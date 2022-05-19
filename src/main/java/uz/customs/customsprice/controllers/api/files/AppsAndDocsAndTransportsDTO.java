package uz.customs.customsprice.controllers.api.files;


import lombok.Data;
import uz.customs.customsprice.entity.InitialDecision.Apps;
import uz.customs.customsprice.entity.InitialDecision.TransportType;
import uz.customs.customsprice.entity.earxiv.Earxiv;


import javax.validation.Valid;
import java.util.List;

@Data
public class AppsAndDocsAndTransportsDTO {
    private Apps apps;

    private List<Earxiv> docs;

    private List<TransportType> transports;

    public AppsAndDocsAndTransportsDTO() {
    }

    public AppsAndDocsAndTransportsDTO(Apps apps, List<Earxiv> docs, List<TransportType> transports) {
        this.apps = apps;
        this.docs = docs;
        this.transports = transports;
    }

    public Apps getApps() {
        return apps;
    }

    public void setApps(Apps apps) {
        this.apps = apps;
    }

    public List<Earxiv> getDocs() {
        return docs;
    }

    public void setDocs(List<Earxiv> docs) {
        this.docs = docs;
    }

    public List<TransportType> getTransports() {
        return transports;
    }

    public void setTransports(List<TransportType> transports) {
        this.transports = transports;
    }
}
