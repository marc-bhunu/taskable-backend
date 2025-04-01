package com.marcuswhocodes.tasktracker.services.impl;

import com.marcuswhocodes.tasktracker.domain.CreateTaskRequest;
import com.marcuswhocodes.tasktracker.domain.UpdateTaskRequest;
import com.marcuswhocodes.tasktracker.domain.entities.Task;
import com.marcuswhocodes.tasktracker.domain.entities.TaskList;
import com.marcuswhocodes.tasktracker.domain.enums.TaskPriority;
import com.marcuswhocodes.tasktracker.domain.enums.TaskStatus;
import com.marcuswhocodes.tasktracker.repositories.TaskListRepository;
import com.marcuswhocodes.tasktracker.repositories.TaskRepository;
import com.marcuswhocodes.tasktracker.services.TaskService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl  implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    @Override
    public Task createTask(CreateTaskRequest createTaskRequest) {
        TaskList taskList = taskListRepository.findById(createTaskRequest.getTask_list_id())
                                    .orElseThrow(() -> new IllegalArgumentException("Task List not found"));
        Task task = Task.builder()
                .title(createTaskRequest.getTitle())
                .description(createTaskRequest.getDescription())
                .status(TaskStatus.OPEN)
                .taskPriority(TaskPriority.LOW)
                .tasks(taskList)
                .build();
        task.setTasks(taskList);
        return taskRepository.save(task);
    }

    @Override
    public List<Task> findByTaskListTasksById(UUID taskListId) {
        return  taskRepository.findByTasks_Id(taskListId);
    }

    @Override
    public void deleteTask(UUID id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) {
            throw new IllegalStateException("Task with id "+ id + "could not be found");
        }
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateTask(UUID id, UpdateTaskRequest updateTaskRequest) {
        log.info("Updating task with id {}", updateTaskRequest);

        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found exception" + id));

        TaskList taskList = taskListRepository.findById(updateTaskRequest.getTask_list_id())
                .orElseThrow(() -> new IllegalArgumentException("Task List not found"));

        existingTask.setTitle(updateTaskRequest.getTitle());
        existingTask.setDescription(updateTaskRequest.getDescription());
        existingTask.setStatus(updateTaskRequest.getStatus());
        existingTask.setTaskPriority(updateTaskRequest.getTaskPriority());
        existingTask.setTasks(taskList);
        existingTask.setDueDate(updateTaskRequest.getDueDate());
        existingTask.setCompletedAt(updateTaskRequest.getCompletedAt());

        return taskRepository.save(existingTask);

    }



}
