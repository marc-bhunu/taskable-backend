package com.marcuswhocodes.tasktracker.services.impl;

import com.marcuswhocodes.tasktracker.domain.CreateTaskRequest;
import com.marcuswhocodes.tasktracker.domain.entities.Task;
import com.marcuswhocodes.tasktracker.domain.entities.TaskList;
import com.marcuswhocodes.tasktracker.domain.enums.TaskPriority;
import com.marcuswhocodes.tasktracker.domain.enums.TaskStatus;
import com.marcuswhocodes.tasktracker.repositories.TaskListRepository;
import com.marcuswhocodes.tasktracker.repositories.TaskRepository;
import com.marcuswhocodes.tasktracker.services.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl  implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    @Override
    public Task createTask(CreateTaskRequest createTaskRequest) {
        log.info("Creating task with id {}", createTaskRequest.getTask_list_id());
        Task task = new Task();
        task.setTitle(createTaskRequest.getTitle());
        task.setDescription(createTaskRequest.getDescription());
        task.setStatus(TaskStatus.OPEN);
        task.setTaskPriority(TaskPriority.LOW);
        TaskList taskList = taskListRepository.findById(createTaskRequest.getTask_list_id())
                                    .orElseThrow(() -> new IllegalArgumentException("Task List not found"));
        task.setTasks(taskList);
        return taskRepository.save(task);
    }

    @Override
    public List<Task> findByTaskListTasksById(UUID taskListId) {
        return  taskRepository.findByTasks_Id(taskListId);
    }

}
