package it.sogei.svildep.indirizziservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SoggettoDto extends SvildepDto{

    private String id;
    private String codiceFiscale;

}
