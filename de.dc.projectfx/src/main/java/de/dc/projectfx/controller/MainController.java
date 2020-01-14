package de.dc.projectfx.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Entry;

import de.dc.projectfx.model.Task;
import de.dc.projectfx.repository.TaskRepository;
import de.dc.projectfx.service.IProjectService;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

@Controller
public class MainController extends BaseMainBindingController {

	@Autowired TaskRepository taskRepository;
	@Autowired IProjectService projectService;

	@Autowired ConfigurableApplicationContext springContext;

	private Calendar currentCalendar;
	private Parent dashboard;

	@Override
	public void initialize() {
		super.initialize();
		model.dataTask.addAll(taskRepository.findAll());
		model.dataProject.addAll(projectService.findAll());
		currentCalendar = createCalendar("General");
		model.dataTask.forEach(a -> createEvent(currentCalendar, a.getName(), a.getStart(), a.getEnd()));

		dashboard = load("/de/dc/projectfx/Dashboard.fxml");
		stackPaneMain.getChildren().add(dashboard);
	}

	@Override
	protected void onButtonAction(ActionEvent event) {
		Object source = event.getSource();
		if (source == buttonSetStart) {
			model.setStart(LocalDateTime.now().toString());
			model.calcDuration();
		} else if (source == buttonSetEnd) {
			model.setEnd(LocalDateTime.now().toString());
			model.calcDuration();
		} else if (source == buttonCreateAppointment) {
			LocalDateTime start = LocalDateTime.parse(model.getStart());
			LocalDateTime end = LocalDateTime.parse(model.getEnd());
			String name = model.getAppointmentDescription();
			createEvent(currentCalendar, name, start, end);
			Task entity = new Task();
			entity.setName(name);
			entity.setEnd(end);
			entity.setStart(start);
			entity.setCreatedOn(LocalDateTime.now());
			taskRepository.save(entity);

			model.dataTask.add(0, entity);
		} else if (source == buttonCreateProject) {
			currentCalendar = createCalendar(model.getProjectName());
			projectService.create(model);
		} else if (source == buttonNewAppointment) {
			model.setStart(LocalDateTime.now().toString());
			model.setEnd(LocalDateTime.now().toString());
			paneNewAppointmentForn.toFront();
		} else if (source == buttonCancelAppointment) {
			paneNewAppointmentForn.toBack();
		}
	}

	@Override
	protected void onAppointmentSearchChanged(ObservableValue<? extends String> observable, String oldValue,
			String newValue) {
		if (newValue != null) {
			model.filteredDataTask.setPredicate(e -> e.getName().toLowerCase().contains(newValue.toLowerCase()));
		}
	}

	@Override
	protected void onMouseClicked(MouseEvent event) {
		Object source = event.getSource();
		if (source == labelNavAgenda) {
			paneAgenda.toFront();
		} else if (source == labelNavProject) {
			paneProject.toFront();
		} else if (source == labelNavHome) {
			dashboard.toFront();
		} else if (source == listViewAppointments) {
			dispatchOnListViewAppointmentClicked();
		}
	}

	private void dispatchOnListViewAppointmentClicked() {
		Task selection = listViewAppointments.getSelectionModel().getSelectedItem();
		if (selection != null) {
			List<Entry<?>> entries = currentCalendar.findEntries(selection.getName());
			if (!entries.isEmpty()) {
				calendarView.clearSelection();
				calendarView.setDate(selection.getStart().toLocalDate());
				calendarView.select(entries.get(0));
			}
		}
	}

	private Parent load(String fxml) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
		fxmlLoader.setControllerFactory(springContext::getBean);
		try {
			return fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}