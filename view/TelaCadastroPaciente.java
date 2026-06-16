package view;
import javax.swing.*;

import model.Paciente;
import service.SistemaAgendamento;

public class TelaCadastroPaciente extends JFrame {
    private SistemaAgendamento sistema;

    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JTextField txtCpf;
    private JTextField txtEndereco;

    private JButton btnCadastrar;

    public TelaCadastroPaciente(Sistema sistema){

    }
}
