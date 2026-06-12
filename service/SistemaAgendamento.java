package service;
import java.util.ArrayList;
import java.util.List;

import model.Consulta;
import model.Pessoa;
import model.Horario;
import model.Paciente;
import model.Dentista;

public class SistemaAgendamento {
    private List<Pessoa> pessoas;
    private List<Consulta> consultas;
    private List<IValidador> validadores;

    public SistemaAgendamento(){
        pessoas = new ArrayList<>();
        consultas = new ArrayList<>();
        validadores = new ArrayList<>();
    }

    public void iniciar(){

    }

    public void adicionarPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
    }

    public void adicionarConsultas(Consulta consulta){
        consultas.add(consulta);
    }

    public void gerenciarConsultas(){
        for(Consulta consulta : consultas){
            System.out.println(consulta);
        }
    }
    public void listarPessoas(){
        for(Pessoa pessoa : pessoas){
            System.out.println(pessoa.getDados());
        }
    }

    public boolean agendarConsulta(Consulta consulta, Paciente paciente, Dentista dentista, Horario horario){
        validadores.clear();
        validadores.add(new ValidadorPaciente(paciente));
        validadores.add(new ValidadorHorario(horario));
            for(IValidador validador : validadores){
                if (!validador.validar()) {
                    System.out.println("Falha na validação");
                    return false;
                }
            }
        consulta.agendar(paciente, dentista, horario);
        consultas.add(consulta);
    }
}
