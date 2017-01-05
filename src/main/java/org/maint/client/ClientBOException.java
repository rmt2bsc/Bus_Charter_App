package org.maint.client;

import com.RMT2RuntimeException;

/**
 * Class for handling bus charter business object errors.
 * 
 * @author rterrell
 *
 */
public class ClientBOException extends RMT2RuntimeException {
    private static final long serialVersionUID = -5207552551760637791L;

    /**
     * 
     */
    public ClientBOException() {
        super();
    }

    /**
     * @param msg
     */
    public ClientBOException(String msg) {
        super(msg);
    }

    /**
     * @param msg
     * @param e
     */
    public ClientBOException(String msg, Throwable e) {
        super(msg, e);
    }

    /**
     * @param e
     */
    public ClientBOException(Throwable e) {
        super(e);
    }

}
