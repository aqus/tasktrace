package com.tasktrace.dto;

import java.util.List;
import java.util.Objects;

public class TaskDto {

    private long id;

    private String title;

    private String reporter;

    private String performer;

    private String text;

    private PriorityDto priority;

    private List<LabelDto> labels;

    private StatusDto status;

    private List<StatusDto> transitions;

    private long createTime;

    public TaskDto(long id, String title, String reporter, String performer, String text, PriorityDto priority,
                   List<LabelDto> labels, StatusDto status, List<StatusDto> transitions, long createTime) {
        this.id = id;
        this.title = title;
        this.reporter = reporter;
        this.performer = performer;
        this.text = text;
        this.priority = priority;
        this.labels = labels;
        this.status = status;
        this.transitions = transitions;
        this.createTime = createTime;
    }

    public TaskDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public PriorityDto getPriority() {
        return priority;
    }

    public void setPriority(PriorityDto priority) {
        this.priority = priority;
    }

    public List<LabelDto> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelDto> labels) {
        this.labels = labels;
    }

    public StatusDto getStatus() {
        return status;
    }

    public void setStatus(StatusDto status) {
        this.status = status;
    }

    public List<StatusDto> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<StatusDto> transitions) {
        this.transitions = transitions;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TaskDto taskDto = (TaskDto) o;
        return id == taskDto.id && createTime == taskDto.createTime && Objects.equals(title, taskDto.title)
                && Objects.equals(reporter, taskDto.reporter) && Objects.equals(performer, taskDto.performer)
                && Objects.equals(text, taskDto.text) && Objects.equals(priority, taskDto.priority)
                && Objects.equals(labels, taskDto.labels) && Objects.equals(status, taskDto.status)
                && Objects.equals(transitions, taskDto.transitions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, reporter, performer, text, priority, labels, status, transitions, createTime);
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", reporter='" + reporter + '\'' +
                ", performer='" + performer + '\'' +
                ", text='" + text + '\'' +
                ", priority=" + priority +
                ", labels=" + labels +
                ", status=" + status +
                ", transitions=" + transitions +
                ", createTime=" + createTime +
                '}';
    }
}
