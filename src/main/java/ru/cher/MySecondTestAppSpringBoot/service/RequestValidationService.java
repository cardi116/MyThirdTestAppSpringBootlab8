package ru.cher.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.cher.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.cher.MySecondTestAppSpringBoot.exception.ValidationFailedException;

@Service
public class RequestValidationService implements ValidationService {

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult.getFieldError().getDefaultMessage());
        }
    }

    @Override
    public void isCodeSupported(String uid) throws UnsupportedCodeException {
        if ("123".equals(uid)) {
            throw new UnsupportedCodeException("Неподдерживаемый код uid: 123");
        }
    }
}