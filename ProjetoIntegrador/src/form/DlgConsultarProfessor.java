package form;

import dao.ProfessorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Professor;
import table.ProfessorTableModel;

/**
 *
 * @author Giseli E Keyve
 */
public class DlgConsultarProfessor extends javax.swing.JDialog {

    public DlgConsultarProfessor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (listaProfessor != null) {
            atualizarTabela("SELECT * FROM Professor o, Endereco e, ContaBancaria cb "
                    + "WHERE o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;");
        }
    }
    DlgGerenciadorProfessor janelaProfessor;
    ProfessorDAO professorDAO = new ProfessorDAO();
    List<Professor> listaProfessor = new ArrayList<>();
    Professor professor;

    private void atualizarTabela(String sql) {
        try {
            listaProfessor = professorDAO.consultarSQL(sql);
            if (listaProfessor != null) {
                tableProfessor.setModel(new ProfessorTableModel(listaProfessor));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        btBuscarPorNome = new javax.swing.JButton();
        lbCpf = new javax.swing.JLabel();
        tfCpf = new javax.swing.JTextField();
        btBuscarPorCpf = new javax.swing.JButton();
        lbRg = new javax.swing.JLabel();
        btBuscarPorRG = new javax.swing.JButton();
        tfRg = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProfessor = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btEnviar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btVoltar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consultar Professor");

        lbNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNome.setText("Nome:");

        tfNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btBuscarPorNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btBuscarPorNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/consultar.png"))); // NOI18N
        btBuscarPorNome.setText("Buscar");
        btBuscarPorNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarPorNomeActionPerformed(evt);
            }
        });

        lbCpf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbCpf.setText("CPF:");

        tfCpf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btBuscarPorCpf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btBuscarPorCpf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/consultar.png"))); // NOI18N
        btBuscarPorCpf.setText("Buscar");
        btBuscarPorCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarPorCpfActionPerformed(evt);
            }
        });

        lbRg.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbRg.setText("RG:");

        btBuscarPorRG.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btBuscarPorRG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/consultar.png"))); // NOI18N
        btBuscarPorRG.setText("Buscar");
        btBuscarPorRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarPorRGActionPerformed(evt);
            }
        });

        tfRg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tableProfessor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tableProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "CPF", "RG", "Data De Entrada", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProfessorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProfessor);
        if (tableProfessor.getColumnModel().getColumnCount() > 0) {
            tableProfessor.getColumnModel().getColumn(0).setResizable(false);
            tableProfessor.getColumnModel().getColumn(1).setResizable(false);
            tableProfessor.getColumnModel().getColumn(2).setResizable(false);
            tableProfessor.getColumnModel().getColumn(3).setResizable(false);
            tableProfessor.getColumnModel().getColumn(4).setResizable(false);
            tableProfessor.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        btEnviar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Enviar.png"))); // NOI18N
        btEnviar.setText("Enviar");
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });
        jPanel1.add(btEnviar);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btVoltar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        jPanel2.add(btVoltar);

        btCancelar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNome)
                            .addComponent(lbCpf, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbRg, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNome)
                            .addComponent(tfCpf)
                            .addComponent(tfRg))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btBuscarPorNome, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(btBuscarPorCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btBuscarPorRG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(btCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarPorNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCpf)
                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarPorCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRg)
                    .addComponent(btBuscarPorRG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        if (this.tableProfessor.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Um professor precisa estar selecionado na tabela!");
        } else {
            int linhaSelecionada = this.tableProfessor.getSelectedRow();
            int idProfessor = Integer.parseInt((String) this.tableProfessor.getValueAt(linhaSelecionada, 0));
            janelaProfessor = new DlgGerenciadorProfessor(null, true);
            janelaProfessor.recuperarDadosAlterarProfessor(idProfessor);
            this.dispose();
            janelaProfessor.setVisible(true);
        }
    }//GEN-LAST:event_btEnviarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        janelaProfessor = new DlgGerenciadorProfessor(null, true);
        this.dispose();
        janelaProfessor.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void tableProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProfessorMouseClicked
        if (evt.getClickCount() == 2) {
            if (this.tableProfessor.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Um professor precisa estar selecionado na tabela!");
            } else {
                int linhaSelecionada = this.tableProfessor.getSelectedRow();
                int idProfessor = (int) this.tableProfessor.getValueAt(linhaSelecionada, 0);
                janelaProfessor = new DlgGerenciadorProfessor(null, true);
                janelaProfessor.recuperarDadosAlterarProfessor(idProfessor);
                this.dispose();
                janelaProfessor.setVisible(true);
            }
        }
    }//GEN-LAST:event_tableProfessorMouseClicked

    private void btBuscarPorNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarPorNomeActionPerformed
        try {
            professor = professorDAO.buscarPorNome(tfNome.getText());
            this.limparCampos();
            if (professor != null) {
                atualizarTabela("SELECT * FROM Professor o, Endereco e, ContaBancaria cb "
                        + "WHERE o.nome LIKE \"" + professor.getNome() + "%\" AND "
                        + "o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;");

            } else {
                JOptionPane.showMessageDialog(this, "O professor não foi encontrado!", "Informação",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btBuscarPorNomeActionPerformed

    private void btBuscarPorCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarPorCpfActionPerformed
        try {
            professor = professorDAO.buscarPorCpf(tfCpf.getText());
            this.limparCampos();
            if (professor != null) {
                atualizarTabela("SELECT * FROM Professor o, Endereco e, ContaBancaria cb "
                        + "WHERE o.cpf = " + professor.getCpf() + " AND "
                        + "o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;");

            } else {
                JOptionPane.showMessageDialog(this, "O professor não foi encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btBuscarPorCpfActionPerformed

    private void btBuscarPorRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarPorRGActionPerformed
        try {
            professor = professorDAO.buscarPorRg(tfRg.getText());
            this.limparCampos();
            if (professor != null) {
                atualizarTabela("SELECT * FROM Professor o, Endereco e, ContaBancaria cb "
                        + "WHERE o.rg = " + professor.getRg() + " AND "
                        + "o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;");

            } else {
                JOptionPane.showMessageDialog(this, "O professor não foi encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btBuscarPorRGActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.limparCampos();
        this.atualizarTabela("SELECT * FROM Professor o, Endereco e, ContaBancaria cb "
                + "WHERE o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;");
    }//GEN-LAST:event_btCancelarActionPerformed

    public void limparCampos() {
        this.tfNome.setText(null);
        this.tfCpf.setText(null);
        this.tfRg.setText(null);
    }

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
            java.util.logging.Logger.getLogger(DlgConsultarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgConsultarProfessor dialog = new DlgConsultarProfessor(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btBuscarPorCpf;
    private javax.swing.JButton btBuscarPorNome;
    private javax.swing.JButton btBuscarPorRG;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEnviar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCpf;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbRg;
    private javax.swing.JTable tableProfessor;
    private javax.swing.JTextField tfCpf;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfRg;
    // End of variables declaration//GEN-END:variables
}
