package it.sogei.svildep.indirizziservice.mapper;

import it.sogei.svildep.indirizziservice.dto.ComunePerInsertDto;
import it.sogei.svildep.indirizziservice.dto.InsertIndirizzoDto;
import it.sogei.svildep.indirizziservice.model.Comune;
import it.sogei.svildep.indirizziservice.model.Indirizzo;
import it.sogei.svildep.indirizziservice.model.Provincia;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@NoArgsConstructor
public class ComunePerInsertMapper implements Mapper<Comune, ComunePerInsertDto> {

    @Override
    public Comune mapDtoToEntityImpl(ComunePerInsertDto dto) throws RuntimeException {
        Comune comune = new Comune();
        comune.setId(Long.parseLong(dto.getId()));

        Provincia provincia = new Provincia();
        provincia.setId(Long.parseLong(dto.getProvinciaId()));
        comune.setProvincia(provincia);

        return comune;

    }

    @Override
    public ComunePerInsertDto mapEntityToDtoImpl(Comune entity) {

        ComunePerInsertDto comuneDto = new ComunePerInsertDto();

        comuneDto.setId(String.valueOf(entity.getId()));
        comuneDto.setProvinciaId(String.valueOf(entity.getProvincia().getId()));

        return comuneDto;
    }
}
