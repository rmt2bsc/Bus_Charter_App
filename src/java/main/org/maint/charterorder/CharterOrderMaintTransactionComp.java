package org.maint.charterorder;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

import org.dao.BusCharterDaoConst;
import org.dao.mapping.GeneralCodes;
import org.dao.mapping.Transaction;

import com.ui.components.AbstractGuiComponentTemplate;
import com.ui.components.dropdownbox.DropDownBoxColumnDefinition;
import com.ui.components.table.CustomComboBoxCellEditor;
import com.ui.components.table.CustomComboBoxCellRenderer;
import com.ui.components.table.CustomDateFieldCellEditor;
import com.ui.components.table.CustomMoneyFieldCellEditor;
import com.ui.components.table.CustomTextFieldCellEditor;
import com.ui.components.table.DataGrid;
import com.ui.components.table.DataGridModel;
import com.ui.components.table.ScrollableDataGrid;
import com.ui.components.table.TableColumnDefinition;
import com.ui.event.CustomItemDoubleClickedEvent;
import com.ui.event.CustomItemSelectedEvent;
import com.ui.event.CustomSelectionListener;

/**
 * A component for displaying and associating transaction data with the Charter
 * Order.
 * 
 * @author Roy Terrell
 *
 */
public class CharterOrderMaintTransactionComp extends
        AbstractGuiComponentTemplate<CharterOrderMaintParmsBean> implements
        CustomSelectionListener, ActionListener {

    private static final long serialVersionUID = 4885982443482429370L;

    /**
     * The action command to open Add Bus window.
     */
    public static final String ACTION_COMMAND_ADD_TRAN = "ADD_TRAN";
    public static final String ACTION_COMMAND_DEL_TRAN = "DEL_TRAN";

    private Transaction trans;
    // private List<Transaction> transList;
    // private List<Transaction> deletedTransList;

    private JButton butDel;
    private JButton butAdd;

    private List<GeneralCodes> tranTypeItems;
    private List<GeneralCodes> tenderItems;

    private ScrollableDataGrid grid;

    private CharterOrderBO bo;

    /**
     * 
     */
    public CharterOrderMaintTransactionComp(CharterOrderMaintParmsBean parms) {
        super(parms);
        return;
    }

    protected void initFields() {
        // this.transList = new ArrayList<Transaction>();
        // this.deletedTransList = new ArrayList<Transaction>();
        this.bo = new CharterOrderBO();

        // Populate drop downs
        tenderItems = this.bo
                .getLookupCodeByGroup(BusCharterDaoConst.LOOKUP_GRP_TENDERCODE);
        tranTypeItems = this.bo
                .getLookupCodeByGroup(BusCharterDaoConst.LOOKUP_GRP_TRANSACTIONTYPE);
        this.butAdd = new JButton("Add");
        this.butAdd.addActionListener(this);
        this.butAdd
                .setActionCommand(CharterOrderMaintTransactionComp.ACTION_COMMAND_ADD_TRAN);
        this.butDel = new JButton("Delete");
        this.butDel.addActionListener(this);
        this.butDel
                .setActionCommand(CharterOrderMaintTransactionComp.ACTION_COMMAND_DEL_TRAN);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.maint.charterorder.AbstractGuiComponentTemplate#setupView()
     */
    @Override
    protected void setupView() {
        this.grid = this.buildSection1();
        this.add(this.grid, "wrap, wrap");
        // JScrollPane sp = this.buildSection();
        // this.add(sp, "wrap, wrap");
        JPanel sect2 = this.buildSection2();
        this.add(sect2, "wrap, wrap");
    }

    private ScrollableDataGrid buildSection1() {
        // Build grid with data
        ScrollableDataGrid g = this.createDataGrid();
        return g;
    }

    private JPanel buildSection2() {
        JPanel sect = new JPanel();
        sect.setLayout(new MigLayout("", "[]20[]", "[]"));
        sect.add(this.butAdd, "top, left");
        sect.add(this.butDel, "top, left, wrap");
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
    private ScrollableDataGrid createDataGrid() {

        // Setup column definitions
        List<TableColumnDefinition> colDefs = new ArrayList<TableColumnDefinition>();
        TableColumnDefinition tcd = null;
        colDefs.add(new TableColumnDefinition("id", "Trans Id", 0, 40));

        // Setup Amount editor
        tcd = new TableColumnDefinition("amount", "Amount", "(#,##0.00)", 1,
                80, SwingConstants.RIGHT);
        tcd.setCellEditor(new CustomMoneyFieldCellEditor());
        colDefs.add(tcd);

        // Setup Transaction Date editor
        tcd = new TableColumnDefinition("transDate", "Date", "MM/dd/yyyy", 2,
                80);
        tcd.setCellEditor(new CustomDateFieldCellEditor());
        colDefs.add(tcd);

        DropDownBoxColumnDefinition ddbcd = new DropDownBoxColumnDefinition(
                "codeId", "longdesc");
        // Setup transcation type dropdown editor
        tcd = new TableColumnDefinition("transTypeId", "Transaction Type", 3,
                130);
        tcd.setCellEditor(new CustomComboBoxCellEditor(this.tranTypeItems,
                ddbcd));
        tcd.setCellRenderer(new CustomComboBoxCellRenderer(ddbcd,
                this.tranTypeItems));
        colDefs.add(tcd);

        // Setup payment tender dropdown editor
        tcd = new TableColumnDefinition("paymentType", "Payment Tender", 4, 130);
        tcd.setCellEditor(new CustomComboBoxCellEditor(this.tenderItems, ddbcd));
        tcd.setCellRenderer(new CustomComboBoxCellRenderer(ddbcd,
                this.tenderItems));
        colDefs.add(tcd);

        // Setup check number editor
        tcd = new TableColumnDefinition("checkNo", "Check No.", "#,##0", 5, 90,
                SwingConstants.CENTER);
        tcd.setCellEditor(new CustomTextFieldCellEditor());
        colDefs.add(tcd);

        // Setup notes editor
        tcd = new TableColumnDefinition("notes", "Notes", 6, 290);
        tcd.setCellEditor(new CustomTextFieldCellEditor());
        colDefs.add(tcd);

        // Set the size of the data grid component
        Dimension size = new Dimension(840, 350);
        DataGrid table = new DataGrid(null, colDefs,
                ListSelectionModel.SINGLE_SELECTION, size);
        table.setup();

        // Identify those columns that need to use special comparators for
        // sorting.
        int numericCols[] = { 0, 1 };
        table.setNumericColumnSorter(numericCols);
        int dateCols[] = { 2 };
        table.setDateColumnSorter(dateCols);
        table.addItemSelectionListener(this);

        // Create ScrollableDataGrid grid component
        ScrollableDataGrid dg = new ScrollableDataGrid(table);

        return dg;
    }

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
        // thread.join(100);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }

        // EventQueue.invokeLater(t);

        // List<Transaction> obj = this.bo.getTransactions(parms.getOrderId());
        // if (obj == null) {
        // return;
        // }
        // this.grid.getTableView().loadTable(obj);
        // // this.transList = obj;
    }

    /**
     * 
     */
    private void addTransactionToList() {
        Transaction trans = new Transaction();
        int row = this.grid.getTableView().addGridRow(trans);
        // this.grid.refreshGrid();
        return;
    }

    private void deleteTransactionFromList() {
        int row = this.grid.getTableView().getSelectedRow();
        Transaction trans = (Transaction) this.grid.getTableView()
                .getSelectedRowData(row);
        if (trans != null) {
            // this.deletedTransList.add(trans);
            this.grid.getTableView().removeGridRow(row);
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
        switch (e.getActionCommand()) {
            case (CharterOrderMaintTransactionComp.ACTION_COMMAND_ADD_TRAN):
                this.addTransactionToList();
                break;
            case (CharterOrderMaintTransactionComp.ACTION_COMMAND_DEL_TRAN):
                this.deleteTransactionFromList();
                break;
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
        // TODO Auto-generated method stub

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
        this.trans = (Transaction) evt.getSelectedItem();
        return;
    }

    private class RetrieveDataThread implements Runnable {
        private CharterOrderMaintTransactionComp parent;
        private CharterOrderMaintParmsBean parms;

        protected RetrieveDataThread(CharterOrderMaintTransactionComp parent,
                CharterOrderMaintParmsBean data) {
            this.parent = parent;
            this.parms = data;
        }

        @Override
        public void run() {
            this.fetchData();
        }

        public void fetchData() {
            List<Transaction> obj = bo.getTransactions(parms.getOrderId());
            if (obj == null) {
                obj = new ArrayList<Transaction>();
            }
            this.updateControls(obj);
            return;
        }

        private void updateControls(final List<Transaction> obj) {
            parent.grid.getTableView().loadTable(obj);

            // SwingUtilities.invokeLater(new Runnable() {
            //
            // @Override
            // public void run() {
            // parent.grid.getTableView().loadTable(obj);
            // }
            // });
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ui.components.AbstractGuiComponentTemplate#saveChanges()
     */
    @Override
    public void saveChanges() {
        DataGridModel m = (DataGridModel) this.grid.getTableView().getModel();
        List viewList = m.getViewBuf();
        List delList = m.getDeletedBuf();

        // Ensure that all new and modified transactions are associated with an
        // order id
        for (int ndx = 0; ndx < viewList.size(); ndx++) {
            Transaction item = (Transaction) viewList.get(ndx);
            item.setOrderId(this.getData().getOrderId());
        }
        // Begin to persist changes
        // this.bo.beginTrans();
        try {
            this.bo.updateTransaction(viewList);
            this.bo.deleteTransaction(delList);
            // this.bo.commitTrans();
        } catch (Exception e) {
            // this.bo.rollbackTrans();
            throw e;
        }
    }

}
