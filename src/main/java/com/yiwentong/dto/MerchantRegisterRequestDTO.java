package com.yiwentong.dto;
import java.util.List;

public class MerchantRegisterRequestDTO {

    // token
    private String token;

    // 服务商编号
    private String serviceProviderId;

    // 商户名称
    private String merchantName;

    // 商户所有人姓名
    private String merchantRealName;

    // 商户身份证号
    private String idCardNumber;

    // 结算卡卡号
    private String cardNumber;

    // 结算卡预留手机号
    private String phone;

    // 结算卡账户类型   1.对公  2.对私
    private String bankAccountType;

    // 提现费率
    private String withdrawDepositRate;

    // 提现手续费
    private String withdrawDepositCharge;

    // 是否自动结算   0 不自动结算  1 自动结算
    private String isAutoSettlement;

    //签名
    private String signature;

    // 交易费率
    List<MerchantRegisterRateInfoRequestDTO> merchantRates;


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

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantRealName() {
        return merchantRealName;
    }

    public void setMerchantRealName(String merchantRealName) {
        this.merchantRealName = merchantRealName;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(String bankAccountType) {
        this.bankAccountType = bankAccountType;
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

    public String getIsAutoSettlement() {
        return isAutoSettlement;
    }

    public void setIsAutoSettlement(String isAutoSettlement) {
        this.isAutoSettlement = isAutoSettlement;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public List<MerchantRegisterRateInfoRequestDTO> getMerchantRates() {
        return merchantRates;
    }

    public void setMerchantRates(List<MerchantRegisterRateInfoRequestDTO> merchantRates) {
        this.merchantRates = merchantRates;
    }
}
