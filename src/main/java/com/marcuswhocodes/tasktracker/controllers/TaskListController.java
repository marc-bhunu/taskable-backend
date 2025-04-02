package com.marcuswhocodes.tasktracker.controllers;


import com.marcuswhocodes.tasktracker.domain.CreateTaskListRequest;
import com.marcuswhocodes.tasktracker.domain.UpdateTaskListRequest;
import com.marcuswhocodes.tasktracker.domain.dtos.CreateTaskListRequestDto;
import com.marcuswhocodes.tasktracker.domain.dtos.TaskListResponseDto;
import com.marcuswhocodes.tasktracker.domain.dtos.UpdateTaskListRequestDto;
import com.marcuswhocodes.tasktracker.domain.entities.TaskList;
import com.marcuswhocodes.tasktracker.mappers.TaskMapper;
import com.marcuswhocodes.tasktracker.services.TaskListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tasks-list")
@RequiredArgsConstructor
@Slf4j
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskMapper taskMapper;

    @GetMapping
    public ResponseEntity<List<TaskListResponseDto>> getTaskList() {
        List<TaskList> tasks =  taskListService.getTaskList();
        List<TaskListResponseDto> taskListResponseDtos = tasks.stream().map(taskMapper::toDto).toList();
        return ResponseEntity.ok(taskListResponseDtos);
    }

    @PostMapping
    public ResponseEntity<TaskListResponseDto> createTaskList(@Valid @RequestBody CreateTaskListRequestDto createTaskListRequestDto) {
        CreateTaskListRequest  createTaskListRequest = taskMapper.toCreateTaskListRequest(createTaskListRequestDto);
        TaskList taskList = taskListService.createTaskList(createTaskListRequest);
        TaskListResponseDto taskListResponseDto = taskMapper.toDto(taskList);
        return new ResponseEntity<>(taskListResponseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{taskListId}")
    public ResponseEntity<TaskListResponseDto> updateTaskList(@PathVariable("taskListId") UUID taskListId, @Valid @RequestBody UpdateTaskListRequestDto updateTaskListRequestDto) {
        UpdateTaskListRequest updateTaskListRequest = taskMapper.toUpdateTaskListRequest(updateTaskListRequestDto);
        TaskList updateTaskList =  taskListService.updateTaskList(taskListId, updateTaskListRequest);
        TaskListResponseDto taskListResponseDto = taskMapper.toDto(updateTaskList);
        return  new ResponseEntity<>(taskListResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskList(@PathVariable UUID id) {
        taskListService.deleteTaskList(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
