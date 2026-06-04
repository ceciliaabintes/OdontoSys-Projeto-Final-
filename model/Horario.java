package model;

public class Horario {
    private String data;
    private String hora;

    public Horario(String data, String hora){
        this.data = data;
        this.hora = hora;
    }

    public String getData(){
        return data;
    }
    @Override
    public String toString(){
        return data + "-" + hora;
    }
}
