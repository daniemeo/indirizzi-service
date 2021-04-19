package it.sogei.svildep.indirizziservice.mapper;

import it.sogei.svildep.indirizziservice.dto.SoggettoDto;
import it.sogei.svildep.indirizziservice.model.Soggetto;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@NoArgsConstructor

public class SoggettoMapper implements Mapper<Soggetto, SoggettoDto> {
    @Override
    public Soggetto mapDtoToEntityImpl(SoggettoDto dto) throws RuntimeException {
        return Soggetto.builder()
                .id(Long.parseLong(dto.getId()))
                .codiceFiscale(dto.getCodiceFiscale())
                .build();

    }

    @Override
    public SoggettoDto mapEntityToDtoImpl(Soggetto entity) {
        return SoggettoDto.builder()
                .id(String.valueOf(entity.getId()))
                .codiceFiscale(entity.getCodiceFiscale())
                .build();
    }
}
