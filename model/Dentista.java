package model;
import java.util.ArrayList;
import java.util.List;

public class Dentista extends Pessoa {
        private String cro;
        private String especialidade;
        private List<Horario> horarios;

        public Dentista(int id, String nome, String telefone, String email,
            String cro, String especialidade){
            super();
            this.cro = cro;
            this.especialidade = especialidade;
            this.horarios = new ArrayList();
        }

        
}
