package com.OfficeManagement.OfficeProject.services;

import com.OfficeManagement.OfficeProject.dtos.TaskRequestDTO;
import com.OfficeManagement.OfficeProject.dtos.TaskResponseDTO;
import java.util.List;

public interface TaskService {
    TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO);
    List<TaskResponseDTO> getAllTasks();
    TaskResponseDTO getTaskById(Long id);
    TaskResponseDTO updateTask(Long id, TaskRequestDTO taskRequestDTO);
    void deleteTask(Long id);
    List<TaskResponseDTO> getTasksByAssignee(Long assigneeId);
    TaskResponseDTO updateTaskStatus(Long id, String status);
    List<TaskResponseDTO> getTasksByPriority(String priority);
    List<TaskResponseDTO> getOverdueTasks();
}