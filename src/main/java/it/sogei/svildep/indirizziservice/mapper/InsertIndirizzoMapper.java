package it.sogei.svildep.indirizziservice.mapper;

import it.sogei.svildep.indirizziservice.dto.InsertIndirizzoDto;
import it.sogei.svildep.indirizziservice.model.Indirizzo;
import it.sogei.svildep.indirizziservice.model.SoggettoFisico;
import it.sogei.svildep.indirizziservice.model.StatoEstero;
import it.sogei.svildep.indirizziservice.model.TipoIndirizzo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@NoArgsConstructor
public class InsertIndirizzoMapper implements Mapper<Indirizzo, InsertIndirizzoDto>{

    @Autowired ComunePerInsertMapper comunePerInsertMapper;
    @Autowired StatoEsteroMapper statoEsteroMapper;

    @Override
    public Indirizzo mapDtoToEntityImpl(InsertIndirizzoDto dto) throws RuntimeException {
        Indirizzo indirizzo = new Indirizzo();

        indirizzo.setCivico(dto.getCivico());
        indirizzo.setIndirizzo(dto.getIndirizzo());
        indirizzo.setCap(dto.getCap());
        indirizzo.setDettaglio(dto.getDettaglio());
        indirizzo.setRipartizione(dto.getRipartizione());

        TipoIndirizzo tipoIndirizzo = new TipoIndirizzo();
        tipoIndirizzo.setId(Long.parseLong(dto.getTipoIndirizzoId()));
        indirizzo.setTipoIndirizzo(tipoIndirizzo);

        SoggettoFisico soggetto = new SoggettoFisico();
        soggetto.setId(Long.parseLong(dto.getSoggettoFisicoId()));
        indirizzo.setSoggettoFisico(soggetto);

        if(dto.getComuneDto() != null) {
            indirizzo.setComune(comunePerInsertMapper.mapDtoToEntity(dto.getComuneDto()));
        }

        if(dto.getStatoEsteroId() != null) {
            StatoEstero statoEstero = new StatoEstero();
            statoEstero.setId(Long.parseLong(dto.getStatoEsteroId()));
            indirizzo.setStatoEstero(statoEstero);
        }


        return indirizzo;
    }

    @Override
    public InsertIndirizzoDto mapEntityToDtoImpl(Indirizzo entity) {
       InsertIndirizzoDto insertIndirizzoDto = new InsertIndirizzoDto();

       insertIndirizzoDto.setCivico(entity.getCivico());
       insertIndirizzoDto.setIndirizzo(entity.getIndirizzo());
       insertIndirizzoDto.setCap(entity.getCap());
       insertIndirizzoDto.setDettaglio(entity.getDettaglio());
       insertIndirizzoDto.setRipartizione(entity.getRipartizione());

       insertIndirizzoDto.setComuneDto(comunePerInsertMapper.mapEntityToDto(entity.getComune()));

       insertIndirizzoDto.setStatoEsteroId(String.valueOf(entity.getStatoEstero().getId()));

       return insertIndirizzoDto;
    }
}
