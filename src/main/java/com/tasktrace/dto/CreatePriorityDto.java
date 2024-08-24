package com.tasktrace.dto;

import jakarta.validation.constraints.NotBlank;

public class CreatePriorityDto {

    @NotBlank(message = "Не должно быть пустым")
    private String name;

    public CreatePriorityDto(String name) {
        this.name = name;
    }

    public CreatePriorityDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
