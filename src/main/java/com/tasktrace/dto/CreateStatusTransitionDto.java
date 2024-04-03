package com.tasktrace.dto;

public class CreateStatusTransitionDto {

    private Long statusId;

    private Long transitionStatusId;

    public CreateStatusTransitionDto(Long statusId, Long transitionStatusId) {
        this.statusId = statusId;
        this.transitionStatusId = transitionStatusId;
    }

    public CreateStatusTransitionDto() {
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getTransitionStatusId() {
        return transitionStatusId;
    }

    public void setTransitionStatusId(Long transitionStatusId) {
        this.transitionStatusId = transitionStatusId;
    }
}
