package com.spring.boilerplate.api.exception;

public class ManagerException extends RuntimeException {

    protected ManagerException(String format, Object... parameters) {
        super(String.format(format, parameters));
    }

    protected ManagerException(Throwable cause, String format, Object... parameters) {
        super(String.format(format, parameters), cause);
    }

    public static ManagerException to(String format, Object... parameters) {
        return new ManagerException(format, parameters);
    }

    public static ManagerException to(Throwable cause, String format, Object... parameters) {
        return new ManagerException(cause, format, parameters);
    }
}
