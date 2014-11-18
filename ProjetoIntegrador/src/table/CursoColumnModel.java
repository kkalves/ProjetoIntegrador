/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.awt.FontMetrics;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Família
 */
public class CursoColumnModel extends DefaultTableColumnModel{
    
    private TableColumn createColumn(int columnIndex, int largura, FontMetrics fm, boolean resizeable, String titulo) {
        int larguraTitulo = fm.stringWidth(titulo + " ");
        if (largura < larguraTitulo)
            largura = larguraTitulo;
        TableColumn col = new TableColumn(columnIndex);
        col.setHeaderRenderer(null);
        col.setHeaderValue(titulo);
        col.setPreferredWidth(largura);
        if (!resizeable) {
            col.setMaxWidth(largura);
            col.setMinWidth(largura);
        }
        col.setResizable(resizeable);
        return col;
    }
    
    public CursoColumnModel(FontMetrics fm) {
        int digito = fm.stringWidth("0");
        int letra = fm.stringWidth("M");
        addColumn(createColumn(0, 4 * digito, fm, false, "Id"));
        addColumn(createColumn(1, 40 * letra, fm, true, "Nome"));
        addColumn(createColumn(2, 40 * letra, fm, true, "Eixo Técnológico"));
        addColumn(createColumn(3, 10 * letra, fm, false, "Carga Horária"));
        addColumn(createColumn(4, 6 * letra, fm, false, "Status"));
 
    } 
}
