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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
@Slf4j
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(@Valid @RequestBody CreateTaskRequestDto createTaskRequestDto) {
        log.info("Creating task: {}", createTaskRequestDto);

        CreateTaskRequest createTaskRequest = taskMapper.toCreateTaskRequest(createTaskRequestDto);
        Task createdTask = taskService.createTask(createTaskRequest);
        TaskResponseDto createdTaskDto = taskMapper.toTaskResponseDto(createdTask);
        return new ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);

    }
}
