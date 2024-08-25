package com.tasktrace.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tasktrace.dto.CreateLabelDto;
import com.tasktrace.dto.LabelDto;
import com.tasktrace.service.LabelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Label Controller Test")
@WebMvcTest(value = LabelController.class,  excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = WebSecurityConfigurer.class)},
        excludeAutoConfiguration = {SecurityAutoConfiguration.class, SecurityFilterAutoConfiguration.class,
                OAuth2ClientAutoConfiguration.class, OAuth2ResourceServerAutoConfiguration.class})
class LabelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LabelService labelService;

    @Autowired
    private ObjectMapper objectMapper;

    private List<LabelDto> labelDto;

    @BeforeEach
    public void setUp() {
        labelDto = List.of(
                new LabelDto(1L, "label1"),
                new LabelDto(2L, "label2"),
                new LabelDto(3L, "label3")
        );
    }

    @DisplayName("Should create a new label")
    @Test
    void shouldCreateNewLabel() throws Exception {
        CreateLabelDto createLabelDto = new CreateLabelDto("label");
        LabelDto expectedLabelDto = new LabelDto(1L, "label");

        // Mock the service call
        when(labelService.create(any())).thenReturn(expectedLabelDto);

        // Convert the DTO to JSON
        String postJson = objectMapper.writeValueAsString(createLabelDto);
        String expectedJson = objectMapper.writeValueAsString(expectedLabelDto);

        // Perform the request
        mockMvc.perform(post("/api/v1/labels")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postJson))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().json(expectedJson));

        // Verify the service method was called
        verify(labelService, times(1)).create(any());
    }

    @DisplayName("Should find all the labels")
    @Test
    void shouldFindAllLabels() throws Exception {
        when(labelService.findAll()).thenReturn(labelDto);

        mockMvc.perform(get("/api/v1/labels"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(labelDto)));

        verify(labelService, times(1)).findAll();
    }
}