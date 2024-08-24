package com.tasktrace.model;

import java.io.Serializable;
import java.util.Objects;

public class StatusTransitionId implements Serializable {

    private Long statusId;

    private Long transitionStatusId;

    public StatusTransitionId(Long statusId, Long transitionStatusId) {
        this.statusId = statusId;
        this.transitionStatusId = transitionStatusId;
    }

    public StatusTransitionId() {
    }

    public Long getStatusId() {
        return statusId;
    }

    public Long getTransitionStatusId() {
        return transitionStatusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StatusTransitionId that = (StatusTransitionId) o;
        return Objects.equals(statusId, that.statusId) && Objects.equals(transitionStatusId, that.transitionStatusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusId, transitionStatusId);
    }
}
