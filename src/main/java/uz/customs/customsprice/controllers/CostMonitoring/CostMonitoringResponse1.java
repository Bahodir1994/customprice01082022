package uz.customs.customsprice.controllers.CostMonitoring;

import java.util.List;

public class CostMonitoringResponse1 {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<CostMonitoringData> data;

    public CostMonitoringResponse1() {
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<CostMonitoringData> getData() {
        return data;
    }

    public void setData(List<CostMonitoringData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CostMonitoringResponse{" +
                "draw=" + draw +
                ", recordsTotal=" + recordsTotal +
                ", recordsFiltered=" + recordsFiltered +
                ", data=" + data +
                '}';
    }
}
