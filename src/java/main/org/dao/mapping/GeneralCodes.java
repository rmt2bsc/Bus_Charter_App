package org.dao.mapping;


import java.util.Date;
import java.io.*;
import com.api.persistence.db.orm.OrmBean;
import com.SystemException;


/**
 * Peer object that maps to the general_codes database table/view.
 *
 * @author auto generated.
 */
public class GeneralCodes extends OrmBean {




	// Property name constants that belong to respective DataSource, GeneralCodesView

/** The property name constant equivalent to property, CodeId, of respective DataSource view. */
  public static final String PROP_CODEID = "CodeId";
/** The property name constant equivalent to property, GroupId, of respective DataSource view. */
  public static final String PROP_GROUPID = "GroupId";
/** The property name constant equivalent to property, Shortdesc, of respective DataSource view. */
  public static final String PROP_SHORTDESC = "Shortdesc";
/** The property name constant equivalent to property, Longdesc, of respective DataSource view. */
  public static final String PROP_LONGDESC = "Longdesc";
/** The property name constant equivalent to property, CountryId, of respective DataSource view. */
  public static final String PROP_COUNTRYID = "CountryId";
/** The property name constant equivalent to property, GenIndValue, of respective DataSource view. */
  public static final String PROP_GENINDVALUE = "GenIndValue";
/** The property name constant equivalent to property, ButtonApiValue, of respective DataSource view. */
  public static final String PROP_BUTTONAPIVALUE = "ButtonApiValue";
/** The property name constant equivalent to property, ButtonDefault, of respective DataSource view. */
  public static final String PROP_BUTTONDEFAULT = "ButtonDefault";
/** The property name constant equivalent to property, IconApiValue, of respective DataSource view. */
  public static final String PROP_ICONAPIVALUE = "IconApiValue";
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
/** The property name constant equivalent to property, IntValue, of respective DataSource view. */
  public static final String PROP_INTVALUE = "IntValue";



	/** The javabean property equivalent of database column general_codes.code_id */
  private int codeId;
/** The javabean property equivalent of database column general_codes.group_id */
  private int groupId;
/** The javabean property equivalent of database column general_codes.shortdesc */
  private String shortdesc;
/** The javabean property equivalent of database column general_codes.longdesc */
  private String longdesc;
/** The javabean property equivalent of database column general_codes.country_id */
  private int countryId;
/** The javabean property equivalent of database column general_codes.gen_ind_value */
  private String genIndValue;
/** The javabean property equivalent of database column general_codes.button_api_value */
  private int buttonApiValue;
/** The javabean property equivalent of database column general_codes.button_default */
  private int buttonDefault;
/** The javabean property equivalent of database column general_codes.icon_api_value */
  private int iconApiValue;
/** The javabean property equivalent of database column general_codes.date_created */
  private java.util.Date dateCreated;
/** The javabean property equivalent of database column general_codes.date_updated */
  private java.util.Date dateUpdated;
/** The javabean property equivalent of database column general_codes.change_reason */
  private String changeReason;
/** The javabean property equivalent of database column general_codes.areacode_created */
  private char areacodeCreated;
/** The javabean property equivalent of database column general_codes.city_created */
  private int cityCreated;
/** The javabean property equivalent of database column general_codes.user_id */
  private char userId;
/** The javabean property equivalent of database column general_codes.permanent */
  private String permanent;
/** The javabean property equivalent of database column general_codes.int_value */
  private int intValue;



	// Getter/Setter Methods

/**
 * Default constructor.
 */
  public GeneralCodes() throws SystemException {
	super();
 }
/**
 * Sets the value of member variable codeId
 */
  public void setCodeId(int value) {
    this.codeId = value;
  }
/**
 * Gets the value of member variable codeId
 */
  public int getCodeId() {
    return this.codeId;
  }
/**
 * Sets the value of member variable groupId
 */
  public void setGroupId(int value) {
    this.groupId = value;
  }
/**
 * Gets the value of member variable groupId
 */
  public int getGroupId() {
    return this.groupId;
  }
/**
 * Sets the value of member variable shortdesc
 */
  public void setShortdesc(String value) {
    this.shortdesc = value;
  }
/**
 * Gets the value of member variable shortdesc
 */
  public String getShortdesc() {
    return this.shortdesc;
  }
/**
 * Sets the value of member variable longdesc
 */
  public void setLongdesc(String value) {
    this.longdesc = value;
  }
/**
 * Gets the value of member variable longdesc
 */
  public String getLongdesc() {
    return this.longdesc;
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
 * Sets the value of member variable genIndValue
 */
  public void setGenIndValue(String value) {
    this.genIndValue = value;
  }
/**
 * Gets the value of member variable genIndValue
 */
  public String getGenIndValue() {
    return this.genIndValue;
  }
/**
 * Sets the value of member variable buttonApiValue
 */
  public void setButtonApiValue(int value) {
    this.buttonApiValue = value;
  }
/**
 * Gets the value of member variable buttonApiValue
 */
  public int getButtonApiValue() {
    return this.buttonApiValue;
  }
/**
 * Sets the value of member variable buttonDefault
 */
  public void setButtonDefault(int value) {
    this.buttonDefault = value;
  }
/**
 * Gets the value of member variable buttonDefault
 */
  public int getButtonDefault() {
    return this.buttonDefault;
  }
/**
 * Sets the value of member variable iconApiValue
 */
  public void setIconApiValue(int value) {
    this.iconApiValue = value;
  }
/**
 * Gets the value of member variable iconApiValue
 */
  public int getIconApiValue() {
    return this.iconApiValue;
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
 * Sets the value of member variable intValue
 */
  public void setIntValue(int value) {
    this.intValue = value;
  }
/**
 * Gets the value of member variable intValue
 */
  public int getIntValue() {
    return this.intValue;
  }
/**
 * Stubbed initialization method designed to implemented by developer.

 */
  public void initBean() throws SystemException {}
}