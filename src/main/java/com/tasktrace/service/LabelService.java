package com.tasktrace.service;

import com.tasktrace.dto.CreateLabelDto;
import com.tasktrace.dto.LabelDto;

import java.util.List;

public interface LabelService {

    LabelDto create(CreateLabelDto createLabelDto);

    List<LabelDto> findAll();
}
