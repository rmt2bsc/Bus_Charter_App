package org.maint.charterorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import net.miginfocom.swing.MigLayout;

import org.FormUtil;
import org.dao.BusCharterDao;
import org.dao.BusCharterDaoConst;
import org.dao.BusCharterDaoFactory;
import org.dao.mapping.BusDetail;
import org.dao.mapping.GeneralCodes;
import org.dao.mapping.Orders;
import org.dao.mapping.Quote;

import com.ui.components.AbstractGuiComponentTemplate;
import com.ui.components.dropdownbox.DynamicDropDownBox;
import com.util.RMT2Money;
import com.util.RMT2String;

/**
 * A component for displaying and associating trip data with the Charter Order.
 * <p>
 * Depending on the charter order status, the information displayed in this
 * component can be read only or editable based on passing a valid {@link Quote}
 * object to its constructor when managing an existing Charter Order.
 * 
 * @author Roy Terrell
 *
 */
public class CharterOrderMaintFinanceComp extends
        AbstractGuiComponentTemplate<CharterOrderMaintParmsBean> implements
        ActionListener, DocumentListener {

    private static final long serialVersionUID = 4885982443482429370L;

    public static final int EVENT_ID_TOTAL_COST_CHANGED = 106;

    /**
     * The action command to open Add Bus window.
     */
    public static final String ACTION_COMMAND_OPEN_ADD_BUS = "OPEN_ADD_BUS";
    public static final String ACTION_COMMAND_ADDBUSCHARGES_CHANGED = "ADDITIONAL BUS CHARGES HANGED";
    public static final String ACTION_COMMAND_MINHOURFACTOR_CHANGED = "MINIMUM HOULRY FACTOR CHANGED";
    public static final String ACTION_COMMAND_FLATRATE_CHANGED = "FLAT RATE CHANGED";
    public static final String ACTION_COMMAND_MILEAGERATE_CHANGED = "MILEAGE RATE CHANGED";
    public static final String ACTION_COMMAND_DEADHEADMILERATE_CHANGED = "DEAD HEAD MILE RATE CHANGED";
    public static final String ACTION_COMMAND_LIVEMILES_CHANGED = "LIVE MILES CHANGED";
    public static final String ACTION_COMMAND_DEADHEADMILE_CHANGED = "DEAD HEAD MILES CHANGED";
    public static final String ACTION_COMMAND_MINHOURRATE_CHANGED = "MINIMUM HOURLY RATE CHANGED";
    public static final String ACTION_COMMAND_EXTHOURRATE_CHANGED = "EXTENDED HOURLY RATE CHANGED";
    public static final String ACTION_COMMAND_TOTALHOURS_CHANGED = "TOTAL HOURS CHANGED";
    public static final String ACTION_COMMAND_BUSNUMBER_CHANGED = "BUS NUMBER CHANGED";
    public static final String ACTION_COMMAND_BUSDRIVER_CHANGED = "BUS DRIVER CHANGED";

    private Orders order;
    private Quote quote;
    private List<BusDetail> busList;
    private List<BusDetail> deletedBusList;

    private CharterOrderBO bo;

    private JButton butAddBus;
    private JLabel lblTripId;
    private JLabel lblOrderId;
    private JLabel lblAddBusCharges;
    private JLabel lblMileageSubTot;
    private JLabel lblHourlySubTot;
    private JLabel lblTripTotal;

    private JCheckBox cbxDropOffCollect;
    private DynamicDropDownBox<GeneralCodes> ddbDropOffCollectTender;
    private DynamicDropDownBox<GeneralCodes> ddbMinHourlyFact;

    private JTextField txtClientOrderNo;
    private JTextField txtFlatRate;
    private JTextField txtLiveMileRate;
    private JTextField txtDeadHeadMileRate;
    private JTextField txtLiveMiles;
    private JTextField txtDeadHeadMiles;
    private JTextField txtMinHourlyRate;
    private JTextField txtExtHourlyRate;
    private JTextField txtTotalHours;
    private JTextField txtRequiredDeposit;

    /**
     * 
     */
    public CharterOrderMaintFinanceComp(CharterOrderMaintParmsBean orders) {
        super(orders);
        return;
    }

    protected void initFields() {
        this.bo = new CharterOrderBO();

        this.lblTripId = FormUtil.createDataLabel(null, true, Color.BLUE);
        this.lblOrderId = FormUtil.createDataLabel(null, true, Color.BLUE);
        this.lblAddBusCharges = FormUtil.createDataLabel(null, true,
                Color.BLACK);
        this.lblMileageSubTot = FormUtil.createDataLabel(null, true,
                Color.BLUE, FormUtil.STD_TEXT_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.RIGHT);
        this.lblHourlySubTot = FormUtil.createDataLabel(null, true, Color.BLUE,
                FormUtil.STD_TEXT_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.RIGHT);
        this.lblTripTotal = FormUtil.createDataLabel(null, true, Color.RED,
                FormUtil.STD_TEXT_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.RIGHT);

        this.cbxDropOffCollect = FormUtil.createCheckBox("Drop Off Collection",
                SwingConstants.LEFT, false, true);

        List<GeneralCodes> tenderItems = this.bo
                .getLookupCodeByGroup(BusCharterDaoConst.LOOKUP_GRP_TENDERCODE);
        this.ddbDropOffCollectTender = FormUtil.createGeneralCodesDDB(
                tenderItems, null, 180);
        List<GeneralCodes> hourlyFactorItems = this.bo
                .getLookupCodeByGroup(BusCharterDaoConst.LOOKUP_GRP_MINHOURFACTOR);
        this.ddbMinHourlyFact = FormUtil.createGeneralCodesDDB(
                hourlyFactorItems, null, 180);
        this.ddbMinHourlyFact
                .setActionCommand(CharterOrderMaintFinanceComp.ACTION_COMMAND_MINHOURFACTOR_CHANGED);
        this.ddbMinHourlyFact.addActionListener(this);

        this.txtClientOrderNo = FormUtil.createTextField(this, null, false,
                FormUtil.STD_TEXT_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.LEFT);
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
        this.txtRequiredDeposit = FormUtil.createTextField(this, null, false,
                FormUtil.STD_TEXT_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.RIGHT);

        this.butAddBus = new JButton("Add Bus");
        this.butAddBus.addActionListener(this);
        this.butAddBus
                .setActionCommand(CharterOrderMaintFinanceComp.ACTION_COMMAND_OPEN_ADD_BUS);
        // this.butGenInvoice = new JButton("Generate Invoice");
        // this.butGenInvoice.addActionListener(this);
        // this.butGenInvoice
        // .setActionCommand(CharterOrderMaintFinanceComp.ACTION_COMMAND_GEN_INVOICE);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.maint.charterorder.AbstractGuiComponentTemplate#setupView()
     */
    @Override
    protected void setupView() {
        JPanel sect1 = this.buildSection1();
        JPanel sect2 = this.buildSection2();
        // JPanel sect3 = this.buildSection3();
        this.add(sect1, "wrap, wrap");
        this.add(sect2, "wrap, wrap");
        // this.add(sect3, "wrap, wrap");
    }

    private JPanel buildSection1() {
        JPanel sect = new JPanel();
        sect.setLayout(new MigLayout("", "[][]20[][]20[][]20[][]20[][]", "[][]"));

        sect.add(FormUtil.createHeaderLabel("Order Id:"), "right, center");
        sect.add(this.lblOrderId, "center, left");

        sect.add(FormUtil.createHeaderLabel("Trip Id:"), "right, center");
        sect.add(this.lblTripId, "center");

        sect.add(FormUtil.createHeaderLabel("Client Order No.:"),
                "right, center");
        sect.add(this.txtClientOrderNo, "center");

        // Add check box
        sect.add(this.cbxDropOffCollect, "span 2");

        sect.add(FormUtil.createHeaderLabel("Drop Off Collection Tender:"),
                "right, center");
        sect.add(this.ddbDropOffCollectTender, "center");

        return sect;
    }

    private JPanel buildSection2() {
        JPanel sect = new JPanel();
        sect.setLayout(new MigLayout("", "[][]20[][]20[][]", "[][][]"));
        FormUtil.addPanelTitle(sect, "Trip Charges", Color.BLUE);

        sect.add(FormUtil.createHeaderLabel("Base Cost Per Bus:"), "right, top");
        sect.add(this.txtFlatRate, "top, left");

        sect.add(FormUtil.createHeaderLabel("Additonal Bus Charges:"),
                "right, top");
        sect.add(this.lblAddBusCharges, "top, left");

        sect.add(this.butAddBus, "top, left, span 2, wrap");

        // Build Milage Charges
        JPanel milagePanel = new JPanel();
        milagePanel
                .setLayout(new MigLayout("", "[][120:120:120]", "[][][][][]"));
        FormUtil.addPanelTitle(milagePanel, "Per/Bus Milage Cost", Color.BLUE);

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
                .setLayout(new MigLayout("", "[][130:130:130]", "[][][][][]"));
        FormUtil.addPanelTitle(hourlyPanel, "Per/Bus Hourly Cost", Color.BLUE);

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
        sect.add(FormUtil.createHeaderLabel("Trip Total for All Buses:"),
                "right, top");
        sect.add(this.lblTripTotal);
        sect.add(FormUtil.createHeaderLabel("Required Deposit:"), "right, top");
        sect.add(this.txtRequiredDeposit);

        return sect;
    }

    // private JPanel buildSection3() {
    // JPanel sect = new JPanel();
    // sect.setLayout(new MigLayout("", "[]", "[]"));
    //
    // sect.add(this.butGenInvoice, "right, top");
    // return sect;
    // }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.maint.charterorder.AbstractGuiComponentTemplate#updateView(java.util
     * .List)
     */
    @Override
    public void updateView(CharterOrderMaintParmsBean parms) {
        RetrieveDataThread t = new RetrieveDataThread(this, parms);
        t.fetchData();

        // Thread thread = new Thread(t);
        // thread.start();
        // try {
        // thread.join(200);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }

        // EventQueue.invokeLater(t);

        // this.order = this.bo.getOrderInfo(parms.getOrderId());
        // if (this.order == null) {
        // this.order = new Orders();
        // }
        // this.quote = this.bo.getTripInfo(parms.getQuoteId());
        // if (this.quote == null) {
        // this.quote = new Quote();
        // }
        // this.busList = this.bo.getOrderBusInfo(parms.getOrderId());
        //
        // this.updateView();
    }

    // public void updateView() {
    // this.lblOrderId.setText(String.valueOf(this.order.getId()));
    // this.lblTripId.setText(String.valueOf(this.order.getQuoteId()));
    // this.txtClientOrderNo.setText(this.order.getClientOrderId());
    // this.txtFlatRate.setText(String.valueOf(this.order.getFlatRate()));
    // this.lblAddBusCharges.setText(String.valueOf(this.order.getBuscost()));
    //
    // this.txtLiveMileRate
    // .setText(String.valueOf(this.order.getMilageRate()));
    // this.txtDeadHeadMileRate.setText(String.valueOf(this.order
    // .getDeadheadMilageRate()));
    // this.txtLiveMiles.setText(String.valueOf(this.order.getLiveMiles()));
    // this.txtDeadHeadMiles.setText(String.valueOf(this.order
    // .getDeadheadMiles()));
    // this.txtMinHourlyRate
    // .setText(String.valueOf(this.order.getHourlyRate()));
    // this.txtExtHourlyRate.setText(String.valueOf(this.order
    // .getHourlyRate2()));
    // this.txtTotalHours.setText(String.valueOf(this.order.getTotalHours()));
    // this.txtRequiredDeposit.setText(String.valueOf(this.order
    // .getRequiredDeposit()));
    //
    // this.ddbDropOffCollectTender.selectItemByKey(this.order
    // .getDropoffCollectTender());
    //
    // this.calculateTotals();
    // }

    public void updateView(Orders obj) {
        this.lblOrderId.setText(String.valueOf(obj.getId()));
        this.lblTripId.setText(String.valueOf(obj.getQuoteId()));
        this.txtClientOrderNo.setText(obj.getClientOrderId());
        this.txtFlatRate.setText(String.valueOf(obj.getFlatRate()));
        this.lblAddBusCharges.setText(String.valueOf(obj.getBuscost()));

        this.txtLiveMileRate.setText(String.valueOf(obj.getMilageRate()));
        this.txtDeadHeadMileRate.setText(String.valueOf(obj
                .getDeadheadMilageRate()));
        this.txtLiveMiles.setText(String.valueOf(obj.getLiveMiles()));
        this.txtDeadHeadMiles.setText(String.valueOf(obj.getDeadheadMiles()));
        this.txtMinHourlyRate.setText(String.valueOf(obj.getHourlyRate()));
        this.txtExtHourlyRate.setText(String.valueOf(obj.getHourlyRate2()));
        this.txtTotalHours.setText(String.valueOf(obj.getTotalHours()));
        this.txtRequiredDeposit
                .setText(String.valueOf(obj.getRequiredDeposit()));

        this.ddbDropOffCollectTender.selectItemByKey(obj
                .getDropoffCollectTender());
        this.ddbMinHourlyFact.selectItemByKey(obj.getMinHourFactor());

        this.calculateTotals();
    }

    /**
     * Basically transfers the data from the input controls to the model object
     */
    private void updateModel() {
        String strVal = null;
        double val = 0;
        int iVal = 0;

        // Order id
        this.order.setId(this.getData().getOrderId());
        // Quote id
        this.order.setQuoteId(this.getData().getQuoteId());
        // Client Order Id
        strVal = this.txtClientOrderNo.getText();
        if (strVal.equals(RMT2String.spaces(strVal.length()))) {
            this.order.setClientOrderId(null);
        }
        else {
            this.order.setClientOrderId(strVal);
        }
        // Drop off collect
        if (this.cbxDropOffCollect.isSelected()) {
            this.order.setDropoffCollect("Y");
        }
        else {
            this.order.setDropoffCollect("N");
        }
        // Drop off tender
        GeneralCodes dropOffTender = (GeneralCodes) this.ddbDropOffCollectTender
                .getSelectedItem();
        if (dropOffTender == null) {
            this.order.setDropoffCollectTender(0);
        }
        else {
            this.order.setDropoffCollectTender(dropOffTender.getCodeId());
        }
        // Flat Rate
        val = this.txtFlatRate.getText() == null ? 0 : Double
                .parseDouble(this.txtFlatRate.getText());
        this.order.setFlatRate(val);
        // Additional Bus Cost
        val = this.lblAddBusCharges.getText() == null ? 0 : Double
                .parseDouble(this.lblAddBusCharges.getText());
        this.order.setBuscost(val);
        // Live milage rate
        val = this.txtLiveMileRate.getText() == null ? 0 : Double
                .parseDouble(this.txtLiveMileRate.getText());
        this.order.setMilageRate(val);
        // Dead Head milage rate
        val = this.txtDeadHeadMileRate.getText() == null ? 0 : Double
                .parseDouble(this.txtDeadHeadMileRate.getText());
        this.order.setDeadheadMilageRate(val);
        // Live miles
        iVal = this.txtLiveMiles.getText() == null ? 0 : Integer
                .parseInt(this.txtLiveMiles.getText());
        this.order.setLiveMiles(iVal);
        // Dead Head miles
        iVal = this.txtDeadHeadMiles.getText() == null ? 0 : Integer
                .parseInt(this.txtDeadHeadMiles.getText());
        this.order.setDeadheadMiles(iVal);
        // Minimum Hour Factor
        GeneralCodes minHourFact = (GeneralCodes) this.ddbMinHourlyFact
                .getSelectedItem();
        if (minHourFact == null) {
            this.order.setMinHourFactor(0);
        }
        else {
            this.order.setMinHourFactor(minHourFact.getCodeId());
        }
        // Minimum Hour rate
        val = this.txtMinHourlyRate.getText() == null ? 0 : Double
                .parseDouble(this.txtMinHourlyRate.getText());
        this.order.setHourlyRate(val);
        // Extended Hour rate
        val = this.txtExtHourlyRate.getText() == null ? 0 : Double
                .parseDouble(this.txtExtHourlyRate.getText());
        this.order.setHourlyRate2(val);
        // total hours
        iVal = this.txtTotalHours.getText() == null ? 0 : Integer
                .parseInt(this.txtTotalHours.getText());
        this.order.setTotalHours(iVal);
        // Required Deposit
        val = this.txtRequiredDeposit.getText() == null ? 0 : Double
                .parseDouble(this.txtRequiredDeposit.getText());
        this.order.setRequiredDeposit(val);
    }

    /**
     * Performs caluclations for the hourly sub total, milage sub total,
     * additional bus charges, and trip total fields for an entire order.
     */
    protected void calculateTotals() {
        double tripTotal = this.bo.calculateOrderCharge(this.order, this.quote);
        double mileSubTotal = this.bo.calculateOrderMileageCharge(this.order);
        double hourlySubTotal = this.bo.calculateOrderHourlyCharge(this.order);

        this.lblHourlySubTot.setText(RMT2Money.formatNumber(
                Double.valueOf(hourlySubTotal), "#,##0.00"));
        this.lblMileageSubTot.setText(RMT2Money.formatNumber(
                Double.valueOf(mileSubTotal), "#,##0.00"));
        this.lblTripTotal.setText(RMT2Money.formatNumber(
                Double.valueOf(tripTotal), "#,##0.00"));
        this.lblAddBusCharges.setText(RMT2Money.formatNumber(
                Double.valueOf(this.order.getBuscost()), "#,##0.00"));

        // Notify any listeners that the total has changed.
        TotalCostChangedEvent evt = new TotalCostChangedEvent(this,
                CharterOrderMaintFinanceComp.EVENT_ID_TOTAL_COST_CHANGED,
                tripTotal);
        this.evtDispatcher.fireEvent(evt);
    }

    /**
     * @param quoteList
     *            a list of quotes
     */
    public void setOrder(Orders order) {
        this.order = order;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case (CharterOrderMaintFinanceComp.ACTION_COMMAND_OPEN_ADD_BUS):
                this.manageAdditionalBusInfo();
                break;
            // case (CharterOrderMaintFinanceComp.ACTION_COMMAND_GEN_INVOICE):
            // this.generateInvoice();
            // break;
            case (CharterOrderMaintFinanceComp.ACTION_COMMAND_MINHOURFACTOR_CHANGED):
                if (e.getSource() instanceof DynamicDropDownBox) {
                    GeneralCodes code = (GeneralCodes) ((DynamicDropDownBox) e
                            .getSource()).getSelectedItem();
                    this.order.setMinHourFactor(code.getCodeId());
                }
        }
        this.calculateTotals();
    }

    /**
     * Opens the {@link CharterOrderMaintFinanceBusDialog} in order to maintain
     * additonal bus information for the charter order.
     * <p>
     * The CharterOrderMaintFinanceBusDialog dialog will return to the caller an
     * instance of Map<String, Object> in which the mappings will represent the
     * 1) list of deleted buses and 2) the total cost of additional buses for
     * the charter order. a Map<String, Object> containing a list of deleted
     * buses and the total cost of the remaining buses. The list of deleted
     * buses will be of type List<{@link BusDetail}> and keyed as
     * {@link CharterOrderMaintFinanceBusDialog#ADDBUS_RESULTS_KEY_DELETEDBUSES}
     * . The remaining bus cost value is of type Double and is keyed as
     * {@link CharterOrderMaintFinanceBusDialog#ADDBUS_RESULTS_KEY_TOTALCHARGES}
     * .
     */
    protected void manageAdditionalBusInfo() {
        BusCharterDao dao = BusCharterDaoFactory.createDao(null);
        CharterOrderMaintFinanceBusDialog d = new CharterOrderMaintFinanceBusDialog(
                "Charter Order Add Bus Details", this.busList, new Dimension(
                        680, 700), new Point(300, 300));
        d.setVisible(true);
        Object results = d.getResults();
        if (results != null && results instanceof Map<?, ?>) {
            Map<String, Object> dialogResults = (Map<String, Object>) results;
            this.deletedBusList = (List<BusDetail>) dialogResults
                    .get(CharterOrderMaintFinanceBusDialog.ADDBUS_RESULTS_KEY_DELETEDBUSES);
            Double addBusCharges = (Double) dialogResults
                    .get(CharterOrderMaintFinanceBusDialog.ADDBUS_RESULTS_KEY_TOTALCHARGES);
            this.order.setBuscost(addBusCharges);
            this.calculateTotals();
        }

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
        double dVal;
        try {
            val = e.getDocument().getText(0, e.getDocument().getLength());
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
        Object name = e.getDocument().getProperty("name");
        switch (name.toString()) {
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_FLATRATE_CHANGED:
                if (RMT2Money.isNumeric(val)) {
                    this.order.setFlatRate(Double.parseDouble(val));
                }
                break;
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_MILEAGERATE_CHANGED:
                if (RMT2Money.isNumeric(val)) {
                    this.order.setMilageRate(Double.parseDouble(val));
                }
                break;
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_DEADHEADMILERATE_CHANGED:
                if (RMT2Money.isNumeric(val)) {
                    this.order.setDeadheadMilageRate(Double.parseDouble(val));
                }
                break;
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_LIVEMILES_CHANGED:
                if (RMT2Money.isNumeric(val)) {
                    this.order.setLiveMiles(Integer.parseInt(val));
                }
                break;
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_DEADHEADMILE_CHANGED:
                if (RMT2Money.isNumeric(val)) {
                    this.order.setDeadheadMiles(Integer.parseInt(val));
                }
                break;
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_MINHOURRATE_CHANGED:
                if (RMT2Money.isNumeric(val)) {
                    this.order.setHourlyRate(Double.parseDouble(val));
                }
                break;
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_EXTHOURRATE_CHANGED:
                if (RMT2Money.isNumeric(val)) {
                    this.order.setHourlyRate2(Double.parseDouble(val));
                }
                break;
            case CharterOrderMaintFinanceBusDialog.ACTION_COMMAND_TOTALHOURS_CHANGED:
                if (RMT2Money.isNumeric(val)) {
                    this.order.setTotalHours(Integer.parseInt(val));
                }
                break;
        }
        this.calculateTotals();
        return;

    }

    /**
     * @param quote
     *            the quote to set
     */
    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    /**
     * @param busList
     *            the busList to set
     */
    public void setBusList(List<BusDetail> busList) {
        this.busList = busList;
    }

    /**
     * Adds an instance of TotalCostChangedListener interface to the List of
     * Listeners.
     * 
     * @param listener
     *            an instance of a class that has implemented the
     *            {@link TotalCostChangedListener} interface.
     */
    public void addFinancialUpdateListener(TotalCostChangedListener listener) {
        this.listenerList.add(TotalCostChangedListener.class, listener);
    }

    /**
     * Removes a TotalCostChangedListener listener from the list of listeners.
     * 
     * @param listener
     *            an instance of {@link TotalCostChangedListener} interface
     *            targeted for removal.
     */
    public void removeFinancialUpdateListener(TotalCostChangedListener listener) {
        this.listenerList.remove(TotalCostChangedListener.class, listener);
    }

    /**
     * Adds an instance of NewOrderCreatedListener interface to the List of
     * Listeners.
     * 
     * @param listener
     *            an instance of a class that has implemented the
     *            {@link TotalCostChangedListener} interface.
     */
    public void addNewOrderCreatedListener(NewOrderCreatedListener listener) {
        this.listenerList.add(NewOrderCreatedListener.class, listener);
    }

    /**
     * Removes a NewOrderCreatedListener listener from the list of listeners.
     * 
     * @param listener
     *            an instance of {@link NewOrderCreatedListener} interface
     *            targeted for removal.
     */
    public void removeNewOrderCreatedListener(NewOrderCreatedListener listener) {
        this.listenerList.remove(NewOrderCreatedListener.class, listener);
    }

    /**
     * Saves changes pertaining to an existing charter order as well as creates
     * a new charter order.
     * <p>
     * Once the save operation has concluded, a {@link NewOrderCreatedEvent}
     * event is fired in the event of the charter order moves from "Quote" to
     * "Order" status.
     * 
     * @see com.ui.components.AbstractGuiComponentTemplate#saveChanges()
     */
    @Override
    public void saveChanges() {
        if (!this.getData().isOrderAcceptingChanges()) {
            return;
        }
        this.updateModel();

        try {
            // this.bo.beginTrans();
            this.bo.updateOrder(this.order, this.busList);
            this.bo.deleteOrderBuses(this.deletedBusList);
            // this.bo.commitTrans();
            // Update the key paramters that is shared with other tabs with the
            // order id.
            this.getData().setOrderId(this.order.getId());
            // If new order is created, fire NewOrderCreatedEvent to interested
            // listeners.
            if (this.getData().isNewOrder()) {
                this.getData().setNewOrder(false);
                NewOrderCreatedEvent evt2 = new NewOrderCreatedEvent(this,
                        order.getId());
                evtDispatcher.fireEvent(evt2);
            }
        } catch (Exception e) {
            // this.bo.rollbackTrans();
            throw e;
        } finally {
            this.updateView(this.order);
        }
    }

    private class RetrieveDataThread implements Runnable {
        private CharterOrderMaintFinanceComp parent;
        private CharterOrderMaintParmsBean parms;

        protected RetrieveDataThread(CharterOrderMaintFinanceComp parent,
                CharterOrderMaintParmsBean data) {
            this.parent = parent;
            this.parms = data;
        }

        @Override
        public void run() {
            this.fetchData();
        }

        public void fetchData() {
            Orders order = bo.getOrderInfo(parms.getOrderId());
            if (order == null) {
                order = new Orders();
            }
            Quote quote = bo.getTripInfo(parms.getQuoteId());
            if (quote == null) {
                quote = new Quote();
            }
            List<BusDetail> buses = bo.getOrderBusInfo(parms.getOrderId());
            if (buses == null) {
                buses = new ArrayList<BusDetail>();
            }
            parent.setOrder(order);
            parent.setQuote(quote);
            parent.setBusList(buses);
            this.updateControls(order);
            return;
        }

        private void updateControls(final Orders obj) {
            parent.updateView(obj);

            // SwingUtilities.invokeLater(new Runnable() {
            //
            // @Override
            // public void run() {
            // parent.updateView(obj);
            // }
            // });
        }
    }

    /**
     * Saves changes pertaining to an existing charter order as well as creates
     * a new charter order.
     * <p>
     * Once the save operation has concluded, at most, two events are fired. The
     * {@link com.ui.event.ComponentUpdateCompletedEvent} event is fired to
     * indicate success or failure of the save operation. A
     * {@link NewOrderCreatedEvent} event is fired in the event of the charter
     * order moves from "Quote" to "Order" status.
     * 
     * @author appdev
     *
     */

}
