package com.tasktrace.service;

import com.tasktrace.dto.CreateLabelDto;
import com.tasktrace.dto.LabelDto;
import com.tasktrace.model.Label;
import com.tasktrace.repository.LabelRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LabelServiceImpl test")
@SpringBootTest
class LabelServiceImplTest {

    @Autowired
    private LabelServiceImpl labelService;

    @MockBean
    private LabelRepository labelRepository;

    @Test
    @DisplayName("Should create label")
    void shouldCreateLabel() {
        Label expectedRepositoryLabel = new Label(null, "Test");
        when(labelRepository.save(any())).thenReturn(expectedRepositoryLabel);
        CreateLabelDto createLabelDto = new CreateLabelDto("Test");
        LabelDto labelDto = labelService.create(createLabelDto);
        assertEquals("Test", labelDto.getName());
        verify(labelRepository, times(1)).save(any());
    }

    @Test
    @DisplayName("should find all the labels")
    void shouldFindAllLabels() {
        List<Label> expectedRepositoryLabels = Arrays.asList(new Label(1L, "Label1"),
                new Label(2L, "Label2"));
        when(labelRepository.findAll()).thenReturn(expectedRepositoryLabels);
        List<LabelDto> allLabels = labelService.findAll();
        assertEquals(expectedRepositoryLabels.size(), allLabels.size());
        assertEquals(allLabels.get(0).getName(), expectedRepositoryLabels.get(0).getName());
        assertEquals(allLabels.get(1).getName(), expectedRepositoryLabels.get(1).getName());
        verify(labelRepository, times(1)).findAll();
    }
}