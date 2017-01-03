package org.dao.mapping;


import java.util.Date;
import java.io.*;
import com.api.persistence.db.orm.OrmBean;
import com.SystemException;


/**
 * Peer object that maps to the states_code database table/view.
 *
 * @author auto generated.
 */
public class StatesCode extends OrmBean {




	// Property name constants that belong to respective DataSource, StatesCodeView

/** The property name constant equivalent to property, StateId, of respective DataSource view. */
  public static final String PROP_STATEID = "StateId";
/** The property name constant equivalent to property, Shortname, of respective DataSource view. */
  public static final String PROP_SHORTNAME = "Shortname";
/** The property name constant equivalent to property, Longname, of respective DataSource view. */
  public static final String PROP_LONGNAME = "Longname";
/** The property name constant equivalent to property, StateCapital, of respective DataSource view. */
  public static final String PROP_STATECAPITAL = "StateCapital";
/** The property name constant equivalent to property, CountryId, of respective DataSource view. */
  public static final String PROP_COUNTRYID = "CountryId";
/** The property name constant equivalent to property, DateCreated, of respective DataSource view. */
  public static final String PROP_DATECREATED = "DateCreated";
/** The property name constant equivalent to property, DateUpdated, of respective DataSource view. */
  public static final String PROP_DATEUPDATED = "DateUpdated";
/** The property name constant equivalent to property, ChangeReason, of respective DataSource view. */
  public static final String PROP_CHANGEREASON = "ChangeReason";
/** The property name constant equivalent to property, AreacodeCreated, of respective DataSource view. */
  public static final String PROP_AREACODECREATED = "AreacodeCreated";
/** The property name constant equivalent to property, CityCreated, of respective DataSource view. */
  public static final String PROP_CITYCREATED = "CityCreated";
/** The property name constant equivalent to property, UserId, of respective DataSource view. */
  public static final String PROP_USERID = "UserId";
/** The property name constant equivalent to property, Permanent, of respective DataSource view. */
  public static final String PROP_PERMANENT = "Permanent";



	/** The javabean property equivalent of database column states_code.state_id */
  private int stateId;
/** The javabean property equivalent of database column states_code.shortname */
  private String shortname;
/** The javabean property equivalent of database column states_code.longname */
  private String longname;
/** The javabean property equivalent of database column states_code.state_capital */
  private int stateCapital;
/** The javabean property equivalent of database column states_code.country_id */
  private int countryId;
/** The javabean property equivalent of database column states_code.date_created */
  private java.util.Date dateCreated;
/** The javabean property equivalent of database column states_code.date_updated */
  private java.util.Date dateUpdated;
/** The javabean property equivalent of database column states_code.change_reason */
  private String changeReason;
/** The javabean property equivalent of database column states_code.areacode_created */
  private char areacodeCreated;
/** The javabean property equivalent of database column states_code.city_created */
  private int cityCreated;
/** The javabean property equivalent of database column states_code.user_id */
  private char userId;
/** The javabean property equivalent of database column states_code.permanent */
  private String permanent;



	// Getter/Setter Methods

/**
 * Default constructor.
 */
  public StatesCode() throws SystemException {
	super();
 }
/**
 * Sets the value of member variable stateId
 */
  public void setStateId(int value) {
    this.stateId = value;
  }
/**
 * Gets the value of member variable stateId
 */
  public int getStateId() {
    return this.stateId;
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
 * Sets the value of member variable stateCapital
 */
  public void setStateCapital(int value) {
    this.stateCapital = value;
  }
/**
 * Gets the value of member variable stateCapital
 */
  public int getStateCapital() {
    return this.stateCapital;
  }
/**
 * Sets the value of member variable countryId
 */
  public void setCountryId(int value) {
    this.countryId = value;
  }
/**
 * Gets the value of member variable countryId
 */
  public int getCountryId() {
    return this.countryId;
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
 * Sets the value of member variable permanent
 */
  public void setPermanent(String value) {
    this.permanent = value;
  }
/**
 * Gets the value of member variable permanent
 */
  public String getPermanent() {
    return this.permanent;
  }
/**
 * Stubbed initialization method designed to implemented by developer.

 */
  public void initBean() throws SystemException {}
}