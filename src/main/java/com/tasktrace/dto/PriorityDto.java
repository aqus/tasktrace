package com.tasktrace.dto;

public class PriorityDto {

    private final Long id;

    private final String name;

    public PriorityDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
