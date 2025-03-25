package com.marcuswhocodes.tasktracker.domain.dtos;

import com.marcuswhocodes.tasktracker.domain.enums.TaskPriority;
import com.marcuswhocodes.tasktracker.domain.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponseDto {
    private UUID id;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority taskPriority;
}
