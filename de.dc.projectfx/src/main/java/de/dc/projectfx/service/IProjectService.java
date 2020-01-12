package de.dc.projectfx.service;

import java.util.List;

import de.dc.projectfx.controller.model.MainBinding;
import de.dc.projectfx.model.Project;

public interface IProjectService {

	Project create(MainBinding model);
	
	List<Project> findAll();
}
