package org.dao.mapping;


import java.util.Date;
import java.io.*;
import com.api.persistence.db.orm.OrmBean;
import com.SystemException;


/**
 * Peer object that maps to the vw_charter_order_list database table/view.
 *
 * @author auto generated.
 */
public class VwCharterOrderList extends OrmBean {




	// Property name constants that belong to respective DataSource, VwCharterOrderListView

/** The property name constant equivalent to property, ClientId, of respective DataSource view. */
  public static final String PROP_CLIENTID = "ClientId";
/** The property name constant equivalent to property, ContactFname, of respective DataSource view. */
  public static final String PROP_CONTACTFNAME = "ContactFname";
/** The property name constant equivalent to property, ContactLname, of respective DataSource view. */
  public static final String PROP_CONTACTLNAME = "ContactLname";
/** The property name constant equivalent to property, ContactCompany, of respective DataSource view. */
  public static final String PROP_CONTACTCOMPANY = "ContactCompany";
/** The property name constant equivalent to property, ContactCompanyName, of respective DataSource view. */
  public static final String PROP_CONTACTCOMPANYNAME = "ContactCompanyName";
/** The property name constant equivalent to property, QuoteId, of respective DataSource view. */
  public static final String PROP_QUOTEID = "QuoteId";
/** The property name constant equivalent to property, TransportCompanyId, of respective DataSource view. */
  public static final String PROP_TRANSPORTCOMPANYID = "TransportCompanyId";
/** The property name constant equivalent to property, TransportCompany, of respective DataSource view. */
  public static final String PROP_TRANSPORTCOMPANY = "TransportCompany";
/** The property name constant equivalent to property, Signage, of respective DataSource view. */
  public static final String PROP_SIGNAGE = "Signage";
/** The property name constant equivalent to property, CharterParty, of respective DataSource view. */
  public static final String PROP_CHARTERPARTY = "CharterParty";
/** The property name constant equivalent to property, DepartDate, of respective DataSource view. */
  public static final String PROP_DEPARTDATE = "DepartDate";
/** The property name constant equivalent to property, ReturnDate, of respective DataSource view. */
  public static final String PROP_RETURNDATE = "ReturnDate";
/** The property name constant equivalent to property, OrderId, of respective DataSource view. */
  public static final String PROP_ORDERID = "OrderId";
/** The property name constant equivalent to property, StatusId, of respective DataSource view. */
  public static final String PROP_STATUSID = "StatusId";
/** The property name constant equivalent to property, Status, of respective DataSource view. */
  public static final String PROP_STATUS = "Status";
/** The property name constant equivalent to property, Destination, of respective DataSource view. */
  public static final String PROP_DESTINATION = "Destination";
/** The property name constant equivalent to property, ClientOrderId, of respective DataSource view. */
  public static final String PROP_CLIENTORDERID = "ClientOrderId";
/** The property name constant equivalent to property, BalanceDue, of respective DataSource view. */
  public static final String PROP_BALANCEDUE = "BalanceDue";
/** The property name constant equivalent to property, OrderTotal, of respective DataSource view. */
  public static final String PROP_ORDERTOTAL = "OrderTotal";
/** The property name constant equivalent to property, Expenses, of respective DataSource view. */
  public static final String PROP_EXPENSES = "Expenses";



	/** The javabean property equivalent of database column vw_charter_order_list.client_id */
  private int clientId;
/** The javabean property equivalent of database column vw_charter_order_list.contact_fname */
  private String contactFname;
/** The javabean property equivalent of database column vw_charter_order_list.contact_lname */
  private String contactLname;
/** The javabean property equivalent of database column vw_charter_order_list.contact_company */
  private int contactCompany;
/** The javabean property equivalent of database column vw_charter_order_list.contact_company_name */
  private String contactCompanyName;
/** The javabean property equivalent of database column vw_charter_order_list.quote_id */
  private int quoteId;
/** The javabean property equivalent of database column vw_charter_order_list.transport_company_id */
  private int transportCompanyId;
/** The javabean property equivalent of database column vw_charter_order_list.transport_company */
  private String transportCompany;
/** The javabean property equivalent of database column vw_charter_order_list.signage */
  private String signage;
/** The javabean property equivalent of database column vw_charter_order_list.charter_party */
  private String charterParty;
/** The javabean property equivalent of database column vw_charter_order_list.depart_date */
  private java.util.Date departDate;
/** The javabean property equivalent of database column vw_charter_order_list.return_date */
  private java.util.Date returnDate;
/** The javabean property equivalent of database column vw_charter_order_list.order_id */
  private int orderId;
/** The javabean property equivalent of database column vw_charter_order_list.status_id */
  private int statusId;
/** The javabean property equivalent of database column vw_charter_order_list.status */
  private String status;
/** The javabean property equivalent of database column vw_charter_order_list.destination */
  private String destination;
/** The javabean property equivalent of database column vw_charter_order_list.client_order_id */
  private String clientOrderId;
/** The javabean property equivalent of database column vw_charter_order_list.balance_due */
  private double balanceDue;
/** The javabean property equivalent of database column vw_charter_order_list.order_total */
  private double orderTotal;
/** The javabean property equivalent of database column vw_charter_order_list.expenses */
  private double expenses;



	// Getter/Setter Methods

/**
 * Default constructor.
 */
  public VwCharterOrderList() throws SystemException {
	super();
 }
/**
 * Sets the value of member variable clientId
 */
  public void setClientId(int value) {
    this.clientId = value;
  }
/**
 * Gets the value of member variable clientId
 */
  public int getClientId() {
    return this.clientId;
  }
/**
 * Sets the value of member variable contactFname
 */
  public void setContactFname(String value) {
    this.contactFname = value;
  }
/**
 * Gets the value of member variable contactFname
 */
  public String getContactFname() {
    return this.contactFname;
  }
/**
 * Sets the value of member variable contactLname
 */
  public void setContactLname(String value) {
    this.contactLname = value;
  }
/**
 * Gets the value of member variable contactLname
 */
  public String getContactLname() {
    return this.contactLname;
  }
/**
 * Sets the value of member variable contactCompany
 */
  public void setContactCompany(int value) {
    this.contactCompany = value;
  }
/**
 * Gets the value of member variable contactCompany
 */
  public int getContactCompany() {
    return this.contactCompany;
  }
/**
 * Sets the value of member variable contactCompanyName
 */
  public void setContactCompanyName(String value) {
    this.contactCompanyName = value;
  }
/**
 * Gets the value of member variable contactCompanyName
 */
  public String getContactCompanyName() {
    return this.contactCompanyName;
  }
/**
 * Sets the value of member variable quoteId
 */
  public void setQuoteId(int value) {
    this.quoteId = value;
  }
/**
 * Gets the value of member variable quoteId
 */
  public int getQuoteId() {
    return this.quoteId;
  }
/**
 * Sets the value of member variable transportCompanyId
 */
  public void setTransportCompanyId(int value) {
    this.transportCompanyId = value;
  }
/**
 * Gets the value of member variable transportCompanyId
 */
  public int getTransportCompanyId() {
    return this.transportCompanyId;
  }
/**
 * Sets the value of member variable transportCompany
 */
  public void setTransportCompany(String value) {
    this.transportCompany = value;
  }
/**
 * Gets the value of member variable transportCompany
 */
  public String getTransportCompany() {
    return this.transportCompany;
  }
/**
 * Sets the value of member variable signage
 */
  public void setSignage(String value) {
    this.signage = value;
  }
/**
 * Gets the value of member variable signage
 */
  public String getSignage() {
    return this.signage;
  }
/**
 * Sets the value of member variable charterParty
 */
  public void setCharterParty(String value) {
    this.charterParty = value;
  }
/**
 * Gets the value of member variable charterParty
 */
  public String getCharterParty() {
    return this.charterParty;
  }
/**
 * Sets the value of member variable departDate
 */
  public void setDepartDate(java.util.Date value) {
    this.departDate = value;
  }
/**
 * Gets the value of member variable departDate
 */
  public java.util.Date getDepartDate() {
    return this.departDate;
  }
/**
 * Sets the value of member variable returnDate
 */
  public void setReturnDate(java.util.Date value) {
    this.returnDate = value;
  }
/**
 * Gets the value of member variable returnDate
 */
  public java.util.Date getReturnDate() {
    return this.returnDate;
  }
/**
 * Sets the value of member variable orderId
 */
  public void setOrderId(int value) {
    this.orderId = value;
  }
/**
 * Gets the value of member variable orderId
 */
  public int getOrderId() {
    return this.orderId;
  }
/**
 * Sets the value of member variable statusId
 */
  public void setStatusId(int value) {
    this.statusId = value;
  }
/**
 * Gets the value of member variable statusId
 */
  public int getStatusId() {
    return this.statusId;
  }
/**
 * Sets the value of member variable status
 */
  public void setStatus(String value) {
    this.status = value;
  }
/**
 * Gets the value of member variable status
 */
  public String getStatus() {
    return this.status;
  }
/**
 * Sets the value of member variable destination
 */
  public void setDestination(String value) {
    this.destination = value;
  }
/**
 * Gets the value of member variable destination
 */
  public String getDestination() {
    return this.destination;
  }
/**
 * Sets the value of member variable clientOrderId
 */
  public void setClientOrderId(String value) {
    this.clientOrderId = value;
  }
/**
 * Gets the value of member variable clientOrderId
 */
  public String getClientOrderId() {
    return this.clientOrderId;
  }
/**
 * Sets the value of member variable balanceDue
 */
  public void setBalanceDue(double value) {
    this.balanceDue = value;
  }
/**
 * Gets the value of member variable balanceDue
 */
  public double getBalanceDue() {
    return this.balanceDue;
  }
/**
 * Sets the value of member variable orderTotal
 */
  public void setOrderTotal(double value) {
    this.orderTotal = value;
  }
/**
 * Gets the value of member variable orderTotal
 */
  public double getOrderTotal() {
    return this.orderTotal;
  }
/**
 * Sets the value of member variable expenses
 */
  public void setExpenses(double value) {
    this.expenses = value;
  }
/**
 * Gets the value of member variable expenses
 */
  public double getExpenses() {
    return this.expenses;
  }
/**
 * Stubbed initialization method designed to implemented by developer.

 */
  public void initBean() throws SystemException {}
}