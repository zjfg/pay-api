package com.zj.payapi.model.result.callback;

import lombok.Data;

/**
 * <b>功能名：支付申请回调</b><br>
 * <b>说明：</b>公众号、App、小程序等统一使用<br>
 * <b>著作权：</b> Copyright (C) 2023 HUIFANEDU  CORPORATION<br>
 * <b>修改履历：</b><br>
 *
 * @author 2023-07-18 zhujie
 */
@Data
public class PayApplyCallBackResult {
    /**
     * 错误码，SUCCESS为清算机构接收成功，其他错误码为失败。
     * 示例值：FAIL
     * HTTP应答状态码需返回200或204，无需返回应答报文。
     */
    private String code;
    /**
     * 返回信息，如非空，为错误原因。
     * 示例值：失败
     */
    private String message;
}