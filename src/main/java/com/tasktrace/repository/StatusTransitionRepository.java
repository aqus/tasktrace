package com.tasktrace.repository;

import com.tasktrace.model.StatusTransition;
import com.tasktrace.model.StatusTransitionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusTransitionRepository extends JpaRepository<StatusTransition, StatusTransitionId> {
}
