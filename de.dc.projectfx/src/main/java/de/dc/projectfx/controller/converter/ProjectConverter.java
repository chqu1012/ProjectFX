package de.dc.projectfx.controller.converter;

import de.dc.projectfx.controller.model.MainBinding;
import de.dc.projectfx.model.Project;
import javafx.collections.transformation.FilteredList;
import javafx.util.StringConverter;

public class ProjectConverter extends StringConverter<Project>{

	private MainBinding model;
	private FilteredList<Project> filteredProjects;
	
	public ProjectConverter(MainBinding model) {
		this.model = model;
		this.filteredProjects = new FilteredList<>(model.dataProject);
	}
	
	@Override
	public String toString(Project project) {
		if (project==null) {
			return "";
		}
		return project.getName()==null? "" : project.getName();
	}
	
	@Override
	public Project fromString(String name) {
		filteredProjects.setPredicate(e->e.getName().equals(name));
		if (!filteredProjects.isEmpty()) {
			return model.filteredDataProject.get(0);
		}
		Project project = new Project();
		project.setName("---");
		return project;
	}
}