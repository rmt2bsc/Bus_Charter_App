package org.maint.charterorder;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

import org.FormUtil;
import org.apache.log4j.Logger;
import org.dao.mapping.Business;
import org.dao.mapping.GeneralCodes;
import org.dao.mapping.Quote;
import org.maint.company.CompanyBO;

import com.ui.components.AbstractGuiComponentTemplate;
import com.ui.components.dropdownbox.DynamicDropDownBox;
import com.util.RMT2Date;
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
public class CharterOrderMaintTripComp extends
        AbstractGuiComponentTemplate<CharterOrderMaintParmsBean> {

    private static final long serialVersionUID = 4885982443482429370L;

    private static Logger logger = Logger
            .getLogger(CharterOrderMaintTripComp.class);

    private Quote quote;
    private GeneralCodes quoteStatus;

    private JLabel lblTripId;
    private JLabel lblClientId;
    private JLabel lblBusCount;
    private JLabel lblOrderStatus;

    private JCheckBox cbxStatusOverride;
    private DynamicDropDownBox<Business> ddbTransComp;

    private JTextField txtCharterParty;
    private JTextField txtSinage;
    private JTextField txtCapacity;
    private JTextField txtDepartDate;
    private JTextField txtDepartSpotTime;
    private JTextField txtDepartDropTime;
    private JTextField txtReturnDate;
    private JTextField txtReturnSpotTime;
    private JTextField txtReturnDropTime;
    private JTextField txtGarageDate;
    private JTextField txtGarageTime;
    private JTextArea taPickupLoc;
    private JTextArea taDest;
    private JTextArea taSpecialInstruct;

    private String comments;

    private CharterOrderBO bo;
    private CompanyBO cBo;

    /**
     * 
     */
    public CharterOrderMaintTripComp(CharterOrderMaintParmsBean quote) {
        super(quote);
        return;
    }

    protected void initFields() {
        this.bo = new CharterOrderBO();
        this.cBo = new CompanyBO();
        this.lblTripId = FormUtil.createDataLabel(null, true, Color.BLUE);
        this.lblClientId = FormUtil.createDataLabel(null, true, Color.BLUE);
        this.lblBusCount = FormUtil.createDataLabel(null, true, Color.BLUE);
        this.lblOrderStatus = FormUtil.createDataLabel(null, true, Color.RED);
        this.cbxStatusOverride = FormUtil.createCheckBox(
                "Override Order Status", SwingConstants.LEFT, false, true);

        try {
            List<Integer> busTypeIdList = new ArrayList<Integer>();
            busTypeIdList.add(24);
            busTypeIdList.add(25);
            List<Business> items = this.cBo
                    .getCompanyInfoByBusinessType(busTypeIdList);
            this.ddbTransComp = FormUtil.createCompanyInfoDDB(items, null, 180);
        } catch (Exception e) {
            logger.error("*********Trip tab: DropDown component for Transport company field was not created");
            logger.error(e);
        }

        this.txtCharterParty = FormUtil.createTextField(this, null, false, 250,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.LEFT);
        this.txtSinage = FormUtil.createTextField(this, null, false, 180,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.LEFT);
        this.txtCapacity = FormUtil.createTextField(this, null, false, 30,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.LEFT);
        this.txtDepartDate = FormUtil.createTextField(this, null, false,
                FormUtil.STD_DATE_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.LEFT);
        this.txtDepartSpotTime = FormUtil.createTextField(this, null, false,
                FormUtil.STD_DATE_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.LEFT);
        this.txtDepartDropTime = FormUtil.createTextField(this, null, false,
                FormUtil.STD_DATE_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.LEFT);
        this.txtReturnDate = FormUtil.createTextField(this, null, false,
                FormUtil.STD_DATE_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.LEFT);
        this.txtReturnSpotTime = FormUtil.createTextField(this, null, false,
                FormUtil.STD_DATE_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.LEFT);
        this.txtReturnDropTime = FormUtil.createTextField(this, null, false,
                FormUtil.STD_DATE_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.LEFT);
        this.txtGarageDate = FormUtil.createTextField(this, null, false,
                FormUtil.STD_DATE_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.LEFT);
        this.txtGarageTime = FormUtil.createTextField(this, null, false,
                FormUtil.STD_DATE_CNTROL_WIDTH,
                FormUtil.STD_TEXT_CNTROL_HEIGHT, SwingConstants.LEFT);

        this.taPickupLoc = FormUtil.createTextArea(this, null, false, 2);
        this.taDest = FormUtil.createTextArea(this, null, false, 2);
        this.taSpecialInstruct = FormUtil.createTextArea(this, null, false, 5);
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
        JPanel sect3 = this.buildSection3();
        JPanel sect4 = this.buildSection4();
        this.add(sect1, "wrap, wrap");
        this.add(sect2, "wrap, wrap");
        this.add(sect3, "wrap, wrap");
        this.add(sect4, "wrap, wrap");
    }

    private JPanel buildSection1() {
        JPanel sect = new JPanel();
        sect.setLayout(new MigLayout("", "[][]20[][]40[][]20[][]20[]", "[][][]"));

        sect.add(FormUtil.createHeaderLabel("Client Id:"), "right, center");
        sect.add(this.lblClientId, "center, left");

        sect.add(FormUtil.createHeaderLabel("Trip Id:"), "right, center");
        sect.add(this.lblTripId, "center");

        sect.add(FormUtil.createHeaderLabel("Bus Count:"), "right, center");
        sect.add(this.lblBusCount, "center");

        sect.add(FormUtil.createHeaderLabel("Order Status:"), "right, center");
        sect.add(this.lblOrderStatus, "center");

        // Add check box
        sect.add(this.cbxStatusOverride, "wrap");

        sect.add(FormUtil.createHeaderLabel("Transport Company:", true),
                "right, top, span 2");

        sect.add(this.ddbTransComp, "top, span 7, wrap");

        sect.add(FormUtil.createHeaderLabel("Charter Party:"),
                "right, top, span 2");
        sect.add(this.txtCharterParty, "top, span 7, wrap");

        sect.add(FormUtil.createHeaderLabel("Signage:"), "right, top");
        sect.add(this.txtSinage, "top, span 3");

        sect.add(FormUtil.createHeaderLabel("Capacity:"), "right, top");
        sect.add(this.txtCapacity, "top, span 3, wrap");

        return sect;
    }

    private JPanel buildSection2() {
        JPanel sect = new JPanel();
        sect.setLayout(new GridLayout(2, 1));

        JPanel departInfo = new JPanel();
        departInfo.setLayout(new MigLayout("",
                "[][80:80:80]20[][80:80:80]20[][80:80:80]", "[]"));
        FormUtil.addPanelTitle(departInfo, "Departure Specifics", Color.BLUE);
        departInfo.add(FormUtil.createHeaderLabel("Date:", true), "right, top");
        departInfo.add(this.txtDepartDate, "top");

        departInfo.add(FormUtil.createHeaderLabel("Spot Time:", true),
                "right, top");
        departInfo.add(this.txtDepartSpotTime, "top");

        departInfo.add(FormUtil.createHeaderLabel("Drop Time:"), "right, top");
        departInfo.add(this.txtDepartDropTime, "top");

        sect.add(departInfo);

        JPanel returnInfo = new JPanel();
        returnInfo.setLayout(new MigLayout("",
                "[][80:80:80]20[][80:80:80]20[][80:80:80]", "[]"));
        FormUtil.addPanelTitle(returnInfo, "Return Specifics", Color.BLUE);

        returnInfo.add(FormUtil.createHeaderLabel("Date:", true), "right, top");
        returnInfo.add(this.txtReturnDate, "top");

        returnInfo.add(FormUtil.createHeaderLabel("Spot Time:"), "right, top");
        returnInfo.add(this.txtReturnSpotTime, "top");

        returnInfo.add(FormUtil.createHeaderLabel("Drop Time:", true),
                "right, top");
        returnInfo.add(this.txtReturnDropTime, "top");

        sect.add(departInfo);
        sect.add(returnInfo);

        return sect;
    }

    private JPanel buildSection3() {
        JPanel sect = new JPanel();
        sect.setLayout(new MigLayout("", "[][80:80:80]30[][80:80:80]",
                "[][][][]"));

        sect.add(FormUtil.createHeaderLabel("Garage Date: "), "right, top");
        sect.add(this.txtGarageDate, "growx, left");

        sect.add(FormUtil.createHeaderLabel("Garage Time: "), "right, top");
        sect.add(this.txtGarageTime, "growx, left, wrap");

        return sect;
    }

    private JPanel buildSection4() {
        JPanel sect = new JPanel();
        sect.setLayout(new MigLayout("", "[][580:580:580]", "[][][]"));

        sect.add(FormUtil.createHeaderLabel("Pickup Location:", true),
                "right, top");
        sect.add(new JScrollPane(taPickupLoc), "growx, left, wrap");

        sect.add(FormUtil.createHeaderLabel("Destination:", true), "right, top");
        sect.add(new JScrollPane(this.taDest), "growx, left, wrap");

        sect.add(FormUtil.createHeaderLabel("Special Instructions:", true),
                "right, top");
        sect.add(new JScrollPane(this.taSpecialInstruct), "growx, left, wrap");
        return sect;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.maint.charterorder.AbstractGuiComponentTemplate#updateView(java.util
     * .List)
     */
    @Override
    public void updateView(CharterOrderMaintParmsBean data) {
        RetrieveDataThread t = new RetrieveDataThread(this, data);
        t.fetchData();

        // Thread thread = new Thread(t);
        // thread.start();
        // try {
        // thread.join(300);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }

        // EventQueue.invokeLater(t);

        // Quote obj = this.bo.getTripInfo(data.getQuoteId());
        // this.setQuote(obj);
        // if (obj == null) {
        // return;
        // }
        // this.lblClientId.setText(String.valueOf(obj.getClientId()));
        // this.lblTripId.setText(String.valueOf(obj.getId()));
        // this.lblBusCount.setText(String.valueOf(obj.getBusCount()));
        // this.lblOrderStatus.setText(String.valueOf(obj.getStatus()));
        // this.txtCharterParty.setText(obj.getCharterParty());
        // this.txtSinage.setText(obj.getSignage());
        // this.txtCapacity.setText("100");
        //
        // if (obj.getDepartDate() != null) {
        // this.txtDepartDate.setText(String.valueOf(RMT2Date.formatDate(
        // obj.getDepartDate(), "MM-dd-yyyy")));
        // }
        //
        // if (obj.getDepartSpottime() != null) {
        // this.txtDepartSpotTime.setText(String.valueOf(RMT2Date.formatDate(
        // obj.getDepartSpottime(), "hh:mm a")));
        // }
        // if (obj.getDepartDroptime() != null) {
        // this.txtDepartDropTime.setText(String.valueOf(RMT2Date.formatDate(
        // obj.getDepartDroptime(), "hh:mm a")));
        // }
        // if (obj.getReturnDate() != null) {
        // this.txtReturnDate.setText(String.valueOf(RMT2Date.formatDate(
        // obj.getReturnDate(), "MM-dd-yyyy")));
        // }
        // if (obj.getReturnSpottime() != null) {
        // this.txtReturnSpotTime.setText(String.valueOf(RMT2Date.formatDate(
        // obj.getReturnSpottime(), "hh:mm a")));
        // }
        // if (obj.getReturnDroptime() != null) {
        // this.txtReturnDropTime.setText(String.valueOf(RMT2Date.formatDate(
        // obj.getReturnDroptime(), "hh:mm a")));
        // }
        // if (obj.getGarageDate() != null) {
        // this.txtGarageDate.setText(RMT2Date.formatDate(obj.getGarageDate(),
        // "MM/dd/yyyy"));
        // }
        // if (obj.getGarageTime() != null) {
        // this.txtGarageTime.setText(RMT2Date.formatDate(obj.getGarageTime(),
        // "hh:mm a"));
        // }
        //
        // this.taPickupLoc.setText(obj.getPickupLocation());
        // this.taDest.setText(obj.getDestination());
        //
        // this.ddbTransComp.selectItemByKey(obj.getCompanyId());
        // // Comments comment =
        // this.bo.getComment(obj.getSpecialInstructions());
        // this.taSpecialInstruct.setText(obj.getInstructions());
    }

    private void updateView(Quote obj) {
        this.lblClientId.setText(String.valueOf(obj.getClientId()));
        this.lblTripId.setText(String.valueOf(obj.getId()));
        this.lblBusCount.setText(String.valueOf(obj.getBusCount()));
        this.lblOrderStatus.setText(this.quoteStatus == null ? "New"
                : this.quoteStatus.getLongdesc());
        this.txtCharterParty.setText(obj.getCharterParty());
        this.txtSinage.setText(obj.getSignage());
        this.txtCapacity.setText(String.valueOf(obj.getHeadCount()));

        if (obj.getDepartDate() != null) {
            this.txtDepartDate.setText(String.valueOf(RMT2Date.formatDate(
                    obj.getDepartDate(), "MM-dd-yyyy")));
        }

        if (obj.getDepartSpottime() != null) {
            this.txtDepartSpotTime.setText(String.valueOf(RMT2Date.formatDate(
                    obj.getDepartSpottime(), "hh:mm a")));
        }
        if (obj.getDepartDroptime() != null) {
            this.txtDepartDropTime.setText(String.valueOf(RMT2Date.formatDate(
                    obj.getDepartDroptime(), "hh:mm a")));
        }
        if (obj.getReturnDate() != null) {
            this.txtReturnDate.setText(String.valueOf(RMT2Date.formatDate(
                    obj.getReturnDate(), "MM-dd-yyyy")));
        }
        if (obj.getReturnSpottime() != null) {
            this.txtReturnSpotTime.setText(String.valueOf(RMT2Date.formatDate(
                    obj.getReturnSpottime(), "hh:mm a")));
        }
        if (obj.getReturnDroptime() != null) {
            this.txtReturnDropTime.setText(String.valueOf(RMT2Date.formatDate(
                    obj.getReturnDroptime(), "hh:mm a")));
        }
        if (obj.getGarageDate() != null) {
            this.txtGarageDate.setText(RMT2Date.formatDate(obj.getGarageDate(),
                    "MM/dd/yyyy"));
        }
        if (obj.getGarageTime() != null) {
            this.txtGarageTime.setText(RMT2Date.formatDate(obj.getGarageTime(),
                    "hh:mm a"));
        }

        this.taPickupLoc.setText(obj.getPickupLocation());
        this.taDest.setText(obj.getDestination());

        this.ddbTransComp.selectItemByKey(obj.getCompanyId());

        this.taSpecialInstruct.setText(obj.getInstructions());
    }

    /**
     * Basically transfers the data from the input controls to the model object
     */
    private void updateModel() {
        String val = null;
        this.quote.setClientId(this.getData().getClientId());
        this.quote.setId(this.getData().getQuoteId());
        val = this.lblBusCount.getText();
        this.quote.setBusCount(val.equals(RMT2String.spaces(val.length())) ? 0
                : RMT2Money.stringToNumber(val).intValue());
        this.quote.setStatus(this.getData().getOrderStatusId());

        val = this.txtCharterParty.getText();
        this.quote
                .setCharterParty(val.equals(RMT2String.spaces(val.length())) ? null
                        : val);
        val = this.txtSinage.getText();
        this.quote
                .setSignage(val.equals(RMT2String.spaces(val.length())) ? null
                        : val);

        val = this.txtCapacity.getText();
        if (!val.equals(RMT2String.spaces(val.length()))
                && RMT2Money.isNumeric(val)) {
            this.quote.setHeadCount(RMT2Money.stringToNumber(
                    this.txtCapacity.getText()).intValue());
        }
        else {
            this.quote.setHeadCount(0);
        }

        val = this.txtDepartDate.getText();
        if (val.equals(RMT2String.spaces(val.length()))) {
            this.quote.setDepartDate(null);
        }
        else {
            this.quote.setDepartDate(RMT2Date.stringToDate(val));
        }

        val = this.txtDepartSpotTime.getText();
        if (val.equals(RMT2String.spaces(val.length()))) {
            this.quote.setDepartSpottime(null);
        }
        else {
            // this.quote.setDepartSpottime(RMT2Date.stringToDate(val,
            // "hh:mm a"));
            this.quote.setDepartSpottime(RMT2Date.stringToDate(val));
        }

        val = this.txtDepartDropTime.getText();
        if (val.equals(RMT2String.spaces(val.length()))) {
            this.quote.setDepartDroptime(null);
        }
        else {
            // this.quote.setDepartSpottime(RMT2Date.stringToDate(val,
            // "hh:mm a"));
            this.quote.setDepartDroptime(RMT2Date.stringToDate(val));
        }

        val = this.txtReturnDate.getText();
        if (val.equals(RMT2String.spaces(val.length()))) {
            this.quote.setReturnDate(null);
        }
        else {
            this.quote.setReturnDate(RMT2Date.stringToDate(val));
        }

        val = this.txtReturnSpotTime.getText();
        if (val.equals(RMT2String.spaces(val.length()))) {
            this.quote.setReturnSpottime(null);
        }
        else {
            // this.quote.setReturnSpottime(RMT2Date.stringToDate(val,
            // "hh:mm a"));
            this.quote.setReturnSpottime(RMT2Date.stringToDate(val));
        }

        val = this.txtReturnDropTime.getText();
        if (val.equals(RMT2String.spaces(val.length()))) {
            this.quote.setReturnDroptime(null);
        }
        else {
            // this.quote.setReturnDroptime(RMT2Date.stringToDate(val,
            // "hh:mm a"));
            this.quote.setReturnDroptime(RMT2Date.stringToDate(val));
        }

        val = this.txtGarageDate.getText();
        if (val.equals(RMT2String.spaces(val.length()))) {
            this.quote.setGarageDate(null);
        }
        else {
            this.quote.setGarageDate(RMT2Date.stringToDate(val));
        }

        val = this.txtGarageTime.getText();
        if (val.equals(RMT2String.spaces(val.length()))) {
            this.quote.setGarageTime(null);
        }
        else {
            // this.quote.setGarageTime(RMT2Date.stringToDate(val, "hh:mm a"));
            this.quote.setGarageTime(RMT2Date.stringToDate(val));
        }

        val = this.taPickupLoc.getText();
        this.quote
                .setPickupLocation(val.equals(RMT2String.spaces(val.length())) ? null
                        : val);

        val = this.taDest.getText();
        this.quote
                .setDestination(val.equals(RMT2String.spaces(val.length())) ? null
                        : val);

        val = this.taSpecialInstruct.getText();
        this.quote
                .setInstructions(val.equals(RMT2String.spaces(val.length())) ? null
                        : val);

        Business comp = (Business) this.ddbTransComp.getSelectedItem();
        this.quote.setCompanyId(comp.getId());

    }

    /**
     * @param quoteList
     *            a list of quotes
     */
    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    /**
     * Saves quote changes.
     * <p>
     * Once the save operation has concluded, at most, two events are fired. The
     * {@link com.ui.event.ComponentUpdateCompletedEvent} event is fired to
     * indicate success or failure of the save operation. A
     * {@link NewOrderCreatedEvent} event is fired in the event of the charter
     * order moves from "Quote" to "Order" status.
     * 
     * @see com.ui.components.AbstractGuiComponentTemplate#saveChanges()
     */
    @Override
    public void saveChanges() {
        // logic to save existing data or create a new quote.
        this.updateModel();

        try {
            this.bo.updateQuote(this.quote);
            // Update the key paramters that is shared with other tabs.
            this.getData().setQuoteId(this.quote.getId());
            this.getData().setOrderStatusId(this.quote.getStatus());
            // Update quote status text
            this.quoteStatus = bo.getLookupCode(this.quote.getStatus());
        } catch (Exception e) {
            throw e;
        } finally {
            updateView(this.quote);
        }
        return;
    }

    private class RetrieveDataThread implements Runnable {
        private CharterOrderMaintTripComp parent;
        private CharterOrderMaintParmsBean parms;

        protected RetrieveDataThread(CharterOrderMaintTripComp parent,
                CharterOrderMaintParmsBean data) {
            this.parent = parent;
            this.parms = data;
        }

        @Override
        public void run() {
            this.fetchData();
        }

        public void fetchData() {
            Quote obj = bo.getTripInfo(this.parms.getQuoteId());
            if (obj != null) {
                this.updateControls(obj);
            }
            else {
                obj = new Quote();
            }
            parent.setQuote(obj);
        }

        private void updateControls(final Quote obj) {
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
}
