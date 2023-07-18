package com.zj.payapi.controller;

import com.zj.payapi.service.WechatPayService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>功能名：微信支付管理</b><br>
 * <b>说明：</b><br>
 * <b>著作权：</b> Copyright (C) 2023 HUIFANEDU  CORPORATION<br>
 * <b>修改履历：</b><br>
 *
 * @author 2023-07-17 zhujie
 */
@Slf4j
@RestController
@RequestMapping("/wechat_pay")
public class WechatPayController {

    private static final Logger logger = LoggerFactory.getLogger(WechatPayController.class);
    @Autowired
    WechatPayService wechatPayService;
}