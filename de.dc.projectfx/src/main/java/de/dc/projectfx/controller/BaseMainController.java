package de.dc.projectfx.controller;

import de.dc.projectfx.model.Project;
import de.dc.projectfx.model.Task;
import de.dc.projectfx.model.User;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public abstract class BaseMainController {

	@FXML
	protected StackPane stackPaneMain;
	
	@FXML
	protected ComboBox<User> comboProjectLead;
	
	@FXML
	protected ListView<Project> listViewProject;
	
	@FXML
	protected FontAwesomeIconView labelNavAgenda;
	
	@FXML
	protected FontAwesomeIconView labelNavProject;

	@FXML
	protected FontAwesomeIconView labelNavHome;
	
	@FXML
	protected SplitPane paneProject;
	
	@FXML
	protected StackPane stackPaneAppointment;
	
	@FXML
	protected VBox paneNewAppointmentForn;
	
    @FXML
    protected Button buttonCancelAppointment;

    @FXML
    protected Button buttonNewAppointment;
	
	@FXML
	protected SplitPane paneAgenda;

	@FXML
	protected TextField textProjectKey;
	
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
	protected ComboBox<Project> comboAppointmentProject;

	@FXML
	protected TextArea textAppointmentDescription;

	@FXML
	protected Button buttonCreateAppointment;

	@FXML
	protected abstract void onButtonAction(ActionEvent event);

	@FXML
	protected abstract void onMouseClicked(MouseEvent event);

}
