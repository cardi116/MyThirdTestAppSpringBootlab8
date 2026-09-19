package ru.cher.MySecondTestAppSpringBoot.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.cher.MySecondTestAppSpringBoot.model.Request;
import ru.cher.MySecondTestAppSpringBoot.model.Response;

@Service("ModifySourceRequestService")
public class ModifySourceRequestService implements ModifyRequestService {

    @Override
    public void modify(Request request) {
        request.setSource("Source 1");

        RestClient.create()
                .post()
                .uri("http://localhost:8084/feedback")
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .toEntity(Response.class);
    }
}