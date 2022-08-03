package uz.customs.customsprice.controllers.api.files;

import lombok.Data;
import uz.customs.customsprice.entity.InitialDecision.Commodity;

import java.util.List;

@Data
public class CommodityDTO {

    public List<Commodity> commodity;

    public CommodityDTO() {
    }

    public CommodityDTO(List<Commodity> commodity) {
        this.commodity = commodity;
    }

    public List<Commodity> getCommodity() {
        return commodity;
    }

    public void setCommodity(List<Commodity> commodity) {
        this.commodity = commodity;
    }
}
