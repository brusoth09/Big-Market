package com.cms.app.dao;

/**
 * User defined exception class to handle search exceptions.
 *
 */
public class SearchException extends RuntimeException {

    public SearchException(Throwable ex) {
        super(ex);
    }

}
