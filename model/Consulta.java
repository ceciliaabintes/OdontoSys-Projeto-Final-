package model;
/* Criação da classe Consulta */
public class Consulta {
    /*Atributos da Classe Consulta */
    private int idConsulta;
    private String dataHora;
    private String tipoConsulta;
    private String status;
    private String observacoes;
/* Associando objetos da classe Dentista, Paciente e Horário à Consulta */
    private Paciente paciente;
    private Dentista dentista;
    private Horario horario;
/*Construtor da classe Consulta */
    public Consulta(int idConsulta, String dataHora, String tipoConsulta, String observacoes){
        this.idConsulta = idConsulta;
        this.dataHora = dataHora;
        this.tipoConsulta = tipoConsulta;
        this.observacoes = observacoes;
        this.status = "Pendente";
    }
/*Método de agendamento de consultas */
    public void agendar(Paciente p, Dentista d, Horario h){
        this.dentista = d;
        this.paciente = p;
        this.horario = h;
        h.bloquear(); 

        this.status = "Agendada";
    }
/*Métodos para cancelamento de Consultas */
    public void cancelar(){
        this.status = "Cancelado";

        if(horario!= null){
            horario.liberar();
        }
    }
/*Métodos para confirmação de consultas */
    public void confirmar(){
        this.status = "Confirmada";
    }
/*Métodos get para retorno de dados da classe */
    public String getStatus(){
        return status;
    }
    public Paciente getPaciente(){
        return paciente;
    }
    public Dentista getDentista(){
        return dentista;
    }
    public Horario getHorario(){
        return horario;
    }
    public int getIdConsulta(){
        return idConsulta;
    }
    public String getDataHora(){
        return dataHora; 
    }
    public String getTipoConsulta(){
        return tipoConsulta;
    }
    public String getObservacoes(){
        return observacoes;
    }
}