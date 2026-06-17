package view;
import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import model.Consulta;
import service.SistemaAgendamento;

public class TelaListarConsultas extends JFrame {
    private SistemaAgendamento sistema;

    private JTable table;
    private DefaultTableModel modelo;

    public TelaListarConsultas(SistemaAgendamento sistema){
        this.sistema = sistema;

        setTitle("Consultas Agendadas");
        setSize(800,400);
        setLocationRelativeTo(null);

        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Paciente");
        modelo.addColumn("Dentista");
        modelo.addColumn("Tipo");
        modelo.addColumn("Status");

        table = new JTable(modelo);
        carregarConsultas();

        add(new JScrollPane(table));
        setVisible(true);
    }
    private void carregarConsultas(){
        for(Consulta consulta : sistema.getConsultas()){
            modelo.addRow(new Object[]{
                consulta.getIdConsulta(),
                consulta.getPaciente().getNome(),
                consulta.getDentista().getNome(),
                consulta.getTipoConsulta(),
                consulta.getStatus()
            });
        }
    }
}
