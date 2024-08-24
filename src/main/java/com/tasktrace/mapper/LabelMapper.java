package com.tasktrace.mapper;

import com.tasktrace.dto.LabelDto;
import com.tasktrace.model.Label;
import jakarta.annotation.Nullable;

public class LabelMapper {

    @Nullable
    public static LabelDto toLabelDto(@Nullable Label label) {
        if (label == null) {
            return null;
        }
        return new LabelDto(label.getId(), label.getName());
    }
}
