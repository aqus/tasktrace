package com.tasktrace.mapper;

import com.tasktrace.dto.AttachmentDto;
import com.tasktrace.model.Attachment;

public class AttachmentMapper {

    public static AttachmentDto toAttachmentDto(Attachment attachment) {
        return new AttachmentDto(attachment.getId(), attachment.getName(), attachment.getFileId(),
                null);
    }
}
