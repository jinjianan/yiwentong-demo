package com.yiwentong.dto;

public class MerchantRateRequestDTO {

    // token
    private String token;

    // 服务商编号
    private String serviceProviderId;

    // 商户编号
    private String merchantId;

    /**
     * 操作类型
     * 1.修改提现费率
     * 2.修改交易费率
     * 3.新增交易费率
     * 4.变更结算卡
     */
    private String operationType;

    //费率编号
    private String rateId;

    //借记卡费率
    private String debitCardRate;

    //借记卡固定额度手续费
    private String debitCardMaxAmount;

    //信用卡费率
    private String creditCardRate;

    //信用卡固定额度手续费
    private String creditCardMaxAmount;


    // 提现费率
    private String withdrawDepositRate;

    // 提现手续费
    private String withdrawDepositCharge;

    //签名
    private String signature;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getRateId() {
        return rateId;
    }

    public void setRateId(String rateId) {
        this.rateId = rateId;
    }

    public String getDebitCardRate() {
        return debitCardRate;
    }

    public void setDebitCardRate(String debitCardRate) {
        this.debitCardRate = debitCardRate;
    }

    public String getDebitCardMaxAmount() {
        return debitCardMaxAmount;
    }

    public void setDebitCardMaxAmount(String debitCardMaxAmount) {
        this.debitCardMaxAmount = debitCardMaxAmount;
    }

    public String getCreditCardRate() {
        return creditCardRate;
    }

    public void setCreditCardRate(String creditCardRate) {
        this.creditCardRate = creditCardRate;
    }

    public String getCreditCardMaxAmount() {
        return creditCardMaxAmount;
    }

    public void setCreditCardMaxAmount(String creditCardMaxAmount) {
        this.creditCardMaxAmount = creditCardMaxAmount;
    }

    public String getWithdrawDepositRate() {
        return withdrawDepositRate;
    }

    public void setWithdrawDepositRate(String withdrawDepositRate) {
        this.withdrawDepositRate = withdrawDepositRate;
    }

    public String getWithdrawDepositCharge() {
        return withdrawDepositCharge;
    }

    public void setWithdrawDepositCharge(String withdrawDepositCharge) {
        this.withdrawDepositCharge = withdrawDepositCharge;
    }
}
