package com.tasktrace.mapper;

import com.tasktrace.dto.StatusDto;
import com.tasktrace.dto.TaskDto;
import com.tasktrace.model.Task;

import java.util.List;

public class TaskMapper {

    public static TaskDto toTaskDto(Task task) {
        List<StatusDto> transitions = task.getTransitions() != null
                ? task.getTransitions().stream().map(StatusMapper::toStatusDto).toList()
                : null;
        return new TaskDto(task.getId(), task.getTitle(), task.getReporter(), task.getPerformer(), task.getText(),
                PriorityMapper.toPriorityDto(task.getPriority()), task.getLabels().stream()
                .map(LabelMapper::toLabelDto).toList(), StatusMapper.toStatusDto(task.getStatus()),
                transitions, task.getCreateTime());
    }
}
