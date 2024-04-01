package com.tasktrace.controller;


import com.tasktrace.dto.CreateTaskDto;
import com.tasktrace.dto.TaskDto;
import com.tasktrace.dto.UpdateTaskDto;
import com.tasktrace.feign.TasktraceUsers;
import com.tasktrace.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public List<TaskDto> findAllTasks() {
        return taskService.findAll();
    }

    @GetMapping("api/v1/tasks/{id}")
    public TaskDto findById(@PathVariable long id) {
        return taskService.findById(id);
    }

    @PostMapping("api/v1/tasks")
    public TaskDto createTask(@RequestBody @Valid CreateTaskDto createTaskDto) {
        return taskService.insert(createTaskDto);
    }

    @PutMapping("api/v1/tasks")
    public TaskDto updateTask(@RequestBody @Valid UpdateTaskDto updateTaskDto) {
        return taskService.update(updateTaskDto);
    }
}
