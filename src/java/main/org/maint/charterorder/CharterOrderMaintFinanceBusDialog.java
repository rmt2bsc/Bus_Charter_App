package org.maint.charterorder;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import net.miginfocom.swing.MigLayout;

import org.FormUtil;
import org.WindowConst;
import org.dao.BusCharterDaoConst;
import org.dao.mapping.BusDetail;
import org.dao.mapping.GeneralCodes;

import com.InvalidGuiDataException;
import com.ProcessDataFailureException;
import com.ui.components.dropdownbox.DynamicDropDownBox;
import com.ui.components.table.DataGrid;
import com.ui.components.table.DataGridModel;
import com.ui.components.table.ScrollableDataGrid;
import com.ui.components.table.TableColumnDefinition;
import com.ui.event.CustomItemDoubleClickedEvent;
import com.ui.event.CustomItemSelectedEvent;
import com.ui.event.CustomSelectionListener;
import com.ui.window.AbstractSdiModalWindow;
import com.ui.window.WindowActionListener;
import com.util.RMT2Money;

/**
 * @author rterrell
 *
 */
public class CharterOrderMaintFinanceBusDialog extends AbstractSdiModalWindow
        implements CustomSelectionListener, DocumentListener {

    private static final long serialVersionUID = 1746311868533836L;
    public static final String ACTION_COMMAND_BUSNO_CHANGED = "BUS NO CHANGED";
    public static final String ACTION_COMMAND_BUSDRIVER_CHANGED = "BUS DRIVER CHANGED";
    public static final String ACTION_COMMAND_MINHOURFACTOR_CHANGED = "MINIMUM HOULRY FACTOR CHANGED";
    public static final String ACTION_COMMAND_FLATRATE_CHANGED = "FLAT RATE CHANGED";
    public static final String ACTION_COMMAND_MILEAGERATE_CHANGED = "MILEAGE RATE CHANGED";
    public static final String ACTION_COMMAND_DEADHEADMILERATE_CHANGED = "DEAD HEAD MILE RATE CHANGED";
    public static final String ACTION_COMMAND_LIVEMILES_CHANGED = "LIVE MILES CHANGED";
    public static final String ACTION_COMMAND_DEADHEADMILE_CHANGED = "DEAD HEAD MILES CHANGED";
    public static final String ACTION_COMMAND_MINHOURRATE_CHANGED = "MINIMUM HOURLY RATE CHANGED";
    public static final String ACTION_COMMAND_EXTHOURRATE_CHANGED = "EXTENDED HOURLY RATE CHANGED";
    public static final String ACTION_COMMAND_TOTALHOURS_CHANGED = "TOTAL HOURS CHANGED";
    public static final String ACTION_COMMAND_SPECINSTRCT_CHANGED = "SPECIAL INSTRUCTIONS CHANGED";

    public static final String ADDBUS_RESULTS_KEY_TOTALCHARGES = "BUS_COST";
    public static final String ADDBUS_RESULTS_KEY_BUSES = "NEW_MODOFIED_BUSES";
    public static final String ADDBUS_RESULTS_KEY_DELETEDBUSES = "DELETED_BUSES";

    private ScrollableDataGrid grid;

    private List<BusDetail> busList;

    private int currentRow;

    private BusDetail currentBus;

    private DynamicDropDownBox<GeneralCodes> ddbMinHourlyFact;
    private JLabel lblMileageSubTot;
    private JLabel lblHourlySubTot;
    private JLabel lblBusTotal;
    private JLabel lblOrderId;
    private JTextField txtBusNo;
    private JTextField txtBusDriver;
    private JTextField txtFlatRate;
    private JTextField txtLiveMileRate;
    private JTextField txtDeadHeadMileRate;
    private JTextField txtLiveMiles;
    private JTextField txtDeadHeadMiles;
    private JTextField txtMinHourlyRate;
    private JTextField txtExtHourlyRate;
    private JTextField txtTotalHours;
    private JTextArea taSpecialInstruct;

    /**
     * The Command buttons
     */
    private JButton addButton;
    private JButton deleteButton;

    private CharterOrderBO bo;

    /**
     * Default constructor
     */
    protected CharterOrderMaintFinanceBusDialog() {
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
    public CharterOrderMaintFinanceBusDialog(String winTitle, Object data,
            Dimension size, Point pos) {
        super((Dialog) null, data, size, pos, winTitle);
        // this.deletedBusList = new ArrayList<BusDetail>();
        return;
    }

    @Override
    protected void initDialog() {
        this.bo = new CharterOrderBO();
        if (this.inData instanceof List) {
            this.busList = (List) this.inData;
        }

        super.initDialog();

        // Add buttons to button pane
        this.remove(this.cancelButton);
        this.okButton.setText("Return");
        this.okButton
                .setActionCommand(WindowActionListener.ACTION_COMMAND_PROCESS_CLOSE);
        this.addButton = new JButton("Add");
        this.deleteButton = new JButton("Delete");
        this.addButton.setActionCommand(WindowConst.CLIENT_MAINT_ACTION_ADD);
        this.addButton.addActionListener(this);
        this.deleteButton
                .setActionCommand(WindowConst.CLIENT_MAINT_ACTION_DELETE);
        this.deleteButton.addActionListener(this);

        this.buttonPane.add(this.addButton);
        this.buttonPane.add(this.deleteButton);
        this.buttonPane.add(this.cancelButton);
    }

    private void initializeFields() {
        this.lblMileageSubTot = FormUtil.createDataLabel(null, true,
                Color.BLUE, FormUtil.STD_TEXT_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.RIGHT);
        this.lblHourlySubTot = FormUtil.createDataLabel(null, true, Color.BLUE,
                FormUtil.STD_TEXT_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.RIGHT);
        this.lblBusTotal = FormUtil.createDataLabel(null, true, Color.RED,
                FormUtil.STD_TEXT_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.RIGHT);

        // Populate drop downs
        List<GeneralCodes> hourlyFactorItems = this.bo
                .getLookupCodeByGroup(BusCharterDaoConst.LOOKUP_GRP_MINHOURFACTOR);
        this.ddbMinHourlyFact = FormUtil.createGeneralCodesDDB(
                hourlyFactorItems, null, 180);
        this.ddbMinHourlyFact
                .setActionCommand(CharterOrderMaintFinanceComp.ACTION_COMMAND_MINHOURFACTOR_CHANGED);
        this.ddbMinHourlyFact.addActionListener(this);

        this.lblOrderId = FormUtil.createDataLabel(null, true, Color.BLUE, 40,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.LEFT);

        this.txtBusNo = FormUtil.createTextField(this, null, false, 60,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.LEFT);
        this.txtBusNo.getDocument().addDocumentListener(this);
        this.txtBusNo.getDocument().putProperty("name",
                CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_BUSNO_CHANGED);

        this.txtBusDriver = FormUtil.createTextField(this, null, false, 180,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.LEFT);
        this.txtBusDriver.getDocument().addDocumentListener(this);
        this.txtBusDriver
                .getDocument()
                .putProperty(
                        "name",
                        CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_BUSDRIVER_CHANGED);

        this.txtFlatRate = FormUtil.createTextField(this, null, false,
                FormUtil.STD_TEXT_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.RIGHT);
        this.txtFlatRate.getDocument().addDocumentListener(this);
        this.txtFlatRate
                .getDocument()
                .putProperty(
                        "name",
                        CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_FLATRATE_CHANGED);

        this.txtLiveMileRate = FormUtil.createTextField(this, null, false,
                FormUtil.STD_TEXT_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.RIGHT);
        this.txtLiveMileRate.getDocument().addDocumentListener(this);
        this.txtLiveMileRate
                .getDocument()
                .putProperty(
                        "name",
                        CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_MILEAGERATE_CHANGED);
        this.txtDeadHeadMileRate = FormUtil.createTextField(this, null, false,
                FormUtil.STD_TEXT_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.RIGHT);
        this.txtDeadHeadMileRate.getDocument().addDocumentListener(this);
        this.txtDeadHeadMileRate
                .getDocument()
                .putProperty(
                        "name",
                        CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_DEADHEADMILERATE_CHANGED);

        this.txtLiveMiles = FormUtil.createTextField(this, null, false,
                FormUtil.STD_TEXT_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.RIGHT);
        this.txtLiveMiles.getDocument().addDocumentListener(this);
        this.txtLiveMiles
                .getDocument()
                .putProperty(
                        "name",
                        CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_LIVEMILES_CHANGED);

        this.txtDeadHeadMiles = FormUtil.createTextField(this, null, false,
                FormUtil.STD_TEXT_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.RIGHT);
        this.txtDeadHeadMiles.getDocument().addDocumentListener(this);
        this.txtDeadHeadMiles
                .getDocument()
                .putProperty(
                        "name",
                        CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_DEADHEADMILE_CHANGED);

        this.txtMinHourlyRate = FormUtil.createTextField(this, null, false,
                FormUtil.STD_TEXT_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.RIGHT);
        this.txtMinHourlyRate.getDocument().addDocumentListener(this);
        this.txtMinHourlyRate
                .getDocument()
                .putProperty(
                        "name",
                        CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_MINHOURRATE_CHANGED);

        this.txtExtHourlyRate = FormUtil.createTextField(this, null, false,
                FormUtil.STD_TEXT_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.RIGHT);
        this.txtExtHourlyRate.getDocument().addDocumentListener(this);
        this.txtExtHourlyRate
                .getDocument()
                .putProperty(
                        "name",
                        CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_EXTHOURRATE_CHANGED);

        this.txtTotalHours = FormUtil.createTextField(this, null, false,
                FormUtil.STD_TEXT_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.RIGHT);
        this.txtTotalHours.getDocument().addDocumentListener(this);
        this.txtTotalHours
                .getDocument()
                .putProperty(
                        "name",
                        CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_TOTALHOURS_CHANGED);

        this.taSpecialInstruct = FormUtil.createTextArea(this, null, false, 5);
        this.taSpecialInstruct.setPreferredSize(new Dimension(450, 130));
        this.taSpecialInstruct.getDocument().addDocumentListener(this);
        this.taSpecialInstruct
                .getDocument()
                .putProperty(
                        "name",
                        CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_SPECINSTRCT_CHANGED);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ui.window.WindowActionListener#createContentLayout()
     */
    @Override
    public JPanel createContentLayout() {
        // Setup the main panel with criteria and results sections
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new MigLayout("", "[grow]", "[][][]"));

        this.initializeFields();
        this.grid = this.buildSection1();
        JPanel sect1 = this.buildSection2();
        JPanel sect2 = this.buildSection3();
        JPanel sect3 = this.buildSection4();
        mainPanel.add(this.grid, "wrap, wrap");
        mainPanel.add(sect1, "wrap, wrap");
        mainPanel.add(sect2, "wrap, wrap");
        mainPanel.add(sect3, "wrap, wrap");
        return mainPanel;
    }

    private ScrollableDataGrid buildSection1() {
        // Build grid with data
        ScrollableDataGrid g = this.createDataGrid(this.busList);
        return g;
    }

    private JPanel buildSection2() {
        JPanel sect = new JPanel();
        sect.setLayout(new MigLayout("", "[][][]", "[]"));
        sect.add(FormUtil.createHeaderLabel("Order Id:"), "right, top");
        sect.add(this.lblOrderId, "center");
        sect.add(FormUtil.createHeaderLabel("Bus Number:"), "right, top");
        sect.add(this.txtBusNo, "center");
        sect.add(FormUtil.createHeaderLabel("Bus Driver:"), "right, top");
        sect.add(this.txtBusDriver, "center, wrap");
        return sect;
    }

    private JPanel buildSection3() {
        JPanel sect = new JPanel();
        sect.setLayout(new MigLayout("", "[][]", "[]"));
        FormUtil.addPanelTitle(sect, "Bus Charge Details", Color.BLUE);

        sect.add(FormUtil.createHeaderLabel("Base Cost:"), "right, top");
        sect.add(this.txtFlatRate, "top, left, wrap");

        // Build Milage Charges
        JPanel milagePanel = new JPanel();
        milagePanel
                .setLayout(new MigLayout("", "[][115:115:115]", "[][][][][]"));
        FormUtil.addPanelTitle(milagePanel, "Milage Cost", Color.BLUE);

        milagePanel.add(FormUtil.createHeaderLabel("Live Mileage Rate:"),
                "right, top");
        milagePanel.add(this.txtLiveMileRate, "top, wrap");
        milagePanel.add(FormUtil.createHeaderLabel("Dead Head Mileage Rate:"),
                "right, top");
        milagePanel.add(this.txtDeadHeadMileRate, "top, wrap");
        milagePanel
                .add(FormUtil.createHeaderLabel("Live Miles:"), "right, top");
        milagePanel.add(this.txtLiveMiles, "top, wrap");
        milagePanel
                .add(FormUtil.createHeaderLabel("Dead Miles:"), "right, top");
        milagePanel.add(this.txtDeadHeadMiles, "top, wrap");
        milagePanel.add(FormUtil.createHeaderLabel("Mileage Sub Total:"),
                "right, top");
        milagePanel.add(this.lblMileageSubTot, "top, wrap");

        // Build Milage Charges
        JPanel hourlyPanel = new JPanel();
        hourlyPanel
                .setLayout(new MigLayout("", "[][125:125:125]", "[][][][][]"));
        FormUtil.addPanelTitle(hourlyPanel, "Hourly Cost", Color.BLUE);

        hourlyPanel.add(FormUtil.createHeaderLabel("Minimum Hour Factor:"),
                "right, top");
        hourlyPanel.add(this.ddbMinHourlyFact, "top, wrap");
        hourlyPanel.add(FormUtil.createHeaderLabel("Minimum Hourly Rate:"),
                "right, top");
        hourlyPanel.add(this.txtMinHourlyRate, "top, wrap");
        hourlyPanel.add(FormUtil.createHeaderLabel("Extended Hourly Rate:"),
                "right, top");
        hourlyPanel.add(this.txtExtHourlyRate, "top, wrap");
        hourlyPanel.add(FormUtil.createHeaderLabel("Total Hours:"),
                "right, top");
        hourlyPanel.add(this.txtTotalHours, "top, wrap");
        hourlyPanel.add(FormUtil.createHeaderLabel("Hourly Sub Total:"),
                "right, top");
        hourlyPanel.add(this.lblHourlySubTot, "top, wrap");

        sect.add(milagePanel, "span 2");
        sect.add(hourlyPanel, "span 2, wrap");
        sect.add(FormUtil.createHeaderLabel("Total Cost for Bus:"),
                "right, top");
        sect.add(this.lblBusTotal);

        return sect;
    }

    private JPanel buildSection4() {
        JPanel sect = new JPanel();
        sect.setLayout(new MigLayout("", "[]", "[]"));

        sect.add(FormUtil.createHeaderLabel("Special Instructions:", true),
                "right, top");
        sect.add(this.taSpecialInstruct, "growx, left, wrap");
        return sect;
    }

    /**
     * Creates the structure of the ScrollableDataGrid based on the List of data
     * items representing the grid data to be displayed.
     * 
     * @param list
     *            the data to be displayed.
     * @return an instance of {@link ScrollableDataGrid}
     */
    private ScrollableDataGrid createDataGrid(List<BusDetail> list) {

        // Setup column definitions
        List<TableColumnDefinition> colDefs = new ArrayList<TableColumnDefinition>();
        colDefs.add(new TableColumnDefinition("id", "Bus Id", 0, 80));
        colDefs.add(new TableColumnDefinition("busNumber", "Bus Number", 1, 120));
        colDefs.add(new TableColumnDefinition("driverName", "Bus Driver Name",
                2, 200));

        // Set the size of the data grid component
        Dimension size = new Dimension(400, 150);

        DataGrid table = new DataGrid(list, colDefs,
                ListSelectionModel.SINGLE_SELECTION, size);
        table.setup();
        table.addItemSelectionListener(this);

        // Identify those columns that need to use special comparators for
        // sorting.
        int numericCols[] = { 0 };
        table.setNumericColumnSorter(numericCols);

        // Create ScrollableDataGrid grid component
        ScrollableDataGrid dg = new ScrollableDataGrid(table);

        return dg;
    }

    /**
     * Returns the list of buses to process.
     * 
     * @return an List<{@link BusDetail}> objects
     * @throws InvalidGuiDataException
     */
    @Override
    public Object getInputData() throws InvalidGuiDataException {
        return this.busList;
    }

    /**
     * Sums to total charges of each bus and returns the summed charges to the
     * caller.
     * 
     * @param data
     *            an instance of List containing {@link BusDetail} objects
     * @return a Map<String, Object> containing a list of deleted buses and the
     *         total cost of the remaining buses. The list of deleted buses will
     *         be of type List<{@link BusDetail}> and keyed as
     *         {@link CharterOrderMaintFinanceBusDialog#ADDBUS_RESULTS_KEY_DELETEDBUSES}
     *         . The remaining bus cost value is of type Double and is keyed as
     *         {@link CharterOrderMaintFinanceBusDialog#ADDBUS_RESULTS_KEY_TOTALCHARGES}
     *         .
     * @throws ProcessDataFailureException
     */
    @Override
    public Object processData(Object data) throws ProcessDataFailureException {
        List<BusDetail> bus = null;
        if (data instanceof List) {
            bus = (List<BusDetail>) data;
        }
        double totalCharges = 0;
        int busCount = bus.size();
        for (int ndx = 0; ndx < busCount; ndx++) {
            this.currentBus = bus.get(ndx);
            totalCharges += this.calculateTotals();
        }
        DataGridModel dgm = (DataGridModel) this.grid.getTableView().getModel();
        Map<String, Object> dialogResults = new HashMap<String, Object>();
        dialogResults
                .put(CharterOrderMaintFinanceBusDialog.ADDBUS_RESULTS_KEY_TOTALCHARGES,
                        totalCharges);
        dialogResults.put(
                CharterOrderMaintFinanceBusDialog.ADDBUS_RESULTS_KEY_BUSES,
                dgm.getViewBuf());
        dialogResults
                .put(CharterOrderMaintFinanceBusDialog.ADDBUS_RESULTS_KEY_DELETEDBUSES,
                        dgm.getDeletedBuf());

        return dialogResults;
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
            case WindowConst.CLIENT_MAINT_ACTION_ADD:
                this.addBusToList();
                break;
            case WindowConst.CLIENT_MAINT_ACTION_DELETE:
                this.deleteBusFromList();
                break;
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_MINHOURFACTOR_CHANGED:
                if (e.getSource() instanceof DynamicDropDownBox) {
                    GeneralCodes code = (GeneralCodes) ((DynamicDropDownBox) e
                            .getSource()).getSelectedItem();
                    this.currentBus.setMinHourFactor(code.getCodeId());
                }
                this.calculateTotals();
                break;
        }

    }

    /**
     * 
     */
    private void addBusToList() {
        BusDetail bus = new BusDetail();
        int row = this.grid.getTableView().addGridRow(bus);
        this.grid.getTableView().setRowSelectionInterval(row, row);
        // this.grid.refreshGrid();
        return;
    }

    /**
     * 
     */
    private void deleteBusFromList() {
        int row = this.grid.getTableView().getSelectedRow();
        BusDetail bus = (BusDetail) this.grid.getTableView()
                .getSelectedRowData(row);
        if (bus != null) {
            // this.deletedBusList.add(bus);
            this.grid.getTableView().removeGridRow(row);
        }
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
        FormUtil.showInfoMessageBox(this, "handleDoubleClickedRow Event",
                "Row was double clicked");

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
        this.currentBus = (BusDetail) evt.getSelectedItem();
        this.currentRow = evt.getSelectedRowIndex();
        this.updateView();
        this.calculateTotals();
        return;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.event.DocumentListener#changedUpdate(javax.swing.event.
     * DocumentEvent)
     */
    @Override
    public void changedUpdate(DocumentEvent e) {
        this.handleTextFieldChange(e);
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.event.DocumentListener#insertUpdate(javax.swing.event.
     * DocumentEvent)
     */
    @Override
    public void insertUpdate(DocumentEvent e) {
        this.handleTextFieldChange(e);
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.event.DocumentListener#removeUpdate(javax.swing.event.
     * DocumentEvent)
     */
    @Override
    public void removeUpdate(DocumentEvent e) {
        this.handleTextFieldChange(e);
    }

    private void handleTextFieldChange(DocumentEvent e) {
        String val = null;
        boolean doCalc = true;
        if (this.currentBus == null) {
            return;
        }
        try {
            val = e.getDocument().getText(0, e.getDocument().getLength());
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
        Object name = e.getDocument().getProperty("name");
        switch (name.toString()) {
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_BUSNO_CHANGED:
                if (RMT2Money.isNumeric(val)) {
                    this.currentBus.setBusNumber(Integer.parseInt(val));
                    this.grid.getTableView().repaint();
                    doCalc = false;
                }
                break;
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_BUSDRIVER_CHANGED:
                this.currentBus.setDriverName(val);
                this.grid.getTableView().repaint();
                doCalc = false;
                break;
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_FLATRATE_CHANGED:
                if (RMT2Money.isNumeric(val)) {
                    this.currentBus.setFlatRate(Double.parseDouble(val));
                }
                break;
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_MILEAGERATE_CHANGED:
                if (RMT2Money.isNumeric(val)) {
                    this.currentBus.setMilageRate(Double.parseDouble(val));
                }
                break;
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_DEADHEADMILERATE_CHANGED:
                if (RMT2Money.isNumeric(val)) {
                    this.currentBus.setDeadheadMilageRate(Double
                            .parseDouble(val));
                }
                break;
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_LIVEMILES_CHANGED:
                if (RMT2Money.isNumeric(val)) {
                    this.currentBus.setLiveMiles(Integer.parseInt(val));
                }
                break;
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_DEADHEADMILE_CHANGED:
                if (RMT2Money.isNumeric(val)) {
                    this.currentBus.setDeadheadMiles(Integer.parseInt(val));
                }
                break;
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_MINHOURRATE_CHANGED:
                if (RMT2Money.isNumeric(val)) {
                    this.currentBus.setHourlyRate(Double.parseDouble(val));
                }
                break;
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_EXTHOURRATE_CHANGED:
                if (RMT2Money.isNumeric(val)) {
                    this.currentBus.setHourlyRate2(Double.parseDouble(val));
                }
                break;
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_TOTALHOURS_CHANGED:
                if (RMT2Money.isNumeric(val)) {
                    this.currentBus.setTotalHours(Integer.parseInt(val));
                }
                break;
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_SPECINSTRCT_CHANGED:
                this.currentBus.setInstructions(val);
                break;
        }
        if (doCalc) {
            this.calculateTotals();
        }
        return;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ui.window.AbstractSdiModalWindow#updateView()
     */
    @Override
    public void updateView() {
        super.updateView();
        if (this.currentBus == null) {
            return;
        }

        // Populate drop downs
        this.ddbMinHourlyFact.selectItemByKey(this.currentBus
                .getMinHourFactor());
        this.lblOrderId.setText(String.valueOf(this.currentBus.getOrdersId()));
        this.txtBusNo.setText(String.valueOf(this.currentBus.getBusNumber()));
        this.txtBusDriver.setText(this.currentBus.getDriverName());
        this.txtFlatRate.setText(String.valueOf(this.currentBus.getFlatRate()));
        this.txtLiveMileRate.setText(String.valueOf(this.currentBus
                .getMilageRate()));
        this.txtDeadHeadMileRate.setText(String.valueOf(this.currentBus
                .getDeadheadMilageRate()));
        this.txtLiveMiles
                .setText(String.valueOf(this.currentBus.getLiveMiles()));
        this.txtDeadHeadMiles.setText(String.valueOf(this.currentBus
                .getDeadheadMiles()));
        this.txtMinHourlyRate.setText(String.valueOf(this.currentBus
                .getHourlyRate()));
        this.txtExtHourlyRate.setText(String.valueOf(this.currentBus
                .getHourlyRate2()));
        this.txtTotalHours.setText(String.valueOf(this.currentBus
                .getTotalHours()));
        this.taSpecialInstruct.setText(currentBus.getInstructions());

    }

    /**
     * Performs caluclations for all buses targeting the hourly sub total,
     * milage sub total, and trip total fields.
     */
    protected double calculateTotals() {
        // When a row has been deleted, there is no current bus object. This
        // holds true when all rows have been deleted.
        if (this.currentBus == null) {
            return 0;
        }
        double busTotal = this.bo.calculateBusCharge(this.currentBus);
        double mileSubTotal = this.bo
                .calculateBusMileageCharge(this.currentBus);
        double hourlySubTotal = this.bo
                .calculateBusHourlyCharge(this.currentBus);

        this.lblHourlySubTot.setText(RMT2Money.formatNumber(
                Double.valueOf(hourlySubTotal), "#,##0.00"));
        this.lblMileageSubTot.setText(RMT2Money.formatNumber(
                Double.valueOf(mileSubTotal), "#,##0.00"));
        this.lblBusTotal.setText(RMT2Money.formatNumber(
                Double.valueOf(busTotal), "#,##0.00"));

        return busTotal;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ui.window.AbstractSdiModalWindow#closeWithoutProcessingAction(java
     * .awt.event.ActionEvent)
     */
    @Override
    protected void closeWithoutProcessingAction(ActionEvent e) {
        this.setResults(null);
        super.closeWithoutProcessingAction(e);
    }

    // private class RetrieveDataThread implements Runnable {
    // private CharterOrderMaintFinanceBusDialog parent;
    // private BusDetail bus;
    //
    // protected RetrieveDataThread(CharterOrderMaintFinanceBusDialog parent,
    // BusDetail bus) {
    // this.parent = parent;
    // this.bus = bus;
    // }
    //
    // @Override
    // public void run() {
    // this.updateControls();
    // parent.calculateTotals();
    // return;
    // }
    //
    // private void updateControls() {
    // parent.ddbMinHourlyFact.selectItemByKey(bus.getMinHourFactor());
    // parent.lblOrderId.setText(String.valueOf(bus.getOrdersId()));
    // parent.txtBusNo.setText(String.valueOf(bus.getBusNumber()));
    // parent.txtBusDriver.setText(bus.getDriverName());
    // parent.txtFlatRate.setText(String.valueOf(bus.getFlatRate()));
    // parent.txtLiveMileRate.setText(String.valueOf(bus.getMilageRate()));
    // parent.txtDeadHeadMileRate.setText(String.valueOf(bus
    // .getDeadheadMilageRate()));
    // parent.txtLiveMiles.setText(String.valueOf(bus.getLiveMiles()));
    // parent.txtDeadHeadMiles.setText(String.valueOf(bus
    // .getDeadheadMiles()));
    // parent.txtMinHourlyRate
    // .setText(String.valueOf(bus.getHourlyRate()));
    // parent.txtExtHourlyRate
    // .setText(String.valueOf(bus.getHourlyRate2()));
    // parent.txtTotalHours.setText(String.valueOf(bus.getTotalHours()));
    // parent.taSpecialInstruct.setText(bus.getInstructions());
    // }
    // }

}
