package org.maint.charterorder;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.SwingConstants;

import com.ui.components.table.CustomLabelCellRenderer;

/**
 * JLabel cell renderer for the DataGrid in Charter Order Maintenance Invoice
 * Summary Component
 * 
 * @author appdev
 *
 */
public class InvoiceLabelTableCellRenderer extends CustomLabelCellRenderer {

    private static final long serialVersionUID = -9076751526058570753L;

    /**
     * 
     */
    public InvoiceLabelTableCellRenderer() {
        super(SwingConstants.TOP);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ui.components.table.CustomLabelCellRenderer#getTableCellRendererComponent
     * (javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                row, column);

        switch (column) {
            case 3:
            case 4:
                this.setHorizontalAlignment(SwingConstants.RIGHT);
        }

        // Handle summary row
        if (row == (table.getModel().getRowCount() - 1)) {
            Font f = new Font(Font.SERIF, Font.BOLD, 13);
            this.setFont(f);
            if (column == 1) {
                this.setText("");
            }
        }
        return this;
    }

}
