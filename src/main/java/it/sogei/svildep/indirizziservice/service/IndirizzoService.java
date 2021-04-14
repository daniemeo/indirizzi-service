package it.sogei.svildep.indirizziservice.service;

import it.sogei.svildep.indirizziservice.dto.IndirizzoDto;
import it.sogei.svildep.indirizziservice.dto.InsertIndirizzoDto;
import it.sogei.svildep.indirizziservice.dto.MessageDto;
import it.sogei.svildep.indirizziservice.exception.Messages;
import it.sogei.svildep.indirizziservice.exception.SvildepException;
import it.sogei.svildep.indirizziservice.mapper.IndirizzoMapper;
import it.sogei.svildep.indirizziservice.mapper.InsertIndirizzoMapper;
import it.sogei.svildep.indirizziservice.model.Indirizzo;
import it.sogei.svildep.indirizziservice.repository.IndirizzoRepository;
import it.sogei.svildep.indirizziservice.service.external.AnagrafeUnica;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@RequiredArgsConstructor
public class IndirizzoService {

    private final IndirizzoRepository indirizzoRepository;
    private final IndirizzoMapper indirizzoMapper;
    private final AnagrafeUnica anagrafeUnica;
    private final InsertIndirizzoMapper insertIndirizzoMapper;

    public List<IndirizzoDto> getAll() {
        List<Indirizzo> listaIndirizzi = indirizzoRepository.findAllEager();
        return indirizzoMapper.mapEntityToDto(listaIndirizzi);
    }

    public List<IndirizzoDto> listaDaAnagrafe(){
        List<IndirizzoDto> listaIndirizzi = anagrafeUnica.listAllIndirizzi();
        return listaIndirizzi;
    }

    public MessageDto insertIndirizzo(InsertIndirizzoDto insertIndirizzoDto) throws SvildepException {
        Indirizzo indirizzo =  insertIndirizzoMapper.mapDtoToEntity(insertIndirizzoDto);
        indirizzoRepository.save(indirizzo);
        return new MessageDto(Messages.nuovoIndirizzo, HttpStatus.OK);
    }

}
