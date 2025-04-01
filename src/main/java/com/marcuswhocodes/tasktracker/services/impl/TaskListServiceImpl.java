package com.marcuswhocodes.tasktracker.services.impl;

import com.marcuswhocodes.tasktracker.domain.CreateTaskListRequest;
import com.marcuswhocodes.tasktracker.domain.entities.TaskList;
import com.marcuswhocodes.tasktracker.repositories.TaskListRepository;
import com.marcuswhocodes.tasktracker.services.TaskListService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    @Override
    public List<TaskList> getTaskList() {
       return  taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(CreateTaskListRequest createTaskListRequest) {

        TaskList taskList = new TaskList();
        taskList.setTitle(createTaskListRequest.getTitle());
        taskList.setDescription(createTaskListRequest.getDescription());
        taskList.setTasks(new ArrayList<>());

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
}
