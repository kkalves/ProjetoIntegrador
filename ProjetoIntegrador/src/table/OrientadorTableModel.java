package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Orientador;

/**
 *
 * @author Giseli e Keyve
 */
public class OrientadorTableModel extends AbstractTableModel {

    private List<Orientador> valores;

    public OrientadorTableModel(List<Orientador> valores) {
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
        Orientador orientador = valores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return orientador.getId();
            case 1:
                return orientador.getNome();
            case 2:
                return orientador.getCpf();
            case 3:
                return orientador.getRg();
            case 4:
                return orientador.getTitulacao();
            case 5:
                return orientador.getDataEntrada();
            case 6:
                return (orientador.isStatus() ? "Ativo" : "Inativo");
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

    public Orientador get(int row) {
        return valores.get(row);
    }
}
