package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Curso;

/**
 *
 * @author Giseli e Keyve
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
                return curso.getId();
            case 1:
                return curso.getNome();
            case 2:
                return curso.getEixoTecnologico();
            case 3:
                return curso.getCargaHoraria();
            case 4:
                return (curso.isStatus() ? "Ativo" : "Inativo");
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
                return coluna = "Eixo Técnológico";
            case 3:
                return coluna = "Carga Horária";
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
