package com.tasktrace.mapper;

import com.tasktrace.dto.StatusDto;
import com.tasktrace.model.Status;

public class StatusMapper {

    public static StatusDto toStatusDto(Status status) {
        return new StatusDto(status.getId(), status.getName());
    }
}
