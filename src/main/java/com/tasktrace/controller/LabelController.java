package com.tasktrace.controller;

import com.tasktrace.dto.CreateLabelDto;
import com.tasktrace.dto.LabelDto;
import com.tasktrace.service.LabelService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LabelController {

    private final LabelService labelService;

    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @PostMapping("api/v1/labels")
    public LabelDto create(@RequestBody @Valid CreateLabelDto createLabelDto) {
        return labelService.create(createLabelDto);
    }

    @GetMapping("api/v1/labels")
    public List<LabelDto> findAll() {
        return labelService.findAll();
    }
}
