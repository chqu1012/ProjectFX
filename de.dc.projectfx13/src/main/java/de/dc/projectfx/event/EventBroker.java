package de.dc.projectfx.event;

import org.greenrobot.eventbus.EventBus;

public enum EventBroker {
	INSTANCE;

	private EventBus eventBus = new EventBus();
	
	public void post(EventContext context) {
		eventBus.post(context);
	}

	public void postSticky(EventContext context) {
		eventBus.postSticky(context);
	}
	
	public void register(Object object) {
		eventBus.register(object);
	}

	public void unregister(Object object) {
		eventBus.unregister(object);
	}
}
