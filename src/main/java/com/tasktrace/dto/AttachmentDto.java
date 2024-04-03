package com.tasktrace.dto;

import com.tasktrace.model.Task;
import jakarta.persistence.Column;

public class AttachmentDto {

    private long id;

    private String name;

    private String fileId;

    private TaskDto task;

    public AttachmentDto(long id, String name, String fileId, TaskDto task) {
        this.id = id;
        this.name = name;
        this.fileId = fileId;
        this.task = task;
    }

    public AttachmentDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public TaskDto getTask() {
        return task;
    }

    public void setTask(TaskDto task) {
        this.task = task;
    }
}
