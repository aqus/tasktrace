package com.tasktrace.mapper;

import com.tasktrace.dto.PriorityDto;
import com.tasktrace.model.Priority;

public class PriorityMapper {

    public static PriorityDto toPriorityDto(Priority priority) {
        return new PriorityDto(priority.getId(), priority.getName());
    }
}
