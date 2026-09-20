package ru.cher.MySecondTestAppSpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    /**
     * Идентификатор сообщения
     */
    private String uid;

    /**
     * Идентификатор операции
     */
    private String operationUid;

    /**
     * Время формирования ответа
     */
    private String systemTime;

    /**
     * Код результата операции
     */
    private Codes code;

    /**
     * Код ошибки (при наличии)
     */
    private ErrorCodes errorCode;

    /**
     * Сообщение об ошибке (при наличии)
     */
    private ErrorMessages errorMessage;

    /**
     * Рассчитанный размер годовой премии
     */
    private Double annualBonus;
}