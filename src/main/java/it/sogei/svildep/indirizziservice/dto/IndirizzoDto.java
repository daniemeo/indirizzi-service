package it.sogei.svildep.indirizziservice.dto;

import it.sogei.svildep.indirizziservice.model.Soggetto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
public class IndirizzoDto extends SvildepDto{

    private String id;
    private String civico;
    private String indirizzo;
    private String cap;
    private String dettaglio;
    private String ripartizione;
    private String tipoIndirizzoId;
    private SoggettoFisicoDto soggettoFisicoDto;
    private ComuneDto comuneDto;
    private StatoEsteroDto statoEstero;

}
