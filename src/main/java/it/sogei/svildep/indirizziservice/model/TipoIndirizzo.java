package it.sogei.svildep.indirizziservice.model;

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
@Table(name = "D_TIPI_INDIRIZZO")
public class TipoIndirizzo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "PK_SEQU_ID_TIPO_INDIRIZZO")
    private Long id;

    @Column(name = "DESC_DESCRIZIONE_TIPO_INDIRIZZO")
    private String descrizioneTipoIndirizzo;
}
