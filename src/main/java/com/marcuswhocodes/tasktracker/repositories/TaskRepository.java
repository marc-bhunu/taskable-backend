package com.marcuswhocodes.tasktracker.repositories;

import com.marcuswhocodes.tasktracker.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {

}
