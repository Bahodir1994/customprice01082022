package uz.customs.customsprice.controllers.InternationalSurvey;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class InternationalSurveyStep3DTO {

    @Size(min = 3, max = 30, message = "Майдон белгилари сони 3 та дан<br> 30 та гача бўлиши лозим!")
    private String resultAnswerMailNum;

    @NotBlank(message = "Санани киритиш мажбурий!")
    private String resultAnswerMailDate;

    @Size(min = 3, max = 30, message = "Майдон белгилари сони 3 та дан<br> 30 та гача бўлиши лозим!")
    private String xbbVerdictNum;

    @NotBlank(message = "Санани киритиш мажбурий!")
    private String xbbVerdictDate;

    @Size(min = 3, max = 30, message = "Майдон белгилари сони 3 та дан<br> 30 та гача бўлиши лозим!")
    private String sum;

    @NotBlank(message = "Изох майдони дастлаб тўлдирилиши лозим!")
    private String comment;

    private String id;
    private String status;
}
