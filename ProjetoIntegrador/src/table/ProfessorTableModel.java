package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Professor;

/**
 *
 * @author Giseli e Keyve
 */
public class ProfessorTableModel extends AbstractTableModel {

    private List<Professor> valores;

    public ProfessorTableModel(List<Professor> valores) {
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
        Professor professor = valores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return professor.getId();
            case 1:
                return professor.getNome();
            case 2:
                return professor.getCpf();
            case 3:
                return professor.getRg();
            case 4:
                return professor.getTitulacao();
            case 5:
                return professor.getDataEntrada();
            case 6:
                return (professor.isStatus() ? "Ativo" : "Inativo");
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
                return coluna = "Titulação";
            case 5:
                return coluna = "Data De Entrada";
            case 6:
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
            case 5:
                return String.class;
            case 6:
                return String.class;
        }
        return null;
    }

    public Professor get(int row) {
        return valores.get(row);
    }
}
