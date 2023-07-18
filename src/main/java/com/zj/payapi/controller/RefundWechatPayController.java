package com.zj.payapi.controller;

import com.alibaba.fastjson.JSON;
import com.zj.payapi.model.params.refund.RefundCreateRequest;
import com.zj.payapi.model.result.callback.PayApplyCallBackResult;
import com.zj.payapi.model.result.refund.RefundCallBackResult;
import com.zj.payapi.service.RefundWechatPayService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@Slf4j
@RestController
@RequestMapping("/refund_wechat_pay")
public class RefundWechatPayController {
    private static final Logger logger = LoggerFactory.getLogger(RefundWechatPayController.class);
    @Autowired
    RefundWechatPayService refundWechatPayService;

    /**
    * <b>方法名: </b> 微信退款申请 <br>
    * <b>说明: </b>  <br>
    * @param refundCreateRequest RefundCreateRequest
    * @return java.lang.Boolean
    * <b>修改履历:</b> <br>
    * @author 2023/7/18 zhujie
    */
    @PostMapping("/v1/refund_create")
    public Boolean refundCreate(@RequestBody RefundCreateRequest refundCreateRequest) {
        try {
            return refundWechatPayService.refundCreate(refundCreateRequest);
        } catch (Exception e) {
            logger.error("微信官方支付---退款申请异常：", e);
        }
        return false;
    }

    /**
    * <b>方法名: </b> 退款申请回调 <br>
    * <b>说明: </b>  <br>
    * @param request HttpServletRequest
    * @param response HttpServletResponse
    * @return com.zj.payapi.model.result.callback.PayApplyCallBackResult
    * <b>修改履历:</b> <br>
    * @author 2023/7/18 zhujie
    */
    @PostMapping("/v1/call_back")
    public RefundCallBackResult callBack(HttpServletRequest request, HttpServletResponse response) {
        RefundCallBackResult refundCallBackResult = new RefundCallBackResult();
        try {
            refundCallBackResult = refundWechatPayService.callBack(request, response);
            logger.info("微信官方支付---退款申请回调返回微信服务结果，响应参数：{}" + JSON.toJSONString(refundCallBackResult));
            return refundCallBackResult;
        } catch (Exception e) {
            logger.error("微信官方支付---退款申请回调处理异常：", e);
        }
        refundCallBackResult.setCode("501");
        refundCallBackResult.setMessage("失败");
        return refundCallBackResult;
    }
}