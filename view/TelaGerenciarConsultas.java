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
        add(btnConfirmar);

        btnCancelar = new JButton("Cancelar");
        add(btnCancelar);
        btnConfirmar.addActionListener(e -> confirmar());
        btnCancelar.addActionListener(e -> cancelar());

        setVisible(true);

   }    
   private void confirmar(){
    try{
        int id = Integer.parseInt(txtIdConsulta.getText());
        boolean sucess = sistema.confirmarConsulta(id);
        if(sucess){
            JOptionPane.showMessageDialog(this, "Consulta confirmada");
        }else{
            JOptionPane.showMessageDialog(this, "Consulta não encontrada");

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
   }
   private void cancelar(){
    try{
        int id = Integer.parseInt(txtIdConsulta.getText());
        boolean sucess = sistema.cancelarConsulta(id);
        if(sucess){
            JOptionPane.showMessageDialog(this, "Consulta cancelada");
        }else{
            JOptionPane.showMessageDialog(this, "Consulta não encontrada");

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
   }
}
