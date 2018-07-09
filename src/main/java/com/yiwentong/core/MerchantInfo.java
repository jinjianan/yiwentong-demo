package com.yiwentong.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.yiwentong.constant.ServiceProviderConfig;
import com.yiwentong.constant.TokenType;
import com.yiwentong.dto.*;
import com.yiwentong.util.DataParseUtil;
import com.yiwentong.util.SignatureUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商户信息变更
 */
public class MerchantInfo {

    public static void main(String[] args) throws IOException{

        //获取token
        String token = TokenCore.getToken(
                ServiceProviderConfig.SERVICE_PROVIDER_SECRET_KEY,
                ServiceProviderConfig.SERVICE_PROVIDER_ID,
                TokenType.MERCHANT_RATE);

        //构建签名参数
        MerchantRateRequestDTO requestDTO = new MerchantRateRequestDTO();

        //必填数据
        requestDTO.setServiceProviderId(ServiceProviderConfig.SERVICE_PROVIDER_ID);
        requestDTO.setToken(token);
        requestDTO.setMerchantId("100000011");

        /**
         * 操作类型
         * 1.修改提现费率
         * 2.修改交易费率
         * 3.新增交易费率(暂未开通)
         * 4.变更结算卡（暂未开通）
         */
        requestDTO.setOperationType("2");

        //当类型为 1 时必填
        requestDTO.setWithdrawDepositRate("0");
        requestDTO.setWithdrawDepositCharge("200");


        //当类型为2 时必填
        requestDTO.setRateId("100001");
        requestDTO.setCreditCardRate("0.05");
        requestDTO.setDebitCardRate("0.05");

        //签名
        String signature = SignatureUtil.signByObj(ServiceProviderConfig.SERVICE_PROVIDER_SECRET_KEY,requestDTO);

        //组装请求参数
        requestDTO.setSignature(signature);

        //发送请求
        String json = DataParseUtil.getJson(requestDTO);
        String url = ServiceProviderConfig.URL+"merchant/rate";
        System.out.println("请求参数为:"+json);
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(ServiceProviderConfig.MEDIA_TYPE,json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();

        String tokenJsonRsp = response.body().string();
        System.out.println("响应JSON为: " + tokenJsonRsp);
        BaseResponse<MerchantRegisterResponseDTO> baseResponse = null;
        MerchantRegisterResponseDTO tokenResponseDTO = null;
        if (response.isSuccessful()) {
            baseResponse = DataParseUtil.getObj(tokenJsonRsp,new TypeReference<BaseResponse<MerchantRegisterResponseDTO>>(){});
            tokenResponseDTO = baseResponse.getData();
        }
        else {
            System.out.println("响应码:"+response.code());
            throw new IOException("Unexpected code " + response.message());
        }

    }

}
