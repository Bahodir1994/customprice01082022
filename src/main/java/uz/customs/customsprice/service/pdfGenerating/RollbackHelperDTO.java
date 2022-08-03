package uz.customs.customsprice.service.pdfGenerating;

import lombok.Data;

import java.util.List;

@Data
public class RollbackHelperDTO {

    public String commodityNum;

    public String metDescList;

    public RollbackHelperDTO() {
    }

    public RollbackHelperDTO(String commodityNum, String metDescList) {
        this.commodityNum = commodityNum;
        this.metDescList = metDescList;
    }

    public String getCommodityNum() {
        return commodityNum;
    }

    public void setCommodityNum(String commodityNum) {
        this.commodityNum = commodityNum;
    }

    public String getMetDescList() {
        return metDescList;
    }

    public void setMetDescList(String metDescList) {
        this.metDescList = metDescList;
    }
}
