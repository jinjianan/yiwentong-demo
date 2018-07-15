package com.yiwentong.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.yiwentong.constant.ServiceProviderConfig;
import com.yiwentong.constant.TokenType;
import com.yiwentong.dto.BaseResponse;
import com.yiwentong.dto.CardRegisterResponseDTO;
import com.yiwentong.dto.ConsumeRequestDTO;
import com.yiwentong.dto.WithdrawRequestDTO;
import com.yiwentong.util.DataParseUtil;
import com.yiwentong.util.SignatureUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.UUID;

/**
 * 提现
 */
public class Withdraw {

    public static void main(String[] args) throws IOException{

        //获取token
        String token = TokenCore.getToken(
                ServiceProviderConfig.SERVICE_PROVIDER_SECRET_KEY,
                ServiceProviderConfig.SERVICE_PROVIDER_ID,
                TokenType.WITHDRAW);

        //构建签名参数
        WithdrawRequestDTO requestDTO = new WithdrawRequestDTO();
        requestDTO.setServiceProviderId(ServiceProviderConfig.SERVICE_PROVIDER_ID);
        requestDTO.setToken(token);
        requestDTO.setOrderId(UUID.randomUUID().toString().replace("-",""));
//        requestDTO.setOrderId("e3aca0d0ed4245c0be31d5adb4c0ef2d");
        requestDTO.setMerchantId("");
        requestDTO.setWalletType("");
        requestDTO.setAmount("");
        requestDTO.setCardHolder("");
        requestDTO.setCardNumber("");

        //签名
        String signature = SignatureUtil.signByObj(ServiceProviderConfig.SERVICE_PROVIDER_SECRET_KEY,requestDTO);

        //组装请求参数
        requestDTO.setSignature(signature);

        //发送请求
        String json = DataParseUtil.getJson(requestDTO);
        String url = ServiceProviderConfig.URL+"payment/withdraw";
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
