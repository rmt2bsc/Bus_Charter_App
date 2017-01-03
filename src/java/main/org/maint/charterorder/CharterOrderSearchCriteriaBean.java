package org.maint.charterorder;

import com.RMT2Base;

/**
 * A bean class for managing charter order search criteria.
 * 
 * @author rterrell
 *
 */
class CharterOrderSearchCriteriaBean extends RMT2Base {

    private String clientId;
    private String firstName;
    private String lastName;
    private String company;
    private String tripId;
    private String transComp;
    private String charterParty;
    private String signage;
    private String departDate;
    private String returnDate;
    private String orderId;
    private String orderStatus;
    private String clientOrderId;

    /**
     * Default constructor
     */
    public CharterOrderSearchCriteriaBean() {
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
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company
     *            the company to set
     */
    public void setCompany(String company) {
        this.company = company;
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
     * @return the transComp
     */
    public String getTransComp() {
        return transComp;
    }

    /**
     * @param transComp
     *            the transComp to set
     */
    public void setTransComp(String transComp) {
        this.transComp = transComp;
    }

    /**
     * @return the charterParty
     */
    public String getCharterParty() {
        return charterParty;
    }

    /**
     * @param charterParty
     *            the charterParty to set
     */
    public void setCharterParty(String charterParty) {
        this.charterParty = charterParty;
    }

    /**
     * @return the signage
     */
    public String getSignage() {
        return signage;
    }

    /**
     * @param signage
     *            the signage to set
     */
    public void setSignage(String signage) {
        this.signage = signage;
    }

    /**
     * @return the departDate
     */
    public String getDepartDate() {
        return departDate;
    }

    /**
     * @param departDate
     *            the departDate to set
     */
    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    /**
     * @return the returnDate
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate
     *            the returnDate to set
     */
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
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
     * @return the orderStatus
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * @param orderStatus
     *            the orderStatus to set
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * @return the clientORderId
     */
    public String getClientOrderId() {
        return clientOrderId;
    }

    /**
     * @param clientORderId
     *            the clientORderId to set
     */
    public void setClientOrderId(String clientORderId) {
        this.clientOrderId = clientORderId;
    }
}
