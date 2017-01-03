package org.dao.mapping;


import java.util.Date;
import java.io.*;
import com.api.persistence.db.orm.OrmBean;
import com.SystemException;


/**
 * Peer object that maps to the quote database table/view.
 *
 * @author auto generated.
 */
public class Quote extends OrmBean {




	// Property name constants that belong to respective DataSource, QuoteView

/** The property name constant equivalent to property, Id, of respective DataSource view. */
  public static final String PROP_ID = "Id";
/** The property name constant equivalent to property, CompanyId, of respective DataSource view. */
  public static final String PROP_COMPANYID = "CompanyId";
/** The property name constant equivalent to property, ClientId, of respective DataSource view. */
  public static final String PROP_CLIENTID = "ClientId";
/** The property name constant equivalent to property, CharterParty, of respective DataSource view. */
  public static final String PROP_CHARTERPARTY = "CharterParty";
/** The property name constant equivalent to property, Signage, of respective DataSource view. */
  public static final String PROP_SIGNAGE = "Signage";
/** The property name constant equivalent to property, BusCount, of respective DataSource view. */
  public static final String PROP_BUSCOUNT = "BusCount";
/** The property name constant equivalent to property, HeadCount, of respective DataSource view. */
  public static final String PROP_HEADCOUNT = "HeadCount";
/** The property name constant equivalent to property, QuotePrice, of respective DataSource view. */
  public static final String PROP_QUOTEPRICE = "QuotePrice";
/** The property name constant equivalent to property, DepartDate, of respective DataSource view. */
  public static final String PROP_DEPARTDATE = "DepartDate";
/** The property name constant equivalent to property, DepartSpottime, of respective DataSource view. */
  public static final String PROP_DEPARTSPOTTIME = "DepartSpottime";
/** The property name constant equivalent to property, DepartDroptime, of respective DataSource view. */
  public static final String PROP_DEPARTDROPTIME = "DepartDroptime";
/** The property name constant equivalent to property, ReturnDate, of respective DataSource view. */
  public static final String PROP_RETURNDATE = "ReturnDate";
/** The property name constant equivalent to property, ReturnSpottime, of respective DataSource view. */
  public static final String PROP_RETURNSPOTTIME = "ReturnSpottime";
/** The property name constant equivalent to property, ReturnDroptime, of respective DataSource view. */
  public static final String PROP_RETURNDROPTIME = "ReturnDroptime";
/** The property name constant equivalent to property, GarageDate, of respective DataSource view. */
  public static final String PROP_GARAGEDATE = "GarageDate";
/** The property name constant equivalent to property, GarageTime, of respective DataSource view. */
  public static final String PROP_GARAGETIME = "GarageTime";
/** The property name constant equivalent to property, PickupLocation, of respective DataSource view. */
  public static final String PROP_PICKUPLOCATION = "PickupLocation";
/** The property name constant equivalent to property, Destination, of respective DataSource view. */
  public static final String PROP_DESTINATION = "Destination";
/** The property name constant equivalent to property, DateCreated, of respective DataSource view. */
  public static final String PROP_DATECREATED = "DateCreated";
/** The property name constant equivalent to property, DateUpdated, of respective DataSource view. */
  public static final String PROP_DATEUPDATED = "DateUpdated";
/** The property name constant equivalent to property, UserId, of respective DataSource view. */
  public static final String PROP_USERID = "UserId";
/** The property name constant equivalent to property, Status, of respective DataSource view. */
  public static final String PROP_STATUS = "Status";
/** The property name constant equivalent to property, Instructions, of respective DataSource view. */
  public static final String PROP_INSTRUCTIONS = "Instructions";



	/** The javabean property equivalent of database column quote.id */
  private int id;
/** The javabean property equivalent of database column quote.company_id */
  private int companyId;
/** The javabean property equivalent of database column quote.client_id */
  private int clientId;
/** The javabean property equivalent of database column quote.charter_party */
  private String charterParty;
/** The javabean property equivalent of database column quote.signage */
  private String signage;
/** The javabean property equivalent of database column quote.bus_count */
  private int busCount;
/** The javabean property equivalent of database column quote.head_count */
  private int headCount;
/** The javabean property equivalent of database column quote.quote_price */
  private double quotePrice;
/** The javabean property equivalent of database column quote.depart_date */
  private java.util.Date departDate;
/** The javabean property equivalent of database column quote.depart_spottime */
  private java.util.Date departSpottime;
/** The javabean property equivalent of database column quote.depart_droptime */
  private java.util.Date departDroptime;
/** The javabean property equivalent of database column quote.return_date */
  private java.util.Date returnDate;
/** The javabean property equivalent of database column quote.return_spottime */
  private java.util.Date returnSpottime;
/** The javabean property equivalent of database column quote.return_droptime */
  private java.util.Date returnDroptime;
/** The javabean property equivalent of database column quote.garage_date */
  private java.util.Date garageDate;
/** The javabean property equivalent of database column quote.garage_time */
  private java.util.Date garageTime;
/** The javabean property equivalent of database column quote.pickup_location */
  private String pickupLocation;
/** The javabean property equivalent of database column quote.destination */
  private String destination;
/** The javabean property equivalent of database column quote.date_created */
  private java.util.Date dateCreated;
/** The javabean property equivalent of database column quote.date_updated */
  private java.util.Date dateUpdated;
/** The javabean property equivalent of database column quote.user_id */
  private String userId;
/** The javabean property equivalent of database column quote.status */
  private int status;
/** The javabean property equivalent of database column quote.instructions */
  private String instructions;



	// Getter/Setter Methods

/**
 * Default constructor.
 */
  public Quote() throws SystemException {
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
 * Sets the value of member variable companyId
 */
  public void setCompanyId(int value) {
    this.companyId = value;
  }
/**
 * Gets the value of member variable companyId
 */
  public int getCompanyId() {
    return this.companyId;
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
 * Sets the value of member variable headCount
 */
  public void setHeadCount(int value) {
    this.headCount = value;
  }
/**
 * Gets the value of member variable headCount
 */
  public int getHeadCount() {
    return this.headCount;
  }
/**
 * Sets the value of member variable quotePrice
 */
  public void setQuotePrice(double value) {
    this.quotePrice = value;
  }
/**
 * Gets the value of member variable quotePrice
 */
  public double getQuotePrice() {
    return this.quotePrice;
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
 * Sets the value of member variable departSpottime
 */
  public void setDepartSpottime(java.util.Date value) {
    this.departSpottime = value;
  }
/**
 * Gets the value of member variable departSpottime
 */
  public java.util.Date getDepartSpottime() {
    return this.departSpottime;
  }
/**
 * Sets the value of member variable departDroptime
 */
  public void setDepartDroptime(java.util.Date value) {
    this.departDroptime = value;
  }
/**
 * Gets the value of member variable departDroptime
 */
  public java.util.Date getDepartDroptime() {
    return this.departDroptime;
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
 * Sets the value of member variable returnSpottime
 */
  public void setReturnSpottime(java.util.Date value) {
    this.returnSpottime = value;
  }
/**
 * Gets the value of member variable returnSpottime
 */
  public java.util.Date getReturnSpottime() {
    return this.returnSpottime;
  }
/**
 * Sets the value of member variable returnDroptime
 */
  public void setReturnDroptime(java.util.Date value) {
    this.returnDroptime = value;
  }
/**
 * Gets the value of member variable returnDroptime
 */
  public java.util.Date getReturnDroptime() {
    return this.returnDroptime;
  }
/**
 * Sets the value of member variable garageDate
 */
  public void setGarageDate(java.util.Date value) {
    this.garageDate = value;
  }
/**
 * Gets the value of member variable garageDate
 */
  public java.util.Date getGarageDate() {
    return this.garageDate;
  }
/**
 * Sets the value of member variable garageTime
 */
  public void setGarageTime(java.util.Date value) {
    this.garageTime = value;
  }
/**
 * Gets the value of member variable garageTime
 */
  public java.util.Date getGarageTime() {
    return this.garageTime;
  }
/**
 * Sets the value of member variable pickupLocation
 */
  public void setPickupLocation(String value) {
    this.pickupLocation = value;
  }
/**
 * Gets the value of member variable pickupLocation
 */
  public String getPickupLocation() {
    return this.pickupLocation;
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
 * Sets the value of member variable status
 */
  public void setStatus(int value) {
    this.status = value;
  }
/**
 * Gets the value of member variable status
 */
  public int getStatus() {
    return this.status;
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