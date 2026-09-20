package ru.cher.MySecondTestAppSpringBoot.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    /**
     * Уникальный идентификатор сообщения
     */
    @NotBlank(message = "UID не может быть пустым")
    @Size(max = 32, message = "UID должен содержать не более 32 символов")
    private String uid;

    /**
     * Уникальный идентификатор операции
     */
    @NotBlank(message = "Operation UID не может быть пустым")
    @Size(max = 32, message = "Operation UID должен содержать не более 32 символов")
    private String operationUid;

    /**
     * Имя системы-источника
     */
    private Systems systemName;

    /**
     * Время отправки сообщения
     */
    @NotBlank(message = "System Time не может быть пустым")
    private String systemTime;

    /**
     * Источник запроса
     */
    private String source;

    /**
     * Должность сотрудника
     */
    private Positions position;

    /**
     * Заработная плата сотрудника
     */
    private Double salary;

    /**
     * Коэффициент бонуса
     */
    private Double bonus;

    /**
     * Количество отработанных дней
     */
    private Integer workDays;

    /**
     * Идентификатор коммуникации
     */
    @Min(value = 1, message = "Communication ID должен быть от 1 до 2147483647")
    @Max(value = 2147483647, message = "Communication ID должен быть от 1 до 2147483647")
    private Integer communicationId;

    /**
     * Идентификатор шаблона
     */
    private Integer templateId;

    /**
     * Код продукта
     */
    private Integer productCode;

    /**
     * СМС-код для подтверждения
     */
    private Integer smsCode;
}