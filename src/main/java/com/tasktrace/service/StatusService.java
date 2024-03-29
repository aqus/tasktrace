package com.tasktrace.service;

import com.tasktrace.dto.CreateStatusDto;
import com.tasktrace.dto.StatusDto;

import java.util.List;

public interface StatusService {

    StatusDto create(CreateStatusDto createStatusDto);

    List<StatusDto> findAll();
}
