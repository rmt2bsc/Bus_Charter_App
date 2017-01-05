package org.maint.charterorder;

import java.util.EventListener;

/**
 * A listener for tracking when the charter order has moved from "Quote" to
 * "Order" status.
 * 
 * @author rterrell
 *
 */
public interface NewOrderCreatedListener extends EventListener {

    /**
     * Handler for the creation of a new charter order.
     * 
     * @param evt
     *            an instance of {@link NewOrderCreatedEvent} containing the
     *            cost of the charter order.
     */
    void handleNewOrderCreation(NewOrderCreatedEvent evt);

}
