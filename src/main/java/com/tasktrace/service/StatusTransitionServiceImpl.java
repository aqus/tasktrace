package com.tasktrace.service;

import com.tasktrace.dto.CreateStatusTransitionDto;
import com.tasktrace.dto.StatusTransitionDto;
import com.tasktrace.exception.EntityNotFoundException;
import com.tasktrace.mapper.StatusTransitionMapper;
import com.tasktrace.model.Status;
import com.tasktrace.model.StatusTransition;
import com.tasktrace.repository.StatusRepository;
import com.tasktrace.repository.StatusTransitionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StatusTransitionServiceImpl implements StatusTransitionService {

    private final StatusTransitionRepository statusTransitionRepository;

    private final StatusRepository statusRepository;

    public StatusTransitionServiceImpl(StatusTransitionRepository statusTransitionRepository,
                                       StatusRepository statusRepository) {
        this.statusTransitionRepository = statusTransitionRepository;
        this.statusRepository = statusRepository;
    }

    @Transactional
    @Override
    public StatusTransitionDto create(CreateStatusTransitionDto createStatusTransitionDto) {
        final Status currentStatus = statusRepository.findById(createStatusTransitionDto.getStatusId())
                .orElseThrow(() -> new EntityNotFoundException("Status not found"));
        final Status transitionStatus = statusRepository.findById(createStatusTransitionDto.getTransitionStatusId())
                .orElseThrow(() -> new EntityNotFoundException("Transition status not found"));
        return StatusTransitionMapper.toStatusTransitionDto(statusTransitionRepository.save(
                new StatusTransition(currentStatus, transitionStatus)));
    }
}
