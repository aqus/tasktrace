package com.tasktrace.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateStatusDto {

    @NotBlank(message = "Не должно быть пустым")
    private String name;

    public CreateStatusDto(String name) {
        this.name = name;
    }

    public CreateStatusDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
