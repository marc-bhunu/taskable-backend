package com.marcuswhocodes.tasktracker.domain;


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
public class UpdateTaskRequest {
    private UUID task_list_id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private LocalDateTime completedAt;
    private TaskStatus status;
    private TaskPriority taskPriority;
}
