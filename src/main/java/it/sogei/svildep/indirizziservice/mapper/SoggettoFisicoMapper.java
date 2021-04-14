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
        SoggettoFisico soggettoFisico = new SoggettoFisico();

        soggettoFisico.setId(Long.parseLong(dto.getId()));
        soggettoFisico.setNome(dto.getNome());
        soggettoFisico.setCognome(dto.getCognome());
        soggettoFisico.setDataNascita(LocalDate.parse(dto.getDataNascita()));
        soggettoFisico.setSoggetto(soggettoMapper.mapDtoToEntityImpl(dto.getSoggetto()));

        return soggettoFisico;
    }

    @Override
    public SoggettoFisicoDto mapEntityToDtoImpl(SoggettoFisico entity) {
        SoggettoFisicoDto soggettoFisicoDto = new SoggettoFisicoDto();

        soggettoFisicoDto.setId(String.valueOf(entity.getId()));
        soggettoFisicoDto.setNome(entity.getNome());
        soggettoFisicoDto.setCognome(entity.getCognome());
        soggettoFisicoDto.setDataNascita(String.valueOf(entity.getDataNascita()));
        soggettoFisicoDto.setSoggetto(soggettoMapper.mapEntityToDtoImpl(entity.getSoggetto()));

        return soggettoFisicoDto;
    }
}
