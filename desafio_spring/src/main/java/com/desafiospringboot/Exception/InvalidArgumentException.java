package com.desafiospringboot.Exception;

public class InvalidArgumentException  extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public InvalidArgumentException(String message) {
        super(message);
    }

    public InvalidArgumentException(Exception e) {
        super(e);
    }
}