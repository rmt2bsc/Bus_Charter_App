package org.maint.charterorder;

import com.ui.event.BaseEvent;

/**
 * A notification source containing information pertaining to the changing of
 * the charter order's total cost.
 * 
 * @author rterrell
 *
 */
public class TotalCostChangedEvent extends BaseEvent {

    private static final long serialVersionUID = -6324768544010430938L;

    private double cost;

    /**
     * @param source
     * @param eventId
     */
    public TotalCostChangedEvent(Object source, int eventId, double cost) {
        super(source, eventId);
        this.cost = cost;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

}
