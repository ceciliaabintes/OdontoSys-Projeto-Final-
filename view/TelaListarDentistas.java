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

        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("CRO");
        modelo.addColumn("Especialidade");
        modelo.addColumn("Telefone");

        tabela = new JTable(modelo);

        carregarDentistas();
        add(new JScrollPane(tabela));

        setVisible(true);
    }
    public void carregarDentistas(){
        modelo.setRowCount(0);

        for(Dentista dentista : sistema.getDentistas()){
            modelo.addRow(new Object[]{
                dentista.getId(),
                dentista.getNome(),
                dentista.getCro(),
                dentista.getEspecialidade(),
                dentista.getTelefone()
            });
        }
    }
}