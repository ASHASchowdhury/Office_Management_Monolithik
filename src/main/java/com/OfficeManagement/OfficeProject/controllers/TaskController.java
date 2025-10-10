package com.OfficeManagement.OfficeProject.controllers;

import com.OfficeManagement.OfficeProject.dtos.TaskRequestDTO;
import com.OfficeManagement.OfficeProject.dtos.TaskResponseDTO;
import com.OfficeManagement.OfficeProject.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        List<TaskResponseDTO> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO taskRequestDTO) {
        TaskResponseDTO createdTask = taskService.createTask(taskRequestDTO);
        return ResponseEntity.ok(createdTask);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Long id) {
        TaskResponseDTO task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }
}