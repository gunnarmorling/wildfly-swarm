package org.jboss.unimbus.events;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * @author Ken Finnigan
 */
@ApplicationScoped
public class EventEmitter {

    @Inject
    Event<LifecycleEvent> event;

    public void fireScan() {
        event.fire( new LifecycleEvent.Scan() );
    }

    public void fireInitialize() {
        event.fire( new LifecycleEvent.Initialize() );
    }

    public void fireDeploy() {
        event.fire( new LifecycleEvent.Deploy() );
    }

    public void fireBeforeStart() {
        event.fire( new LifecycleEvent.BeforeStart());
    }

    public void fireStart() {
        event.fire( new LifecycleEvent.Start());
    }

    public void fireAfterStart() {
        event.fire( new LifecycleEvent.AfterStart());
    }

}
