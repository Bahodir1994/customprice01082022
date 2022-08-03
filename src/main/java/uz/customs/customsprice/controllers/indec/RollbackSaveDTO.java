package uz.customs.customsprice.controllers.indec;

import lombok.Data;

@Data
public class RollbackSaveDTO {
    private final String id1;
    private final String id2;
    private final String id3;
    private final String id4;
    private final String id5;
    private final String id6;
    private final String textareaFor1;
    private final String textareaFor2;
    private final String appId;
    private final String correction;
    private final String entirely;


    public RollbackSaveDTO(String id1, String id2, String id3, String id4, String id5, String id6, String textareaFor1, String textareaFor2, String appId, String correction, String entirely) {
        this.id1 = id1;
        this.id2 = id2;
        this.id3 = id3;
        this.id4 = id4;
        this.id5 = id5;
        this.id6 = id6;
        this.textareaFor1 = textareaFor1;
        this.textareaFor2 = textareaFor2;
        this.appId = appId;
        this.correction = correction;
        this.entirely = entirely;
    }

    public String getId1() {
        return id1;
    }

    public String getId2() {
        return id2;
    }

    public String getId3() {
        return id3;
    }

    public String getId4() {
        return id4;
    }

    public String getId5() {
        return id5;
    }

    public String getId6() {
        return id6;
    }

    public String getTextareaFor1() {
        return textareaFor1;
    }

    public String getTextareaFor2() {
        return textareaFor2;
    }

    public String getAppId() {return appId;}

    public String getCorrection() {
        return correction;
    }

    public String getEntirely() {
        return entirely;
    }
}
