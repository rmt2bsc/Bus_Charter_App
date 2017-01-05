package org.maint.company;

import java.util.List;

import org.dao.BusCharterDao;
import org.dao.BusCharterDaoFactory;
import org.dao.mapping.Business;

import com.nv.dao.SwingDaoTransaction;

/**
 * The business object containing domain and data access logic for managing
 * client related models.
 * 
 * @author rterrell
 *
 */
public class CompanyBO extends SwingDaoTransaction {

    private BusCharterDao dao;

    /**
     * Default constructor
     */
    public CompanyBO() {
        super();
        this.dao = BusCharterDaoFactory.createDao(null);
        this.setBaseDao(this.dao);
        return;
    }

    /**
     * Gets a list of all company entities.
     * 
     * @return List of {@link CompanyInfo} objects
     */
    public List<Business> getCompanyInfo() {
        Business criteria = new Business();
        criteria.addOrderBy(Business.PROP_LONGNAME, Business.ORDERBY_ASCENDING);
        try {
            List<Business> results = this.dao.fetchCompany(criteria);
            return results;
        } catch (Exception e) {
            throw new CompanyBOException(e);
        }
    }

    /**
     * Get an individual company entity based on its unique id.
     * 
     * @param companyId
     *            the id of the company
     * @return {@link CompanyInfo}
     */
    public Business getCompanyInfo(int companyId) {
        Business criteria = new Business();
        criteria.addCriteria(Business.PROP_ID, companyId);
        List<Business> results = this.dao.fetchCompany(criteria);
        if (results == null || results.size() == 0) {
            return null;
        }
        if (results.size() > 1) {
            throw new CompanyBOException(
                    "CompanyInfo query returned too many rows.  Should be just 1 one returned");
        }
        return results.get(0);
    }

    /**
     * Gets a list of all company entities based on business type.
     * 
     * @param businessTypeId
     *            the id of the business type
     * @return List of {@link CompanyInfo} objects
     */
    public List<Business> getCompanyInfoByBusinessType(int businessTypeId) {
        Business criteria = new Business();
        criteria.addCriteria(Business.PROP_BUSINESSTYPE, businessTypeId);
        criteria.addOrderBy(Business.PROP_LONGNAME, Business.ORDERBY_ASCENDING);
        try {
            List<Business> results = this.dao.fetchCompany(criteria);
            return results;
        } catch (Exception e) {
            throw new CompanyBOException(e);
        }
    }

    /**
     * 
     * @param businessTypeId
     * @return
     */
    public List<Business> getCompanyInfoByBusinessType(
            List<Integer> businessTypeId) {
        Business criteria = new Business();
        Integer a[] = new Integer[businessTypeId.size()];
        a = businessTypeId.toArray(a);
        criteria.addInClause(Business.PROP_BUSINESSTYPE, a);
        criteria.addOrderBy(Business.PROP_LONGNAME, Business.ORDERBY_ASCENDING);
        try {
            List<Business> results = this.dao.fetchCompany(criteria);
            return results;
        } catch (Exception e) {
            throw new CompanyBOException(e);
        }
    }

    public int deleteCompany(int companyId) {
        return 0;
    }
}
