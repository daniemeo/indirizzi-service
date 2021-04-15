package it.sogei.svildep.indirizziservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class AssociaDissociaIndirizzoDto extends SvildepDto{

    @NotBlank
    private String indirizzoId;

    private String soggettoFisicoId;
}
