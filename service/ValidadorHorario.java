package service;
import model.Horario;
/** Classe Validador Horario que implementa IValidador */
public class ValidadorHorario implements IValidador {
    private Horario horario;
    /** Construtor de Validador Horario */
    public ValidadorHorario(Horario horario){
        this.horario = horario;
    }
    @Override
    /** Implementação do método validar estabelecido com a interface */
    public boolean validar(){
        if (horario == null){
            return false;
        }
        return horario.isDisponivel();
    }
}