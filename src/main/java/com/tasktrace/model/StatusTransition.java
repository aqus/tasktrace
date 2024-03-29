package com.tasktrace.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "status_transitions")
@IdClass(StatusTransitionId.class)
public class StatusTransition {

    @Id
    @Column(name = "status_id")
    private Long statusId;

    @Id
    @Column(name = "transition_status_id")
    private Long transitionStatusId;

    public StatusTransition(Long statusId, Long transitionStatusId) {
        this.statusId = statusId;
        this.transitionStatusId = transitionStatusId;
    }

    public StatusTransition() {
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
