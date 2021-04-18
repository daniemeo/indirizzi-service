package it.sogei.svildep.indirizziservice.mapper;

import it.sogei.svildep.indirizziservice.dto.SoggettoFisicoDto;
import it.sogei.svildep.indirizziservice.model.SoggettoFisico;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Primary
@NoArgsConstructor
public class SoggettoFisicoMapper implements Mapper<SoggettoFisico, SoggettoFisicoDto> {

    @Autowired private SoggettoMapper soggettoMapper;

    @Override
    public SoggettoFisico mapDtoToEntityImpl(SoggettoFisicoDto dto) throws RuntimeException {

        return SoggettoFisico.builder()
                .id(Long.parseLong(dto.getId()))
                .nome(dto.getNome())
                .cognome(dto.getCognome())
                .dataNascita(LocalDate.parse(dto.getDataNascita()))
                .soggetto(soggettoMapper.mapDtoToEntityImpl(dto.getSoggetto()))
                .build();

    }

    @Override
    public SoggettoFisicoDto mapEntityToDtoImpl(SoggettoFisico entity) {

        return SoggettoFisicoDto.builder()
                .id(String.valueOf(entity.getId()))
                .nome(entity.getCognome())
                .dataNascita(String.valueOf(entity.getDataNascita()))
                .soggetto(soggettoMapper.mapEntityToDtoImpl(entity.getSoggetto()))
                .build();
    }
}
