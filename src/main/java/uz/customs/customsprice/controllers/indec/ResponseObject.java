package uz.customs.customsprice.controllers.indec;

import java.math.BigDecimal;

public class ResponseObject {
    private String paymentType;
    private BigDecimal g47Base;
    private BigDecimal g47AltBase;
    private BigDecimal g47Rate;
    private BigDecimal g47AltRate;
    private String g47AltBaseCurrKod;
    private BigDecimal currRate;
    private String g47AltBaseEdIzm;
    private BigDecimal g47Sum;
    private String g47Sp;
    private String g47Type;
    private int g47ClcType;

    public ResponseObject() {
    }

    public ResponseObject(String paymentType, BigDecimal g47Base, BigDecimal g47AltBase, BigDecimal g47Rate, BigDecimal g47AltRate, String g47AltBaseCurrKod, BigDecimal currRate, String g47AltBaseEdIzm, BigDecimal g47Sum, String g47Sp, String g47Type, int g47ClcType) {
        this.paymentType = paymentType;
        this.g47Base = g47Base;
        this.g47AltBase = g47AltBase;
        this.g47Rate = g47Rate;
        this.g47AltRate = g47AltRate;
        this.g47AltBaseCurrKod = g47AltBaseCurrKod;
        this.currRate = currRate;
        this.g47AltBaseEdIzm = g47AltBaseEdIzm;
        this.g47Sum = g47Sum;
        this.g47Sp = g47Sp;
        this.g47Type = g47Type;
        this.g47ClcType = g47ClcType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getG47Base() {
        return g47Base;
    }

    public void setG47Base(BigDecimal g47Base) {
        this.g47Base = g47Base;
    }

    public BigDecimal getG47AltBase() {
        return g47AltBase;
    }

    public void setG47AltBase(BigDecimal g47AltBase) {
        this.g47AltBase = g47AltBase;
    }

    public BigDecimal getG47Rate() {
        return g47Rate;
    }

    public void setG47Rate(BigDecimal g47Rate) {
        this.g47Rate = g47Rate;
    }

    public BigDecimal getG47AltRate() {
        return g47AltRate;
    }

    public void setG47AltRate(BigDecimal g47AltRate) {
        this.g47AltRate = g47AltRate;
    }

    public String getG47AltBaseCurrKod() {
        return g47AltBaseCurrKod;
    }

    public void setG47AltBaseCurrKod(String g47AltBaseCurrKod) {
        this.g47AltBaseCurrKod = g47AltBaseCurrKod;
    }

    public BigDecimal getCurrRate() {
        return currRate;
    }

    public void setCurrRate(BigDecimal currRate) {
        this.currRate = currRate;
    }

    public String getG47AltBaseEdIzm() {
        return g47AltBaseEdIzm;
    }

    public void setG47AltBaseEdIzm(String g47AltBaseEdIzm) {
        this.g47AltBaseEdIzm = g47AltBaseEdIzm;
    }

    public BigDecimal getG47Sum() {
        return g47Sum;
    }

    public void setG47Sum(BigDecimal g47Sum) {
        this.g47Sum = g47Sum;
    }

    public String getG47Sp() {
        return g47Sp;
    }

    public void setG47Sp(String g47Sp) {
        this.g47Sp = g47Sp;
    }

    public String getG47Type() {
        return g47Type;
    }

    public void setG47Type(String g47Type) {
        this.g47Type = g47Type;
    }

    public int getG47ClcType() {
        return g47ClcType;
    }

    public void setG47ClcType(int g47ClcType) {
        this.g47ClcType = g47ClcType;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "paymentType='" + paymentType + '\'' +
                ", g47Base=" + g47Base +
                ", g47AltBase=" + g47AltBase +
                ", g47Rate=" + g47Rate +
                ", g47AltRate=" + g47AltRate +
                ", g47AltBaseCurrKod='" + g47AltBaseCurrKod + '\'' +
                ", currRate=" + currRate +
                ", g47AltBaseEdIzm='" + g47AltBaseEdIzm + '\'' +
                ", g47Sum=" + g47Sum +
                ", g47Sp='" + g47Sp + '\'' +
                ", g47Type='" + g47Type + '\'' +
                ", g47ClcType=" + g47ClcType +
                '}';
    }
}
