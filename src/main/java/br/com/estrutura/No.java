package br.com.estrutura;

public class No {
    private long dado;
    private No proximo;

    public No(long dado){
        this.dado = dado;
        this.proximo = proximo;
    }

    public long getDado() {
        return dado;
    }
    public void setDado(long dado) {
        this.dado = dado;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
