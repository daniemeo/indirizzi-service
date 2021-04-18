package it.sogei.svildep.indirizziservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class StatoEsteroDto extends SvildepDto{

    private String id;
    private String  denominazioneStatoEstero;

}
