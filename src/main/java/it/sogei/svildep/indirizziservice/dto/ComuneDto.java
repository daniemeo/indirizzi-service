package it.sogei.svildep.indirizziservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class ComuneDto extends SvildepDto{

    @NotNull
    private String id;
    @NotBlank
    private String sigla;
    @NotBlank
    private String denominazioneComune;
    private String dataInizioValidita;
    private String dataFineValidita;

    private String comune;
    private String provinciaId;
}
