package com.tasktrace.controller;

import com.tasktrace.dto.CreateStatusDto;
import com.tasktrace.dto.StatusDto;
import com.tasktrace.service.StatusService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping("api/v1/statuses")
    public StatusDto create(@RequestBody @Valid CreateStatusDto createStatusDto) {
        return statusService.create(createStatusDto);
    }

    @GetMapping("api/v1/statuses")
    public List<StatusDto> findAll() {
        return statusService.findAll();
    }
}
