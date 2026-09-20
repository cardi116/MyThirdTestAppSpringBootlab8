package ru.cher.MySecondTestAppSpringBoot.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.cher.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.cher.MySecondTestAppSpringBoot.model.*;
import ru.cher.MySecondTestAppSpringBoot.service.AnnualBonusService;
import ru.cher.MySecondTestAppSpringBoot.service.ValidationService;
import ru.cher.MySecondTestAppSpringBoot.util.DateTimeUtil;

import java.util.Date;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MyController {

    private final ValidationService validationService;
    private final AnnualBonusService annualBonusService;

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {
        log.info("request: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();

        try {
            validationService.isValid(bindingResult);
        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.error("Validation error: {}", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.error("Unknown error: {}", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (request.getPosition() != null && request.getSalary() != null
                && request.getBonus() != null && request.getWorkDays() != null) {
            double bonus = annualBonusService.calculate(
                    request.getPosition(),
                    request.getSalary(),
                    request.getBonus(),
                    request.getWorkDays()
            );
            response.setAnnualBonus(bonus);
        }

        log.info("response: {}", response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}