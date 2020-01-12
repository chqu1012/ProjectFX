package de.dc.projectfx.controller.model;

import java.time.Duration;
import java.time.LocalDateTime;

import de.dc.projectfx.model.Project;
import de.dc.projectfx.model.ProjectCategory;
import de.dc.projectfx.model.ProjectType;
import de.dc.projectfx.model.Task;
import de.dc.projectfx.model.User;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

public class MainBinding {

	private ObjectProperty<String> start = new SimpleObjectProperty<>();
	private ObjectProperty<String> end = new SimpleObjectProperty<>();
	private ObjectProperty<String> duration = new SimpleObjectProperty<>();
	private ObjectProperty<String> projectDescription = new SimpleObjectProperty<>();
	private ObjectProperty<String> projectName = new SimpleObjectProperty<>();
	private ObjectProperty<String> projectKey = new SimpleObjectProperty<>();
	private ObjectProperty<String> appointmentDescription = new SimpleObjectProperty<>();
	private ObjectProperty<ProjectCategory> category = new SimpleObjectProperty<>();

	public ObservableList<Project> dataProject = FXCollections.observableArrayList();
	public FilteredList<Project> filteredDataProject = new FilteredList<>(dataProject);
	public SortedList<Project> sortedDataProject = new SortedList<>(filteredDataProject);

	public ObservableList<User> dataUser = FXCollections.observableArrayList();
	public FilteredList<User> filteredDataUser = new FilteredList<>(dataUser);
	public SortedList<User> sortedDataUser = new SortedList<>(filteredDataUser);

	public ObservableList<ProjectCategory> dataProjectCategory = FXCollections.observableArrayList();
	public FilteredList<ProjectCategory> filteredDataProjectCategory = new FilteredList<>(dataProjectCategory);
	public SortedList<ProjectCategory> sortedDataProjectCategory = new SortedList<>(filteredDataProjectCategory);

	public ObservableList<ProjectType> dataProjectType = FXCollections.observableArrayList();
	public FilteredList<ProjectType> filteredDataProjectType = new FilteredList<>(dataProjectType);
	public SortedList<ProjectType> sortedDataProjectType = new SortedList<>(filteredDataProjectType);

	public ObservableList<Task> dataTask = FXCollections.observableArrayList();
	public FilteredList<Task> filteredDataTask = new FilteredList<>(dataTask);
	public SortedList<Task> sortedDataTask = new SortedList<>(filteredDataTask);

	public void calcDuration() {
		try {
			LocalDateTime startTime = LocalDateTime.parse(start.get());
			LocalDateTime endTime = LocalDateTime.parse(end.get());
			setDuration(String.format("%s min", Duration.between(startTime, endTime).toMinutes()));
		} catch (Exception e) {
			setDuration("Error on calc");
		}
	}

	public ObservableList<Project> getDataProject() {
		return dataProject;
	}

	public void setDataProject(ObservableList<Project> dataProject) {
		this.dataProject = dataProject;
	}

	public FilteredList<Project> getFilteredDataProject() {
		return filteredDataProject;
	}

	public void setFilteredDataProject(FilteredList<Project> filteredDataProject) {
		this.filteredDataProject = filteredDataProject;
	}

	public SortedList<Project> getSortedDataProject() {
		return sortedDataProject;
	}

	public void setSortedDataProject(SortedList<Project> sortedDataProject) {
		this.sortedDataProject = sortedDataProject;
	}

	public ObservableList<ProjectCategory> getDataProjectCategory() {
		return dataProjectCategory;
	}

	public void setDataProjectCategory(ObservableList<ProjectCategory> dataProjectCategory) {
		this.dataProjectCategory = dataProjectCategory;
	}

	public FilteredList<ProjectCategory> getFilteredDataProjectCategory() {
		return filteredDataProjectCategory;
	}

	public void setFilteredDataProjectCategory(FilteredList<ProjectCategory> filteredDataProjectCategory) {
		this.filteredDataProjectCategory = filteredDataProjectCategory;
	}

	public SortedList<ProjectCategory> getSortedDataProjectCategory() {
		return sortedDataProjectCategory;
	}

	public void setSortedDataProjectCategory(SortedList<ProjectCategory> sortedDataProjectCategory) {
		this.sortedDataProjectCategory = sortedDataProjectCategory;
	}

	public ObservableList<ProjectType> getDataProjectType() {
		return dataProjectType;
	}

	public void setDataProjectType(ObservableList<ProjectType> dataProjectType) {
		this.dataProjectType = dataProjectType;
	}

	public FilteredList<ProjectType> getFilteredDataProjectType() {
		return filteredDataProjectType;
	}

	public void setFilteredDataProjectType(FilteredList<ProjectType> filteredDataProjectType) {
		this.filteredDataProjectType = filteredDataProjectType;
	}

	public SortedList<ProjectType> getSortedDataProjectType() {
		return sortedDataProjectType;
	}

	public void setSortedDataProjectType(SortedList<ProjectType> sortedDataProjectType) {
		this.sortedDataProjectType = sortedDataProjectType;
	}

	public ObservableList<Task> getDataTask() {
		return dataTask;
	}

	public void setDataTask(ObservableList<Task> dataTask) {
		this.dataTask = dataTask;
	}

	public FilteredList<Task> getFilteredDataTask() {
		return filteredDataTask;
	}

	public void setFilteredDataTask(FilteredList<Task> filteredDataTask) {
		this.filteredDataTask = filteredDataTask;
	}

	public SortedList<Task> getSortedDataTask() {
		return sortedDataTask;
	}

	public void setSortedDataTask(SortedList<Task> sortedDataTask) {
		this.sortedDataTask = sortedDataTask;
	}

	public final ObjectProperty<String> startProperty() {
		return this.start;
	}

	public final String getStart() {
		return this.startProperty().get();
	}

	public final void setStart(final String start) {
		this.startProperty().set(start);
	}

	public final ObjectProperty<String> endProperty() {
		return this.end;
	}

	public final String getEnd() {
		return this.endProperty().get();
	}

	public final void setEnd(final String end) {
		this.endProperty().set(end);
	}

	public final ObjectProperty<String> durationProperty() {
		return this.duration;
	}

	public final String getDuration() {
		return this.durationProperty().get();
	}

	public final void setDuration(final String duration) {
		this.durationProperty().set(duration);
	}

	public final ObjectProperty<String> projectDescriptionProperty() {
		return this.projectDescription;
	}

	public final String getProjectDescription() {
		return this.projectDescriptionProperty().get();
	}

	public final void setProjectDescription(final String projectDescription) {
		this.projectDescriptionProperty().set(projectDescription);
	}

	public final ObjectProperty<String> appointmentDescriptionProperty() {
		return this.appointmentDescription;
	}

	public final String getAppointmentDescription() {
		return this.appointmentDescriptionProperty().get();
	}

	public final void setAppointmentDescription(final String appointmentDescription) {
		this.appointmentDescriptionProperty().set(appointmentDescription);
	}

	public final ObjectProperty<ProjectCategory> categoryProperty() {
		return this.category;
	}

	public final ProjectCategory getCategory() {
		return this.categoryProperty().get();
	}

	public final void setCategory(final ProjectCategory category) {
		this.categoryProperty().set(category);
	}

	public final ObjectProperty<String> projectNameProperty() {
		return this.projectName;
	}

	public final String getProjectName() {
		return this.projectNameProperty().get();
	}

	public final void setProjectName(final String projectName) {
		this.projectNameProperty().set(projectName);
	}

	public final ObjectProperty<String> projectKeyProperty() {
		return this.projectKey;
	}

	public final String getProjectKey() {
		return this.projectKeyProperty().get();
	}

	public final void setProjectKey(final String projectKey) {
		this.projectKeyProperty().set(projectKey);
	}

}
