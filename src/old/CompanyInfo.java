package org.dao.mapping;


import java.util.Date;
import java.io.*;
import com.api.persistence.db.orm.OrmBean;
import com.SystemException;


/**
 * Peer object that maps to the company_info database table/view.
 *
 * @author auto generated.
 */
public class CompanyInfo extends OrmBean {




	// Property name constants that belong to respective DataSource, CompanyInfoView

/** The property name constant equivalent to property, Id, of respective DataSource view. */
  public static final String PROP_ID = "Id";
/** The property name constant equivalent to property, Name, of respective DataSource view. */
  public static final String PROP_NAME = "Name";
/** The property name constant equivalent to property, Addr1, of respective DataSource view. */
  public static final String PROP_ADDR1 = "Addr1";
/** The property name constant equivalent to property, Addr2, of respective DataSource view. */
  public static final String PROP_ADDR2 = "Addr2";
/** The property name constant equivalent to property, City, of respective DataSource view. */
  public static final String PROP_CITY = "City";
/** The property name constant equivalent to property, State, of respective DataSource view. */
  public static final String PROP_STATE = "State";
/** The property name constant equivalent to property, Zip, of respective DataSource view. */
  public static final String PROP_ZIP = "Zip";
/** The property name constant equivalent to property, Phone, of respective DataSource view. */
  public static final String PROP_PHONE = "Phone";
/** The property name constant equivalent to property, Fax, of respective DataSource view. */
  public static final String PROP_FAX = "Fax";
/** The property name constant equivalent to property, Cell, of respective DataSource view. */
  public static final String PROP_CELL = "Cell";
/** The property name constant equivalent to property, Email, of respective DataSource view. */
  public static final String PROP_EMAIL = "Email";
/** The property name constant equivalent to property, Website, of respective DataSource view. */
  public static final String PROP_WEBSITE = "Website";
/** The property name constant equivalent to property, OwnerName, of respective DataSource view. */
  public static final String PROP_OWNERNAME = "OwnerName";
/** The property name constant equivalent to property, Active, of respective DataSource view. */
  public static final String PROP_ACTIVE = "Active";



	/** The javabean property equivalent of database column company_info.id */
  private char id;
/** The javabean property equivalent of database column company_info.name */
  private String name;
/** The javabean property equivalent of database column company_info.addr1 */
  private String addr1;
/** The javabean property equivalent of database column company_info.addr2 */
  private String addr2;
/** The javabean property equivalent of database column company_info.city */
  private String city;
/** The javabean property equivalent of database column company_info.state */
  private String state;
/** The javabean property equivalent of database column company_info.zip */
  private String zip;
/** The javabean property equivalent of database column company_info.phone */
  private String phone;
/** The javabean property equivalent of database column company_info.fax */
  private String fax;
/** The javabean property equivalent of database column company_info.cell */
  private String cell;
/** The javabean property equivalent of database column company_info.email */
  private String email;
/** The javabean property equivalent of database column company_info.website */
  private String website;
/** The javabean property equivalent of database column company_info.owner_name */
  private String ownerName;
/** The javabean property equivalent of database column company_info.active */
  private int active;



	// Getter/Setter Methods

/**
 * Default constructor.
 */
  public CompanyInfo() throws SystemException {
	super();
 }
/**
 * Sets the value of member variable id
 */
  public void setId(char value) {
    this.id = value;
  }
/**
 * Gets the value of member variable id
 */
  public char getId() {
    return this.id;
  }
/**
 * Sets the value of member variable name
 */
  public void setName(String value) {
    this.name = value;
  }
/**
 * Gets the value of member variable name
 */
  public String getName() {
    return this.name;
  }
/**
 * Sets the value of member variable addr1
 */
  public void setAddr1(String value) {
    this.addr1 = value;
  }
/**
 * Gets the value of member variable addr1
 */
  public String getAddr1() {
    return this.addr1;
  }
/**
 * Sets the value of member variable addr2
 */
  public void setAddr2(String value) {
    this.addr2 = value;
  }
/**
 * Gets the value of member variable addr2
 */
  public String getAddr2() {
    return this.addr2;
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
  public void setZip(String value) {
    this.zip = value;
  }
/**
 * Gets the value of member variable zip
 */
  public String getZip() {
    return this.zip;
  }
/**
 * Sets the value of member variable phone
 */
  public void setPhone(String value) {
    this.phone = value;
  }
/**
 * Gets the value of member variable phone
 */
  public String getPhone() {
    return this.phone;
  }
/**
 * Sets the value of member variable fax
 */
  public void setFax(String value) {
    this.fax = value;
  }
/**
 * Gets the value of member variable fax
 */
  public String getFax() {
    return this.fax;
  }
/**
 * Sets the value of member variable cell
 */
  public void setCell(String value) {
    this.cell = value;
  }
/**
 * Gets the value of member variable cell
 */
  public String getCell() {
    return this.cell;
  }
/**
 * Sets the value of member variable email
 */
  public void setEmail(String value) {
    this.email = value;
  }
/**
 * Gets the value of member variable email
 */
  public String getEmail() {
    return this.email;
  }
/**
 * Sets the value of member variable website
 */
  public void setWebsite(String value) {
    this.website = value;
  }
/**
 * Gets the value of member variable website
 */
  public String getWebsite() {
    return this.website;
  }
/**
 * Sets the value of member variable ownerName
 */
  public void setOwnerName(String value) {
    this.ownerName = value;
  }
/**
 * Gets the value of member variable ownerName
 */
  public String getOwnerName() {
    return this.ownerName;
  }
/**
 * Sets the value of member variable active
 */
  public void setActive(int value) {
    this.active = value;
  }
/**
 * Gets the value of member variable active
 */
  public int getActive() {
    return this.active;
  }
/**
 * Stubbed initialization method designed to implemented by developer.

 */
  public void initBean() throws SystemException {}
}