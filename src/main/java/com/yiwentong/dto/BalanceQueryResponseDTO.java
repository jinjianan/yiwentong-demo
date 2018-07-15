package com.yiwentong.dto;

public class BalanceQueryResponseDTO {

    private String serviceProviderId;

    private String merchantId;

    private String walletBalance;

    private String walletD0Balance;

    private String walletT1Balance;

    @Override
    public String toString() {
        return "BalanceQueryResponseDTO{" +
                "serviceProviderId='" + serviceProviderId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", walletBalance='" + walletBalance + '\'' +
                ", walletD0Balance='" + walletD0Balance + '\'' +
                ", walletT1Balance='" + walletT1Balance + '\'' +
                '}';
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

    public String getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(String walletBalance) {
        this.walletBalance = walletBalance;
    }

    public String getWalletD0Balance() {
        return walletD0Balance;
    }

    public void setWalletD0Balance(String walletD0Balance) {
        this.walletD0Balance = walletD0Balance;
    }

    public String getWalletT1Balance() {
        return walletT1Balance;
    }

    public void setWalletT1Balance(String walletT1Balance) {
        this.walletT1Balance = walletT1Balance;
    }
}
