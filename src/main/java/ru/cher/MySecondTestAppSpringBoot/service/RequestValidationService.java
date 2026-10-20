package ru.cher.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.cher.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.cher.MySecondTestAppSpringBoot.exception.ValidationFailedException;

import java.util.Objects;

@Service
public class RequestValidationService implements ValidationService {

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(
                    bindingResult.getFieldError() != null
                            ? Objects.requireNonNull(bindingResult.getFieldError().getDefaultMessage())
                            : "Validation error"
            );
        }
    }

    @Override
    public void isCodeSupported(String uid) throws UnsupportedCodeException {
        if ("123".equals(uid)) {
            throw new UnsupportedCodeException("Код 123 не поддерживается");
        }
    }
}