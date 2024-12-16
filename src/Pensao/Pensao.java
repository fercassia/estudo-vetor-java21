package Pensao;
import Pessoa.Pessoa;
import Utils.ValidaNumeroQuarto;

import java.util.ArrayList;
import java.util.List;

public class Pensao {
    private final Pessoa[] quartosPensao;

    public Pensao(){
        this.quartosPensao = new Pessoa[10];
    }

    public List<Integer> verificaQuartosVazios(){
        List<Integer> quartosVazios = new ArrayList<>();
        for(int i = 0; i < quartosPensao.length; i++){
            if(quartosPensao[i] == null){
                quartosVazios.add(i + 1);
            }
        }
        return quartosVazios;
    }

    public void reservaQuarto(Pessoa pessoa, int numeroQuarto){

        if(!ValidaNumeroQuarto.ehNumeroQuartoValido(numeroQuarto)){
            throw new IllegalArgumentException("Adicione um número de quarto válido (1 a 10).");
        }

        if(quartosPensao[numeroQuarto-1] != null){
            throw new IllegalArgumentException("Esse quarto já está reservado. " +
                    "Para reserva, o quarto deve estar vazio.");
        }
        quartosPensao[numeroQuarto-1] = pessoa;
    }

    public void checkoutQuarto(int numeroQuarto){
        if(!ValidaNumeroQuarto.ehNumeroQuartoValido(numeroQuarto)){
            throw new IllegalArgumentException("Adicione um número de quarto válido (1 a 10).");
        }

        if(quartosPensao[numeroQuarto - 1] == null){
            throw new Error("Esse quarto não possui reserva. Para checkout," +
                    "o quarto deve possuir reserva");
        }

        quartosPensao[numeroQuarto-1] = null;
    }

    @Override
    public String toString() {
       StringBuilder result = new StringBuilder("QUARTOS RESERVADOS:\n");
        boolean possuiQuartosReservados = false;

        for(int i = 0; i < quartosPensao.length; i++){
           if(quartosPensao[i] != null){
               result
                       .append(i+1+": ")
                       .append(quartosPensao[i].getNome()+", ")
                       .append(quartosPensao[i].getEmail())
                       .append("\n");
               possuiQuartosReservados = true;
           }
       }
       return possuiQuartosReservados ? result.toString() : "Nenhum quarto reservado.";
    }
}
