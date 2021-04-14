package it.sogei.svildep.indirizziservice.mapper;

import it.sogei.svildep.indirizziservice.dto.SoggettoDto;
import it.sogei.svildep.indirizziservice.dto.SoggettoFisicoDto;
import it.sogei.svildep.indirizziservice.model.Soggetto;
import it.sogei.svildep.indirizziservice.model.SoggettoFisico;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@NoArgsConstructor

public class SoggettoMapper implements Mapper<Soggetto, SoggettoDto> {
    @Override
    public Soggetto mapDtoToEntityImpl(SoggettoDto dto) throws RuntimeException {
        Soggetto soggetto = new Soggetto();

        soggetto.setId(Long.parseLong(dto.getId()));
        soggetto.setCodiceFiscale(dto.getCodiceFiscale());

        return soggetto;
    }

    @Override
    public SoggettoDto mapEntityToDtoImpl(Soggetto entity) {
        SoggettoDto soggettoDto = new SoggettoDto();

        soggettoDto.setId(String.valueOf(entity.getId()));
        soggettoDto.setCodiceFiscale(entity.getCodiceFiscale());

        return soggettoDto;
    }
}
