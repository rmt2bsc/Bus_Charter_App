package org.maint.charterorder;

import java.util.List;

import org.dao.mapping.BusDetail;
import org.dao.mapping.Client;
import org.dao.mapping.Orders;
import org.dao.mapping.Quote;

import com.RMT2Base;

/**
 * A bean class for managing key data items for charter order maintenance dialog
 * 
 * @author rterrell
 *
 */
public class CharterOrderMaintParmsBean extends RMT2Base {
    private boolean editable;

    private boolean newOrder;

    private int orderStatusId;
    private int clientId;
    private int quoteId;
    private int orderId;
    private String clientOrderId;

    Client client;
    Quote quote;
    Orders order;
    List<BusDetail> busList;

    /**
     * Default constructor
     */
    public CharterOrderMaintParmsBean() {
        return;
    }

    /**
     * @return the clientId
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * @param clientId
     *            the clientId to set
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    /**
     * @return the quoteId
     */
    public int getQuoteId() {
        return quoteId;
    }

    /**
     * @param quoteId
     *            the quoteId to set
     */
    public void setQuoteId(int tripId) {
        this.quoteId = tripId;
    }

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     *            the orderId to set
     */
    public void setOrderId(int orderId) {
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

    /**
     * @return the newOrder
     */
    public boolean isNewOrder() {
        return newOrder;
    }

    /**
     * @param newOrder
     *            the newOrder to set
     */
    public void setNewOrder(boolean newOrder) {
        this.newOrder = newOrder;
    }

    public boolean isOrderInvoiceReady() {
        return (this.orderStatusId == CharterOrderConst.STATUS_ORDER);
    }

    public boolean isOrderAcceptingChanges() {
        return (this.orderStatusId == CharterOrderConst.STATUS_ORDER || this.orderStatusId == CharterOrderConst.STATUS_INVOICED);
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param clients
     *            the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the quote
     */
    public Quote getQuote() {
        return quote;
    }

    /**
     * @param quote
     *            the quote to set
     */
    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    /**
     * @return the orders
     */
    public Orders getOrder() {
        return order;
    }

    /**
     * @param orders
     *            the orders to set
     */
    public void setOrder(Orders order) {
        this.order = order;
    }

    /**
     * @return the busList
     */
    public List<BusDetail> getBusList() {
        return busList;
    }

    /**
     * @param busList
     *            the busList to set
     */
    public void setBusList(List<BusDetail> busList) {
        this.busList = busList;
    }

    /**
     * @return the orderStatusId
     */
    public int getOrderStatusId() {
        return orderStatusId;
    }

    /**
     * @param orderStatusId
     *            the orderStatusId to set
     */
    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

}
