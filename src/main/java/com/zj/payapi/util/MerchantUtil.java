package com.zj.payapi.util;


import com.wechat.pay.java.core.RSAAutoCertificateConfig;

/**
 * 商户配置初始化工具类
 * 懒加载单利处理
 */
public class MerchantUtil {
    private static MerchantUtil merchantUtil =null;
    private static RSAAutoCertificateConfig config =null;

    public MerchantUtil() {
    }

    public static synchronized MerchantUtil getInstance(){
        if(merchantUtil ==null){
            synchronized (MerchantUtil.class){
                if(merchantUtil == null){
                    merchantUtil = new MerchantUtil();
                }
            }
        }
        return merchantUtil;
    }

    /**
     * 微信公众号支付商户数据处理方法
     * @param merchantId
     * @param privateKeyPath
     * @param merchantSerialNumber
     * @param apiV3key
     * @return config Config
     */
    public static RSAAutoCertificateConfig handleMer(String merchantId, String privateKeyPath, String merchantSerialNumber, String apiV3key){
        if(config ==null){
            config = new RSAAutoCertificateConfig.Builder()
                    .merchantId(merchantId)
                    .privateKeyFromPath(privateKeyPath)
                    .merchantSerialNumber(merchantSerialNumber)
                    .apiV3Key(apiV3key)
                    .build();
        }
        return config;
    }
}
