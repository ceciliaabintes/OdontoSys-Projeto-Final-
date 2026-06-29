package service;
import model.Paciente;
public class ValidadorPaciente implements IValidador{
   private Paciente paciente;
    /*Construtor de Validador Paciente  */
    public ValidadorPaciente(Paciente paciente){
        this.paciente = paciente;
    }
    @Override
     /*Implementação do método validar estabelecido com a interface */
    public boolean validar(){
        return paciente != null;
    }
}
