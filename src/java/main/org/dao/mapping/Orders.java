package org.dao.mapping;


import java.util.Date;
import java.io.*;
import com.api.persistence.db.orm.OrmBean;
import com.SystemException;


/**
 * Peer object that maps to the orders database table/view.
 *
 * @author auto generated.
 */
public class Orders extends OrmBean {




	// Property name constants that belong to respective DataSource, OrdersView

/** The property name constant equivalent to property, Id, of respective DataSource view. */
  public static final String PROP_ID = "Id";
/** The property name constant equivalent to property, ClientOrderId, of respective DataSource view. */
  public static final String PROP_CLIENTORDERID = "ClientOrderId";
/** The property name constant equivalent to property, QuoteId, of respective DataSource view. */
  public static final String PROP_QUOTEID = "QuoteId";
/** The property name constant equivalent to property, FlatRate, of respective DataSource view. */
  public static final String PROP_FLATRATE = "FlatRate";
/** The property name constant equivalent to property, MilageRate, of respective DataSource view. */
  public static final String PROP_MILAGERATE = "MilageRate";
/** The property name constant equivalent to property, DeadheadMilageRate, of respective DataSource view. */
  public static final String PROP_DEADHEADMILAGERATE = "DeadheadMilageRate";
/** The property name constant equivalent to property, LiveMiles, of respective DataSource view. */
  public static final String PROP_LIVEMILES = "LiveMiles";
/** The property name constant equivalent to property, DeadheadMiles, of respective DataSource view. */
  public static final String PROP_DEADHEADMILES = "DeadheadMiles";
/** The property name constant equivalent to property, HourlyRate, of respective DataSource view. */
  public static final String PROP_HOURLYRATE = "HourlyRate";
/** The property name constant equivalent to property, HourlyRate2, of respective DataSource view. */
  public static final String PROP_HOURLYRATE2 = "HourlyRate2";
/** The property name constant equivalent to property, TotalHours, of respective DataSource view. */
  public static final String PROP_TOTALHOURS = "TotalHours";
/** The property name constant equivalent to property, Buscost, of respective DataSource view. */
  public static final String PROP_BUSCOST = "Buscost";
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
/** The property name constant equivalent to property, RequiredDeposit, of respective DataSource view. */
  public static final String PROP_REQUIREDDEPOSIT = "RequiredDeposit";
/** The property name constant equivalent to property, MinHourFactor, of respective DataSource view. */
  public static final String PROP_MINHOURFACTOR = "MinHourFactor";



	/** The javabean property equivalent of database column orders.id */
  private int id;
/** The javabean property equivalent of database column orders.client_order_id */
  private String clientOrderId;
/** The javabean property equivalent of database column orders.quote_id */
  private int quoteId;
/** The javabean property equivalent of database column orders.flat_rate */
  private double flatRate;
/** The javabean property equivalent of database column orders.milage_rate */
  private double milageRate;
/** The javabean property equivalent of database column orders.deadhead_milage_rate */
  private double deadheadMilageRate;
/** The javabean property equivalent of database column orders.live_miles */
  private int liveMiles;
/** The javabean property equivalent of database column orders.deadhead_miles */
  private int deadheadMiles;
/** The javabean property equivalent of database column orders.hourly_rate */
  private double hourlyRate;
/** The javabean property equivalent of database column orders.hourly_rate2 */
  private double hourlyRate2;
/** The javabean property equivalent of database column orders.total_hours */
  private int totalHours;
/** The javabean property equivalent of database column orders.buscost */
  private double buscost;
/** The javabean property equivalent of database column orders.dropoff_collect */
  private String dropoffCollect;
/** The javabean property equivalent of database column orders.dropoff_collect_tender */
  private int dropoffCollectTender;
/** The javabean property equivalent of database column orders.date_created */
  private java.util.Date dateCreated;
/** The javabean property equivalent of database column orders.date_updated */
  private java.util.Date dateUpdated;
/** The javabean property equivalent of database column orders.user_id */
  private String userId;
/** The javabean property equivalent of database column orders.required_deposit */
  private double requiredDeposit;
/** The javabean property equivalent of database column orders.min_hour_factor */
  private int minHourFactor;



	// Getter/Setter Methods

/**
 * Default constructor.
 */
  public Orders() throws SystemException {
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
 * Sets the value of member variable requiredDeposit
 */
  public void setRequiredDeposit(double value) {
    this.requiredDeposit = value;
  }
/**
 * Gets the value of member variable requiredDeposit
 */
  public double getRequiredDeposit() {
    return this.requiredDeposit;
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
 * Stubbed initialization method designed to implemented by developer.

 */
  public void initBean() throws SystemException {}
}