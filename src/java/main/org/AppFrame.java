package org;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import org.apache.log4j.Logger;
import org.maint.charterorder.CharterOrderSearchFrame;
import org.maint.client.ClientSerachMaintFrame;
import org.maint.company.CompanySerachMaintFrame;

import com.AppInitException;
import com.InvalidDataException;
import com.api.config.AppPropertyPool;
import com.api.security.User;
import com.nv.security.GuiSecurityToken;
import com.nv.security.UserSecurityManager;
import com.nv.security.UserVo;
import com.ui.window.AbstractMdiMainFrame;

/**
 * The main application frame for the bus charter systems.
 * 
 * @author rterrell
 *
 */
public class AppFrame extends AbstractMdiMainFrame implements ActionListener {

    private static final long serialVersionUID = -8040373526936069464L;
    private static Logger logger = Logger.getLogger(AppFrame.class);
    private static final int FRAME_X_VALUE = 250;

    /**
     * 
     */
    public AppFrame() {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ui.window.AbstractMainFrame#doPostInitialization()
     */
    @Override
    protected void doPostInitialization() throws AppInitException {
        JMenuBar mb = this.createMenuBar();
        this.setJMenuBar(mb);

        // Setup security for DEV environment
        String env = System.getProperty("env");
        if (env.equalsIgnoreCase("dev")) {
            User user = new UserVo();
            user.setLoginId("test_user");
            UserSecurityManager mgr = new UserSecurityManager();
            mgr.initUserSecurity();
            mgr.updateSecurityToken(user);
        }
        return;
    }

    protected JMenuBar createMenuBar() {
        // Where the GUI is created:
        JMenuBar menuBar;
        // Create the menu bar.
        menuBar = new JMenuBar();

        JMenu menu = this.createFileMenu();
        menuBar.add(menu);
        JMenu menu2 = this.createEditMenu();
        menuBar.add(menu2);
        JMenu menu3 = this.createDatabaseMenu();
        menuBar.add(menu3);
        JMenu menu4 = this.createWindowMenu();
        menuBar.add(menu4);
        JMenu menu5 = this.createHelpMenu();
        menuBar.add(menu5);

        return menuBar;
    }

    private JMenu createFileMenu() {
        JMenu menu;
        JMenuItem menuItem;

        // Build the File menu.
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.getAccessibleContext().setAccessibleDescription("File menu");

        // Security related JMenuItems
        menuItem = new JMenuItem(MenuItemConst.FILE_LOGIN, KeyEvent.VK_L);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
                ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "User login page");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem(MenuItemConst.FILE_LOGOUT);
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem(MenuItemConst.FILE_CHG_PW);
        menuItem.setMnemonic(KeyEvent.VK_P);
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menu.addSeparator();

        // Charter Order related menu items
        // menuItem = new JMenuItem(MenuItemConst.FILE_OPEN_CHRT_ORD,
        // KeyEvent.VK_O);
        // menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
        // ActionEvent.ALT_MASK));
        // menuItem.getAccessibleContext().setAccessibleDescription(
        // "Open Charter Order");
        // menuItem.addActionListener(this);
        // menu.add(menuItem);
        //
        // menuItem = new JMenuItem(MenuItemConst.FILE_NEW_CHRT_ORD,
        // KeyEvent.VK_N);
        // menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
        // ActionEvent.ALT_MASK));
        // menuItem.getAccessibleContext().setAccessibleDescription(
        // "Create new Charter Order");
        // menuItem.addActionListener(this);
        // menu.add(menuItem);
        //
        // menuItem = new JMenuItem(MenuItemConst.FILE_CLOSE_CHRT_ORD,
        // KeyEvent.VK_C);
        // menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
        // ActionEvent.ALT_MASK));
        // menuItem.getAccessibleContext().setAccessibleDescription(
        // "Close Charter Order");
        // menuItem.addActionListener(this);
        // menu.add(menuItem);
        //
        // menuItem = new JMenuItem(MenuItemConst.FILE_SAVE_CHRT_ORD,
        // KeyEvent.VK_S);
        // menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
        // ActionEvent.CTRL_MASK));
        // menuItem.getAccessibleContext().setAccessibleDescription(
        // "Save Charter Order changes");
        // menuItem.addActionListener(this);
        // menu.add(menuItem);
        //
        // menu.addSeparator();

        // Print related menu items
        menuItem = new JMenuItem(MenuItemConst.FILE_PRINT_SETUP);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Open print setup dialog");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem(MenuItemConst.FILE_PRINT, KeyEvent.VK_P);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
                ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Print Charter Order");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menu.addSeparator();

        // // Bus Charter Entity menu items
        // menuItem = new JMenuItem(MenuItemConst.FILE_COMPANY);
        // menuItem.getAccessibleContext().setAccessibleDescription(
        // "Manage company information");
        // menuItem.addActionListener(this);
        // menu.add(menuItem);
        //
        // menuItem = new JMenuItem(MenuItemConst.FILE_CLIENT);
        // menuItem.getAccessibleContext().setAccessibleDescription(
        // "Manage client information");
        // menuItem.addActionListener(this);
        // menu.add(menuItem);
        //
        // menuItem = new JMenuItem(MenuItemConst.FILE_RECONCILE);
        // menuItem.getAccessibleContext().setAccessibleDescription(
        // "Reconcile Charter Order");
        // menuItem.addActionListener(this);
        // menu.add(menuItem);
        //
        // menu.addSeparator();

        // Exit menu item
        menuItem = new JMenuItem(MenuItemConst.FILE_EXIT, KeyEvent.VK_X);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
                ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Exit Application");
        menuItem.addActionListener(this);

        menu.add(menuItem);

        return menu;
    }

    private JMenu createEditMenu() {
        JMenu menu;
        JMenuItem menuItem;

        // Build Edit menu.
        menu = new JMenu("Maintenance");
        menu.setMnemonic(KeyEvent.VK_E);
        menu.getAccessibleContext()
                .setAccessibleDescription("Maintenance menu");

        // Charter Order Menu Items
        menuItem = new JMenuItem(MenuItemConst.MAINT_CHARTER, KeyEvent.VK_S);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Charter Order");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem(MenuItemConst.MAINT_RECONCILE);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Reconcile Charter Order");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem(MenuItemConst.MAINT_COMPANY);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Manage company information");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem(MenuItemConst.MAINT_CLIENT);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Manage client information");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        // menuItem = new JMenuItem(MenuItemConst.EDIT_RESET, KeyEvent.VK_R);
        // menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
        // ActionEvent.ALT_MASK));
        // menuItem.getAccessibleContext().setAccessibleDescription(
        // "Reset Charter Order Data");
        // menuItem.addActionListener(this);
        // menu.add(menuItem);
        //
        // menuItem = new JMenuItem(MenuItemConst.EDIT_ADD, KeyEvent.VK_A);
        // menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
        // ActionEvent.ALT_MASK));
        // menuItem.getAccessibleContext().setAccessibleDescription("Add");
        // menuItem.addActionListener(this);
        // menu.add(menuItem);
        //
        // menuItem = new JMenuItem(MenuItemConst.EDIT_DEL, KeyEvent.VK_D);
        // menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
        // ActionEvent.ALT_MASK));
        // menuItem.getAccessibleContext().setAccessibleDescription("Delete");
        // menuItem.addActionListener(this);
        // menu.add(menuItem);
        //
        // menuItem = new JMenuItem(MenuItemConst.EDIT_DETAILS, KeyEvent.VK_T);
        // menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,
        // ActionEvent.ALT_MASK));
        // menuItem.getAccessibleContext()
        // .setAccessibleDescription("Show Details");
        // menuItem.addActionListener(this);
        // menu.add(menuItem);

        menu.addSeparator();

        // Maintenance Menu Items
        menuItem = new JMenuItem(MenuItemConst.MAINT_GEN_CODE_GRP);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Maintain General Code Group Data");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem(MenuItemConst.MAINT_GEN_CODES);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Maintain General Code Data");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem(MenuItemConst.MAINT_STATES);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Maintain U.S. States Data");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem(MenuItemConst.MAINT_CITY);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Maintain U.S. Cities Data");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem(MenuItemConst.MAINT_USERS, KeyEvent.VK_U);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
                ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Maintain users");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menu.addSeparator();

        // Expenses Menu Item
        menuItem = new JMenuItem(MenuItemConst.MAINT_EXPENSE_MAINT);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Maintain Charter Order expenses");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        return menu;
    }

    private JMenu createDatabaseMenu() {
        JMenu menu;
        JMenuItem menuItem;

        // Build Database menu.
        menu = new JMenu("Database");
        menu.setMnemonic(KeyEvent.VK_D);
        menu.getAccessibleContext().setAccessibleDescription("Database menu");

        // Menu Items
        menuItem = new JMenuItem(MenuItemConst.DB_BACKUP);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Backup Database");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem(MenuItemConst.DB_RECOVER);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Restore database from selected backup");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        return menu;
    }

    private JMenu createWindowMenu() {
        JMenu menu;
        JMenuItem menuItem;

        // Build Database menu.
        menu = new JMenu("Window");
        menu.setMnemonic(KeyEvent.VK_W);
        menu.getAccessibleContext().setAccessibleDescription("Window menu");

        // Menu Items
        menuItem = new JMenuItem(MenuItemConst.WIN_CASCADE);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Cascade Windows");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem(MenuItemConst.WIN_LAYER);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Layer Windows");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem(MenuItemConst.WIN_TILE);
        menuItem.getAccessibleContext()
                .setAccessibleDescription("Tile Windows");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem(MenuItemConst.WIN_TILE_HORIZ);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Horizonally Tile Windows");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem(MenuItemConst.WIN_ICON);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Iconize Windows");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        return menu;
    }

    private JMenu createHelpMenu() {
        JMenu menu;
        JMenuItem menuItem;

        // Build Help menu.
        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_D);
        menu.getAccessibleContext().setAccessibleDescription("Help menu");

        // Menu Items
        menuItem = new JMenuItem(MenuItemConst.HELP_ABOUT);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "About Inforamtion");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        return menu;
    }

    /**
     * Handles all of the menu item selections.
     * 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case MenuItemConst.FILE_LOGIN:
                this.openLoginWindow();
                break;
            case MenuItemConst.FILE_LOGOUT:
                this.logoutUser();
                break;
            case MenuItemConst.FILE_PRINT_SETUP:
                this.openPrintSetup(null);
                break;
            case MenuItemConst.FILE_PRINT:
                this.print();
                break;
            case MenuItemConst.FILE_EXIT:
                this.exitApplication();
                break;
            case MenuItemConst.MAINT_CHARTER:
                this.openCharterOrderSearch();
                break;
            case MenuItemConst.MAINT_CLIENT:
                this.openClientManitenance();
                break;
            case MenuItemConst.MAINT_COMPANY:
                this.openCompanyManitenance();
                break;
        }
    }

    /**
     * Displays the User Login Window.
     */
    protected void openLoginWindow() {
        String msg = null;
        try {
            // UserMdiSignOnDialog dialog = new
            // UserMdiSignOnDialog("User Login",
            // null, new Dimension(380, 180),
            // new Point(FRAME_X_VALUE, 300));
            // this.desktop.add(dialog);

            UserSdiSignOnDialog dialog = new UserSdiSignOnDialog(this,
                    new Dimension(380, 180), new Point(FRAME_X_VALUE, 300),
                    "User Login");

            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
            GuiSecurityToken user = (GuiSecurityToken) dialog.getResults();
            logger.debug("User's Id: "
                    + (user == null ? "Unknown" : user.getUserId()));

        } catch (InvalidDataException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "User Login Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            msg = e.getMessage()
                    + "\n\nContact the support team for assistance";
            JOptionPane.showMessageDialog(this, msg, "Authentication Error",
                    JOptionPane.ERROR_MESSAGE);
            logger.error(msg);
            e.printStackTrace();
        }
    }

    protected boolean openPrintSetup(PrinterJob pj) {
        if (pj == null) {
            pj = PrinterJob.getPrinterJob();
        }
        return pj.printDialog();
    }

    protected void print() {
        PrinterJob pj = PrinterJob.getPrinterJob();
        if (this.openPrintSetup(pj)) {
            try {
                pj.print();
            } catch (PrinterException e) {
                logger.error(e);
            }
        }
    }

    protected void logoutUser() {
        GuiSecurityToken user = UserSecurityManager.getSecurityToken();
        if (user == null) {
            return;
        }
        // TODO: use user token to logout user via the database
    }

    /**
     * Releases allocated resources and closes the application.
     */
    protected void exitApplication() {
        this.logoutUser();
        this.dispose();
    }

    protected void openCharterOrderSearch() {
        CharterOrderSearchFrame frame = new CharterOrderSearchFrame(
                new Dimension(1100, 680), new Point(FRAME_X_VALUE, 50),
                "Charter Order Search");
        frame.setVisible(true);
        this.desktop.add(frame);
    }

    protected void openClientManitenance() {
        ClientSerachMaintFrame frame = new ClientSerachMaintFrame(
                new Dimension(1100, 880), new Point(FRAME_X_VALUE, 50),
                "Client Search/Maintenance");
        frame.setVisible(true);
        this.desktop.add(frame);
    }

    protected void openCompanyManitenance() {
        CompanySerachMaintFrame frame = new CompanySerachMaintFrame(
                new Dimension(1100, 880), new Point(FRAME_X_VALUE, 50),
                "Company Search/Maintenance");
        frame.setVisible(true);
        this.desktop.add(frame);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // try {
        // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        // } catch (Exception ex) {
        // ex.printStackTrace();
        // }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                String message = null;
                boolean error = false;
                AppFrame frame = null;
                String appTitle = null;
                try {
                    frame = new AppFrame();
                    appTitle = AppPropertyPool.getProperty("apptitle");
                    frame.setTitle(appTitle);
                    frame.setVisible(true);
                } catch (Exception e) {
                    error = true;
                    message = "Application is shutting down due to initialization error.  Check logs!";
                    if (AppFrame.logger != null) {
                        AppFrame.logger.fatal(message, e);
                    }
                    else {
                        System.out.println(message);
                    }
                    JOptionPane.showMessageDialog(frame, message,
                            appTitle == null ? "Application Title Unknown"
                                    : appTitle + " Error Message",
                            JOptionPane.ERROR_MESSAGE);
                } finally {
                    if (error) {
                        AppFrame.logger.fatal(appTitle
                                + " Application failed to start!");
                        System.exit(1);
                    }
                    else {
                        AppFrame.logger.info(appTitle
                                + " Application started successfully!");
                        // frame.pack();
                    }
                }
            }
        });

    }

}
