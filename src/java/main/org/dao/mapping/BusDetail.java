package org.dao.mapping;


import java.util.Date;
import java.io.*;
import com.api.persistence.db.orm.OrmBean;
import com.SystemException;


/**
 * Peer object that maps to the bus_detail database table/view.
 *
 * @author auto generated.
 */
public class BusDetail extends OrmBean {




	// Property name constants that belong to respective DataSource, BusDetailView

/** The property name constant equivalent to property, Id, of respective DataSource view. */
  public static final String PROP_ID = "Id";
/** The property name constant equivalent to property, OrdersId, of respective DataSource view. */
  public static final String PROP_ORDERSID = "OrdersId";
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
/** The property name constant equivalent to property, BusNumber, of respective DataSource view. */
  public static final String PROP_BUSNUMBER = "BusNumber";
/** The property name constant equivalent to property, DriverName, of respective DataSource view. */
  public static final String PROP_DRIVERNAME = "DriverName";
/** The property name constant equivalent to property, DateCreated, of respective DataSource view. */
  public static final String PROP_DATECREATED = "DateCreated";
/** The property name constant equivalent to property, DateUpdated, of respective DataSource view. */
  public static final String PROP_DATEUPDATED = "DateUpdated";
/** The property name constant equivalent to property, UserId, of respective DataSource view. */
  public static final String PROP_USERID = "UserId";
/** The property name constant equivalent to property, MinHourFactor, of respective DataSource view. */
  public static final String PROP_MINHOURFACTOR = "MinHourFactor";
/** The property name constant equivalent to property, Instructions, of respective DataSource view. */
  public static final String PROP_INSTRUCTIONS = "Instructions";



	/** The javabean property equivalent of database column bus_detail.id */
  private int id;
/** The javabean property equivalent of database column bus_detail.orders_id */
  private int ordersId;
/** The javabean property equivalent of database column bus_detail.flat_rate */
  private double flatRate;
/** The javabean property equivalent of database column bus_detail.milage_rate */
  private double milageRate;
/** The javabean property equivalent of database column bus_detail.deadhead_milage_rate */
  private double deadheadMilageRate;
/** The javabean property equivalent of database column bus_detail.live_miles */
  private int liveMiles;
/** The javabean property equivalent of database column bus_detail.deadhead_miles */
  private int deadheadMiles;
/** The javabean property equivalent of database column bus_detail.hourly_rate */
  private double hourlyRate;
/** The javabean property equivalent of database column bus_detail.hourly_rate2 */
  private double hourlyRate2;
/** The javabean property equivalent of database column bus_detail.total_hours */
  private int totalHours;
/** The javabean property equivalent of database column bus_detail.bus_number */
  private int busNumber;
/** The javabean property equivalent of database column bus_detail.driver_name */
  private String driverName;
/** The javabean property equivalent of database column bus_detail.date_created */
  private java.util.Date dateCreated;
/** The javabean property equivalent of database column bus_detail.date_updated */
  private java.util.Date dateUpdated;
/** The javabean property equivalent of database column bus_detail.user_id */
  private String userId;
/** The javabean property equivalent of database column bus_detail.min_hour_factor */
  private double minHourFactor;
/** The javabean property equivalent of database column bus_detail.instructions */
  private String instructions;



	// Getter/Setter Methods

/**
 * Default constructor.
 */
  public BusDetail() throws SystemException {
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
 * Sets the value of member variable ordersId
 */
  public void setOrdersId(int value) {
    this.ordersId = value;
  }
/**
 * Gets the value of member variable ordersId
 */
  public int getOrdersId() {
    return this.ordersId;
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
 * Sets the value of member variable busNumber
 */
  public void setBusNumber(int value) {
    this.busNumber = value;
  }
/**
 * Gets the value of member variable busNumber
 */
  public int getBusNumber() {
    return this.busNumber;
  }
/**
 * Sets the value of member variable driverName
 */
  public void setDriverName(String value) {
    this.driverName = value;
  }
/**
 * Gets the value of member variable driverName
 */
  public String getDriverName() {
    return this.driverName;
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
 * Sets the value of member variable minHourFactor
 */
  public void setMinHourFactor(double value) {
    this.minHourFactor = value;
  }
/**
 * Gets the value of member variable minHourFactor
 */
  public double getMinHourFactor() {
    return this.minHourFactor;
  }
/**
 * Sets the value of member variable instructions
 */
  public void setInstructions(String value) {
    this.instructions = value;
  }
/**
 * Gets the value of member variable instructions
 */
  public String getInstructions() {
    return this.instructions;
  }
/**
 * Stubbed initialization method designed to implemented by developer.

 */
  public void initBean() throws SystemException {}
}