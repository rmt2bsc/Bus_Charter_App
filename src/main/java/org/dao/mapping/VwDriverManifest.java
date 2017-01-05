package org.dao.mapping;


import java.util.Date;
import java.io.*;
import com.api.persistence.db.orm.OrmBean;
import com.SystemException;


/**
 * Peer object that maps to the vw_driver_manifest database table/view.
 *
 * @author auto generated.
 */
public class VwDriverManifest extends OrmBean {




	// Property name constants that belong to respective DataSource, VwDriverManifestView

/** The property name constant equivalent to property, OrderId, of respective DataSource view. */
  public static final String PROP_ORDERID = "OrderId";
/** The property name constant equivalent to property, ContactFname, of respective DataSource view. */
  public static final String PROP_CONTACTFNAME = "ContactFname";
/** The property name constant equivalent to property, ContactLname, of respective DataSource view. */
  public static final String PROP_CONTACTLNAME = "ContactLname";
/** The property name constant equivalent to property, ContactAddress1, of respective DataSource view. */
  public static final String PROP_CONTACTADDRESS1 = "ContactAddress1";
/** The property name constant equivalent to property, ContactAddress2, of respective DataSource view. */
  public static final String PROP_CONTACTADDRESS2 = "ContactAddress2";
/** The property name constant equivalent to property, ContactAddress3, of respective DataSource view. */
  public static final String PROP_CONTACTADDRESS3 = "ContactAddress3";
/** The property name constant equivalent to property, City, of respective DataSource view. */
  public static final String PROP_CITY = "City";
/** The property name constant equivalent to property, State, of respective DataSource view. */
  public static final String PROP_STATE = "State";
/** The property name constant equivalent to property, Zip, of respective DataSource view. */
  public static final String PROP_ZIP = "Zip";
/** The property name constant equivalent to property, ContactPhone, of respective DataSource view. */
  public static final String PROP_CONTACTPHONE = "ContactPhone";
/** The property name constant equivalent to property, ContactCompany, of respective DataSource view. */
  public static final String PROP_CONTACTCOMPANY = "ContactCompany";
/** The property name constant equivalent to property, QuoteId, of respective DataSource view. */
  public static final String PROP_QUOTEID = "QuoteId";
/** The property name constant equivalent to property, Signage, of respective DataSource view. */
  public static final String PROP_SIGNAGE = "Signage";
/** The property name constant equivalent to property, CharterParty, of respective DataSource view. */
  public static final String PROP_CHARTERPARTY = "CharterParty";
/** The property name constant equivalent to property, GarageDate, of respective DataSource view. */
  public static final String PROP_GARAGEDATE = "GarageDate";
/** The property name constant equivalent to property, GarageTime, of respective DataSource view. */
  public static final String PROP_GARAGETIME = "GarageTime";
/** The property name constant equivalent to property, HeadCount, of respective DataSource view. */
  public static final String PROP_HEADCOUNT = "HeadCount";
/** The property name constant equivalent to property, BusCount, of respective DataSource view. */
  public static final String PROP_BUSCOUNT = "BusCount";
/** The property name constant equivalent to property, DepartDate, of respective DataSource view. */
  public static final String PROP_DEPARTDATE = "DepartDate";
/** The property name constant equivalent to property, DepartDroptime, of respective DataSource view. */
  public static final String PROP_DEPARTDROPTIME = "DepartDroptime";
/** The property name constant equivalent to property, DepartSpottime, of respective DataSource view. */
  public static final String PROP_DEPARTSPOTTIME = "DepartSpottime";
/** The property name constant equivalent to property, ReturnDate, of respective DataSource view. */
  public static final String PROP_RETURNDATE = "ReturnDate";
/** The property name constant equivalent to property, ReturnDroptime, of respective DataSource view. */
  public static final String PROP_RETURNDROPTIME = "ReturnDroptime";
/** The property name constant equivalent to property, ReturnSpottime, of respective DataSource view. */
  public static final String PROP_RETURNSPOTTIME = "ReturnSpottime";
/** The property name constant equivalent to property, PickupLocation, of respective DataSource view. */
  public static final String PROP_PICKUPLOCATION = "PickupLocation";
/** The property name constant equivalent to property, Destination, of respective DataSource view. */
  public static final String PROP_DESTINATION = "Destination";
/** The property name constant equivalent to property, SpecialInstructions, of respective DataSource view. */
  public static final String PROP_SPECIALINSTRUCTIONS = "SpecialInstructions";
/** The property name constant equivalent to property, BusNumber, of respective DataSource view. */
  public static final String PROP_BUSNUMBER = "BusNumber";
/** The property name constant equivalent to property, DriverName, of respective DataSource view. */
  public static final String PROP_DRIVERNAME = "DriverName";
/** The property name constant equivalent to property, BusInstructions, of respective DataSource view. */
  public static final String PROP_BUSINSTRUCTIONS = "BusInstructions";



	/** The javabean property equivalent of database column vw_driver_manifest.order_id */
  private int orderId;
/** The javabean property equivalent of database column vw_driver_manifest.contact_fname */
  private String contactFname;
/** The javabean property equivalent of database column vw_driver_manifest.contact_lname */
  private String contactLname;
/** The javabean property equivalent of database column vw_driver_manifest.contact_address1 */
  private String contactAddress1;
/** The javabean property equivalent of database column vw_driver_manifest.contact_address2 */
  private String contactAddress2;
/** The javabean property equivalent of database column vw_driver_manifest.contact_address3 */
  private String contactAddress3;
/** The javabean property equivalent of database column vw_driver_manifest.city */
  private String city;
/** The javabean property equivalent of database column vw_driver_manifest.state */
  private String state;
/** The javabean property equivalent of database column vw_driver_manifest.zip */
  private int zip;
/** The javabean property equivalent of database column vw_driver_manifest.contact_phone */
  private String contactPhone;
/** The javabean property equivalent of database column vw_driver_manifest.contact_company */
  private int contactCompany;
/** The javabean property equivalent of database column vw_driver_manifest.quote_id */
  private int quoteId;
/** The javabean property equivalent of database column vw_driver_manifest.signage */
  private String signage;
/** The javabean property equivalent of database column vw_driver_manifest.charter_party */
  private String charterParty;
/** The javabean property equivalent of database column vw_driver_manifest.garage_date */
  private java.util.Date garageDate;
/** The javabean property equivalent of database column vw_driver_manifest.garage_time */
  private java.util.Date garageTime;
/** The javabean property equivalent of database column vw_driver_manifest.head_count */
  private int headCount;
/** The javabean property equivalent of database column vw_driver_manifest.bus_count */
  private int busCount;
/** The javabean property equivalent of database column vw_driver_manifest.depart_date */
  private java.util.Date departDate;
/** The javabean property equivalent of database column vw_driver_manifest.depart_droptime */
  private java.util.Date departDroptime;
/** The javabean property equivalent of database column vw_driver_manifest.depart_spottime */
  private java.util.Date departSpottime;
/** The javabean property equivalent of database column vw_driver_manifest.return_date */
  private java.util.Date returnDate;
/** The javabean property equivalent of database column vw_driver_manifest.return_droptime */
  private java.util.Date returnDroptime;
/** The javabean property equivalent of database column vw_driver_manifest.return_spottime */
  private java.util.Date returnSpottime;
/** The javabean property equivalent of database column vw_driver_manifest.pickup_location */
  private String pickupLocation;
/** The javabean property equivalent of database column vw_driver_manifest.destination */
  private String destination;
/** The javabean property equivalent of database column vw_driver_manifest.special_instructions */
  private String specialInstructions;
/** The javabean property equivalent of database column vw_driver_manifest.bus_number */
  private int busNumber;
/** The javabean property equivalent of database column vw_driver_manifest.driver_name */
  private String driverName;
/** The javabean property equivalent of database column vw_driver_manifest.bus_instructions */
  private String busInstructions;



	// Getter/Setter Methods

/**
 * Default constructor.
 */
  public VwDriverManifest() throws SystemException {
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
 * Sets the value of member variable contactAddress1
 */
  public void setContactAddress1(String value) {
    this.contactAddress1 = value;
  }
/**
 * Gets the value of member variable contactAddress1
 */
  public String getContactAddress1() {
    return this.contactAddress1;
  }
/**
 * Sets the value of member variable contactAddress2
 */
  public void setContactAddress2(String value) {
    this.contactAddress2 = value;
  }
/**
 * Gets the value of member variable contactAddress2
 */
  public String getContactAddress2() {
    return this.contactAddress2;
  }
/**
 * Sets the value of member variable contactAddress3
 */
  public void setContactAddress3(String value) {
    this.contactAddress3 = value;
  }
/**
 * Gets the value of member variable contactAddress3
 */
  public String getContactAddress3() {
    return this.contactAddress3;
  }
/**
 * Sets the value of member variable city
 */
  public void setCity(String value) {
    this.city = value;
  }
/**
 * Gets the value of member variable city
 */
  public String getCity() {
    return this.city;
  }
/**
 * Sets the value of member variable state
 */
  public void setState(String value) {
    this.state = value;
  }
/**
 * Gets the value of member variable state
 */
  public String getState() {
    return this.state;
  }
/**
 * Sets the value of member variable zip
 */
  public void setZip(int value) {
    this.zip = value;
  }
/**
 * Gets the value of member variable zip
 */
  public int getZip() {
    return this.zip;
  }
/**
 * Sets the value of member variable contactPhone
 */
  public void setContactPhone(String value) {
    this.contactPhone = value;
  }
/**
 * Gets the value of member variable contactPhone
 */
  public String getContactPhone() {
    return this.contactPhone;
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
 * Sets the value of member variable specialInstructions
 */
  public void setSpecialInstructions(String value) {
    this.specialInstructions = value;
  }
/**
 * Gets the value of member variable specialInstructions
 */
  public String getSpecialInstructions() {
    return this.specialInstructions;
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
 * Sets the value of member variable busInstructions
 */
  public void setBusInstructions(String value) {
    this.busInstructions = value;
  }
/**
 * Gets the value of member variable busInstructions
 */
  public String getBusInstructions() {
    return this.busInstructions;
  }
/**
 * Stubbed initialization method designed to implemented by developer.

 */
  public void initBean() throws SystemException {}
}