package org.dao.mapping;


import java.util.Date;
import java.io.*;
import com.api.persistence.db.orm.OrmBean;
import com.SystemException;


/**
 * Peer object that maps to the vw_order_agreement database table/view.
 *
 * @author auto generated.
 */
public class VwOrderAgreement extends OrmBean {




	// Property name constants that belong to respective DataSource, VwOrderAgreementView

/** The property name constant equivalent to property, CompanyId, of respective DataSource view. */
  public static final String PROP_COMPANYID = "CompanyId";
/** The property name constant equivalent to property, ContactCompany, of respective DataSource view. */
  public static final String PROP_CONTACTCOMPANY = "ContactCompany";
/** The property name constant equivalent to property, ContactFname, of respective DataSource view. */
  public static final String PROP_CONTACTFNAME = "ContactFname";
/** The property name constant equivalent to property, ContactLname, of respective DataSource view. */
  public static final String PROP_CONTACTLNAME = "ContactLname";
/** The property name constant equivalent to property, PickupLocation, of respective DataSource view. */
  public static final String PROP_PICKUPLOCATION = "PickupLocation";
/** The property name constant equivalent to property, Signage, of respective DataSource view. */
  public static final String PROP_SIGNAGE = "Signage";
/** The property name constant equivalent to property, BusCount, of respective DataSource view. */
  public static final String PROP_BUSCOUNT = "BusCount";
/** The property name constant equivalent to property, ReturnDate, of respective DataSource view. */
  public static final String PROP_RETURNDATE = "ReturnDate";
/** The property name constant equivalent to property, DepartDate, of respective DataSource view. */
  public static final String PROP_DEPARTDATE = "DepartDate";
/** The property name constant equivalent to property, DepartSpottime, of respective DataSource view. */
  public static final String PROP_DEPARTSPOTTIME = "DepartSpottime";
/** The property name constant equivalent to property, HeadCount, of respective DataSource view. */
  public static final String PROP_HEADCOUNT = "HeadCount";
/** The property name constant equivalent to property, Destination, of respective DataSource view. */
  public static final String PROP_DESTINATION = "Destination";
/** The property name constant equivalent to property, Id, of respective DataSource view. */
  public static final String PROP_ID = "Id";
/** The property name constant equivalent to property, RequiredDeposit, of respective DataSource view. */
  public static final String PROP_REQUIREDDEPOSIT = "RequiredDeposit";
/** The property name constant equivalent to property, CharterOwnerCompany, of respective DataSource view. */
  public static final String PROP_CHARTEROWNERCOMPANY = "CharterOwnerCompany";
/** The property name constant equivalent to property, ContactCompnay, of respective DataSource view. */
  public static final String PROP_CONTACTCOMPNAY = "ContactCompnay";
/** The property name constant equivalent to property, OrderTotal, of respective DataSource view. */
  public static final String PROP_ORDERTOTAL = "OrderTotal";



	/** The javabean property equivalent of database column vw_order_agreement.company_id */
  private int companyId;
/** The javabean property equivalent of database column vw_order_agreement.contact_company */
  private int contactCompany;
/** The javabean property equivalent of database column vw_order_agreement.contact_fname */
  private String contactFname;
/** The javabean property equivalent of database column vw_order_agreement.contact_lname */
  private String contactLname;
/** The javabean property equivalent of database column vw_order_agreement.pickup_location */
  private String pickupLocation;
/** The javabean property equivalent of database column vw_order_agreement.signage */
  private String signage;
/** The javabean property equivalent of database column vw_order_agreement.bus_count */
  private int busCount;
/** The javabean property equivalent of database column vw_order_agreement.return_date */
  private java.util.Date returnDate;
/** The javabean property equivalent of database column vw_order_agreement.depart_date */
  private java.util.Date departDate;
/** The javabean property equivalent of database column vw_order_agreement.depart_spottime */
  private java.util.Date departSpottime;
/** The javabean property equivalent of database column vw_order_agreement.head_count */
  private int headCount;
/** The javabean property equivalent of database column vw_order_agreement.destination */
  private String destination;
/** The javabean property equivalent of database column vw_order_agreement.id */
  private int id;
/** The javabean property equivalent of database column vw_order_agreement.required_deposit */
  private double requiredDeposit;
/** The javabean property equivalent of database column vw_order_agreement.charter_owner_company */
  private String charterOwnerCompany;
/** The javabean property equivalent of database column vw_order_agreement.contact_compnay */
  private String contactCompnay;
/** The javabean property equivalent of database column vw_order_agreement.order_total */
  private double orderTotal;



	// Getter/Setter Methods

/**
 * Default constructor.
 */
  public VwOrderAgreement() throws SystemException {
	super();
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
 * Sets the value of member variable charterOwnerCompany
 */
  public void setCharterOwnerCompany(String value) {
    this.charterOwnerCompany = value;
  }
/**
 * Gets the value of member variable charterOwnerCompany
 */
  public String getCharterOwnerCompany() {
    return this.charterOwnerCompany;
  }
/**
 * Sets the value of member variable contactCompnay
 */
  public void setContactCompnay(String value) {
    this.contactCompnay = value;
  }
/**
 * Gets the value of member variable contactCompnay
 */
  public String getContactCompnay() {
    return this.contactCompnay;
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
 * Stubbed initialization method designed to implemented by developer.

 */
  public void initBean() throws SystemException {}
}