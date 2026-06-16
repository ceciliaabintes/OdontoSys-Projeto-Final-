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
}
