package de.dc.projectfx.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.dc.projectfx.controller.model.MainBinding;
import de.dc.projectfx.model.Project;
import de.dc.projectfx.repository.ProjectRepository;

@Service
public class ProjectService implements IProjectService{

	private static final Logger LOG = Logger.getLogger(ProjectService.class);
	
	@Autowired ProjectRepository projectRepository;
	
	@Override
	public Project create(MainBinding model) {
		String projectName = model.getProjectName();
		Project project = new Project();
		project.setName(projectName);
		project.setKey(model.getProjectKey());
		project.setCreatedOn(LocalDateTime.now());
//		project.setProjectLead(projectLead);
//		project.setType(type);
//		project.setCategory(category);
		projectRepository.save(project);
		model.dataProject.add(0, project);
		model.clearProjectForm();
		
		LOG.info("Create new project with name "+projectName);
		
		return project;
	}

	@Override
	public List<Project> findAll() {
		return projectRepository.findAll();
	}
}
