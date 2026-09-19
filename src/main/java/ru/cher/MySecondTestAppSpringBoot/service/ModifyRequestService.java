package ru.cher.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.cher.MySecondTestAppSpringBoot.model.Request;

@Service
public interface ModifyRequestService {
    void modify(Request request);
}