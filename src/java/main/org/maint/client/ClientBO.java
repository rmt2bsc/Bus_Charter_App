package org.maint.client;

import java.util.List;

import org.dao.BusCharterDao;
import org.dao.BusCharterDaoFactory;
import org.dao.mapping.Client;
import org.dao.mapping.Quote;
import org.dao.mapping.VwClientList;
import org.maint.charterorder.CharterOrderBO;

import com.nv.dao.SwingDaoTransaction;
import com.util.RMT2Money;
import com.util.RMT2String;

/**
 * The business object containing domain and data access logic for managing
 * client related models.
 * 
 * @author rterrell
 *
 */
public class ClientBO extends SwingDaoTransaction {

    private BusCharterDao dao;

    /**
     * Default constructor
     */
    public ClientBO() {
        super();
        this.dao = BusCharterDaoFactory.createDao(null);
        this.setBaseDao(this.dao);
        return;
    }

    /**
     * Get an individual client entity based on its unique id.
     * 
     * @param clientId
     *            the id of the client
     * @return {@link CompanyInfo}
     */
    public Client getClientInfo(int clientId) {
        Client criteria = new Client();
        criteria.addCriteria(Client.PROP_ID, clientId);
        List<Client> results = this.dao.fetchClient(criteria);
        if (results == null || results.size() == 0) {
            return null;
        }
        if (results.size() > 1) {
            throw new ClientBOException(
                    "Client query returned too many rows.  Should be just 1 one returned");
        }
        return results.get(0);
    }

    /**
     * Get an individual client entity based on its unique id.
     * 
     * @param clientId
     *            the id of the client
     * @return {@link CompanyInfo}
     */
    public VwClientList getClientInfoExt(int clientId) {
        VwClientList criteria = new VwClientList();
        criteria.addCriteria(VwClientList.PROP_CLIENTID, clientId);
        List<VwClientList> results = this.dao.fetchClient(criteria);
        if (results == null || results.size() == 0) {
            return null;
        }
        if (results.size() > 1) {
            throw new ClientBOException(
                    "Extended Client query returned too many rows.  Should be just 1 one returned for client id, "
                            + clientId);
        }
        return results.get(0);
    }

    /**
     * Performs a client search using selection criteria contained in a
     * ClientSearchCriteriaBean object.
     * 
     * @param selectionCriteria
     *            data used to filter client query
     * @return a List of {@link VwClientList} objects or null if no data is
     *         found.
     */
    public List<VwClientList> getClientInfo(
            ClientSearchCriteriaBean selectionCriteria) {
        VwClientList criteria;
        if (selectionCriteria == null) {
            throw new ClientBOException(
                    "Unable to perform client search due to an invalid or null client selection criteria bean as input");
        }
        else {
            criteria = new VwClientList();
        }
        Number numVal = 0;

        // Client section
        if (selectionCriteria.getClientId() != null) {
            if (RMT2Money.isNumeric(selectionCriteria.getClientId())) {
                numVal = RMT2Money.stringToNumber(selectionCriteria
                        .getClientId());
                criteria.addCriteria(VwClientList.PROP_CLIENTID,
                        numVal.intValue());
            }
        }
        if (selectionCriteria.getFirstName() != null) {
            criteria.addLikeClause(VwClientList.PROP_CONTACTFNAME,
                    selectionCriteria.getFirstName());
        }
        if (selectionCriteria.getLastName() != null) {
            criteria.addLikeClause(VwClientList.PROP_CONTACTLNAME,
                    selectionCriteria.getLastName());
        }
        if (selectionCriteria.getCompany() != null) {
            if (RMT2Money.isNumeric(selectionCriteria.getCompany())) {
                numVal = RMT2Money.stringToNumber(selectionCriteria
                        .getCompany());
                criteria.addCriteria(VwClientList.PROP_CONTACTCOMPANY,
                        numVal.intValue());
            }
        }
        if (selectionCriteria.getState() != null) {
            criteria.addCriteria(VwClientList.PROP_CONTACTSTATE,
                    selectionCriteria.getState());
        }
        if (selectionCriteria.getCity() != null) {
            criteria.addCriteria(VwClientList.PROP_CONTACTCITY,
                    selectionCriteria.getCity());
        }
        if (selectionCriteria.getZip() != null) {
            if (RMT2Money.isNumeric(selectionCriteria.getZip())) {
                numVal = RMT2Money.stringToNumber(selectionCriteria.getZip());
                criteria.addCriteria(VwClientList.PROP_CONTACTZIP,
                        numVal.intValue());
            }
        }
        if (selectionCriteria.getPhone() != null) {
            criteria.addLikeClause(VwClientList.PROP_CONTACTPHONE,
                    selectionCriteria.getPhone());
        }

        criteria.addOrderBy(VwClientList.PROP_CONTACTLNAME,
                VwClientList.ORDERBY_ASCENDING);
        criteria.addOrderBy(VwClientList.PROP_CONTACTFNAME,
                VwClientList.ORDERBY_ASCENDING);
        criteria.addOrderBy(VwClientList.PROP_CONTACTCOMPANYNAME,
                VwClientList.ORDERBY_ASCENDING);
        criteria.addOrderBy(VwClientList.PROP_CONTACTCITY,
                VwClientList.ORDERBY_ASCENDING);
        criteria.addOrderBy(VwClientList.PROP_CONTACTSTATE,
                VwClientList.ORDERBY_ASCENDING);
        criteria.addOrderBy(VwClientList.PROP_CONTACTZIP,
                VwClientList.ORDERBY_ASCENDING);

        // Fetch data based on selection criteria
        List<VwClientList> items = this.dao.fetchClient(criteria);
        return items;
    }

    public int updateClient(VwClientList srcObj) {
        if (srcObj == null) {
            throw new ClientBOException(
                    "Update of client failed...invalid or null source object was found");
        }
        Client client = BusCharterDaoFactory.createClient(srcObj);

        // // The property, zipId, of the incoming client has the actual zip
        // code
        // // value. Use this value to obtain the corresponding zip id.
        // CharterOrderBO cobo = new CharterOrderBO();
        // List<Zipcode> zipList = cobo.getZipByZipcode(srcObj.getContactZip());
        // if (zipList != null) {
        // client.setContactZipId(zipList.get(0).getZipId());
        // }
        // zipList = cobo.getZipByZipcode(srcObj.getBillingZip());
        // if (zipList != null) {
        // client.setBillingZipId(zipList.get(0).getZipId());
        // }

        this.validateClient(client);

        try {
            int rc = this.dao.maintainClient(client);
            this.dao.commitTrans();
            return rc;
        } catch (Exception e) {
            this.dao.rollbackTrans();
            throw new ClientBOException(e);
        }
    }

    public void validateClient(Client client) {
        if (client == null) {
            throw new ClientBOException("Client object is invalid");
        }
        String val = client.getContactFname();
        if (val == null || val.equals(RMT2String.spaces(val.length()))) {
            throw new ClientBOException("Contact first name is required");
        }
        val = client.getContactLname();
        if (val == null || val.equals(RMT2String.spaces(val.length()))) {
            throw new ClientBOException("Contact last name is required");
        }
        int intVal = client.getContactZipId();
        if (intVal <= 0) {
            throw new ClientBOException("Contact zip code is required");
        }
        val = client.getContactPhone();
        if (val == null || val.equals(RMT2String.spaces(val.length()))) {
            throw new ClientBOException("Contact phone is required");
        }
        val = client.getBillingFname();
        if (val == null || val.equals(RMT2String.spaces(val.length()))) {
            throw new ClientBOException("Billing first name is required");
        }
        val = client.getBillingLname();
        if (val == null || val.equals(RMT2String.spaces(val.length()))) {
            throw new ClientBOException("Billing last name is required");
        }
        intVal = client.getBillingZipId();
        if (intVal <= 0) {
            throw new ClientBOException("Billing zip code is required");
        }
        val = client.getBillingPhone();
        if (val == null || val.equals(RMT2String.spaces(val.length()))) {
            throw new ClientBOException("Billing phone is required");
        }
        return;
    }

    public int deleteClient(int clientId) {
        CharterOrderBO cobo = new CharterOrderBO();
        Quote quoteCriteria = new Quote();
        quoteCriteria.addCriteria(Quote.PROP_CLIENTID, clientId);
        List list = this.dao.fetchQuote(quoteCriteria);
        if (list != null && list.size() > 0) {
            this.msg = "Client, "
                    + clientId
                    + ", cannot be deleted.  Client is asscociated with one or more quotes/orders in the system!";
            throw new ClientBOException(this.msg);
        }
        Client criteria = new Client();
        criteria.addCriteria(Client.PROP_ID, clientId);
        try {
            int row = this.dao.deleteClient(criteria);
            this.dao.commitTrans();
            return row;
        } catch (Exception e) {
            this.dao.rollbackTrans();
            throw new ClientBOException("Client deletion failed", e);
        }
    }

}
