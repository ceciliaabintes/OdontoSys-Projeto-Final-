package model;
import java.util.ArrayList;
import java.util.List;

public class Dentista extends Pessoa {
/*Atributos da Classe Dentista */
        private String cro;
        private String especialidade;
        private List<Horario> horarios;
/*Construtor da Classe Dentista */
        public Dentista(int id, String nome, String telefone, String email,
            String cro, String especialidade){
            super(id, nome, telefone, email);
            //Tratamento de exceções
            if(cro == null || cro.isBlank()){
                throw new IllegalArgumentException("CRO inválido");
            }
            if(especialidade == null || especialidade.isBlank()){
                throw new IllegalArgumentException("Especialidade é obrigatória");
            }
            this.cro = cro;
            this.especialidade = especialidade;
            this.horarios = new ArrayList<>();
        }
/*Metodos getters para retorno de informações */
        public String getCro(){
                return cro;
        }
        public String getEspecialidade(){
                return especialidade;
        }
/*Método para o Dentista definir os horários de atendimento*/
        public void definirHorario (Horario h){
            horarios.add(h);
        }
/*Método sobreescrito para atender as especificidades da classe Dentista */
        @Override
        public String getDados(){
            return "Dentista: " + getNome() +
            "\nCRO: " + cro +
            "\nEspecialidade: " + especialidade +
            "\nTelefone: " + getTelefone() +
            "\nEmail: " + getEmail();
        }
/*Método de retorno para lista de horários de atendimento */
        public List<Horario> getHorarios(){
            return horarios;
        }
}
