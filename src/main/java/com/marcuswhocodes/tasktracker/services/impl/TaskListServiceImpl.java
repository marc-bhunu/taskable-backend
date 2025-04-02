package com.marcuswhocodes.tasktracker.services.impl;

import com.marcuswhocodes.tasktracker.domain.CreateTaskListRequest;
import com.marcuswhocodes.tasktracker.domain.UpdateTaskListRequest;
import com.marcuswhocodes.tasktracker.domain.entities.Task;
import com.marcuswhocodes.tasktracker.domain.entities.TaskList;
import com.marcuswhocodes.tasktracker.repositories.TaskListRepository;
import com.marcuswhocodes.tasktracker.repositories.TaskRepository;
import com.marcuswhocodes.tasktracker.services.TaskListService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;
    private final TaskRepository taskRepository;

    @Override
    public List<TaskList> getTaskList() {
       return  taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(CreateTaskListRequest createTaskListRequest) {

        TaskList taskList = TaskList.builder()
                .title(createTaskListRequest.getTitle())
                .description(createTaskListRequest.getDescription())
                .tasks(new ArrayList<>())
                .build();

        return  taskListRepository.save(taskList);

    }

    @Override
    public void deleteTaskList(UUID id) {

        Optional<TaskList>  taskList = taskListRepository.findById(id);
        if (taskList.isEmpty()) {
            throw new IllegalArgumentException("TaskList with id " + id + " not found");
        }
        taskListRepository.deleteById(id);
    }
    @Transactional
    @Override
    public TaskList updateTaskList(UUID id, UpdateTaskListRequest updateTaskListRequest) {
        TaskList existingTaskList = taskListRepository.findById(id)
                                        .orElseThrow(() -> new IllegalArgumentException("TaskList with id :"+id+" not found"));
        List<Task> tasks = taskRepository.findByTasks_Id(id);
        log.info("Tasks {}" , tasks.toString());
        existingTaskList.setTitle(updateTaskListRequest.getTitle());
        existingTaskList.setDescription(updateTaskListRequest.getDescription());
        return taskListRepository.save(existingTaskList);
    }
}
