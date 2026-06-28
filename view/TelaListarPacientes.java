package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Paciente;
import service.SistemaAgendamento;
public class TelaListarPacientes extends JFrame{
    
    private SistemaAgendamento sistema;

    private JTable tabela;
    private DefaultTableModel modelo;

     public TelaListarPacientes(SistemaAgendamento sistema){

        this.sistema = sistema;

        setTitle("Pacientes Cadastrados");
        setSize(800,400);
        setLocationRelativeTo(null);

        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("CPF");
        modelo.addColumn("Telefone");
        modelo.addColumn("Email");

        tabela = new JTable(modelo);

        carregarPacientes();

        add(new JScrollPane(tabela));

        setVisible(true);
    }
    private void carregarPacientes(){

        modelo.setRowCount(0);

        for(Paciente paciente : sistema.getPacientes()){

            modelo.addRow(new Object[]{
                paciente.getId(),
                paciente.getNome(),
                paciente.getCpf(),
                paciente.getTelefone(),
                paciente.getEmail()
            });
        }
    }
}
