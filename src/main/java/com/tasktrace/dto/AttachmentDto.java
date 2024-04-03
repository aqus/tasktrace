package com.tasktrace.dto;

public class AttachmentDto {

    private long id;

    private String name;

    private String fileId;

    public AttachmentDto(long id, String name, String fileId) {
        this.id = id;
        this.name = name;
        this.fileId = fileId;
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
}
