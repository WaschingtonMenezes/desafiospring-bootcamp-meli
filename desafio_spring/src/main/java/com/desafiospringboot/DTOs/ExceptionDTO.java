package com.desafiospringboot.DTOs;

public class ExceptionDTO {
    private String campo;
    private String mensagem;

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public ExceptionDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public ExceptionDTO(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }
}
