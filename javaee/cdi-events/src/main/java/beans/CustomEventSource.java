package beans;

import java.util.function.Supplier;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import events.CustomEvent;
import qualifiers.Admin;

@Dependent
public class CustomEventSource extends CustomBean {

	private final Supplier<CustomEvent> eventSupplier = () -> new CustomEvent(getRandomInt());

	@Inject
	private Event<CustomEvent> event;

	public void fireRandomEvent() {
		event.fire(eventSupplier.get());
	}

	public void fireAsycncRandomEvent() {
		event.fireAsync(eventSupplier.get());
	}

	public void fireRandomAdminEvent() {
		event.select(CustomEvent.class, new Admin.Literal()).fire(eventSupplier.get());
	}
}
