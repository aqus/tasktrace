package com.tasktrace.mapper;

import com.tasktrace.dto.LabelDto;
import com.tasktrace.model.Label;

public class LabelMapper {

    public static LabelDto toLabelDto(Label label) {
        return new LabelDto(label.getId(), label.getName());
    }
}
