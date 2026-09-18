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

    @NotBlank(message = "uid не может быть пустым")
    @Size(max = 32, message = "uid не должен превышать 32 символа")
    private String uid;

    @NotBlank(message = "operationUid не может быть пустым")
    @Size(max = 32, message = "operationUid не должен превышать 32 символа")
    private String operationUid;

    private Systems systemName; // Заменено с String на enum Systems

    @NotBlank(message = "systemTime не может быть пустым")
    private String systemTime;

    private String source;

    @Min(value = 1, message = "communicationId должен быть не менее 1")
    @Max(value = 100000, message = "communicationId должен быть не более 100000")
    private int communicationId;

    private Integer templateId;
    private Integer productCode;
    private Integer smsCode;

    @Override
    public String toString() {
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId=" + communicationId +
                ", templateId=" + templateId +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                '}';
    }
}