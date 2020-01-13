package de.dc.projectfx.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Calendar.Style;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.model.Interval;
import com.calendarfx.view.CalendarView;

import de.dc.projectfx.controller.converter.ProjectConverter;
import de.dc.projectfx.controller.feature.AppointmentListCell;
import de.dc.projectfx.controller.feature.ProjectNameListCell;
import de.dc.projectfx.controller.model.MainBinding;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.StackPane;

public abstract class BaseMainBindingController extends BaseMainController{

	protected MainBinding model = new MainBinding();
	protected CalendarView calendarView = new CalendarView();
	protected CalendarSource generalCalendarSource = new CalendarSource("General");
	
	public void initialize() {
		StackPane stackPane = createView();		
		stackPaneAppointment.getChildren().add(stackPane);
		
		textAppointmentStart.textProperty().bindBidirectional(model.startProperty());
		textAppointmentEnd.textProperty().bindBidirectional(model.endProperty());
		
		textAppointmentStart.textProperty().addListener(this::calcDuration);
		textAppointmentEnd.textProperty().addListener(this::calcDuration);
		
		labelAppointmentDuration.textProperty().bind(model.durationProperty());
		
		listViewAppointments.setItems(model.sortedDataTask);
		listViewAppointments.setCellFactory(e -> new AppointmentListCell());
		
		textAppointmentSearch.textProperty().addListener(this::onAppointmentSearchChanged);
		
		comboAppointmentProject.setItems(model.sortedDataProject);
		comboAppointmentProject.setCellFactory(e-> new ProjectNameListCell());
		
		listViewProject.setItems(model.sortedDataProject);
		listViewProject.setCellFactory(e-> new ProjectNameListCell());
		
		textProjectName.textProperty().bindBidirectional(model.projectNameProperty());
		textProjectKey.textProperty().bindBidirectional(model.projectKeyProperty());
		textProjectDescription.textProperty().bindBidirectional(model.projectDescriptionProperty());
		
		buttonCreateAppointment.disableProperty().bind(model.disableCreateAppointmentButtonProperty());
		buttonCreateProject.disableProperty().bind(model.disableCreateProjectButtonProperty());
		
		comboAppointmentProject.setConverter(new ProjectConverter(model));
	}

	protected abstract void onAppointmentSearchChanged(ObservableValue<? extends String> observable, String oldValue, String newValue);
	
	private void calcDuration(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		model.calcDuration();
	}
	
	private StackPane createView() {
        calendarView.getCalendarSources().setAll(generalCalendarSource);
        calendarView.setStyle("-fx-background-color: #1E2F3C");
        calendarView.setRequestedTime(LocalTime.now());

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(calendarView); // introPane);

        Thread updateTimeThread = new Thread("Calendar: Update Time Thread") {
            @Override
            public void run() {
                while (true) {
                    Platform.runLater(() -> {
                        calendarView.setToday(LocalDate.now());
                        calendarView.setTime(LocalTime.now());
                    });

                    try {
                        // update every 10 seconds
                        sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        updateTimeThread.setPriority(Thread.MIN_PRIORITY);
        updateTimeThread.setDaemon(true);
        updateTimeThread.start();
		return stackPane;
	}
	
	protected Entry<Object> createEvent(Calendar calendar, String name, LocalDateTime start, LocalDateTime end) {
		Entry<Object> entry = new Entry<>(name, new Interval(start, end));
		calendar.addEntry(entry);
		return entry;
	}
	
	protected Calendar createCalendar(String name) {
        Calendar calendar = new Calendar(name);
        calendar.setStyle(Style.STYLE1);

        generalCalendarSource.getCalendars().add(calendar);
        return calendar;
	}
}