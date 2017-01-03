package org.dao;

import java.util.Date;
import java.util.List;

import org.dao.mapping.BusDetail;
import org.dao.mapping.Business;
import org.dao.mapping.Client;
import org.dao.mapping.Expenses;
import org.dao.mapping.GeneralCodes;
import org.dao.mapping.GeneralCodesGroup;
import org.dao.mapping.OrderExpenses;
import org.dao.mapping.Orders;
import org.dao.mapping.Quote;
import org.dao.mapping.StatesCode;
import org.dao.mapping.Transaction;
import org.dao.mapping.VwCharterOrderList;
import org.dao.mapping.VwClientList;
import org.dao.mapping.VwInvoiceSummary;
import org.dao.mapping.Zipcode;
import org.maint.charterorder.CharterOrderConst;

import com.api.persistence.AbstractDaoClientImpl;
import com.api.persistence.db.orm.OrmBean;
import com.nv.security.UserSecurityManager;

/**
 * An RMT2 ORM implementation of the bus charter DAO interface,
 * {@link BusCharterDao}
 * 
 * @author rterrell
 *
 */
class BusCharterDaoImpl extends AbstractDaoClientImpl implements BusCharterDao {

    /**
     * 
     */
    BusCharterDaoImpl() {
        super();
    }

    BusCharterDaoImpl(String contextName) {
        super(contextName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see dao.BusCharterDao#getCompany(org.orm.mapping.CompanyInfo)
     */
    @Override
    public List<Business> fetchCompany(Business criteria)
            throws BusCharterDaoException {
        try {
            List<Business> list = this.client.retrieveList(criteria);
            return list;
        } catch (Exception e) {
            throw new BusCharterDaoException(e);
        }
    }

    @Override
    public List<Client> fetchClient(Client criteria)
            throws BusCharterDaoException {
        try {
            List<Client> list = this.client.retrieveList(criteria);
            return list;
        } catch (Exception e) {
            throw new BusCharterDaoException(e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#fetchClient(org.dao.mapping.VwClientList)
     */
    @Override
    public List<VwClientList> fetchClient(VwClientList criteria)
            throws BusCharterDaoException {
        try {
            List<VwClientList> list = this.client.retrieveList(criteria);
            return list;
        } catch (Exception e) {
            throw new BusCharterDaoException(e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.dao.BusCharterDao#fetchLookupCodeGroup(org.dao.mapping.GeneralCodesGroup
     * )
     */
    @Override
    public List<GeneralCodesGroup> fetchLookupCodeGroup(
            GeneralCodesGroup criteria) throws BusCharterDaoException {
        try {
            List<GeneralCodesGroup> list = this.client.retrieveList(criteria);
            return list;
        } catch (Exception e) {
            throw new BusCharterDaoException(e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see dao.BusCharterDao#getLookupCodeByGroup(int)
     */
    @Override
    public List<GeneralCodes> fetchLookupCode(GeneralCodes criteria)
            throws BusCharterDaoException {

        try {
            List<GeneralCodes> list = this.client.retrieveList(criteria);
            return list;
        } catch (Exception e) {
            throw new BusCharterDaoException(e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see dao.BusCharterDao#getBusDetails(int)
     */
    @Override
    public List<BusDetail> fetchBus(BusDetail criteria)
            throws BusCharterDaoException {
        try {
            List<BusDetail> list = this.client.retrieveList(criteria);
            return list;
        } catch (Exception e) {
            throw new BusCharterDaoException(e);
        }
    }

    /**
     * Queries the vw_charter_order database view for charter orders based on
     * selection criteria.
     * 
     * @param criteria
     *            an instance of {@link VwCharterOrderList} containing the
     *            selection criteria
     * @return List of {@link VwCharterOrderList} or null when no data is found
     * @throws BusCharterDaoException
     */
    @Override
    public List<VwCharterOrderList> fetchCharterOrder(
            VwCharterOrderList criteria) throws BusCharterDaoException {
        try {
            List<VwCharterOrderList> list = this.client.retrieveList(criteria);
            return list;
        } catch (Exception e) {
            throw new BusCharterDaoException(e);
        }
    }

    /**
     * Queries the orders database table for basic orders based on selection
     * criteria.
     * 
     * @param criteria
     *            an instance of {@link Orders} containing the selection
     *            criteria
     * @return List of {@link Orders} or null when no data is found
     * @throws BusCharterDaoException
     */
    @Override
    public List<Orders> fetchOrder(Orders criteria)
            throws BusCharterDaoException {
        try {
            List<Orders> list = this.client.retrieveList(criteria);
            return list;
        } catch (Exception e) {
            throw new BusCharterDaoException(e);
        }
    }

    /**
     * Queries the quote database table based on selection criteria.
     * 
     * @param criteria
     *            an instance of {@link Quote} containing the selection criteria
     * @return List of {@link Quote} or null when no data is found
     * @throws BusCharterDaoException
     */
    @Override
    public List<Quote> fetchQuote(Quote criteria) throws BusCharterDaoException {
        try {
            List<Quote> list = this.client.retrieveList(criteria);
            return list;
        } catch (Exception e) {
            throw new BusCharterDaoException(e);
        }
    }

    /**
     * Queries the transaction database table based on selection criteria.
     * 
     * @param criteria
     *            an instance of {@link Transaction} containing the selection
     *            criteria
     * @return List of {@link Transaction} or null when no data is found
     * @throws BusCharterDaoException
     */
    @Override
    public List<Transaction> fetchTransaction(Transaction criteria)
            throws BusCharterDaoException {
        try {
            List<Transaction> list = this.client.retrieveList(criteria);
            return list;
        } catch (Exception e) {
            throw new BusCharterDaoException(e);
        }
    }

    /**
     * Queries the states_code database table based on selection criteria.
     * 
     * @param criteria
     *            an instance of {@link StatesCode} containing the selection
     *            criteria
     * @return List of {@link StatesCode} or null when no data is found
     * @throws BusCharterDaoException
     */
    @Override
    public List<StatesCode> fetchStates(StatesCode criteria)
            throws BusCharterDaoException {
        try {
            List<StatesCode> list = this.client.retrieveList(criteria);
            return list;
        } catch (Exception e) {
            throw new BusCharterDaoException(e);
        }
    }

    /**
     * Queries the expenses database table based on selection criteria.
     * 
     * @param criteria
     *            an instance of {@link Expenses} containing the selection
     *            criteria
     * @return List of {@link Expenses} or null when no data is found
     * @throws BusCharterDaoException
     */
    @Override
    public List<Expenses> fetchExpenseType(Expenses criteria)
            throws BusCharterDaoException {
        try {
            List<Expenses> list = this.client.retrieveList(criteria);
            return list;
        } catch (Exception e) {
            throw new BusCharterDaoException(e);
        }
    }

    /**
     * Queries the order_expenses database table based on selection criteria.
     * 
     * @param criteria
     *            an instance of {@link OrderExpenses} containing the selection
     *            criteria
     * @return List of {@link OrderExpenses} or null when no data is found
     * @throws BusCharterDaoException
     */
    @Override
    public List<OrderExpenses> fetchOrderExpense(OrderExpenses criteria)
            throws BusCharterDaoException {
        try {
            List<OrderExpenses> list = this.client.retrieveList(criteria);
            return list;
        } catch (Exception e) {
            throw new BusCharterDaoException(e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#fetchZip(org.dao.mapping.Zipcode)
     */
    @Override
    public List<Zipcode> fetchZip(Zipcode criteria)
            throws BusCharterDaoException {
        try {
            List<Zipcode> list = this.client.retrieveList(criteria);
            return list;
        } catch (Exception e) {
            throw new BusCharterDaoException(e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.dao.BusCharterDao#fetchInvoiceSummary(org.dao.mapping.VwInvoiceSummary
     * )
     */
    @Override
    public List<VwInvoiceSummary> fetchInvoiceSummary(VwInvoiceSummary criteria)
            throws BusCharterDaoException {
        try {
            List<VwInvoiceSummary> list = this.client.retrieveList(criteria);
            return list;
        } catch (Exception e) {
            throw new BusCharterDaoException(e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#updateClient(org.dao.mapping.Client)
     */
    @Override
    public int maintainClient(Client obj) throws BusCharterDaoException {
        int results = 0;
        if (obj.getId() <= 0) {
            results = this.insertClient(obj);
            obj.setId(results);
        }
        else {
            results = this.updateClient(obj);
        }
        return results;
    }

    private int insertClient(Client obj) throws BusCharterDaoException {
        Date dt = new Date();
        obj.setDateCreated(dt);
        obj.setDateUpdated(dt);
        obj.setUserId(UserSecurityManager.getSecurityToken().getUserId());
        int rc = this.client.insertRow(obj, true);
        return rc;
    }

    private int updateClient(Client obj) throws BusCharterDaoException {
        Date dt = new Date();
        obj.setDateUpdated(dt);
        obj.setUserId(UserSecurityManager.getSecurityToken().getUserId());
        obj.addCriteria(Client.PROP_ID, obj.getId());
        int rc = this.client.updateRow(obj);
        return rc;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#maintainQuote(org.dao.mapping.Quote)
     */
    @Override
    public int maintainQuote(Quote obj) throws BusCharterDaoException {
        int results = 0;
        if (obj.getId() <= 0) {
            results = this.insertQuote(obj);
            obj.setId(results);
        }
        else {
            results = this.updateQuote(obj);
        }
        return results;
    }

    private int insertQuote(Quote obj) throws BusCharterDaoException {
        Date dt = new Date();
        obj.setDateCreated(dt);
        obj.setDateUpdated(dt);
        obj.setUserId(UserSecurityManager.getSecurityToken().getUserId());
        obj.setStatus(CharterOrderConst.STATUS_QUOTE);
        int rc = this.client.insertRow(obj, true);
        return rc;
    }

    private int updateQuote(Quote obj) throws BusCharterDaoException {
        Date dt = new Date();
        obj.setDateUpdated(dt);
        obj.setUserId(UserSecurityManager.getSecurityToken().getUserId());
        obj.addCriteria(Quote.PROP_ID, obj.getId());
        int rc = this.client.updateRow(obj);
        return rc;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#maintainOrder(org.dao.mapping.Orders)
     */
    @Override
    public int maintainOrder(Orders obj) throws BusCharterDaoException {
        int results = 0;
        if (obj.getDropoffCollectTender() == 0) {
            obj.setNull(Orders.PROP_DROPOFFCOLLECTTENDER);
        }
        if (obj.getMinHourFactor() == 0) {
            obj.setNull(Orders.PROP_MINHOURFACTOR);
        }
        if (obj.getId() <= 0) {
            results = this.insertOrder(obj);
            obj.setId(results);
        }
        else {
            results = this.updateOrder(obj);
        }
        return results;
    }

    private int insertOrder(Orders obj) throws BusCharterDaoException {
        Date dt = new Date();
        obj.setDateCreated(dt);
        obj.setDateUpdated(dt);
        obj.setUserId(UserSecurityManager.getSecurityToken().getUserId());
        int rc = this.client.insertRow(obj, true);
        return rc;
    }

    private int updateOrder(Orders obj) throws BusCharterDaoException {
        Date dt = new Date();
        obj.setDateUpdated(dt);
        obj.setUserId(UserSecurityManager.getSecurityToken().getUserId());
        obj.addCriteria(Orders.PROP_ID, obj.getId());
        int rc = this.client.updateRow(obj);
        return rc;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#maintainOrderBuses(java.util.List)
     */
    @Override
    public int maintainOrderBuses(List<BusDetail> obj)
            throws BusCharterDaoException {
        int results = 0;
        for (BusDetail bus : obj) {
            this.maintainOrderBus(bus);
            results++;
        }
        return results;
    }

    protected int maintainOrderBus(BusDetail obj) throws BusCharterDaoException {
        int results = 0;
        if (obj.getMinHourFactor() == 0) {
            obj.setNull(Orders.PROP_MINHOURFACTOR);
        }
        if (obj.getId() <= 0) {
            results = this.insertBus(obj);
            obj.setId(results);
        }
        else {
            results = this.updateBus(obj);
        }
        return results;
    }

    private int insertBus(BusDetail obj) throws BusCharterDaoException {
        Date dt = new Date();
        obj.setDateCreated(dt);
        obj.setDateUpdated(dt);
        obj.setUserId(UserSecurityManager.getSecurityToken().getUserId());
        int rc = this.client.insertRow(obj, true);
        return rc;
    }

    private int updateBus(BusDetail obj) throws BusCharterDaoException {
        Date dt = new Date();
        obj.setDateUpdated(dt);
        obj.setUserId(UserSecurityManager.getSecurityToken().getUserId());
        obj.addCriteria(BusDetail.PROP_ID, obj.getId());
        int rc = this.client.updateRow(obj);
        return rc;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.dao.BusCharterDao#maintainTransaction(org.dao.mapping.Transaction)
     */
    @Override
    public int maintainTransaction(Transaction obj)
            throws BusCharterDaoException {
        int results = 0;
        if (obj.getId() <= 0) {
            results = this.insertTransaction(obj);
            obj.setId(results);
        }
        else {
            results = this.updateTransaction(obj);
        }
        return results;
    }

    private int insertTransaction(Transaction obj)
            throws BusCharterDaoException {
        Date dt = new Date();
        obj.setDateCreated(dt);
        obj.setDateUpdated(dt);
        obj.setUserId(UserSecurityManager.getSecurityToken().getUserId());
        int rc = this.client.insertRow(obj, true);
        return rc;
    }

    private int updateTransaction(Transaction obj)
            throws BusCharterDaoException {
        Date dt = new Date();
        obj.setDateUpdated(dt);
        obj.setUserId(UserSecurityManager.getSecurityToken().getUserId());
        obj.addCriteria(Transaction.PROP_ID, obj.getId());
        int rc = this.client.updateRow(obj);
        return rc;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.dao.BusCharterDao#maintainOrderExpense(org.dao.mapping.OrderExpenses)
     */
    @Override
    public int maintainOrderExpense(OrderExpenses obj)
            throws BusCharterDaoException {
        int results = 0;
        if (obj.getId() <= 0) {
            results = this.insertOrderExpense(obj);
            obj.setId(results);
        }
        else {
            results = this.updateOrderExpense(obj);
        }
        return results;
    }

    private int insertOrderExpense(OrderExpenses obj)
            throws BusCharterDaoException {
        Date dt = new Date();
        obj.setDateCreated(dt);
        obj.setDateUpdated(dt);
        obj.setUserId(UserSecurityManager.getSecurityToken().getUserId());
        int rc = this.client.insertRow(obj, true);
        return rc;
    }

    private int updateOrderExpense(OrderExpenses obj)
            throws BusCharterDaoException {
        Date dt = new Date();
        obj.setDateUpdated(dt);
        obj.setUserId(UserSecurityManager.getSecurityToken().getUserId());
        obj.addCriteria(OrderExpenses.PROP_ID, obj.getId());
        int rc = this.client.updateRow(obj);
        return rc;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#deleteClient(org.dao.mapping.Client)
     */
    @Override
    public int deleteClient(Client criteria) throws BusCharterDaoException {
        return this.delete(criteria);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#deleteQuote(org.dao.mapping.Quote)
     */
    @Override
    public int deleteQuote(Quote criteria) throws BusCharterDaoException {
        return this.delete(criteria);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#deleteOrder(org.dao.mapping.Orders)
     */
    @Override
    public int deleteOrder(Orders criteria) throws BusCharterDaoException {
        return this.delete(criteria);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#deleteBusDetail(org.dao.mapping.BusDetail)
     */
    @Override
    public int deleteBusDetail(BusDetail criteria)
            throws BusCharterDaoException {
        return this.delete(criteria);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#deleteTransaction(org.dao.mapping.Transaction)
     */
    @Override
    public int deleteTransaction(Transaction criteria)
            throws BusCharterDaoException {
        return this.delete(criteria);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#deleteExpenses(org.dao.mapping.Expenses)
     */
    @Override
    public int deleteOrderExpenses(OrderExpenses criteria)
            throws BusCharterDaoException {
        return this.delete(criteria);
    }

    private int delete(OrmBean criteria) throws BusCharterDaoException {
        try {
            return this.client.deleteRow(criteria);
        } catch (Exception e) {
            throw new BusCharterDaoException(e);
        }
    }

}
