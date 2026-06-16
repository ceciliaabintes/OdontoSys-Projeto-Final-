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

        add(new JLabel("ID Horário:"));
        txtId = new JTextField();
        add(txtId);

        add(new JLabel("Dia da Semana:"));
        txtDiaSemana = new JTextField();
        add(txtDiaSemana);

        add(new JLabel("Hora Início:"));
        txtHoraInicio = new JTextField();
        add(txtHoraInicio);

        add(new JLabel("Hora Fim:"));
        txtHoraFim = new JTextField();
        add(txtHoraFim);

         btnSalvar = new JButton("Salvar Horário");
        add(btnSalvar);
         btnSalvar.addActionListener(e -> cadastrarHorario());

         setVisible(true);
    }
    private void cadastrarHorario(){
        try{

            int id = Integer.parseInt(txtId.getText());

            Horario horario = new Horario(
                    id,
                    txtDiaSemana.getText(),
                    txtHoraInicio.getText(),
                    txtHoraFim.getText(),
                    true
                );
            sistema.adicionarHorario(horario);
            JOptionPane.showMessageDialog(
                this,
                "Horario cadastrado com sucesso"
            );

        }catch(Exception e ){
            JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
