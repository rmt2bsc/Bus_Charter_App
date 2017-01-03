package org.dao;

import org.dao.mapping.Client;
import org.dao.mapping.VwClientList;

import com.RMT2Base;

/**
 * Factory class for creating Bus Charter DAO related objects.
 * 
 * @author Roy Terrell
 * 
 */
public class BusCharterDaoFactory extends RMT2Base {
    private static BusCharterDao DAO;

    /**
     * Default constructor
     */
    public BusCharterDaoFactory() {
        return;
    }

    /**
     * Creates an instance of <i>BusCharterDao</i> using the RMT2 ORM basic
     * implementation.
     * 
     * @param appName
     *            application name or null to use
     *            <i>config.DB-ORM-Config.properties</i>.
     * 
     * @return an instance of {@link BusCharterDao}
     */
    public static final BusCharterDao createDao(String appName) {
        if (DAO == null) {
            BusCharterDao dao = new BusCharterDaoImpl(appName);
            // BusCharterDao dao = new BusCharterMockDataDaoImpl();
            DAO = dao;
        }
        return DAO;
    }

    /**
     * 
     * @param src
     * @return
     */
    public static final Client createClient(VwClientList src) {
        if (src == null) {
            return null;
        }
        Client obj = new Client();
        obj.setId(src.getClientId());
        obj.setContactLname(src.getContactLname());
        obj.setContactFname(src.getContactFname());
        obj.setContactCompany(src.getContactCompany());
        obj.setContactAddress1(src.getContactAddress1());
        obj.setContactAddress2(src.getContactAddress2());
        obj.setContactAddress3(src.getContactAddress3());
        obj.setContactZipId(src.getContactZipId());
        obj.setContactPhone(src.getContactPhone());
        obj.setContactFax(src.getContactFax());

        obj.setBillingLname(src.getBillingLname());
        obj.setBillingFname(src.getBillingFname());
        obj.setBillingCompany(src.getBillingCompany());
        obj.setBillingAddress1(src.getBillingAddress1());
        obj.setBillingAddress2(src.getBillingAddress2());
        obj.setBillingAddress3(src.getBillingAddress3());
        obj.setBillingZipId(src.getBillingZipId());
        obj.setBillingPhone(src.getBillingPhone());
        obj.setBillingFax(src.getBillingFax());

        obj.setEmail(src.getEmail());
        obj.setWebsite(src.getWebsite());
        obj.setComments(src.getComments());
        obj.setIsbillingexact(src.getIsBillingExcat());

        obj.setDateCreated(src.getDateCreated());
        obj.setDateUpdated(src.getDateUpdated());
        obj.setUserId(src.getUserId());
        return obj;
    }
}
