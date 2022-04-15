package uz.customs.customsprice.payload;

import uz.customs.customsprice.entity.earxiv.Earxiv;

import java.util.Map;

public class EarxivResponse {
    private Earxiv earxiv;
    private boolean validated;
    private Map<String, String> errorMessages;
    private String infoTitle;
    private String infoMessages;
    private String typeIcon;
    private String typeMessages;

    public Earxiv getEarxiv() {
        return earxiv;
    }

    public void setEarxiv(Earxiv earxiv) {
        this.earxiv = earxiv;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getInfoMessages() {
        return infoMessages;
    }

    public void setInfoMessages(String infoMessages) {
        this.infoMessages = infoMessages;
    }

    public String getTypeIcon() {
        return typeIcon;
    }

    public void setTypeIcon(String typeIcon) {
        this.typeIcon = typeIcon;
    }

    public String getTypeMessages() {
        return typeMessages;
    }

    public void setTypeMessages(String typeMessages) {
        this.typeMessages = typeMessages;
    }
}
