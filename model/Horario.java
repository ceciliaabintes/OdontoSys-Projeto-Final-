package model;
/*Classe Horários que cria a instancia dos Horario da Consulta */
public class Horario {
    /*Atribitos da Classe Horário */
    private int idHorario;
    private String diaSemana;
    private String horaInicio;
    private String horaFim;
    private boolean disponivel;
/*Construtor da Classe Horário */
    public Horario(int idHorario, String diaSemana, String horaInicio, String horaFim, boolean disponivel){
        this.idHorario = idHorario;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.disponivel = disponivel;
    }
/*Método get para retorno de data */
    public String getData(){
        return diaSemana;
    }
/*Método de verificação de disponibilidade do horário */
    public boolean isDisponivel(){
        return disponivel;
    }
/*Sobreescrevendo o método toString para atender as parcularidades de retorno da classe Horario */
    @Override
/*Método de retorno das informações concatenadas e formatadas */
    public String toString(){
        return  "Início: " + horaInicio + "-" + "Fim: " + horaFim +
        "\nDia: " + diaSemana;
    }
/*Método para bloquear o horario */
    public void bloquear(){
       this.disponivel = false;
    }
/*Metodo para liberar o horario */
    public void liberar(){
        this.disponivel = true;
    }
}
