package org.maint.client;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.WindowConst;

import com.InvalidGuiDataException;
import com.ProcessDataFailureException;
import com.ui.window.AbstractMdiModelessWindow;

/**
 * @author rterrell
 *
 */
public class ClientSerachMaintFrame extends AbstractMdiModelessWindow {

    private static final long serialVersionUID = -5968216660329452488L;

    private ClientSearchMaintComp comp;

    /**
     * The Command buttons
     */
    private JButton resetButton;
    private JButton addButton;
    private JButton deleteButton;
    private JButton saveButton;

    /**
     * @throws HeadlessException
     */
    public ClientSerachMaintFrame() throws HeadlessException {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param size
     * @param pos
     * @param winTitle
     * @throws HeadlessException
     */
    public ClientSerachMaintFrame(Dimension size, Point pos, String winTitle)
            throws HeadlessException {
        super(size, pos, winTitle);
        return;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ui.window.AbstractMdiModelessWindow#initFrame()
     */
    @Override
    protected void initFrame() {
        super.initFrame();

        // Add buttons to button pane
        this.remove(this.cancelButton);
        this.okButton.setText("Search");
        this.cancelButton.setText("Close");
        this.resetButton = new JButton("Reset");
        this.addButton = new JButton("Add");
        this.deleteButton = new JButton("Delete");
        this.saveButton = new JButton("Save");

        this.resetButton
                .setActionCommand(WindowConst.CLIENT_MAINT_ACTION_RESET);
        this.addButton.setActionCommand(WindowConst.CLIENT_MAINT_ACTION_ADD);
        this.deleteButton
                .setActionCommand(WindowConst.CLIENT_MAINT_ACTION_DELETE);
        this.saveButton.setActionCommand(WindowConst.CLIENT_MAINT_ACTION_SAVE);

        this.resetButton.addActionListener(this);
        this.saveButton.addActionListener(this);
        this.deleteButton.addActionListener(this);
        this.addButton.addActionListener(this);

        this.buttonPane.add(this.resetButton);
        this.buttonPane.add(this.addButton);
        this.buttonPane.add(this.deleteButton);
        this.buttonPane.add(this.saveButton);
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
        this.comp = new ClientSearchMaintComp(false);
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
        this.comp.doSearch();
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ui.window.AbstractMdiModelessWindow#actionPerformed(java.awt.event
     * .ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if (e.getActionCommand().equalsIgnoreCase(
                WindowConst.CLIENT_MAINT_ACTION_RESET)) {
            this.comp.doReset();
        }
        if (e.getActionCommand().equalsIgnoreCase(
                WindowConst.CLIENT_MAINT_ACTION_ADD)) {
            this.comp.doAdd();
        }
        if (e.getActionCommand().equalsIgnoreCase(
                WindowConst.CLIENT_MAINT_ACTION_DELETE)) {
            this.comp.doDelete();
        }
        if (e.getActionCommand().equalsIgnoreCase(
                WindowConst.CLIENT_MAINT_ACTION_SAVE)) {
            this.comp.doSave();
        }
    }

}
