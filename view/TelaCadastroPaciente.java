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
    private JTextField txtNascimento;
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
        add(txtId);

        add(new JLabel("Nome: "));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Telefone: "));
        txtTelefone = new JTextField();
        add(txtTelefone);

         add(new JLabel("Email: "));
        txtEmail = new JTextField();
        add(txtEmail);

        add(new JLabel("CPF: "));
        txtCpf = new JTextField();
        add(txtCpf);

        add(new JLabel("Nascimento: "));
        txtNascimento = new JTextField();
        add(txtNascimento);

        add(new JLabel("Endereco: "));
        txtEndereco = new JTextField();
        add(txtEndereco);

        add(new JLabel("Cadastrar: "));
        add(btnCadastrar);

        btnCadastrar.addActionListener(e -> cadastrarPaciente());
        setVisible(true);
    }

    private void cadastrarPaciente(){
        
    }
}
