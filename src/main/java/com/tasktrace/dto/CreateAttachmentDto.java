package com.tasktrace.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class CreateAttachmentDto {

    @NotBlank(message = "Не должно быть пустым")
    private String name;

    private long taskId;

    @NotNull
    private MultipartFile file;

    public CreateAttachmentDto(String name, long taskId, MultipartFile file) {
        this.name = name;
        this.taskId = taskId;
        this.file = file;
    }

    public CreateAttachmentDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
