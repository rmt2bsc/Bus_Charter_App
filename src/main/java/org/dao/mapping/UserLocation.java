package org.dao.mapping;


import java.util.Date;
import java.io.*;
import com.api.persistence.db.orm.OrmBean;
import com.SystemException;


/**
 * Peer object that maps to the user_location database table/view.
 *
 * @author auto generated.
 */
public class UserLocation extends OrmBean {




	// Property name constants that belong to respective DataSource, UserLocationView

/** The property name constant equivalent to property, Id, of respective DataSource view. */
  public static final String PROP_ID = "Id";
/** The property name constant equivalent to property, LoginId, of respective DataSource view. */
  public static final String PROP_LOGINID = "LoginId";
/** The property name constant equivalent to property, UserName, of respective DataSource view. */
  public static final String PROP_USERNAME = "UserName";
/** The property name constant equivalent to property, Firstname, of respective DataSource view. */
  public static final String PROP_FIRSTNAME = "Firstname";
/** The property name constant equivalent to property, Lastname, of respective DataSource view. */
  public static final String PROP_LASTNAME = "Lastname";
/** The property name constant equivalent to property, Title, of respective DataSource view. */
  public static final String PROP_TITLE = "Title";
/** The property name constant equivalent to property, StartDate, of respective DataSource view. */
  public static final String PROP_STARTDATE = "StartDate";
/** The property name constant equivalent to property, TerminationDate, of respective DataSource view. */
  public static final String PROP_TERMINATIONDATE = "TerminationDate";
/** The property name constant equivalent to property, AccessLevel, of respective DataSource view. */
  public static final String PROP_ACCESSLEVEL = "AccessLevel";
/** The property name constant equivalent to property, Password, of respective DataSource view. */
  public static final String PROP_PASSWORD = "Password";
/** The property name constant equivalent to property, TotalLogons, of respective DataSource view. */
  public static final String PROP_TOTALLOGONS = "TotalLogons";
/** The property name constant equivalent to property, LogonCity, of respective DataSource view. */
  public static final String PROP_LOGONCITY = "LogonCity";
/** The property name constant equivalent to property, LogonAreacode, of respective DataSource view. */
  public static final String PROP_LOGONAREACODE = "LogonAreacode";
/** The property name constant equivalent to property, LogonPhonePrefix, of respective DataSource view. */
  public static final String PROP_LOGONPHONEPREFIX = "LogonPhonePrefix";
/** The property name constant equivalent to property, DateCreated, of respective DataSource view. */
  public static final String PROP_DATECREATED = "DateCreated";
/** The property name constant equivalent to property, DateUpdated, of respective DataSource view. */
  public static final String PROP_DATEUPDATED = "DateUpdated";
/** The property name constant equivalent to property, UserId, of respective DataSource view. */
  public static final String PROP_USERID = "UserId";



	/** The javabean property equivalent of database column user_location.id */
  private int id;
/** The javabean property equivalent of database column user_location.login_id */
  private char loginId;
/** The javabean property equivalent of database column user_location.user_name */
  private char userName;
/** The javabean property equivalent of database column user_location.firstname */
  private char firstname;
/** The javabean property equivalent of database column user_location.lastname */
  private char lastname;
/** The javabean property equivalent of database column user_location.title */
  private char title;
/** The javabean property equivalent of database column user_location.start_date */
  private java.util.Date startDate;
/** The javabean property equivalent of database column user_location.termination_date */
  private java.util.Date terminationDate;
/** The javabean property equivalent of database column user_location.access_level */
  private int accessLevel;
/** The javabean property equivalent of database column user_location.password */
  private char password;
/** The javabean property equivalent of database column user_location.total_logons */
  private int totalLogons;
/** The javabean property equivalent of database column user_location.logon_city */
  private char logonCity;
/** The javabean property equivalent of database column user_location.logon_areacode */
  private char logonAreacode;
/** The javabean property equivalent of database column user_location.logon_phone_prefix */
  private char logonPhonePrefix;
/** The javabean property equivalent of database column user_location.date_created */
  private java.util.Date dateCreated;
/** The javabean property equivalent of database column user_location.date_updated */
  private java.util.Date dateUpdated;
/** The javabean property equivalent of database column user_location.user_id */
  private String userId;



	// Getter/Setter Methods

/**
 * Default constructor.
 */
  public UserLocation() throws SystemException {
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
 * Sets the value of member variable loginId
 */
  public void setLoginId(char value) {
    this.loginId = value;
  }
/**
 * Gets the value of member variable loginId
 */
  public char getLoginId() {
    return this.loginId;
  }
/**
 * Sets the value of member variable userName
 */
  public void setUserName(char value) {
    this.userName = value;
  }
/**
 * Gets the value of member variable userName
 */
  public char getUserName() {
    return this.userName;
  }
/**
 * Sets the value of member variable firstname
 */
  public void setFirstname(char value) {
    this.firstname = value;
  }
/**
 * Gets the value of member variable firstname
 */
  public char getFirstname() {
    return this.firstname;
  }
/**
 * Sets the value of member variable lastname
 */
  public void setLastname(char value) {
    this.lastname = value;
  }
/**
 * Gets the value of member variable lastname
 */
  public char getLastname() {
    return this.lastname;
  }
/**
 * Sets the value of member variable title
 */
  public void setTitle(char value) {
    this.title = value;
  }
/**
 * Gets the value of member variable title
 */
  public char getTitle() {
    return this.title;
  }
/**
 * Sets the value of member variable startDate
 */
  public void setStartDate(java.util.Date value) {
    this.startDate = value;
  }
/**
 * Gets the value of member variable startDate
 */
  public java.util.Date getStartDate() {
    return this.startDate;
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
 * Sets the value of member variable accessLevel
 */
  public void setAccessLevel(int value) {
    this.accessLevel = value;
  }
/**
 * Gets the value of member variable accessLevel
 */
  public int getAccessLevel() {
    return this.accessLevel;
  }
/**
 * Sets the value of member variable password
 */
  public void setPassword(char value) {
    this.password = value;
  }
/**
 * Gets the value of member variable password
 */
  public char getPassword() {
    return this.password;
  }
/**
 * Sets the value of member variable totalLogons
 */
  public void setTotalLogons(int value) {
    this.totalLogons = value;
  }
/**
 * Gets the value of member variable totalLogons
 */
  public int getTotalLogons() {
    return this.totalLogons;
  }
/**
 * Sets the value of member variable logonCity
 */
  public void setLogonCity(char value) {
    this.logonCity = value;
  }
/**
 * Gets the value of member variable logonCity
 */
  public char getLogonCity() {
    return this.logonCity;
  }
/**
 * Sets the value of member variable logonAreacode
 */
  public void setLogonAreacode(char value) {
    this.logonAreacode = value;
  }
/**
 * Gets the value of member variable logonAreacode
 */
  public char getLogonAreacode() {
    return this.logonAreacode;
  }
/**
 * Sets the value of member variable logonPhonePrefix
 */
  public void setLogonPhonePrefix(char value) {
    this.logonPhonePrefix = value;
  }
/**
 * Gets the value of member variable logonPhonePrefix
 */
  public char getLogonPhonePrefix() {
    return this.logonPhonePrefix;
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
 * Stubbed initialization method designed to implemented by developer.

 */
  public void initBean() throws SystemException {}
}