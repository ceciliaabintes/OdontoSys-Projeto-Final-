package model;

public class Horario {
    private int idHorario;
    private String diaSemana;
    private String horaInicio;
    private String horaFim;
    private boolean disponivel;

    public Horario(String diaSemana, String horaInicio, String horaFim, boolean disponivel){
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.disponivel = disponivel;
    }

    public String getData(){
        return diaSemana;
    }
    @Override
    public String toString(){
        return  + "-" + ;
    }
}
