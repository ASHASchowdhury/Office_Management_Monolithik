package com.OfficeManagement.OfficeProject.repository;

import com.OfficeManagement.OfficeProject.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // Find all non-deleted tasks
    List<Task> findByDeletedFalse();

    // Find tasks by assignee (non-deleted only)
    List<Task> findByAssignedToIdAndDeletedFalse(Long assignedToId);

    // Find tasks by priority (non-deleted only)
    List<Task> findByPriorityAndDeletedFalse(String priority);

    // Find task by ID (non-deleted only)
    Optional<Task> findByIdAndDeletedFalse(Long id);

    // Find tasks by status (non-deleted only)
    List<Task> findByStatusAndDeletedFalse(String status);
}