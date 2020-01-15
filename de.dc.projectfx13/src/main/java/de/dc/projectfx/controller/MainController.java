package de.dc.projectfx.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Entry;

import de.dc.projectfx.model.Task;
import de.dc.projectfx.repository.TaskRepository;
import de.dc.projectfx.service.IProjectService;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

@Controller
public class MainController extends BaseMainBindingController {

	@Autowired TaskRepository taskRepository;
	@Autowired IProjectService projectService;

	private Calendar currentCalendar;

	@Override
	public void initialize() {
		super.initialize();
		model.dataTask.addAll(taskRepository.findAll());
		model.dataProject.addAll(projectService.findAll());
		currentCalendar = createCalendar("General");
		model.dataTask.forEach(a -> createEvent(currentCalendar, a.getName(), a.getStart(), a.getEnd()));

		listViewAppointments.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Task>() {
			@Override
			public void changed(ObservableValue<? extends Task> observable, Task oldValue, Task newValue) {
				if (newValue != null) {
					Platform.runLater(() -> {
						List<Entry<?>> entries = currentCalendar.findEntries(newValue.getName());
						if (!entries.isEmpty()) {
							calendarView.clearSelection();
							calendarView.setDate(newValue.getStart().toLocalDate());
							calendarView.select(entries.get(0));
						}
					});
				}
			}
		});
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
			String name = comboAppointmentProject.getValue().toString();
			createEvent(currentCalendar, name, start, end);
			Task entity = new Task();
			entity.setName(name);
			entity.setEnd(end);
			entity.setStart(start);
			entity.setCreatedOn(LocalDateTime.now());
			taskRepository.save(entity);

			model.dataTask.add(entity);
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
	}
}