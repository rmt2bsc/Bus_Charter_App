package org.dao;

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

import com.api.persistence.DaoClient;

/**
 * Class contract for accessing and/or updating data from the bus charter
 * database.
 * 
 * @author rterrell
 *
 */
public interface BusCharterDao extends DaoClient {

    /**
     * Queries the datasource for basic order entries.
     * 
     * @param criteria
     *            an instance of {@link Quote} containing the selection criteria
     * @return List of {@link Quote} or null when no data is found
     * @throws BusCharterDaoException
     */
    List<Quote> fetchQuote(Quote criteria) throws BusCharterDaoException;

    /**
     * Queries the datasource for basic order entries.
     * 
     * @param criteria
     *            an instance of {@link Orders} containing the selection
     *            criteria
     * @return List of {@link Orders} or null when no data is found
     * @throws BusCharterDaoException
     */
    List<Orders> fetchOrder(Orders criteria) throws BusCharterDaoException;

    /**
     * Queries the datasource for charter order entries.
     * 
     * @param criteria
     *            an instance of {@link VwCharterOrderList} containing the
     *            selection criteria
     * @return List of {@link VwCharterOrderList} or null when no data is found
     * @throws BusCharterDaoException
     */
    List<VwCharterOrderList> fetchCharterOrder(VwCharterOrderList criteria)
            throws BusCharterDaoException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BusCharterDaoException
     */
    List<Business> fetchCompany(Business criteria)
            throws BusCharterDaoException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BusCharterDaoException
     */
    List<Client> fetchClient(Client criteria) throws BusCharterDaoException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BusCharterDaoException
     */
    List<VwClientList> fetchClient(VwClientList criteria)
            throws BusCharterDaoException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BusCharterDaoException
     */
    List<GeneralCodesGroup> fetchLookupCodeGroup(GeneralCodesGroup criteria)
            throws BusCharterDaoException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BusCharterDaoException
     */
    List<GeneralCodes> fetchLookupCode(GeneralCodes criteria)
            throws BusCharterDaoException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BusCharterDaoException
     */
    List<BusDetail> fetchBus(BusDetail criteria) throws BusCharterDaoException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BusCharterDaoException
     */
    List<Transaction> fetchTransaction(Transaction criteria)
            throws BusCharterDaoException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BusCharterDaoException
     */
    List<StatesCode> fetchStates(StatesCode criteria)
            throws BusCharterDaoException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BusCharterDaoException
     */
    List<Expenses> fetchExpenseType(Expenses criteria)
            throws BusCharterDaoException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BusCharterDaoException
     */
    List<OrderExpenses> fetchOrderExpense(OrderExpenses criteria)
            throws BusCharterDaoException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BusCharterDaoException
     */
    List<VwInvoiceSummary> fetchInvoiceSummary(VwInvoiceSummary criteria)
            throws BusCharterDaoException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BusCharterDaoException
     */
    List<Zipcode> fetchZip(Zipcode criteria) throws BusCharterDaoException;

    /**
     * 
     * @param obj
     * @return
     * @throws BusCharterDaoException
     */
    int maintainClient(Client obj) throws BusCharterDaoException;

    /**
     * 
     * @param obj
     * @return
     * @throws BusCharterDaoException
     */
    int maintainQuote(Quote obj) throws BusCharterDaoException;

    /**
     * 
     * @param obj
     * @return
     * @throws BusCharterDaoException
     */
    int maintainOrder(Orders obj) throws BusCharterDaoException;

    /**
     * 
     * @param obj
     * @return
     * @throws BusCharterDaoException
     */
    int maintainOrderBuses(List<BusDetail> obj) throws BusCharterDaoException;

    /**
     * 
     * @param obj
     * @return
     * @throws BusCharterDaoException
     */
    int maintainTransaction(Transaction obj) throws BusCharterDaoException;

    /**
     * 
     * @param obj
     * @return
     * @throws BusCharterDaoException
     */
    int maintainOrderExpense(OrderExpenses obj) throws BusCharterDaoException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BusCharterDaoException
     */
    int deleteClient(Client criteria) throws BusCharterDaoException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BusCharterDaoException
     */
    int deleteQuote(Quote criteria) throws BusCharterDaoException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BusCharterDaoException
     */
    int deleteOrder(Orders criteria) throws BusCharterDaoException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BusCharterDaoException
     */
    int deleteBusDetail(BusDetail criteria) throws BusCharterDaoException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BusCharterDaoException
     */
    int deleteTransaction(Transaction criteria) throws BusCharterDaoException;

    /**
     * 
     * @param criteria
     * @return
     * @throws BusCharterDaoException
     */
    int deleteOrderExpenses(OrderExpenses criteria)
            throws BusCharterDaoException;
}
