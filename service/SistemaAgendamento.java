package service;
import java.util.ArrayList;
import java.util.List;

import model.Consulta;
import model.Pessoa;
import model.Horario;
import model.Paciente;
import model.Dentista;
/*Classe Sistema Agendamento */
public class SistemaAgendamento {
    /*Atributos de Sistema Agendamento */
    private List<Pessoa> pessoas;
    private List<Consulta> consultas;
    private List<IValidador> validadores;
    private List<Horario> horarios;
    /* Construtor de Sistema Agendamento*/
    public SistemaAgendamento(){
        pessoas = new ArrayList<>();
        consultas = new ArrayList<>();
        validadores = new ArrayList<>();
        horarios = new ArrayList<>();
    }

    public List<Horario> getHorarios(){
        return horarios;
    }
    /*Método para retorno de Pacientes */
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
    /*Método de retorno de Dentistas */
    public List<Dentista> getDentistas(){
        List<Dentista> dentistas = new ArrayList<>();
            for(Pessoa pessoa : pessoas){
                if(pessoa instanceof Dentista){
                    dentistas.add((Dentista)pessoa);
                }
        }
            return dentistas;
    } 
    /*Métod de retono de Consultas */
    public List<Consulta> getConsultas(){
        return consultas;
    }
    /*Método para adicionar Pessoas */
    public void adicionarPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
    }
    /*Método para Adicionar Horarios */
    public void adicionarHorario(Horario horario){
        horarios.add(horario);
    }
    /*Método de confirmação de consultas */
    public boolean confirmarConsulta(int idConsulta){
        for(Consulta consulta : consultas){
            if(consulta.getIdConsulta() == idConsulta){
                consulta.confirmar();
                return true;
            }
        }
            return false;
    }
    /*Método de cancelamento de Consultas */
    public boolean cancelarConsulta(int idConsulta){
            for(Consulta consulta : consultas){
                if (consulta.getIdConsulta() == idConsulta) {
                    consulta.cancelar();
                    return true;
                }
            }
            return false;
    }
    /*Método de agendar Consultas */
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
