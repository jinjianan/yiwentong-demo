package com.yiwentong.dto;


public class MerchantRegisterRateInfoRequestDTO {

    //费率编号
    private String rateId;

    //借记卡费率
    private String debitCardRate;

    //信用卡费率
    private String creditCardRate;

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

    public String getCreditCardRate() {
        return creditCardRate;
    }

    public void setCreditCardRate(String creditCardRate) {
        this.creditCardRate = creditCardRate;
    }


    @Override
    public String toString() {
        return "MerchantRegisterRateInfoRequestDTO{" +
                "rateId='" + rateId + '\'' +
                ", debitCardRate='" + debitCardRate + '\'' +
                ", creditCardRate='" + creditCardRate + '\'' +
                '}';
    }
}
