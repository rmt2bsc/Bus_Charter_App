package org.maint.charterorder;

import com.RMT2RuntimeException;

/**
 * Class for handling bus charter business object validation errors.
 * 
 * @author rterrell
 *
 */
public class CharterOrderBOValidationException extends RMT2RuntimeException {
    private static final long serialVersionUID = -5207552551760637791L;

    /**
     * 
     */
    public CharterOrderBOValidationException() {
        super();
    }

    /**
     * @param msg
     */
    public CharterOrderBOValidationException(String msg) {
        super(msg);
    }

    /**
     * @param msg
     * @param e
     */
    public CharterOrderBOValidationException(String msg, Throwable e) {
        super(msg, e);
    }

    /**
     * @param e
     */
    public CharterOrderBOValidationException(Throwable e) {
        super(e);
    }

}
