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

/**
 * 开卡
 */
public class CardRegister {

    public static void main(String[] args) throws IOException{

        //获取token
        String token = TokenCore.getToken(
                ServiceProviderConfig.SERVICE_PROVIDER_SECRET_KEY,
                ServiceProviderConfig.SERVICE_PROVIDER_ID,
                TokenType.CARD_BIND);

        //构建签名参数
        CardRegisterRequstDTO requestDTO = new CardRegisterRequstDTO();
        requestDTO.setServiceProviderId(ServiceProviderConfig.SERVICE_PROVIDER_ID);
        requestDTO.setToken(token);
        requestDTO.setMerchantId("100000011");
        requestDTO.setRateId("100001");
        requestDTO.setCardHolder("靳嘉楠");
        requestDTO.setCardNumber("4367420064581053839");
        requestDTO.setCardType("1");
        requestDTO.setIdCardNumber("140428199607259239");
        requestDTO.setPhone("15620727048");

        //信用卡
        requestDTO.setCvn2("");
        requestDTO.setExpiration("");

        //短信
        requestDTO.setSmsOrderId("196c600fbdb24aa49a00b81c457af61c");
        requestDTO.setSmsCode("289233");

        //签名
        String signature = SignatureUtil.signByObj(ServiceProviderConfig.SERVICE_PROVIDER_SECRET_KEY,requestDTO);

        //组装请求参数
        requestDTO.setSignature(signature);

        //发送请求
        String json = DataParseUtil.getJson(requestDTO);
        String url = ServiceProviderConfig.URL+"card/register";
        System.out.println("请求参数为:"+json);
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(ServiceProviderConfig.MEDIA_TYPE,json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();

        String tokenJsonRsp = response.body().string();
        System.out.println("响应JSON为: " + tokenJsonRsp);
        BaseResponse<CardRegisterResponseDTO> baseResponse = null;
        CardRegisterResponseDTO cardRegisterResponseDTO = null;
        if (response.isSuccessful()) {
            baseResponse = DataParseUtil.getObj(tokenJsonRsp,new TypeReference<BaseResponse<CardRegisterResponseDTO>>(){});
            cardRegisterResponseDTO = baseResponse.getData();
        }
        else {
            System.out.println("响应码:"+response.code());
            throw new IOException("Unexpected code " + response.message());
        }

    }

}