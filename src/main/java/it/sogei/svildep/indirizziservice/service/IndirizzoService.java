package it.sogei.svildep.indirizziservice.service;

import it.sogei.svildep.indirizziservice.dto.AssociaDissociaIndirizzoDto;
import it.sogei.svildep.indirizziservice.dto.IndirizzoDto;
import it.sogei.svildep.indirizziservice.dto.InsertIndirizzoDto;
import it.sogei.svildep.indirizziservice.dto.MessageDto;
import it.sogei.svildep.indirizziservice.exception.Messages;
import it.sogei.svildep.indirizziservice.exception.SvildepException;
import it.sogei.svildep.indirizziservice.mapper.IndirizzoMapper;
import it.sogei.svildep.indirizziservice.mapper.InsertIndirizzoMapper;
import it.sogei.svildep.indirizziservice.model.Indirizzo;
import it.sogei.svildep.indirizziservice.model.SoggettoFisico;
import it.sogei.svildep.indirizziservice.repository.IndirizzoRepository;
import it.sogei.svildep.indirizziservice.repository.SoggettoFisicoRepository;
import it.sogei.svildep.indirizziservice.service.external.AnagrafeUnica;
import it.sogei.svildep.indirizziservice.service.external.PortaleServiziDag;
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
    private final SoggettoFisicoRepository soggettoFisicoRepository;
    private final IndirizzoMapper indirizzoMapper;
    private final AnagrafeUnica anagrafeUnica;
    private final PortaleServiziDag portaleServiziDag;
    private final InsertIndirizzoMapper insertIndirizzoMapper;


    public List<IndirizzoDto> findAllBySoggetto(Long id) {
        SoggettoFisico soggettoFisico = soggettoFisicoRepository.findById(id).orElse(null);
        if(soggettoFisico == null ){
            throw new SvildepException(Messages.soggettoInesistente, HttpStatus.BAD_REQUEST);
        }
        List<Indirizzo> listaIndirizzi = indirizzoRepository.findAllIndirizziBySoggettoFisico_id(id);
        return indirizzoMapper.mapEntityToDto(listaIndirizzi);
    }


    public MessageDto insertIndirizzo(InsertIndirizzoDto insertIndirizzoDto) throws SvildepException {
//        if(insertIndirizzoDto.getComuneId() ==  null && insertIndirizzoDto.getStatoEsteroId() == null){
//             return new MessageDto(Messages.erroreInserimento, HttpStatus.BAD_REQUEST);
//        }
        Indirizzo indirizzo =  insertIndirizzoMapper.mapDtoToEntity(insertIndirizzoDto);
        indirizzoRepository.save(indirizzo);
        anagrafeUnica.insertIndirizzo(insertIndirizzoDto);
        portaleServiziDag.comunicaCreazioneIndirizzo(insertIndirizzoDto);
        return new MessageDto(Messages.nuovoIndirizzo, HttpStatus.OK);

    }

    public MessageDto associaASoggetto(AssociaDissociaIndirizzoDto associaDissociaIndirizzoDto) throws SvildepException{
        Indirizzo indirizzo = indirizzoRepository.findById(Long.parseLong(associaDissociaIndirizzoDto.getIndirizzoId())).orElse(null);
        if(indirizzo == null ){
            throw new SvildepException(Messages.indirizzoInesistente, HttpStatus.BAD_REQUEST);
        }

        SoggettoFisico soggettoFisico = soggettoFisicoRepository.findById(Long.parseLong(associaDissociaIndirizzoDto.getSoggettoFisicoId())).orElse(null);
        if(soggettoFisico == null ){
            throw new SvildepException(Messages.soggettoInesistente, HttpStatus.BAD_REQUEST);
        }
        indirizzo.setSoggettoFisico(soggettoFisico);
        indirizzoRepository.save(indirizzo);

        return new MessageDto(Messages.operazioneEffettuata, HttpStatus.OK);
    }

    public List<IndirizzoDto> listaDaAnagrafe(){
        List<IndirizzoDto> listaIndirizzi = anagrafeUnica.listAllIndirizzi();
        return listaIndirizzi;
    }


    public MessageDto chiusuraAssociazione(AssociaDissociaIndirizzoDto associaDissociaIndirizzoDto) throws SvildepException{
        Indirizzo indirizzo = indirizzoRepository.findById(Long.parseLong(associaDissociaIndirizzoDto.getIndirizzoId())).orElse(null);
        if(indirizzo == null ){
            throw new SvildepException(Messages.indirizzoInesistente, HttpStatus.BAD_REQUEST);
        }

        indirizzo.setSoggettoFisico(null);
        indirizzoRepository.save(indirizzo);

        return new MessageDto(Messages.operazioneEffettuata, HttpStatus.OK);
    }



}
