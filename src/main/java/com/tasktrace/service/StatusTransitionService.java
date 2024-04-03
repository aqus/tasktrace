package com.tasktrace.service;

import com.tasktrace.dto.CreateStatusTransitionDto;
import com.tasktrace.dto.StatusTransitionDto;

public interface StatusTransitionService {

    StatusTransitionDto create(CreateStatusTransitionDto createStatusTransitionDto);
}
