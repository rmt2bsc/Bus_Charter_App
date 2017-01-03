package org.maint.charterorder;

import com.RMT2Base;

/**
 * A bean class for managing key data items for charter order maintenance dialog
 * 
 * @author rterrell
 *
 */
public class CharterOrderMaintKeyBean extends RMT2Base {
    private boolean editable;
    private String clientId;
    private String tripId;
    private String orderId;
    private String clientOrderId;

    /**
     * Default constructor
     */
    public CharterOrderMaintKeyBean() {
        return;
    }

    /**
     * @return the clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @param clientId
     *            the clientId to set
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * @return the tripId
     */
    public String getTripId() {
        return tripId;
    }

    /**
     * @param tripId
     *            the tripId to set
     */
    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     *            the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the clientOrderId
     */
    public String getClientOrderId() {
        return clientOrderId;
    }

    /**
     * @param clientOrderId
     *            the clientOrderId to set
     */
    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    /**
     * @return the editable
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * @param editable
     *            the editable to set
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
