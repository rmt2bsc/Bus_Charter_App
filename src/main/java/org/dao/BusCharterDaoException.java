package org.dao;

import com.RMT2RuntimeException;

/**
 * Class for handling bus charter database errors.
 * 
 * @author rterrell
 *
 */
public class BusCharterDaoException extends RMT2RuntimeException {
    private static final long serialVersionUID = -5207552551760637791L;

    /**
     * 
     */
    public BusCharterDaoException() {
        super();
    }

    /**
     * @param msg
     */
    public BusCharterDaoException(String msg) {
        super(msg);
    }

    /**
     * @param msg
     * @param e
     */
    public BusCharterDaoException(String msg, Throwable e) {
        super(msg, e);
    }

    /**
     * @param e
     */
    public BusCharterDaoException(Throwable e) {
        super(e);
    }

}
