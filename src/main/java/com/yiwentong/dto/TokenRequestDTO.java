package com.yiwentong.dto;

public class TokenRequestDTO {

    //服务商编号
    private String serviceProviderId;

    //token类型
    private String tokenType;

    //签名
    private String signature;

    public String getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(String serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "TokenRequestDTO{" +
                "serviceProviderId='" + serviceProviderId + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
