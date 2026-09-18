package ru.cher.MySecondTestAppSpringBoot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import ru.cher.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.cher.MySecondTestAppSpringBoot.exception.ValidationFailedException;

@Slf4j
@Service
public class RequestValidationService implements ValidationService {

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()) {
            // Вывод сообщений из bindingResult с уровнем ERROR
            for (FieldError error : bindingResult.getFieldErrors()) {
                log.error("Ошибка валидации в поле '{}': {}", error.getField(), error.getDefaultMessage());
            }
            throw new ValidationFailedException(bindingResult.getFieldError().getDefaultMessage());
        }
    }

    @Override
    public void isCodeSupported(String uid) throws UnsupportedCodeException {
        if ("123".equals(uid)) {
            // Вывод лога ERROR перед выбросом исключения
            log.error("Обнаружен неподдерживаемый uid: {}", uid);
            throw new UnsupportedCodeException("Неподдерживаемый код uid: 123");
        }
    }
}