package com.yiwentong.dto;

public class CardRegisterResponseDTO {

    // 服务商编号
    private String serviceProviderId;

    //商户ID
    private String merchantId;

    //卡号
    private String cardNumber;

    public CardRegisterResponseDTO() {
    }

    public CardRegisterResponseDTO(String serviceProviderId, String merchantId, String cardNumber) {
        this.serviceProviderId = serviceProviderId;
        this.merchantId = merchantId;
        this.cardNumber = cardNumber;
    }

    public String getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(String serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

}
