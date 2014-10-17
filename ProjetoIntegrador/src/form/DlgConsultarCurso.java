/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import dao.CursoDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Curso;
import table.CursoCellRenderer;
import table.CursoTableModel;

/**
 *
 * @author Giseli e Keyve
 */
public class DlgConsultarCurso extends javax.swing.JDialog {

    CursoDAO cursoDAO = new CursoDAO();
    List<Curso> listaCurso = new ArrayList<>();
    
    public DlgConsultarCurso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        URL caminhoImagem = this.getClass().getClassLoader().getResource("simbolo.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
        setIconImage(iconeTitulo);
        initComponents();
        if (listaCurso != null) {
            atualizarTabela("SELECT idCurso, nome, descricao, eixoTecnologico, cargaHoraria, status "
                    + "FROM Curso c;");
        }
    }
    
    private void atualizarTabela(String sql) {
        try {
            listaCurso = cursoDAO.consultarSQL(sql);
            if (listaCurso != null) {
                tableCurso.setModel(new CursoTableModel(listaCurso));
                tableCurso.setDefaultRenderer(Object.class, new CursoCellRenderer());
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar clientes na base de dados");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenuAlterar = new javax.swing.JPopupMenu();
        popupMenuRemover = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCurso = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btEnviar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consultar Curso");

        tableCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Curso", "Descrição", "Eixo Tecnológico", "Carga Horária", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCursoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCurso);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nome:");

        tfNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/consultar.png"))); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.setToolTipText("");
        btBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        btEnviar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Enviar.png"))); // NOI18N
        btEnviar.setText("Enviar");
        btEnviar.setActionCommand("btEnviar");
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btEnviar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btVoltar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.setActionCommand("btVoltar");
        btVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tfNome)
                        .addGap(18, 18, 18)
                        .addComponent(btBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        try {
            Curso curso = cursoDAO.buscarPorNome(tfNome.getText());
            if (curso != null) {
                JOptionPane.showMessageDialog(this, "O Curso foi encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                atualizarTabela("SELECT idCurso, nome, descricao, eixoTecnologico, cargaHoraria, status "
                        + "FROM Curso c "
                        + "WHERE c.nome LIKE \"" + curso.getNome() + "%\";");

            } else {
                JOptionPane.showMessageDialog(this, "O curso não foi encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de SQL Buscar por nome!");
        }
    }//GEN-LAST:event_btBuscarActionPerformed
    DlgGerenciadorCurso janelaCurso;
    private void tableCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCursoMouseClicked
        if (evt.getClickCount() == 2) {
            if (this.tableCurso.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um curso!");
            } else {
                int linhaSelecionada = this.tableCurso.getSelectedRow();
                int idCurso = (int) this.tableCurso.getValueAt(linhaSelecionada, 0);
                janelaCurso = new DlgGerenciadorCurso(null, true);
                janelaCurso.recuperarDadosAlterarCurso(idCurso);
                this.dispose();
                janelaCurso.setVisible(true);
            }
        }
    }//GEN-LAST:event_tableCursoMouseClicked

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
//        JOptionPane.showMessageDialog(this, "A Operação foi encerrada!");
        janelaCurso = new DlgGerenciadorCurso(null, true);
        this.dispose();
        janelaCurso.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        if (this.tableCurso.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um curso!");
        } else {
            int linhaSelecionada = this.tableCurso.getSelectedRow();
            int idCurso = Integer.parseInt((String) this.tableCurso.getValueAt(linhaSelecionada, 0));
            janelaCurso = new DlgGerenciadorCurso(null, true);
            janelaCurso.recuperarDadosAlterarCurso(idCurso);
            this.dispose();
            janelaCurso.setVisible(true);
        }
    }//GEN-LAST:event_btEnviarActionPerformed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgConsultarCurso dialog = new DlgConsultarCurso(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEnviar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popupMenuAlterar;
    private javax.swing.JPopupMenu popupMenuRemover;
    private javax.swing.JTable tableCurso;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
