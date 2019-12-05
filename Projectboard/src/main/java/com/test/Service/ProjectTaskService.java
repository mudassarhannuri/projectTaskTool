package com.test.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Repository.ProjectTaskRepo;
import com.test.bean.ProjectTask;

@Service
public class ProjectTaskService {

	@Autowired
	private ProjectTaskRepo projectRepo;
	public ProjectTask saveOrUpdate(ProjectTask projectTask)
	{
		if(projectTask.getStatus()==null || projectTask.getStatus()=="")
			projectTask.setStatus("To_Do");
		return projectRepo.save(projectTask);
		
	}
	
	public Iterable<ProjectTask> findAll()
	{
		return projectRepo.findAll();
	}
	
	public ProjectTask findById(Long id)
	{
		return projectRepo.getById(id);
	}
	
}
