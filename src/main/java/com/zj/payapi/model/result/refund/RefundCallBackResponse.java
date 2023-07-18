package com.zj.payapi.model.result.refund;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * 退款回调返回对象
 */
@Data
public class RefundCallBackResponse {

    /**
     * 直连商户的商户号，由微信支付生成并下发。
     */
    @SerializedName("mchid")
    private String mchid;

    /**
     * 返回的商户订单号
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /**
     * 微信支付订单号
     */
    @SerializedName("transaction_id")
    private String transactionId;

    /**
     * 商户退款单号
     */
    @SerializedName("out_refund_no")
    private String outRefundNo;

    /**
     * 微信退款单号
     */
    @SerializedName("refund_id")
    private String refundId;

    /**
     * 退款状态，枚举值：
     * SUCCESS：退款成功
     * CLOSED：退款关闭
     * ABNORMAL：退款异常，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，可前往【商户平台—>交易中心】，手动处理此笔退款
     */
    @SerializedName("refund_status")
    private RefundStatusEnum refundStatus;

    public enum RefundStatusEnum {
        @SerializedName("SUCCESS")
        SUCCESS,
        @SerializedName("CLOSED")
        CLOSED,
        @SerializedName("ABNORMAL")
        ABNORMAL
    }

    /**
     * 1、退款成功时间，遵循rfc3339标准格式，格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，
     * 表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。
     * 例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日13点29分35秒。
     * 2、当退款状态为退款成功时返回此参数。
     */
    @SerializedName("success_time")
    private String successTime;

    /**
     * 取当前退款单的退款入账方。
     * 1、退回银行卡：{银行名称}{卡类型}{卡尾号}
     * 2、退回支付用户零钱: 支付用户零钱
     * 3、退还商户: 商户基本账户、商户结算银行账户
     * 4、退回支付用户零钱通：支付用户零钱通
     */
    @SerializedName("user_received_account")
    private String userReceivedAccount;

    /**
     * 金额信息集合
     */
    @SerializedName("amount")
    private RefundCallBackAmountResponse amount;

}
