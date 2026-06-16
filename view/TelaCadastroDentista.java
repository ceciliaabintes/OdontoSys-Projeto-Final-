package view;
import javax.swing.*;
import java.awt.*;

import model.Dentista;
import service.SistemaAgendamento;

public class TelaCadastroDentista extends JFrame{
    private SistemaAgendamento sistema;
    
    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JTextField txtCro;
    private JTextField txtEspecialidade;

    private JButton btnSalvar;

public TelaCadastroDentista(SistemaAgendamento sistema){
        this.sistema = sistema;

        setTitle("Cadastro Dentista");
        setSize(500,350);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(7,2));

        add(new JLabel("ID:"));
        txtId = new JTextField();
        add(txtId);

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Telefone:"));
        txtTelefone = new JTextField();
        add(txtTelefone);

        add(new JLabel("Email:"));
        txtEmail = new JTextField();
        add(txtEmail);

        add(new JLabel("CRO:"));
        txtCro = new JTextField();
        add(txtCro);

        add(new JLabel("Especialidade:"));
        txtEspecialidade = new JTextField();
        add(txtEspecialidade);

        btnSalvar = new JButton("Salvar Dentista");
        add(btnSalvar);

         btnSalvar.addActionListener(e -> cadastrarDentista());

         setVisible(true);
    }
    private void cadastrarDentista(){
        try{
            int id = Integer.parseInt(txtId.getText());

            Dentista dentista = new Dentista (id, 
                txtNome.getText(),
                txtTelefone.getText(),
                txtEmail.getText(),
                txtCro.getText(),
                txtEspecialidade.getText()
            );

            sistema.adicionarPessoa(dentista);

            JOptionPane.showMessageDialog(
                this,
                "Dentista cadastrado com sucesso"
            );
        }catch (Exception e){
                JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
                );
        }
    }
}
