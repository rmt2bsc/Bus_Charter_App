package org.dao.mapping;


import java.util.Date;
import java.io.*;
import com.api.persistence.db.orm.OrmBean;
import com.SystemException;


/**
 * Peer object that maps to the business database table/view.
 *
 * @author auto generated.
 */
public class Business extends OrmBean {




	// Property name constants that belong to respective DataSource, BusinessView

/** The property name constant equivalent to property, Id, of respective DataSource view. */
  public static final String PROP_ID = "Id";
/** The property name constant equivalent to property, BusinessType, of respective DataSource view. */
  public static final String PROP_BUSINESSTYPE = "BusinessType";
/** The property name constant equivalent to property, ServiceType, of respective DataSource view. */
  public static final String PROP_SERVICETYPE = "ServiceType";
/** The property name constant equivalent to property, Longname, of respective DataSource view. */
  public static final String PROP_LONGNAME = "Longname";
/** The property name constant equivalent to property, Shortname, of respective DataSource view. */
  public static final String PROP_SHORTNAME = "Shortname";
/** The property name constant equivalent to property, Photoid, of respective DataSource view. */
  public static final String PROP_PHOTOID = "Photoid";
/** The property name constant equivalent to property, DateCreated, of respective DataSource view. */
  public static final String PROP_DATECREATED = "DateCreated";
/** The property name constant equivalent to property, DateUpdated, of respective DataSource view. */
  public static final String PROP_DATEUPDATED = "DateUpdated";
/** The property name constant equivalent to property, ChangeReason, of respective DataSource view. */
  public static final String PROP_CHANGEREASON = "ChangeReason";
/** The property name constant equivalent to property, ActiveInd, of respective DataSource view. */
  public static final String PROP_ACTIVEIND = "ActiveInd";
/** The property name constant equivalent to property, AreacodeCreated, of respective DataSource view. */
  public static final String PROP_AREACODECREATED = "AreacodeCreated";
/** The property name constant equivalent to property, CityCreated, of respective DataSource view. */
  public static final String PROP_CITYCREATED = "CityCreated";
/** The property name constant equivalent to property, UserId, of respective DataSource view. */
  public static final String PROP_USERID = "UserId";
/** The property name constant equivalent to property, Status, of respective DataSource view. */
  public static final String PROP_STATUS = "Status";
/** The property name constant equivalent to property, TerminationDate, of respective DataSource view. */
  public static final String PROP_TERMINATIONDATE = "TerminationDate";
/** The property name constant equivalent to property, SuspensionDate, of respective DataSource view. */
  public static final String PROP_SUSPENSIONDATE = "SuspensionDate";
/** The property name constant equivalent to property, SuspensionRemovedDate, of respective DataSource view. */
  public static final String PROP_SUSPENSIONREMOVEDDATE = "SuspensionRemovedDate";
/** The property name constant equivalent to property, ActiveDate, of respective DataSource view. */
  public static final String PROP_ACTIVEDATE = "ActiveDate";
/** The property name constant equivalent to property, AddrLine1, of respective DataSource view. */
  public static final String PROP_ADDRLINE1 = "AddrLine1";
/** The property name constant equivalent to property, AddrLine3, of respective DataSource view. */
  public static final String PROP_ADDRLINE3 = "AddrLine3";
/** The property name constant equivalent to property, AddrLine2, of respective DataSource view. */
  public static final String PROP_ADDRLINE2 = "AddrLine2";
/** The property name constant equivalent to property, ZipId, of respective DataSource view. */
  public static final String PROP_ZIPID = "ZipId";



	/** The javabean property equivalent of database column business.id */
  private int id;
/** The javabean property equivalent of database column business.business_type */
  private int businessType;
/** The javabean property equivalent of database column business.service_type */
  private int serviceType;
/** The javabean property equivalent of database column business.longname */
  private String longname;
/** The javabean property equivalent of database column business.shortname */
  private String shortname;
/** The javabean property equivalent of database column business.photoid */
  private int photoid;
/** The javabean property equivalent of database column business.date_created */
  private java.util.Date dateCreated;
/** The javabean property equivalent of database column business.date_updated */
  private java.util.Date dateUpdated;
/** The javabean property equivalent of database column business.change_reason */
  private String changeReason;
/** The javabean property equivalent of database column business.active_ind */
  private char activeInd;
/** The javabean property equivalent of database column business.areacode_created */
  private char areacodeCreated;
/** The javabean property equivalent of database column business.city_created */
  private int cityCreated;
/** The javabean property equivalent of database column business.user_id */
  private char userId;
/** The javabean property equivalent of database column business.status */
  private int status;
/** The javabean property equivalent of database column business.termination_date */
  private java.util.Date terminationDate;
/** The javabean property equivalent of database column business.suspension_date */
  private java.util.Date suspensionDate;
/** The javabean property equivalent of database column business.suspension_removed_date */
  private java.util.Date suspensionRemovedDate;
/** The javabean property equivalent of database column business.active_date */
  private java.util.Date activeDate;
/** The javabean property equivalent of database column business.addr_line_1 */
  private String addrLine1;
/** The javabean property equivalent of database column business.addr_line_3 */
  private String addrLine3;
/** The javabean property equivalent of database column business.addr_line_2 */
  private String addrLine2;
/** The javabean property equivalent of database column business.zip_id */
  private int zipId;



	// Getter/Setter Methods

/**
 * Default constructor.
 */
  public Business() throws SystemException {
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
 * Sets the value of member variable businessType
 */
  public void setBusinessType(int value) {
    this.businessType = value;
  }
/**
 * Gets the value of member variable businessType
 */
  public int getBusinessType() {
    return this.businessType;
  }
/**
 * Sets the value of member variable serviceType
 */
  public void setServiceType(int value) {
    this.serviceType = value;
  }
/**
 * Gets the value of member variable serviceType
 */
  public int getServiceType() {
    return this.serviceType;
  }
/**
 * Sets the value of member variable longname
 */
  public void setLongname(String value) {
    this.longname = value;
  }
/**
 * Gets the value of member variable longname
 */
  public String getLongname() {
    return this.longname;
  }
/**
 * Sets the value of member variable shortname
 */
  public void setShortname(String value) {
    this.shortname = value;
  }
/**
 * Gets the value of member variable shortname
 */
  public String getShortname() {
    return this.shortname;
  }
/**
 * Sets the value of member variable photoid
 */
  public void setPhotoid(int value) {
    this.photoid = value;
  }
/**
 * Gets the value of member variable photoid
 */
  public int getPhotoid() {
    return this.photoid;
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
 * Sets the value of member variable changeReason
 */
  public void setChangeReason(String value) {
    this.changeReason = value;
  }
/**
 * Gets the value of member variable changeReason
 */
  public String getChangeReason() {
    return this.changeReason;
  }
/**
 * Sets the value of member variable activeInd
 */
  public void setActiveInd(char value) {
    this.activeInd = value;
  }
/**
 * Gets the value of member variable activeInd
 */
  public char getActiveInd() {
    return this.activeInd;
  }
/**
 * Sets the value of member variable areacodeCreated
 */
  public void setAreacodeCreated(char value) {
    this.areacodeCreated = value;
  }
/**
 * Gets the value of member variable areacodeCreated
 */
  public char getAreacodeCreated() {
    return this.areacodeCreated;
  }
/**
 * Sets the value of member variable cityCreated
 */
  public void setCityCreated(int value) {
    this.cityCreated = value;
  }
/**
 * Gets the value of member variable cityCreated
 */
  public int getCityCreated() {
    return this.cityCreated;
  }
/**
 * Sets the value of member variable userId
 */
  public void setUserId(char value) {
    this.userId = value;
  }
/**
 * Gets the value of member variable userId
 */
  public char getUserId() {
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
 * Sets the value of member variable terminationDate
 */
  public void setTerminationDate(java.util.Date value) {
    this.terminationDate = value;
  }
/**
 * Gets the value of member variable terminationDate
 */
  public java.util.Date getTerminationDate() {
    return this.terminationDate;
  }
/**
 * Sets the value of member variable suspensionDate
 */
  public void setSuspensionDate(java.util.Date value) {
    this.suspensionDate = value;
  }
/**
 * Gets the value of member variable suspensionDate
 */
  public java.util.Date getSuspensionDate() {
    return this.suspensionDate;
  }
/**
 * Sets the value of member variable suspensionRemovedDate
 */
  public void setSuspensionRemovedDate(java.util.Date value) {
    this.suspensionRemovedDate = value;
  }
/**
 * Gets the value of member variable suspensionRemovedDate
 */
  public java.util.Date getSuspensionRemovedDate() {
    return this.suspensionRemovedDate;
  }
/**
 * Sets the value of member variable activeDate
 */
  public void setActiveDate(java.util.Date value) {
    this.activeDate = value;
  }
/**
 * Gets the value of member variable activeDate
 */
  public java.util.Date getActiveDate() {
    return this.activeDate;
  }
/**
 * Sets the value of member variable addrLine1
 */
  public void setAddrLine1(String value) {
    this.addrLine1 = value;
  }
/**
 * Gets the value of member variable addrLine1
 */
  public String getAddrLine1() {
    return this.addrLine1;
  }
/**
 * Sets the value of member variable addrLine3
 */
  public void setAddrLine3(String value) {
    this.addrLine3 = value;
  }
/**
 * Gets the value of member variable addrLine3
 */
  public String getAddrLine3() {
    return this.addrLine3;
  }
/**
 * Sets the value of member variable addrLine2
 */
  public void setAddrLine2(String value) {
    this.addrLine2 = value;
  }
/**
 * Gets the value of member variable addrLine2
 */
  public String getAddrLine2() {
    return this.addrLine2;
  }
/**
 * Sets the value of member variable zipId
 */
  public void setZipId(int value) {
    this.zipId = value;
  }
/**
 * Gets the value of member variable zipId
 */
  public int getZipId() {
    return this.zipId;
  }
/**
 * Stubbed initialization method designed to implemented by developer.

 */
  public void initBean() throws SystemException {}
}