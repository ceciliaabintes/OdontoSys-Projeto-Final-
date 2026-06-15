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
        //Tratamento de exceções
        if(diaSemana == null || diaSemana.isBlank()){
            throw new IllegalArgumentException("Dia da semana inválido");
        }
        if(horaInicio.equals(horaFim)){
            throw new IllegalArgumentException("Horario inicial e final não podem ser igauis");
        }
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
    public int getIdHorario(){
        return idHorario;
    }
    public String getDiaSemana(){
        return diaSemana;
    }
    public String getHoraInicio(){
        return horaInicio;
    }
    public String getHoraFim(){
        return horaFim;
    }
/*Método de verificação de disponibilidade do horário */
    public boolean isDisponivel(){
        return disponivel;
    }
/*Sobreescrevendo o método toString para atender as parcularidades de retorno da classe Horario */
    @Override
/*Método de retorno das informações concatenadas e formatadas */
    public String toString(){
        return "Posição: " + idHorario +
        "\nDia: " + diaSemana + 
        "\nInício: " + horaInicio +
        "\nFim: " + horaFim +
        "\nDisponivel" + disponivel;
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
