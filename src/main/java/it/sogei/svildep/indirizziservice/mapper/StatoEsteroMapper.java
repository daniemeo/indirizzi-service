package it.sogei.svildep.indirizziservice.mapper;

import it.sogei.svildep.indirizziservice.dto.StatoEsteroDto;
import it.sogei.svildep.indirizziservice.model.StatoEstero;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@NoArgsConstructor
public class StatoEsteroMapper implements Mapper<StatoEstero, StatoEsteroDto>{

    @Override
    public StatoEstero mapDtoToEntityImpl(StatoEsteroDto dto) throws RuntimeException {
        StatoEstero statoEstero = new StatoEstero();

        statoEstero.setId(Long.parseLong(dto.getId()));
        statoEstero.setDenominazioneStatoEstero(dto.getDenominazioneStatoEstero());

        return statoEstero;

    }

    @Override
    public StatoEsteroDto mapEntityToDtoImpl(StatoEstero entity) {
       StatoEsteroDto statoEsteroDto = new StatoEsteroDto();


       if(entity!= null) {
           statoEsteroDto.setId(String.valueOf(entity.getId()));
           statoEsteroDto.setDenominazioneStatoEstero(statoEsteroDto.getDenominazioneStatoEstero());
       }


       return statoEsteroDto;
    }
}
