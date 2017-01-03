package org.maint.charterorder;

import com.RMT2RuntimeException;

/**
 * Class for handling bus charter business object errors.
 * 
 * @author rterrell
 *
 */
public class CharterOrderBOException extends RMT2RuntimeException {
    private static final long serialVersionUID = -5207552551760637791L;

    /**
     * 
     */
    public CharterOrderBOException() {
        super();
    }

    /**
     * @param msg
     */
    public CharterOrderBOException(String msg) {
        super(msg);
    }

    /**
     * @param msg
     * @param e
     */
    public CharterOrderBOException(String msg, Throwable e) {
        super(msg, e);
    }

    /**
     * @param e
     */
    public CharterOrderBOException(Throwable e) {
        super(e);
    }

}
