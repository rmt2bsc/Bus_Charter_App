package org;

import java.awt.Dimension;
import java.awt.Point;

import com.api.security.User;
import com.nv.security.UserSecurityException;
import com.ui.window.AbstractMdiUserLoginDialog;

/**
 * @author rterrell
 *
 */
public class UserMdiSignOnDialog extends AbstractMdiUserLoginDialog {

    private static final long serialVersionUID = -5526719038498454298L;

    /**
     * @param title
     * @param data
     * @param size
     * @param pos
     */
    public UserMdiSignOnDialog(String title, Object data, Dimension size,
            Point pos) {
        super(title, data, size, pos);
        return;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ui.window.AbstractMdiUserLoginDialog#authenticateUser(com.api.security
     * .User)
     */
    @Override
    protected void authenticateUser(User user) throws UserSecurityException {
        // TODO Auto-generated method stub

    }

}
