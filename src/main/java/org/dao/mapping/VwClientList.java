package org.dao.mapping;


import java.util.Date;
import java.io.*;
import com.api.persistence.db.orm.OrmBean;
import com.SystemException;


/**
 * Peer object that maps to the vw_client_list database table/view.
 *
 * @author auto generated.
 */
public class VwClientList extends OrmBean {




	// Property name constants that belong to respective DataSource, VwClientListView

/** The property name constant equivalent to property, ClientId, of respective DataSource view. */
  public static final String PROP_CLIENTID = "ClientId";
/** The property name constant equivalent to property, ContactFname, of respective DataSource view. */
  public static final String PROP_CONTACTFNAME = "ContactFname";
/** The property name constant equivalent to property, ContactLname, of respective DataSource view. */
  public static final String PROP_CONTACTLNAME = "ContactLname";
/** The property name constant equivalent to property, ContactCompany, of respective DataSource view. */
  public static final String PROP_CONTACTCOMPANY = "ContactCompany";
/** The property name constant equivalent to property, ContactCompanyName, of respective DataSource view. */
  public static final String PROP_CONTACTCOMPANYNAME = "ContactCompanyName";
/** The property name constant equivalent to property, ContactAddress1, of respective DataSource view. */
  public static final String PROP_CONTACTADDRESS1 = "ContactAddress1";
/** The property name constant equivalent to property, ContactAddress2, of respective DataSource view. */
  public static final String PROP_CONTACTADDRESS2 = "ContactAddress2";
/** The property name constant equivalent to property, ContactAddress3, of respective DataSource view. */
  public static final String PROP_CONTACTADDRESS3 = "ContactAddress3";
/** The property name constant equivalent to property, ContactCity, of respective DataSource view. */
  public static final String PROP_CONTACTCITY = "ContactCity";
/** The property name constant equivalent to property, ContactState, of respective DataSource view. */
  public static final String PROP_CONTACTSTATE = "ContactState";
/** The property name constant equivalent to property, ContactZipId, of respective DataSource view. */
  public static final String PROP_CONTACTZIPID = "ContactZipId";
/** The property name constant equivalent to property, ContactZip, of respective DataSource view. */
  public static final String PROP_CONTACTZIP = "ContactZip";
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
/** The property name constant equivalent to property, BillingCompanyName, of respective DataSource view. */
  public static final String PROP_BILLINGCOMPANYNAME = "BillingCompanyName";
/** The property name constant equivalent to property, BillingAddress1, of respective DataSource view. */
  public static final String PROP_BILLINGADDRESS1 = "BillingAddress1";
/** The property name constant equivalent to property, BillingAddress2, of respective DataSource view. */
  public static final String PROP_BILLINGADDRESS2 = "BillingAddress2";
/** The property name constant equivalent to property, BillingAddress3, of respective DataSource view. */
  public static final String PROP_BILLINGADDRESS3 = "BillingAddress3";
/** The property name constant equivalent to property, BillingCity, of respective DataSource view. */
  public static final String PROP_BILLINGCITY = "BillingCity";
/** The property name constant equivalent to property, BillingState, of respective DataSource view. */
  public static final String PROP_BILLINGSTATE = "BillingState";
/** The property name constant equivalent to property, BillingZipId, of respective DataSource view. */
  public static final String PROP_BILLINGZIPID = "BillingZipId";
/** The property name constant equivalent to property, BillingZip, of respective DataSource view. */
  public static final String PROP_BILLINGZIP = "BillingZip";
/** The property name constant equivalent to property, BillingPhone, of respective DataSource view. */
  public static final String PROP_BILLINGPHONE = "BillingPhone";
/** The property name constant equivalent to property, BillingFax, of respective DataSource view. */
  public static final String PROP_BILLINGFAX = "BillingFax";
/** The property name constant equivalent to property, Email, of respective DataSource view. */
  public static final String PROP_EMAIL = "Email";
/** The property name constant equivalent to property, Website, of respective DataSource view. */
  public static final String PROP_WEBSITE = "Website";
/** The property name constant equivalent to property, Comments, of respective DataSource view. */
  public static final String PROP_COMMENTS = "Comments";
/** The property name constant equivalent to property, IsBillingExcat, of respective DataSource view. */
  public static final String PROP_ISBILLINGEXCAT = "IsBillingExcat";
/** The property name constant equivalent to property, DateCreated, of respective DataSource view. */
  public static final String PROP_DATECREATED = "DateCreated";
/** The property name constant equivalent to property, DateUpdated, of respective DataSource view. */
  public static final String PROP_DATEUPDATED = "DateUpdated";
/** The property name constant equivalent to property, UserId, of respective DataSource view. */
  public static final String PROP_USERID = "UserId";



	/** The javabean property equivalent of database column vw_client_list.client_id */
  private int clientId;
/** The javabean property equivalent of database column vw_client_list.contact_fname */
  private String contactFname;
/** The javabean property equivalent of database column vw_client_list.contact_lname */
  private String contactLname;
/** The javabean property equivalent of database column vw_client_list.contact_company */
  private int contactCompany;
/** The javabean property equivalent of database column vw_client_list.contact_company_name */
  private String contactCompanyName;
/** The javabean property equivalent of database column vw_client_list.contact_address1 */
  private String contactAddress1;
/** The javabean property equivalent of database column vw_client_list.contact_address2 */
  private String contactAddress2;
/** The javabean property equivalent of database column vw_client_list.contact_address3 */
  private String contactAddress3;
/** The javabean property equivalent of database column vw_client_list.contact_city */
  private String contactCity;
/** The javabean property equivalent of database column vw_client_list.contact_state */
  private String contactState;
/** The javabean property equivalent of database column vw_client_list.contact_zip_id */
  private int contactZipId;
/** The javabean property equivalent of database column vw_client_list.contact_zip */
  private int contactZip;
/** The javabean property equivalent of database column vw_client_list.contact_phone */
  private String contactPhone;
/** The javabean property equivalent of database column vw_client_list.contact_fax */
  private String contactFax;
/** The javabean property equivalent of database column vw_client_list.billing_fname */
  private String billingFname;
/** The javabean property equivalent of database column vw_client_list.billing_lname */
  private String billingLname;
/** The javabean property equivalent of database column vw_client_list.billing_company */
  private int billingCompany;
/** The javabean property equivalent of database column vw_client_list.billing_company_name */
  private String billingCompanyName;
/** The javabean property equivalent of database column vw_client_list.billing_address1 */
  private String billingAddress1;
/** The javabean property equivalent of database column vw_client_list.billing_address2 */
  private String billingAddress2;
/** The javabean property equivalent of database column vw_client_list.billing_address3 */
  private String billingAddress3;
/** The javabean property equivalent of database column vw_client_list.billing_city */
  private String billingCity;
/** The javabean property equivalent of database column vw_client_list.billing_state */
  private String billingState;
/** The javabean property equivalent of database column vw_client_list.billing_zip_id */
  private int billingZipId;
/** The javabean property equivalent of database column vw_client_list.billing_zip */
  private int billingZip;
/** The javabean property equivalent of database column vw_client_list.billing_phone */
  private String billingPhone;
/** The javabean property equivalent of database column vw_client_list.billing_fax */
  private String billingFax;
/** The javabean property equivalent of database column vw_client_list.email */
  private String email;
/** The javabean property equivalent of database column vw_client_list.website */
  private String website;
/** The javabean property equivalent of database column vw_client_list.comments */
  private String comments;
/** The javabean property equivalent of database column vw_client_list.is_billing_excat */
  private String isBillingExcat;
/** The javabean property equivalent of database column vw_client_list.date_created */
  private java.util.Date dateCreated;
/** The javabean property equivalent of database column vw_client_list.date_updated */
  private java.util.Date dateUpdated;
/** The javabean property equivalent of database column vw_client_list.user_id */
  private String userId;



	// Getter/Setter Methods

/**
 * Default constructor.
 */
  public VwClientList() throws SystemException {
	super();
 }
/**
 * Sets the value of member variable clientId
 */
  public void setClientId(int value) {
    this.clientId = value;
  }
/**
 * Gets the value of member variable clientId
 */
  public int getClientId() {
    return this.clientId;
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
 * Sets the value of member variable contactCompanyName
 */
  public void setContactCompanyName(String value) {
    this.contactCompanyName = value;
  }
/**
 * Gets the value of member variable contactCompanyName
 */
  public String getContactCompanyName() {
    return this.contactCompanyName;
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
 * Sets the value of member variable contactCity
 */
  public void setContactCity(String value) {
    this.contactCity = value;
  }
/**
 * Gets the value of member variable contactCity
 */
  public String getContactCity() {
    return this.contactCity;
  }
/**
 * Sets the value of member variable contactState
 */
  public void setContactState(String value) {
    this.contactState = value;
  }
/**
 * Gets the value of member variable contactState
 */
  public String getContactState() {
    return this.contactState;
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
 * Sets the value of member variable contactZip
 */
  public void setContactZip(int value) {
    this.contactZip = value;
  }
/**
 * Gets the value of member variable contactZip
 */
  public int getContactZip() {
    return this.contactZip;
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
 * Sets the value of member variable billingCompanyName
 */
  public void setBillingCompanyName(String value) {
    this.billingCompanyName = value;
  }
/**
 * Gets the value of member variable billingCompanyName
 */
  public String getBillingCompanyName() {
    return this.billingCompanyName;
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
 * Sets the value of member variable billingCity
 */
  public void setBillingCity(String value) {
    this.billingCity = value;
  }
/**
 * Gets the value of member variable billingCity
 */
  public String getBillingCity() {
    return this.billingCity;
  }
/**
 * Sets the value of member variable billingState
 */
  public void setBillingState(String value) {
    this.billingState = value;
  }
/**
 * Gets the value of member variable billingState
 */
  public String getBillingState() {
    return this.billingState;
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
 * Sets the value of member variable billingZip
 */
  public void setBillingZip(int value) {
    this.billingZip = value;
  }
/**
 * Gets the value of member variable billingZip
 */
  public int getBillingZip() {
    return this.billingZip;
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
 * Sets the value of member variable isBillingExcat
 */
  public void setIsBillingExcat(String value) {
    this.isBillingExcat = value;
  }
/**
 * Gets the value of member variable isBillingExcat
 */
  public String getIsBillingExcat() {
    return this.isBillingExcat;
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