package org;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;

import com.api.security.User;
import com.nv.security.UserSecurityException;
import com.ui.window.AbstractSdiUserLoginDialog;

/**
 * Authenticates the user for the bus charter systems.
 * 
 * @author rterrell
 *
 */
public class UserSdiSignOnDialog extends AbstractSdiUserLoginDialog {

    private static final long serialVersionUID = -8093835971568311201L;

    /**
     * Create an UserSignOnDialog object with a known parent, window size
     * properties, window location coordinates, and the window title.
     * 
     * @param title
     *            the window title
     * @param data
     *            window data.
     * @param size
     *            the size coordinates
     * @param pos
     *            the location coordinates
     */
    public UserSdiSignOnDialog(Frame parent, Dimension size, Point pos,
            String title) {
        super(parent, size, pos, title);
        return;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ui.window.AbstractUserLoginDialog#authenticateUser(com.api.security
     * .User)
     */
    @Override
    protected void authenticateUser(User user) throws UserSecurityException {
        // TODO verify user and its credentials against the database.

    }

}
