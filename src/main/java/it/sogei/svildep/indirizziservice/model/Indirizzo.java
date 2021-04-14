package it.sogei.svildep.indirizziservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;



    @EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
    @Getter @Setter
    @Entity
    @Table(name = "D_INDIRIZZI")
    public class Indirizzo extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        @Column(name = "PK_SEQU_ID_INDIRIZZO")
        private Long id;
        @Column(name = "NUME_CIVICO")
        private String civico;
        @Column(name = "INDI_INDIRIZZO")
        private String indirizzo;
        @Column(name = "INDI_CAP")
        private String cap;
        @Column(name = "INDI_DETTAGLIO")
        private String dettaglio;
        @Column(name = "INDI_RIPARTIZIONE")
        private String ripartizione;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "FK1_TIPI_INDIRIZZO_INDIRIZZI")
        private TipoIndirizzo tipoIndirizzo;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "FK1_SOGGETTI_FISICI_INDIRIZZI")
        @JsonIgnore
        private SoggettoFisico soggettoFisico;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "FK1_COMUNI_INDIRIZZI")
        private Comune comune;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "FK1_STATI_ESTERI_INDIRIZZI")
        private StatoEstero statoEstero;
    }





