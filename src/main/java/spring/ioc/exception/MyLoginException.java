package spring.ioc.exception;

import spring.ioc.exception.MyAppException;

public class MyLoginException extends MyAppException {
    public MyLoginException(String message) {
        super(message);
    }
}
