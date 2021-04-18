package it.sogei.svildep.indirizziservice.dto;

import it.sogei.svildep.indirizziservice.model.Soggetto;
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
public class IndirizzoDto extends SvildepDto{

    @NotNull
    private String id;
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
    private SoggettoFisicoDto soggettoFisicoDto;
    private ComuneDto comuneDto;
    private StatoEsteroDto statoEstero;

}
