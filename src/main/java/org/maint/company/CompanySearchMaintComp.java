package org.maint.company;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

import org.FormUtil;
import org.dao.BusCharterDaoConst;
import org.dao.mapping.Business;
import org.dao.mapping.StatesCode;
import org.dao.mapping.VwClientList;
import org.dao.mapping.Zipcode;
import org.maint.charterorder.CharterOrderBO;
import org.maint.charterorder.CharterOrderSearchFrame;

import com.ui.components.AbstractGuiComponentTemplate;
import com.ui.components.dropdownbox.DropDownBoxColumnDefinition;
import com.ui.components.dropdownbox.DynamicDropDownBox;
import com.ui.components.dropdownbox.DynamicDropDownBoxColumnModelBuilder;
import com.ui.components.table.DataGrid;
import com.ui.components.table.ScrollableDataGrid;
import com.ui.components.table.TableColumnDefinition;
import com.ui.event.CustomItemDoubleClickedEvent;
import com.ui.event.CustomItemSelectedEvent;
import com.ui.event.CustomSelectionListener;
import com.util.RMT2Money;
import com.util.RMT2String;

/**
 * A component for displaying and managing client data.
 * 
 * @author rterrell
 *
 */
public class CompanySearchMaintComp extends
        AbstractGuiComponentTemplate<Boolean> implements ActionListener,
        CustomSelectionListener, FocusListener {

    private static final long serialVersionUID = 1746311868533836L;

    /**
     * Search criteria fields
     */
    private JTextField srchClientIdField;
    private JTextField srchFirstNameField;
    private JTextField srchLastNameField;
    private DynamicDropDownBox<Business> srchCompanyField;
    private DynamicDropDownBox<StatesCode> srchStateField;
    private JTextField srchCityField;
    private JTextField srchZipField;
    private JTextField srchPhoneField;

    /**
     * Detail fields
     */
    private JCheckBox cbxDupBilling;
    private DynamicDropDownBox<Business> ddbCntCompany;
    private JTextField txtCntCompName;
    private JTextField txtCntFirstName;
    private JTextField txtCntLastName;
    private JTextField txtCntAddr1;
    private JTextField txtCntAddr2;
    private JTextField txtCntAddr3;
    private JLabel lblCntCity;
    private JLabel lblCntState;
    private JTextField txtCntZip;
    private JTextField txtCntPhone;
    private JTextField txtCntFax;

    private DynamicDropDownBox<Business> ddbBillCompany;
    private JTextField txtBillCompName;
    private JTextField txtBillFirstName;
    private JTextField txtBillLastName;
    private JTextField txtBillAddr1;
    private JTextField txtBillAddr2;
    private JTextField txtBillAddr3;
    private JLabel lblBillCity;
    private JLabel lblBillState;
    private JTextField txtBillZip;
    private JTextField txtBillPhone;
    private JTextField txtBillFax;
    private JTextField txtEmail;
    private JTextField txtWebsite;
    private JTextArea txtComments;
    private JLabel lblMsg;

    private ScrollableDataGrid grid;
    private List<VwClientList> clients;
    private VwClientList selectedClient;

    private CompanyBO bo;
    private CharterOrderBO coBo;

    private List<StatesCode> stateList;
    private List<Business> companyClientList;
    private boolean readlOnly;
    private boolean showReqInd;;
    private String prevContactZip;
    private String prevBillZip;

    /**
     * @throws HeadlessException
     */
    public CompanySearchMaintComp(boolean readOnly) {
        super(readOnly);
        return;
    }

    protected void initFields() {
        this.bo = new CompanyBO();
        this.coBo = new CharterOrderBO();
        this.stateList = this.coBo.getUsStates();
        this.companyClientList = this.bo
                .getCompanyInfoByBusinessType(BusCharterDaoConst.LOOKUP_CODE_BUSINESSTYPE_CLIENT);
        this.clients = new ArrayList<VwClientList>();
    }

    protected void setupView() {
        this.readlOnly = this.getData();
        if (this.readlOnly) {
            this.showReqInd = false;
        }
        else {
            this.showReqInd = true;
        }
        // Initialize search criteria fields
        this.srchClientIdField = FormUtil.createTextField(this, null, false);
        this.srchFirstNameField = FormUtil.createTextField(this, null, false);
        this.srchLastNameField = FormUtil.createTextField(this, null, false);
        this.srchCityField = FormUtil.createTextField(this, null, false);
        this.srchZipField = FormUtil.createTextField(this, null, false);
        this.srchPhoneField = FormUtil.createTextField(this, null, false);

        // Initialize detail fields
        this.cbxDupBilling = FormUtil.createCheckBox("Copy billing address?",
                SwingConstants.LEFT, false, true);
        this.txtCntCompName = FormUtil.createTextField(this, null,
                this.readlOnly);
        this.txtCntFirstName = FormUtil.createTextField(this, null,
                this.readlOnly);
        this.txtCntLastName = FormUtil.createTextField(this, null,
                this.readlOnly);
        this.txtCntAddr1 = FormUtil.createTextField(this, null, this.readlOnly);
        this.txtCntAddr2 = FormUtil.createTextField(this, null, this.readlOnly);
        this.txtCntAddr3 = FormUtil.createTextField(this, null, this.readlOnly);
        this.lblCntCity = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblCntState = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.txtCntZip = FormUtil.createTextField(this, null, this.readlOnly);
        this.txtCntPhone = FormUtil.createTextField(this, null, this.readlOnly);
        this.txtCntFax = FormUtil.createTextField(this, null, this.readlOnly);
        this.txtBillCompName = FormUtil.createTextField(this, null,
                this.readlOnly);
        this.txtBillFirstName = FormUtil.createTextField(this, null,
                this.readlOnly);
        this.txtBillLastName = FormUtil.createTextField(this, null,
                this.readlOnly);
        this.txtBillAddr1 = FormUtil
                .createTextField(this, null, this.readlOnly);
        this.txtBillAddr2 = FormUtil
                .createTextField(this, null, this.readlOnly);
        this.txtBillAddr3 = FormUtil
                .createTextField(this, null, this.readlOnly);
        this.lblBillCity = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblBillState = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.txtBillZip = FormUtil.createTextField(this, null, this.readlOnly);
        this.txtBillPhone = FormUtil
                .createTextField(this, null, this.readlOnly);
        this.txtBillFax = FormUtil.createTextField(this, null, this.readlOnly);
        this.txtEmail = FormUtil.createTextField(this, null, this.readlOnly);
        this.txtWebsite = FormUtil.createTextField(this, null, this.readlOnly);
        this.txtComments = FormUtil.createTextArea(this, null, this.readlOnly,
                5);

        this.ddbCntCompany = FormUtil.createCompanyInfoDDB(
                this.companyClientList, null, 70);
        this.ddbBillCompany = FormUtil.createCompanyInfoDDB(
                this.companyClientList, null, 70);

        this.lblMsg = FormUtil.createDataLabel(null, true, Color.RED, 100,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.LEFT, 14);

        if (!this.readlOnly) {
            this.txtCntZip.setName("txtCntZip");
            this.txtCntZip.addFocusListener(this);
            this.txtBillZip.setName("txtBillZip");
            this.txtBillZip.addFocusListener(this);
        }

        this.setLayout(new MigLayout("", "[grow]", "[grow][grow][]"));
        JPanel sect1 = this.buildSection1();
        JPanel sect2 = this.buildSection2();
        JPanel sect3 = this.buildSection3();
        this.add(sect1, "wrap");
        this.add(sect2, "growy, wrap");
        this.add(sect3);
    }

    private JPanel buildSection1() {
        JPanel sect1 = new JPanel();
        sect1.setLayout(new MigLayout("", "[][grow][][grow][][grow]",
                "[][][][]"));

        // Create Section Title
        JLabel lbl = new JLabel("Company Search Criteria");
        Font font = new Font(Font.SERIF, Font.BOLD, 18);
        lbl.setFont(font);
        lbl.setForeground(Color.BLUE);
        sect1.add(lbl, "right, span 8, left, top, wrap");

        // Create First row
        sect1.add(FormUtil.createHeaderLabel("Company Id: "), "right, top");
        sect1.add(this.srchClientIdField, "width 90, left");

        sect1.add(FormUtil.createHeaderLabel("Name: "), "right, top");
        sect1.add(this.srchFirstNameField, "width 180, left");

        sect1.add(FormUtil.createHeaderLabel("Alternate Name: "), "right, top");
        sect1.add(this.srchLastNameField, "width 90, left, wrap");

        // Create second row
        sect1.add(FormUtil.createHeaderLabel("Company Type: "), "right, top");
        DropDownBoxColumnDefinition def = new DropDownBoxColumnDefinition(
                "stateId", "longname", 0, 70);
        this.srchStateField = FormUtil.createDropDownBox(def, this.stateList);
        sect1.add(this.srchStateField, "growx, left");

        sect1.add(FormUtil.createHeaderLabel("Status: "), "right, top");
        sect1.add(this.srchCityField, "growx, left");

        sect1.add(FormUtil.createHeaderLabel("Start Date: "), "right, top");
        sect1.add(this.srchZipField, "growx, left, wrap");

        // Create third row
        sect1.add(FormUtil.createHeaderLabel("Termination Date: "),
                "right, top");
        sect1.add(this.srchPhoneField, "growx, left");

        sect1.add(FormUtil.createHeaderLabel("Date Suspended: "), "right, top");
        sect1.add(this.srchCityField, "growx, left");

        sect1.add(FormUtil.createHeaderLabel("Date Suspension Removed: "),
                "right, top");
        sect1.add(this.srchZipField, "growx, left, wrap");

        return sect1;
    }

    private JPanel buildSection2() {
        JPanel sect2 = new JPanel();
        sect2.setLayout(new MigLayout("", "[grow]", "[][grow]"));

        // Create Section Title
        JLabel lbl = new JLabel("Client Search Results");
        Font font = new Font(Font.SERIF, Font.BOLD, 18);
        lbl.setFont(font);
        lbl.setForeground(Color.BLUE);
        sect2.add(lbl, "right, span 8, left, top, wrap");

        this.grid = this.createDataGrid(this.clients);
        sect2.add(this.grid, "width 880, growx");
        return sect2;
    }

    private JPanel buildSection3() {
        JPanel outer = new JPanel();
        outer.setLayout(new MigLayout("", "[grow]", "[grow][grow][grow]"));
        if (!this.readlOnly) {
            this.cbxDupBilling.addActionListener(this);
            outer.add(this.cbxDupBilling, "right, span 8, left, top, wrap");
        }
        JPanel addrPanel = new JPanel();
        addrPanel.setLayout(new MigLayout("", "[grow]20[grow]", "[]"));

        JPanel contactInfo = new JPanel();
        contactInfo.setLayout(new MigLayout("", "[][grow]",
                "[][][][][][][][][][][]"));
        FormUtil.addPanelTitle(contactInfo, "Contact Information", Color.BLUE);
        contactInfo.add(
                FormUtil.createHeaderLabel("First Name: ", this.showReqInd),
                "right, top");
        contactInfo.add(this.txtCntFirstName, "growx, left, wrap");
        contactInfo.add(
                FormUtil.createHeaderLabel("Last Name: ", this.showReqInd),
                "right, top");
        contactInfo.add(this.txtCntLastName, "growx, left, wrap");
        contactInfo.add(FormUtil.createHeaderLabel("Company Name: "),
                "right, top");

        if (this.readlOnly) {
            // Add spaces to force panel to expand on initial view
            this.txtCntCompName.setText(RMT2String.spaces(60));
            contactInfo.add(this.txtCntCompName, "growx, left, wrap");
        }
        else {
            contactInfo.add(this.ddbCntCompany, "growx, left, wrap");
        }

        contactInfo.add(FormUtil.createHeaderLabel("Address: "), "right, top");
        contactInfo.add(this.txtCntAddr1, "growx, left, wrap");
        contactInfo.add(FormUtil.createHeaderLabel(""), "right, top");
        contactInfo.add(this.txtCntAddr2, "growx, left, wrap");
        contactInfo.add(FormUtil.createHeaderLabel(""), "right, top");
        contactInfo.add(this.txtCntAddr3, "growx, left, wrap");
        contactInfo.add(FormUtil.createHeaderLabel("City: "), "right, top");
        contactInfo.add(this.lblCntCity, "growx, left, wrap");
        contactInfo.add(FormUtil.createHeaderLabel("State: "), "right, top");
        contactInfo.add(this.lblCntState, "growx, left, wrap");
        contactInfo.add(FormUtil.createHeaderLabel("Zip: ", this.showReqInd),
                "right, top");
        contactInfo.add(this.txtCntZip, "growx, left, wrap");
        contactInfo.add(FormUtil.createHeaderLabel("Phone: ", this.showReqInd),
                "right, top");
        contactInfo.add(this.txtCntPhone, "growx, left, wrap");
        contactInfo.add(FormUtil.createHeaderLabel("Fax: "), "right, top");
        contactInfo.add(this.txtCntFax, "growx, left, wrap");

        JPanel billInfo = new JPanel();
        billInfo.setLayout(new MigLayout("", "[][grow]",
                "[][][][][][][][][][][]"));
        FormUtil.addPanelTitle(billInfo, "Billing Information", Color.BLUE);
        billInfo.add(
                FormUtil.createHeaderLabel("First Name: ", this.showReqInd),
                "right, top");
        billInfo.add(this.txtBillFirstName, "growx, left, wrap");
        billInfo.add(
                FormUtil.createHeaderLabel("Last Name: ", this.showReqInd),
                "right, top");
        billInfo.add(this.txtBillLastName, "growx, left, wrap");
        billInfo.add(FormUtil.createHeaderLabel("Company Name: "), "right, top");

        if (this.readlOnly) {
            // Add spaces to force panel to expand on initial view
            this.txtBillCompName.setText(RMT2String.spaces(60));
            billInfo.add(this.txtBillCompName, "growx, left, wrap");
        }
        else {
            billInfo.add(this.ddbBillCompany, "growx, left, wrap");
        }

        billInfo.add(FormUtil.createHeaderLabel("Address: "), "right, top");
        billInfo.add(this.txtBillAddr1, "growx, left, wrap");
        billInfo.add(FormUtil.createHeaderLabel(""), "right, top");
        billInfo.add(this.txtBillAddr2, "growx, left, wrap");
        billInfo.add(FormUtil.createHeaderLabel(""), "right, top");
        billInfo.add(this.txtBillAddr3, "growx, left, wrap");
        billInfo.add(FormUtil.createHeaderLabel("City: "), "right, top");
        billInfo.add(this.lblBillCity, "growx, left, wrap");
        billInfo.add(FormUtil.createHeaderLabel("State: "), "right, top");
        billInfo.add(this.lblBillState, "growx, left, wrap");
        billInfo.add(FormUtil.createHeaderLabel("Zip: ", this.showReqInd),
                "right, top");
        billInfo.add(this.txtBillZip, "growx, left, wrap");
        billInfo.add(FormUtil.createHeaderLabel("Phone: ", this.showReqInd),
                "right, top");
        billInfo.add(this.txtBillPhone, "growx, left, wrap");
        billInfo.add(FormUtil.createHeaderLabel("Fax: "), "right, top");
        billInfo.add(this.txtBillFax, "growx, left, wrap");

        addrPanel.add(contactInfo);
        addrPanel.add(billInfo);

        JPanel genPanel = new JPanel();
        genPanel.setLayout(new MigLayout("", "[][540:540:540]", "[][][][]"));
        genPanel.add(FormUtil.createHeaderLabel("Email: "), "right, top");
        genPanel.add(this.txtEmail, "growx, left, wrap");
        genPanel.add(FormUtil.createHeaderLabel("Web Site: "), "right, top");
        genPanel.add(this.txtWebsite, "growx, left, wrap");
        genPanel.add(FormUtil.createHeaderLabel("Comments: "), "right, top");
        genPanel.add(this.txtComments, "growx, left, wrap");

        genPanel.add(this.lblMsg, "growx, left, span 2");

        outer.add(addrPanel, "wrap");
        outer.add(genPanel);
        return outer;
    }

    /**
     * Creates the structure of the ScrollableDataGrid based on the List of data
     * items representing the grid data to be displayed.
     * 
     * @param list
     *            the data to be displayed.
     * @return an instance of {@link ScrollableDataGrid}
     */
    private ScrollableDataGrid createDataGrid(List<?> list) {

        // Setup column definitions
        List<TableColumnDefinition> colDefs = new ArrayList<TableColumnDefinition>();
        colDefs.add(new TableColumnDefinition("clientId", "Client Id", 0, 60));
        colDefs.add(new TableColumnDefinition("contactFname", "First Name", 1,
                140));
        colDefs.add(new TableColumnDefinition("contactLname", "Last Name", 2,
                140));
        colDefs.add(new TableColumnDefinition("contactCompanyName", "Company",
                3, 280));
        colDefs.add(new TableColumnDefinition("contactCity", "City", 4, 120));
        colDefs.add(new TableColumnDefinition("contactState", "State", 5, 40));
        colDefs.add(new TableColumnDefinition("contactPhone", "Phone", 6, 100));

        // Set the width of size to "0" so that the framework can determine the
        // actual table size.
        Dimension size = new Dimension(0, 430);

        DataGrid table = new DataGrid(list, colDefs,
                ListSelectionModel.SINGLE_SELECTION, size);
        table.setup();
        table.addItemSelectionListener(this);

        // Create ScrollableDataGrid grid component
        ScrollableDataGrid dg = new ScrollableDataGrid(table);

        return dg;
    }

    public void updateView(Boolean data) {
        if (this.selectedClient == null) {
            return;
        }
        this.txtCntFirstName.setText(this.selectedClient.getContactFname());
        this.txtCntLastName.setText(this.selectedClient.getContactLname());
        this.txtCntAddr1.setText(this.selectedClient.getContactAddress1());
        this.txtCntAddr2.setText(this.selectedClient.getContactAddress2());
        this.txtCntAddr3.setText(this.selectedClient.getContactAddress3());
        this.lblCntCity.setText(this.selectedClient.getContactCity());
        this.lblCntState.setText(this.selectedClient.getContactState());
        this.txtCntZip.setText(String.valueOf(this.selectedClient
                .getContactZip()));
        this.txtCntPhone.setText(this.selectedClient.getContactPhone());
        this.txtCntFax.setText(this.selectedClient.getContactFax());

        this.txtBillFirstName.setText(this.selectedClient.getBillingFname());
        this.txtBillLastName.setText(this.selectedClient.getBillingLname());
        this.txtBillAddr1.setText(this.selectedClient.getBillingAddress1());
        this.txtBillAddr2.setText(this.selectedClient.getBillingAddress2());
        this.txtBillAddr3.setText(this.selectedClient.getBillingAddress3());
        this.lblBillCity.setText(this.selectedClient.getBillingCity());
        this.lblBillState.setText(this.selectedClient.getBillingState());
        this.txtBillZip.setText(String.valueOf(this.selectedClient
                .getBillingZip()));
        this.txtBillPhone.setText(this.selectedClient.getBillingPhone());
        this.txtBillFax.setText(this.selectedClient.getBillingFax());

        this.txtEmail.setText(this.selectedClient.getEmail());
        this.txtWebsite.setText(this.selectedClient.getWebsite());
        this.txtComments.setText(this.selectedClient.getComments());

        // Populate text fields or drop downs depending on how component is
        // used.
        if (readlOnly) {
            this.txtCntCompName.setText(this.selectedClient
                    .getContactCompanyName());
            this.txtBillCompName.setText(this.selectedClient
                    .getBillingCompanyName());
        }
        else {
            this.ddbCntCompany.selectItemByKey(this.selectedClient
                    .getContactCompany());
            this.ddbBillCompany.selectItemByKey(this.selectedClient
                    .getBillingCompany());
            String billExact = this.selectedClient.getIsBillingExcat();
            this.cbxDupBilling.setSelected(billExact != null
                    && billExact.equalsIgnoreCase("Y") ? true : false);
        }

        return;
    }

    /**
     * Creates a company drop down box.
     * 
     * @return
     */
    private DynamicDropDownBox<StatesCode> createStateDropDownBox() {
        DropDownBoxColumnDefinition col = new DropDownBoxColumnDefinition(
                "stateId", "longname", 0, 70);
        List<StatesCode> items = new ArrayList<StatesCode>();
        items.add(new StatesCode());
        DynamicDropDownBoxColumnModelBuilder<StatesCode> b = new DynamicDropDownBoxColumnModelBuilder<StatesCode>(
                items, col);
        DynamicDropDownBox<StatesCode> ddb = b.createInstance();
        return ddb;
    }

    private void copyContactInfoToBilling() {
        this.txtBillFirstName.setText(this.txtCntFirstName.getText());
        this.txtBillLastName.setText(this.txtCntLastName.getText());
        this.txtBillAddr1.setText(this.txtCntAddr1.getText());
        this.txtBillAddr2.setText(this.txtCntAddr2.getText());
        this.txtBillAddr3.setText(this.txtCntAddr3.getText());
        this.lblBillCity.setText(this.lblCntCity.getText());
        this.lblBillState.setText(this.lblCntState.getText());
        this.txtBillZip.setText(this.txtCntZip.getText());
        this.txtBillPhone.setText(this.txtCntPhone.getText());
        this.txtBillFax.setText(this.txtCntFax.getText());
        this.ddbBillCompany.setSelectedIndex(this.ddbCntCompany
                .getSelectedIndex());
    }

    /**
     * Handles user's request to perform client search based on selection
     * criteria entered.
     */
    public void doSearch() {

        CompanySearchCriteriaBean userInput = new CompanySearchCriteriaBean();
        String strVal = null;
        strVal = this.srchClientIdField.getText();
        if (!strVal.equals(RMT2String.spaces(strVal.length()))) {
            userInput.setClientId(strVal);
        }
        strVal = this.srchFirstNameField.getText();
        if (!strVal.equals(RMT2String.spaces(strVal.length()))) {
            userInput.setFirstName(strVal);
        }
        strVal = this.srchLastNameField.getText();
        if (!strVal.equals(RMT2String.spaces(strVal.length()))) {
            userInput.setLastName(strVal);
        }
        Business company = (Business) this.srchCompanyField.getSelectedItem();
        if (company != null
                && company.getId() != CharterOrderSearchFrame.NO_COMPANY_SELECTED) {
            userInput.setCompany(String.valueOf(company.getId()));
        }
        StatesCode state = (StatesCode) this.srchStateField.getSelectedItem();
        if (state != null && !state.getShortname().equals("XX")) {
            userInput.setState(state.getShortname());
        }
        strVal = this.srchCityField.getText();
        if (!strVal.equals(RMT2String.spaces(strVal.length()))) {
            userInput.setCity(strVal);
        }
        strVal = this.srchZipField.getText();
        if (!strVal.equals(RMT2String.spaces(strVal.length()))) {
            userInput.setZip(strVal);
        }
        strVal = this.srchPhoneField.getText();
        if (!strVal.equals(RMT2String.spaces(strVal.length()))) {
            userInput.setPhone(strVal);
        }

        Thread t = new Thread(new RetrieveDataThread(this, userInput));
        t.start();

        this.doResetResults();
    }

    private void doResetCriteria() {
        this.srchClientIdField.setText("");
        this.srchFirstNameField.setText("");
        this.srchLastNameField.setText("");
        this.srchCompanyField.setSelectedIndex(0);
        this.srchStateField.setSelectedIndex(0);
        this.srchCityField.setText("");
        this.srchZipField.setText("");
        this.srchPhoneField.setText("");
    }

    private void doResetResults() {
        this.txtCntFirstName.setText("");
        this.txtCntLastName.setText("");
        this.txtCntAddr1.setText("");
        this.txtCntAddr2.setText("");
        this.txtCntAddr3.setText("");
        this.lblCntCity.setText("");
        this.lblCntState.setText("");
        this.txtCntZip.setText("");
        this.txtCntPhone.setText("");
        this.txtCntFax.setText("");

        this.txtBillFirstName.setText("");
        this.txtBillLastName.setText("");
        this.txtBillAddr1.setText("");
        this.txtBillAddr2.setText("");
        this.txtBillAddr3.setText("");
        this.lblBillCity.setText("");
        this.lblBillState.setText("");
        this.txtBillZip.setText("");
        this.txtBillPhone.setText("");
        this.txtBillFax.setText("");

        this.txtEmail.setText("");
        this.txtWebsite.setText("");
        this.txtComments.setText("");
        this.lblMsg.setText("");

        if (this.readlOnly) {
            this.txtCntCompName.setText(RMT2String.spaces(60));
            this.txtBillCompName.setText(RMT2String.spaces(60));
        }
        else {
            this.ddbCntCompany.setSelectedIndex(0);
            this.ddbBillCompany.setSelectedIndex(0);
        }

        this.cbxDupBilling.setSelected(false);

        this.grid.getTableView().loadTable(new ArrayList<VwClientList>());
        this.selectedClient = null;
    }

    /**
     * Handles user's request to reset the component to its intial state.
     */
    public void doReset() {
        this.doResetCriteria();
        this.doResetResults();

    }

    /**
     * Handles user's request to add a client
     */
    public void doAdd() {
        this.doReset();
        this.selectedClient = new VwClientList();
    }

    /**
     * Handles user's request to delete a client
     */
    public void doDelete() {
        try {
            this.bo.deleteCompany(this.selectedClient.getClientId());
            int row = this.grid.getTableView().getSelectedRow();
            this.grid.getTableView().removeGridRow(row);
            // this.lblMsg.setText("Delete was successful!");
            FormUtil.showStatusMessage(this.lblMsg, "Delete was successful!",
                    false);
        } catch (Exception e) {
            FormUtil.showErrorMessageBox(this, e.getMessage(),
                    "Charter Order Client Delete Error");
        }
    }

    /**
     * Handles user's request to save changes..
     */
    public void doSave() {
        this.saveChanges();
    }

    /**
     * Handles user's request to cancel previous changes.
     */
    public void doCancel() {

    }

    /**
     * Handles user's request to return the select client to the caller
     */
    public VwClientList doReturn() {
        return this.selectedClient;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ui.event.CustomSelectionListener#handleDoubleClickedRow(com.ui.event
     * .CustomItemDoubleClickedEvent)
     */
    @Override
    public void handleDoubleClickedRow(CustomItemDoubleClickedEvent evt) {
        return;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ui.event.CustomSelectionListener#handleSelectionChanged(com.ui.event
     * .CustomItemSelectedEvent)
     */
    @Override
    public void handleSelectionChanged(CustomItemSelectedEvent evt) {
        this.selectedClient = (VwClientList) evt.getSelectedItem();
        this.updateView((Boolean) null);
        return;

    }

    /**
     * Thread for retrieving list of clients
     * 
     * @author appdev
     *
     */
    protected class RetrieveDataThread implements Runnable {
        private CompanySearchMaintComp parent;
        private CompanySearchCriteriaBean criteria;

        protected RetrieveDataThread(CompanySearchMaintComp parent,
                CompanySearchCriteriaBean data) {
            this.parent = parent;
            this.criteria = data;
        }

        @Override
        public void run() {
            // List<VwClientList> list = parent.bo.getClientInfo(criteria);
            // if (list == null) {
            // list = new ArrayList<VwClientList>();
            // }
            //
            // this.updateControls(list);
            return;
        }

        private void updateControls(final List<VwClientList> obj) {

            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    parent.grid.getTableView().loadTable(obj);
                    // parent.lblRowCount
                    // .setText(CharterOrderSearchFrame.ROW_COUNT_TEXT
                    // + obj.size());
                }
            });
        }
    }

    /**
     * Thread for retrieving zip code data.
     * 
     * @author appdev
     *
     */
    protected class RetrieveZipDataThread implements Runnable {
        private CompanySearchMaintComp parent;
        private VwClientList model;
        private String fieldName;
        private int zipcode;
        private int row;

        protected RetrieveZipDataThread(CompanySearchMaintComp parent,
                VwClientList model, String zipcode, String fieldName) {
            this.parent = parent;
            this.row = this.parent.grid.getTableView().getSelectedRow();
            this.model = model;
            this.fieldName = fieldName;
            if (RMT2Money.isNumeric(zipcode)) {
                this.zipcode = Integer.parseInt(zipcode);
            }
            else {
                this.zipcode = 0;
            }
        }

        @Override
        public void run() {
            CharterOrderBO cobo = new CharterOrderBO();
            List<Zipcode> zipList = cobo.getZipByZipcode(this.zipcode);
            cobo = null;
            if (zipList == null) {
                return;
            }
            this.updateControls(zipList.get(0));
        }

        private void updateControls(final Zipcode zip) {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    if (fieldName.equals("txtCntZip")) {
                        model.setContactZipId(zip.getZipId());
                        // model.setContactZip(zip.getZip());
                        // model.setContactCity(zip.getCity());
                        // model.setContactState(zip.getState());
                        parent.txtCntZip.setText(String.valueOf(zip.getZip()));
                        parent.lblCntCity.setText(zip.getCity());
                        parent.lblCntState.setText(zip.getState());
                    }
                    if (fieldName.equals("txtBillZip")) {
                        model.setBillingZipId(zip.getZipId());
                        parent.txtBillZip.setText(String.valueOf(zip.getZip()));
                        parent.lblBillCity.setText(zip.getCity());
                        parent.lblBillState.setText(zip.getState());
                        // model.setBillingZip(zip.getZip());
                        // model.setBillingCity(zip.getCity());
                        // model.setBillingState(zip.getState());
                    }
                    // parent.grid.getTableView().refreshGrid();
                    parent.grid.getTableView().scrollToVisible(row);
                }
            });
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ui.components.AbstractGuiComponentTemplate#saveChanges()
     */
    @Override
    public void saveChanges() {
        this.selectedClient.setContactFname(this.txtCntFirstName.getText());
        this.selectedClient.setContactLname(this.txtCntLastName.getText());

        Business contactCompany = (Business) this.ddbCntCompany
                .getSelectedItem();
        this.selectedClient.setContactCompany(contactCompany.getId());

        this.selectedClient.setContactAddress1(this.txtCntAddr1.getText());
        this.selectedClient.setContactAddress2(this.txtCntAddr2.getText());
        this.selectedClient.setContactAddress3(this.txtCntAddr3.getText());
        this.selectedClient.setContactZip(Integer.parseInt(this.txtCntZip
                .getText()));
        this.selectedClient.setContactPhone(this.txtCntPhone.getText());
        this.selectedClient.setContactFax(this.txtCntFax.getText());

        this.selectedClient.setBillingFname(this.txtBillFirstName.getText());
        this.selectedClient.setBillingLname(this.txtBillLastName.getText());

        Business billCompany = (Business) this.ddbBillCompany.getSelectedItem();
        this.selectedClient.setBillingCompany(billCompany.getId());

        this.selectedClient.setBillingAddress1(this.txtBillAddr1.getText());
        this.selectedClient.setBillingAddress2(this.txtBillAddr2.getText());
        this.selectedClient.setBillingAddress3(this.txtBillAddr3.getText());
        this.selectedClient.setBillingCity(this.lblBillCity.getText());
        this.selectedClient.setBillingState(this.lblBillState.getText());
        this.selectedClient.setBillingZip(Integer.parseInt(this.txtBillZip
                .getText()));
        this.selectedClient.setBillingPhone(this.txtBillPhone.getText());
        this.selectedClient.setBillingFax(this.txtBillFax.getText());

        this.selectedClient.setEmail(this.txtEmail.getText());
        this.selectedClient.setWebsite(this.txtWebsite.getText());
        this.selectedClient.setComments(this.txtComments.getText());
        this.selectedClient
                .setIsBillingExcat(this.cbxDupBilling.isSelected() ? "Y" : "N");

        try {
            // this.bo.updateClient(this.selectedClient);
            FormUtil.showStatusMessage(this.lblMsg, "Update was successful!",
                    false);
        } catch (Exception e) {
            FormUtil.showStatusMessage(this.lblMsg,
                    "Update of company failed: " + e.getMessage(), true);
        }
        return;

    }

    /**
     * Captures the contents of the contact and billing zip code fields in the
     * detail section of the window just before the user begins to make changes.
     * 
     * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
     */
    @Override
    public void focusGained(FocusEvent e) {
        String srcName = ((JTextField) e.getSource()).getName();
        if (srcName.equals(this.txtCntZip.getName())) {
            this.prevContactZip = this.txtCntZip.getText();
        }
        if (srcName.equals(this.txtBillZip.getName())) {
            this.prevBillZip = this.txtCntZip.getText();
        }
    }

    /**
     * Retrieves zip code data when user changes either the contact or billing
     * zip codes in the detail section of the window.
     * 
     * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
     */
    @Override
    public void focusLost(FocusEvent e) {
        String srcName = ((JTextField) e.getSource()).getName();
        if (srcName.equals(this.txtCntZip.getName())) {
            if (!this.txtCntZip.getText().equalsIgnoreCase(this.prevContactZip)) {
                RetrieveZipDataThread r = new RetrieveZipDataThread(this,
                        this.selectedClient, this.txtCntZip.getText(), srcName);
                Thread t = new Thread(r);
                t.start();
                return;
            }
        }
        if (srcName.equals(this.txtBillZip.getName())) {
            if (!this.txtBillZip.getText().equalsIgnoreCase(this.prevBillZip)) {
                RetrieveZipDataThread r = new RetrieveZipDataThread(this,
                        this.selectedClient, this.txtBillZip.getText(), srcName);
                Thread t = new Thread(r);
                t.start();
                return;
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("")) {
            if (((JCheckBox) e.getSource()).isSelected()) {
                this.copyContactInfoToBilling();
            }
        }

    }
}
