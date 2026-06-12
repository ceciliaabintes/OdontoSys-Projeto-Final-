package service;
import model.Paciente;
public class ValidadorPaciente implements IValidador{
   private Paciente paciente;
    
    public ValidadorPaciente(Paciente paciente){
        this.paciente = paciente;
    }
    @Override
    public boolean validar(){
        return paciente != null;
    }
}
