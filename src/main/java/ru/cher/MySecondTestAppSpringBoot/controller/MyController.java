package ru.cher.MySecondTestAppSpringBoot.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.cher.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.cher.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.cher.MySecondTestAppSpringBoot.model.Codes;
import ru.cher.MySecondTestAppSpringBoot.model.ErrorCodes;
import ru.cher.MySecondTestAppSpringBoot.model.ErrorMessages;
import ru.cher.MySecondTestAppSpringBoot.model.Request;
import ru.cher.MySecondTestAppSpringBoot.model.Response;
import ru.cher.MySecondTestAppSpringBoot.service.ModifyResponseService;
import ru.cher.MySecondTestAppSpringBoot.service.ValidationService;
import ru.cher.MySecondTestAppSpringBoot.util.DateTimeUtil;

import java.util.Date;

@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;

    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService) {
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult) {

        log.info("Received request: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();

        log.info("Initial response created: {}", response);

        try {
            validationService.isValid(bindingResult);
            validationService.isCodeSupported(request.getUid());
        } catch (ValidationFailedException e) {
            log.error("Handling ValidationFailedException: {}", e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.info("Response updated after validation failure: {}", response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException e) {
            log.error("Handling UnsupportedCodeException: {}", e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            log.info("Response updated after unsupported code error: {}", response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Handling unexpected exception: ", e);
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.info("Response updated after unknown error: {}", response);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Response modifiedResponse = modifyResponseService.modify(response);
        log.info("Response modified by service: {}", modifiedResponse);

        return new ResponseEntity<>(modifiedResponse, HttpStatus.OK);
    }
}