package uz.customs.customsprice.controllers.InternationalSurvey;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class InternationalSurveyStep2DTO {

    @Size(min = 3, max = 30, message = "Майдон белгилари сони 3 та дан <br> 30 та гача бўлиши лозим!")
    private String sendReqNum;

    @NotBlank(message = "Санани киритиш мажбурий!")
    private String reqDate;

//    @Size(min = 3, max = 30, message = "Майдон белгилари сони 3 та дан <br> 30 та гача бўлиши лозим!")
    private String responseNum;

//    @NotBlank(message = "Санани киритиш мажбурий!")
    private String responseDate;

//    @Size(min = 3, max = 30, message = "Майдон белгилари сони 3 та дан <br> 30 та гача бўлиши лозим!")
    private String responseNumSendXbbNum;

//    @NotBlank(message = "Санани киритиш мажбурий!")
    private String responseNumSendXbbDate;

    @NotBlank(message = "Ижрочи худудни танланг!")
    private String executiveTerritoryCode;

    private String distributed;

    private String id;
    private String status;
}
