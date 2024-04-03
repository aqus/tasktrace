package com.tasktrace.mapper;

import com.tasktrace.dto.AttachmentDto;
import com.tasktrace.dto.StatusDto;
import com.tasktrace.dto.TaskDto;
import com.tasktrace.model.Task;

import java.util.List;
import java.util.stream.Collectors;

public class TaskMapper {

    public static TaskDto toTaskDto(Task task) {
        List<StatusDto> transitions = task.getTransitions() != null
                ? task.getTransitions().stream().map(StatusMapper::toStatusDto).toList()
                : null;

        List<AttachmentDto> attachments = task.getAttachments() != null
                ? task.getAttachments().stream().map(AttachmentMapper::toAttachmentDto).collect(Collectors.toList())
                : null;
        return new TaskDto(task.getId(), task.getTitle(), task.getReporter(), task.getPerformer(), task.getText(),
                PriorityMapper.toPriorityDto(task.getPriority()), task.getLabels().stream()
                .map(LabelMapper::toLabelDto).toList(), StatusMapper.toStatusDto(task.getStatus()),
                transitions, attachments, task.getCreateTime());
    }
}
