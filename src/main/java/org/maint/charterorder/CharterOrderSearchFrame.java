package org.maint.charterorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

import org.FormUtil;
import org.apache.log4j.Logger;
import org.dao.BusCharterDaoConst;
import org.dao.mapping.Business;
import org.dao.mapping.GeneralCodes;
import org.dao.mapping.VwCharterOrderList;
import org.maint.company.CompanyBO;

import com.InvalidDataException;
import com.InvalidGuiDataException;
import com.ProcessDataFailureException;
import com.ui.components.dropdownbox.DynamicDropDownBox;
import com.ui.components.table.DataGrid;
import com.ui.components.table.ScrollableDataGrid;
import com.ui.components.table.TableColumnDefinition;
import com.ui.event.CustomItemDoubleClickedEvent;
import com.ui.event.CustomItemSelectedEvent;
import com.ui.event.CustomSelectionListener;
import com.ui.window.AbstractMdiModelessWindow;
import com.ui.window.WindowActionListener;
import com.util.RMT2SwingUtil;

/**
 * @author rterrell
 *
 */
public class CharterOrderSearchFrame extends AbstractMdiModelessWindow
        implements CustomSelectionListener, ActionListener {

    private static final long serialVersionUID = 1746311868533836L;

    private static final Logger logger = Logger
            .getLogger(CharterOrderSearchFrame.class);

    public static final int NO_COMPANY_SELECTED = 1000;

    private static final int FRAME_X_VALUE = 300;
    private static final String ROW_COUNT_TEXT = "Row count: ";

    /**
     * The Edit Command button
     */
    private JButton editButton;
    private JButton newButton;
    private JButton delButton;
    private JButton resetButton;

    private JTextField clientIdField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private DynamicDropDownBox<Business> companyField;

    private JTextField tripIdField;
    private DynamicDropDownBox<Business> transCompField;
    private JTextField charterPartyField;
    private JTextField signageField;
    private JTextField departDateField;
    private JTextField returnDateField;

    private JTextField orderIdField;
    private DynamicDropDownBox<GeneralCodes> orderStatusField;
    private JTextField clientOrderIdField;

    private ScrollableDataGrid grid;
    private JLabel lblRowCount;

    private CharterOrderMaintParmsBean currentCharterOrder;

    private CharterOrderBO bo;
    private CompanyBO cBo;

    private List<Business> companyOwnerList;
    private List<Business> companyClientList;
    private List<GeneralCodes> orderStatusItmes;

    /**
     * @throws HeadlessException
     */
    public CharterOrderSearchFrame() throws HeadlessException {
        return;
    }

    /**
     * @param size
     * @param pos
     * @param winTitle
     * @throws HeadlessException
     */
    public CharterOrderSearchFrame(Dimension size, Point pos, String winTitle)
            throws HeadlessException {
        super(size, pos, winTitle);
        return;
    }

    @Override
    protected void initFrame() {
        this.bo = new CharterOrderBO();
        this.cBo = new CompanyBO();
        this.orderStatusItmes = this.bo
                .getLookupCodeByGroup(BusCharterDaoConst.LOOKUP_GRP_ORDERSTATUS);
        this.companyOwnerList = this.cBo
                .getCompanyInfoByBusinessType(BusCharterDaoConst.LOOKUP_CODE_BUSINESSTYPE_CHARTER_OWNER);
        this.companyClientList = this.cBo
                .getCompanyInfoByBusinessType(BusCharterDaoConst.LOOKUP_CODE_BUSINESSTYPE_CLIENT);

        super.initFrame();
        this.okButton.setText("Search");

        // Create additional command buttons starting at position #1
        editButton = new JButton("Edit");
        editButton.setActionCommand(WindowActionListener.ACTION_COMMAND_EDIT);
        editButton.setEnabled(false);
        editButton.addActionListener(this);
        buttonPane.add(editButton, 1);

        newButton = new JButton("New");
        newButton.setActionCommand(WindowActionListener.ACTION_COMMAND_ADD);
        newButton.addActionListener(this);
        buttonPane.add(newButton, 2);

        delButton = new JButton("Delete");
        delButton.setActionCommand(WindowActionListener.ACTION_COMMAND_DELETE);
        delButton.setEnabled(false);
        delButton.addActionListener(this);
        buttonPane.add(delButton, 3);

        resetButton = new JButton("Reset");
        resetButton.setActionCommand(WindowActionListener.ACTION_COMMAND_RESET);
        resetButton.addActionListener(this);
        buttonPane.add(resetButton, 4);

        this.companyField.addActionListener(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ui.window.WindowActionListener#createContentLayout()
     */
    @Override
    public JPanel createContentLayout() {

        // Use the MigLayout to setup criteria section
        JPanel criteriaPanel = new JPanel();
        criteriaPanel
                .setLayout(new MigLayout("", "[grow][grow][grow]", "[][]"));

        JLabel lblTitle = new JLabel("Charter Order Search Criteria");
        Font font = new Font(Font.SERIF, Font.BOLD, 20);
        lblTitle.setFont(font);
        lblTitle.setForeground(Color.BLUE);
        criteriaPanel.add(lblTitle, "split 3, wrap");
        // Setup client panel
        criteriaPanel.add(this.createClientPanel(), "growx");
        // Setup trip panel
        criteriaPanel.add(this.createTripPanel(), "growx");
        // Setup order panel
        criteriaPanel.add(this.createOrderPanel(), "growx");

        // Use the MigLayout to setup results section
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new MigLayout("", "[grow]", "[][]"));
        lblTitle = new JLabel("Charter Order Search Results");
        lblTitle.setFont(font);
        lblTitle.setForeground(Color.BLUE);
        listPanel.add(lblTitle, "wrap");

        // Build grid with data
        this.lblRowCount = new JLabel(CharterOrderSearchFrame.ROW_COUNT_TEXT
                + "0");
        this.grid = this.createDataGrid(null);
        listPanel.add(this.grid, "growx");

        // Setup the main panel with criteria and results sections
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new MigLayout("", "[grow]", "[]20[][]"));
        mainPanel.add(criteriaPanel, "dock north, wrap");
        mainPanel.add(listPanel, "dock center");
        mainPanel.add(this.lblRowCount, "dock south");

        return mainPanel;
    }

    private JPanel createClientPanel() {
        JPanel p = new JPanel();
        p.setLayout(new MigLayout("insets 0 10 10 20", "[][grow]", "[][][][]"));
        JLabel lblNewLabel = new JLabel("Client Id");
        p.add(lblNewLabel, "cell 0 0,alignx right");
        this.clientIdField = new JTextField();
        p.add(this.clientIdField, "cell 1 0,growx");
        lblNewLabel = new JLabel("First Name");
        p.add(lblNewLabel, "cell 0 1,alignx right");
        this.firstNameField = new JTextField();
        p.add(this.firstNameField, "cell 1 1,growx");
        lblNewLabel = new JLabel("Last Name");
        p.add(lblNewLabel, "cell 0 2,alignx right");
        this.lastNameField = new JTextField();
        p.add(this.lastNameField, "cell 1 2,growx");
        lblNewLabel = new JLabel("Company");
        p.add(lblNewLabel, "cell 0 3,alignx right");

        this.companyField = FormUtil.createCompanyInfoDDB(
                this.companyClientList, null, 70);
        p.add(this.companyField, "cell 1 3,growx");

        FormUtil.addPanelTitle(p, "Client Data", Color.BLUE);
        return p;
    }

    private JPanel createTripPanel() {
        JPanel p = new JPanel();
        p.setLayout(new MigLayout("insets 0 10 10 20", "[][grow]",
                "[][][][][][]"));
        JLabel lblNewLabel = new JLabel("Trip Id");
        p.add(lblNewLabel, "cell 0 0,alignx right");
        this.tripIdField = new JTextField();
        p.add(this.tripIdField, "cell 1 0,growx");

        lblNewLabel = new JLabel("Transport Company");
        p.add(lblNewLabel, "cell 0 1,alignx right");
        // this.transCompField = new JComboBox();
        this.transCompField = FormUtil.createCompanyInfoDDB(
                this.companyOwnerList, null, 70);
        p.add(this.transCompField, "cell 1 1,growx");

        lblNewLabel = new JLabel("Charter Party");
        p.add(lblNewLabel, "cell 0 2,alignx right");
        this.charterPartyField = new JTextField();
        p.add(this.charterPartyField, "cell 1 2,growx");

        lblNewLabel = new JLabel("Signage");
        p.add(lblNewLabel, "cell 0 3,alignx right");
        this.signageField = new JTextField();
        p.add(this.signageField, "cell 1 3,growx");

        lblNewLabel = new JLabel("Depart Date");
        p.add(lblNewLabel, "cell 0 4,alignx right");
        this.departDateField = new JTextField();
        p.add(this.departDateField, "cell 1 4,growx");

        lblNewLabel = new JLabel("Return Date");
        p.add(lblNewLabel, "cell 0 5,alignx right");
        this.returnDateField = new JTextField();
        p.add(this.returnDateField, "cell 1 5,growx");

        FormUtil.addPanelTitle(p, "Trip Data", Color.BLUE);
        return p;
    }

    private JPanel createOrderPanel() {
        JPanel p = new JPanel();
        p.setLayout(new MigLayout("insets 0 10 10 20", "[][grow]", "[][][]"));
        JLabel lblNewLabel = new JLabel("Order Id");
        p.add(lblNewLabel, "cell 0 0,alignx right");
        this.orderIdField = new JTextField();
        p.add(this.orderIdField, "cell 1 0,growx");
        lblNewLabel = new JLabel("Order Status");
        p.add(lblNewLabel, "cell 0 1,alignx right");

        this.orderStatusField = FormUtil.createGeneralCodesDDB(
                this.orderStatusItmes, null, 90);
        p.add(this.orderStatusField, "cell 1 1,growx");

        lblNewLabel = new JLabel("Client Order Id");
        p.add(lblNewLabel, "cell 0 2,alignx right");
        this.clientOrderIdField = new JTextField();
        FormUtil.addPanelTitle(p, "Order Data", Color.BLUE);
        p.add(this.clientOrderIdField, "cell 1 2,growx");

        return p;
    }

    private void resetWindow() {
        this.clientIdField.setText("");
        this.firstNameField.setText("");
        this.lastNameField.setText("");
        this.companyField.setSelectedIndex(0);

        this.tripIdField.setText("");
        this.transCompField.setSelectedIndex(0);
        this.charterPartyField.setText("");
        this.signageField.setText("");
        this.departDateField.setText("");
        this.returnDateField.setText("");

        this.orderIdField.setText("");
        this.orderStatusField.setSelectedIndex(0);
        this.clientOrderIdField.setText("");

        this.grid.getTableView().loadTable(new ArrayList<VwCharterOrderList>());
        this.lblRowCount.setText(CharterOrderSearchFrame.ROW_COUNT_TEXT + "0");
    }

    /**
     * Creates the structure of the ScrollableDataGrid based on the List of data
     * items representing the grid data to be displayed.
     * 
     * @param list
     *            the data to be displayed.
     * @return an instance of {@link ScrollableDataGrid}
     */
    private ScrollableDataGrid createDataGrid(List<VwCharterOrderList> list) {

        // Setup column definitions
        List<TableColumnDefinition> colDefs = new ArrayList<TableColumnDefinition>();
        colDefs.add(new TableColumnDefinition("orderId", "Order Id", 0, 60));
        colDefs.add(new TableColumnDefinition("status", "Order Status", 1, 80));
        colDefs.add(new TableColumnDefinition("orderTotal", "Order Total",
                "#,##0.00", 2, 90, SwingConstants.RIGHT));
        colDefs.add(new TableColumnDefinition("contactFname", "First Name", 3,
                80));
        colDefs.add(new TableColumnDefinition("contactLname", "Last Name", 4,
                80));
        colDefs.add(new TableColumnDefinition("contactCompanyName",
                "Client Comapny", 5, 180));
        colDefs.add(new TableColumnDefinition("balanceDue", "Balance Due",
                "#,##0.00", 6, 100, SwingConstants.RIGHT));
        colDefs.add(new TableColumnDefinition("expenses", "Expenses",
                "#,##0.00", 7, 80, SwingConstants.RIGHT));
        colDefs.add(new TableColumnDefinition("transportCompany",
                "Transport Company", 8, 180));

        colDefs.add(new TableColumnDefinition("charterParty", "Charter Party",
                9, 180));
        colDefs.add(new TableColumnDefinition("departDate", "Depart Date", 10,
                90));
        colDefs.add(new TableColumnDefinition("returnDate", "Return Date", 11,
                90));
        colDefs.add(new TableColumnDefinition("destination", "Destination", 12,
                280));

        // Set the size of the data grid component
        Dimension size = new Dimension(2050, 430);

        DataGrid table = new DataGrid(list, colDefs,
                ListSelectionModel.SINGLE_SELECTION, size);
        table.setup();
        table.addItemSelectionListener(this);

        // Identify those columns that need to use special comparators for
        // sorting.
        int numericCols[] = { 0, 1, 2, 3 };
        table.setNumericColumnSorter(numericCols);

        // Create ScrollableDataGrid grid component
        ScrollableDataGrid dg = new ScrollableDataGrid(table);
        return dg;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ui.window.WindowActionListener#getInputData()
     */
    @Override
    public Object getInputData() throws InvalidGuiDataException {
        // Get selection crtiteria
        this.editButton.setEnabled(false);
        CharterOrderSearchCriteriaBean criteria = this
                .getUserSelectionCriteria();
        return criteria;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ui.window.WindowActionListener#processData(java.lang.Object)
     */
    @Override
    public Object processData(Object data) throws ProcessDataFailureException {
        RetrieveDataThread t = new RetrieveDataThread(this,
                (CharterOrderSearchCriteriaBean) data);
        Thread thread = new Thread(t);
        thread.start();
        return null;
    }

    private CharterOrderSearchCriteriaBean getUserSelectionCriteria() {
        CharterOrderSearchCriteriaBean c = new CharterOrderSearchCriteriaBean();
        c.setClientId(RMT2SwingUtil.isTextFieldPopulated(this.clientIdField) ? this.clientIdField
                .getText() : null);
        c.setFirstName(RMT2SwingUtil.isTextFieldPopulated(this.firstNameField) ? this.firstNameField
                .getText() : null);
        c.setLastName(RMT2SwingUtil.isTextFieldPopulated(this.lastNameField) ? this.lastNameField
                .getText() : null);
        if (this.companyField.getSelectedItem() != null) {
            Business busObj = (Business) this.companyField.getSelectedItem();
            if (busObj.getId() != CharterOrderSearchFrame.NO_COMPANY_SELECTED) {
                c.setCompany(String.valueOf(busObj.getId()));
            }
        }

        c.setTripId(RMT2SwingUtil.isTextFieldPopulated(this.tripIdField) ? this.tripIdField
                .getText() : null);
        if (this.transCompField.getSelectedItem() != null) {
            Business transCompObj = (Business) this.transCompField
                    .getSelectedItem();
            if (transCompObj.getId() != CharterOrderSearchFrame.NO_COMPANY_SELECTED) {
                c.setTransComp(String.valueOf(transCompObj.getId()));
            }
        }
        c.setCharterParty(RMT2SwingUtil
                .isTextFieldPopulated(this.charterPartyField) ? this.charterPartyField
                .getText() : null);
        c.setSignage(RMT2SwingUtil.isTextFieldPopulated(this.signageField) ? this.signageField
                .getText() : null);
        c.setDepartDate(RMT2SwingUtil
                .isTextFieldPopulated(this.departDateField) ? this.departDateField
                .getText() : null);
        c.setReturnDate(RMT2SwingUtil
                .isTextFieldPopulated(this.returnDateField) ? this.returnDateField
                .getText() : null);

        c.setOrderId(RMT2SwingUtil.isTextFieldPopulated(this.orderIdField) ? this.orderIdField
                .getText() : null);
        if (this.orderStatusField.getSelectedItem() != null) {
            GeneralCodes code = (GeneralCodes) this.orderStatusField
                    .getSelectedItem();
            if (!code.getShortdesc().equalsIgnoreCase("A")) {
                c.setOrderStatus(String.valueOf(code.getCodeId()));
            }

        }
        c.setClientOrderId(RMT2SwingUtil
                .isTextFieldPopulated(this.clientOrderIdField) ? this.clientOrderIdField
                .getText() : null);

        return c;
    }

    /**
     * Displays the User Login Window.
     */
    protected void openCharterOrderMaintDialog(CharterOrderMaintParmsBean parms) {
        String msg = null;

        try {
            CharterOrderMaintDialog dialog = new CharterOrderMaintDialog(
                    "Charter Order Maintenance", parms,
                    new Dimension(980, 680), new Point(FRAME_X_VALUE, 300));
            // this.getDesktopPane().add(dialog);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
            Object results = dialog.getResults();

        } catch (InvalidDataException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "User Login Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            msg = e.getMessage()
                    + "\n\nContact the support team for assistance";
            logger.error(e);
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, msg,
                    "Charter Order Maintenance Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteCharterOrder() {
        int row = this.grid.getTableView().getSelectedRow();
        try {
            int rows = this.bo.deleteCharterOrder(this.currentCharterOrder
                    .getQuoteId());
            logger.info("total number of entries effected by deleting quote ["
                    + this.currentCharterOrder.getQuoteId() + "] order ["
                    + this.currentCharterOrder.getOrderId() + "] => " + rows);
            this.grid.getTableView().removeGridRow(row);
        } catch (Exception e) {
            FormUtil.showErrorMessageBox(this, e.getMessage(),
                    "Charter Order Delete Problem");
        }

    }

    /**
     * Opens the modal dialog, {@link CharterOrderMaintDialog}, using the
     * current selected charter order object as input.
     * <p>
     * before the dialog is opened, all data that is needed to satisfy the
     * display requirements of the CharterOrderMaintDialog dialog is fetched and
     * stored in the variable representing the current charter order object.
     * 
     * @param evt
     *            an instance of {@link CustomItemDoubleClickedEvent}
     */
    @Override
    public void handleDoubleClickedRow(CustomItemDoubleClickedEvent evt) {
        if (evt.getSelectedItem() == null) {
            return;
        }

        // open the CharterOrdermaintDialog using selected parameters,
        // CharterOrderMaintParmsBean.
        this.openCharterOrderMaintDialog(this.currentCharterOrder);
    }

    /**
     * Captures key information for identifying the current charter order record
     * when a selection is made in the data grid.
     * <p>
     * The data items captured are <i>client id</i>, <i>quote id</i>, <i>order
     * id</i>, <i>client order id</i>, <i>order status</i>,<i>is new order
     * flag</i>, and <i>is editable flag</i>.
     * 
     * @param evt
     *            an instance of {@link CustomItemSelectedEvent}
     */
    @Override
    public void handleSelectionChanged(CustomItemSelectedEvent evt) {
        if (this.currentCharterOrder == null) {
            this.currentCharterOrder = new CharterOrderMaintParmsBean();
        }

        // Get data from selected row and populate the variable representing the
        // current charter order grid row, which is used as an input paramter
        // for opening the CharterORdermaintDialog.
        VwCharterOrderList item = (VwCharterOrderList) evt.getSelectedItem();
        this.currentCharterOrder.setClientId(item.getClientId());
        this.currentCharterOrder.setQuoteId(item.getQuoteId());
        this.currentCharterOrder.setOrderId(item.getOrderId());
        this.currentCharterOrder.setClientOrderId(item.getClientOrderId());
        this.currentCharterOrder.setOrderStatusId(item.getStatusId());
        this.currentCharterOrder.setNewOrder(false);
        this.currentCharterOrder
                .setEditable(item.getStatusId() == CharterOrderConst.STATUS_QUOTE
                        || item.getStatusId() == CharterOrderConst.STATUS_ORDER);

        this.editButton.setEnabled(true);
        this.delButton.setEnabled(true);
    }

    /**
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        String command = e.getActionCommand();
        if (command.equals(WindowActionListener.ACTION_COMMAND_EDIT)) {
            this.openCharterOrderMaintDialog(this.currentCharterOrder);
            return;
        }
        if (command.equals(WindowActionListener.ACTION_COMMAND_ADD)) {
            this.openCharterOrderMaintDialog(null);
            return;
        }
        if (command.equals(WindowActionListener.ACTION_COMMAND_DELETE)) {
            this.deleteCharterOrder();
            return;
        }
        if (command.equals(WindowActionListener.ACTION_COMMAND_RESET)) {
            this.resetWindow();
            return;
        }

        // TEsting combobox fetch
        if (command.equals("comboBoxChanged")) {
            Business obj = null;
            if (e.getSource() instanceof DynamicDropDownBox) {
                DynamicDropDownBox<Business> ddb = (DynamicDropDownBox<Business>) e
                        .getSource();
                obj = (Business) ddb.getSelectedItem();
                String name = obj.getLongname();
            }

            else if (e.getSource() instanceof JComboBox) {
                JComboBox<Business> ddb = (JComboBox<Business>) e.getSource();
                Integer key = (Integer) ddb.getSelectedItem();
                key = key;
            }

            return;
        }
    }

    /**
     * 
     * @author appdev
     *
     */
    protected class RetrieveDataThread implements Runnable {
        private CharterOrderSearchFrame parent;
        private CharterOrderSearchCriteriaBean criteria;

        protected RetrieveDataThread(CharterOrderSearchFrame parent,
                CharterOrderSearchCriteriaBean data) {
            this.parent = parent;
            this.criteria = data;
        }

        @Override
        public void run() {
            List<VwCharterOrderList> list = parent.bo
                    .getCharterOrderInfo(criteria);
            if (list == null) {
                list = new ArrayList<VwCharterOrderList>();
            }
            this.updateControls(list);
            return;
        }

        private void updateControls(final List<VwCharterOrderList> obj) {

            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    parent.grid.getTableView().loadTable(obj);
                    parent.lblRowCount
                            .setText(CharterOrderSearchFrame.ROW_COUNT_TEXT
                                    + obj.size());
                }
            });
        }
    }

}
