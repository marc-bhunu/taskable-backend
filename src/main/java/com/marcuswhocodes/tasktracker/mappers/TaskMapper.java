package com.marcuswhocodes.tasktracker.mappers;

import com.marcuswhocodes.tasktracker.domain.CreateTaskListRequest;
import com.marcuswhocodes.tasktracker.domain.CreateTaskRequest;
import com.marcuswhocodes.tasktracker.domain.dtos.CreateTaskListRequestDto;
import com.marcuswhocodes.tasktracker.domain.dtos.CreateTaskRequestDto;
import com.marcuswhocodes.tasktracker.domain.dtos.TaskListResponseDto;
import com.marcuswhocodes.tasktracker.domain.dtos.TaskResponseDto;
import com.marcuswhocodes.tasktracker.domain.entities.Task;
import com.marcuswhocodes.tasktracker.domain.entities.TaskList;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TaskMapper {
    TaskListResponseDto toDto(TaskList taskList);
    CreateTaskRequest toCreateTaskRequest(CreateTaskRequestDto createTaskRequestDto);
    CreateTaskListRequest toCreateTaskListRequest(CreateTaskListRequestDto createTaskListRequestDto);
    TaskResponseDto toTaskResponseDto(Task task);
}
