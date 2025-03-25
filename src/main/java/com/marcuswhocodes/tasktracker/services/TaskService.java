package com.marcuswhocodes.tasktracker.services;

import com.marcuswhocodes.tasktracker.domain.CreateTaskRequest;
import com.marcuswhocodes.tasktracker.domain.entities.Task;

public interface TaskService {
    Task createTask(CreateTaskRequest createTaskRequest);
}
