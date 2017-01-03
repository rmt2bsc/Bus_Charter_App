package org.maint.charterorder;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

import org.FormUtil;
import org.apache.log4j.Logger;

import com.InvalidGuiDataException;
import com.ProcessDataFailureException;
import com.ui.components.AbstractGuiComponentTemplate;
import com.ui.window.AbstractSdiModalWindow;
import com.ui.window.WindowActionListener;
import com.util.RMT2Money;
import com.util.RMT2SwingUtil;

/**
 * @author rterrell
 *
 */
public class CharterOrderMaintDialog extends AbstractSdiModalWindow implements
        TotalCostChangedListener, NewOrderCreatedListener {

    private static final long serialVersionUID = 1746311868533836L;

    private static final Logger logger = Logger
            .getLogger(CharterOrderMaintDialog.class);

    /**
     * The action command to create charter order.
     */
    public static final String ACTION_COMMAND_CREATEORDER = "CREATE_ORDER";

    public static final String ACTION_COMMAND_GEN_INVOICE = "GENERATE_INVOICE";

    public static final String TAB_NAME_CLIENT = "Client";

    public static final String TAB_NAME_TRIP = "Trip";

    public static final String TAB_NAME_FINANCIALS = "Financials";

    public static final String TAB_NAME_TRANSACTIONS = "Transactions";

    public static final String TAB_NAME_EXPENSES = "Expenses";

    public static final String TAB_NAME_SUMMARY = "Invoice Summary";

    // private SaveChangesThread worker;

    private JTabbedPane tp;

    /**
     * The Save Command button
     */
    private JButton saveButton;

    private JButton createOrderButton;

    private JButton butGenInvoice;

    private JTextField txtBalanceField;

    private JLabel lblOrderId;

    private JLabel lblMessage;

    private CharterOrderMaintParmsBean parms;

    /**
     * Default constructor
     */
    protected CharterOrderMaintDialog() {
        return;
    }

    /**
     * Creates a CharterOrderMaintDialog initialized with data to populate all
     * tabs.
     * 
     * @param owner
     *            an instance of Frame
     * @param data
     *            an arbitrary object representing the data that is to displayed
     *            and maniupulated by all tab components of the dialog.
     * @param size
     *            the window's dimensions in terms of size and position
     * @param pos
     *            the location where the window is to be positioned.
     * @param winTitle
     *            a String to append to the title of the window.
     */
    public CharterOrderMaintDialog(String winTitle, Object data,
            Dimension size, Point pos) {
        super((Dialog) null, data, size, pos, winTitle);

        return;
    }

    @Override
    protected void initDialog() {
        // Create and cast <data> as a member variable.
        if (this.inData == null) {
            this.parms = new CharterOrderMaintParmsBean();
            this.parms.setNewOrder(true);
        }
        else {
            if (this.inData instanceof CharterOrderMaintParmsBean) {
                this.parms = (CharterOrderMaintParmsBean) this.inData;
                this.parms.setNewOrder(this.parms.getOrderId() <= 0);
            }
        }

        super.initDialog();

        this.okButton
                .setActionCommand(WindowActionListener.ACTION_COMMAND_PROCESS_CLOSE);
        // Create additional command buttons starting at position #1
        saveButton = new JButton("Save");
        saveButton.setActionCommand(WindowActionListener.ACTION_COMMAND_SAVE);
        // saveButton.setEnabled(false);
        saveButton.addActionListener(this);

        this.createOrderButton = new JButton("Create Order");
        this.createOrderButton
                .setActionCommand(CharterOrderMaintDialog.ACTION_COMMAND_CREATEORDER);
        this.createOrderButton.addActionListener(this);

        this.butGenInvoice = new JButton("Generate Invoice");
        this.butGenInvoice.addActionListener(this);
        this.butGenInvoice
                .setActionCommand(CharterOrderMaintDialog.ACTION_COMMAND_GEN_INVOICE);

        buttonPane.add(this.createOrderButton, 1);
        buttonPane.add(this.butGenInvoice, 2);
        buttonPane.add(saveButton, 3);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ui.window.WindowActionListener#createContentLayout()
     */
    @Override
    public JPanel createContentLayout() {

        // Use the MigLayout to setup criteria section
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new MigLayout("", "[][grow]50[][grow]", "[]"));

        JLabel lblTitle = new JLabel(this.winTitle + " -  Order: ");
        Font font = new Font(Font.SERIF, Font.BOLD, 20);
        lblTitle.setFont(font);
        lblTitle.setForeground(Color.BLUE);
        titlePanel.add(lblTitle);

        this.lblOrderId = new JLabel(
                this.parms.getOrderId() > 0 ? String.valueOf(this.parms
                        .getOrderId()) : "");
        this.lblOrderId.setFont(font);
        this.lblOrderId.setForeground(Color.BLUE);
        titlePanel.add(this.lblOrderId);

        JLabel lblBal = new JLabel("Balance Due: ");
        font = new Font(Font.SERIF, Font.BOLD, 20);
        lblBal.setFont(font);
        lblBal.setForeground(Color.BLUE);
        titlePanel.add(lblBal);

        txtBalanceField = new JTextField();
        font = new Font(Font.SERIF, Font.BOLD, 20);
        txtBalanceField.setForeground(Color.RED);
        txtBalanceField.setBackground(Color.WHITE);
        txtBalanceField.setFont(font);
        txtBalanceField.setText("0.00");
        txtBalanceField.setSize(new Dimension(180, 40));
        txtBalanceField.setEditable(false);
        txtBalanceField.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(txtBalanceField, "growx");

        JPanel tabPanel = this.createTabs();

        // Retrieve data for all tabs on a separate thread.
        RetrieveDataThread t = new RetrieveDataThread(this.tp, this.parms);
        Thread thread = new Thread(t);
        thread.start();

        this.lblMessage = new JLabel();

        // Setup the main panel with criteria and results sections
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new MigLayout("", "[grow]", "[]"));
        mainPanel.add(titlePanel, "dock north, wrap");
        mainPanel.add(this.lblMessage, "dock south");
        mainPanel.add(tabPanel, "dock center, w 500");

        return mainPanel;
    }

    private JPanel createTabs() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 1));
        tp = new JTabbedPane(JTabbedPane.TOP);

        // Add tab components
        ImageIcon icon = RMT2SwingUtil.createImageIcon("/images/Icon0130.gif");
        tp.insertTab(CharterOrderMaintDialog.TAB_NAME_CLIENT, icon,
                this.createClientComponent(),
                "Manages Client information for Charter Order", 0);
        icon = RMT2SwingUtil.createImageIcon("/images/Icon1113.gif");
        tp.insertTab(CharterOrderMaintDialog.TAB_NAME_TRIP, icon,
                this.createTripComponent(),
                "Manages Trip information for Charter Order", 1);
        icon = RMT2SwingUtil.createImageIcon("/images/Icon2504.gif");
        tp.insertTab(CharterOrderMaintDialog.TAB_NAME_FINANCIALS, icon,
                this.createFinancialsComponent(),
                "Manages Charter Order financial information", 2);
        icon = RMT2SwingUtil.createImageIcon("/images/Icon0141.gif");
        tp.insertTab(CharterOrderMaintDialog.TAB_NAME_TRANSACTIONS, icon,
                this.createTransactionsComponent(),
                "Manages transactions pertaining to the Charter Order", 3);
        icon = RMT2SwingUtil.createImageIcon("/images/Icon2754.gif");
        tp.insertTab(CharterOrderMaintDialog.TAB_NAME_EXPENSES, icon,
                this.createExpensesComponent(),
                "Manages Expense information for Charter Order", 4);
        icon = RMT2SwingUtil.createImageIcon("/images/Icon2672.gif");
        tp.insertTab(CharterOrderMaintDialog.TAB_NAME_SUMMARY, icon,
                this.createInvoiceSummaryComponent(),
                "Manages Invoice Summary information for Charter Order", 5);

        p.add(tp);
        return p;
    }

    private JPanel createClientComponent() {
        CharterOrderMaintClientComp comp = new CharterOrderMaintClientComp(
                this.parms);
        return comp;
    }

    private JPanel createTripComponent() {
        CharterOrderMaintTripComp comp = new CharterOrderMaintTripComp(
                this.parms);
        return comp;
    }

    private JPanel createFinancialsComponent() {
        CharterOrderMaintFinanceComp comp = new CharterOrderMaintFinanceComp(
                this.parms);
        comp.addFinancialUpdateListener(this);
        comp.addNewOrderCreatedListener(this);
        return comp;
    }

    private JPanel createTransactionsComponent() {
        CharterOrderMaintTransactionComp comp = new CharterOrderMaintTransactionComp(
                this.parms);
        return comp;
    }

    private JPanel createExpensesComponent() {
        CharterOrderMaintExpenseComp comp = new CharterOrderMaintExpenseComp(
                this.parms);
        return comp;
    }

    private JPanel createInvoiceSummaryComponent() {
        CharterOrderMaintInvoiceSummaryComp comp = new CharterOrderMaintInvoiceSummaryComp(
                this.parms);
        return comp;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ui.window.AbstractSdiModalWindow#updateView()
     */
    @Override
    public void updateView() {
        super.updateView();

        // // Decide if wwe should show the "Create Order" button
        // this.createOrderButton.setVisible(this.parms.isNewOrder());
        this.enableControls();
        // this.enableControls(!this.parms.isNewOrder());
    }

    /**
     * Returns the count of tab pages to process.
     * 
     * @return an Integer
     * @throws InvalidGuiDataException
     */
    @Override
    public Object getInputData() throws InvalidGuiDataException {
        return this.tp.getComponentCount();
    }

    /**
     * Cycles through all tab pages and persist the data changes of each.
     * 
     * @param data
     *            an Integer representing the total count of tab pages to
     *            process.
     * @return the total number of tab pages successfully saved.
     * @throws ProcessDataFailureException
     */
    @Override
    public Object processData(Object data) throws ProcessDataFailureException {
        try {
            this.saveChanges();
        } catch (Exception e) {
            this.okToClose = false;
        }

        return null;
    }

    /**
     * Saves data changes of all tab pages.
     */
    public void saveChanges() {
        // Create separate thread to perform save operation.
        SaveChangesThread t = new SaveChangesThread(this.tp);
        Thread thread = new Thread(t);
        thread.start();

        // int compCount = this.tp.getComponentCount();
        // try {
        // for (int ndx = 0; ndx < compCount; ndx++) {
        // AbstractGuiComponentTemplate<?> comp =
        // (AbstractGuiComponentTemplate<?>) this.tp
        // .getComponentAt(ndx);
        // comp.saveChanges();
        // }
        // FormUtil.showStatusMessage(lblMessage, "Update was successful",
        // false);
        // } catch (Exception e) {
        // FormUtil.showStatusMessage(lblMessage,
        // "Update failed: " + e.getMessage(), true);
        // throw e;
        // } finally {
        // enableControls();
        // }
        // return;
    }

    /**
     * Enables/Disables tabs, buttons, and other controls based on the value of
     * the order status
     * 
     * @param flag
     */
    private void enableControls() {
        // Enable tabs if order is not new
        boolean flag = (!this.parms.isNewOrder() && this.parms
                .getOrderStatusId() != CharterOrderConst.STATUS_QUOTE);
        int compCount = this.tp.getComponentCount();
        for (int ndx = 2; ndx < compCount; ndx++) {
            this.tp.setEnabledAt(ndx, flag);
        }

        // Show "Create Order" button only in "Quote" status
        this.createOrderButton
                .setVisible(this.parms.getOrderStatusId() == CharterOrderConst.STATUS_QUOTE);

        // Change text of save button to be "Save Quote" if we have not reached
        // "order" status
        if (this.parms.isNewOrder()
                || this.parms.getOrderStatusId() == CharterOrderConst.STATUS_QUOTE) {
            this.saveButton.setText("Save Quote");
        }
        else {
            this.saveButton.setText("Save");
        }

        // Show the "Generate Invoice" button only when in "Order" status
        this.butGenInvoice.setVisible(this.parms.isOrderInvoiceReady());

        // Enable the "Transactions", "Expenses", and "Invoice Summary" tabs
        // only when order is in "Invoice" status
        flag = (this.parms.getOrderStatusId() == CharterOrderConst.STATUS_INVOICED
                || this.parms.getOrderStatusId() == CharterOrderConst.STATUS_CLOSED || this.parms
                .getOrderStatusId() == CharterOrderConst.STATUS_CANCEL);
        this.tp.setEnabledAt((compCount - 3), flag); // Transactions
        this.tp.setEnabledAt((compCount - 2), flag); // Expenses
        this.tp.setEnabledAt((compCount - 1), flag); // Invoice Summary

        // Prevent user from saving changes when order is closed or cancelled
        if (this.parms.getOrderStatusId() == CharterOrderConst.STATUS_CLOSED
                || this.parms.getOrderStatusId() == CharterOrderConst.STATUS_CANCEL) {
            this.saveButton.setVisible(false);
            this.okButton.setVisible(false);
            this.cancelButton.setText("Close");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.maint.charterorder.TotalCostChangedListener#charterOrderTotalCostChange
     * (org.maint.charterorder.TotalCostChangedEvent)
     */
    @Override
    public void charterOrderTotalCostChanged(TotalCostChangedEvent evt) {
        double cost = evt.getCost();
        String value = RMT2Money.formatNumber(new Double(cost),
                "$#,##0.00;($#,##0.00)");
        this.txtBalanceField.setText(value);
        return;
    }

    /**
     * Event handler for updating the <i>Order</i> header value after the new
     * order is persisted successfully to the database.
     * 
     * @see org.maint.charterorder.NewOrderCreatedListener#handleNewOrderCreation
     *      (org.maint.charterorder.NewOrderCreatedEvent)
     */
    @Override
    public void handleNewOrderCreation(NewOrderCreatedEvent evt) {
        if (evt.getOrderId() > 0) {
            this.lblOrderId.setText(String.valueOf(this.parms.getOrderId()));
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ui.window.AbstractSdiModalWindow#actionPerformed(java.awt.event.
     * ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        switch (e.getActionCommand()) {
            case (CharterOrderMaintDialog.ACTION_COMMAND_GEN_INVOICE):
                this.generateInvoice();
                break;
            case (CharterOrderMaintDialog.ACTION_COMMAND_CREATEORDER):
                this.createNewOrder();
                break;
        }

    }

    /**
     * Creates a new order by changing the charter order status to "Order".
     * 
     */
    protected void createNewOrder() {
        this.parms.setOrderStatusId(CharterOrderConst.STATUS_ORDER);
        this.saveChanges();
    }

    /**
     * Moves the charter order into "Invoice" status.
     */
    protected void generateInvoice() {
        Number bal = RMT2Money.stringToNumber(txtBalanceField.getText());
        if (bal.doubleValue() == 0) {
            this.msg = "Cannot advance to invoice status at this time since no charges have been applied to the current Charter Order";
            FormUtil.showErrorMessageBox(this, this.msg,
                    "Charter Order Invoice Error");
            return;
        }
        this.parms.setOrderStatusId(CharterOrderConst.STATUS_INVOICED);
        this.saveChanges();
        this.enableControls();
    }

    private class RetrieveDataThread implements Runnable {
        private CharterOrderMaintParmsBean parms;
        private JTabbedPane tabs;

        protected RetrieveDataThread(JTabbedPane tabComp,
                CharterOrderMaintParmsBean data) {
            this.tabs = tabComp;
            this.parms = data;
        }

        @Override
        public void run() {
            int compCount = this.tabs.getComponentCount();
            try {
                for (int ndx = 0; ndx < compCount; ndx++) {
                    AbstractGuiComponentTemplate<CharterOrderMaintParmsBean> comp = (AbstractGuiComponentTemplate<CharterOrderMaintParmsBean>) this.tabs
                            .getComponentAt(ndx);
                    comp.updateView(this.parms);
                }
            } catch (Exception e) {
                String msg = "Unable to obtain data for Charter Order failed";
                logger.error(msg, e);
                throw new CharterOrderMaintenanceFailureException(msg, e);
            }
            logger.info("Thread: " + Thread.currentThread().getName());
            return;
        }
    }

    /**
     * A Worker Thread inner class used to save the data changes of all tab
     * pages.
     * <p>
     * <b>NOTE</b> Calling {@link AbstractGuiComponentTemplate#saveChanges()} in
     * the background has a tendency to cause problems when making back to back
     * DB calls for multiple components. For example, creating a TabPane where
     * each tab is a component that invokes multiple DB calls.
     * 
     * @author rterrell
     *
     */
    private class SaveChangesThread implements Runnable {

        private JTabbedPane tabs;

        protected SaveChangesThread(JTabbedPane tabComp) {
            this.tabs = tabComp;
            return;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {
            int compCount = this.tabs.getComponentCount();
            CharterOrderBO bo = new CharterOrderBO();
            bo.beginTrans();
            try {
                for (int ndx = 0; ndx < compCount; ndx++) {
                    AbstractGuiComponentTemplate<?> comp = (AbstractGuiComponentTemplate<?>) this.tabs
                            .getComponentAt(ndx);
                    comp.saveChanges();
                }
                bo.commitTrans();
            } catch (Exception e) {
                bo.rollbackTrans();
                String msg = "Update of Charter Order failed";
                logger.error(msg, e);
                throw new CharterOrderMaintenanceFailureException(msg, e);
            } finally {
                bo = null;
            }
            logger.info("Thread: " + Thread.currentThread().getName());
            return;

        }
    }
}
