package com.tasktrace.controller;

import com.tasktrace.dto.CreateStatusTransitionDto;
import com.tasktrace.dto.StatusTransitionDto;
import com.tasktrace.service.StatusTransitionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusTransitionController {

    private final StatusTransitionService statusTransitionService;

    public StatusTransitionController(StatusTransitionService statusTransitionService) {
        this.statusTransitionService = statusTransitionService;
    }

    @PostMapping("api/v1/status-transitions")
    public StatusTransitionDto create(@RequestBody @Valid CreateStatusTransitionDto createStatusTransitionDto) {
        return statusTransitionService.create(createStatusTransitionDto);
    }
}
