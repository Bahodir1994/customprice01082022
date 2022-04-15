package uz.customs.customsprice.entity.InitialDecision;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import uz.customs.customsprice.controllers.api.helper.ValidDate;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Commodity extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "APP_ID", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Apps apps;

    @Column(name = "APP_ID", columnDefinition = "VARCHAR(50)")
    private String appId;

    @Column(name = "CMDT_NUM")
    private Integer cmdtNum;

    @Column(name = "ORIGIN_COUNTRY", length = 3)
    @Digits(message = "Устун фақат сонлардан иборат бўлиши лозим", integer = 3, fraction = 0)
    private String originCountry;

    @Column(name = "ORIGIN_COUNTRY_NM", columnDefinition = "VARCHAR(120) CCSID 1208")
    private String orignCountrNm;

    @Column(name = "ORIGIN_ORG", columnDefinition = "VARCHAR(900) CCSID 1208")
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 300, message = "Устун маълумоти катталиги чекланган")
    private String originOrg;

    @Column(name = "TRADE_NAME", columnDefinition = "VARCHAR(765) CCSID 1208")
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 255, message = "Устун маълумоти катталиги чекланган")
    private String tradeName;

    @Column(name = "TRADE_MARK", columnDefinition = "VARCHAR(765) CCSID 1208")
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 255, message = "Устун маълумоти катталиги чекланган")
    private String tradeMark;

    @Column(name = "MARK", columnDefinition = "VARCHAR(765) CCSID 1208")
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 255, message = "Устун маълумоти катталиги чекланган")
    private String mark;

    @Column(name = "MODEL", columnDefinition = "VARCHAR(765) CCSID 1208")
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 255, message = "Устун маълумоти катталиги чекланган")
    private String model;

    @Column(name = "ARTICLE", columnDefinition = "VARCHAR(765) CCSID 1208")
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 255, message = "Устун маълумоти катталиги чекланган")
    private String article;

    @Column(name = "SORT", columnDefinition = "VARCHAR(765) CCSID 1208")
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 255, message = "Устун маълумоти катталиги чекланган")
    private String sort;

    @Column(name = "STANDARTS", columnDefinition = "VARCHAR(1500) CCSID 1208")
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 500, message = "Устун маълумоти катталиги чекланган")
    private String standarts;

    @Column(name = "FUNCTIONS", columnDefinition = "VARCHAR(1500) CCSID 1208")
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 500, message = "Устун маълумоти катталиги чекланган")
    private String functions;

    @Column(name = "COM_PROP", columnDefinition = "VARCHAR(4000) CCSID 1208")
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 1300, message = "Устун маълумоти катталиги чекланган")
    private String comProp;

    @Column(name = "TECH_CHAR", columnDefinition = "VARCHAR(2000) CCSID 1208")
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 600, message = "Устун маълумоти катталиги чекланган")
    private String techChar;

    @Column(name = "PRODUCT_GOAL", columnDefinition = "VARCHAR(900) CCSID 1208")
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 30, message = "Устун маълумоти катталиги чекланган")
    private String productGoal;

    @Column(name = "HS_CODE", length = 10)
    @NotNull(message =  "Устун тўлдирилмаган")
    @Size(min = 10, max = 10, message = "Устун 10 та сондан иборат бўлиши лозим")
    private String hsCode;

    @Column(name = "HS_NAME", columnDefinition = "VARCHAR(2000) CCSID 1208")
    private String hsName;

    @Column(name = "BRUTTO", length = 4)
    @Digits(message = "Устун фақат ҳақиқий сонлардан иборат бўлиши лозим", integer = 15, fraction = 3)
    private BigDecimal brutto;

    @Column(name = "NETTO", length = 4)
    @Digits(message = "Устун фақат ҳақиқий сонлардан иборат бўлиши лозим", integer = 15, fraction = 3)
    private BigDecimal netto;

    @Column(name = "BASIC_QTY", length = 4)
    @Digits(message = "Устун фақат ҳақиқий сонлардан иборат бўлиши лозим", integer = 15, fraction = 3)
    private BigDecimal basicQty;

    @Column(name = "EXTRA_UNITS", length = 3)
    @Digits(message = "Устун фақат сонлардан иборат бўлиши лозим", integer = 3, fraction = 0)
    private String extraUnits;

    @Column(name = "EXTRA_QTY", length = 4)
    @Digits(message = "Устун фақат ҳақиқий сонлардан иборат бўлиши лозим", integer = 15, fraction = 3)
    private BigDecimal extraQty;

    @Column(name = "PRICE", length = 4)
    @Digits(message = "Устун фақат ҳақиқий сонлардан иборат бўлиши лозим", integer = 15, fraction = 3)
    private BigDecimal price;

    @Column(name = "CURRENCY_TYPE", length = 3)
    @Digits(message = "Устун фақат сонлардан иборат бўлиши лозим", integer = 3, fraction = 0)
    private String currencyType;

    @Column(name = "CARGO_SPACE", length = 4)
    @Digits(message = "Устун фақат ҳақиқий сонлардан иборат бўлиши лозим", integer = 15, fraction = 3)
    private BigDecimal cargoSpace;

    @Column(name = "PACK_TYPE", length = 3)
    @Digits(message = "Устун фақат сонлардан иборат бўлиши лозим", integer = 3, fraction = 0)
    private String packType;

    @Column(name = "PACK_TYPE_NM", columnDefinition = "VARCHAR(90) CCSID 1208")
    private String packTypeNm;

    @Column(name = "PACK_QTY", length = 4)
    @Digits(message = "Устун фақат ҳақиқий сонлардан иборат бўлиши лозим", integer = 15, fraction = 3)
    private BigDecimal packQty;

    @Column(name = "EXTRA_INFO", columnDefinition = "VARCHAR(2000) CCSID 1208")
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 600, message = "Устун маълумоти катталиги чекланган")
    private String extraInfo;

    @Column(name = "HS_DEC_NUM", length = 20)
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 20, message = "Устун маълумоти катталиги чекланган")
    private String hsDecNum;

    @Column(name = "HS_DEC_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Устун тўлдирилмаган")
    @Temporal(TemporalType.DATE)
    private Date hsDecDate;

    @Column(name = "IN_DEC_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Устун тўлдирилмаган")
    @Temporal(TemporalType.DATE)
    private Date inDecDate;

    @Column(name = "IN_DEC_NUM", length = 30)
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 30, message = "Устун маълумоти катталиги чекланган")
    private String inDecNum;

    @Column(name = "METHOD", length = 2)
    @Digits(message = "Устун фақат сонлардан иборат бўлиши лозим", integer = 2, fraction = 0)
    private String method;

    @Column(name = "METHOD_NM", columnDefinition = "VARCHAR(180) CCSID 1208")
    private String methodNm;

    @Column(name = "PAYMENT_YN", columnDefinition = " VARCHAR(3) DEFAULT 'NO' ")
//    @Digits(message = "Устун фақат сонлардан иборат бўлиши лозим", integer = 2, fraction = 0)
    private String paymentYN;

    public Commodity() {
    }

    public Commodity(String insUser, String updUser, Date insTime, Date updTime, int isDeleted, String id, Apps apps, String appId, Integer cmdtNum, String originCountry, String orignCountrNm, String originOrg, String tradeName, String tradeMark, String mark, String model, String article, String sort, String standarts, String functions, String comProp, String techChar, String productGoal, String hsCode, String hsName, BigDecimal brutto, BigDecimal netto, BigDecimal basicQty, String extraUnits, BigDecimal extraQty, BigDecimal price, String currencyType, BigDecimal cargoSpace, String packType, String packTypeNm, BigDecimal packQty, String extraInfo, String hsDecNum, Date hsDecDate, Date inDecDate, String inDecNum, String method, String methodNm, String paymentYN) {
        super(insUser, updUser, insTime, updTime, isDeleted);
        this.id = id;
        this.apps = apps;
        this.appId = appId;
        this.cmdtNum = cmdtNum;
        this.originCountry = originCountry;
        this.orignCountrNm = orignCountrNm;
        this.originOrg = originOrg;
        this.tradeName = tradeName;
        this.tradeMark = tradeMark;
        this.mark = mark;
        this.model = model;
        this.article = article;
        this.sort = sort;
        this.standarts = standarts;
        this.functions = functions;
        this.comProp = comProp;
        this.techChar = techChar;
        this.productGoal = productGoal;
        this.hsCode = hsCode;
        this.hsName = hsName;
        this.brutto = brutto;
        this.netto = netto;
        this.basicQty = basicQty;
        this.extraUnits = extraUnits;
        this.extraQty = extraQty;
        this.price = price;
        this.currencyType = currencyType;
        this.cargoSpace = cargoSpace;
        this.packType = packType;
        this.packTypeNm = packTypeNm;
        this.packQty = packQty;
        this.extraInfo = extraInfo;
        this.hsDecNum = hsDecNum;
        this.hsDecDate = hsDecDate;
        this.inDecDate = inDecDate;
        this.inDecNum = inDecNum;
        this.method = method;
        this.methodNm = methodNm;
        this.paymentYN = paymentYN;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Apps getApps() {
        return apps;
    }

    public void setApps(Apps apps) {
        this.apps = apps;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Integer getCmdtNum() {
        return cmdtNum;
    }

    public void setCmdtNum(Integer cmdtNum) {
        this.cmdtNum = cmdtNum;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getOrignCountrNm() {
        return orignCountrNm;
    }

    public void setOrignCountrNm(String orignCountrNm) {
        this.orignCountrNm = orignCountrNm;
    }

    public String getOriginOrg() {
        return originOrg;
    }

    public void setOriginOrg(String originOrg) {
        this.originOrg = originOrg;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getStandarts() {
        return standarts;
    }

    public void setStandarts(String standarts) {
        this.standarts = standarts;
    }

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    public String getComProp() {
        return comProp;
    }

    public void setComProp(String comProp) {
        this.comProp = comProp;
    }

    public String getTechChar() {
        return techChar;
    }

    public void setTechChar(String techChar) {
        this.techChar = techChar;
    }

    public String getProductGoal() {
        return productGoal;
    }

    public void setProductGoal(String productGoal) {
        this.productGoal = productGoal;
    }

    public String getHsCode() {
        return hsCode;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    public String getHsName() {
        return hsName;
    }

    public void setHsName(String hsName) {
        this.hsName = hsName;
    }

    public BigDecimal getBrutto() {
        return brutto;
    }

    public void setBrutto(BigDecimal brutto) {
        this.brutto = brutto;
    }

    public BigDecimal getNetto() {
        return netto;
    }

    public void setNetto(BigDecimal netto) {
        this.netto = netto;
    }

    public BigDecimal getBasicQty() {
        return basicQty;
    }

    public void setBasicQty(BigDecimal basicQty) {
        this.basicQty = basicQty;
    }

    public String getExtraUnits() {
        return extraUnits;
    }

    public void setExtraUnits(String extraUnits) {
        this.extraUnits = extraUnits;
    }

    public BigDecimal getExtraQty() {
        return extraQty;
    }

    public void setExtraQty(BigDecimal extraQty) {
        this.extraQty = extraQty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public BigDecimal getCargoSpace() {
        return cargoSpace;
    }

    public void setCargoSpace(BigDecimal cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    public String getPackType() {
        return packType;
    }

    public void setPackType(String packType) {
        this.packType = packType;
    }

    public String getPackTypeNm() {
        return packTypeNm;
    }

    public void setPackTypeNm(String packTypeNm) {
        this.packTypeNm = packTypeNm;
    }

    public BigDecimal getPackQty() {
        return packQty;
    }

    public void setPackQty(BigDecimal packQty) {
        this.packQty = packQty;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getHsDecNum() {
        return hsDecNum;
    }

    public void setHsDecNum(String hsDecNum) {
        this.hsDecNum = hsDecNum;
    }

    public Date getHsDecDate() {
        return hsDecDate;
    }

    public void setHsDecDate(Date hsDecDate) {
        this.hsDecDate = hsDecDate;
    }

    public Date getInDecDate() {
        return inDecDate;
    }

    public void setInDecDate(Date inDecDate) {
        this.inDecDate = inDecDate;
    }

    public String getInDecNum() {
        return inDecNum;
    }

    public void setInDecNum(String inDecNum) {
        this.inDecNum = inDecNum;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethodNm() {
        return methodNm;
    }

    public void setMethodNm(String methodNm) {
        this.methodNm = methodNm;
    }

    public String getPaymentYN() {
        return paymentYN;
    }

    public void setPaymentYN(String paymentYN) {
        this.paymentYN = paymentYN;
    }
}