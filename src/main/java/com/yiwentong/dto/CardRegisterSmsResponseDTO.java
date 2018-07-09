package com.yiwentong.dto;

public class CardRegisterSmsResponseDTO {

    private int serviceProviderId;

    private String merchantId;

    private String smsOrderId;

    private String cardNumber;

    @Override
    public String toString() {
        return "CardRegisterSmsResponseDTO{" +
                "serviceProviderId='" + serviceProviderId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", smsOrderId='" + smsOrderId + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }

    public CardRegisterSmsResponseDTO(int serviceProviderId, String merchantId, String smsOrderId, String cardNumber) {
        this.serviceProviderId = serviceProviderId;
        this.merchantId = merchantId;
        this.smsOrderId = smsOrderId;
        this.cardNumber = cardNumber;
    }

    public CardRegisterSmsResponseDTO() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getSmsOrderId() {
        return smsOrderId;
    }

    public void setSmsOrderId(String smsOrderId) {
        this.smsOrderId = smsOrderId;
    }

    public int getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(int serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

}
