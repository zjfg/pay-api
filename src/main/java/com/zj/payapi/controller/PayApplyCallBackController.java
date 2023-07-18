package com.zj.payapi.controller;

import com.alibaba.fastjson.JSON;
import com.zj.payapi.model.result.callback.PayApplyCallBackResult;
import com.zj.payapi.service.PayApplyCallBackService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>功能名：支付申请回调管理</b><br>
 * <b>说明：</b><br>
 * <b>著作权：</b> Copyright (C) 2023 HUIFANEDU  CORPORATION<br>
 * <b>修改履历：</b><br>
 *
 * @author 2023-07-18 zhujie
 */
@Slf4j
@RestController
@RequestMapping("/pay_apply_call_back")
public class PayApplyCallBackController {
    private static final Logger logger = LoggerFactory.getLogger(PayApplyCallBackController.class);
    @Autowired
    PayApplyCallBackService payApplyCallBackService;

    /**
     * <b>方法名: </b> 支付申请通知回调 <br>
     * <b>说明: </b>  <br>
     * @param request HttpServletRequest，微信回调数据参数在request中
     * @param response HttpServletResponse
     * @return com.zj.payapi.model.result.refund.PayApplyCallBackResult
     * <b>修改履历:</b> <br>
     * @author 2023/7/18 zhujie
     */
    @PostMapping("/v1/call_back")
    public PayApplyCallBackResult callBack(HttpServletRequest request, HttpServletResponse response) {
        PayApplyCallBackResult payApplyCallBackResult = new PayApplyCallBackResult();
        try {
            payApplyCallBackResult = payApplyCallBackService.callBack(request, response);
            logger.info("微信官方支付---返回微信服务结果，响应参数：{}" + JSON.toJSONString(payApplyCallBackResult));
            return payApplyCallBackResult;
        } catch (Exception e) {
            logger.error("微信官方支付---回调处理异常：", e);
        }
        payApplyCallBackResult.setCode("501");
        payApplyCallBackResult.setMessage("失败");
        return payApplyCallBackResult;
    }
}