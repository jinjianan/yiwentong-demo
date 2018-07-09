package com.yiwentong.dto;

public class CardRegisterRequstDTO {

    // 服务商编号
    private String serviceProviderId;

    // token
    private String token;

    //短信订单号
    private String smsOrderId;

    //短信验证码
    private String smsCode;

    //商户ID
    private String merchantId;

    //费率编号
    private String rateId;

    // 持卡人姓名
    private String cardHolder;

    // 卡号
    private String cardNumber;

    // 卡类型   1.借记卡  2.贷记卡
    private String cardType;

    // 商户身份证号
    private String idCardNumber;

    // 结算卡预留手机号
    private String phone;

    //信用卡：安全码
    private String cvn2;

    //信用卡：有效期
    private String expiration;

    //签名
    private String signature;

    public interface CreditCardGroup{};


    public String getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(String serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSmsOrderId() {
        return smsOrderId;
    }

    public void setSmsOrderId(String smsOrderId) {
        this.smsOrderId = smsOrderId;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getRateId() {
        return rateId;
    }

    public void setRateId(String rateId) {
        this.rateId = rateId;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCvn2() {
        return cvn2;
    }

    public void setCvn2(String cvn2) {
        this.cvn2 = cvn2;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
