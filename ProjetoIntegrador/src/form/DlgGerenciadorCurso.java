/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import dao.CursoDAO;
import java.awt.TextArea;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Curso;

/**
 *
 * @author Família
 */
public class DlgGerenciadorCurso extends javax.swing.JDialog {

    /**
     * Creates new form DlgGerenciadorCurso
     */
    public DlgGerenciadorCurso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.taDescricao.setLineWrap(true);
    }

    private CursoDAO cursoDAO = new CursoDAO();
    private Curso curso;
    List<Curso> cursoList;
    int idCurso;
    private boolean pesquisa;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbEixoTecnologico = new javax.swing.JLabel();
        lbDescricao = new javax.swing.JLabel();
        lbCargaHoraria = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        tfEixoTecnologico = new javax.swing.JTextField();
        tfCargaHoraria = new javax.swing.JTextField();
        lbNome = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        chBStatus = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        btCadastrar = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciador Curso");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbEixoTecnologico.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbEixoTecnologico.setText("Eixo Tecnológico:");

        lbDescricao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbDescricao.setText("Descrição:");

        lbCargaHoraria.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbCargaHoraria.setText("Carga Horária:");

        tfNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        taDescricao.setColumns(20);
        taDescricao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        taDescricao.setRows(5);
        jScrollPane1.setViewportView(taDescricao);

        tfEixoTecnologico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfCargaHoraria.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNome.setText("Nome:");

        lbStatus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbStatus.setText("Status:");

        chBStatus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chBStatus.setText("Inativo");
        chBStatus.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chBStatusStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbEixoTecnologico)
                        .addGap(18, 18, 18)
                        .addComponent(tfEixoTecnologico, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbNome)
                                    .addComponent(lbDescricao)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbCargaHoraria)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                                    .addComponent(tfNome)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(tfCargaHoraria)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbStatus)
                        .addGap(18, 18, 18)
                        .addComponent(chBStatus)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNome)
                    .addComponent(lbStatus)
                    .addComponent(chBStatus))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDescricao))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEixoTecnologico)
                    .addComponent(tfEixoTecnologico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCargaHoraria)
                    .addComponent(tfCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new java.awt.GridLayout());

        btCadastrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Adicionar.png"))); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });
        jPanel2.add(btCadastrar);

        btConsultar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Procurar.png"))); // NOI18N
        btConsultar.setText("Consultar");
        btConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(btConsultar);

        btAlterar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Atualizar.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(btAlterar);

        btExcluir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Excluir.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(btExcluir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chBStatusStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chBStatusStateChanged
        if (this.chBStatus.isSelected()) {
            tratarCampos(false);
        } else {
            tratarCampos(true);
        }
    }//GEN-LAST:event_chBStatusStateChanged

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        try {
            if (Curso == null) {
                curso = new Curso();
                this.getDados();
                if (cursoDAO.cadastrar(curso)) {
                    JOptionPane.showMessageDialog(this, "Curso Inserido com sucesso!");
                    this.limparCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Esse curso já foi cadastrado!",
                            "Cadastro de Curso", JOptionPane.ERROR_MESSAGE);
                    curso = null;
                }
            } else {
                this.getDados();
                cursoDAO.atualizar(curso);
                this.limparCampos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERRO! " + ex.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void getDados() {
        if (!tfNome.getText().isEmpty()) {
            curso.setNome(tfNome.getText());
            curso.setDescricao(taDescricao.getText());
            curso.setEixoTecnologico(tfEixoTecnologico.getText());
            curso.setCargaHoraria(tfCargaHoraria.getText());
            curso.setStatus(chBStatus.isSelected());
        }
    }

    private void setDados() {
        this.tfNome.setText(curso.getNome());
        this.taDescricao.setText(curso.getDescricao());
        this.tfEixoTecnologico.setText(curso.getEixoTecnologico());
        this.tfCargaHoraria.setText(curso.getCargaHoraria());
        this.chBStatus.setSelected(curso.isStatus());
    }

    private void tratarCampos(boolean status) {
        this.tfNome.setEnabled(status);
        this.taDescricao.setEnabled(status);
        this.tfEixoTecnologico.setEnabled(status);
        this.tfCargaHoraria.setEnabled(status);
    }

    private void limparCampos() {
        this.tfNome.setText(null);
        this.taDescricao.setText(null);
        this.tfEixoTecnologico.setText(null);
        this.tfCargaHoraria.setText(null);
        this.chBStatus.setSelected(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DlgGerenciadorCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgGerenciadorCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgGerenciadorCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgGerenciadorCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgGerenciadorCurso dialog = new DlgGerenciadorCurso(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JCheckBox chBStatus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCargaHoraria;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbEixoTecnologico;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextField tfCargaHoraria;
    private javax.swing.JTextField tfEixoTecnologico;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}