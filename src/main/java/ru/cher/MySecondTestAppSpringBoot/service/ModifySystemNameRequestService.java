package ru.cher.MySecondTestAppSpringBoot.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.cher.MySecondTestAppSpringBoot.model.Request;
import ru.cher.MySecondTestAppSpringBoot.model.Response;
import ru.cher.MySecondTestAppSpringBoot.model.Systems; // импортируем enum Systems

@Service("modifySystemNameRequestService")
public class ModifySystemNameRequestService implements ModifyRequestService {

    @Override
    public void modify(Request request) {
        request.setSystemName(Systems.SERVICE_1);

        RestClient.create()
                .post()
                .uri("http://localhost:8084/feedback")
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .toEntity(Response.class);
    }
}