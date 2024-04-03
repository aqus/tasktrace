package com.tasktrace.service;

import com.tasktrace.dto.PriorityDto;

import java.util.List;

public interface PriorityService {

    PriorityDto create(String name);

    List<PriorityDto> findAll();
}
