package com.yiwentong.dto;

public class WithdrawStatusCheckResponseDTO {

    private String serviceProviderId;
    private String merchantId;
    private String orderId;
    private String cardNumber;
    private String walletType;
    private String createTime;
    private String finishTime;
    private String status;
    private String merchantFeeRate;
    private String merchantFeeCharge;
    private String amount;
    private String actualAmount;
    private String serviceProviderProfit;
    private String errorMessage;

    @Override
    public String toString() {
        return "WithdrawStatusCheckResponseDTO{" +
                "serviceProviderId='" + serviceProviderId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", walletType='" + walletType + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", createTime='" + createTime + '\'' +
                ", finishTime='" + finishTime + '\'' +
                ", status='" + status + '\'' +
                ", merchantFeeRate='" + merchantFeeRate + '\'' +
                ", merchantFeeCharge='" + merchantFeeCharge + '\'' +
                ", amount='" + amount + '\'' +
                ", actualAmount='" + actualAmount + '\'' +
                ", serviceProviderProfit='" + serviceProviderProfit + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

    public String getWalletType() {
        return walletType;
    }

    public void setWalletType(String walletType) {
        this.walletType = walletType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMerchantFeeRate() {
        return merchantFeeRate;
    }

    public void setMerchantFeeRate(String merchantFeeRate) {
        this.merchantFeeRate = merchantFeeRate;
    }

    public String getMerchantFeeCharge() {
        return merchantFeeCharge;
    }

    public void setMerchantFeeCharge(String merchantFeeCharge) {
        this.merchantFeeCharge = merchantFeeCharge;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(String actualAmount) {
        this.actualAmount = actualAmount;
    }

    public String getServiceProviderProfit() {
        return serviceProviderProfit;
    }

    public void setServiceProviderProfit(String serviceProviderProfit) {
        this.serviceProviderProfit = serviceProviderProfit;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
