package com.spring.boilerplate.api.exception;

public class ChildException extends ManagerException {

    protected ChildException(String format, Object... parameters) {
        super(format, parameters);
    }

    public static ChildException to(String format, Object... parameters) {
        return new ChildException(format, parameters);
    }

}
