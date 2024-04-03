package com.tasktrace.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateLabelDto {

    @NotBlank(message = "Не должно быть пустым")
    private String name;

    public CreateLabelDto(String name) {
        this.name = name;
    }

    public CreateLabelDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
