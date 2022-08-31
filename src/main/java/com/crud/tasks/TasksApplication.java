package com.crud.tasks;

import com.crud.tasks.domain.TaskDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class TasksApplication {
    // public class TasksApplication{
    public static void main(String[] args) {


        TaskDto taskDto = new TaskDto(1L, "Test title", "I want to be a coder!");

        String title = taskDto.getTitle();
        String content = taskDto.getContent();
        Long id = taskDto.getId();


        System.out.println(id + " " + title + " " + content);
        SpringApplication.run(TasksApplication.class, args);
    }

  //  @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TasksApplication.class);
    }
}

