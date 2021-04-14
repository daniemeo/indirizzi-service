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

public class ComuneMapper implements Mapper<Comune, ComuneDto>{

    @Override
    public Comune mapDtoToEntityImpl(ComuneDto dto) throws RuntimeException {
        Comune comune = new Comune();
        comune.setId(Long.parseLong(dto.getId()));
        comune.setSigla(dto.getSigla());
        comune.setDenominazioneComune(dto.getDenominazioneComune());
        comune.setDataInizioValidita(LocalDate.parse(dto.getDataInizioValidita()));
        comune.setDataFineValidita(LocalDate.parse(dto.getDataFineValidita()));
        comune.setComune(dto.getComune());

        Provincia provincia = new Provincia();
        provincia.setId(Long.parseLong(dto.getProvinciaId()));
        comune.setProvincia(provincia);

        return comune;
    }

    @Override
    public ComuneDto mapEntityToDtoImpl(Comune entity) {
        ComuneDto comuneDto = new ComuneDto();
        if(entity != null) {

            comuneDto.setId(String.valueOf(entity.getId()));
            comuneDto.setSigla(entity.getSigla());
            comuneDto.setDenominazioneComune(entity.getDenominazioneComune());
            comuneDto.setDataInizioValidita(String.valueOf(entity.getDataInizioValidita()));
            comuneDto.setDataFineValidita(String.valueOf(entity.getDataFineValidita()));
            comuneDto.setComune(comuneDto.getComune());
            comuneDto.setProvinciaId(String.valueOf(entity.getProvincia().getId()));
        }
        return comuneDto;
    }
}
