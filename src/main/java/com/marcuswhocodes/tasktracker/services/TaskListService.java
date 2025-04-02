package com.marcuswhocodes.tasktracker.services;

import com.marcuswhocodes.tasktracker.domain.CreateTaskListRequest;
import com.marcuswhocodes.tasktracker.domain.UpdateTaskListRequest;
import com.marcuswhocodes.tasktracker.domain.entities.TaskList;
import java.util.UUID;

import java.util.List;

public interface TaskListService {
    List<TaskList> getTaskList();
    TaskList createTaskList(CreateTaskListRequest createTaskListRequest);
    void deleteTaskList(UUID id);
    TaskList updateTaskList(UUID id, UpdateTaskListRequest updateTaskListRequest);
}
