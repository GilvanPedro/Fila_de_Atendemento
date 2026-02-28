package br.com.entity;

import br.com.enums.TipoAtendimento;

public class Ticket {
    private long id;
    private TipoAtendimento tipoAtendimento;
    private boolean status;

    public Ticket(long id, TipoAtendimento tipoAtendimento, boolean status) {
        this.id = id;
        this.tipoAtendimento = tipoAtendimento;
        this.status = status;
    }

    public long getId(){
        return id;
    }

    public TipoAtendimento getTipoAtendimento(){
        return tipoAtendimento;
    }

    public boolean isStatus(){
        return status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }
}
