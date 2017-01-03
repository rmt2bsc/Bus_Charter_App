package org.maint.charterorder;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

import org.dao.BusCharterDao;
import org.dao.BusCharterDaoFactory;
import org.dao.mapping.Client;
import org.dao.mapping.Orders;
import org.dao.mapping.Quote;

import com.InvalidGuiDataException;
import com.ProcessDataFailureException;
import com.ui.window.AbstractSdiModalWindow;
import com.ui.window.WindowActionListener;
import com.util.RMT2SwingUtil;

/**
 * @author rterrell
 *
 */
public class CharterOrderMaint extends AbstractSdiModalWindow {

    private static final long serialVersionUID = 1746311868533836L;

    /**
     * The Save Command button
     */
    private JButton saveButton;

    private JTextField balanceField;
    private JTextField clientCompField;
    private JTextField billCompField;
    private JTextField ctcNameField;
    private JTextField ctcAddrField;

    private JTextField billNameField;
    private JTextField billAddrField;

    /**
     * Default constructor
     */
    protected CharterOrderMaint() {
        return;
    }

    /**
     * Creates a CharterOrderMaint initialized with data to populate all tabs.
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
    public CharterOrderMaint(String winTitle, Object data, Dimension size,
            Point pos) {
        super((Dialog) null, data, size, pos, winTitle);

        // TODO: Create and cast <data> as a member variable.

        return;
    }

    @Override
    protected void initDialog() {
        super.initDialog();

        // Create additional command buttons starting at position #1
        saveButton = new JButton("Save");
        saveButton.setActionCommand(WindowActionListener.ACTION_COMMAND_SAVE);
        saveButton.setEnabled(false);
        saveButton.addActionListener(this);
        buttonPane.add(saveButton, 1);
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
        titlePanel.setLayout(new MigLayout("", "[grow]50[][grow]", "[]"));

        JLabel lblTitle = new JLabel(this.winTitle + " -  Order: ");
        Font font = new Font(Font.SERIF, Font.BOLD, 20);
        lblTitle.setFont(font);
        lblTitle.setForeground(Color.BLUE);
        titlePanel.add(lblTitle);

        JLabel lblBal = new JLabel("Balance Due: ");
        font = new Font(Font.SERIF, Font.BOLD, 20);
        lblBal.setFont(font);
        lblBal.setForeground(Color.BLUE);
        titlePanel.add(lblBal);

        balanceField = new JTextField();
        font = new Font(Font.SERIF, Font.BOLD, 20);
        balanceField.setForeground(Color.RED);
        balanceField.setBackground(Color.WHITE);
        balanceField.setFont(font);
        balanceField.setText("0.00");
        balanceField.setSize(new Dimension(180, 40));
        balanceField.setEditable(false);
        balanceField.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(balanceField, "growx");

        JPanel tabPanel = this.createTabs();

        // Setup the main panel with criteria and results sections
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new MigLayout("", "[grow]", "[]"));
        mainPanel.add(titlePanel, "dock north, wrap");
        mainPanel.add(tabPanel, "dock center, w 500");

        return mainPanel;
    }

    private JPanel createTabs() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 1));
        JTabbedPane tp = new JTabbedPane(JTabbedPane.TOP);

        int clientId = 0;

        // Add tab components
        ImageIcon icon = RMT2SwingUtil.createImageIcon("images/middle.gif");
        tp.insertTab("Client", icon, this.createClientComponent(clientId),
                "Manages Client information for Charter Order", 0);
        tp.insertTab("Trip", icon, this.createTripComponent(),
                "Manages Trip information for Charter Order", 1);
        tp.insertTab("Financials", icon, this.createFinancialsComponent(),
                "Manages Charter Order financial information", 2);
        tp.insertTab("Transactions", icon, this.createTransactionsComponent(),
                "Manages transactions pertaining to the Charter Order", 3);
        tp.insertTab("Expenses", icon, this.createExpensesComponent(),
                "Manages Expense information for Charter Order", 4);
        tp.insertTab("Invoice Summary", icon,
                this.createInvoiceSummaryComponent(),
                "Manages Invoice Summary information for Charter Order", 5);

        p.add(tp);
        return p;
    }

    private JPanel createClientComponent(int clientId) {
        BusCharterDao dao = BusCharterDaoFactory.createDao(null);
        List<Client> items = dao.geClient(clientId);
        CharterOrderMaintClientComp clientComp = new CharterOrderMaintClientComp(
                items);
        return clientComp;
    }

    private JPanel createTripComponent() {
        Quote q = new Quote();
        List<Quote> list = new ArrayList<Quote>();
        list.add(q);
        CharterOrderMaintTripComp tripComp = new CharterOrderMaintTripComp(list);
        return tripComp;
    }

    private JPanel createFinancialsComponent() {
        Orders q = new Orders();
        List<Orders> list = new ArrayList<Orders>();
        list.add(q);
        CharterOrderMaintFinanceComp comp = new CharterOrderMaintFinanceComp(
                list);
        return comp;
    }

    private JPanel createTransactionsComponent() {
        JPanel p = new JPanel();
        p.setLayout(new MigLayout("insets 0 10 10 20", "[][grow]",
                "[][][][][][]"));
        return p;
    }

    private JPanel createExpensesComponent() {
        JPanel p = new JPanel();
        p.setLayout(new MigLayout("insets 0 10 10 20", "[][grow]",
                "[][][][][][]"));
        return p;
    }

    private JPanel createInvoiceSummaryComponent() {
        JPanel p = new JPanel();
        p.setLayout(new MigLayout("insets 0 10 10 20", "[][grow]",
                "[][][][][][]"));
        return p;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ui.window.WindowActionListener#getInputData()
     */
    @Override
    public Object getInputData() throws InvalidGuiDataException {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ui.window.WindowActionListener#processData(java.lang.Object)
     */
    @Override
    public Object processData(Object data) throws ProcessDataFailureException {
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        String command = e.getActionCommand();
        if (command.equals(WindowActionListener.ACTION_COMMAND_EDIT)) {
            this.processAction(e);
            return;
        }
    }

    private JLabel createDataLabel(String value) {
        JLabel lbl = new JLabel(value);
        Font font = new Font(Font.SERIF, Font.PLAIN, 12);
        lbl.setFont(font);
        lbl.setForeground(Color.BLUE);
        return lbl;
    }

    private JLabel createHeaderLabel(String value) {
        JLabel lbl = new JLabel(value);
        lbl.setHorizontalAlignment(SwingConstants.RIGHT);
        Font font = new Font(Font.SERIF, Font.BOLD, 12);
        lbl.setFont(font);
        return lbl;
    }
}
