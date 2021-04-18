package it.sogei.svildep.indirizziservice.mapper;

import it.sogei.svildep.indirizziservice.dto.InsertIndirizzoDto;
import it.sogei.svildep.indirizziservice.model.*;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
@NoArgsConstructor
public class InsertIndirizzoMapper implements Mapper<Indirizzo, InsertIndirizzoDto> {

    @Autowired
    StatoEsteroMapper statoEsteroMapper;

    @Override
    public Indirizzo mapDtoToEntityImpl(InsertIndirizzoDto dto) throws RuntimeException {
       return Indirizzo.builder()
                .civico(dto.getCivico())
                .indirizzo(dto.getIndirizzo())
                .cap(dto.getCap())
                .dettaglio(dto.getDettaglio())
                .ripartizione(dto.getRipartizione())
                .tipoIndirizzo(TipoIndirizzo.builder().id(Long.parseLong(dto.getTipoIndirizzoId())).build())
                .soggettoFisico(SoggettoFisico.builder().id(Long.parseLong(dto.getSoggettoFisicoId())).build())
                .comune(
                        Optional.ofNullable(dto.getComuneId())
                                .map(id -> Comune.builder().id(Long.parseLong(id)).build())
                                .orElse(null)
                )
                .statoEstero(
                        Optional.ofNullable(dto.getStatoEsteroId())
                        .map(id-> StatoEstero.builder().id(Long.parseLong(id)).build())
                        .orElse(null)
                )
                .build();

    }

    @Override
    public InsertIndirizzoDto mapEntityToDtoImpl(Indirizzo entity) {

        return InsertIndirizzoDto.builder().civico(entity.getCivico())
                .indirizzo(entity.getIndirizzo())
                .cap(entity.getCap())
                .dettaglio(entity.getDettaglio())
                .ripartizione(entity.getRipartizione())
                .comuneId(
                        Optional.ofNullable(entity.getComune().getId())
                        .map(String::valueOf)
                        .orElse(null)
                )
                .statoEsteroId(
                        Optional.ofNullable(entity.getStatoEstero().getId())
                        .map(String::valueOf)
                        .orElse(null)
                )
                .build();

    }
}
