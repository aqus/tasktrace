package com.tasktrace.controller;


import com.tasktrace.feign.TasktraceUsers;
import com.tasktrace.model.Task;
import com.tasktrace.service.TaskService;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    private final TasktraceUsers tasktraceUsers;

    public TaskController(TaskService taskService, TasktraceUsers tasktraceUsers) {
        this.taskService = taskService;
        this.tasktraceUsers = tasktraceUsers;
    }

    @GetMapping("api/v1/tasks")
    public List<Task> findAllTasks() {
        return Collections.emptyList();
    }
//
//    @GetMapping("api/v1/tasks/{userId}")
//    public List<UserRepresentation> searchUser(@PathVariable("userId") String userId) {
//        return tasktraceUsers.searchByUsername(userId);
//    }
}
