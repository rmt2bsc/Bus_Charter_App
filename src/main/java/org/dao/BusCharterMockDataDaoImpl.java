package org.dao;

import java.util.ArrayList;
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

import com.api.persistence.AbstractDaoClientImpl;
import com.util.RMT2Date;

/**
 * Bus Charter mock data implementation of {@link BusCharterDao}
 * 
 * @author rterrell
 *
 */
class BusCharterMockDataDaoImpl extends AbstractDaoClientImpl implements
        BusCharterDao {

    private static final int CLIENT_ID = 200;
    private static final int QUOTE_ID = 300;
    private static final int ORDER_ID = 400;
    private static final int COMPANY_ID = 1000;
    private static final int COMMENT_ID = 2000;
    private static final int STATUS_ID = 100;
    private static final int TENDER_ID = 500;
    private static final int TRAN_ID = 600;
    private static final int MINHOURFACTOR_ID = 223;

    /**
     * 
     */
    BusCharterMockDataDaoImpl() {
        super();
    }

    @Override
    public List<Client> fetchClient(Client criteria)
            throws BusCharterDaoException {
        List<Client> list = new ArrayList<Client>();

        Client c = new Client();
        c.setId(BusCharterMockDataDaoImpl.CLIENT_ID);
        c.setContactFname("Roy");
        c.setContactLname("Terrell");
        c.setContactAddress1("2300 Dana Dr");
        c.setContactZipId(75232);
        c.setContactPhone("9723339394");
        c.setContactFax("2145559999");

        c.setBillingFname("Roy");
        c.setBillingLname("Terrell");
        c.setBillingAddress1("1079 W Round Grove Rd");
        c.setBillingAddress2("Suite 300");
        c.setBillingAddress3("P.O. Box 232");
        c.setBillingZipId(75267);
        c.setBillingPhone("9723339394");
        c.setBillingFax("2145559999");

        c.setEmail("royroy@gte.net");
        c.setWebsite("www.dell.com");
        c.setComments("This is a client comment #1");
        list.add(c);

        // Return only one element when searching for a single client
        if (criteria.getCriteria().get(Client.PROP_ID) != null) {
            return list;
        }

        c = new Client();
        c.setId(BusCharterMockDataDaoImpl.CLIENT_ID + 1);
        c.setContactFname("Dennis");
        c.setContactLname("Chambers");
        c.setContactAddress1("9328 Hall Ave");
        c.setContactZipId(75028);
        c.setContactPhone("2149983747");
        c.setContactFax("2145392838");

        c.setBillingFname("Dennis");
        c.setBillingLname("Chambers");
        c.setBillingAddress1("610 Hoover Rd");
        c.setBillingAddress2("Suite 543");
        c.setBillingAddress3("P.O. Box 123456");
        c.setBillingZipId(75044);
        c.setBillingPhone("9403546782");
        c.setBillingFax("2145559999");

        c.setEmail("rmt2bsc2@verizon.net");
        c.setWebsite("www.rmt2-forty.net");
        c.setComments("This is a client comment #2");
        list.add(c);

        return list;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#fetchQuote(org.dao.mapping.Quote)
     */
    @Override
    public List<Quote> fetchQuote(Quote criteria) throws BusCharterDaoException {
        List<Quote> items = new ArrayList<Quote>();
        Quote q = new Quote();
        q.setId(BusCharterMockDataDaoImpl.QUOTE_ID);
        q.setCharterParty("Charter Party 1");
        q.setClientId(BusCharterMockDataDaoImpl.CLIENT_ID);
        q.setBusCount(1);
        q.setCompanyId(BusCharterMockDataDaoImpl.COMPANY_ID);
        q.setDepartDate(RMT2Date.stringToDate("01/01/2015", "MM/dd/yyyy"));
        q.setDepartDroptime(RMT2Date.stringToDate("01/01/2015 12:10:00",
                "MM/dd/yyyy HH:mm:ss"));
        q.setDepartSpottime(RMT2Date.stringToDate("01/01/2015 13:10:00",
                "MM/dd/yyyy HH:mm:ss"));
        q.setDestination("Baby Dolls");
        q.setGarageDate(RMT2Date.stringToDate("01/01/2015", "MM/dd/yyyy"));
        q.setGarageTime(RMT2Date.stringToDate("01/01/2015 12:10:00",
                "MM/dd/yyyy HH:mm:ss"));
        q.setReturnDate(RMT2Date.stringToDate("01/01/2015", "MM/dd/yyyy"));
        q.setReturnDroptime(RMT2Date.stringToDate("01/01/2015 12:10:00",
                "MM/dd/yyyy HH:mm:ss"));
        q.setReturnSpottime(null);
        q.setHeadCount(100);
        q.setPickupLocation("234 Hanover Dr Dallas, Tx 75028");
        q.setQuotePrice(8432.39);
        q.setSignage("This is the signage");
        q.setInstructions("Bus detail instructions #1");
        q.setStatus(BusCharterMockDataDaoImpl.STATUS_ID);
        items.add(q);

        // Return only one element when searching for a single quote
        if (criteria.getCriteria().get(Quote.PROP_ID) != null) {
            return items;
        }

        q = new Quote();
        q.setId(BusCharterMockDataDaoImpl.QUOTE_ID + 1);
        q.setCharterParty("Charter Party 2");
        q.setClientId(BusCharterMockDataDaoImpl.CLIENT_ID + 1);
        q.setBusCount(1);
        q.setCompanyId(BusCharterMockDataDaoImpl.COMPANY_ID + 1);
        q.setDepartDate(RMT2Date.stringToDate("01/01/2015", "MM/dd/yyyy"));
        q.setDepartDroptime(RMT2Date.stringToDate("12:10", "hh:mm a"));
        q.setDepartSpottime(RMT2Date.stringToDate("13:10", "hh:mm a"));
        q.setDestination("Dallas Gentlemen Club");
        q.setGarageDate(RMT2Date.stringToDate("01/01/2015", "MM/dd/yyyy"));
        q.setGarageTime(RMT2Date.stringToDate("12:10", "hh:mm a"));
        q.setReturnDate(RMT2Date.stringToDate("01/01/2015", "MM/dd/yyyy"));
        q.setReturnDroptime(RMT2Date.stringToDate("12:10", "hh:mm a"));
        q.setReturnSpottime(null);
        q.setHeadCount(100);
        q.setPickupLocation("555 Northwest Hwy Dallas, Tx 75028");
        q.setQuotePrice(8432.39);
        q.setSignage("This is the signage");
        q.setInstructions("Bus detail instructions #2");
        q.setStatus(BusCharterMockDataDaoImpl.STATUS_ID);
        items.add(q);
        return items;
    }

    @Override
    public List<Orders> fetchOrder(Orders criteria)
            throws BusCharterDaoException {
        List<Orders> items = new ArrayList<Orders>();
        Orders o = new Orders();
        o.setId(BusCharterMockDataDaoImpl.ORDER_ID);
        o.setQuoteId(BusCharterMockDataDaoImpl.QUOTE_ID);
        o.setBuscost(1000.00);
        o.setClientOrderId("894038290439");
        o.setDeadheadMilageRate(10.00);
        o.setDeadheadMiles(100);
        o.setDropoffCollect("N/A");
        o.setDropoffCollectTender(BusCharterMockDataDaoImpl.TENDER_ID);
        o.setFlatRate(300.00);
        o.setHourlyRate(25.00);
        o.setHourlyRate2(15.00);
        o.setLiveMiles(80);
        o.setMilageRate(21.00);
        o.setMinHourFactor(BusCharterMockDataDaoImpl.MINHOURFACTOR_ID);
        o.setRequiredDeposit(200.00);
        o.setTotalHours(120);
        items.add(o);

        // Return only one element when searching for a single order
        if (criteria.getCriteria().get(Orders.PROP_ID) != null) {
            return items;
        }

        o = new Orders();
        o.setId(BusCharterMockDataDaoImpl.ORDER_ID + 1);
        o.setQuoteId(BusCharterMockDataDaoImpl.QUOTE_ID + 1);
        o.setBuscost(1000.00);
        o.setClientOrderId("77732837328");
        o.setDeadheadMilageRate(0.00);
        o.setDeadheadMiles(0);
        o.setDropoffCollect("N/A");
        o.setDropoffCollectTender(BusCharterMockDataDaoImpl.TENDER_ID);
        o.setFlatRate(350.00);
        o.setHourlyRate(25.00);
        o.setHourlyRate2(15.00);
        o.setLiveMiles(0);
        o.setMilageRate(0.00);
        o.setMinHourFactor(BusCharterMockDataDaoImpl.MINHOURFACTOR_ID);
        o.setRequiredDeposit(200.00);
        o.setTotalHours(120);
        items.add(o);

        return items;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.dao.BusCharterDao#fetchCharterOrder(org.dao.mapping.VwCharterOrderList
     * )
     */
    @Override
    public List<VwCharterOrderList> fetchCharterOrder(
            VwCharterOrderList criteria) throws BusCharterDaoException {

        List<VwCharterOrderList> items = new ArrayList<VwCharterOrderList>();
        VwCharterOrderList o = new VwCharterOrderList();
        o.setOrderId(BusCharterMockDataDaoImpl.ORDER_ID);
        o.setQuoteId(BusCharterMockDataDaoImpl.QUOTE_ID);
        o.setClientId(BusCharterMockDataDaoImpl.CLIENT_ID);
        o.setStatusId(BusCharterMockDataDaoImpl.STATUS_ID);
        o.setStatus("Invoiced");
        o.setContactFname("Roy");
        o.setContactLname("Terrell");
        o.setContactCompany(BusCharterMockDataDaoImpl.COMPANY_ID);
        o.setContactCompanyName("ABC Industrial Company");
        o.setTransportCompanyId(BusCharterMockDataDaoImpl.COMPANY_ID);
        o.setTransportCompany("ABC Industrial Company");
        o.setClientOrderId("77732837328");
        o.setCharterParty("Charter Party 1");
        o.setDepartDate(RMT2Date.stringToDate("01/01/2015", "MM/dd/yyyy"));
        o.setDestination("Baby Dolls");
        o.setReturnDate(RMT2Date.stringToDate("01/01/2015", "MM/dd/yyyy"));
        o.setSignage("This is the signage");
        o.setBalanceDue(900.00);
        o.setOrderTotal(8432.39);
        o.setExpenses(450.00);
        items.add(o);

        o = new VwCharterOrderList();
        o.setOrderId(BusCharterMockDataDaoImpl.ORDER_ID + 1);
        o.setQuoteId(BusCharterMockDataDaoImpl.QUOTE_ID + 1);
        o.setClientId(BusCharterMockDataDaoImpl.CLIENT_ID + 1);
        o.setStatusId(BusCharterMockDataDaoImpl.STATUS_ID);
        o.setStatus("Invoiced");
        o.setContactFname("Dennis");
        o.setContactLname("Chambers");
        o.setContactCompany(BusCharterMockDataDaoImpl.COMPANY_ID + 1);
        o.setContactCompanyName("XYZ Electrical/Plumbing Company");
        o.setTransportCompanyId(BusCharterMockDataDaoImpl.COMPANY_ID);
        o.setTransportCompany("XYZ Electrical/Plumbing Company");
        o.setClientOrderId("77732837328");
        o.setCharterParty("Charter Party 2");
        o.setDepartDate(RMT2Date.stringToDate("01/01/2015", "MM/dd/yyyy"));
        o.setDestination("Dallas Gentlemen Club");
        o.setReturnDate(RMT2Date.stringToDate("01/01/2015", "MM/dd/yyyy"));
        o.setSignage("This is the signage");
        o.setBalanceDue(200.00);
        o.setOrderTotal(5483.87);
        o.setExpenses(500.00);
        items.add(o);

        return items;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#fetchCompany(org.dao.mapping.Business)
     */
    @Override
    public List<Business> fetchCompany(Business criteria)
            throws BusCharterDaoException {
        List<Business> items = new ArrayList<Business>();

        Business c = new Business();
        c.setId(BusCharterMockDataDaoImpl.COMPANY_ID);
        c.setLongname("ABC Industrial Company");
        items.add(c);

        // Return only one element when searching for a single company
        if (criteria.getCriteria().get(Business.PROP_ID) != null) {
            return items;
        }

        c = new Business();
        c.setId(BusCharterMockDataDaoImpl.COMPANY_ID + 1);
        c.setLongname("XYZ Electrical/Plumbing Company");
        items.add(c);
        return items;
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
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#fetchLookupCode(org.dao.mapping.GeneralCodes)
     */
    @Override
    public List<GeneralCodes> fetchLookupCode(GeneralCodes criteria)
            throws BusCharterDaoException {
        List<GeneralCodes> items = new ArrayList<GeneralCodes>();
        GeneralCodes c = new GeneralCodes();
        c.setCodeId(1);
        c.setGroupId(1);
        c.setLongdesc("Code 1");
        c.setShortdesc("10");
        items.add(c);
        c = new GeneralCodes();
        c.setCodeId(2);
        c.setGroupId(1);
        c.setLongdesc("Code 2");
        c.setShortdesc("10");
        items.add(c);
        return items;
    }

    // /*
    // * (non-Javadoc)
    // *
    // * @see org.dao.BusCharterDao#fetchComment(int)
    // */
    // @Override
    // public Comments fetchComment(int commentId) throws BusCharterDaoException
    // {
    // Comments c = new Comments();
    // c.setCommentId(BusCharterMockDataDaoImpl.COMMENT_ID);
    // c.setCommentText("Brings up a dialog where the number of choices is determined by the optionType parameter, where the messageType parameter determines the icon to display. The messageType parameter is primarily used to supply a default icon from the Look and Feel.");
    // return c;
    // }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#fetchBus(org.dao.mapping.BusDetail)
     */
    @Override
    public List<BusDetail> fetchBus(BusDetail criteria)
            throws BusCharterDaoException {
        List<BusDetail> items = new ArrayList<BusDetail>();
        BusDetail c = new BusDetail();
        c.setId(1);
        c.setOrdersId(BusCharterMockDataDaoImpl.ORDER_ID);
        c.setBusNumber(832);
        c.setDriverName("Roy Terrell");
        items.add(c);
        c = new BusDetail();
        c.setId(2);
        c.setOrdersId(BusCharterMockDataDaoImpl.ORDER_ID);
        c.setBusNumber(776);
        c.setDriverName("Gail Devers");
        items.add(c);
        return items;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#fetchTransaction(org.dao.mapping.Transaction)
     */
    @Override
    public List<Transaction> fetchTransaction(Transaction criteria)
            throws BusCharterDaoException {
        List<Transaction> items = new ArrayList<Transaction>();
        Transaction t = new Transaction();
        t.setId(BusCharterMockDataDaoImpl.TRAN_ID);
        t.setOrderId(BusCharterMockDataDaoImpl.ORDER_ID);
        t.setAmount(120.00);
        t.setCheckNo("2345");
        t.setNotes("Note #1");
        t.setPaymentType(1);
        t.setTransDate(new Date());
        t.setTransTypeId(2);
        items.add(t);

        t = new Transaction();
        t.setId(BusCharterMockDataDaoImpl.TRAN_ID + 1);
        t.setOrderId(BusCharterMockDataDaoImpl.ORDER_ID);
        t.setAmount(120.00);
        t.setCheckNo("93233");
        t.setNotes("Note #21");
        t.setPaymentType(1);
        t.setTransDate(new Date());
        t.setTransTypeId(1);
        items.add(t);

        return items;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#fetchStates(org.dao.mapping.StatesCode)
     */
    @Override
    public List<StatesCode> fetchStates(StatesCode criteria)
            throws BusCharterDaoException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#fetchExpenseType(org.dao.mapping.Expenses)
     */
    @Override
    public List<Expenses> fetchExpenseType(Expenses criteria)
            throws BusCharterDaoException {
        List<Expenses> items = new ArrayList<Expenses>();
        Expenses e = new Expenses();
        e.setId(1);
        e.setDescription("Expense #1");
        e.setActive(1);
        e.setDateCreated(new Date());
        e.setDateUpdated(new Date());
        e.setUserId("test_user1");
        items.add(e);
        e = new Expenses();
        e.setId(2);
        e.setDescription("Expense #2");
        e.setActive(1);
        e.setDateCreated(new Date());
        e.setDateUpdated(new Date());
        e.setUserId("test_user2");
        items.add(e);
        return items;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.dao.BusCharterDao#fetchOrderExpense(org.dao.mapping.OrderExpenses)
     */
    @Override
    public List<OrderExpenses> fetchOrderExpense(OrderExpenses criteria)
            throws BusCharterDaoException {
        List<OrderExpenses> items = new ArrayList<OrderExpenses>();
        OrderExpenses o = new OrderExpenses();
        o.setId(5000);
        o.setOrderId(BusCharterMockDataDaoImpl.ORDER_ID);
        o.setExpenseId(1);
        o.setDescription("Order expense description #1");
        o.setAmount(321.99);
        o.setDateCreated(new Date());
        o.setDateUpdated(new Date());
        o.setUserId("test_user1");
        items.add(o);

        o = new OrderExpenses();
        o.setId(5001);
        o.setOrderId(BusCharterMockDataDaoImpl.ORDER_ID + 1);
        o.setExpenseId(2);
        o.setDescription("Order expense description #2");
        o.setAmount(584.87);
        o.setDateCreated(new Date());
        o.setDateUpdated(new Date());
        o.setUserId("test_user2");
        items.add(o);
        return items;
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
        List<VwInvoiceSummary> items = new ArrayList<VwInvoiceSummary>();
        VwInvoiceSummary i = new VwInvoiceSummary();
        i.setOrderId(BusCharterMockDataDaoImpl.ORDER_ID);
        i.setBusCount(2);
        i.setCategory("Base Trip");
        i.setClientOrderId("8943090439023");
        i.setDescription("This is description #1");
        i.setSeq(1);
        i.setTotalCost(123.99);
        i.setTripCost(11.87);
        items.add(i);

        i = new VwInvoiceSummary();
        i.setOrderId(BusCharterMockDataDaoImpl.ORDER_ID);
        i.setBusCount(2);
        i.setCategory("Adjustment");
        i.setClientOrderId("439023");
        i.setDescription("This is description #2");
        i.setSeq(2);
        i.setTotalCost(-23.44);
        i.setTripCost(-2.34);
        items.add(i);
        return items;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#deleteQuote(org.dao.mapping.Quote)
     */
    @Override
    public int deleteQuote(Quote criteria) throws BusCharterDaoException {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#deleteOrder(org.dao.mapping.Orders)
     */
    @Override
    public int deleteOrder(Orders criteria) throws BusCharterDaoException {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#deleteBusDetail(org.dao.mapping.BusDetail)
     */
    @Override
    public int deleteBusDetail(BusDetail criteria)
            throws BusCharterDaoException {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#deleteTransaction(org.dao.mapping.Transaction)
     */
    @Override
    public int deleteTransaction(Transaction criteria)
            throws BusCharterDaoException {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#deleteExpenses(org.dao.mapping.Expenses)
     */
    @Override
    public int deleteOrderExpenses(OrderExpenses criteria)
            throws BusCharterDaoException {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#fetchZip(org.dao.mapping.Zipcode)
     */
    @Override
    public List<Zipcode> fetchZip(Zipcode criteria)
            throws BusCharterDaoException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#fetchClient(org.dao.mapping.VwClientList)
     */
    @Override
    public List<VwClientList> fetchClient(VwClientList criteria)
            throws BusCharterDaoException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#maintainClient(org.dao.mapping.Client)
     */
    @Override
    public int maintainClient(Client obj) throws BusCharterDaoException {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#deleteClient(org.dao.mapping.Client)
     */
    @Override
    public int deleteClient(Client criteria) throws BusCharterDaoException {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#maintainQuote(org.dao.mapping.Quote)
     */
    @Override
    public int maintainQuote(Quote obj) throws BusCharterDaoException {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#maintainOrder(org.dao.mapping.Orders)
     */
    @Override
    public int maintainOrder(Orders obj) throws BusCharterDaoException {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.dao.BusCharterDao#maintainOrderBuses(java.util.List)
     */
    @Override
    public int maintainOrderBuses(List<BusDetail> obj)
            throws BusCharterDaoException {
        // TODO Auto-generated method stub
        return 0;
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
        // TODO Auto-generated method stub
        return 0;
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
        // TODO Auto-generated method stub
        return 0;
    }

}
