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
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Sistema para Agendamento de Consultas");


        btnPaciente = new JButton("Cadastrar Paciente");
        btnDentista = new JButton("Cadastrar Dentista");
        btnHorario = new JButton("Cadastrar Horario");
        btnConsulta = new JButton("Agendar Consulta");
        btnListar = new JButton("Cadastrar Paciente");
        btnSair = new JButton("Sair");

        btnPaciente.setAlignmentX(CENTER_ALIGNMENT);
        btnDentista.setAlignmentX(CENTER_ALIGNMENT);
        btnHorario.setAlignmentX(CENTER_ALIGNMENT);
        btnConsulta.setAlignmentX(CENTER_ALIGNMENT);
        btnListar.setAlignmentX(CENTER_ALIGNMENT);
        btnSair.setAlignmentX(CENTER_ALIGNMENT);

        painel.add(Box.createVerticalStrut(20));
        painel.add(titulo);
        btnSair.addActionListener(e -> System.exit(0));
        setVisible(true);
    }
}
