package view;
import java.awt.GridLayout;

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

    public TelaCadastroPaciente(SistemaAgendamento sistema){
        this.sistema = sistema;

        setTitle("Cadastro Paciente");
        setSize(400,400);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(8,2));
        add(new JLabel("ID: "));
        txtId = new JTextField();

        add(new JLabel("Nome: "));
        txtNome = new JTextField();

        add(new JLabel("Telefone: "));
        txtTelefone = new JTextField();
    }
}
