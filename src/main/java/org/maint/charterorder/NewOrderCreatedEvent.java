package org.maint.charterorder;

import com.ui.event.BaseEvent;

/**
 * A notification source containing information indicating that the charter
 * order has moved from "Quote" to "Order" status.
 * 
 * @author rterrell
 *
 */
public class NewOrderCreatedEvent extends BaseEvent {

    private static final long serialVersionUID = -6324768544010430938L;

    private int orderId;

    /**
     * @param source
     * @param eventId
     */
    public NewOrderCreatedEvent(Object source, int newOrderId) {
        super(source, 0);
        this.orderId = newOrderId;
    }

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

}
