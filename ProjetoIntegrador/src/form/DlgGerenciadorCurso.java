package form;

import dao.CursoDAO;
import exceptions.CursoException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Curso;

/**
 *
 * @author Giseli e Keyve
 */
public class DlgGerenciadorCurso extends javax.swing.JDialog {

    public DlgGerenciadorCurso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.taDescricao.setLineWrap(true);
        this.tratarControles(false);
    }
    DlgConsultarCurso telaConsulta = new DlgConsultarCurso(null, true);
    private final CursoDAO cursoDAO = new CursoDAO();
    private Curso curso;
    List<Curso> cursoList;
    int idCurso;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
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
        panelButtons = new javax.swing.JPanel();
        btCadastrar = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciador De Cursos");
        setIconImage(null);

        panelPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Do Curso", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 102, 204))); // NOI18N

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
        chBStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chBStatus.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chBStatusStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbEixoTecnologico)
                        .addGap(18, 18, 18)
                        .addComponent(tfEixoTecnologico, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbNome)
                                    .addComponent(lbDescricao)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbCargaHoraria)))
                        .addGap(18, 18, 18)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNome)
                                    .addComponent(jScrollPane1))
                                .addGap(77, 77, 77)
                                .addComponent(lbStatus)
                                .addGap(18, 18, 18)
                                .addComponent(chBStatus))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(tfCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNome)
                    .addComponent(lbStatus)
                    .addComponent(chBStatus))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDescricao))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEixoTecnologico)
                    .addComponent(tfEixoTecnologico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCargaHoraria)
                    .addComponent(tfCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelButtons.setLayout(new java.awt.GridLayout(1, 0));

        btCadastrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cadastrar.png"))); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });
        panelButtons.add(btCadastrar);

        btConsultar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/consultar.png"))); // NOI18N
        btConsultar.setText("Consultar");
        btConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });
        panelButtons.add(btConsultar);

        btAlterar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/alterar.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAlterar.setEnabled(false);
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        panelButtons.add(btAlterar);

        btExcluir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/remover.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        panelButtons.add(btExcluir);

        btCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        panelButtons.add(btCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            if (curso == null) {
                curso = new Curso();
                this.getDados();
                if (cursoDAO.cadastrar(curso)) {
                    telaConsulta.atualizarTabela("SELECT * FROM Curso c;");
                    JOptionPane.showMessageDialog(this, "Este curso foi cadastrado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Esse curso já foi cadastrado!",
                            "Cadastro de Curso", JOptionPane.ERROR_MESSAGE);
                    curso = null;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERRO! " + ex.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        } catch (CursoException ex) {
            JOptionPane.showMessageDialog(this, "ERRO! " + ex.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        } finally {
            this.limparCampos();
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        if (curso != null) {
            try {
                this.getDados();
                cursoDAO.atualizar(curso);
                telaConsulta.atualizarTabela("SELECT * FROM Curso c;");
                JOptionPane.showMessageDialog(this, "Este curso foi atualizado com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERRO! " + ex.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
            } catch (CursoException ex) {
                JOptionPane.showMessageDialog(this, "ERRO! " + ex.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
            } finally {
                this.limparCampos();
                this.tratarControles(false);
            }
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        this.setVisible(false);
        telaConsulta.setVisible(true);
    }//GEN-LAST:event_btConsultarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (curso != null) {
            try {
                cursoDAO.remover(curso);
                telaConsulta.atualizarTabela("SELECT * FROM Curso c;");
                JOptionPane.showMessageDialog(this, "Este curso foi removido com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERRO! " + ex.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
            } finally {
                this.limparCampos();
                this.tratarControles(false);
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.limparCampos();
        this.tratarControles(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void getDados() throws CursoException {
        curso.setNome(tfNome.getText());
        curso.setDescricao(taDescricao.getText());
        curso.setEixoTecnologico(tfEixoTecnologico.getText());
        curso.setCargaHoraria(tfCargaHoraria.getText());
        curso.setStatus(chBStatus.isSelected());
        validar();
    }
    
    private void validar() throws CursoException{
        if (curso.getNome().isEmpty()) {
            throw new CursoException("O Campo 'Nome' é um campo obrigatório!");
        }else if (curso.getEixoTecnologico().isEmpty()) {
            throw new CursoException("O Campo 'Eixo Técnológico' é um campo obrigatório!");
        }else if (curso.getCargaHoraria().isEmpty()) {
            throw new CursoException("O Campo 'Carga Horária' é um campo obrigatório!");
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

    private void tratarControles(boolean status) {
        this.btCadastrar.setEnabled(!status);
        this.btAlterar.setEnabled(status);
        this.btExcluir.setEnabled(status);
    }

    private void limparCampos() {
        this.tfNome.setText(null);
        this.taDescricao.setText(null);
        this.tfEixoTecnologico.setText(null);
        this.tfCargaHoraria.setText(null);
        this.chBStatus.setSelected(false);
    }

    public void recuperarDadosAlterarCurso(int idCurso) {
        try {
            curso = new CursoDAO().buscarPorId(idCurso);
            this.tfNome.setText(curso.getNome());
            this.taDescricao.setText(curso.getDescricao());
            this.tfEixoTecnologico.setText(curso.getEixoTecnologico());
            this.tfCargaHoraria.setText(curso.getCargaHoraria());
            this.chBStatus.setSelected(curso.isStatus());
            this.tratarControles(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERRO! " + ex.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgGerenciadorCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            @Override
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
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JCheckBox chBStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCargaHoraria;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbEixoTecnologico;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextField tfCargaHoraria;
    private javax.swing.JTextField tfEixoTecnologico;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
