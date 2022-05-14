package uz.customs.customsprice.payload;

public class PostResponse {
    private String code;
    private String cdDesc;
    private String cdId;
    private String cdIdL;
    private String cdNm;
    private String cdOrdr;
    private String lngaTpcd;
    private String useYN;
    private String lat;
    private String longs;
    private String adress;
    private String telephone;
    private String hours;
    private String direction;

    public PostResponse() {
    }

    public PostResponse(String code, String cdDesc, String cdId, String cdIdL, String cdNm, String cdOrdr, String lngaTpcd, String useYN, String lat, String longs, String adress, String telephone, String hours, String direction) {
        this.code = code;
        this.cdDesc = cdDesc;
        this.cdId = cdId;
        this.cdIdL = cdIdL;
        this.cdNm = cdNm;
        this.cdOrdr = cdOrdr;
        this.lngaTpcd = lngaTpcd;
        this.useYN = useYN;
        this.lat = lat;
        this.longs = longs;
        this.adress = adress;
        this.telephone = telephone;
        this.hours = hours;
        this.direction = direction;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCdDesc() {
        return cdDesc;
    }

    public void setCdDesc(String cdDesc) {
        this.cdDesc = cdDesc;
    }

    public String getCdId() {
        return cdId;
    }

    public void setCdId(String cdId) {
        this.cdId = cdId;
    }

    public String getCdIdL() {
        return cdIdL;
    }

    public void setCdIdL(String cdIdL) {
        this.cdIdL = cdIdL;
    }

    public String getCdNm() {
        return cdNm;
    }

    public void setCdNm(String cdNm) {
        this.cdNm = cdNm;
    }

    public String getCdOrdr() {
        return cdOrdr;
    }

    public void setCdOrdr(String cdOrdr) {
        this.cdOrdr = cdOrdr;
    }

    public String getLngaTpcd() {
        return lngaTpcd;
    }

    public void setLngaTpcd(String lngaTpcd) {
        this.lngaTpcd = lngaTpcd;
    }

    public String getUseYN() {
        return useYN;
    }

    public void setUseYN(String useYN) {
        this.useYN = useYN;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongs() {
        return longs;
    }

    public void setLongs(String longs) {
        this.longs = longs;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "PostResponse{" +
                "code='" + code + '\'' +
                ", cdDesc='" + cdDesc + '\'' +
                ", cdId='" + cdId + '\'' +
                ", cdIdL='" + cdIdL + '\'' +
                ", cdNm='" + cdNm + '\'' +
                ", cdOrdr='" + cdOrdr + '\'' +
                ", lngaTpcd='" + lngaTpcd + '\'' +
                ", useYN='" + useYN + '\'' +
                ", lat='" + lat + '\'' +
                ", longs='" + longs + '\'' +
                ", adress='" + adress + '\'' +
                ", telephone='" + telephone + '\'' +
                ", hours='" + hours + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }
}
