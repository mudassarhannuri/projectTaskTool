package com.test.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.bean.ProjectTask;

@Repository
public interface ProjectTaskRepo extends CrudRepository<ProjectTask, Long> {
 
	ProjectTask getById(Long id);
}
