package com.tasktrace.repository;

import com.tasktrace.model.Task;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @EntityGraph("priority-status-entity-graph")
    List<Task> findByPerformer(String performer);

    @EntityGraph("priority-status-entity-graph")
    Optional<Task> findById(long id);
}
