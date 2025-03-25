package com.marcuswhocodes.tasktracker.services.impl;

import com.marcuswhocodes.tasktracker.domain.CreateTaskRequest;
import com.marcuswhocodes.tasktracker.domain.entities.Task;
import com.marcuswhocodes.tasktracker.domain.enums.TaskPriority;
import com.marcuswhocodes.tasktracker.domain.enums.TaskStatus;
import com.marcuswhocodes.tasktracker.repositories.TaskListRepository;
import com.marcuswhocodes.tasktracker.repositories.TaskRepository;
import com.marcuswhocodes.tasktracker.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl  implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    @Override
    public Task createTask(CreateTaskRequest createTaskRequest) {
        Task task = new Task();
        task.setTitle(createTaskRequest.getTitle());
        task.setDescription(createTaskRequest.getDescription());
        task.setStatus(TaskStatus.OPEN);
        task.setTaskPriority(TaskPriority.LOW);
        return taskRepository.save(task);
    }
}
