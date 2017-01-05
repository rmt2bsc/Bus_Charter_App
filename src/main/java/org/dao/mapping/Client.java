package org.dao.mapping;


import java.util.Date;
import java.io.*;
import com.api.persistence.db.orm.OrmBean;
import com.SystemException;


/**
 * Peer object that maps to the client database table/view.
 *
 * @author auto generated.
 */
public class Client extends OrmBean {




	// Property name constants that belong to respective DataSource, ClientView

/** The property name constant equivalent to property, Id, of respective DataSource view. */
  public static final String PROP_ID = "Id";
/** The property name constant equivalent to property, ContactFname, of respective DataSource view. */
  public static final String PROP_CONTACTFNAME = "ContactFname";
/** The property name constant equivalent to property, ContactLname, of respective DataSource view. */
  public static final String PROP_CONTACTLNAME = "ContactLname";
/** The property name constant equivalent to property, ContactCompany, of respective DataSource view. */
  public static final String PROP_CONTACTCOMPANY = "ContactCompany";
/** The property name constant equivalent to property, ContactAddress1, of respective DataSource view. */
  public static final String PROP_CONTACTADDRESS1 = "ContactAddress1";
/** The property name constant equivalent to property, ContactAddress2, of respective DataSource view. */
  public static final String PROP_CONTACTADDRESS2 = "ContactAddress2";
/** The property name constant equivalent to property, ContactAddress3, of respective DataSource view. */
  public static final String PROP_CONTACTADDRESS3 = "ContactAddress3";
/** The property name constant equivalent to property, ContactZipId, of respective DataSource view. */
  public static final String PROP_CONTACTZIPID = "ContactZipId";
/** The property name constant equivalent to property, ContactPhone, of respective DataSource view. */
  public static final String PROP_CONTACTPHONE = "ContactPhone";
/** The property name constant equivalent to property, ContactFax, of respective DataSource view. */
  public static final String PROP_CONTACTFAX = "ContactFax";
/** The property name constant equivalent to property, BillingFname, of respective DataSource view. */
  public static final String PROP_BILLINGFNAME = "BillingFname";
/** The property name constant equivalent to property, BillingLname, of respective DataSource view. */
  public static final String PROP_BILLINGLNAME = "BillingLname";
/** The property name constant equivalent to property, BillingCompany, of respective DataSource view. */
  public static final String PROP_BILLINGCOMPANY = "BillingCompany";
/** The property name constant equivalent to property, BillingAddress1, of respective DataSource view. */
  public static final String PROP_BILLINGADDRESS1 = "BillingAddress1";
/** The property name constant equivalent to property, BillingAddress2, of respective DataSource view. */
  public static final String PROP_BILLINGADDRESS2 = "BillingAddress2";
/** The property name constant equivalent to property, BillingAddress3, of respective DataSource view. */
  public static final String PROP_BILLINGADDRESS3 = "BillingAddress3";
/** The property name constant equivalent to property, BillingZipId, of respective DataSource view. */
  public static final String PROP_BILLINGZIPID = "BillingZipId";
/** The property name constant equivalent to property, BillingPhone, of respective DataSource view. */
  public static final String PROP_BILLINGPHONE = "BillingPhone";
/** The property name constant equivalent to property, BillingFax, of respective DataSource view. */
  public static final String PROP_BILLINGFAX = "BillingFax";
/** The property name constant equivalent to property, Isbillingexact, of respective DataSource view. */
  public static final String PROP_ISBILLINGEXACT = "Isbillingexact";
/** The property name constant equivalent to property, Email, of respective DataSource view. */
  public static final String PROP_EMAIL = "Email";
/** The property name constant equivalent to property, Website, of respective DataSource view. */
  public static final String PROP_WEBSITE = "Website";
/** The property name constant equivalent to property, DateCreated, of respective DataSource view. */
  public static final String PROP_DATECREATED = "DateCreated";
/** The property name constant equivalent to property, DateUpdated, of respective DataSource view. */
  public static final String PROP_DATEUPDATED = "DateUpdated";
/** The property name constant equivalent to property, UserId, of respective DataSource view. */
  public static final String PROP_USERID = "UserId";
/** The property name constant equivalent to property, Comments, of respective DataSource view. */
  public static final String PROP_COMMENTS = "Comments";



	/** The javabean property equivalent of database column client.id */
  private int id;
/** The javabean property equivalent of database column client.contact_fname */
  private String contactFname;
/** The javabean property equivalent of database column client.contact_lname */
  private String contactLname;
/** The javabean property equivalent of database column client.contact_company */
  private int contactCompany;
/** The javabean property equivalent of database column client.contact_address1 */
  private String contactAddress1;
/** The javabean property equivalent of database column client.contact_address2 */
  private String contactAddress2;
/** The javabean property equivalent of database column client.contact_address3 */
  private String contactAddress3;
/** The javabean property equivalent of database column client.contact_zip_id */
  private int contactZipId;
/** The javabean property equivalent of database column client.contact_phone */
  private String contactPhone;
/** The javabean property equivalent of database column client.contact_fax */
  private String contactFax;
/** The javabean property equivalent of database column client.billing_fname */
  private String billingFname;
/** The javabean property equivalent of database column client.billing_lname */
  private String billingLname;
/** The javabean property equivalent of database column client.billing_company */
  private int billingCompany;
/** The javabean property equivalent of database column client.billing_address1 */
  private String billingAddress1;
/** The javabean property equivalent of database column client.billing_address2 */
  private String billingAddress2;
/** The javabean property equivalent of database column client.billing_address3 */
  private String billingAddress3;
/** The javabean property equivalent of database column client.billing_zip_id */
  private int billingZipId;
/** The javabean property equivalent of database column client.billing_phone */
  private String billingPhone;
/** The javabean property equivalent of database column client.billing_fax */
  private String billingFax;
/** The javabean property equivalent of database column client.isbillingexact */
  private String isbillingexact;
/** The javabean property equivalent of database column client.email */
  private String email;
/** The javabean property equivalent of database column client.website */
  private String website;
/** The javabean property equivalent of database column client.date_created */
  private java.util.Date dateCreated;
/** The javabean property equivalent of database column client.date_updated */
  private java.util.Date dateUpdated;
/** The javabean property equivalent of database column client.user_id */
  private String userId;
/** The javabean property equivalent of database column client.comments */
  private String comments;



	// Getter/Setter Methods

/**
 * Default constructor.
 */
  public Client() throws SystemException {
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
 * Sets the value of member variable contactZipId
 */
  public void setContactZipId(int value) {
    this.contactZipId = value;
  }
/**
 * Gets the value of member variable contactZipId
 */
  public int getContactZipId() {
    return this.contactZipId;
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
 * Sets the value of member variable contactFax
 */
  public void setContactFax(String value) {
    this.contactFax = value;
  }
/**
 * Gets the value of member variable contactFax
 */
  public String getContactFax() {
    return this.contactFax;
  }
/**
 * Sets the value of member variable billingFname
 */
  public void setBillingFname(String value) {
    this.billingFname = value;
  }
/**
 * Gets the value of member variable billingFname
 */
  public String getBillingFname() {
    return this.billingFname;
  }
/**
 * Sets the value of member variable billingLname
 */
  public void setBillingLname(String value) {
    this.billingLname = value;
  }
/**
 * Gets the value of member variable billingLname
 */
  public String getBillingLname() {
    return this.billingLname;
  }
/**
 * Sets the value of member variable billingCompany
 */
  public void setBillingCompany(int value) {
    this.billingCompany = value;
  }
/**
 * Gets the value of member variable billingCompany
 */
  public int getBillingCompany() {
    return this.billingCompany;
  }
/**
 * Sets the value of member variable billingAddress1
 */
  public void setBillingAddress1(String value) {
    this.billingAddress1 = value;
  }
/**
 * Gets the value of member variable billingAddress1
 */
  public String getBillingAddress1() {
    return this.billingAddress1;
  }
/**
 * Sets the value of member variable billingAddress2
 */
  public void setBillingAddress2(String value) {
    this.billingAddress2 = value;
  }
/**
 * Gets the value of member variable billingAddress2
 */
  public String getBillingAddress2() {
    return this.billingAddress2;
  }
/**
 * Sets the value of member variable billingAddress3
 */
  public void setBillingAddress3(String value) {
    this.billingAddress3 = value;
  }
/**
 * Gets the value of member variable billingAddress3
 */
  public String getBillingAddress3() {
    return this.billingAddress3;
  }
/**
 * Sets the value of member variable billingZipId
 */
  public void setBillingZipId(int value) {
    this.billingZipId = value;
  }
/**
 * Gets the value of member variable billingZipId
 */
  public int getBillingZipId() {
    return this.billingZipId;
  }
/**
 * Sets the value of member variable billingPhone
 */
  public void setBillingPhone(String value) {
    this.billingPhone = value;
  }
/**
 * Gets the value of member variable billingPhone
 */
  public String getBillingPhone() {
    return this.billingPhone;
  }
/**
 * Sets the value of member variable billingFax
 */
  public void setBillingFax(String value) {
    this.billingFax = value;
  }
/**
 * Gets the value of member variable billingFax
 */
  public String getBillingFax() {
    return this.billingFax;
  }
/**
 * Sets the value of member variable isbillingexact
 */
  public void setIsbillingexact(String value) {
    this.isbillingexact = value;
  }
/**
 * Gets the value of member variable isbillingexact
 */
  public String getIsbillingexact() {
    return this.isbillingexact;
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
 * Sets the value of member variable comments
 */
  public void setComments(String value) {
    this.comments = value;
  }
/**
 * Gets the value of member variable comments
 */
  public String getComments() {
    return this.comments;
  }
/**
 * Stubbed initialization method designed to implemented by developer.

 */
  public void initBean() throws SystemException {}
}