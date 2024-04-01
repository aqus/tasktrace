package com.tasktrace.service;

import com.tasktrace.dto.CreateTaskDto;
import com.tasktrace.dto.TaskDto;
import com.tasktrace.dto.UpdateTaskDto;
import com.tasktrace.exception.EntityNotFoundException;
import com.tasktrace.mapper.TaskMapper;
import com.tasktrace.model.Label;
import com.tasktrace.model.Priority;
import com.tasktrace.model.Status;
import com.tasktrace.model.Task;
import com.tasktrace.repository.LabelRepository;
import com.tasktrace.repository.PriorityRepository;
import com.tasktrace.repository.StatusRepository;
import com.tasktrace.repository.TaskRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final PriorityRepository priorityRepository;

    private final LabelRepository labelRepository;

    private final StatusRepository statusRepository;

    public TaskServiceImpl(TaskRepository taskRepository, PriorityRepository priorityRepository,
                           LabelRepository labelRepository, StatusRepository statusRepository) {
        this.taskRepository = taskRepository;
        this.priorityRepository = priorityRepository;
        this.labelRepository = labelRepository;
        this.statusRepository = statusRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<TaskDto> findAll() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt principal = (Jwt) authentication.getPrincipal();
        String userName = (String) principal.getClaims().get("preferred_username");

        return taskRepository.findByPerformer(userName)
                .stream()
                .map(TaskMapper::toTaskDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public TaskDto findById(long id) {
        return TaskMapper.toTaskDto(
                taskRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Task with id %d not found".formatted(id)))
        );
    }

    @Transactional
    @Override
    public TaskDto insert(CreateTaskDto createTaskDto) {
        return save(0, createTaskDto.getTitle(), createTaskDto.getReporter(), createTaskDto.getPerformer(),
                createTaskDto.getText(), createTaskDto.getPriorityId(), createTaskDto.getLabels(),
                createTaskDto.getStatusId());
    }

    @Transactional
    @Override
    public TaskDto update(UpdateTaskDto updateTaskDto) {
        taskRepository.findById(updateTaskDto.getId())
                .orElseThrow(
                        () -> new EntityNotFoundException("Task with id %d is not found"
                                .formatted(updateTaskDto.getId())));
        return save(updateTaskDto.getId(), updateTaskDto.getTitle(), updateTaskDto.getReporter(),
                updateTaskDto.getPerformer(), updateTaskDto.getText(), updateTaskDto.getPriorityId(),
                updateTaskDto.getLabels(), updateTaskDto.getStatusId());
    }

    private TaskDto save(long id, String title, String reporter, String performer, String text, long priorityId,
                         List<Long> labelIds, long statusId) {
        Priority priority = priorityRepository.findById(priorityId)
                .orElseThrow(() -> new EntityNotFoundException("Priority with id %d not found".formatted(id)));
        List<Label> labels = labelRepository.findAllById(labelIds);
        Status status = statusRepository.findById(statusId)
                .orElseThrow(() -> new EntityNotFoundException("Status with id %d not found".formatted(id)));
        Task task = new Task(id, title, reporter, performer, text, priority, labels, status,
                System.currentTimeMillis());
        return TaskMapper.toTaskDto(taskRepository.save(task));
    }
}
