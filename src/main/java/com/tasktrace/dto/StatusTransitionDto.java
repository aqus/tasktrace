package com.tasktrace.dto;

public class StatusTransitionDto {

    private final Long statusId;

    private final Long transitionStatusId;

    public StatusTransitionDto(Long statusId, Long transitionStatusId) {
        this.statusId = statusId;
        this.transitionStatusId = transitionStatusId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public Long getTransitionStatusId() {
        return transitionStatusId;
    }
}
