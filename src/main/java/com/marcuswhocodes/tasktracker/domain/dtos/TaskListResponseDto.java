package com.marcuswhocodes.tasktracker.domain.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
