package org;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;

import org.dao.mapping.Business;
import org.dao.mapping.GeneralCodes;

import com.ui.components.dropdownbox.DropDownBoxColumnDefinition;
import com.ui.components.dropdownbox.DynamicDropDownBox;
import com.ui.components.dropdownbox.DynamicDropDownBoxColumnModelBuilder;

/**
 * @author rterrell
 *
 */
public class FormUtil {

    public static final int STD_DATE_CNTROL_WIDTH = 80;
    public static final int STD_TEXT_CNTROL_WIDTH = 90;
    public static final int STD_TEXT_CNTROL_HEIGHT = 20;

    /**
     * 
     */
    public FormUtil() {
        return;
    }

    /**
     * Adds a border with specified text as the title to the target panel
     * object.
     * <p>
     * By default, a titleless border can be created when <i>title</i> is null.
     * Also by default, a title with black text foreground is created when
     * <i>textColor</i> is null.
     * 
     * @param pan
     *            the target panel
     * @param title
     *            the text to display as the panel title. Defaults to "" when
     *            null.
     * @param textColor
     *            the color of the text. Defaults to black when null.
     */
    public static final void addPanelTitle(JPanel pan, String title,
            Color textColor) {
        if (title == null) {
            title = "";
        }
        if (textColor == null) {
            textColor = Color.BLACK;
        }
        TitledBorder titledBorder = BorderFactory.createTitledBorder(title);
        titledBorder.setTitleColor(textColor);
        pan.setBorder(titledBorder);
        return;
    }

    /**
     * 
     * @param value
     * @param boldText
     * @param textColor
     * @return
     */
    public static final JLabel createDataLabel(String value, boolean boldText,
            Color textColor) {
        JLabel lbl;
        if (value == null) {
            lbl = new JLabel("");
        }
        else {
            lbl = new JLabel(value);
        }
        Font font;
        if (boldText) {
            font = new Font(Font.SERIF, Font.BOLD, 12);
        }
        else {
            font = new Font(Font.SERIF, Font.PLAIN, 12);
        }
        lbl.setFont(font);
        if (textColor == null) {
            lbl.setForeground(Color.BLACK);
        }
        else {
            lbl.setForeground(textColor);
        }

        return lbl;
    }

    /**
     * 
     * @param value
     * @param boldText
     * @param textColor
     * @param width
     * @param height
     * @param alignment
     * @return
     */
    public static final JLabel createDataLabel(String value, boolean boldText,
            Color textColor, int width, int height, int alignment) {
        JLabel lbl = FormUtil.createDataLabel(value, boldText, textColor);
        Dimension dim = new Dimension(width, height);
        lbl.setPreferredSize(dim);
        lbl.setHorizontalAlignment(alignment);
        return lbl;
    }

    /**
     * 
     * @param value
     * @param boldText
     * @param textColor
     * @param width
     * @param height
     * @param alignment
     * @param textSize
     * @return
     */
    public static final JLabel createDataLabel(String value, boolean boldText,
            Color textColor, int width, int height, int alignment, int textSize) {
        JLabel lbl = FormUtil.createDataLabel(value, boldText, textColor,
                width, height, alignment);
        Font font;
        if (boldText) {
            font = new Font(Font.SERIF, Font.BOLD, textSize);
        }
        else {
            font = new Font(Font.SERIF, Font.PLAIN, textSize);
        }
        lbl.setFont(font);
        return lbl;
    }

    /**
     * 
     * @param value
     * @return
     */
    public static final JLabel createHeaderLabel(String value) {
        JLabel lbl = new JLabel(value);
        lbl.setHorizontalAlignment(SwingConstants.RIGHT);
        Font font = new Font(Font.SERIF, Font.BOLD, 12);
        lbl.setFont(font);
        return lbl;
    }

    /**
     * Creates a header label prefixed with a "required" indicator.
     * 
     * @param value
     *            the original header text
     * @param requiredInd
     *            a String representing the required indicator
     * @param requiredIndColor
     *            the color of the indicator
     * @return a {@link JLabel} object which its text is prefix with the
     *         required indicator
     */
    public static final JLabel createHeaderLabel(String value,
            String requiredInd, String requiredIndColor) {
        StringBuffer h = new StringBuffer();
        h.append("<HTML><B><FONT color=");
        h.append(requiredIndColor);
        h.append(">");
        h.append(requiredInd);
        h.append("&nbsp;</FONT></B>");
        h.append(value);
        h.append("</HTML>");
        JLabel lbl = FormUtil.createHeaderLabel(h.toString());
        return lbl;
    }

    /**
     * Creates a header label prefixed with a RED required indicator character,
     * '*'.
     * 
     * @param value
     *            the original header text
     * @param required
     *            true signals to include the required indicator and false will
     *            render the JLabel just the orginal text as is.
     * @return a {@link JLabel} object
     */
    public static final JLabel createHeaderLabel(String value, boolean required) {
        JLabel lbl = null;
        if (required) {
            lbl = FormUtil.createHeaderLabel(value, "*", "RED");
        }
        else {
            lbl = FormUtil.createHeaderLabel(value);
        }
        return lbl;
    }

    /**
     * 
     * @param parent
     * @param value
     * @param readOnly
     * @return
     */
    public static final JTextField createTextField(Component parent,
            String value, boolean readOnly) {
        JTextField cntrl;
        if (value == null) {
            cntrl = new JTextField("");
        }
        else {
            cntrl = new JTextField(value);
        }
        Font font = new Font(Font.SERIF, Font.PLAIN, 14);
        cntrl.setFont(font);
        cntrl.setForeground(Color.BLACK);
        if (readOnly) {
            cntrl.setBackground(parent.getBackground());
            cntrl.setEditable(false);
            cntrl.setBorder(null);
        }
        return cntrl;
    }

    /**
     * 
     * @param parent
     * @param value
     * @param readOnly
     * @param width
     * @param height
     * @param alignment
     * @return
     */
    public static final JTextField createTextField(Component parent,
            String value, boolean readOnly, int width, int height, int alignment) {
        JTextField cntrl = FormUtil.createTextField(parent, value, readOnly);
        Dimension dim = new Dimension(width, height);
        cntrl.setPreferredSize(dim);
        cntrl.setHorizontalAlignment(alignment);
        return cntrl;
    }

    /**
     * 
     * @param parent
     * @param value
     * @param readOnly
     * @param rows
     * @return
     */
    public static final JTextArea createTextArea(Component parent,
            String value, boolean readOnly, int rows) {
        JTextArea cntrl;
        if (value == null) {
            cntrl = new JTextArea();
        }
        else {
            cntrl = new JTextArea(value);
        }
        if (rows <= 0) {
            rows = 5;
        }
        cntrl.setRows(rows);
        cntrl.setLineWrap(true);
        cntrl.setEditable(true);
        if (!readOnly) {
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            cntrl.setBorder(BorderFactory.createCompoundBorder(border,
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        }
        Font font = new Font(Font.SERIF, Font.PLAIN, 14);
        cntrl.setFont(font);
        cntrl.setForeground(Color.BLACK);
        if (readOnly) {
            cntrl.setBackground(parent.getBackground());
        }

        return cntrl;
    }

    /**
     * 
     * @param def
     * @param items
     * @return
     */
    public static final <E> DynamicDropDownBox<E> createDropDownBox(
            DropDownBoxColumnDefinition def, List<E> items) {
        DynamicDropDownBoxColumnModelBuilder<E> b = new DynamicDropDownBoxColumnModelBuilder<E>(
                items, def);
        DynamicDropDownBox<E> ddb = b.createInstance();
        return ddb;
    }

    /**
     * Creates a company drop down box.
     * 
     * @param selectedKey
     *            the key of the object that will show as selected in the drop
     *            down box
     * @param width
     *            The visible width of the control. Defaults to 70 pixels in the
     *            event the value is less than 1.
     * @return an instnace of {@link DropDownBox}
     */
    public static final DynamicDropDownBox<Business> createCompanyInfoDDB(
            List<Business> items, String selectedKey, int width) {

        if (width <= 0) {
            width = 70;
        }
        DropDownBoxColumnDefinition col = new DropDownBoxColumnDefinition("id",
                "longname", 0, width);
        DynamicDropDownBox<Business> ddb = FormUtil.createDropDownBox(col,
                items);
        // Try to set default item
        // ddb.setSelectedItem(items.get(1));
        // ddb.selectItemByKey(items.get(1).getId());
        // ddb.selectItemByDisplayValue(items.get(1).getName());
        // ddb.selectItemByDisplayValue("XYZ Electrical/Plumbing Company");
        return ddb;
    }

    public static final DynamicDropDownBox<GeneralCodes> createGeneralCodesDDB(
            List<GeneralCodes> items, String selectedKey, int width) {

        if (width <= 0) {
            width = 70;
        }
        DropDownBoxColumnDefinition col = new DropDownBoxColumnDefinition(
                "codeId", "longdesc", 0, width);
        DynamicDropDownBox<GeneralCodes> ddb = FormUtil.createDropDownBox(col,
                items);
        // // Try to set default item
        // ddb.setSelectedItem(items.get(1));
        return ddb;
    }

    /**
     * 
     * @param text
     * @param textPosition
     * @param selected
     * @param boldText
     * @return
     */
    public static final JCheckBox createCheckBox(String text, int textPosition,
            boolean selected, boolean boldText) {
        JCheckBox cbx = new JCheckBox(text);

        cbx.setSelected(selected);

        Font font = null;
        if (boldText) {
            font = new Font(Font.SERIF, Font.BOLD, 12);
        }
        else {
            font = new Font(Font.SERIF, Font.PLAIN, 12);
        }
        cbx.setFont(font);
        cbx.setForeground(Color.BLACK);

        if (textPosition == SwingConstants.LEFT
                || textPosition == SwingConstants.RIGHT) {
            cbx.setHorizontalTextPosition(textPosition);
        }
        else {
            cbx.setHorizontalTextPosition(SwingConstants.LEFT);
        }

        return cbx;
    }

    /**
     * 
     * @param parent
     * @param message
     * @param title
     */
    public static final void showInfoMessageBox(Component parent,
            String message, String title) {
        JOptionPane.showMessageDialog(parent, message, title,
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * 
     * @param parent
     * @param message
     * @param title
     */
    public static final void showErrorMessageBox(Component parent,
            String message, String title) {
        JOptionPane.showMessageDialog(parent, message, title,
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * 
     * @param comp
     * @param text
     * @param error
     */
    public static final void showStatusMessage(JLabel comp, String text,
            boolean error) {
        if (comp == null) {
            return;
        }
        Font font = null;
        font = new Font(Font.SERIF, Font.BOLD, 14);
        comp.setFont(font);
        if (error) {
            comp.setForeground(Color.RED);
        }
        else {
            comp.setForeground(Color.BLACK);
        }
        comp.setText(text);
        return;
    }

    /**
     * Get the user entered value from an arbitrary input control.
     * 
     * @param cntrl
     * @return The value entered by the user.
     */
    public static final Object getInputControlValue(Object cntrl) {
        if (cntrl instanceof DynamicDropDownBox) {
            return ((DynamicDropDownBox) cntrl).getSelectedItem();
        }
        if (cntrl instanceof JTextComponent) {
            return ((JTextComponent) cntrl).getText();
        }
        return null;
    }
}
