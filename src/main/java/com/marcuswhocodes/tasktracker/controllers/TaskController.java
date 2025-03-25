package com.marcuswhocodes.tasktracker.controllers;

import com.marcuswhocodes.tasktracker.domain.CreateTaskRequest;
import com.marcuswhocodes.tasktracker.domain.dtos.CreateTaskRequestDto;
import com.marcuswhocodes.tasktracker.domain.dtos.TaskResponseDto;
import com.marcuswhocodes.tasktracker.domain.entities.Task;
import com.marcuswhocodes.tasktracker.mappers.TaskMapper;
import com.marcuswhocodes.tasktracker.services.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
@Slf4j
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(@Valid @RequestBody CreateTaskRequestDto createTaskRequestDto) {
        CreateTaskRequest createTaskRequest = taskMapper.toCreateTaskRequest(createTaskRequestDto);
        Task createdTask = taskService.createTask(createTaskRequest);
        TaskResponseDto createdTaskDto = taskMapper.toTaskResponseDto(createdTask);
        return new ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);

    }

    @GetMapping("/{taskListId}")
    public ResponseEntity<List<TaskResponseDto>> getTasks(@PathVariable UUID taskListId) {
        List<Task> tasks = taskService.findByTaskListTasksById(taskListId);
        List<TaskResponseDto> taskDtos = tasks.stream().map(taskMapper::toTaskResponseDto).toList();
        return new ResponseEntity<>(taskDtos, HttpStatus.OK);
    }
}
