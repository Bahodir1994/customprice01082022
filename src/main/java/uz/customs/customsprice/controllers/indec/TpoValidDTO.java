package uz.customs.customsprice.controllers.indec;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
public class TpoValidDTO {
//    @Size(min = 5, max = 5, message = "Майдон белгилари сони 5 та бўлиши лозим!")
    private String inDecId;

    private String g3a;

//    @NotBlank(message = "Санани киритиш мажбурий!")
    private String g3b;

//    @Size(min = 5, max = 5, message = "Майдон бўш бўлиши мумкун эмас!")
    private String g3c;
}
