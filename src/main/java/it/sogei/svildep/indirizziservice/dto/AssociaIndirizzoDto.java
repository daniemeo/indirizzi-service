package it.sogei.svildep.indirizziservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class AssociaIndirizzoDto extends SvildepDto{

    @NotBlank
    private String indirizzoId;
    @NotBlank
    private String soggettoFisicoId;
}
