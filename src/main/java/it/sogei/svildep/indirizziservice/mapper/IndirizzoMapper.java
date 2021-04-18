package it.sogei.svildep.indirizziservice.mapper;

import it.sogei.svildep.indirizziservice.dto.IndirizzoDto;
import it.sogei.svildep.indirizziservice.model.*;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@NoArgsConstructor
public class IndirizzoMapper implements Mapper<Indirizzo, IndirizzoDto> {

    @Autowired
    SoggettoFisicoMapper soggettoFisicoMapper;
    @Autowired
    ComuneMapper comuneMapper;
    @Autowired
    StatoEsteroMapper statoEsteroMapper;

    @Override
    public Indirizzo mapDtoToEntityImpl(IndirizzoDto dto) throws RuntimeException {


        return Indirizzo.builder()
                .id(Long.parseLong(dto.getId()))
                .civico(dto.getCivico())
                .indirizzo(dto.getIndirizzo())
                .cap(dto.getCap())
                .dettaglio(dto.getDettaglio())
                .ripartizione(dto.getRipartizione())
                .tipoIndirizzo(TipoIndirizzo.builder().id(Long.parseLong(dto.getTipoIndirizzoId())).build())
                .soggettoFisico(soggettoFisicoMapper.mapDtoToEntityImpl(dto.getSoggettoFisicoDto()))
                .comune(comuneMapper.mapDtoToEntityImpl(dto.getComuneDto()))
                .statoEstero(statoEsteroMapper.mapDtoToEntity(dto.getStatoEstero())).build();
    }

    @Override
    public IndirizzoDto mapEntityToDtoImpl(Indirizzo entity) {

        return IndirizzoDto.builder().id(String.valueOf(entity.getId())).civico(entity.getCivico())
                .indirizzo(entity.getIndirizzo()).cap(entity.getCap()).dettaglio(entity.getDettaglio())
                .ripartizione(entity.getRipartizione()).tipoIndirizzoId(String.valueOf(entity.getTipoIndirizzo().getId()))
                .soggettoFisicoDto(soggettoFisicoMapper.mapEntityToDto(entity.getSoggettoFisico()))
                .comuneDto(comuneMapper.mapEntityToDtoImpl(entity.getComune()))
                .statoEstero(statoEsteroMapper.mapEntityToDtoImpl(entity.getStatoEstero()))
                .build();

    }
}
