package com.tasktrace.service;

import com.tasktrace.dto.PriorityDto;
import com.tasktrace.mapper.PriorityMapper;
import com.tasktrace.model.Priority;
import com.tasktrace.repository.PriorityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriorityServiceImpl implements PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityServiceImpl(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public PriorityDto create(String name) {
        return PriorityMapper.toPriorityDto(priorityRepository.save(new Priority(null, name)));
    }

    @Override
    public List<PriorityDto> findAll() {
        return priorityRepository.findAll()
                .stream()
                .map(PriorityMapper::toPriorityDto)
                .collect(Collectors.toList());
    }
}
