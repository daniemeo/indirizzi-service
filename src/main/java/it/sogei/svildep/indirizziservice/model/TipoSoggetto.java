package it.sogei.svildep.indirizziservice.model;

import it.sogei.svildep.indirizziservice.model.enums.FlagTipoSoggetto;
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
@Table(name = "D_TIPI_SOGGETTO")
public class TipoSoggetto extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "PK_SEQU_ID_TIPO_SOGGETTO")
    private Long id;
    @Column(name = "DESC_DESCRIZIONE_TIPO_SOGGETTO")
    private String descrizioneTipoSoggetto;
    @Column(name = "CODI_CODICE_TIPO_SOGGETTO")
    @Enumerated(EnumType.STRING)
    private FlagTipoSoggetto codiceTipo;
}
