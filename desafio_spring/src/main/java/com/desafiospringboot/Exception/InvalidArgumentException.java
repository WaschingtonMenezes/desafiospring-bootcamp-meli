package com.desafiospringboot.Exception;

public class InvalidArgumentException  extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public InvalidArgumentException(String mensagem) {
        super(mensagem);
    }
    public InvalidArgumentException(Exception e) {
        super(e);
    }
}