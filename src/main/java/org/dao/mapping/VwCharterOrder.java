package org.dao.mapping;


import java.util.Date;
import java.io.*;
import com.api.persistence.db.orm.OrmBean;
import com.SystemException;


/**
 * Peer object that maps to the vw_charter_order database table/view.
 *
 * @author auto generated.
 */
public class VwCharterOrder extends OrmBean {




	// Property name constants that belong to respective DataSource, VwCharterOrderView

/** The property name constant equivalent to property, OrderId, of respective DataSource view. */
  public static final String PROP_ORDERID = "OrderId";
/** The property name constant equivalent to property, QuoteId, of respective DataSource view. */
  public static final String PROP_QUOTEID = "QuoteId";
/** The property name constant equivalent to property, StatusCode, of respective DataSource view. */
  public static final String PROP_STATUSCODE = "StatusCode";
/** The property name constant equivalent to property, Status, of respective DataSource view. */
  public static final String PROP_STATUS = "Status";
/** The property name constant equivalent to property, FlatRate, of respective DataSource view. */
  public static final String PROP_FLATRATE = "FlatRate";
/** The property name constant equivalent to property, MilageRate, of respective DataSource view. */
  public static final String PROP_MILAGERATE = "MilageRate";
/** The property name constant equivalent to property, HourlyRate, of respective DataSource view. */
  public static final String PROP_HOURLYRATE = "HourlyRate";
/** The property name constant equivalent to property, HourlyRate2, of respective DataSource view. */
  public static final String PROP_HOURLYRATE2 = "HourlyRate2";
/** The property name constant equivalent to property, TotalHours, of respective DataSource view. */
  public static final String PROP_TOTALHOURS = "TotalHours";
/** The property name constant equivalent to property, LiveMiles, of respective DataSource view. */
  public static final String PROP_LIVEMILES = "LiveMiles";
/** The property name constant equivalent to property, DeadheadMiles, of respective DataSource view. */
  public static final String PROP_DEADHEADMILES = "DeadheadMiles";
/** The property name constant equivalent to property, DropoffCollect, of respective DataSource view. */
  public static final String PROP_DROPOFFCOLLECT = "DropoffCollect";
/** The property name constant equivalent to property, DropoffCollectTender, of respective DataSource view. */
  public static final String PROP_DROPOFFCOLLECTTENDER = "DropoffCollectTender";
/** The property name constant equivalent to property, DateCreated, of respective DataSource view. */
  public static final String PROP_DATECREATED = "DateCreated";
/** The property name constant equivalent to property, DateUpdated, of respective DataSource view. */
  public static final String PROP_DATEUPDATED = "DateUpdated";
/** The property name constant equivalent to property, UserId, of respective DataSource view. */
  public static final String PROP_USERID = "UserId";
/** The property name constant equivalent to property, Buscost, of respective DataSource view. */
  public static final String PROP_BUSCOST = "Buscost";
/** The property name constant equivalent to property, Overridestatus, of respective DataSource view. */
  public static final String PROP_OVERRIDESTATUS = "Overridestatus";
/** The property name constant equivalent to property, ClientOrderId, of respective DataSource view. */
  public static final String PROP_CLIENTORDERID = "ClientOrderId";
/** The property name constant equivalent to property, DeadheadMilageRate, of respective DataSource view. */
  public static final String PROP_DEADHEADMILAGERATE = "DeadheadMilageRate";
/** The property name constant equivalent to property, BusCount, of respective DataSource view. */
  public static final String PROP_BUSCOUNT = "BusCount";
/** The property name constant equivalent to property, MinHourFactor, of respective DataSource view. */
  public static final String PROP_MINHOURFACTOR = "MinHourFactor";
/** The property name constant equivalent to property, MinHours, of respective DataSource view. */
  public static final String PROP_MINHOURS = "MinHours";
/** The property name constant equivalent to property, MileageSubtotal, of respective DataSource view. */
  public static final String PROP_MILEAGESUBTOTAL = "MileageSubtotal";
/** The property name constant equivalent to property, HourlySubtotal, of respective DataSource view. */
  public static final String PROP_HOURLYSUBTOTAL = "HourlySubtotal";
/** The property name constant equivalent to property, TripTotal, of respective DataSource view. */
  public static final String PROP_TRIPTOTAL = "TripTotal";



	/** The javabean property equivalent of database column vw_charter_order.order_id */
  private int orderId;
/** The javabean property equivalent of database column vw_charter_order.quote_id */
  private int quoteId;
/** The javabean property equivalent of database column vw_charter_order.status_code */
  private int statusCode;
/** The javabean property equivalent of database column vw_charter_order.status */
  private String status;
/** The javabean property equivalent of database column vw_charter_order.flat_rate */
  private double flatRate;
/** The javabean property equivalent of database column vw_charter_order.milage_rate */
  private double milageRate;
/** The javabean property equivalent of database column vw_charter_order.hourly_rate */
  private double hourlyRate;
/** The javabean property equivalent of database column vw_charter_order.hourly_rate2 */
  private double hourlyRate2;
/** The javabean property equivalent of database column vw_charter_order.total_hours */
  private int totalHours;
/** The javabean property equivalent of database column vw_charter_order.live_miles */
  private int liveMiles;
/** The javabean property equivalent of database column vw_charter_order.deadhead_miles */
  private int deadheadMiles;
/** The javabean property equivalent of database column vw_charter_order.dropoff_collect */
  private String dropoffCollect;
/** The javabean property equivalent of database column vw_charter_order.dropoff_collect_tender */
  private int dropoffCollectTender;
/** The javabean property equivalent of database column vw_charter_order.date_created */
  private java.util.Date dateCreated;
/** The javabean property equivalent of database column vw_charter_order.date_updated */
  private java.util.Date dateUpdated;
/** The javabean property equivalent of database column vw_charter_order.user_id */
  private String userId;
/** The javabean property equivalent of database column vw_charter_order.buscost */
  private double buscost;
/** The javabean property equivalent of database column vw_charter_order.overridestatus */
  private char overridestatus;
/** The javabean property equivalent of database column vw_charter_order.client_order_id */
  private String clientOrderId;
/** The javabean property equivalent of database column vw_charter_order.deadhead_milage_rate */
  private double deadheadMilageRate;
/** The javabean property equivalent of database column vw_charter_order.bus_count */
  private int busCount;
/** The javabean property equivalent of database column vw_charter_order.min_hour_factor */
  private int minHourFactor;
/** The javabean property equivalent of database column vw_charter_order.min_hours */
  private double minHours;
/** The javabean property equivalent of database column vw_charter_order.mileage_subtotal */
  private double mileageSubtotal;
/** The javabean property equivalent of database column vw_charter_order.hourly_subtotal */
  private double hourlySubtotal;
/** The javabean property equivalent of database column vw_charter_order.trip_total */
  private double tripTotal;



	// Getter/Setter Methods

/**
 * Default constructor.
 */
  public VwCharterOrder() throws SystemException {
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
 * Sets the value of member variable statusCode
 */
  public void setStatusCode(int value) {
    this.statusCode = value;
  }
/**
 * Gets the value of member variable statusCode
 */
  public int getStatusCode() {
    return this.statusCode;
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
 * Sets the value of member variable flatRate
 */
  public void setFlatRate(double value) {
    this.flatRate = value;
  }
/**
 * Gets the value of member variable flatRate
 */
  public double getFlatRate() {
    return this.flatRate;
  }
/**
 * Sets the value of member variable milageRate
 */
  public void setMilageRate(double value) {
    this.milageRate = value;
  }
/**
 * Gets the value of member variable milageRate
 */
  public double getMilageRate() {
    return this.milageRate;
  }
/**
 * Sets the value of member variable hourlyRate
 */
  public void setHourlyRate(double value) {
    this.hourlyRate = value;
  }
/**
 * Gets the value of member variable hourlyRate
 */
  public double getHourlyRate() {
    return this.hourlyRate;
  }
/**
 * Sets the value of member variable hourlyRate2
 */
  public void setHourlyRate2(double value) {
    this.hourlyRate2 = value;
  }
/**
 * Gets the value of member variable hourlyRate2
 */
  public double getHourlyRate2() {
    return this.hourlyRate2;
  }
/**
 * Sets the value of member variable totalHours
 */
  public void setTotalHours(int value) {
    this.totalHours = value;
  }
/**
 * Gets the value of member variable totalHours
 */
  public int getTotalHours() {
    return this.totalHours;
  }
/**
 * Sets the value of member variable liveMiles
 */
  public void setLiveMiles(int value) {
    this.liveMiles = value;
  }
/**
 * Gets the value of member variable liveMiles
 */
  public int getLiveMiles() {
    return this.liveMiles;
  }
/**
 * Sets the value of member variable deadheadMiles
 */
  public void setDeadheadMiles(int value) {
    this.deadheadMiles = value;
  }
/**
 * Gets the value of member variable deadheadMiles
 */
  public int getDeadheadMiles() {
    return this.deadheadMiles;
  }
/**
 * Sets the value of member variable dropoffCollect
 */
  public void setDropoffCollect(String value) {
    this.dropoffCollect = value;
  }
/**
 * Gets the value of member variable dropoffCollect
 */
  public String getDropoffCollect() {
    return this.dropoffCollect;
  }
/**
 * Sets the value of member variable dropoffCollectTender
 */
  public void setDropoffCollectTender(int value) {
    this.dropoffCollectTender = value;
  }
/**
 * Gets the value of member variable dropoffCollectTender
 */
  public int getDropoffCollectTender() {
    return this.dropoffCollectTender;
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
 * Sets the value of member variable buscost
 */
  public void setBuscost(double value) {
    this.buscost = value;
  }
/**
 * Gets the value of member variable buscost
 */
  public double getBuscost() {
    return this.buscost;
  }
/**
 * Sets the value of member variable overridestatus
 */
  public void setOverridestatus(char value) {
    this.overridestatus = value;
  }
/**
 * Gets the value of member variable overridestatus
 */
  public char getOverridestatus() {
    return this.overridestatus;
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
 * Sets the value of member variable deadheadMilageRate
 */
  public void setDeadheadMilageRate(double value) {
    this.deadheadMilageRate = value;
  }
/**
 * Gets the value of member variable deadheadMilageRate
 */
  public double getDeadheadMilageRate() {
    return this.deadheadMilageRate;
  }
/**
 * Sets the value of member variable busCount
 */
  public void setBusCount(int value) {
    this.busCount = value;
  }
/**
 * Gets the value of member variable busCount
 */
  public int getBusCount() {
    return this.busCount;
  }
/**
 * Sets the value of member variable minHourFactor
 */
  public void setMinHourFactor(int value) {
    this.minHourFactor = value;
  }
/**
 * Gets the value of member variable minHourFactor
 */
  public int getMinHourFactor() {
    return this.minHourFactor;
  }
/**
 * Sets the value of member variable minHours
 */
  public void setMinHours(double value) {
    this.minHours = value;
  }
/**
 * Gets the value of member variable minHours
 */
  public double getMinHours() {
    return this.minHours;
  }
/**
 * Sets the value of member variable mileageSubtotal
 */
  public void setMileageSubtotal(double value) {
    this.mileageSubtotal = value;
  }
/**
 * Gets the value of member variable mileageSubtotal
 */
  public double getMileageSubtotal() {
    return this.mileageSubtotal;
  }
/**
 * Sets the value of member variable hourlySubtotal
 */
  public void setHourlySubtotal(double value) {
    this.hourlySubtotal = value;
  }
/**
 * Gets the value of member variable hourlySubtotal
 */
  public double getHourlySubtotal() {
    return this.hourlySubtotal;
  }
/**
 * Sets the value of member variable tripTotal
 */
  public void setTripTotal(double value) {
    this.tripTotal = value;
  }
/**
 * Gets the value of member variable tripTotal
 */
  public double getTripTotal() {
    return this.tripTotal;
  }
/**
 * Stubbed initialization method designed to implemented by developer.

 */
  public void initBean() throws SystemException {}
}