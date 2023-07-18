package com.zj.payapi.service;

import com.zj.payapi.model.result.callback.PayApplyCallBackResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>功能名：PayApplyCallBackService</b><br>
 * <b>说明：</b><br>
 * <b>著作权：</b> Copyright (C) 2023 HUIFANEDU  CORPORATION<br>
 * <b>修改履历：</b><br>
 *
 * @author 2023-07-18 zhujie
 */
public interface PayApplyCallBackService {

    /**
     * <b>方法名: </b> 支付申请通知回调 <br>
     * <b>说明: </b>  <br>
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return com.zj.payapi.model.result.refund.PayApplyCallBackResult
     * <b>修改履历:</b> <br>
     * @author 2023/7/18 zhujie
     */
    PayApplyCallBackResult callBack(HttpServletRequest request, HttpServletResponse response);
}