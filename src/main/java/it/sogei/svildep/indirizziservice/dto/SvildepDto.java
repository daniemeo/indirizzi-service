package it.sogei.svildep.indirizziservice.dto;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor

public abstract class SvildepDto {
    private String utenteInserimentoId;

    private String timestampInserimento;

    private String utenteAggiornamentoId;

    private String timestampAggiornamento;
}
