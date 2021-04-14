package it.sogei.svildep.indirizziservice.service.external;

import org.springframework.web.client.RestTemplate;

public interface ExternalService {

    RestTemplate getRestTemplate();

    String getURL();
}
