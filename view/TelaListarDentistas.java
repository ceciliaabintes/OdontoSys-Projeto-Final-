package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Dentista;
import service.SistemaAgendamento;;
public class TelaListarDentistas extends JFrame{
    private SistemaAgendamento sistema;
    private JTable tabela;
    private DefaultTableModel modelo;

    public TelaListarDentistas(SistemaAgendamento sistema){
        this.sistema = sistema;

        setTitle("Dentistas Cadastrados");
        setSize(800,400);
        setLocationRelativeTo(null);
    }
}