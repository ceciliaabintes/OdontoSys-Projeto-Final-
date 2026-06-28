package view;
import javax.swing.*;
import service.SistemaAgendamento;

public class TelaGerenciarConsultas extends JFrame{
   private SistemaAgendamento sistema;
   
   private JTextField txtIdConsulta;

   private JButton btnConfirmar;
   private JButton btnCancelar;

   public TelaGerenciarConsultas(SistemaAgendamento sistema){
        this.sistema = sistema;
        setSize(300,200);
        setLocationRelativeTo(null);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new JLabel("ID da Consulta"));

        txtIdConsulta = new JTextField();
        add(txtIdConsulta);

        btnConfirmar = new JButton("Confirmar");
   }    

}
