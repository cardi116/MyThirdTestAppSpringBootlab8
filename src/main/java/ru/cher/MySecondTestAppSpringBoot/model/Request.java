package ru.cher.MySecondTestAppSpringBoot.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Request {

    @NotBlank
    @Size(max = 32)
    private String uid;

    @NotBlank
    @Size(max = 32)
    private String operationUid;

    private String systemName;
    private String systemTime;
    private String source;
    private Positions position;
    private Double salary;
    private Double bonus;
    private Integer workDays;
    private Integer communicationId;

    public Request() {
    }

    public Request(String uid, String operationUid, String systemName, String systemTime, String source, Positions position, Double salary, Double bonus, Integer workDays, Integer communicationId) {
        this.uid = uid;
        this.operationUid = operationUid;
        this.systemName = systemName;
        this.systemTime = systemTime;
        this.source = source;
        this.position = position;
        this.salary = salary;
        this.bonus = bonus;
        this.workDays = workDays;
        this.communicationId = communicationId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String uid;
        private String operationUid;
        private String systemName;
        private String systemTime;
        private String source;
        private Positions position;
        private Double salary;
        private Double bonus;
        private Integer workDays;
        private Integer communicationId;

        public Builder uid(String uid) { this.uid = uid; return this; }
        public Builder operationUid(String operationUid) { this.operationUid = operationUid; return this; }
        public Builder systemName(String systemName) { this.systemName = systemName; return this; }
        public Builder systemTime(String systemTime) { this.systemTime = systemTime; return this; }
        public Builder source(String source) { this.source = source; return this; }
        public Builder position(Positions position) { this.position = position; return this; }
        public Builder salary(Double salary) { this.salary = salary; return this; }
        public Builder bonus(Double bonus) { this.bonus = bonus; return this; }
        public Builder workDays(Integer workDays) { this.workDays = workDays; return this; }
        public Builder communicationId(Integer communicationId) { this.communicationId = communicationId; return this; }

        public Request build() {
            return new Request(uid, operationUid, systemName, systemTime, source, position, salary, bonus, workDays, communicationId);
        }
    }

    public String getUid() { return uid; }
    public void setUid(String uid) { this.uid = uid; }

    public String getOperationUid() { return operationUid; }
    public void setOperationUid(String operationUid) { this.operationUid = operationUid; }

    public String getSystemName() { return systemName; }
    public void setSystemName(String systemName) { this.systemName = systemName; }

    public String getSystemTime() { return systemTime; }
    public void setSystemTime(String systemTime) { this.systemTime = systemTime; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public Positions getPosition() { return position; }
    public void setPosition(Positions position) { this.position = position; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public Double getBonus() { return bonus; }
    public void setBonus(Double bonus) { this.bonus = bonus; }

    public Integer getWorkDays() { return workDays; }
    public void setWorkDays(Integer workDays) { this.workDays = workDays; }

    public Integer getCommunicationId() { return communicationId; }
    public void setCommunicationId(Integer communicationId) { this.communicationId = communicationId; }
}