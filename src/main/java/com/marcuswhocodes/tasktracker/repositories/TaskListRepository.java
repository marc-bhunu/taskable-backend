package com.marcuswhocodes.tasktracker.repositories;

import com.marcuswhocodes.tasktracker.domain.entities.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface TaskListRepository extends JpaRepository<TaskList, UUID> {

}
