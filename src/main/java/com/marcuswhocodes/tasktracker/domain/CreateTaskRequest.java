package com.marcuswhocodes.tasktracker.domain;


import com.marcuswhocodes.tasktracker.domain.enums.TaskPriority;
import com.marcuswhocodes.tasktracker.domain.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTaskRequest {
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private LocalDateTime completedAt;
    private TaskStatus status;
    private TaskPriority taskPriority;
}
