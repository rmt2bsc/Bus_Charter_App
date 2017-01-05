package org.dao.mapping;


import java.util.Date;
import java.io.*;
import com.api.persistence.db.orm.OrmBean;
import com.SystemException;


/**
 * Peer object that maps to the vw_charter_order_invoice_detail database table/view.
 *
 * @author auto generated.
 */
public class VwCharterOrderInvoiceDetail extends OrmBean {




	// Property name constants that belong to respective DataSource, VwCharterOrderInvoiceDetailView

/** The property name constant equivalent to property, OrderId, of respective DataSource view. */
  public static final String PROP_ORDERID = "OrderId";
/** The property name constant equivalent to property, UnitCost, of respective DataSource view. */
  public static final String PROP_UNITCOST = "UnitCost";
/** The property name constant equivalent to property, Description, of respective DataSource view. */
  public static final String PROP_DESCRIPTION = "Description";
/** The property name constant equivalent to property, ClientOrderId, of respective DataSource view. */
  public static final String PROP_CLIENTORDERID = "ClientOrderId";
/** The property name constant equivalent to property, Category, of respective DataSource view. */
  public static final String PROP_CATEGORY = "Category";
/** The property name constant equivalent to property, BusCount, of respective DataSource view. */
  public static final String PROP_BUSCOUNT = "BusCount";
/** The property name constant equivalent to property, Seq, of respective DataSource view. */
  public static final String PROP_SEQ = "Seq";
/** The property name constant equivalent to property, TotalCost, of respective DataSource view. */
  public static final String PROP_TOTALCOST = "TotalCost";



	/** The javabean property equivalent of database column vw_charter_order_invoice_detail.order_id */
  private int orderId;
/** The javabean property equivalent of database column vw_charter_order_invoice_detail.unit_cost */
  private double unitCost;
/** The javabean property equivalent of database column vw_charter_order_invoice_detail.description */
  private String description;
/** The javabean property equivalent of database column vw_charter_order_invoice_detail.client_order_id */
  private String clientOrderId;
/** The javabean property equivalent of database column vw_charter_order_invoice_detail.category */
  private String category;
/** The javabean property equivalent of database column vw_charter_order_invoice_detail.bus_count */
  private double busCount;
/** The javabean property equivalent of database column vw_charter_order_invoice_detail.seq */
  private int seq;
/** The javabean property equivalent of database column vw_charter_order_invoice_detail.total_cost */
  private double totalCost;



	// Getter/Setter Methods

/**
 * Default constructor.
 */
  public VwCharterOrderInvoiceDetail() throws SystemException {
	super();
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
 * Sets the value of member variable unitCost
 */
  public void setUnitCost(double value) {
    this.unitCost = value;
  }
/**
 * Gets the value of member variable unitCost
 */
  public double getUnitCost() {
    return this.unitCost;
  }
/**
 * Sets the value of member variable description
 */
  public void setDescription(String value) {
    this.description = value;
  }
/**
 * Gets the value of member variable description
 */
  public String getDescription() {
    return this.description;
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
 * Sets the value of member variable category
 */
  public void setCategory(String value) {
    this.category = value;
  }
/**
 * Gets the value of member variable category
 */
  public String getCategory() {
    return this.category;
  }
/**
 * Sets the value of member variable busCount
 */
  public void setBusCount(double value) {
    this.busCount = value;
  }
/**
 * Gets the value of member variable busCount
 */
  public double getBusCount() {
    return this.busCount;
  }
/**
 * Sets the value of member variable seq
 */
  public void setSeq(int value) {
    this.seq = value;
  }
/**
 * Gets the value of member variable seq
 */
  public int getSeq() {
    return this.seq;
  }
/**
 * Sets the value of member variable totalCost
 */
  public void setTotalCost(double value) {
    this.totalCost = value;
  }
/**
 * Gets the value of member variable totalCost
 */
  public double getTotalCost() {
    return this.totalCost;
  }
/**
 * Stubbed initialization method designed to implemented by developer.

 */
  public void initBean() throws SystemException {}
}