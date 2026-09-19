package ru.cher.MySecondTestAppSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Systems {
    ERP("Enterprise Resource Planning"),
    CRM("Customer Relationship Management"),
    WMS("Warehouse Management System"),
    SERVICE_1("Service 1");

    private final String name;

    Systems(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static Systems fromValue(String value) {
        if (value == null) {
            return null;
        }
        for (Systems system : values()) {
            if (system.name.equalsIgnoreCase(value) || system.name().equalsIgnoreCase(value)) {
                return system;
            }
        }
        throw new IllegalArgumentException("Unknown system: " + value);
    }
}