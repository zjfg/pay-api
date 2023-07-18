package com.zj.payapi.service;

import com.zj.payapi.model.params.refund.RefundCreateRequest;
import com.zj.payapi.model.result.refund.RefundCallBackResult;
import org.springframework.web.bind.annotation.RequestBody;

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
public interface RefundWechatPayService {

    /**
    * <b>方法名: </b> 微信退款申请 <br>
    * <b>说明: </b>  <br>
    * @param refundCreateRequest RefundCreateRequest
    * @return java.lang.Boolean
    * <b>修改履历:</b> <br>
    * @author 2023/7/18 zhujie
    */
    Boolean refundCreate(@RequestBody RefundCreateRequest refundCreateRequest);

    /**
    * <b>方法名: </b> 退款申请回调 <br>
    * <b>说明: </b>  <br>
    * @param request HttpServletRequest
    * @param response HttpServletResponse
    * @return com.zj.payapi.model.result.refund.RefundCallBackResult
    * <b>修改履历:</b> <br>
    * @author 2023/7/18 zhujie
    */
    RefundCallBackResult callBack(HttpServletRequest request, HttpServletResponse response);
}