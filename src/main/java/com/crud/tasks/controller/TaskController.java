package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks() {
        return new ArrayList<>();
    }

//    @GetMapping("/v1/getTask")
//    public ResponseEntity<TaskDto> getTask(@PathVariable Long taskId) {
//        return new ResponseEntity<>(new TaskDto(1L, "test title", "test_content"), HttpStatus.OK);
//    }
    @RequestMapping(method = RequestMethod.GET, value = "getTask")
    public TaskDto getTask(Long taskId) {
        return new TaskDto(1L, "test title", "test_content");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    public void deleteTask(Long taskId) {
    }
//    @PutMapping("/v1/updateTask")
//    public ResponseEntity<?> updateTask( @PathVariable TaskDto taskDto) {
//
//        return new ResponseEntity<>(new TaskDto (1L, "Edited test title", "Test content"));
//    }
    @RequestMapping(method = RequestMethod.POST, value = "createTask")
    public void createTask(TaskDto taskDto) {
    }
}
