package com.tasktrace.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class UpdateTaskDto {

    private Long id;

    @NotBlank(message = "Не должен быть пустым")
    private String title;

    @NotBlank(message = "Не должен быть пустым")
    private String reporter;

    @NotBlank(message = "Не должен быть пустым")
    private String performer;

    @NotBlank(message = "Не должен быть пустым")
    private String text;

    private long priorityId;

    private List<Long> labels;

    private long statusId;

    public UpdateTaskDto(Long id, String title, String reporter, String performer, String text, long priorityId,
                         List<Long> labels, long statusId) {
        this.id = id;
        this.title = title;
        this.reporter = reporter;
        this.performer = performer;
        this.text = text;
        this.priorityId = priorityId;
        this.labels = labels;
        this.statusId = statusId;
    }

    public UpdateTaskDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(long priorityId) {
        this.priorityId = priorityId;
    }

    public List<Long> getLabels() {
        return labels;
    }

    public void setLabels(List<Long> labels) {
        this.labels = labels;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }
}
