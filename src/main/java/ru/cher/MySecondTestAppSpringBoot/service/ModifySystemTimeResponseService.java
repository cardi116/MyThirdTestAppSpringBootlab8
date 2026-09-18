package ru.cher.MySecondTestAppSpringBoot.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.cher.MySecondTestAppSpringBoot.model.Response;
import ru.cher.MySecondTestAppSpringBoot.util.DateTimeUtil;

import java.lang.module.ResolutionException;
import java.util.Date;

@Service
@Qualifier("ModifySystemTimeResponseService")

public class ModifySystemTimeResponseService implements ModifyResponseService {
    @Override
    public Response modify(Response response) {
        response.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));

        return response;
    }

}
