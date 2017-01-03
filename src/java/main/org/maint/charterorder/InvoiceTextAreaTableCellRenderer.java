package org.maint.charterorder;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;

import com.ui.components.table.CustomTextAreaCellRenderer;

/**
 * JTextArea cell renderer for the DataGrid in Charter Order Maintenance Invoice
 * Summary Component
 * 
 * @author appdev
 *
 */
public class InvoiceTextAreaTableCellRenderer extends
        CustomTextAreaCellRenderer {

    private static final long serialVersionUID = -6796260332604967958L;

    /**
     * 
     */
    public InvoiceTextAreaTableCellRenderer() {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ui.components.table.CustomTextAreaCellRenderer#
     * getTableCellRendererComponent(javax.swing.JTable, java.lang.Object,
     * boolean, boolean, int, int)
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                row, column);

        // Handle summary row
        if (row == (table.getModel().getRowCount() - 1)) {
            Font f = new Font(Font.SERIF, Font.BOLD, 13);
            this.setFont(f);
        }
        return this;
    }

}
