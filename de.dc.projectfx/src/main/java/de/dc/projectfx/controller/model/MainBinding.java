package de.dc.projectfx.controller.model;

import java.time.LocalTime;

import de.dc.projectfx.model.ProjectCategory;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class MainBinding {

	private ObjectProperty<LocalTime> start = new SimpleObjectProperty<>();
	private ObjectProperty<LocalTime> end = new SimpleObjectProperty<>();
	private ObjectProperty<ProjectCategory> category = new SimpleObjectProperty<>();

	public final ObjectProperty<LocalTime> startProperty() {
		return this.start;
	}

	public final LocalTime getStart() {
		return this.startProperty().get();
	}

	public final void setStart(final LocalTime start) {
		this.startProperty().set(start);
	}

	public final ObjectProperty<LocalTime> endProperty() {
		return this.end;
	}

	public final LocalTime getEnd() {
		return this.endProperty().get();
	}

	public final void setEnd(final LocalTime end) {
		this.endProperty().set(end);
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

}
