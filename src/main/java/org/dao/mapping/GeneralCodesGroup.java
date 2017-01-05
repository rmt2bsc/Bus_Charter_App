package org.dao.mapping;


import java.util.Date;
import java.io.*;
import com.api.persistence.db.orm.OrmBean;
import com.SystemException;


/**
 * Peer object that maps to the general_codes_group database table/view.
 *
 * @author auto generated.
 */
public class GeneralCodesGroup extends OrmBean {




	// Property name constants that belong to respective DataSource, GeneralCodesGroupView

/** The property name constant equivalent to property, GroupId, of respective DataSource view. */
  public static final String PROP_GROUPID = "GroupId";
/** The property name constant equivalent to property, Description, of respective DataSource view. */
  public static final String PROP_DESCRIPTION = "Description";
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



	/** The javabean property equivalent of database column general_codes_group.group_id */
  private int groupId;
/** The javabean property equivalent of database column general_codes_group.description */
  private String description;
/** The javabean property equivalent of database column general_codes_group.date_created */
  private java.util.Date dateCreated;
/** The javabean property equivalent of database column general_codes_group.date_updated */
  private java.util.Date dateUpdated;
/** The javabean property equivalent of database column general_codes_group.change_reason */
  private String changeReason;
/** The javabean property equivalent of database column general_codes_group.areacode_created */
  private char areacodeCreated;
/** The javabean property equivalent of database column general_codes_group.city_created */
  private int cityCreated;
/** The javabean property equivalent of database column general_codes_group.user_id */
  private char userId;
/** The javabean property equivalent of database column general_codes_group.permanent */
  private String permanent;



	// Getter/Setter Methods

/**
 * Default constructor.
 */
  public GeneralCodesGroup() throws SystemException {
	super();
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