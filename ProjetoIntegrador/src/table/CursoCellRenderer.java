/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Giseli e Keyve
 */
public class CursoCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);         
        if (row % 2 == 0) {
            setBackground(Color.white);
            setForeground(Color.black);
        }else {
            setBackground(Color.lightGray);
        }        
        if (isSelected) {
            setBackground(Color.CYAN);
        }
        Font fonte = new Font("Arial", Font.PLAIN, 14);
        table.setFont(fonte);
        return this;
    }
   
}
