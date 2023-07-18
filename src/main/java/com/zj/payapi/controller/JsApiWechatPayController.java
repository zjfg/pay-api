package com.zj.payapi.controller;

import com.alibaba.fastjson.JSON;
import com.zj.payapi.model.params.jsapi.JsApiWechatPayApplyParam;
import com.zj.payapi.model.result.jsapi.JsApiWechatPayApplyResult;
import com.zj.payapi.service.JsApiWechatPayService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>功能名：公众号微信支付管理</b><br>
 * <b>说明：</b><br>
 * <b>著作权：</b> Copyright (C) 2023 HUIFANEDU  CORPORATION<br>
 * <b>修改履历：</b><br>
 *
 * @author 2023-07-17 zhujie
 */
@Slf4j
@RestController
@RequestMapping("/js_api_wechat_pay")
public class JsApiWechatPayController {
    private static final Logger logger = LoggerFactory.getLogger(WechatPayController.class);
    @Autowired
    JsApiWechatPayService jsApiWechatPayService;

    /**
    * <b>方法名: </b> 公众号支付申请 <br>
    * <b>说明: </b>  <br>
    * @param jsApiWechatPayApplyParam JsApiWechatPayApplyParam
    * @return com.zj.payapi.model.result.jsapi.JsApiWechatPayApplyResult
    * <b>修改履历:</b> <br>
    * @author 2023/7/17 zhujie
    */
    @PostMapping("/v1/pay_apply")
    public JsApiWechatPayApplyResult payApply(@RequestBody JsApiWechatPayApplyParam jsApiWechatPayApplyParam){
        JsApiWechatPayApplyResult jsApiWechatPayApplyResult = new JsApiWechatPayApplyResult();
        try {
            jsApiWechatPayApplyResult = jsApiWechatPayService.payApply(jsApiWechatPayApplyParam);
            logger.info("微信官方支付---支付请求完成，响应参数：{}"+ JSON.toJSONString(jsApiWechatPayApplyResult));
            return jsApiWechatPayApplyResult;
        } catch (Exception e) {
            logger.error("微信官方支付---支付请求异常：", e);
        }
        return jsApiWechatPayApplyResult;
    }
}