package it.sogei.svildep.indirizziservice.model;

import it.sogei.svildep.indirizziservice.model.enums.FlagSN;
import it.sogei.svildep.indirizziservice.model.enums.FlagSessoMF;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Getter
@Setter
@Entity
@Table(name = "D_SOGGETTI_FISICI")
public class SoggettoFisico extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "PK_SEQU_ID_SOGGETTO_FISICO")
    private Long id;
    @Column(name = "PERS_NOME")
    private String nome;
    @Column(name = "PERS_COGNOME")
    private String cognome;
    @Column(name = "DATA_NASCITA")
    private LocalDate dataNascita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK1_COMUNI_SOGGETTI_FISICI")
    private Comune comuneNascita;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK1_STATI_ESTERI_SOGGETTI_FISICI")
    private StatoEstero statoEsteroNascita;

    @Column(name = "FLAG_SESSO_MF")
    @Enumerated(EnumType.STRING)
    private FlagSessoMF flagSessoMF;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK1_SOGGETTI_SOGGETTI_FISICI")
    private Soggetto soggetto;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK1_SOGGETTI_GIURIDICI_SOGGETTI_FISICI")
    private SoggettoGiuridico soggettoGiuridico;




}
