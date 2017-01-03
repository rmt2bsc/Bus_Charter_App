package org.dao.mapping;


import java.util.Date;
import java.io.*;
import com.api.persistence.db.orm.OrmBean;
import com.SystemException;


/**
 * Peer object that maps to the system_message_detail database table/view.
 *
 * @author auto generated.
 */
public class SystemMessageDetail extends OrmBean {




	// Property name constants that belong to respective DataSource, SystemMessageDetailView

/** The property name constant equivalent to property, MesgId, of respective DataSource view. */
  public static final String PROP_MESGID = "MesgId";
/** The property name constant equivalent to property, MesgTypeId, of respective DataSource view. */
  public static final String PROP_MESGTYPEID = "MesgTypeId";
/** The property name constant equivalent to property, Description, of respective DataSource view. */
  public static final String PROP_DESCRIPTION = "Description";
/** The property name constant equivalent to property, ButtonId, of respective DataSource view. */
  public static final String PROP_BUTTONID = "ButtonId";
/** The property name constant equivalent to property, IconId, of respective DataSource view. */
  public static final String PROP_ICONID = "IconId";
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



	/** The javabean property equivalent of database column system_message_detail.mesg_id */
  private int mesgId;
/** The javabean property equivalent of database column system_message_detail.mesg_type_id */
  private int mesgTypeId;
/** The javabean property equivalent of database column system_message_detail.description */
  private String description;
/** The javabean property equivalent of database column system_message_detail.button_id */
  private int buttonId;
/** The javabean property equivalent of database column system_message_detail.icon_id */
  private int iconId;
/** The javabean property equivalent of database column system_message_detail.date_created */
  private java.util.Date dateCreated;
/** The javabean property equivalent of database column system_message_detail.date_updated */
  private java.util.Date dateUpdated;
/** The javabean property equivalent of database column system_message_detail.change_reason */
  private String changeReason;
/** The javabean property equivalent of database column system_message_detail.active_ind */
  private char activeInd;
/** The javabean property equivalent of database column system_message_detail.areacode_created */
  private char areacodeCreated;
/** The javabean property equivalent of database column system_message_detail.city_created */
  private int cityCreated;
/** The javabean property equivalent of database column system_message_detail.user_id */
  private char userId;



	// Getter/Setter Methods

/**
 * Default constructor.
 */
  public SystemMessageDetail() throws SystemException {
	super();
 }
/**
 * Sets the value of member variable mesgId
 */
  public void setMesgId(int value) {
    this.mesgId = value;
  }
/**
 * Gets the value of member variable mesgId
 */
  public int getMesgId() {
    return this.mesgId;
  }
/**
 * Sets the value of member variable mesgTypeId
 */
  public void setMesgTypeId(int value) {
    this.mesgTypeId = value;
  }
/**
 * Gets the value of member variable mesgTypeId
 */
  public int getMesgTypeId() {
    return this.mesgTypeId;
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
 * Sets the value of member variable buttonId
 */
  public void setButtonId(int value) {
    this.buttonId = value;
  }
/**
 * Gets the value of member variable buttonId
 */
  public int getButtonId() {
    return this.buttonId;
  }
/**
 * Sets the value of member variable iconId
 */
  public void setIconId(int value) {
    this.iconId = value;
  }
/**
 * Gets the value of member variable iconId
 */
  public int getIconId() {
    return this.iconId;
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
 * Stubbed initialization method designed to implemented by developer.

 */
  public void initBean() throws SystemException {}
}