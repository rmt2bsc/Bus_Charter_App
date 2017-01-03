package org.maint.charterorder;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

import org.FormUtil;
import org.dao.mapping.VwInvoiceSummary;

import com.ui.components.AbstractGuiComponentTemplate;
import com.ui.components.table.DataGrid;
import com.ui.components.table.ScrollableDataGrid;
import com.ui.components.table.TableColumnDefinition;

/**
 * A component for displaying and associating expense data associated with the
 * Charter Order.
 * 
 * @author Roy Terrell
 *
 */
public class CharterOrderMaintInvoiceSummaryComp extends
        AbstractGuiComponentTemplate<CharterOrderMaintParmsBean> {

    private static final long serialVersionUID = 4885982443482429370L;

    // private List<VwInvoiceSummary> items;

    private JLabel lblTotalUnitCost;
    private JLabel lblTotalCost;
    private ScrollableDataGrid grid;

    private CharterOrderBO bo;

    /**
     * 
     */
    public CharterOrderMaintInvoiceSummaryComp(CharterOrderMaintParmsBean parms) {
        super(parms);
        return;
    }

    protected void initFields() {
        this.bo = new CharterOrderBO();
        this.lblTotalUnitCost = FormUtil
                .createDataLabel(null, true, Color.BLUE);
        this.lblTotalCost = FormUtil.createDataLabel(null, true, Color.BLUE);
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
        sect.add(this.lblTotalUnitCost, "top, left");
        sect.add(this.lblTotalCost, "top, left, wrap");
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

        // Setup Category
        tcd = new TableColumnDefinition("category", "Category", 0, 130);
        tcd.setCellRenderer(new InvoiceLabelTableCellRenderer());
        colDefs.add(tcd);

        // Setup Bus Count
        tcd = new TableColumnDefinition("busCount", "Bus Count", "#,##0", 1,
                80, SwingConstants.RIGHT);
        tcd.setCellRenderer(new InvoiceLabelTableCellRenderer());
        colDefs.add(tcd);

        // Setup Description
        tcd = new TableColumnDefinition("description", "Description", 2, 290);
        tcd.setCellRenderer(new InvoiceTextAreaTableCellRenderer());
        colDefs.add(tcd);

        // Setup unit cost
        tcd = new TableColumnDefinition("tripCost", "Unit Cost", 3, 80);
        tcd.setCellRenderer(new InvoiceLabelTableCellRenderer());
        colDefs.add(tcd);

        // Setup total cost
        tcd = new TableColumnDefinition("totalCost", "Total Cost", 4, 80);
        tcd.setCellRenderer(new InvoiceLabelTableCellRenderer());
        colDefs.add(tcd);

        // Set the size of the data grid component
        Dimension size = new Dimension(0, 350);
        DataGrid table = new DataGrid(null, colDefs, -1, size);
        table.setup();

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

        // EventQueue.invokeLater(t);
    }

    private class RetrieveDataThread implements Runnable {
        private CharterOrderMaintInvoiceSummaryComp parent;
        private CharterOrderMaintParmsBean parms;

        protected RetrieveDataThread(
                CharterOrderMaintInvoiceSummaryComp parent,
                CharterOrderMaintParmsBean data) {
            this.parent = parent;
            this.parms = data;
        }

        @Override
        public void run() {
            this.fetchData();
        }

        public void fetchData() {
            List<VwInvoiceSummary> obj = bo.getInvoiceSummary(parms
                    .getOrderId());
            if (obj == null) {
                obj = new ArrayList<VwInvoiceSummary>();
            }
            this.updateControls(obj);
            return;
        }

        private void updateControls(final List<VwInvoiceSummary> obj) {
            // parent.grid.getTableView().loadTable(obj);

            // Prepare summary row
            final VwInvoiceSummary totalRow = new VwInvoiceSummary();
            double unitCostSummmed = 0;
            double totalCostSummed = 0;
            for (VwInvoiceSummary item : obj) {
                unitCostSummmed += item.getTripCost();
                totalCostSummed += item.getTotalCost();
            }
            totalRow.setDescription("Total Due:");
            totalRow.setTripCost(unitCostSummmed);
            totalRow.setTotalCost(totalCostSummed);

            parent.grid.getTableView().loadTable(obj);
            parent.grid.getTableView().addGridRow(totalRow);

            // SwingUtilities.invokeLater(new Runnable() {
            //
            // @Override
            // public void run() {
            // parent.grid.getTableView().loadTable(obj);
            // parent.grid.getTableView().addGridRow(totalRow);
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
        // TODO Auto-generated method stub

    }

}
