package uz.customs.customsprice.service.pdfGenerating;

import lombok.Data;

@Data
public class MetDesc {
    public String cause;

    public MetDesc() {
    }

    public MetDesc(String cause) {
        this.cause = cause;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
