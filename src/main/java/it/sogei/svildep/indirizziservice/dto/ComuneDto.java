package it.sogei.svildep.indirizziservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComuneDto extends SvildepDto{
    private String id;
    private String sigla;
    private String denominazioneComune;
    private String dataInizioValidita;
    private String dataFineValidita;
    private String comune;
    private String provinciaId;
}
