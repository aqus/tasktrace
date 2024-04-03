package com.tasktrace.mapper;

import com.tasktrace.dto.StatusTransitionDto;
import com.tasktrace.model.StatusTransition;

public class StatusTransitionMapper {

    public static StatusTransitionDto toStatusTransitionDto(StatusTransition statusTransition) {
        return new StatusTransitionDto(statusTransition.getStatusId(), statusTransition.getTransitionStatusId());
    }
}
