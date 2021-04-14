package it.sogei.svildep.indirizziservice.service.external;

import it.sogei.svildep.indirizziservice.dto.IndirizzoDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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


}
