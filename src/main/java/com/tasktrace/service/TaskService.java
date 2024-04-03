package com.tasktrace.service;

import com.tasktrace.dto.CreateTaskDto;
import com.tasktrace.dto.TaskDto;
import com.tasktrace.dto.UpdateTaskDto;

import java.util.List;

public interface TaskService {

    List<TaskDto> findAll();

    TaskDto findById(long id);

    TaskDto insert(CreateTaskDto createTaskDto);

    TaskDto update(UpdateTaskDto updateTaskDto);
}
