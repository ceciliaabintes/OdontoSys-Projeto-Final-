package view;
import javax.swing.*;
import service.SistemaAgendamento;
public class TelaPrincipal extends JFrame{

    private SistemaAgendamento sistema;

    private JButton btnPaciente;
    private JButton btnDentista;
    private JButton btnHorario;
    private JButton btnConsulta;
    private JButton btnListar;
    private JButton btnSair;

    public TelaPrincipal(SistemaAgendamento sistema){
        this.sistema = sistema;
        setTitle("OdontoSys");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Sistema para Agendamento de Consultas");


        btnPaciente = new JButton("Cadastrar Paciente");
        btnDentista = new JButton("Cadastrar Dentista");
        btnHorario = new JButton("Cadastrar Horario");
        btnConsulta = new JButton("Agendar Consulta");
        btnListar = new JButton("Listar Consultas");
        btnSair = new JButton("Sair");

        btnPaciente.setAlignmentX(CENTER_ALIGNMENT);
        btnDentista.setAlignmentX(CENTER_ALIGNMENT);
        btnHorario.setAlignmentX(CENTER_ALIGNMENT);
        btnConsulta.setAlignmentX(CENTER_ALIGNMENT);
        btnListar.setAlignmentX(CENTER_ALIGNMENT);
        btnSair.setAlignmentX(CENTER_ALIGNMENT);

        btnSair.addActionListener(e -> System.exit(0));
        btnPaciente.addActionListener( e -> new TelaCadastroPaciente(sistema));
        btnDentista.addActionListener(e -> new TelaCadastroDentista(sistema));
        btnHorario.addActionListener(e -> new TelaCadastroHorario(sistema));

        painel.add(Box.createVerticalStrut(20));
        painel.add(titulo);
        painel.add(Box.createVerticalStrut(20));

        painel.add(btnPaciente);
        painel.add(Box.createHorizontalStrut(15));

        painel.add(btnDentista);
        painel.add(Box.createHorizontalStrut(15));

        painel.add(btnHorario);
        painel.add(Box.createHorizontalStrut(15));

         painel.add(btnConsulta);
        painel.add(Box.createHorizontalStrut(15));

        painel.add(btnListar);
        painel.add(Box.createHorizontalStrut(15));

        painel.add(btnSair);

        add(painel);
        setVisible(true);
    }
}
