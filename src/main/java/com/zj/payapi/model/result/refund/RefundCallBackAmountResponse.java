package com.zj.payapi.model.result.refund;

/**
 * 退款回调金额信息对象
 */
public class RefundCallBackAmountResponse {

    /**
     * 订单总金额，单位为分，只能为整数，详见支付金额
     */
    private Integer total;

    /**
     * 退款金额，币种的最小单位，只能为整数，不能超过原订单支付金额，如果有使用券，后台会按比例退。
     */
    private Integer refund;

    /**
     * 用户实际支付金额，单位为分，只能为整数，详见支付金额
     */
    private Integer payerTotal;

    /**
     * 退款给用户的金额，不包含所有优惠券金额
     */
    private Integer payerRefund;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getRefund() {
        return refund;
    }

    public void setRefund(Integer refund) {
        this.refund = refund;
    }

    public Integer getPayerTotal() {
        return payerTotal;
    }

    public void setPayerTotal(Integer payerTotal) {
        this.payerTotal = payerTotal;
    }

    public Integer getPayerRefund() {
        return payerRefund;
    }

    public void setPayerRefund(Integer payerRefund) {
        this.payerRefund = payerRefund;
    }

    @Override
    public String toString() {
        return "RefundCallBackAmountResponse{" +
                "total=" + total +
                ", refund=" + refund +
                ", payerTotal=" + payerTotal +
                ", payerRefund=" + payerRefund +
                '}';
    }
}
