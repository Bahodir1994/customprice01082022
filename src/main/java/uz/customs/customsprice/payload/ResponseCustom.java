package uz.customs.customsprice.payload;

public class ResponseCustom {
    private String g47Base;
    private String g47AltBase;
    private String g47AltRate;
    private String g47Rate;
    private String g47Sum;
    private String unitRate;
    private String altRate;
    private String advRate;
    private String g47AltBaseEdIzm;
    private String rate840;
    private String typeRate;
    private String g47ClcType;
    private String g47Type;
    private String currRate;
    private String g47AltBaseCurrKod;

    public ResponseCustom() {
    }

    public ResponseCustom(String g47Base, String g47AltBase, String g47AltRate, String g47Rate, String g47Sum, String unitRate, String altRate, String advRate, String g47AltBaseEdIzm, String rate840, String typeRate, String g47ClcType, String g47Type, String currRate, String g47AltBaseCurrKod) {
        this.g47Base = g47Base;
        this.g47AltBase = g47AltBase;
        this.g47AltRate = g47AltRate;
        this.g47Rate = g47Rate;
        this.g47Sum = g47Sum;
        this.unitRate = unitRate;
        this.altRate = altRate;
        this.advRate = advRate;
        this.g47AltBaseEdIzm = g47AltBaseEdIzm;
        this.rate840 = rate840;
        this.typeRate = typeRate;
        this.g47ClcType = g47ClcType;
        this.g47Type = g47Type;
        this.currRate = currRate;
        this.g47AltBaseCurrKod = g47AltBaseCurrKod;
    }

    public String getG47Base() {
        return g47Base;
    }

    public void setG47Base(String g47Base) {
        this.g47Base = g47Base;
    }

    public String getG47AltBase() {
        return g47AltBase;
    }

    public void setG47AltBase(String g47AltBase) {
        this.g47AltBase = g47AltBase;
    }

    public String getG47AltRate() {
        return g47AltRate;
    }

    public void setG47AltRate(String g47AltRate) {
        this.g47AltRate = g47AltRate;
    }

    public String getG47Rate() {
        return g47Rate;
    }

    public void setG47Rate(String g47Rate) {
        this.g47Rate = g47Rate;
    }

    public String getG47Sum() {
        return g47Sum;
    }

    public void setG47Sum(String g47Sum) {
        this.g47Sum = g47Sum;
    }

    public String getUnitRate() {
        return unitRate;
    }

    public void setUnitRate(String unitRate) {
        this.unitRate = unitRate;
    }

    public String getAltRate() {
        return altRate;
    }

    public void setAltRate(String altRate) {
        this.altRate = altRate;
    }

    public String getAdvRate() {
        return advRate;
    }

    public void setAdvRate(String advRate) {
        this.advRate = advRate;
    }

    public String getG47AltBaseEdIzm() {
        return g47AltBaseEdIzm;
    }

    public void setG47AltBaseEdIzm(String g47AltBaseEdIzm) {
        this.g47AltBaseEdIzm = g47AltBaseEdIzm;
    }

    public String getRate840() {
        return rate840;
    }

    public void setRate840(String rate840) {
        this.rate840 = rate840;
    }

    public String getTypeRate() {
        return typeRate;
    }

    public void setTypeRate(String typeRate) {
        this.typeRate = typeRate;
    }

    public String getG47ClcType() {
        return g47ClcType;
    }

    public void setG47ClcType(String g47ClcType) {
        this.g47ClcType = g47ClcType;
    }

    public String getG47Type() {
        return g47Type;
    }

    public void setG47Type(String g47Type) {
        this.g47Type = g47Type;
    }

    public String getCurrRate() {
        return currRate;
    }

    public void setCurrRate(String currRate) {
        this.currRate = currRate;
    }

    public String getG47AltBaseCurrKod() {
        return g47AltBaseCurrKod;
    }

    public void setG47AltBaseCurrKod(String g47AltBaseCurrKod) {
        this.g47AltBaseCurrKod = g47AltBaseCurrKod;
    }

    @Override
    public String toString() {
        return "ResponseCustom{" +
                "g47Base='" + g47Base + '\'' +
                ", g47AltBase='" + g47AltBase + '\'' +
                ", g47AltRate='" + g47AltRate + '\'' +
                ", g47Rate='" + g47Rate + '\'' +
                ", g47Sum='" + g47Sum + '\'' +
                ", unitRate='" + unitRate + '\'' +
                ", altRate='" + altRate + '\'' +
                ", advRate='" + advRate + '\'' +
                ", g47AltBaseEdIzm='" + g47AltBaseEdIzm + '\'' +
                ", rate840='" + rate840 + '\'' +
                ", typeRate='" + typeRate + '\'' +
                ", g47ClcType='" + g47ClcType + '\'' +
                ", g47Type='" + g47Type + '\'' +
                ", currRate='" + currRate + '\'' +
                ", g47AltBaseCurrKod='" + g47AltBaseCurrKod + '\'' +
                '}';
    }
}
