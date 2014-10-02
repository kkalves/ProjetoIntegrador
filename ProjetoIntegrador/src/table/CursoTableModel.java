/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Curso;

/**
 *
 * @author Alex
 */
public class CursoTableModel extends AbstractTableModel {

    private List<Curso> valores;

    public CursoTableModel(List<Curso> valores) {
        this.valores = valores;
    }

    @Override
    public int getRowCount() {
        return valores.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Curso curso = valores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return curso.getNome();
            case 1:
                return curso.getDescricao();
            case 2:
                return curso.getEixoTecnologico();
            case 3:
                return curso.getCargaHoraria();
            case 4:
                return (curso.isStatus()? "Inativo" : "Ativo");
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String coluna = "";
        switch (column) {
            case 0:
                return coluna = "Nome";
            case 1:
                return coluna = "Descricao";
            case 2:
                return coluna = "Eixo Tecnologico";
            case 3:
                return coluna = "Carga Horaria";
            case 4:
                return coluna = "Status";
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
        }
        return null;
    }

    public Curso get(int row) {
        return valores.get(row);
    }
}
