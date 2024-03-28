package com.tasktrace.controller;


import com.tasktrace.model.Task;
import com.tasktrace.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("api/v1/tasks")
    public List<Task> findAllTasks() {
        return Collections.emptyList();
    }
}
