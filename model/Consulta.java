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
        //Tratamento de exceções
        if(status.equals("Pendente")){
            //Garantindo que consultas com status pendente não sejam canceladas
            throw new IllegalArgumentException("A consulta ainda não foi agendada");
        }
        this.status = "Cancelado";

        if(horario!= null){
            horario.liberar();
        }
    }
/*Métodos para confirmação de consultas */
    public void confirmar(){
        //Tratamento de exceções
        if(status.equals("Cancelado")){
            //Garantindo que mesmo cancelada uma consulta não terá possibilidade de ser confirmada
            throw new IllegalArgumentException("Não é possível confirmar uma consulta que já foi cancelada");
        }
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

    public String toString(){
        return "Consulta nº: " + idConsulta +
        "\nPaciente: " + paciente.getNome() +
        "\nDentista: " + dentista.getNome() +
        "\nData/Hora: " + dataHora + 
        "\nTipo: " + tipoConsulta +
        "\nStatus: " + status +
        "\nObservações: " + observacoes;
    }
}