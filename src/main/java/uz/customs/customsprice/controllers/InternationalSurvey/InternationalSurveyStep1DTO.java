package uz.customs.customsprice.controllers.InternationalSurvey;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class InternationalSurveyStep1DTO {

    @Size(min = 3, max = 15, message = "Майдон белгилари сони 3 та дан 15 та гача бўлиши лозим!")
    private String xbbMailNum;

    @NotBlank(message = "Санани киритиш мажбурий!")
    private String xbbMailDate;

    @Size(min = 2, max = 200, message = "Майдон белгилари сони 2 та дан 200 та гача бўлиши лозим!")
    private String orgName;

    @Size(min = 4, max = 12, message = "Майдон белгилари сони 4 та дан 12 та гача бўлиши лозим!")
    private String hsCode;

    @Size(min = 2, max = 200, message = "Майдон белгилари сони 2 та дан 200 та гача бўлиши лозим!")
    private String productName;

    @NotNull(message = "Давлат номини танланг!")
    private String sendReqCountryCode;
}
