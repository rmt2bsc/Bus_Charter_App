package org.maint.charterorder;

import java.util.EventListener;

/**
 * A listener for tracking the changes in total cost of the charter order.
 * 
 * @author rterrell
 *
 */
public interface TotalCostChangedListener extends EventListener {

    /**
     * Indicates that the total cost of the charter order has changed.
     * 
     * @param evt
     *            an instance of {@link TotalCostChangedEvent} containing the
     *            cost of the charter order.
     */
    void charterOrderTotalCostChanged(TotalCostChangedEvent evt);

}
