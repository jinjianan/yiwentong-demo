package com.yiwentong.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.yiwentong.constant.ServiceProviderConfig;
import com.yiwentong.constant.TokenType;
import com.yiwentong.dto.BaseResponse;
import com.yiwentong.dto.MerchantRegisterRateInfoRequestDTO;
import com.yiwentong.dto.MerchantRegisterRequestDTO;
import com.yiwentong.dto.MerchantRegisterResponseDTO;
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
 * 商户注册
 */
public class MerchantRegister {

    public static void main(String[] args) throws IOException{

        //获取token
        String token = TokenCore.getToken(
                ServiceProviderConfig.SERVICE_PROVIDER_SECRET_KEY,
                ServiceProviderConfig.SERVICE_PROVIDER_ID,
                TokenType.MERCHANT_REGISTER);

        //构建签名参数
        MerchantRegisterRequestDTO requestDTO = new MerchantRegisterRequestDTO();
        requestDTO.setServiceProviderId(ServiceProviderConfig.SERVICE_PROVIDER_ID);
        requestDTO.setToken(token);
        requestDTO.setMerchantName("");
        requestDTO.setMerchantRealName("");
        requestDTO.setIdCardNumber("");
        requestDTO.setCardNumber("");
        requestDTO.setPhone("");
        requestDTO.setWithdrawDepositRate("0");
        requestDTO.setWithdrawDepositCharge("200");
        requestDTO.setIsAutoSettlement("0");
        List<MerchantRegisterRateInfoRequestDTO> rateInfoRequestDTOList = new ArrayList<>();
        requestDTO.setMerchantRates(rateInfoRequestDTOList);

        MerchantRegisterRateInfoRequestDTO rateInfo1 = new MerchantRegisterRateInfoRequestDTO();
        rateInfo1.setRateId("100001");
        rateInfo1.setCreditCardRate("0.002");
        rateInfo1.setDebitCardRate("0.002");
        rateInfoRequestDTOList.add(rateInfo1);


        //签名
        String signature = SignatureUtil.signByObj(ServiceProviderConfig.SERVICE_PROVIDER_SECRET_KEY,requestDTO);

        //组装请求参数
        requestDTO.setSignature(signature);

        //发送请求
        String json = DataParseUtil.getJson(requestDTO);
        String url = ServiceProviderConfig.URL+"merchant/register";
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
