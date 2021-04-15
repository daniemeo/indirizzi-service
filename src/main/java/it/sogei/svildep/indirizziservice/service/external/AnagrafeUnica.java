package it.sogei.svildep.indirizziservice.service.external;

import it.sogei.svildep.indirizziservice.dto.IndirizzoDto;
import it.sogei.svildep.indirizziservice.dto.InsertIndirizzoDto;
import it.sogei.svildep.indirizziservice.dto.MessageDto;
import it.sogei.svildep.indirizziservice.exception.Messages;
import it.sogei.svildep.indirizziservice.exception.SvildepException;
import it.sogei.svildep.indirizziservice.model.Indirizzo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class AnagrafeUnica implements ExternalService {

    private final RestTemplate restTemplate;

    @Value("${anagrafe-service-url}")
    private String URL;

    @Value("${anagrafe-service-indirizzi-path}")
    private String PATH_INDIRIZZI;

    public List<IndirizzoDto> listAllIndirizzi() {

        return null;
    }

    public MessageDto insertIndirizzo(InsertIndirizzoDto insertIndirizzoDto){
        MessageDto response;
     //  response = getRestTemplate().exchange(getURL() + "/nuovoIndirizzo", HttpMethod.POST, new HttpEntity<>(indirizzo), MessageDto.class).getBody();
        response = new MessageDto(Messages.nuovoIndirizzo, HttpStatus.OK);
        if (response.isError()) throw new SvildepException(response);
        return response;
    }


}
