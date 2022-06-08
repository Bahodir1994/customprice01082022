package uz.customs.customsprice.controllers.digest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@Getter
@Setter
public class DigestsControllerDTO {
    private String page;

    private String size;

    @NotBlank(message = "ҲББни танланг!")
    private String locationId;

    @NotBlank(message = "Пост танланмаган!")
    private String g7a;

    @NotBlank(message = "Санани киритиш мажбурий!")
    private String g7b;

    @Size(min = 7, max = 7, message = "БЮД рақами 7 та сон бўлиши лозим!")
    private String g7c;

//    @Size(min = 9, max = 9, message = "СТИР 9 та сон бўлиши лозим!")
    private String g8code2;

//    @NotBlank(message = "Божхона режимни танланг!")
    private String g1b;

}