package com.zj.payapi.service.impl;

import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.RSAAutoCertificateConfig;
import com.wechat.pay.java.service.payments.app.AppServiceExtension;
import com.wechat.pay.java.service.payments.jsapi.JsapiService;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayRequest;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayResponse;
import com.zj.payapi.model.params.jsapi.JsApiWechatPayApplyParam;
import com.zj.payapi.model.result.jsapi.JsApiWechatPayApplyResult;
import com.zj.payapi.service.JsApiWechatPayService;
import com.zj.payapi.util.MerchantUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <b>功能名：JsApiWechatPayServiceImpl</b><br>
 * <b>说明：</b><br>
 * <b>著作权：</b> Copyright (C) 2023 HUIFANEDU  CORPORATION<br>
 * <b>修改履历：</b><br>
 *
 * @author 2023-07-17 zhujie
 */
@Service
public class JsApiWechatPayServiceImpl implements JsApiWechatPayService {
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
    /** 支付申请回调地址 */
    @Value("${pay.payNotifyUrl}")
    private String payNotifyUrl;
    @Override
    public JsApiWechatPayApplyResult payApply(JsApiWechatPayApplyParam jsApiWechatPayApplyParam) {
        PrepayRequest prepayRequest = new PrepayRequest();
        BeanUtils.copyProperties(jsApiWechatPayApplyParam,prepayRequest);
        prepayRequest.setAppid(appid);
        prepayRequest.setMchid(mchid);
        prepayRequest.setNotifyUrl(payNotifyUrl);
        System.out.println(mchid);
        System.out.println(privateFilePath);
        System.out.println(privateFileSn);
        System.out.println(apiPrivate);
        // 初始化商户配置
        Config config = MerchantUtil.getInstance().handleMer(mchid,privateFilePath,privateFileSn,apiPrivate);
        // 初始化商户
        JsapiService service = new JsapiService.Builder().config(config).build();
        // 调用微信公众号支付申请方法
        PrepayResponse prepayResponse =service.prepay(prepayRequest);
        // 处理返回对象
        JsApiWechatPayApplyResult jsApiWechatPayApplyResult = new JsApiWechatPayApplyResult();
        BeanUtils.copyProperties(prepayResponse,jsApiWechatPayApplyResult);
        return jsApiWechatPayApplyResult;
    }
}