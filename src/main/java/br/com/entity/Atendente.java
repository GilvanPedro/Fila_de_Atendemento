package br.com.entity;

public class Atendente {
    private long id;
    private String nome;
    private int guiche;
    private boolean disponivel;

    public Atendente(long id, String nome, int guiche, boolean disponivel){
        this.id = id;
        this.nome = nome;
        this.guiche = guiche;
        this.disponivel = true;
    }

    public long getId() {
        return id;
    }

    public String getNome(){
        return nome;
    }

    public int getGuiche(){
        return guiche;
    }

    public boolean isDisponivel(){
        return disponivel;
    }

    public void setGuiche(int guiche){
        this.guiche = guiche;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
}
