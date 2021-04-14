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

@Autowired SoggettoFisicoMapper soggettoFisicoMapper;
@Autowired ComuneMapper comuneMapper;
@Autowired StatoEsteroMapper statoEsteroMapper;

    @Override
    public Indirizzo mapDtoToEntityImpl(IndirizzoDto dto) throws RuntimeException {


        Indirizzo indirizzo = new Indirizzo();

        indirizzo.setId(Long.parseLong(dto.getId()));
        indirizzo.setCivico(dto.getCivico());
        indirizzo.setIndirizzo(dto.getIndirizzo());
        indirizzo.setCap(dto.getCap());
        indirizzo.setDettaglio(dto.getDettaglio());
        indirizzo.setRipartizione(dto.getRipartizione());

        TipoIndirizzo tipoIndirizzo = new TipoIndirizzo();
        tipoIndirizzo.setId(Long.parseLong(dto.getTipoIndirizzoId()));
        indirizzo.setTipoIndirizzo(tipoIndirizzo);

        indirizzo.setSoggettoFisico(soggettoFisicoMapper.mapDtoToEntityImpl(dto.getSoggettoFisicoDto()));

        indirizzo.setComune(comuneMapper.mapDtoToEntityImpl(dto.getComuneDto()));

        indirizzo.setStatoEstero(statoEsteroMapper.mapDtoToEntity(dto.getStatoEstero()));

        return indirizzo;
    }

    @Override
    public IndirizzoDto mapEntityToDtoImpl(Indirizzo entity) {

        IndirizzoDto indirizzoDto = new IndirizzoDto();

        indirizzoDto.setId(String.valueOf(entity.getId()));
        indirizzoDto.setCivico(entity.getCivico());
        indirizzoDto.setIndirizzo(entity.getIndirizzo());
        indirizzoDto.setCap(entity.getCap());
        indirizzoDto.setDettaglio(entity.getDettaglio());
        indirizzoDto.setRipartizione(entity.getRipartizione());
        indirizzoDto.setTipoIndirizzoId(String.valueOf(entity.getTipoIndirizzo().getId()));

        indirizzoDto.setSoggettoFisicoDto(soggettoFisicoMapper.mapEntityToDto(entity.getSoggettoFisico()));

        indirizzoDto.setComuneDto(comuneMapper.mapEntityToDtoImpl(entity.getComune()));

        indirizzoDto.setStatoEstero(statoEsteroMapper.mapEntityToDtoImpl(entity.getStatoEstero()));

        return indirizzoDto;
    }
}
