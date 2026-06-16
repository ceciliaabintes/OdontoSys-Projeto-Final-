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
}
