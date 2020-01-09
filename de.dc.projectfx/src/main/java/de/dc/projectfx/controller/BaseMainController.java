package de.dc.projectfx.controller;

import de.dc.projectfx.model.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public abstract class BaseMainController {

	@FXML
	protected SplitPane paneAgenda;

	@FXML
	protected Label labelAppointmentsCount;

	@FXML
	protected TextField textAppointmentSearch;

	@FXML
	protected ListView<Task> listViewAppointments;

	@FXML
	protected TextField textProjectName;

	@FXML
	protected TextArea textProjectDescription;

	@FXML
	protected Button buttonCreateProject;

	@FXML
	protected TextField textAppointmentStart;

	@FXML
	protected Button buttonSetStart;

	@FXML
	protected TextField textAppointmentEnd;

	@FXML
	protected Button buttonSetEnd;

	@FXML
	protected Label labelAppointmentDuration;

	@FXML
	protected ComboBox<?> comboAppointmentProject;

	@FXML
	protected TextArea textAppointmentDescription;

	@FXML
	protected Button buttonCreateAppointment;

	@FXML
	protected abstract void onButtonAction(ActionEvent event);

}
