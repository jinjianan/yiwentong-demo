package com.yiwentong.constant;

import okhttp3.MediaType;

/**
 * 服务商配置
 */
public  class ServiceProviderConfig {

    //请求地址
    public static final String URL = "http://localhost:30002/v1/";

    // MEDIA TYPE
    public static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

    //服务商编号
    public static final String SERVICE_PROVIDER_ID = "100000000";

    //服务商秘钥
    public static final String SERVICE_PROVIDER_SECRET_KEY = "e1f0d9e0ce8f44fabf4c6d72d476fa8d";

}
