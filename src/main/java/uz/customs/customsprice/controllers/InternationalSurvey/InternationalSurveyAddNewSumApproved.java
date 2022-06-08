package uz.customs.customsprice.controllers.InternationalSurvey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Getter
@Setter
public class InternationalSurveyAddNewSumApproved {
    private BigDecimal sumApprovedAdd;
    private String commentAdd;
    private String IsId;
    private String fabulaAdd;
}
