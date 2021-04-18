package it.sogei.svildep.indirizziservice.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Getter
@Setter
@Entity
@Table(name = "D_REGIONI")
public class Regione extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "PK_SEQU_ID_REGIONE")
    private Long id;
    @Column(name = "DESC_DENOMINAZIONE_REGIONE")
    private String denominazioneRegione;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "regione")
    private Set<Provincia> listaProvince;
}