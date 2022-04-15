package uz.customs.customsprice.payload;


import uz.customs.customsprice.entity.users.User;

import java.util.Map;

public class UserResponse {
    private User user;
    private boolean validated;
    private Map<String, String> errorMessages;
    private String infoTitle;
    private String infoMessages;
    private String typeIcon;
    private String typeMessages;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
