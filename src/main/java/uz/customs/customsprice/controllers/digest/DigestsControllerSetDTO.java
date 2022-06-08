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
public class DigestsControllerSetDTO {
    private String locationId;
    private String g7a;
    private String g7b;
    private String g7c;
    private String g8code2;
    private String g1b;
    private String p7a;
    private String p7b;
    private String p7c;
    private String declId;
}