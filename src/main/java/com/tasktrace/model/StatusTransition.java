package com.tasktrace.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "status_transitions")
@IdClass(StatusTransitionId.class)
public class StatusTransition {

    @Id
    @Column(name = "status_id")
    private Status status;

    @Id
    @Column(name = "transition_status_id")
    private Status transitionStatus;

    public StatusTransition(Status status, Status transitionStatus) {
        this.status = status;
        this.transitionStatus = transitionStatus;
    }

    @NotNull
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @NotNull
    public Status getTransitionStatus() {
        return transitionStatus;
    }

    public void setTransitionStatus(Status transitionStatus) {
        this.transitionStatus = transitionStatus;
    }
}
