package it.sogei.svildep.indirizziservice.dto;

import it.sogei.svildep.indirizziservice.model.SoggettoFisico;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InsertIndirizzoDto extends SvildepDto{

    private String civico;
    private String indirizzo;
    private String cap;
    private String dettaglio;
    private String ripartizione;
    private String tipoIndirizzoId;
    private String soggettoFisicoId;
    private ComunePerInsertDto comuneDto;
    private String statoEsteroId;
}
