package com.marcuswhocodes.tasktracker.domain.entities;


import com.marcuswhocodes.tasktracker.domain.enums.TaskPriority;
import com.marcuswhocodes.tasktracker.domain.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, unique = false)
    private LocalDateTime dueDate;

    @Column(nullable = false, unique = false)
    private LocalDateTime completedAt;

    @Column(nullable = false, unique = false)
    private TaskStatus status;

    @Column(nullable = false, unique = false)
    private TaskPriority taskPriority;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_list_id", nullable = false)
    private TaskList tasks;

    @PrePersist
    public void prePersist() {
        this.completedAt = LocalDateTime.now();
        this.dueDate = LocalDateTime.now().plusDays(7);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(dueDate, task.dueDate) && Objects.equals(completedAt, task.completedAt) && status == task.status && taskPriority == task.taskPriority && Objects.equals(tasks, task.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, dueDate, completedAt, status, taskPriority, tasks);
    }
}
