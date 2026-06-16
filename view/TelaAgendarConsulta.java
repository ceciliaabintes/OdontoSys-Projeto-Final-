package view;
import javax.swing.*;
import java.awt.*;

import model.Consulta;
import model.Dentista;
import model.Horario;
import model.Paciente;
import service.SistemaAgendamento;

public class TelaAgendarConsulta extends JFrame {
    private SistemaAgendamento sistema;

    private JTextField txtIdConsulta;
    private JTextField txtTipoConsulta;

    private JTextArea txtObservacoes;

    private JComboBox<Paciente> cbPaciente;
    private JComboBox<Dentista> cbDentista;
    private JComboBox<Horario> cbHorario;

    private JButton btnAgendar;
      public void carregarDados(){ 
    for(Paciente paciente : sistema.getPacientes()){
        cbPaciente.addItem(paciente);
    }
    for(Dentista dentista : sistema.getDentistas()){
        cbDentista.addItem(dentista);
    }
    for(Horario horario : sistema.getHorarios()){
            if(horario.isDisponivel()){
                cbHorario.addItem(horario);
            }
        }
    }
    public TelaAgendarConsulta(SistemaAgendamento sistema){
        this.sistema = sistema;

        setTitle("Agendamento de Consulta");
        setSize(500, 400);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(7,2));

        add(new JLabel("ID Consulta: "));
        txtIdConsulta = new JTextField();
        add(txtIdConsulta);

        add(new JLabel("Paciente: "));
        cbPaciente = new JComboBox<>();
        add(cbPaciente);
        add(new JLabel("Dentista: "));
        cbDentista = new JComboBox<>();
        add(cbDentista);
        add(new JLabel("Horário: "));
        cbHorario = new JComboBox<>();
        add(cbHorario);
        add(new JLabel("Tipo Consulta"));
        txtTipoConsulta = new JTextField();
        add(txtTipoConsulta);
        add(new JLabel("Observações: "));
        txtObservacoes = new JTextArea();
        add(new JScrollPane(txtObservacoes));

        btnAgendar = new JButton("Agendar Consulta");
        add(btnAgendar);

        btnAgendar.addActionListener(e -> agendarConsulta());
        setVisible(true);
    }
    private void agendarConsulta(){

    }
}
