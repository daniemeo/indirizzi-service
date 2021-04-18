package it.sogei.svildep.indirizziservice.model;

import it.sogei.svildep.indirizziservice.model.enums.FlagSN;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Getter
@Setter
@Entity
@Table(name = "D_SOGGETTI")
public class Soggetto extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "PK_SEQU_ID_SOGGETTO")
    private Long id;
    @Column(name = "CODI_CODICE_FISCALE")
    private String codiceFiscale;
    @Column(name = "FLAG_CERTIFICATO_AT_SN")
    @Enumerated(EnumType.STRING)
    private FlagSN certificatoAnagrafeTributaria;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK1_TIPI_SOGGETTO_SOGGETTI")
    private TipoSoggetto tipoSoggetto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK1_RECAPITI_SOGGETTI")
    private Recapito recapito;
}
