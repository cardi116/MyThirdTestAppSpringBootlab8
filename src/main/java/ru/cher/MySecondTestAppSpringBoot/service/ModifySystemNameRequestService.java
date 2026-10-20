package ru.cher.MySecondTestAppSpringBoot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.cher.MySecondTestAppSpringBoot.model.Request;

@Service
@Qualifier("ModifySystemNameRequestService")
public class ModifySystemNameRequestService implements ModifyRequestService {

    private static final Logger log = LoggerFactory.getLogger(ModifySystemNameRequestService.class);

    private final RestTemplate restTemplate;

    public ModifySystemNameRequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void modify(Request request) {
        request.setSystemName("Service 1");

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        log.info("Sending request to Service 2: {}", request);

        try {
            restTemplate.exchange(
                    "http://localhost:8084/feedback",
                    HttpMethod.POST,
                    httpEntity,
                    new ParameterizedTypeReference<>() {}
            );
        } catch (Exception e) {
            log.error("Error sending request to Service 2: {}", e.getMessage());
        }
    }
}