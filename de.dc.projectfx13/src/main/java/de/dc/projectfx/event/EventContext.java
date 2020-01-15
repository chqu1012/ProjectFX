package de.dc.projectfx.event;

public class EventContext {

	private String id;
	private Object input;

	public EventContext(String id, Object input) {
		this.id = id;
		this.input = input;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getInput() {
		return input;
	}

	public void setInput(Object input) {
		this.input = input;
	};
}
