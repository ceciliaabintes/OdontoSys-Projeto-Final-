package model;

public class Consulta {
    private int idConsulta;
    private String dataHora;
    private String tipoConsulta;
    private String status;
    private String observacoes;

    private Paciente paciente;
    private Dentista dentista;
    private Horario horario;

    public Consulta(int idConsulta, String dataHora, String tipoConsulta, String observacoes){
        this.idConsulta = idConsulta;
        this.dataHora = dataHora;
        this.tipoConsulta = tipoConsulta;
        this.observacoes = observacoes;
        this.status = "Pendente";
    }

    public void agendar(Paciente p, Dentista d, Horario h){
        this.dentista = d;
        this.paciente = p;
        this.horario = h;
        h.bloquear(); 

        this.status = "Agendada";
    }
    public void cancelar(){
        this.status = "Cancelado";

        if(horario!= null){
            horario.liberar();
        }
    }
    public void confirmar(){
        this.status = "Confirmada";
    }
    public String getStatus(){
        return status;
    }
    public Paciente getPaciente(){
        return paciente;
    }
    public Dentista geteDentista(){
        return dentista;
    }
    public Horario getHorario(){
        return horario;
    }
}