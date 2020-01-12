package de.dc.projectfx.controller.feature;

import de.dc.projectfx.model.Task;
import javafx.scene.control.ListCell;

public class AppointmentListCell extends ListCell<Task> {

	@Override
	protected void updateItem(Task item, boolean empty) {
		super.updateItem(item, empty);
		if (item==null || empty) {
			setText(null);
		}else {
			setText(String.format("%s (from: %s, until: %s)", item.getName(), item.getStart().toString(), item.getEnd().toString()));
		}
	}
}
