package service;
import java.util.ArrayList;
import java.util.List;

import model.Consulta;
import model.Pessoa;

public class SistemaAgendamento {
    private List<Pessoa> pessoas;
    private List<Consulta> consultas;

    public SistemaAgendamento(){
        pessoas = new ArrayList<>();
        consultas = new ArrayList<>();
    }

    public void iniciar(){

    }

    public void gerenciarConsultas(){
        
    }
    public void listarPessoas(){
        for(Pessoa pessoa : pessoas){
            System.out.println(pessoa.getDados());
        }
    }
}
