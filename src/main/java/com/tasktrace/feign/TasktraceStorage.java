package com.tasktrace.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@FeignClient("tasktrace-storage")
public interface TasktraceStorage {

    @PostMapping(value = "api/v1/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<UUID> save(@RequestPart("file") MultipartFile file);

    @GetMapping("file/{uuid}")
    ResponseEntity<byte[]> readFile(@PathVariable UUID uuid);
}
