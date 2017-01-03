package org.maint.charterorder;

import com.RMT2RuntimeException;

/**
 * Class for handling bus charter maintenance opertaion failures.
 * 
 * @author rterrell
 *
 */
public class CharterOrderMaintenanceFailureException extends
        RMT2RuntimeException {
    private static final long serialVersionUID = -5207552551760637791L;

    /**
     * 
     */
    public CharterOrderMaintenanceFailureException() {
        super();
    }

    /**
     * @param msg
     */
    public CharterOrderMaintenanceFailureException(String msg) {
        super(msg);
    }

    /**
     * @param msg
     * @param e
     */
    public CharterOrderMaintenanceFailureException(String msg, Throwable e) {
        super(msg, e);
    }

    /**
     * @param e
     */
    public CharterOrderMaintenanceFailureException(Throwable e) {
        super(e);
    }

}
