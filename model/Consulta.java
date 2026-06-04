package model;

public class Consulta {
    private int idConsulta;
    private String dataHora;
    private String tipoConsulta;
    private String status;
    private String observacoes;

    private Paciente paciente;
    private Dentista dentista;

    public Consulta(int idConsulta, String dataHora, String tipoConsulta, String observacoes){
        this.idConsulta = idConsulta;
        this.dataHora = dataHora;
        this.tipoConsulta = tipoConsulta;
        this.observacoes = observacoes;
        this.status = "Pendente";
    }

    public void agendar(Paciente p, Dentista d){
        this.dentista = d;
        this.paciente = p;
        this.status = "Agendada";
    }
}