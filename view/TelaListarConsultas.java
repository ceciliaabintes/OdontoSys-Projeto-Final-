package view;
import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;

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
    }
}
