package com.tasktrace.controller;

import com.tasktrace.dto.CreatePriorityDto;
import com.tasktrace.dto.PriorityDto;
import com.tasktrace.service.PriorityService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PriorityController {

    private final PriorityService priorityService;

    public PriorityController(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @PostMapping("api/v1/priorities")
    public PriorityDto create(@RequestBody @Valid CreatePriorityDto createPriorityDto) {
        return priorityService.create(createPriorityDto.getName());
    }

    @GetMapping("api/v1/priorities")
    public List<PriorityDto> findAll() {
        return priorityService.findAll();
    }
}
