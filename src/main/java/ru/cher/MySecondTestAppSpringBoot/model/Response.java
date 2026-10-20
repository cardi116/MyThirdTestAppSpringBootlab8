package ru.cher.MySecondTestAppSpringBoot.model;

public class Response {

    private String uid;
    private String operationUid;
    private String systemTime;
    private String code;
    private Double annualBonus;

    public Response() {
    }

    public Response(String uid, String operationUid, String systemTime, String code, Double annualBonus) {
        this.uid = uid;
        this.operationUid = operationUid;
        this.systemTime = systemTime;
        this.code = code;
        this.annualBonus = annualBonus;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String uid;
        private String operationUid;
        private String systemTime;
        private String code;
        private Double annualBonus;

        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }

        public Builder operationUid(String operationUid) {
            this.operationUid = operationUid;
            return this;
        }

        public Builder systemTime(String systemTime) {
            this.systemTime = systemTime;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder annualBonus(Double annualBonus) {
            this.annualBonus = annualBonus;
            return this;
        }

        public Response build() {
            return new Response(uid, operationUid, systemTime, code, annualBonus);
        }
    }

    public String getUid() { return uid; }
    public void setUid(String uid) { this.uid = uid; }

    public String getOperationUid() { return operationUid; }
    public void setOperationUid(String operationUid) { this.operationUid = operationUid; }

    public String getSystemTime() { return systemTime; }
    public void setSystemTime(String systemTime) { this.systemTime = systemTime; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Double getAnnualBonus() { return annualBonus; }
    public void setAnnualBonus(Double annualBonus) { this.annualBonus = annualBonus; }
}