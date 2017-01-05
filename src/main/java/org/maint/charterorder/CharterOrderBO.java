package org.maint.charterorder;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dao.BusCharterDao;
import org.dao.BusCharterDaoFactory;
import org.dao.mapping.BusDetail;
import org.dao.mapping.Expenses;
import org.dao.mapping.GeneralCodes;
import org.dao.mapping.GeneralCodesGroup;
import org.dao.mapping.OrderExpenses;
import org.dao.mapping.Orders;
import org.dao.mapping.Quote;
import org.dao.mapping.StatesCode;
import org.dao.mapping.Transaction;
import org.dao.mapping.VwCharterOrderList;
import org.dao.mapping.VwInvoiceSummary;
import org.dao.mapping.Zipcode;

import com.api.config.AppPropertyPool;
import com.nv.dao.SwingDaoTransaction;
import com.util.RMT2Date;
import com.util.RMT2Money;

/**
 * The business object containing domain and data access logic for managing
 * charter order related models.
 * 
 * @author rterrell
 *
 */
public class CharterOrderBO extends SwingDaoTransaction {

    private BusCharterDao dao;

    private Set<Integer> noDeleteStatusesSet;

    /**
     * Default constructor
     */
    public CharterOrderBO() {
        super();
        this.dao = BusCharterDaoFactory.createDao(null);
        this.setBaseDao(this.dao);
        String keys = AppPropertyPool
                .getProperty(CharterOrderConst.NO_DELETE_ORDER_STATUS_KEY);
        String keyArray[] = keys.split(",");
        this.noDeleteStatusesSet = new HashSet<Integer>();
        for (int ndx = 0; ndx < keyArray.length; ndx++) {
            if (RMT2Money.isNumeric(keyArray[ndx])) {
                this.noDeleteStatusesSet.add(new Integer(keyArray[ndx]));
            }
        }
        return;
    }

    /**
     * Performs a charter order search using selection criteria contained in a
     * CharterOrderSearchCriteriaBean object.
     * 
     * @param selectionCriteria
     *            data used to filter charter order query
     * @return a List of {@link VwCharterOrderList} objects or null if no data
     *         is found.
     */
    public List<VwCharterOrderList> getCharterOrderInfo(
            CharterOrderSearchCriteriaBean selectionCriteria) {
        VwCharterOrderList criteria;
        if (selectionCriteria == null) {
            throw new CharterOrderBOException(
                    "Unable to perform charter order search due to an invalid or null charter order search criteria bean as input");
        }
        else {
            criteria = new VwCharterOrderList();
        }
        Number numVal = 0;

        // Client section
        if (selectionCriteria.getClientId() != null) {
            if (RMT2Money.isNumeric(selectionCriteria.getClientId())) {
                numVal = RMT2Money.stringToNumber(selectionCriteria
                        .getClientId());
                criteria.addCriteria(VwCharterOrderList.PROP_CLIENTID,
                        numVal.intValue());
            }
        }
        if (selectionCriteria.getFirstName() != null) {
            criteria.addLikeClause(VwCharterOrderList.PROP_CONTACTFNAME,
                    selectionCriteria.getFirstName());
        }
        if (selectionCriteria.getLastName() != null) {
            criteria.addLikeClause(VwCharterOrderList.PROP_CONTACTLNAME,
                    selectionCriteria.getLastName());
        }
        if (selectionCriteria.getCompany() != null) {
            if (RMT2Money.isNumeric(selectionCriteria.getCompany())) {
                numVal = RMT2Money.stringToNumber(selectionCriteria
                        .getCompany());
                criteria.addCriteria(VwCharterOrderList.PROP_CONTACTCOMPANY,
                        numVal.intValue());
            }
        }

        // Trip Section
        if (selectionCriteria.getTripId() != null) {
            if (RMT2Money.isNumeric(selectionCriteria.getTripId())) {
                numVal = RMT2Money
                        .stringToNumber(selectionCriteria.getTripId());
                criteria.addCriteria(VwCharterOrderList.PROP_QUOTEID,
                        numVal.intValue());
            }
        }
        if (selectionCriteria.getTransComp() != null) {
            if (RMT2Money.isNumeric(selectionCriteria.getTransComp())) {
                numVal = RMT2Money.stringToNumber(selectionCriteria
                        .getTransComp());
                criteria.addCriteria(
                        VwCharterOrderList.PROP_TRANSPORTCOMPANYID,
                        numVal.intValue());
            }
        }
        if (selectionCriteria.getCharterParty() != null) {
            criteria.addLikeClause(VwCharterOrderList.PROP_CHARTERPARTY,
                    selectionCriteria.getCharterParty());
        }
        if (selectionCriteria.getSignage() != null) {
            criteria.addLikeClause(VwCharterOrderList.PROP_SIGNAGE,
                    selectionCriteria.getSignage());
        }

        Date dtVal = null;
        if (selectionCriteria.getDepartDate() != null) {
            dtVal = RMT2Date.stringToDate(selectionCriteria.getDepartDate());
            criteria.addCriteria(VwCharterOrderList.PROP_DEPARTDATE, dtVal);
        }
        if (selectionCriteria.getReturnDate() != null) {
            dtVal = RMT2Date.stringToDate(selectionCriteria.getReturnDate());
            criteria.addCriteria(VwCharterOrderList.PROP_RETURNDATE, dtVal);
        }

        // Order section
        if (selectionCriteria.getOrderId() != null) {
            if (RMT2Money.isNumeric(selectionCriteria.getOrderId())) {
                numVal = RMT2Money.stringToNumber(selectionCriteria
                        .getOrderId());
                criteria.addCriteria(VwCharterOrderList.PROP_ORDERID,
                        numVal.intValue());
            }
        }
        if (selectionCriteria.getOrderStatus() != null) {
            if (RMT2Money.isNumeric(selectionCriteria.getOrderStatus())) {
                numVal = RMT2Money.stringToNumber(selectionCriteria
                        .getOrderStatus());
                criteria.addCriteria(VwCharterOrderList.PROP_STATUSID,
                        numVal.intValue());
            }
        }
        if (selectionCriteria.getClientOrderId() != null) {
            criteria.addLikeClause(VwCharterOrderList.PROP_CLIENTORDERID,
                    selectionCriteria.getClientOrderId());
        }

        criteria.addOrderBy(VwCharterOrderList.PROP_ORDERID,
                VwCharterOrderList.ORDERBY_DESCENDING);

        // Fetch data based on selection criteria
        List<VwCharterOrderList> items = this.dao.fetchCharterOrder(criteria);
        return items;
    }

    /**
     * Get an individual quote entity based on its unique id.
     * 
     * @param quoteId
     *            the id of the quote
     * @return {@link Quote}
     */
    public Quote getTripInfo(int quoteId) {
        Quote criteria = new Quote();
        criteria.addCriteria(Quote.PROP_ID, quoteId);
        List<Quote> results = this.dao.fetchQuote(criteria);
        if (results == null || results.size() == 0) {
            return null;
        }
        if (results.size() > 1) {
            throw new CharterOrderBOException(
                    "Quote query returned too many rows.  Should be just 1 one returned");
        }
        return results.get(0);
    }

    /**
     * Get an individual order entity based on its unique id.
     * 
     * @param orderId
     *            the id of the order
     * @return {@link Orders}
     */
    public Orders getOrderInfo(int orderId) {
        Orders criteria = new Orders();
        criteria.addCriteria(Orders.PROP_ID, orderId);
        List<Orders> results = this.dao.fetchOrder(criteria);
        if (results == null || results.size() == 0) {
            return null;
        }
        if (results.size() > 1) {
            throw new CharterOrderBOException(
                    "Orders query returned too many rows.  Should be just 1 one returned");
        }
        return results.get(0);
    }

    /**
     * Gets a list of buses belonging to a particular order.
     * 
     * @return List of {@link BusDetail} objects
     */
    public List<BusDetail> getOrderBusInfo(int orderId) {
        BusDetail criteria = new BusDetail();
        criteria.addCriteria(BusDetail.PROP_ORDERSID, orderId);
        List<BusDetail> results = this.dao.fetchBus(criteria);
        return results;
    }

    // /**
    // * Gets a list of all company entities.
    // *
    // * @return List of {@link CompanyInfo} objects
    // */
    // public List<Business> getCompanyInfo() {
    // Business criteria = new Business();
    // criteria.addOrderBy(Business.PROP_LONGNAME, Business.ORDERBY_ASCENDING);
    // try {
    // List<Business> results = this.dao.fetchCompany(criteria);
    // return results;
    // } catch (Exception e) {
    // throw new CharterOrderBOException(e);
    // }
    // }

    // /**
    // * Gets a list of all company entities based on business type.
    // *
    // * @param businessTypeId
    // * the id of the business type
    // * @return List of {@link CompanyInfo} objects
    // */
    // public List<Business> getCompanyInfoByBusinessType(int businessTypeId) {
    // Business criteria = new Business();
    // criteria.addCriteria(Business.PROP_BUSINESSTYPE, businessTypeId);
    // criteria.addOrderBy(Business.PROP_LONGNAME, Business.ORDERBY_ASCENDING);
    // try {
    // List<Business> results = this.dao.fetchCompany(criteria);
    // return results;
    // } catch (Exception e) {
    // throw new CharterOrderBOException(e);
    // }
    // }

    // public List<Business> getCompanyInfoByBusinessType(
    // List<Integer> businessTypeId) {
    // Business criteria = new Business();
    // Integer a[] = new Integer[businessTypeId.size()];
    // a = businessTypeId.toArray(a);
    // criteria.addInClause(Business.PROP_BUSINESSTYPE, a);
    // criteria.addOrderBy(Business.PROP_LONGNAME, Business.ORDERBY_ASCENDING);
    // try {
    // List<Business> results = this.dao.fetchCompany(criteria);
    // return results;
    // } catch (Exception e) {
    // throw new CharterOrderBOException(e);
    // }
    //
    // }

    // /**
    // * Get an individual company entity based on its unique id.
    // *
    // * @param companyId
    // * the id of the company
    // * @return {@link CompanyInfo}
    // */
    // public Business getCompanyInfo(int companyId) {
    // Business criteria = new Business();
    // criteria.addCriteria(Business.PROP_ID, companyId);
    // List<Business> results = this.dao.fetchCompany(criteria);
    // if (results == null || results.size() == 0) {
    // return null;
    // }
    // if (results.size() > 1) {
    // throw new CharterOrderBOException(
    // "CompanyInfo query returned too many rows.  Should be just 1 one returned");
    // }
    // return results.get(0);
    // }

    // /**
    // * Get an individual client entity based on its unique id.
    // *
    // * @param clientId
    // * the id of the client
    // * @return {@link CompanyInfo}
    // */
    // public Client getClientInfo(int clientId) {
    // Client criteria = new Client();
    // criteria.addCriteria(Client.PROP_ID, clientId);
    // List<Client> results = this.dao.fetchClient(criteria);
    // if (results == null || results.size() == 0) {
    // return null;
    // }
    // if (results.size() > 1) {
    // throw new CharterOrderBOException(
    // "Client query returned too many rows.  Should be just 1 one returned");
    // }
    // return results.get(0);
    // }

    // /**
    // * Get an individual client entity based on its unique id.
    // *
    // * @param clientId
    // * the id of the client
    // * @return {@link CompanyInfo}
    // */
    // public VwClientList getClientInfoExt(int clientId) {
    // VwClientList criteria = new VwClientList();
    // criteria.addCriteria(VwClientList.PROP_CLIENTID, clientId);
    // List<VwClientList> results = this.dao.fetchClient(criteria);
    // if (results == null || results.size() == 0) {
    // return null;
    // }
    // if (results.size() > 1) {
    // throw new CharterOrderBOException(
    // "Extended Client query returned too many rows.  Should be just 1 one returned for client id, "
    // + clientId);
    // }
    // return results.get(0);
    // }

    public List<GeneralCodesGroup> getLookupCodeGroup() {
        GeneralCodesGroup criteria = new GeneralCodesGroup();
        criteria.addOrderBy(GeneralCodesGroup.PROP_DESCRIPTION,
                GeneralCodes.ORDERBY_ASCENDING);
        return this.dao.fetchLookupCodeGroup(criteria);
    }

    public GeneralCodesGroup getLookupCodeGroup(int groupId) {
        GeneralCodesGroup criteria = new GeneralCodesGroup();
        criteria.addCriteria(GeneralCodesGroup.PROP_GROUPID, groupId);
        List<GeneralCodesGroup> results = this.dao
                .fetchLookupCodeGroup(criteria);
        if (results == null || results.size() == 0) {
            return null;
        }
        if (results.size() > 1) {
            throw new CharterOrderBOException(
                    "Lookup Code Group query returned too many rows.  Should be just 1 one returned");
        }
        return results.get(0);
    }

    public List<GeneralCodes> getLookupCodeByGroup(int groupId) {
        GeneralCodes criteria = new GeneralCodes();
        criteria.addCriteria(GeneralCodes.PROP_GROUPID, groupId);
        criteria.addOrderBy(GeneralCodes.PROP_LONGDESC,
                GeneralCodes.ORDERBY_ASCENDING);
        return this.dao.fetchLookupCode(criteria);
    }

    public GeneralCodes getLookupCode(int codeId) {
        GeneralCodes criteria = new GeneralCodes();
        criteria.addCriteria(GeneralCodes.PROP_CODEID, codeId);
        List<GeneralCodes> results = this.dao.fetchLookupCode(criteria);
        if (results == null || results.size() == 0) {
            return null;
        }
        if (results.size() > 1) {
            throw new CharterOrderBOException(
                    "General lookup code query returned too many rows.  Should be just 1 one returned");
        }
        return results.get(0);
    }

    public List<Transaction> getTransactions(int orderId) {
        Transaction criteria = new Transaction();
        criteria.addCriteria(Transaction.PROP_ORDERID, orderId);
        criteria.addOrderBy(Transaction.PROP_TRANSDATE,
                Transaction.ORDERBY_DESCENDING);
        return this.dao.fetchTransaction(criteria);
    }

    public List<StatesCode> getUsStates() {
        StatesCode criteria = new StatesCode();
        criteria.addCriteria(StatesCode.PROP_COUNTRYID, 17);
        criteria.addOrderBy(StatesCode.PROP_LONGNAME,
                StatesCode.ORDERBY_ASCENDING);
        return this.dao.fetchStates(criteria);
    }

    public List<Expenses> getExpenseType() {
        Expenses criteria = new Expenses();
        criteria.addOrderBy(Expenses.PROP_DESCRIPTION,
                StatesCode.ORDERBY_ASCENDING);
        return this.dao.fetchExpenseType(criteria);
    }

    public List<OrderExpenses> getOrderExpense(int orderId) {
        OrderExpenses criteria = new OrderExpenses();
        criteria.addCriteria(OrderExpenses.PROP_ORDERID, orderId);
        criteria.addOrderBy(OrderExpenses.PROP_DATECREATED,
                StatesCode.ORDERBY_DESCENDING);
        return this.dao.fetchOrderExpense(criteria);
    }

    public List<VwInvoiceSummary> getInvoiceSummary(int orderId) {
        VwInvoiceSummary criteria = new VwInvoiceSummary();
        criteria.addCriteria(VwInvoiceSummary.PROP_ORDERID, orderId);
        criteria.addOrderBy(VwInvoiceSummary.PROP_ORDERID,
                StatesCode.ORDERBY_ASCENDING);
        criteria.addOrderBy(VwInvoiceSummary.PROP_SEQ,
                StatesCode.ORDERBY_ASCENDING);
        criteria.addOrderBy(VwInvoiceSummary.PROP_CATEGORY,
                StatesCode.ORDERBY_ASCENDING);
        return this.dao.fetchInvoiceSummary(criteria);
    }

    public Zipcode getZip(int zipId) {
        Zipcode criteria = new Zipcode();
        criteria.addCriteria(Zipcode.PROP_ZIPID, zipId);
        List<Zipcode> results = this.dao.fetchZip(criteria);
        if (results == null) {
            return null;
        }
        return results.get(0);
    }

    public List<Zipcode> getZipByZipcode(int zipCode) {
        Zipcode criteria = new Zipcode();
        criteria.addCriteria(Zipcode.PROP_ZIP, zipCode);
        List<Zipcode> results = this.dao.fetchZip(criteria);
        if (results == null) {
            return null;
        }
        return results;
    }

    public int updateQuote(Quote src) {
        this.validateQuote(src);

        try {
            int rc = this.dao.maintainQuote(src);
//            this.dao.commitTrans();
            return rc;
        } catch (Exception e) {
//            this.dao.rollbackTrans();
            throw new CharterOrderBOException(e);
        }
    }

    public void validateQuote(Quote quote) {
        if (quote == null) {
            throw new CharterOrderBOValidationException(
                    "Quote object is invalid");
        }
        if (quote.getCompanyId() <= 0) {
            throw new CharterOrderBOValidationException(
                    "Quote Transport company is required");
        }
        if (quote.getDepartDate() == null) {
            throw new CharterOrderBOValidationException(
                    "Quote Depart date is required");
        }
        if (quote.getDepartSpottime() == null) {
            throw new CharterOrderBOValidationException(
                    "Quote Depart spot time is required");
        }
        if (quote.getReturnDate() == null) {
            throw new CharterOrderBOValidationException(
                    "Quote Return date is required");
        }
        if (quote.getReturnDroptime() == null) {
            throw new CharterOrderBOValidationException(
                    "Quote Return drop time is required");
        }
        if (quote.getPickupLocation() == null) {
            throw new CharterOrderBOValidationException(
                    "Quote Pickup location is required");
        }
        if (quote.getDestination() == null) {
            throw new CharterOrderBOValidationException(
                    "Quote Destination is required");
        }
        if (quote.getInstructions() == null) {
            throw new CharterOrderBOValidationException(
                    "Quote Special instructions information is required");
        }
        return;
    }

    public int updateOrder(Orders order, List<BusDetail> buses) {
        this.validateOrder(order);

        try {
            // persist order changes
            int rc = this.dao.maintainOrder(order);
            // Ensure that each bus is associated with the order
            for (BusDetail bus : buses) {
                bus.setOrdersId(order.getId());
            }
            // persist bus changes
            this.dao.maintainOrderBuses(buses);
            return rc;
        } catch (Exception e) {
            throw new CharterOrderBOException(e);
        }
    }

    public int updateTransaction(List<Transaction> list) {
        int count = 0;
        try {
            for (Transaction item : list) {
                this.updateTransaction(item);
                count++;
            }
            return count;
        } catch (Exception e) {
            throw new CharterOrderBOException(e);
        }
    }

    public int updateTransaction(Transaction tran) {
        // Ensure that each bus is associated with the order
        this.validateTransaction(tran);
        try {
            // persist transaction changes
            int rc = this.dao.maintainTransaction(tran);
            return rc;
        } catch (Exception e) {
            throw new CharterOrderBOException(e);
        }
    }

    public int deleteTransaction(List<Transaction> list) {
        if (list == null) {
            return 0;
        }
        int rc = 0;
        try {
            for (Transaction tran : list) {
                tran.addCriteria(Transaction.PROP_ID, tran.getId());
                this.dao.deleteTransaction(tran);
                rc++;
            }
            return rc;
        } catch (Exception e) {
            throw new CharterOrderBOException(e);
        }
    }

    public void validateTransaction(Transaction tran) {
        if (tran == null) {
            throw new CharterOrderBOException("Transaction object is invalid");
        }
        if (tran.getOrderId() == 0) {
            throw new CharterOrderBOException(
                    "Transaction object requires the assoication of an order");
        }
        if (tran.getTransDate() == null) {
            throw new CharterOrderBOException(
                    "Transaction object requires a transaction date");
        }
        if (tran.getTransTypeId() == 0) {
            throw new CharterOrderBOException(
                    "Transaction object requires a transaction type");
        }
        if (tran.getPaymentType() == 0) {
            throw new CharterOrderBOException(
                    "Transaction object requires a payment tender");
        }
    }

    public int updateOrderExpense(List<OrderExpenses> list) {
        int count = 0;
        try {
            for (OrderExpenses item : list) {
                this.updateOrderExpense(item);
                count++;
            }
            return count;
        } catch (Exception e) {
            throw new CharterOrderBOException(e);
        }
    }

    public int updateOrderExpense(OrderExpenses exp) {
        // Ensure that each bus is associated with the order
        this.validateOrderExpense(exp);
        try {
            // persist order expense changes
            int rc = this.dao.maintainOrderExpense(exp);
            return rc;
        } catch (Exception e) {
            throw new CharterOrderBOException(e);
        }
    }

    public void validateOrderExpense(OrderExpenses exp) {
        if (exp == null) {
            throw new CharterOrderBOException("Order expense object is invalid");
        }
        if (exp.getOrderId() == 0) {
            throw new CharterOrderBOException(
                    "Order expense object requires the assoication of an order");
        }
        if (exp.getExpenseId() == 0) {
            throw new CharterOrderBOException(
                    "Order expense object requires the association of an expense id");
        }
        if (exp.getDescription() == null) {
            throw new CharterOrderBOException(
                    "Order expense object requires a description");
        }
    }

    public int deleteOrderExpense(List<OrderExpenses> list) {
        if (list == null) {
            return 0;
        }
        int rc = 0;
        try {
            for (OrderExpenses exp : list) {
                exp.addCriteria(OrderExpenses.PROP_ID, exp.getId());
                this.dao.deleteOrderExpenses(exp);
                rc++;
            }
            return rc;
        } catch (Exception e) {
            throw new CharterOrderBOException(e);
        }
    }

    public int deleteOrderBuses(List<BusDetail> buses) {
        if (buses == null) {
            return 0;
        }
        int rc = 0;
        try {
            for (BusDetail bus : buses) {
                bus.addCriteria(BusDetail.PROP_ID, bus.getId());
                this.dao.deleteBusDetail(bus);
                rc++;
            }
            return rc;
        } catch (Exception e) {
            throw new CharterOrderBOException(e);
        }
    }

    public void validateOrder(Orders order) {
        if (order == null) {
            throw new CharterOrderBOValidationException(
                    "Order object is invalid");
        }
        if (order.getQuoteId() == 0) {
            throw new CharterOrderBOValidationException(
                    "Quote id is required to be associated with the order");
        }
        return;
    }

    /**
     * Delete a charter order and/or quote from the database.
     * <p>
     * If a quote has a charter order associated with it, then all expenses,
     * transactions, bus detial, and the actual charter order is deleted prior
     * to removing the quote fromt he database.
     * 
     * @param quoteId
     *            the quote or trip id.
     * @return the total number of rows effected by the delete transaction.
     */
    public int deleteCharterOrder(int quoteId) {
        if (this.noDeleteStatusesSet == null
                || this.noDeleteStatusesSet.isEmpty()) {
            throw new CharterOrderBOException(
                    "Unable to obtain list of no-delete charter order statuses from application configuration");
        }
        if (quoteId <= 0) {
            throw new CharterOrderBOException(
                    "The Trip ID cannot be null when attempting to delete a Charter Order/Quote");
        }

        // Validate quote
        Quote quoteCriteria = new Quote();
        quoteCriteria.addCriteria(Quote.PROP_ID, quoteId);
        List<Quote> quotes = this.dao.fetchQuote(quoteCriteria);
        if (quotes == null) {
            throw new CharterOrderBOException(
                    "Delete did not occur due to quote was not found in the system ["
                            + quoteId + "]");
        }
        // Can we delete this quote?
        if (this.noDeleteStatusesSet.contains(quotes.get(0).getStatus())) {
            throw new CharterOrderBOException(
                    "Delete failed due to the status of target quote, "
                            + quoteId
                            + ", prevents the quote from being deleted");
        }

        // Check to see if an order exist for this quote
        Orders orderCriteria = new Orders();
        orderCriteria.addCriteria(Orders.PROP_QUOTEID, quoteId);
        List<Orders> orders = this.dao.fetchOrder(orderCriteria);
        boolean orderExist = (orders != null && orders.size() > 0);

        int rows = 0;
        this.dao.beginTrans();
        try {
            if (orderExist) {
                // Delete any charter orders associated with the quote
                OrderExpenses expCriteria = new OrderExpenses();
                Transaction transCriteria = new Transaction();
                BusDetail busCriteria = new BusDetail();
                orderCriteria = new Orders();
                for (Orders item : orders) {
                    expCriteria.addCriteria(OrderExpenses.PROP_ORDERID,
                            item.getId());
                    transCriteria.addCriteria(Transaction.PROP_ORDERID,
                            item.getId());
                    busCriteria.addCriteria(BusDetail.PROP_ORDERSID,
                            item.getId());
                    orderCriteria.addCriteria(Orders.PROP_ID, item.getId());
                    rows += this.dao.deleteOrderExpenses(expCriteria);
                    rows += this.dao.deleteTransaction(transCriteria);
                    rows += this.dao.deleteBusDetail(busCriteria);
                    rows += this.dao.deleteOrder(orderCriteria);
                }
            }

            // Delete quote
            rows += this.dao.deleteQuote(quoteCriteria);
            this.dao.commitTrans();
            return rows;
        } catch (Exception e) {
            this.dao.rollbackTrans();
            throw new CharterOrderBOException("Delete of quote, " + quoteId
                    + ", failed", e);
        }
    }

    /**
     * Performs caluclations for an entire order which includes the hourly sub
     * total, milage sub total, and bus flat rate.
     * 
     * @param order
     * @param quote
     * @return the total charges for the bus.
     */
    public double calculateOrderCharge(Orders order, Quote quote) {
        double busCost = order.getBuscost();
        int busCount = quote.getBusCount();
        double flatRate = order.getFlatRate();
        double mileSubTotal = this.calculateOrderMileageCharge(order);
        double hourlySubTotal = this.calculateOrderHourlyCharge(order);
        double tripTotal = ((flatRate + mileSubTotal + hourlySubTotal) * busCount)
                + busCost;
        return tripTotal;
    }

    /**
     * Calculates the live and dead mile charges for an entire order.
     * 
     * @param order
     * @return the mileage subtotal.
     */
    public double calculateOrderMileageCharge(Orders order) {
        double mileSubTotal = (order.getLiveMiles() * order.getMilageRate())
                + (order.getDeadheadMiles() * order.getDeadheadMilageRate());
        return mileSubTotal;
    }

    /**
     * Calculates the hourly charges for an entire order.
     * 
     * @param order
     * @return the hourly subtotal
     */
    public double calculateOrderHourlyCharge(Orders order) {
        GeneralCodes criteria = new GeneralCodes();
        criteria.addCriteria(GeneralCodes.PROP_CODEID, order.getMinHourFactor());
        List<GeneralCodes> code = this.dao.fetchLookupCode(criteria);
        if (code == null) {
            return 0;
        }
        double minHourlFactor = Integer.parseInt(code.get(0).getShortdesc());

        double hourlyRate = order.getHourlyRate();
        double hourlyRateExt = order.getHourlyRate2();
        int totalHours = order.getTotalHours();
        double hourlySubTotal = (hourlyRate * (totalHours > minHourlFactor ? minHourlFactor
                : totalHours))
                + hourlyRateExt
                * (totalHours > minHourlFactor ? totalHours - minHourlFactor
                        : 0);
        return hourlySubTotal;
    }

    /**
     * Performs caluclations for an indicvidual bus which includes the hourly
     * sub total, milage sub total, and bus flat rate.
     * 
     * @param bus
     * @return the total charges for the bus.
     */
    public double calculateBusCharge(BusDetail bus) {
        double flatRate = bus.getFlatRate();
        double mileSubTotal = this.calculateBusMileageCharge(bus);
        double hourlySubTotal = this.calculateBusHourlyCharge(bus);
        double busTotal = (flatRate + mileSubTotal + hourlySubTotal);
        return busTotal;
    }

    /**
     * Calculates the live and dead mile charges for an individual bus.
     * 
     * @param bus
     * @return the mileage subtotal.
     */
    public double calculateBusMileageCharge(BusDetail bus) {
        double mileSubTotal = (bus.getLiveMiles() * bus.getMilageRate())
                + (bus.getDeadheadMiles() * bus.getDeadheadMilageRate());
        return mileSubTotal;
    }

    /**
     * Calculates the hourly charges for an individual bus.
     * 
     * @param bus
     * @return the hourly subtotal
     */
    public double calculateBusHourlyCharge(BusDetail bus) {
        GeneralCodes criteria = new GeneralCodes();
        criteria.addCriteria(GeneralCodes.PROP_CODEID, bus.getMinHourFactor());
        List<GeneralCodes> code = this.dao.fetchLookupCode(criteria);
        if (code == null) {
            return 0;
        }
        double minHourlFactor = Integer.parseInt(code.get(0).getShortdesc());

        double hourlyRate = bus.getHourlyRate();
        double hourlyRateExt = bus.getHourlyRate2();
        int totalHours = bus.getTotalHours();
        double hourlySubTotal = (hourlyRate * (totalHours > minHourlFactor ? minHourlFactor
                : totalHours))
                + hourlyRateExt
                * (totalHours > minHourlFactor ? totalHours - minHourlFactor
                        : 0);
        return hourlySubTotal;
    }
}
