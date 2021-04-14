package it.sogei.svildep.indirizziservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FlagTipoSoggetto {

    TSF("Soggetto fisico"),
    TSG("Soggetto giuridico"),
    TSD("Ditta individuale");

    public String descrizione;
}