package uz.customs.customsprice.controllers.InternationalSurvey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class InternationalSurveySearchValue {
    private String userLocationCode;
    private String directionTypeCode;
    private String xbbMailDate;
    private String xbbMailNum;
    private String hsCode;
    private String productName;
    private String sendReqCountryCode;
    private String sendReqNum;
    private String reqDate;
    private String responseNum;
    private String responseDate;
    private String responseNumSendXbbNum;
    private String responseNumSendXbbDate;
    private String resultAnswerMailNum;
    private String resultAnswerMailDate;
    private String xbbVerdictNum;
    private String xbbVerdictDate;
    private String executiveTerritoryCode;
    private String status;
    private int page;
    private int size;
}
