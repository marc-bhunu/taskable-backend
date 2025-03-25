package com.marcuswhocodes.tasktracker.services;

import com.marcuswhocodes.tasktracker.domain.CreateTaskRequest;
import com.marcuswhocodes.tasktracker.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    Task createTask(CreateTaskRequest createTaskRequest);
    List<Task> findByTaskListTasksById(UUID taskListId);

}
