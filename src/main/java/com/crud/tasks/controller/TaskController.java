package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
@Autowired
    private final DbService service;
@Autowired
    private final TaskMapper taskMapper;


    @GetMapping
    public List<TaskDto> getTasks(){

      List<Task> tasks = service.getAllTasks();
      return taskMapper.mapToTaskDtoList(tasks);
  }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTask(@RequestBody TaskDto taskDto) {
        Task task = taskMapper.mapToTask(taskDto);
        service.saveTask(task);
    }
    @GetMapping(value = "{taskId}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Long taskId)throws TaskNotFoundException {


        return new ResponseEntity<>(taskMapper.mapToTaskDto(
                service.getTask(taskId).orElseThrow()), HttpStatus.OK);

    }
    @DeleteMapping(value = "taskId")
    public void deleteTask( @PathVariable Long taskId) {
        service.deleteTask(taskId);

    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTask(@RequestBody TaskDto taskDto) {
        Task task = taskMapper.mapToTask(taskDto);
        service.saveTask(task);
    }

}

            

