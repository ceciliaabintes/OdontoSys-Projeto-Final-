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
    private List<Horario> horarios;

    public SistemaAgendamento(){
        pessoas = new ArrayList<>();
        consultas = new ArrayList<>();
        validadores = new ArrayList<>();
        horarios = new ArrayList<>();
    }

    public List<Horario> getHorarios(){
        return horarios;
    }
    public List<Paciente> getPacientes(){
        List<Paciente> pacientes = new ArrayList<>();
        for(Pessoa pessoa : pessoas){
            //testando a instancia e verificando se ela pertence a classe pessoa
            if(pessoa instanceof Paciente){
                pacientes.add((Paciente) pessoa);
            }
        }
            return pacientes;
    }
    public List<Dentista> getDentistas(){
        List<Dentista> dentistas = new ArrayList<>();
            for(Pessoa pessoa : pessoas){
                if(pessoa instanceof Dentista){
                    dentistas.add((Dentista)pessoa);
                }
        }
            return dentistas;
    } 
    public List<Consulta> getConsultas(){
        return consultas;
    }

    public void adicionarPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
    }

    public void adicionarHorario(Horario horario){
        horarios.add(horario);
    }
    public boolean confirmarConsulta(int idConsulta){
        for(Consulta consulta : consultas){
            if(consulta.getIdConsulta() == idConsulta){
                consulta.confirmar();
                return true;
            }
        }
            return false;
    }
    public boolean cancelarConsulta(int idConsulta){
            for(Consulta consulta : consultas){
                if (consulta.getIdConsulta() == idConsulta) {
                    consulta.cancelar();
                    return true;
                }
            }
            return false;
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
        return true;
    }
}
