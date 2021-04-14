package it.sogei.svildep.indirizziservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComunePerInsertDto extends SvildepDto{

    private String id;
    private String provinciaId;
}
