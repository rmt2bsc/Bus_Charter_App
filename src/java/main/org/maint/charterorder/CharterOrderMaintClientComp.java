package org.maint.charterorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

import org.FormUtil;
import org.dao.mapping.VwClientList;
import org.maint.client.ClientBO;
import org.maint.client.ClientSerachMaintDialog;

import com.RMT2Constants;
import com.ui.components.AbstractGuiComponentTemplate;
import com.ui.event.ComponentUpdateCompletedEvent;
import com.util.RMT2String;

/**
 * A component for displaying and associating c data with the Charter Order.
 * <p>
 * The information displayed in this component is read only and can only be
 * obtained from the c search facility during Charter Order add operations or by
 * passing a valid {@link Client} object to its constructor when managing an
 * existing Charter Order. The Client Search component is invoked from this
 * component by clicking the "Get Client..." button.
 * 
 * @author Roy Terrell
 *
 */
public class CharterOrderMaintClientComp extends
        AbstractGuiComponentTemplate<CharterOrderMaintParmsBean> implements
        ActionListener {

    private static final long serialVersionUID = 4885982443482429370L;

    /**
     * The action command to open c search window.
     */
    public static final String ACTION_COMMAND_OPEN_CLEINT_SEARCH = "OPEN_CLIENT_SEARCH";

    private VwClientList client;

    private JButton clientSearchButton;

    private JLabel lblClientId;
    private JLabel lblClientCompName;
    private JLabel lblBillCompName;

    private JLabel lblCntName;
    private JLabel lblCntAddr1;
    private JLabel lblCntAddr2;
    private JLabel lblCntAddr3;
    private JLabel lblCntCity;
    private JLabel lblCntState;
    private JLabel lblCntZip;
    private JLabel lblCntPhone;
    private JLabel lblCntFax;

    private JLabel lblBillName;
    private JLabel lblBillAddr1;
    private JLabel lblBillAddr2;
    private JLabel lblBillAddr3;
    private JLabel lblBillCity;
    private JLabel lblBillState;
    private JLabel lblBillZip;
    private JLabel lblBillPhone;
    private JLabel lblBillFax;

    private JLabel lblEmail;
    private JLabel lblWebsite;
    private JTextArea lblComments;

    private CharterOrderBO bo;
    private ClientBO cBo;

    /**
     * 
     */
    public CharterOrderMaintClientComp(CharterOrderMaintParmsBean client) {
        super(client);
        // this.client = null;
        return;
    }

    protected void initFields() {
        this.bo = new CharterOrderBO();
        this.cBo = new ClientBO();

        this.lblClientId = FormUtil.createDataLabel(null, true, Color.RED);
        this.lblClientCompName = FormUtil
                .createDataLabel(null, true, Color.RED);
        this.lblBillCompName = FormUtil.createDataLabel(null, true, Color.RED);

        this.lblCntName = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblCntAddr1 = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblCntAddr2 = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblCntAddr3 = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblCntCity = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblCntState = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblCntZip = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblCntPhone = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblCntFax = FormUtil.createDataLabel(null, false, Color.BLACK);

        this.lblBillName = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblBillAddr1 = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblBillAddr2 = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblBillAddr3 = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblBillCity = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblBillState = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblBillZip = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblBillPhone = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblBillFax = FormUtil.createDataLabel(null, false, Color.BLACK);

        this.lblEmail = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblWebsite = FormUtil.createDataLabel(null, false, Color.BLACK);
        this.lblComments = FormUtil.createTextArea(this, null, true, 5);
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
        this.add(sect1, "wrap");
        this.add(sect2, "wrap");
        this.add(sect3);
    }

    private JPanel buildSection1() {
        JPanel sect1 = new JPanel();
        sect1.setLayout(new MigLayout("", "[][240:240:240]", "[][][]20[]"));

        JLabel lbl = new JLabel("Client Id: ");
        Font font = new Font(Font.SERIF, Font.BOLD, 12);
        lbl.setFont(font);
        sect1.add(lbl, "right, top");

        this.lblClientId.setSize(30, 20);
        this.lblClientId.setHorizontalAlignment(SwingConstants.LEFT);
        sect1.add(this.lblClientId, "wrap");

        lbl = new JLabel("Client Company: ");
        font = new Font(Font.SERIF, Font.BOLD, 12);
        lbl.setFont(font);
        sect1.add(lbl);

        this.lblClientCompName.setSize(80, 30);
        this.lblClientCompName.setHorizontalAlignment(SwingConstants.LEFT);
        this.lblClientCompName.setFont(font);
        sect1.add(this.lblClientCompName, "growx, wrap");

        lbl = new JLabel("Billing Company: ");
        font = new Font(Font.SERIF, Font.BOLD, 12);
        lbl.setFont(font);
        sect1.add(lbl);

        this.lblBillCompName.setSize(80, 30);
        this.lblBillCompName.setHorizontalAlignment(SwingConstants.LEFT);
        this.lblBillCompName.setFont(font);
        sect1.add(this.lblBillCompName, "growx, wrap");

        this.clientSearchButton = new JButton("Get Client...");
        this.clientSearchButton
                .setActionCommand(CharterOrderMaintClientComp.ACTION_COMMAND_OPEN_CLEINT_SEARCH);
        this.clientSearchButton.addActionListener(this);
        sect1.add(this.clientSearchButton, "span 2, left, wrap");

        return sect1;
    }

    private JPanel buildSection2() {
        JPanel sect2 = new JPanel();
        sect2.setLayout(new GridLayout(1, 2));

        JPanel contactInfo = new JPanel();
        contactInfo.setLayout(new MigLayout("", "[][240:240:240]",
                "[][][][][][][][]"));
        FormUtil.addPanelTitle(contactInfo, "Contact Information", Color.BLUE);
        contactInfo.add(FormUtil.createHeaderLabel("Name: "), "right, top");
        contactInfo.add(this.lblCntName, "growx, left, wrap");
        contactInfo.add(FormUtil.createHeaderLabel("Address: "), "right, top");
        contactInfo.add(this.lblCntAddr1, "growx, left, wrap");
        contactInfo.add(FormUtil.createHeaderLabel(""), "right, top");
        contactInfo.add(this.lblCntAddr2, "growx, left, wrap");
        contactInfo.add(FormUtil.createHeaderLabel(""), "right, top");
        contactInfo.add(this.lblCntAddr3, "growx, left, wrap");
        contactInfo.add(FormUtil.createHeaderLabel("City: "), "right, top");
        contactInfo.add(this.lblCntCity, "growx, left, wrap");
        contactInfo.add(FormUtil.createHeaderLabel("State: "), "right, top");
        contactInfo.add(this.lblCntState, "growx, left, wrap");
        contactInfo.add(FormUtil.createHeaderLabel("Zip: "), "right, top");
        contactInfo.add(this.lblCntZip, "growx, left, wrap");
        contactInfo.add(FormUtil.createHeaderLabel("Phone: "), "right, top");
        contactInfo.add(this.lblCntPhone, "growx, left, wrap");
        contactInfo.add(FormUtil.createHeaderLabel("Fax: "), "right, top");
        contactInfo.add(this.lblCntFax, "growx, left, wrap");

        JPanel billInfo = new JPanel();
        billInfo.setLayout(new MigLayout("", "[][240:240:240]",
                "[][][][][][][][]"));
        FormUtil.addPanelTitle(billInfo, "Billing Information", Color.BLUE);
        billInfo.add(FormUtil.createHeaderLabel("Name: "), "right, top");
        billInfo.add(this.lblBillName, "growx, left, wrap");
        billInfo.add(FormUtil.createHeaderLabel("Address: "), "right, top");
        billInfo.add(this.lblBillAddr1, "growx, left, wrap");
        billInfo.add(FormUtil.createHeaderLabel(""), "right, top");
        billInfo.add(this.lblBillAddr2, "growx, left, wrap");
        billInfo.add(FormUtil.createHeaderLabel(""), "right, top");
        billInfo.add(this.lblBillAddr3, "growx, left, wrap");
        billInfo.add(FormUtil.createHeaderLabel("City: "), "right, top");
        billInfo.add(this.lblBillCity, "growx, left, wrap");
        billInfo.add(FormUtil.createHeaderLabel("State: "), "right, top");
        billInfo.add(this.lblBillState, "growx, left, wrap");
        billInfo.add(FormUtil.createHeaderLabel("Zip: "), "right, top");
        billInfo.add(this.lblBillZip, "growx, left, wrap");
        billInfo.add(FormUtil.createHeaderLabel("Phone: "), "right, top");
        billInfo.add(this.lblBillPhone, "growx, left, wrap");
        billInfo.add(FormUtil.createHeaderLabel("Fax: "), "right, top");
        billInfo.add(this.lblBillFax, "growx, left, wrap");

        sect2.add(contactInfo);
        sect2.add(billInfo);
        return sect2;
    }

    private JPanel buildSection3() {
        JPanel sect3 = new JPanel();
        sect3.setLayout(new MigLayout("", "[][540:540:540]", "[][][]"));

        sect3.add(FormUtil.createHeaderLabel("Email: "), "right, top");
        sect3.add(this.lblEmail, "growx, left, wrap");
        sect3.add(FormUtil.createHeaderLabel("Web Site: "), "right, top");
        sect3.add(this.lblWebsite, "growx, left, wrap");
        sect3.add(FormUtil.createHeaderLabel("Comments: "), "right, top");
        sect3.add(this.lblComments, "growx, left, wrap");
        return sect3;
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
        // thread.join(100);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }

        // EventQueue.invokeLater(t);

        // Client obj = this.bo.getClientInfo(data.getClientId());
        // this.setClient(obj);
        // if (obj == null) {
        // return;
        // }

        // this.lblClientId.setText(String.valueOf(obj.getId()));
        // this.lblCntName.setText(obj.getContactFname() + " "
        // + obj.getContactLname());
        // this.lblCntAddr1.setText(obj.getContactAddress1());
        // this.lblCntAddr2.setText(obj.getContactAddress2());
        // this.lblCntAddr3.setText(obj.getContactAddress3());
        // this.lblCntCity.setText("<Get from DB>");
        // this.lblCntState.setText("<Get from DB>");
        // this.lblCntZip.setText("<Get from DB>");
        // this.lblCntPhone.setText(obj.getContactPhone());
        // this.lblCntFax.setText(obj.getContactFax());
        //
        // this.lblBillName.setText(obj.getBillingFname() + " "
        // + obj.getBillingLname());
        // this.lblBillAddr1.setText(obj.getBillingAddress1());
        // this.lblBillAddr2.setText(obj.getBillingAddress2());
        // this.lblBillAddr3.setText(obj.getBillingAddress3());
        // this.lblBillCity.setText("<Get from DB>");
        // this.lblBillState.setText("<Get from DB>");
        // this.lblBillZip.setText("<Get from DB>");
        // this.lblBillPhone.setText(obj.getBillingPhone());
        // this.lblBillFax.setText(obj.getBillingFax());
        //
        // this.lblEmail.setText(obj.getEmail());
        // this.lblWebsite.setText(obj.getWebsite());
        //
        // // Perform lookups for fields.
        // Business company = this.bo.getCompanyInfo(obj.getContactCompany());
        // this.lblClientCompName.setText(company.getLongname());
        // company = this.bo.getCompanyInfo(obj.getBillingCompany());
        // this.lblBillCompName.setText(company.getLongname());
        // // Comments comment = this.bo.getComment(obj.getCommentId());
        // this.lblComments.setText(obj.getComments());
    }

    protected void updateView(VwClientList obj) {
        this.lblClientId.setText(String.valueOf(obj.getClientId()));
        this.lblCntName.setText(obj.getContactFname() + " "
                + obj.getContactLname());
        this.lblCntAddr1.setText(obj.getContactAddress1());
        this.lblCntAddr2.setText(obj.getContactAddress2());
        this.lblCntAddr3.setText(obj.getContactAddress3());
        this.lblCntCity.setText(RMT2String.wordCap(obj.getContactCity()));
        this.lblCntState.setText(obj.getContactState());
        this.lblCntZip.setText(String.valueOf(obj.getContactZip()));
        this.lblCntPhone.setText(obj.getContactPhone());
        this.lblCntFax.setText(obj.getContactFax());

        this.lblBillName.setText(obj.getBillingFname() + " "
                + obj.getBillingLname());
        this.lblBillAddr1.setText(obj.getBillingAddress1());
        this.lblBillAddr2.setText(obj.getBillingAddress2());
        this.lblBillAddr3.setText(obj.getBillingAddress3());
        this.lblBillCity.setText(RMT2String.wordCap(obj.getBillingCity()));
        this.lblBillState.setText(obj.getBillingState());
        this.lblBillZip.setText(String.valueOf(obj.getBillingZip()));
        this.lblBillPhone.setText(obj.getBillingPhone());
        this.lblBillFax.setText(obj.getBillingFax());

        this.lblEmail.setText(obj.getEmail());
        this.lblWebsite.setText(obj.getWebsite());

        // Perform lookups for fields.
        this.lblClientCompName.setText(obj.getContactCompanyName());
        this.lblBillCompName.setText(obj.getBillingCompanyName());
        this.lblComments.setText(obj.getComments());
    }

    protected void openClientSearchWindow() {
        ClientSerachMaintDialog d = new ClientSerachMaintDialog(
                "Client Maintenance", null, new Dimension(1280, 900),
                new Point(300, 300));
        d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        d.setVisible(true);
        Object results = d.getResults();
        VwClientList client = (VwClientList) results;

        // Populate client visual controls with the data returned from
        // client search window.
        this.updateView(client);
        this.client = client;
        return;
    }

    /**
     * Responds to the clicking of the "Get Client..." button.
     * 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // FormUtil.showInfoMessageBox(this, e.getActionCommand(),
        // "Button Clicked");

        this.openClientSearchWindow();

    }

    /**
     * @param c
     *            the c to set
     */
    public void setClient(VwClientList client) {
        this.client = client;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ui.components.AbstractGuiComponentTemplate#saveChanges()
     */
    @Override
    public void saveChanges() {
        // There is nothing to save here. Just update key parms object with the
        // current client id so that remaining tabs are updated with the correct
        // client id.
        this.getData().setClientId(this.client.getClientId());
        // Notify interested components that the client id has been updated.
        ComponentUpdateCompletedEvent evt = new ComponentUpdateCompletedEvent(
                this, RMT2Constants.OperationResultCode.SUCCESS,
                "Client update successful.  The current client id, "
                        + this.getData().getClientId()
                        + ", was sent to the remaining tabs");
        this.evtDispatcher.fireEvent(evt);
    }

    private class RetrieveDataThread implements Runnable {
        private CharterOrderMaintClientComp parent;
        private CharterOrderMaintParmsBean parms;

        protected RetrieveDataThread(CharterOrderMaintClientComp parent,
                CharterOrderMaintParmsBean data) {
            this.parent = parent;
            this.parms = data;
        }

        @Override
        public void run() {
            this.fetchData();
        }

        public void fetchData() {
            VwClientList obj = cBo.getClientInfoExt(this.parms.getClientId());
            if (obj != null) {
                this.updateControls(obj);
            }
            else {
                obj = new VwClientList();
            }
            parent.setClient(obj);
        }

        private void updateControls(final VwClientList obj) {
            parent.updateView(obj);
        }
    }
}
