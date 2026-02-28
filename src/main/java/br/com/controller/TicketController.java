package br.com.controller;

import br.com.estrutura.Fila;
import br.com.entity.Atendente;
import br.com.enums.TipoAtendimento;

import java.util.*;

public class TicketController {

    private Fila filaNormal = new Fila();
    private Fila filaPrioritaria = new Fila();

    private Map<Long, TipoAtendimento> tiposTicket = new HashMap<>();
    private List<Atendente> atendentes = new ArrayList<>();

    private long contadorTicket = 1;
    private int contadorPrioridade = 0;

    public TicketController() {
        atendentes.add(new Atendente(1,"João",1,true));
        atendentes.add(new Atendente(2,"Maria",2,true));
        atendentes.add(new Atendente(3,"Carlos",3,true));
        atendentes.add(new Atendente(4,"Marcelo",4,true));
        atendentes.add(new Atendente(5,"Júlia",5, true));
    }

    // EMITE UM NOVO TICKET E ENVIA PARA A FILA CORRETA
    public void emitirTicket(Scanner sc){

        System.out.println("Selecione o tipo:");
        System.out.println("1 - Normal");
        System.out.println("2 - Prioritário");
        System.out.println("3 - Troca");
        System.out.println("4 - Suporte");

        int tipo = sc.nextInt();

        TipoAtendimento tipoEscolhido = switch (tipo){
            case 2 -> TipoAtendimento.PRIORITARIO;
            case 3 -> TipoAtendimento.TROCA;
            case 4 -> TipoAtendimento.SUPORTE;
            default -> TipoAtendimento.NORMAL;
        };

        if(tipoEscolhido == TipoAtendimento.PRIORITARIO){
            filaPrioritaria.enqueue(contadorTicket);
        }else{
            filaNormal.enqueue(contadorTicket);
        }

        tiposTicket.put(contadorTicket, tipoEscolhido);

        System.out.println("Ticket emitido: " + contadorTicket +
                " | Tipo: " + tipoEscolhido);

        contadorTicket++;
    }

    // CHAMA O PRÓXIMO TICKET RESPEITANDO A REGRA DE PRIORIDADE
    public void chamarProximo(){

        Atendente disponivel = buscarAtendenteDisponivel();

        if(disponivel == null){
            System.out.println("Nenhum atendente disponível");
            return;
        }

        long ticket = -1;

        if(!filaPrioritaria.estaVazia() && contadorPrioridade < 2){
            ticket = filaPrioritaria.dequeue();
            contadorPrioridade++;
        }
        else if(!filaNormal.estaVazia()){
            ticket = filaNormal.dequeue();
            contadorPrioridade = 0;
        }
        else if(!filaPrioritaria.estaVazia()){
            ticket = filaPrioritaria.dequeue();
        }

        if(ticket == -1){
            System.out.println("Filas vazias");
            return;
        }

        TipoAtendimento tipo = tiposTicket.get(ticket);

        disponivel.setDisponivel(false);

        System.out.println("Ticket " + ticket +
                " | Tipo: " + tipo +
                " -> Guichê " + disponivel.getGuiche() +
                " | Atendente: " + disponivel.getNome());
    }

    // FINALIZA O ATENDIMENTO E LIBERA O ATENDENTE
    public void finalizarAtendimento(Scanner sc){

        System.out.println("Digite o ID do atendente:");
        long id = sc.nextLong();

        for(Atendente a : atendentes){
            if(a.getId() == id){
                a.setDisponivel(true);
                System.out.println("Atendimento finalizado no guichê " + a.getGuiche());
                return;
            }
        }

        System.out.println("Atendente não encontrado");
    }

    // MOSTRA AS DUAS FILAS ATUAIS
    public void mostrarFilas(){
        System.out.print("Fila Prioritária: ");
        filaPrioritaria.exibir();
        System.out.println();
        System.out.print("Fila Normal: ");
        filaNormal.exibir();
        System.out.println();
    }

    // MOSTRA O STATUS DE TODOS OS ATENDENTES
    public void mostrarAtendentes(){
        for(Atendente a : atendentes){
            System.out.println(
                    "ID: " + a.getId() +
                            " | Nome: " + a.getNome() +
                            " | Guichê: " + a.getGuiche() +
                            " | Disponível: " + a.isDisponivel()
            );
        }
    }

    // RETORNA O PRIMEIRO ATENDENTE DISPONÍVEL
    private Atendente buscarAtendenteDisponivel(){
        for(Atendente a : atendentes){
            if(a.isDisponivel()){
                return a;
            }
        }
        return null;
    }
}