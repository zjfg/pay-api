package com.zj.payapi.model.params.refund;

import com.wechat.pay.java.service.refund.model.AmountReq;
import com.wechat.pay.java.service.refund.model.GoodsDetail;
import lombok.Data;

import java.util.List;

/**
 * 微信退款入参实体对象
 */
@Data
public class RefundCreateRequest {
    /**
     * 微信支付订单号 说明：原支付交易对应的微信订单号
     */
    private String transactionId;
    /**
     * 商户订单号 说明：原支付交易对应的商户订单号
     */
    private String outTradeNo;
    /**
     * 商户退款单号 说明：商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，
     * 同一退款单号多次请求只退一笔。
     */
    private String outRefundNo;
    /**
     * 退款原因 说明：若商户传入，会在下发给用户的退款消息中体现退款原因
     */
    private String reason;
    /**
     * 非必要
     * 退款商品 说明：指定商品退款需要传此参数，其他场景无需传递
     */
    private List<GoodsDetail> goodsDetail;
    /**
     * 金额信息 说明：订单金额信息
     */
    private AmountReq amount;

}
