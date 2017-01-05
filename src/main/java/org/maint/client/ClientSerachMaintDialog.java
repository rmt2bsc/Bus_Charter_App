package org.maint.client;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.WindowConst;

import com.InvalidGuiDataException;
import com.ProcessDataFailureException;
import com.ui.window.AbstractSdiModalWindow;
import com.ui.window.WindowActionListener;

/**
 * @author rterrell
 *
 */
public class ClientSerachMaintDialog extends AbstractSdiModalWindow {

    private static final long serialVersionUID = 1746311868533836L;

    private ClientSearchMaintComp comp;

    /**
     * The Command buttons
     */
    private JButton resetButton;
    private JButton searchButton;

    /**
     * Default constructor
     */
    protected ClientSerachMaintDialog() {
        return;
    }

    /**
     * Creates a CharterOrderMaintDialog initialized with data to populate all
     * tabs.
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
    public ClientSerachMaintDialog(String winTitle, Object data,
            Dimension size, Point pos) {
        super((Dialog) null, data, size, pos, winTitle);

        // TODO: Create and cast <data> as a member variable.

        return;
    }

    @Override
    protected void initDialog() {
        super.initDialog();

        // Add buttons to button pane
        this.remove(this.okButton);
        this.remove(this.cancelButton);
        this.okButton.setText("Return");
        this.resetButton = new JButton("Reset");
        this.searchButton = new JButton("Search");
        this.okButton
                .setActionCommand(WindowActionListener.ACTION_COMMAND_PROCESS_CLOSE);
        this.resetButton
                .setActionCommand(WindowConst.CLIENT_MAINT_ACTION_RESET);
        this.searchButton
                .setActionCommand(WindowConst.CLIENT_MAINT_ACTION_SEARCH);
        this.searchButton.addActionListener(this);
        this.resetButton.addActionListener(this);
        this.buttonPane.add(this.searchButton);
        this.buttonPane.add(this.okButton);
        this.buttonPane.add(this.resetButton);
        this.buttonPane.add(this.cancelButton);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ui.window.WindowActionListener#createContentLayout()
     */
    @Override
    public JPanel createContentLayout() {
        // Setup the main panel with criteria and results sections
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new MigLayout("", "[grow]", "[]"));
        this.comp = new ClientSearchMaintComp(true);
        mainPanel.add(this.comp, "dock west, wrap");
        return mainPanel;
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
        return this.comp.doReturn();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ui.window.AbstractSdiModalWindow#actionPerformed(java.awt.event.
     * ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if (e.getActionCommand().equalsIgnoreCase(
                WindowConst.CLIENT_MAINT_ACTION_RESET)) {
            this.comp.doReset();
        }
        if (e.getActionCommand().equalsIgnoreCase(
                WindowConst.CLIENT_MAINT_ACTION_SEARCH)) {
            this.comp.doSearch();
        }
    }

}
