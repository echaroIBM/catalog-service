package com.catalog.catalog.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.catalog.catalog.model.Task;
import com.catalog.catalog.resources.Util;

@Controller
public class TaskController {
	
	@GetMapping("/tasks")
	public ResponseEntity<List<Task>> getTasks(@RequestParam String username){
		
		Util.getInstance();
		return new ResponseEntity<>(Util.getInstance().getValue(username), 
				   HttpStatus.OK);
	}
	
	@PutMapping("/save/{username}")
	public ResponseEntity<String> save(@PathVariable String username, @RequestBody Task task){
		List<Task> tasks = Util.getInstance().getValue(username);
		if(tasks == null) {
			tasks = new ArrayList<Task>();
		}
		tasks.add(new Task(task.getTaskName(),task.getTaskDescription(), LocalDateTime.now(),Task.Status.PENDING));
		Util.getInstance().add(username, tasks);
		return new ResponseEntity<>("success", 
				   HttpStatus.OK);
	}

}
