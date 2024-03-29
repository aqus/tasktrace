package com.tasktrace.service;

import com.tasktrace.dto.CreateStatusTransitionDto;
import com.tasktrace.dto.StatusTransitionDto;
import com.tasktrace.mapper.StatusTransitionMapper;
import com.tasktrace.model.StatusTransition;
import com.tasktrace.repository.StatusTransitionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StatusTransitionServiceImpl implements StatusTransitionService {

    private final StatusTransitionRepository statusTransitionRepository;

    public StatusTransitionServiceImpl(StatusTransitionRepository statusTransitionRepository) {
        this.statusTransitionRepository = statusTransitionRepository;
    }

    @Transactional
    @Override
    public StatusTransitionDto create(CreateStatusTransitionDto createStatusTransitionDto) {
        return StatusTransitionMapper.toStatusTransitionDto(statusTransitionRepository.save(
                new StatusTransition(createStatusTransitionDto.getStatusId(),
                        createStatusTransitionDto.getTransitionStatusId())));
    }
}
