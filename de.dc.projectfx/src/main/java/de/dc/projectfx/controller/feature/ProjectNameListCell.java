package de.dc.projectfx.controller.feature;

import de.dc.projectfx.model.Project;

import javafx.scene.control.ListCell;

public class ProjectNameListCell extends ListCell<Project>{

	@Override
	protected void updateItem(Project item, boolean empty) {
		super.updateItem(item, empty);
		if (item == null || empty) {
			setText(null);
		}else {
			setText(item.getKey()+"-"+item.getName());
		}
	};
}
