package it.sogei.svildep.indirizziservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class InsertIndirizzoDto extends SvildepDto{

    @NotBlank
    private String civico;
    @NotBlank
    private String indirizzo;
    @NotBlank
    private String cap;
    private String dettaglio;
    private String ripartizione;
    @NotBlank
    private String tipoIndirizzoId;
    @NotBlank
    private String soggettoFisicoId;
    private ComunePerInsertDto comuneDto;
    private String statoEsteroId;
}
