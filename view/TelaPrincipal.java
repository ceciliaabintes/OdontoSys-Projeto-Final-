package view;
import javax.swing.*;
import java.awt.*;
public class TelaPrincipal extends JFrame{
    private JButton btnPaciente;
    private JButton btnDentista;
    private JButton btnHorario;
    private JButton btnConsulta;
    private JButton btnListar;
    private JButton btnSair;

    public TelaPrincipal(){
        setTitle("OdontoSys");
        setSize(700, 700);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(null);

        setLayout(new GridLayout (6,1,10,10));

        btnPaciente = new JButton("Cadastrar Paciente");
        btnDentista = new JButton("Cadastrar Dentista");
        btnHorario = new JButton("Cadastrar Horario");
        btnConsulta = new JButton("Agendar Consulta");
        btnListar = new JButton("Cadastrar Paciente");
        btnSair = new JButton("Sair");

        add(btnPaciente);
        add(btnDentista);
        add(btnHorario);
        add(btnListar);
        add(btnConsulta);
        add(btnSair);
    }
}
