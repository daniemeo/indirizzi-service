package it.sogei.svildep.indirizziservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class SoggettoFisicoDto extends SvildepDto{

    private String id;
    private String nome;
    private String cognome;
    private String dataNascita;
    private SoggettoDto soggetto;



}
