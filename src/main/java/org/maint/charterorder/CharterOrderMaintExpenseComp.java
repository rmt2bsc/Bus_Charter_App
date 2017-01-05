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

import org.dao.mapping.Expenses;
import org.dao.mapping.OrderExpenses;

import com.ui.components.AbstractGuiComponentTemplate;
import com.ui.components.dropdownbox.DropDownBoxColumnDefinition;
import com.ui.components.table.CustomComboBoxCellEditor;
import com.ui.components.table.CustomComboBoxCellRenderer;
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
 * A component for displaying and associating expense data associated with the
 * Charter Order.
 * 
 * @author Roy Terrell
 *
 */
public class CharterOrderMaintExpenseComp extends
        AbstractGuiComponentTemplate<CharterOrderMaintParmsBean> implements
        CustomSelectionListener, ActionListener {

    private static final long serialVersionUID = 4885982443482429370L;

    /**
     * The action command to open Add Bus window.
     */
    public static final String ACTION_COMMAND_ADD_TRAN = "ADD_TRAN";
    public static final String ACTION_COMMAND_DEL_TRAN = "DEL_TRAN";

    private OrderExpenses ordExp;

    private JButton butDel;
    private JButton butAdd;

    private List<Expenses> expenseTypeItems;

    private ScrollableDataGrid grid;

    private CharterOrderBO bo;

    /**
     * 
     */
    public CharterOrderMaintExpenseComp(CharterOrderMaintParmsBean parms) {
        super(parms);
        return;
    }

    protected void initFields() {
        this.bo = new CharterOrderBO();

        // Populate drop downs
        expenseTypeItems = this.bo.getExpenseType();
        this.butAdd = new JButton("Add");
        this.butAdd.addActionListener(this);
        this.butAdd
                .setActionCommand(CharterOrderMaintExpenseComp.ACTION_COMMAND_ADD_TRAN);
        this.butDel = new JButton("Delete");
        this.butDel.addActionListener(this);
        this.butDel
                .setActionCommand(CharterOrderMaintExpenseComp.ACTION_COMMAND_DEL_TRAN);
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
        DropDownBoxColumnDefinition ddbcd = new DropDownBoxColumnDefinition(
                "id", "description");
        // Setup column definitions
        List<TableColumnDefinition> colDefs = new ArrayList<TableColumnDefinition>();
        TableColumnDefinition tcd = null;

        // Setup expense type dropdown editor
        tcd = new TableColumnDefinition("expenseId", "Expense", 0, 130);
        tcd.setCellEditor(new CustomComboBoxCellEditor(this.expenseTypeItems,
                ddbcd));
        tcd.setCellRenderer(new CustomComboBoxCellRenderer(ddbcd,
                this.expenseTypeItems));
        colDefs.add(tcd);

        // Setup Amount editor
        tcd = new TableColumnDefinition("amount", "Amount", "(#,##0.00)", 1,
                80, SwingConstants.RIGHT);
        tcd.setCellEditor(new CustomMoneyFieldCellEditor());
        colDefs.add(tcd);

        // Setup reason editor
        tcd = new TableColumnDefinition("description", "Reason", 2, 290);
        tcd.setCellEditor(new CustomTextFieldCellEditor());
        colDefs.add(tcd);

        // Setup order expense date created
        tcd = new TableColumnDefinition("dateCreated", "Date Created",
                "MM/dd/yyyy", 3, 80);
        colDefs.add(tcd);

        // Setup order expense date updated
        tcd = new TableColumnDefinition("dateUpdated", "Date Updated",
                "MM/dd/yyyy", 4, 80);
        colDefs.add(tcd);

        // Setup user id
        tcd = new TableColumnDefinition("userId", "User Id", 5, 80);
        colDefs.add(tcd);

        // Set the size of the data grid component
        Dimension size = new Dimension(0, 350);
        DataGrid table = new DataGrid(null, colDefs,
                ListSelectionModel.SINGLE_SELECTION, size);
        table.setup();

        // Identify those columns that need to use special comparators for
        // sorting.
        int numericCols[] = { 1 };
        table.setNumericColumnSorter(numericCols);
        int dateCols[] = { 3, 4 };
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

        // List<OrderExpenses> obj =
        // this.bo.getOrderExpense(parms.getOrderId());
        // if (obj == null) {
        // return;
        // }
        // this.grid.getTableView().loadTable(obj);
    }

    /**
     * 
     */
    private void addOrderExpenseToList() {
        OrderExpenses trans = new OrderExpenses();
        this.grid.getTableView().addGridRow(trans);
        // this.grid.refreshGrid();
        return;
    }

    private void deleteOrderExpenseFromList() {
        int row = this.grid.getTableView().getSelectedRow();
        OrderExpenses trans = (OrderExpenses) this.grid.getTableView()
                .getSelectedRowData(row);
        if (trans != null) {
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
            case (CharterOrderMaintExpenseComp.ACTION_COMMAND_ADD_TRAN):
                this.addOrderExpenseToList();
                break;
            case (CharterOrderMaintExpenseComp.ACTION_COMMAND_DEL_TRAN):
                this.deleteOrderExpenseFromList();
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
        this.ordExp = (OrderExpenses) evt.getSelectedItem();
        return;
    }

    private class RetrieveDataThread implements Runnable {
        private CharterOrderMaintExpenseComp parent;
        private CharterOrderMaintParmsBean parms;

        protected RetrieveDataThread(CharterOrderMaintExpenseComp parent,
                CharterOrderMaintParmsBean data) {
            this.parent = parent;
            this.parms = data;
        }

        @Override
        public void run() {
            this.fetchData();
        }

        public void fetchData() {
            List<OrderExpenses> obj = bo.getOrderExpense(parms.getOrderId());
            if (obj == null) {
                obj = new ArrayList<OrderExpenses>();
            }
            this.updateControls(obj);
            return;
        }

        private void updateControls(final List<OrderExpenses> obj) {
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
        // logic to update expenses here...
        DataGridModel m = (DataGridModel) this.grid.getTableView().getModel();
        List viewList = m.getViewBuf();
        List delList = m.getDeletedBuf();

        // Ensure that all new and modified transactions are associated with an
        // order id
        for (int ndx = 0; ndx < viewList.size(); ndx++) {
            OrderExpenses item = (OrderExpenses) viewList.get(ndx);
            item.setOrderId(this.getData().getOrderId());
        }
        // Begin to persist changes
        // this.bo.beginTrans();
        try {
            this.bo.updateOrderExpense(viewList);
            this.bo.deleteOrderExpense(delList);
            // this.bo.commitTrans();
        } catch (Exception e) {
            // this.bo.rollbackTrans();
            throw e;
        }

        // // Notify interested components that the order id has been updated.
        // ComponentUpdateCompletedEvent evt = new
        // ComponentUpdateCompletedEvent(
        // this, RMT2Constants.OperationResultCode.SUCCESS,
        // "Expenses update successful.  The current order id (order id), "
        // + this.getData().getOrderId()
        // + ", was sent to the remaining tabs");
        // // Update key parms object with the current order id so that
        // remaining
        // // tabs can reference the correct quote.
        // this.evtDispatcher.fireEvent(evt);

    }

}
