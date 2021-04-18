package it.sogei.svildep.indirizziservice.mapper;

import it.sogei.svildep.indirizziservice.dto.ComuneDto;
import it.sogei.svildep.indirizziservice.dto.InsertIndirizzoDto;
import it.sogei.svildep.indirizziservice.model.Comune;
import it.sogei.svildep.indirizziservice.model.Indirizzo;
import it.sogei.svildep.indirizziservice.model.Provincia;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Primary
@NoArgsConstructor

public class ComuneMapper implements Mapper<Comune, ComuneDto> {

    @Override
    public Comune mapDtoToEntityImpl(ComuneDto dto) throws RuntimeException {
        return Comune.builder().id(Long.parseLong(dto.getId())).sigla(dto.getSigla()).
                denominazioneComune(dto.getDenominazioneComune()).
                dataInizioValidita(LocalDate.parse(dto.getDataInizioValidita())).
                dataFineValidita(LocalDate.parse(dto.getDataFineValidita())).comune(dto.getComune()).
                provincia(Provincia.builder().id(Long.parseLong(dto.getProvinciaId())).build()).build();
    }

    @Override
    public ComuneDto mapEntityToDtoImpl(Comune entity) {

        if (entity != null) {
            return ComuneDto.builder()
                    .id(String.valueOf(entity.getId()))
                    .sigla(entity.getSigla())
                    .denominazioneComune(entity.getDenominazioneComune())
                    .dataInizioValidita(String.valueOf(entity.getDataInizioValidita()))
                    .dataFineValidita(String.valueOf(entity.getDataFineValidita()))
                    .comune(entity.getComune())
                    .provinciaId(String.valueOf(entity.getProvincia().getId())).
                    build();
        }
        return null;
    }
}
