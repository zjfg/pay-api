package com.zj.payapi.service;

import com.zj.payapi.model.params.jsapi.JsApiWechatPayApplyParam;
import com.zj.payapi.model.result.jsapi.JsApiWechatPayApplyResult;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <b>功能名：JsApiWechatPayService</b><br>
 * <b>说明：</b><br>
 * <b>著作权：</b> Copyright (C) 2023 HUIFANEDU  CORPORATION<br>
 * <b>修改履历：</b><br>
 *
 * @author 2023-07-17 zhujie
 */
public interface JsApiWechatPayService {

    /**
    * <b>方法名: </b> 公众号支付申请 <br>
    * <b>说明: </b>  <br>
    * @param jsApiWechatPayApplyParam JsApiWechatPayApplyParam
    * @return com.zj.payapi.model.result.jsapi.JsApiWechatPayApplyResult
    * <b>修改履历:</b> <br>
    * @author 2023/7/17 zhujie
    */
    JsApiWechatPayApplyResult payApply(JsApiWechatPayApplyParam jsApiWechatPayApplyParam);
}