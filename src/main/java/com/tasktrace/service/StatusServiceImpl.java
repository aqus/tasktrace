package com.tasktrace.service;

import com.tasktrace.dto.CreateStatusDto;
import com.tasktrace.dto.StatusDto;
import com.tasktrace.mapper.StatusMapper;
import com.tasktrace.model.Status;
import com.tasktrace.repository.StatusRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Transactional
    @Override
    public StatusDto create(CreateStatusDto createStatusDto) {
        return StatusMapper.toStatusDto(statusRepository.save(new Status(null, createStatusDto.getName())));
    }

    @Override
    public List<StatusDto> findAll() {
        return statusRepository.findAll()
                .stream()
                .map(StatusMapper::toStatusDto)
                .collect(Collectors.toList());
    }
}
