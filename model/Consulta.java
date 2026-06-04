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
            if(!h.di){

            }
        this.dentista = d;
        this.paciente = p;
        this.horario = h;
        this.status = "Agendada";
        h.disponivel() = false;
    }
    public void cancelar(){
        return ;
    }
}