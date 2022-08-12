package uz.customs.customsprice.controllers.InternationalSurvey;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class InternationalSurveyStep1DTO {

    @Size(min = 3, max = 50, message = "Майдон белгилари сони 3 та дан 50 та гача бўлиши лозим!")
    private String xbbMailNum;

    @NotBlank(message = "Санани киритиш мажбурий!")
    private String xbbMailDate;

    @Size(min = 2, max = 200, message = "Майдон белгилари сони 2 та дан 200 та гача бўлиши лозим!")
    private String orgName;

    @NotBlank(message = "Майдон бўш бўлиши мумкун эмас!")
    private String hsCode;

    @Size(min = 2, max = 200, message = "Майдон белгилари сони 2 та дан 200 та гача бўлиши лозим!")
    private String productName;

    @NotBlank(message = "Давлат номини танланг!")
    private String sendReqCountryCode;

    @NotBlank(message = "Йўналиш турини танланг!")
    private String directionTypeSave;

    @NotNull(message = "Майдон бўш бўлиши мумкун эмас!")
    private BigDecimal sumProbability;

}
