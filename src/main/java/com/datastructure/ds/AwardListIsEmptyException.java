package com.datastructure.ds;

public class AwardListIsEmptyException extends RuntimeException {
    public AwardListIsEmptyException() {
        super();
    }

    public AwardListIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public AwardListIsEmptyException(String message) {
        super(message);
    }

    public AwardListIsEmptyException(Throwable cause) {
        super(cause);
    }
}
