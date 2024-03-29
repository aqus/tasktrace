package com.tasktrace.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "tasks")
@NamedEntityGraph(
        name = "priority-status-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("priority"),
                @NamedAttributeNode("status")
        }
)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private long id;

    private String title;

    @Column(name = "reporter_id", nullable = false)
    private long reporterId;

    @Column(name = "performer_id", nullable = false)
    private long performerId;

    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "priority_id")
    private Priority priority;

    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany(targetEntity = Label.class)
    @JoinTable(name = "tasks_labels",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private List<Label> labels;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private Status status;

    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany(targetEntity = Status.class)
    @JoinTable(name = "status_transitions",
            joinColumns = @JoinColumn(name = "status_id"),
            inverseJoinColumns = @JoinColumn(name = "transition_status_id"))
    private List<Status> transitions;

    @Column(name = "create_time", nullable = false)
    private long createTime;

    public Task(long id, String title, long reporterId, long performerId, String text, Priority priority,
                List<Label> labels, Status status, List<Status> transitions, long createTime) {
        this.id = id;
        this.title = title;
        this.reporterId = reporterId;
        this.performerId = performerId;
        this.text = text;
        this.priority = priority;
        this.labels = labels;
        this.status = status;
        this.transitions = transitions;
        this.createTime = createTime;
    }

    public Task() {
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

    public long getReporterId() {
        return reporterId;
    }

    public void setReporterId(long reporterId) {
        this.reporterId = reporterId;
    }

    public long getPerformerId() {
        return performerId;
    }

    public void setPerformerId(long performerId) {
        this.performerId = performerId;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Status> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Status> transitions) {
        this.transitions = transitions;
    }
}
