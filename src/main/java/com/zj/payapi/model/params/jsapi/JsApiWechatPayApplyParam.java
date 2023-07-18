package com.zj.payapi.model.params.jsapi;

import com.wechat.pay.java.service.payments.jsapi.model.*;
import lombok.Data;

/**
 * <b>功能名：公众号支付申请入参对象</b><br>
 * <b>说明：</b><br>
 * <b>著作权：</b> Copyright (C) 2023 HUIFANEDU  CORPORATION<br>
 * <b>修改履历：</b><br>
 *
 * @author 2023-07-17 zhujie
 */
@Data
public class JsApiWechatPayApplyParam {
    /**
     * 商品描述
     * 示例值：Image形象店-深圳腾大-QQ公仔
     */
    private String description;
    /**
     * 商户系统内部订单号，只能是数字、大小写字母_-*且在同一个商户号下唯一
     */
    private String outTradeNo;
    /**
     * 否
     * 订单失效时间，遵循rfc3339标准格式，格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，
     * HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，
     * 北京时间2015年5月20日 13点29分35秒。
     * 示例值：2018-06-08T10:34:56+08:00
     */
    private String timeExpire;
    /**
     * 否
     * 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用，实际情况下只有支付完成状态才会返回该字段。
     * 示例值：自定义数据
     */
    private String attach;
    /**
     * 否
     * 订单优惠标记
     * 示例值：WXG
     */
    private String goodsTag;
    /**
     * 否
     * 传入true时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效。
     * true：是
     * false：否
     * 示例值：true
     */
    private Boolean supportFapiao;
    /**
     * 订单金额信息（分）人民币
     */
    private Amount amount;
    /**
     * 支付者信息
     * 用户在直连商户appid下的唯一标识。 下单前需获取到用户的Openid，Openid获取详见
     * 示例值：oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
     */
    private Payer payer;
    /**
     * 否
     * 优惠功能
     */
    private Detail detail;
    /**
     * 支付场景描述
     */
    private SceneInfo sceneInfo;
    /**
     * 结算信息
     */
    private SettleInfo settleInfo;
}