package com.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.Service.ProjectTaskService;
import com.test.bean.ProjectTask;

@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class ProjectTaskController {

	@Autowired
	private ProjectTaskService proServices;

	@PostMapping("")
	public ResponseEntity<?> addPTToBord(@Valid @RequestBody ProjectTask projectTask, BindingResult result) {
		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}
		ProjectTask newPT = proServices.saveOrUpdate(projectTask);
		return new ResponseEntity<ProjectTask>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")

	public Iterable<ProjectTask> getAllPTs() {
		return proServices.findAll();
	}

	@GetMapping("/{pt_id}")
	public ResponseEntity<?> getByPTId(@PathVariable Long pt_id) {
		ProjectTask newPT = proServices.findById(pt_id);
		return new ResponseEntity<ProjectTask>(newPT, HttpStatus.OK);
	}

}
