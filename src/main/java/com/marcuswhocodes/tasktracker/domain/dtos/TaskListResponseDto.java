package com.marcuswhocodes.tasktracker.domain.dtos;


import com.marcuswhocodes.tasktracker.domain.entities.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskListResponseDto {
    private UUID id;
    private String description;
    private String title;
}
