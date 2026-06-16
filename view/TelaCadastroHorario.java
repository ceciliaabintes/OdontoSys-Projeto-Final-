package view;
import javax.swing.*;
import java.awt.*;

import model.Horario;
import service.SistemaAgendamento;

public class TelaCadastroHorario extends JFrame {
    
    private SistemaAgendamento sistema;

    private JTextField txtId;
    private JTextField txtDiaSemana;
    private JTextField txtHoraInicio;
    private JTextField txtHoraFim;

    private JButton btnSalvar;

    public TelaCadastroHorario(SistemaAgendamento sistema){
        this.sistema = sistema;

        setTitle("Cadastro de Horario");
        setSize(450,300);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(5,2));
        
    }
}
