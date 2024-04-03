package com.tasktrace.service;

import com.tasktrace.dto.CreateLabelDto;
import com.tasktrace.dto.LabelDto;
import com.tasktrace.mapper.LabelMapper;
import com.tasktrace.model.Label;
import com.tasktrace.repository.LabelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabelServiceImpl implements LabelService {

    private final LabelRepository labelRepository;

    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    @Override
    public LabelDto create(CreateLabelDto createLabelDto) {
        return LabelMapper.toLabelDto(labelRepository.save(new Label(null, createLabelDto.getName())));
    }

    @Override
    public List<LabelDto> findAll() {
        return labelRepository.findAll()
                .stream()
                .map(LabelMapper::toLabelDto)
                .collect(Collectors.toList());
    }
}
