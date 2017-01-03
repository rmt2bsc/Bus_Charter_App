package org.maint.company;

import com.RMT2RuntimeException;

/**
 * Class for handling bus charter business object errors.
 * 
 * @author rterrell
 *
 */
public class CompanyBOException extends RMT2RuntimeException {
    private static final long serialVersionUID = -5207552551760637791L;

    /**
     * 
     */
    public CompanyBOException() {
        super();
    }

    /**
     * @param msg
     */
    public CompanyBOException(String msg) {
        super(msg);
    }

    /**
     * @param msg
     * @param e
     */
    public CompanyBOException(String msg, Throwable e) {
        super(msg, e);
    }

    /**
     * @param e
     */
    public CompanyBOException(Throwable e) {
        super(e);
    }

}
