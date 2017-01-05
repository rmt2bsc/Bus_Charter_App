package org.dao.mapping;


import java.util.Date;
import java.io.*;
import com.api.persistence.db.orm.OrmBean;
import com.SystemException;


/**
 * Peer object that maps to the vw_transaction_list database table/view.
 *
 * @author auto generated.
 */
public class VwTransactionList extends OrmBean {




	// Property name constants that belong to respective DataSource, VwTransactionListView

/** The property name constant equivalent to property, Id, of respective DataSource view. */
  public static final String PROP_ID = "Id";
/** The property name constant equivalent to property, OrderId, of respective DataSource view. */
  public static final String PROP_ORDERID = "OrderId";
/** The property name constant equivalent to property, Amount, of respective DataSource view. */
  public static final String PROP_AMOUNT = "Amount";
/** The property name constant equivalent to property, TransDate, of respective DataSource view. */
  public static final String PROP_TRANSDATE = "TransDate";
/** The property name constant equivalent to property, TransTypeId, of respective DataSource view. */
  public static final String PROP_TRANSTYPEID = "TransTypeId";
/** The property name constant equivalent to property, TransTypeDesc, of respective DataSource view. */
  public static final String PROP_TRANSTYPEDESC = "TransTypeDesc";
/** The property name constant equivalent to property, PaymentType, of respective DataSource view. */
  public static final String PROP_PAYMENTTYPE = "PaymentType";
/** The property name constant equivalent to property, PaymentTypeDesc, of respective DataSource view. */
  public static final String PROP_PAYMENTTYPEDESC = "PaymentTypeDesc";
/** The property name constant equivalent to property, CheckNo, of respective DataSource view. */
  public static final String PROP_CHECKNO = "CheckNo";
/** The property name constant equivalent to property, Notes, of respective DataSource view. */
  public static final String PROP_NOTES = "Notes";
/** The property name constant equivalent to property, DateCreated, of respective DataSource view. */
  public static final String PROP_DATECREATED = "DateCreated";
/** The property name constant equivalent to property, DateUpdated, of respective DataSource view. */
  public static final String PROP_DATEUPDATED = "DateUpdated";
/** The property name constant equivalent to property, UserId, of respective DataSource view. */
  public static final String PROP_USERID = "UserId";



	/** The javabean property equivalent of database column vw_transaction_list.id */
  private int id;
/** The javabean property equivalent of database column vw_transaction_list.order_id */
  private int orderId;
/** The javabean property equivalent of database column vw_transaction_list.amount */
  private double amount;
/** The javabean property equivalent of database column vw_transaction_list.trans_date */
  private java.util.Date transDate;
/** The javabean property equivalent of database column vw_transaction_list.trans_type_id */
  private int transTypeId;
/** The javabean property equivalent of database column vw_transaction_list.trans_type_desc */
  private String transTypeDesc;
/** The javabean property equivalent of database column vw_transaction_list.payment_type */
  private int paymentType;
/** The javabean property equivalent of database column vw_transaction_list.payment_type_desc */
  private String paymentTypeDesc;
/** The javabean property equivalent of database column vw_transaction_list.check_no */
  private String checkNo;
/** The javabean property equivalent of database column vw_transaction_list.notes */
  private String notes;
/** The javabean property equivalent of database column vw_transaction_list.date_created */
  private java.util.Date dateCreated;
/** The javabean property equivalent of database column vw_transaction_list.date_updated */
  private java.util.Date dateUpdated;
/** The javabean property equivalent of database column vw_transaction_list.user_id */
  private String userId;



	// Getter/Setter Methods

/**
 * Default constructor.
 */
  public VwTransactionList() throws SystemException {
	super();
 }
/**
 * Sets the value of member variable id
 */
  public void setId(int value) {
    this.id = value;
  }
/**
 * Gets the value of member variable id
 */
  public int getId() {
    return this.id;
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
 * Sets the value of member variable amount
 */
  public void setAmount(double value) {
    this.amount = value;
  }
/**
 * Gets the value of member variable amount
 */
  public double getAmount() {
    return this.amount;
  }
/**
 * Sets the value of member variable transDate
 */
  public void setTransDate(java.util.Date value) {
    this.transDate = value;
  }
/**
 * Gets the value of member variable transDate
 */
  public java.util.Date getTransDate() {
    return this.transDate;
  }
/**
 * Sets the value of member variable transTypeId
 */
  public void setTransTypeId(int value) {
    this.transTypeId = value;
  }
/**
 * Gets the value of member variable transTypeId
 */
  public int getTransTypeId() {
    return this.transTypeId;
  }
/**
 * Sets the value of member variable transTypeDesc
 */
  public void setTransTypeDesc(String value) {
    this.transTypeDesc = value;
  }
/**
 * Gets the value of member variable transTypeDesc
 */
  public String getTransTypeDesc() {
    return this.transTypeDesc;
  }
/**
 * Sets the value of member variable paymentType
 */
  public void setPaymentType(int value) {
    this.paymentType = value;
  }
/**
 * Gets the value of member variable paymentType
 */
  public int getPaymentType() {
    return this.paymentType;
  }
/**
 * Sets the value of member variable paymentTypeDesc
 */
  public void setPaymentTypeDesc(String value) {
    this.paymentTypeDesc = value;
  }
/**
 * Gets the value of member variable paymentTypeDesc
 */
  public String getPaymentTypeDesc() {
    return this.paymentTypeDesc;
  }
/**
 * Sets the value of member variable checkNo
 */
  public void setCheckNo(String value) {
    this.checkNo = value;
  }
/**
 * Gets the value of member variable checkNo
 */
  public String getCheckNo() {
    return this.checkNo;
  }
/**
 * Sets the value of member variable notes
 */
  public void setNotes(String value) {
    this.notes = value;
  }
/**
 * Gets the value of member variable notes
 */
  public String getNotes() {
    return this.notes;
  }
/**
 * Sets the value of member variable dateCreated
 */
  public void setDateCreated(java.util.Date value) {
    this.dateCreated = value;
  }
/**
 * Gets the value of member variable dateCreated
 */
  public java.util.Date getDateCreated() {
    return this.dateCreated;
  }
/**
 * Sets the value of member variable dateUpdated
 */
  public void setDateUpdated(java.util.Date value) {
    this.dateUpdated = value;
  }
/**
 * Gets the value of member variable dateUpdated
 */
  public java.util.Date getDateUpdated() {
    return this.dateUpdated;
  }
/**
 * Sets the value of member variable userId
 */
  public void setUserId(String value) {
    this.userId = value;
  }
/**
 * Gets the value of member variable userId
 */
  public String getUserId() {
    return this.userId;
  }
/**
 * Stubbed initialization method designed to implemented by developer.

 */
  public void initBean() throws SystemException {}
}