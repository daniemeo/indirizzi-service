package it.sogei.svildep.indirizziservice.service.external;

import it.sogei.svildep.indirizziservice.dto.InsertIndirizzoDto;
import it.sogei.svildep.indirizziservice.dto.MessageDto;
import it.sogei.svildep.indirizziservice.exception.Messages;
import it.sogei.svildep.indirizziservice.exception.SvildepException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Getter
@RequiredArgsConstructor
public class PortaleServiziDag implements ExternalService {

    private final RestTemplate restTemplate;

    @Override
    public String getURL() { return "http://localhost:8080/svildep/api/portaleServiziDag"; }

//    public MessageDto comunicaChiusuraAbilitazione(AbilitazioneDto abilitazioneDto) throws SvildepException {
//        MessageDto response;
//        // response = getRestTemplate().exchange(getURL() + "/chiusuraAbilitazione", HttpMethod.POST, new HttpEntity<>(abilitazioneDto), MessageDto.class).getBody();
//        response = new MessageDto(Messages.comunicaChiusuraAbilitazione, HttpStatus.OK);
//        if (response.isError()) throw new SvildepException(response);
//        return response;
//    }

    public MessageDto comunicaCreazioneIndirizzo(InsertIndirizzoDto insertIndirizzoDto) throws SvildepException {
        MessageDto response;
        // response = getRestTemplate().exchange(getURL() + "/aperturaIndirizzo", HttpMethod.POST, new HttpEntity<>(insertIndirizzoDto), MessageDto.class).getBody();
        response = new MessageDto(Messages.nuovoIndirizzo, HttpStatus.OK);
        if (response.isError()) throw new SvildepException(response);
        return response;
    }


}