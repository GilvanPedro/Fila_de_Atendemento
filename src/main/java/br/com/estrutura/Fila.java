package br.com.estrutura;

public class Fila {
    private No inicio = null;
    private No fim = null;


    // INSERIR OS DADOS NA FILA
    public void enqueue(long valor){
        No novoNo = new No(valor);

        if(inicio == null){
            inicio = novoNo;
            fim = novoNo;
        } else{
            fim.setProximo(novoNo);
            fim = novoNo;
        }
    }

    // REMOVER DA FILA
    public long dequeue(){
        if(inicio == null){
            System.out.println("Fila vazia");
            return -1;
        }

        long valor = inicio.getDado();
        inicio = inicio.getProximo();

        if(inicio == null){
            fim = null;
        }

        return valor;
    }

    // VER O PRIMEIRO DA FILA
    public long peek(){
        if(inicio == null){
            System.out.println("Fila vazia");
            return -1;
        }

        return inicio.getDado();
    }

    // MOSTRAR FILA
    public void exibir(){
        No atual = inicio;

        while(atual != null){
            System.out.print(atual.getDado() + " -> ");
            atual =  atual.getProximo();
        }
    }

    // VERIFICAR SE ESTA VAZIA
    public boolean estaVazia(){
        return inicio == null;
    }
}
