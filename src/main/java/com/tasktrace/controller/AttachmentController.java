package com.tasktrace.controller;

import com.tasktrace.dto.CreateAttachmentDto;
import com.tasktrace.service.AttachmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AttachmentController {

    private final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping("api/v1/attachment")
    public String createAttachment(@RequestParam("file") MultipartFile file,
                                   @RequestParam("name") String name,
                                   @RequestParam("taskId") long taskId) {
        return attachmentService.createAttachment(new CreateAttachmentDto(name, taskId, file));
    }
}
