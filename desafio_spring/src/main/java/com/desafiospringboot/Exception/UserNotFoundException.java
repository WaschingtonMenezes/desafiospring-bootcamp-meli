package com.desafiospringboot.Exception;

public class UserNotFoundException extends RuntimeException{
        private static final long serialVersionUID = 1L;
        public UserNotFoundException(String mensagem) {
            super(mensagem);
        }
        public UserNotFoundException(Exception e) {
            super(e);
        }
    }