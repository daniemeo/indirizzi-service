package it.sogei.svildep.indirizziservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    public abstract Long getId();

    public abstract void setId(Long id);

    @Column(name = "NUME_ID_UTENTE_INSERIMENTO")
    private Long idUtenteInserimento;
    @Column(name = "DTTM_TIMESTAMP_INSERIMENTO")
    private LocalDateTime timestampInserimento;
    @Column(name = "NUME_ID_UTENTE_AGGIORNAMENTO")
    private Long idUtenteAggiornamento;
    @Column(name = "DTTM_TIMESTAMP_AGGIORNAMENTO")
    private LocalDateTime timestampAggiornamento;
}