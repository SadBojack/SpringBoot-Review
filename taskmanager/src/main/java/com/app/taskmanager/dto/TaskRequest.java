package com.app.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskRequest {

    @NotBlank
    private String title;

    @Size(max = 255)
    private String description;

    @NotBlank
    private String status;

    @NotNull
    private Integer priority;


}
