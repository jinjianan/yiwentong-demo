package com.yiwentong.core;

import com.yiwentong.constant.ServiceProviderConfig;
import com.yiwentong.constant.TokenType;
import com.yiwentong.dto.BaseResponse;
import com.yiwentong.dto.TokenRequestDTO;
import com.yiwentong.dto.TokenResponseDTO;
import com.yiwentong.util.DataParseUtil;
import com.yiwentong.util.SignatureUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import okhttp3.*;

import java.io.IOException;

public class TokenCore {

    public static void main(String[] args) {
        try {
            System.out.println(
                    TokenCore.getToken(
                            ServiceProviderConfig.SERVICE_PROVIDER_SECRET_KEY,
                            ServiceProviderConfig.SERVICE_PROVIDER_ID,
                            TokenType.MERCHANT_REGISTER)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getToken(String key, String serviceProviderId,String tokenType) throws IOException {


        //构建签名参数
        TokenRequestDTO requestDTO = new TokenRequestDTO();
        requestDTO.setServiceProviderId(serviceProviderId);
        requestDTO.setTokenType(tokenType);

        //签名
        String signature = SignatureUtil.signByObj(key,requestDTO);

        //组装请求参数
        requestDTO.setSignature(signature);

        //发送请求
        String json = DataParseUtil.getJson(requestDTO);
        String url = ServiceProviderConfig.URL+"token";
        System.out.println("请求参数为:"+json);
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(ServiceProviderConfig.MEDIA_TYPE,json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();

        String tokenJsonRsp = response.body().string();
        System.out.println("响应JSON为: " + tokenJsonRsp);
        BaseResponse<TokenResponseDTO> baseResponse = null;
        TokenResponseDTO tokenResponseDTO = null;
        if (response.isSuccessful()) {
            baseResponse = DataParseUtil.getObj(tokenJsonRsp,new TypeReference<BaseResponse<TokenResponseDTO>>(){});
            tokenResponseDTO = baseResponse.getData();
        }
        else {
            System.out.println("响应码:"+response.code());
            throw new IOException("Unexpected code " + response.message());
        }


        return tokenResponseDTO.getToken();
    }

}
