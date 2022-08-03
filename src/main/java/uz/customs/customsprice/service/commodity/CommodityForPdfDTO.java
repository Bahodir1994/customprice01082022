package uz.customs.customsprice.service.commodity;

import lombok.Data;
import uz.customs.customsprice.entity.InitialDecision.Apps;
import uz.customs.customsprice.entity.InitialDecision.Commodity;
import uz.customs.customsprice.entity.InitialDecision.Payment;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class CommodityForPdfDTO {
     public String ID;
     public Apps APPS;
     public String APPID;
     public Integer CMDT_NUM;
     public String ORIGIN_COUNTRY;
     public String ORIGN_COUNTR_NM;
     public String ORIGIN_ORG;
     public String TRADE_NAME;
     public String TRADE_MARK;
     public String MARK;
     public String MODEL;
     public String ARTICLE;
     public String SORT;
     public String STANDARTS;
     public String FUNCTIONS;
     public String COM_PROP;
     public String TECH_CHAR;
     public String PRODUCT_GOAL;
     public String HS_CODE;
     public String HS_NAME;
     public BigDecimal BRUTTO;
     public BigDecimal NETTO;
     public BigDecimal BASIC_QTY;
     public String EXTRA_UNITS;
     public BigDecimal EXTRA_QTY;
     public BigDecimal PRICE;
     public BigDecimal CUSTOMS_PRICE;
     public String CURRENCY_TYPE;
     public BigDecimal CARGO_SPACE;
     public String PACK_TYPE;
     public String PACK_TYPE_NM;
     public BigDecimal PACK_QTY;
     public String EXTRA_INFO;
     public String HS_DEC_NUM;
     public Date HS_DEC_DATE;
     public Date IN_DEC_DATE;
     public String IN_DEC_NUM;
     public String METHOD;
     public String METHOD_NM;
     public String METHOD_DESCRIPTION;
     public String PAYMENT_YN;
     public String CURRENCY_NM;
     public String CURRENCY_NM_SYMBOL;

     /*public String payId;
     public Commodity commodity;
     public String cmdtId;
     public BigDecimal g47Base;
     public BigDecimal g47AltBase;
     public BigDecimal g47Rate;
     public BigDecimal g47AltRate;
     public String g47Currkod;
     public BigDecimal g47Sum;
     public String g47Sp;
     public int g47ClcType;
     public String g47Type;
     public String g47AltBaseCurrkod;
     public BigDecimal currRate;
     public String g47AltBaseEdIzm;
     public String g47SumCurrkod;*/

     public CommodityForPdfDTO() {
     }

     public CommodityForPdfDTO(String ID, Apps APPS, String APPID, Integer CMDT_NUM, String ORIGIN_COUNTRY, String ORIGN_COUNTR_NM, String ORIGIN_ORG, String TRADE_NAME, String TRADE_MARK, String MARK, String MODEL, String ARTICLE, String SORT, String STANDARTS, String FUNCTIONS, String COM_PROP, String TECH_CHAR, String PRODUCT_GOAL, String HS_CODE, String HS_NAME, BigDecimal BRUTTO, BigDecimal NETTO, BigDecimal BASIC_QTY, String EXTRA_UNITS, BigDecimal EXTRA_QTY, BigDecimal PRICE, BigDecimal CUSTOMS_PRICE, String CURRENCY_TYPE, BigDecimal CARGO_SPACE, String PACK_TYPE, String PACK_TYPE_NM, BigDecimal PACK_QTY, String EXTRA_INFO, String HS_DEC_NUM, Date HS_DEC_DATE, Date IN_DEC_DATE, String IN_DEC_NUM, String METHOD, String METHOD_NM, String METHOD_DESCRIPTION, String PAYMENT_YN, String CURRENCY_NM, String CURRENCY_NM_SYMBOL) {
          this.ID = ID;
          this.APPS = APPS;
          this.APPID = APPID;
          this.CMDT_NUM = CMDT_NUM;
          this.ORIGIN_COUNTRY = ORIGIN_COUNTRY;
          this.ORIGN_COUNTR_NM = ORIGN_COUNTR_NM;
          this.ORIGIN_ORG = ORIGIN_ORG;
          this.TRADE_NAME = TRADE_NAME;
          this.TRADE_MARK = TRADE_MARK;
          this.MARK = MARK;
          this.MODEL = MODEL;
          this.ARTICLE = ARTICLE;
          this.SORT = SORT;
          this.STANDARTS = STANDARTS;
          this.FUNCTIONS = FUNCTIONS;
          this.COM_PROP = COM_PROP;
          this.TECH_CHAR = TECH_CHAR;
          this.PRODUCT_GOAL = PRODUCT_GOAL;
          this.HS_CODE = HS_CODE;
          this.HS_NAME = HS_NAME;
          this.BRUTTO = BRUTTO;
          this.NETTO = NETTO;
          this.BASIC_QTY = BASIC_QTY;
          this.EXTRA_UNITS = EXTRA_UNITS;
          this.EXTRA_QTY = EXTRA_QTY;
          this.PRICE = PRICE;
          this.CUSTOMS_PRICE = CUSTOMS_PRICE;
          this.CURRENCY_TYPE = CURRENCY_TYPE;
          this.CARGO_SPACE = CARGO_SPACE;
          this.PACK_TYPE = PACK_TYPE;
          this.PACK_TYPE_NM = PACK_TYPE_NM;
          this.PACK_QTY = PACK_QTY;
          this.EXTRA_INFO = EXTRA_INFO;
          this.HS_DEC_NUM = HS_DEC_NUM;
          this.HS_DEC_DATE = HS_DEC_DATE;
          this.IN_DEC_DATE = IN_DEC_DATE;
          this.IN_DEC_NUM = IN_DEC_NUM;
          this.METHOD = METHOD;
          this.METHOD_NM = METHOD_NM;
          this.METHOD_DESCRIPTION = METHOD_DESCRIPTION;
          this.PAYMENT_YN = PAYMENT_YN;
          this.CURRENCY_NM = CURRENCY_NM;
          this.CURRENCY_NM_SYMBOL = CURRENCY_NM_SYMBOL;
     }

     public String getID() {
          return ID;
     }

     public void setID(String ID) {
          this.ID = ID;
     }

     public Apps getAPPS() {
          return APPS;
     }

     public void setAPPS(Apps APPS) {
          this.APPS = APPS;
     }

     public String getAPPID() {
          return APPID;
     }

     public void setAPPID(String APPID) {
          this.APPID = APPID;
     }

     public Integer getCMDT_NUM() {
          return CMDT_NUM;
     }

     public void setCMDT_NUM(Integer CMDT_NUM) {
          this.CMDT_NUM = CMDT_NUM;
     }

     public String getORIGIN_COUNTRY() {
          return ORIGIN_COUNTRY;
     }

     public void setORIGIN_COUNTRY(String ORIGIN_COUNTRY) {
          this.ORIGIN_COUNTRY = ORIGIN_COUNTRY;
     }

     public String getORIGN_COUNTR_NM() {
          return ORIGN_COUNTR_NM;
     }

     public void setORIGN_COUNTR_NM(String ORIGN_COUNTR_NM) {
          this.ORIGN_COUNTR_NM = ORIGN_COUNTR_NM;
     }

     public String getORIGIN_ORG() {
          return ORIGIN_ORG;
     }

     public void setORIGIN_ORG(String ORIGIN_ORG) {
          this.ORIGIN_ORG = ORIGIN_ORG;
     }

     public String getTRADE_NAME() {
          return TRADE_NAME;
     }

     public void setTRADE_NAME(String TRADE_NAME) {
          this.TRADE_NAME = TRADE_NAME;
     }

     public String getTRADE_MARK() {
          return TRADE_MARK;
     }

     public void setTRADE_MARK(String TRADE_MARK) {
          this.TRADE_MARK = TRADE_MARK;
     }

     public String getMARK() {
          return MARK;
     }

     public void setMARK(String MARK) {
          this.MARK = MARK;
     }

     public String getMODEL() {
          return MODEL;
     }

     public void setMODEL(String MODEL) {
          this.MODEL = MODEL;
     }

     public String getARTICLE() {
          return ARTICLE;
     }

     public void setARTICLE(String ARTICLE) {
          this.ARTICLE = ARTICLE;
     }

     public String getSORT() {
          return SORT;
     }

     public void setSORT(String SORT) {
          this.SORT = SORT;
     }

     public String getSTANDARTS() {
          return STANDARTS;
     }

     public void setSTANDARTS(String STANDARTS) {
          this.STANDARTS = STANDARTS;
     }

     public String getFUNCTIONS() {
          return FUNCTIONS;
     }

     public void setFUNCTIONS(String FUNCTIONS) {
          this.FUNCTIONS = FUNCTIONS;
     }

     public String getCOM_PROP() {
          return COM_PROP;
     }

     public void setCOM_PROP(String COM_PROP) {
          this.COM_PROP = COM_PROP;
     }

     public String getTECH_CHAR() {
          return TECH_CHAR;
     }

     public void setTECH_CHAR(String TECH_CHAR) {
          this.TECH_CHAR = TECH_CHAR;
     }

     public String getPRODUCT_GOAL() {
          return PRODUCT_GOAL;
     }

     public void setPRODUCT_GOAL(String PRODUCT_GOAL) {
          this.PRODUCT_GOAL = PRODUCT_GOAL;
     }

     public String getHS_CODE() {
          return HS_CODE;
     }

     public void setHS_CODE(String HS_CODE) {
          this.HS_CODE = HS_CODE;
     }

     public String getHS_NAME() {
          return HS_NAME;
     }

     public void setHS_NAME(String HS_NAME) {
          this.HS_NAME = HS_NAME;
     }

     public BigDecimal getBRUTTO() {
          return BRUTTO;
     }

     public void setBRUTTO(BigDecimal BRUTTO) {
          this.BRUTTO = BRUTTO;
     }

     public BigDecimal getNETTO() {
          return NETTO;
     }

     public void setNETTO(BigDecimal NETTO) {
          this.NETTO = NETTO;
     }

     public BigDecimal getBASIC_QTY() {
          return BASIC_QTY;
     }

     public void setBASIC_QTY(BigDecimal BASIC_QTY) {
          this.BASIC_QTY = BASIC_QTY;
     }

     public String getEXTRA_UNITS() {
          return EXTRA_UNITS;
     }

     public void setEXTRA_UNITS(String EXTRA_UNITS) {
          this.EXTRA_UNITS = EXTRA_UNITS;
     }

     public BigDecimal getEXTRA_QTY() {
          return EXTRA_QTY;
     }

     public void setEXTRA_QTY(BigDecimal EXTRA_QTY) {
          this.EXTRA_QTY = EXTRA_QTY;
     }

     public BigDecimal getPRICE() {
          return PRICE;
     }

     public void setPRICE(BigDecimal PRICE) {
          this.PRICE = PRICE;
     }

     public BigDecimal getCUSTOMS_PRICE() {
          return CUSTOMS_PRICE;
     }

     public void setCUSTOMS_PRICE(BigDecimal CUSTOMS_PRICE) {
          this.CUSTOMS_PRICE = CUSTOMS_PRICE;
     }

     public String getCURRENCY_TYPE() {
          return CURRENCY_TYPE;
     }

     public void setCURRENCY_TYPE(String CURRENCY_TYPE) {
          this.CURRENCY_TYPE = CURRENCY_TYPE;
     }

     public BigDecimal getCARGO_SPACE() {
          return CARGO_SPACE;
     }

     public void setCARGO_SPACE(BigDecimal CARGO_SPACE) {
          this.CARGO_SPACE = CARGO_SPACE;
     }

     public String getPACK_TYPE() {
          return PACK_TYPE;
     }

     public void setPACK_TYPE(String PACK_TYPE) {
          this.PACK_TYPE = PACK_TYPE;
     }

     public String getPACK_TYPE_NM() {
          return PACK_TYPE_NM;
     }

     public void setPACK_TYPE_NM(String PACK_TYPE_NM) {
          this.PACK_TYPE_NM = PACK_TYPE_NM;
     }

     public BigDecimal getPACK_QTY() {
          return PACK_QTY;
     }

     public void setPACK_QTY(BigDecimal PACK_QTY) {
          this.PACK_QTY = PACK_QTY;
     }

     public String getEXTRA_INFO() {
          return EXTRA_INFO;
     }

     public void setEXTRA_INFO(String EXTRA_INFO) {
          this.EXTRA_INFO = EXTRA_INFO;
     }

     public String getHS_DEC_NUM() {
          return HS_DEC_NUM;
     }

     public void setHS_DEC_NUM(String HS_DEC_NUM) {
          this.HS_DEC_NUM = HS_DEC_NUM;
     }

     public Date getHS_DEC_DATE() {
          return HS_DEC_DATE;
     }

     public void setHS_DEC_DATE(Date HS_DEC_DATE) {
          this.HS_DEC_DATE = HS_DEC_DATE;
     }

     public Date getIN_DEC_DATE() {
          return IN_DEC_DATE;
     }

     public void setIN_DEC_DATE(Date IN_DEC_DATE) {
          this.IN_DEC_DATE = IN_DEC_DATE;
     }

     public String getIN_DEC_NUM() {
          return IN_DEC_NUM;
     }

     public void setIN_DEC_NUM(String IN_DEC_NUM) {
          this.IN_DEC_NUM = IN_DEC_NUM;
     }

     public String getMETHOD() {
          return METHOD;
     }

     public void setMETHOD(String METHOD) {
          this.METHOD = METHOD;
     }

     public String getMETHOD_NM() {
          return METHOD_NM;
     }

     public void setMETHOD_NM(String METHOD_NM) {
          this.METHOD_NM = METHOD_NM;
     }

     public String getMETHOD_DESCRIPTION() {
          return METHOD_DESCRIPTION;
     }

     public void setMETHOD_DESCRIPTION(String METHOD_DESCRIPTION) {
          this.METHOD_DESCRIPTION = METHOD_DESCRIPTION;
     }

     public String getPAYMENT_YN() {
          return PAYMENT_YN;
     }

     public void setPAYMENT_YN(String PAYMENT_YN) {
          this.PAYMENT_YN = PAYMENT_YN;
     }

     public String getCURRENCY_NM() {
          return CURRENCY_NM;
     }

     public void setCURRENCY_NM(String CURRENCY_NM) {
          this.CURRENCY_NM = CURRENCY_NM;
     }

     public String getCURRENCY_NM_SYMBOL() {
          return CURRENCY_NM_SYMBOL;
     }

     public void setCURRENCY_NM_SYMBOL(String CURRENCY_NM_SYMBOL) {
          this.CURRENCY_NM_SYMBOL = CURRENCY_NM_SYMBOL;
     }
}
