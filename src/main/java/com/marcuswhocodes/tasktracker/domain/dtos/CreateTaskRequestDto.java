package com.marcuswhocodes.tasktracker.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTaskRequestDto {
    private UUID task_list_id;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 50, message = "Title must be between {min} and {max} characters")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(min = 3, max = 50, message = "Title must be between {min} and {max} characters")
    private String description;
}
