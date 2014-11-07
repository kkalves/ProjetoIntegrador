/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Aluno;

/**
 *
 * @author Família
 */
public class AlunoTableModel extends AbstractTableModel {

    private List<Aluno> valores;

    public AlunoTableModel(List<Aluno> valores) {
        this.valores = valores;
    }

    @Override
    public int getRowCount() {
        return valores.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno aluno = valores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return aluno.getId();
            case 1:
                return aluno.getNome();
            case 2:
                return aluno.getCpf();
            case 3:
                return aluno.getRg();
            case 4:
                return aluno.getTelefone();
            case 5:
                return aluno.getDataNascimento();
            case 6:
                return aluno.getSituacao();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String coluna = "";
        switch (column) {
            case 0:
                return coluna = "Id";
            case 1:
                return coluna = "Nome";
            case 2:
                return coluna = "CPF";
            case 3:
                return coluna = "RG";
            case 4:
                return coluna = "Telefone";
            case 5:
                return coluna = "Data De Nascimento";
            case 6:
                return coluna = "Situação";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            case 6:
                return String.class;
        }
        return null;
    }

    public Aluno get(int row) {
        return valores.get(row);
    }
}
