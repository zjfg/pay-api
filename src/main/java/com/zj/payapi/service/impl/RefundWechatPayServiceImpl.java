package com.zj.payapi.service.impl;

import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.notification.NotificationConfig;
import com.wechat.pay.java.core.notification.NotificationParser;
import com.wechat.pay.java.core.notification.RequestParam;
import com.wechat.pay.java.service.partnerpayments.app.model.Transaction;
import com.wechat.pay.java.service.refund.RefundService;
import com.wechat.pay.java.service.refund.model.CreateRequest;
import com.wechat.pay.java.service.refund.model.Refund;
import com.zj.payapi.model.params.refund.RefundCreateRequest;
import com.zj.payapi.model.result.refund.RefundCallBackResponse;
import com.zj.payapi.model.result.refund.RefundCallBackResult;
import com.zj.payapi.service.RefundWechatPayService;
import com.zj.payapi.util.HttpUtils;
import com.zj.payapi.util.MerchantUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>功能名：退款管理</b><br>
 * <b>说明：</b><br>
 * <b>著作权：</b> Copyright (C) 2023 HUIFANEDU  CORPORATION<br>
 * <b>修改履历：</b><br>
 *
 * @author 2023-07-18 zhujie
 */
@Service
public class RefundWechatPayServiceImpl implements RefundWechatPayService {
    /** 公众号ID 说明：公众号ID */
    @Value("${pay.appid}")
    private String appid;
    /** 直连商户号 说明：直连商户号 */
    @Value("${pay.mchid}")
    private String mchid;
    /** 商户API私钥路径 */
    @Value("${pay.privateFilePath}")
    private String privateFilePath;
    /** 商户证书序列号 */
    @Value("${pay.privateFileSn}")
    private String privateFileSn;
    /** 商户APIv3密钥 */
    @Value("${pay.apiPrivate}")
    private String apiPrivate;
    /** 退款申请回调地址 */
    @Value("${pay.refundNotifyUrl}")
    private String refundNotifyUrl;
    @Override
    public Boolean refundCreate(RefundCreateRequest refundCreateRequest) {

        // 初始化商户配置
        Config config = MerchantUtil.getInstance().handleMer(mchid,privateFilePath,privateFileSn,apiPrivate);
        // 初始化商户
        RefundService service = new RefundService.Builder().config(config).build();
        CreateRequest createRequest = new CreateRequest();
        createRequest.setTransactionId(refundCreateRequest.getTransactionId());
        createRequest.setOutTradeNo(refundCreateRequest.getOutTradeNo());
        createRequest.setOutRefundNo(refundCreateRequest.getOutRefundNo());
        createRequest.setReason(refundCreateRequest.getReason());
        createRequest.setNotifyUrl(refundNotifyUrl);
        if(null !=refundCreateRequest.getGoodsDetail()){
            createRequest.setGoodsDetail(refundCreateRequest.getGoodsDetail());
        }
        createRequest.setAmount(refundCreateRequest.getAmount());
        // 调用退款处理方法,Refund为返回结果
        Refund refund  = service.create(createRequest);
        //todo 处理相关业务
        return true;
    }

    @Override
    public RefundCallBackResult callBack(HttpServletRequest request, HttpServletResponse response) {
        RefundCallBackResult refundCallBackResult = new RefundCallBackResult();
        //从请求头获取验签字段
        String Timestamp = request.getHeader("Wechatpay-Timestamp");
        String Nonce = request.getHeader("Wechatpay-Nonce");
        String Signature = request.getHeader("Wechatpay-Signature");
        String Serial = request.getHeader("Wechatpay-Serial");
        String body = HttpUtils.readData(request);
        // 处理解析内容结合
        RequestParam requestParam = new RequestParam.Builder()
                .serialNumber(Serial)
                .nonce(Nonce)
                .signature(Signature)
                .timestamp(Timestamp)
                .body(body)
                .build();

        // 初始化商户
        NotificationConfig config = MerchantUtil.getInstance().handleMer(mchid,privateFilePath,privateFileSn,apiPrivate);
        // 构建解析器
        NotificationParser parser = new NotificationParser(config);
        // 解析微信支付回调通知，RefundCallBackResponse解析结果集合
        RefundCallBackResponse refundCallBackResponse = parser.parse(requestParam, RefundCallBackResponse.class);
        // 拿到回调结果，可以处理相关业务
        refundCallBackResult.setCode("200");
        return refundCallBackResult;
    }
}