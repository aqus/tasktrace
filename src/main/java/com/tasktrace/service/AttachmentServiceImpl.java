package com.tasktrace.service;

import com.tasktrace.dto.CreateAttachmentDto;
import com.tasktrace.exception.EntityNotFoundException;
import com.tasktrace.feign.TasktraceStorageService;
import com.tasktrace.model.Attachment;
import com.tasktrace.model.Task;
import com.tasktrace.repository.AttachmentRepository;
import com.tasktrace.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;

    private final TaskRepository taskRepository;

    private final TasktraceStorageService tasktraceStorageService;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository, TaskRepository taskRepository,
                                 TasktraceStorageService tasktraceStorageService) {
        this.attachmentRepository = attachmentRepository;
        this.taskRepository = taskRepository;
        this.tasktraceStorageService = tasktraceStorageService;
    }

    @Transactional
    @Override
    public String createAttachment(CreateAttachmentDto createAttachmentDto) {
        ResponseEntity<UUID> file = tasktraceStorageService.save(createAttachmentDto.getFile());
        UUID fileId = file.getBody();

        if (fileId == null) {
            throw new EntityNotFoundException("While storing attachment");
        }

        final long taskId = createAttachmentDto.getTaskId();

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Task with id %d not found".formatted(taskId)));

        Attachment attachment = new Attachment(createAttachmentDto.getName(), /*createAttachmentDto.getTaskId(),*/
                fileId.toString());
        attachment.setTask(task);

        List<Attachment> attachments = new ArrayList<>(task.getAttachments());
        attachments.add(attachment);
        task.setAttachments(attachments);

        attachmentRepository.save(attachment);
        taskRepository.save(task);
        return fileId.toString();
    }
}
