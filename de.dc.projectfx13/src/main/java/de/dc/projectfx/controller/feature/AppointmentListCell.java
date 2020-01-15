package de.dc.projectfx.controller.feature;

import java.time.format.DateTimeFormatter;

import de.dc.projectfx.model.Task;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;

public class AppointmentListCell extends ListCell<Task> {

	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
	
	@Override
	protected void updateItem(Task item, boolean empty) {
		super.updateItem(item, empty);
		if (item==null || empty) {
			setText(null);
		}else {
			VBox parent = new VBox(1.0);
			parent.getChildren().add(new Label("Name:\t\t"+item.getName()));
			parent.getChildren().add(new Label("\tStart:\t"+item.getStart().format(dtf)));
			parent.getChildren().add(new Label("\tEnd:\t\t"+item.getEnd().format(dtf)));
			setGraphic(parent);
		}
	}
}
