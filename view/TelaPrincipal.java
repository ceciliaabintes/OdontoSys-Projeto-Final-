package view;
import javax.swing.*;
import java.awt.Font;
import service.SistemaAgendamento;
public class TelaPrincipal extends JFrame{

    private SistemaAgendamento sistema;

    private JButton btnPaciente;
    private JButton btnListarPacientes;
    private JButton btnDentista;
    private JButton btnHorario;
    private JButton btnConsulta;
    private JButton btnListar;
    private JButton btnGerenciarConsultas;
    private JButton btnListarDentistas;
    private JButton btnSair;

    public TelaPrincipal(SistemaAgendamento sistema){
        Font fonteTitulo = new Font("Segoe UI", Font.BOLD, 18);
        Font fonteBotao = new Font("Segoe UI", Font.PLAIN, 14);

        java.awt.Dimension tamanhoBotao = new java.awt.Dimension(220, 35);

        this.sistema = sistema;
        setTitle("OdontoSys");
        setSize(490, 580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Sistema para Agendamento de Consultas");
        titulo.setFont(fonteTitulo);
        titulo.setAlignmentX(CENTER_ALIGNMENT);

        btnPaciente = new JButton("Cadastrar Paciente");
        btnListarPacientes = new JButton("Listar Pacientes");
        btnDentista = new JButton("Cadastrar Dentista");
        btnListarDentistas = new JButton("Listar Dentistas");
        btnHorario = new JButton("Cadastrar Horario");
        btnConsulta = new JButton("Agendar Consulta");
        btnListar = new JButton("Listar Consultas");
        btnSair = new JButton("Sair");
        btnGerenciarConsultas = new JButton("Gerenciar Consulta");

        JButton[] todosBotoes = {
            btnPaciente, btnListarPacientes, btnDentista, btnListarDentistas, 
            btnHorario, btnConsulta, btnListar, btnGerenciarConsultas, btnSair
        };

       for(JButton btn : todosBotoes){
            btn.setFont(fonteBotao);
            btn.setPreferredSize(tamanhoBotao);
            btn.setMinimumSize(tamanhoBotao);
            btn.setMaximumSize(tamanhoBotao);
            btn.setAlignmentX(CENTER_ALIGNMENT);
            btn.setFocusPainted(false);
        }

        btnSair.addActionListener(e -> System.exit(0));
        btnPaciente.addActionListener( e -> new TelaCadastroPaciente(sistema));
        btnListarPacientes.addActionListener(e ->{new TelaListarPacientes(sistema);});
        btnDentista.addActionListener(e -> new TelaCadastroDentista(sistema));
        btnHorario.addActionListener(e -> new TelaCadastroHorario(sistema));
        btnConsulta.addActionListener(e -> new TelaAgendarConsulta(sistema));
        btnListar.addActionListener(e -> new TelaListarConsultas(sistema));
        btnGerenciarConsultas.addActionListener(e -> new TelaGerenciarConsultas(sistema));
        btnListarDentistas.addActionListener(e -> new TelaListarDentistas(sistema));

        painel.add(Box.createVerticalStrut(20));
        painel.add(titulo);
        painel.add(Box.createVerticalStrut(25));

        painel.add(btnPaciente);
        painel.add(Box.createVerticalStrut(10));

        painel.add(btnListarPacientes);
        painel.add(Box.createVerticalStrut(10));

        painel.add(btnDentista);
        painel.add(Box.createVerticalStrut(10));

         painel.add(btnListarDentistas);
        painel.add(Box.createVerticalStrut(10));

        painel.add(btnHorario);
        painel.add(Box.createVerticalStrut(10));

        painel.add(btnConsulta);
        painel.add(Box.createVerticalStrut(10));

        painel.add(btnListar);
        painel.add(Box.createVerticalStrut(10));

        painel.add(btnGerenciarConsultas);
        painel.add(Box.createVerticalStrut(20));

        painel.add(btnSair);

        add(painel);
        setVisible(true);
    }
}
