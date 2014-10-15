package form;

/**
 *
 * @author Giseli e Keyve
 */
public class FrmTelaPrincipal extends javax.swing.JFrame {

    
    public FrmTelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btGerenciadorCurso = new javax.swing.JButton();
        btGerenciadoOrientador = new javax.swing.JButton();
        btGerenciadorSupervisor = new javax.swing.JButton();
        btGerenciadorProfessor = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuGerenciadores = new javax.swing.JMenu();
        menuItemGerenciadorCurso = new javax.swing.JMenuItem();
        menuItemGerenciadorOrientador = new javax.swing.JMenuItem();
        menuItemGerenciadorSupervisor = new javax.swing.JMenuItem();
        menuItemGerenciadorProfessor = new javax.swing.JMenuItem();
        menuConsultas = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btGerenciadorCurso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGerenciadorCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Book.png"))); // NOI18N
        btGerenciadorCurso.setText("Gerenciador De Curso");
        btGerenciadorCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerenciadorCursoActionPerformed(evt);
            }
        });

        btGerenciadoOrientador.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGerenciadoOrientador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Manager.png"))); // NOI18N
        btGerenciadoOrientador.setText("Gerenciador De Orientador");

        btGerenciadorSupervisor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGerenciadorSupervisor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Supervisor.png"))); // NOI18N
        btGerenciadorSupervisor.setText("Gerenciador De Supervisor");

        btGerenciadorProfessor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGerenciadorProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Teacher.png"))); // NOI18N
        btGerenciadorProfessor.setText("Gerenciador De Professor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btGerenciadorCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGerenciadoOrientador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGerenciadorSupervisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGerenciadorProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btGerenciadorCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGerenciadoOrientador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGerenciadorSupervisor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGerenciadorProfessor)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        menuGerenciadores.setText("Gerenciadores");
        menuGerenciadores.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        menuItemGerenciadorCurso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuItemGerenciadorCurso.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuItemGerenciadorCurso.setText("Gerenciador De Curso");
        menuItemGerenciadorCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGerenciadorCursoActionPerformed(evt);
            }
        });
        menuGerenciadores.add(menuItemGerenciadorCurso);

        menuItemGerenciadorOrientador.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuItemGerenciadorOrientador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuItemGerenciadorOrientador.setText("Gerenciador De Orientador");
        menuGerenciadores.add(menuItemGerenciadorOrientador);

        menuItemGerenciadorSupervisor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuItemGerenciadorSupervisor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuItemGerenciadorSupervisor.setText("Gerenciador De Supervisor");
        menuItemGerenciadorSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGerenciadorSupervisorActionPerformed(evt);
            }
        });
        menuGerenciadores.add(menuItemGerenciadorSupervisor);

        menuItemGerenciadorProfessor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        menuItemGerenciadorProfessor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuItemGerenciadorProfessor.setText("Gerenciador De Professor");
        menuGerenciadores.add(menuItemGerenciadorProfessor);

        jMenuBar1.add(menuGerenciadores);

        menuConsultas.setText("Consultas");
        menuConsultas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuBar1.add(menuConsultas);

        menuSair.setText("Sair");
        menuSair.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(784, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btGerenciadorCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerenciadorCursoActionPerformed
        DlgGerenciadorCurso gerenciadorCurso = new DlgGerenciadorCurso(this, true);
        gerenciadorCurso.setVisible(true);
    }//GEN-LAST:event_btGerenciadorCursoActionPerformed

    private void menuItemGerenciadorCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGerenciadorCursoActionPerformed
        DlgGerenciadorCurso gerenciadorCurso = new DlgGerenciadorCurso(this, true);
        gerenciadorCurso.setVisible(true);
    }//GEN-LAST:event_menuItemGerenciadorCursoActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuItemGerenciadorSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGerenciadorSupervisorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemGerenciadorSupervisorActionPerformed

    public static void main(String args[]) {
        
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGerenciadoOrientador;
    private javax.swing.JButton btGerenciadorCurso;
    private javax.swing.JButton btGerenciadorProfessor;
    private javax.swing.JButton btGerenciadorSupervisor;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenu menuConsultas;
    private javax.swing.JMenu menuGerenciadores;
    private javax.swing.JMenuItem menuItemGerenciadorCurso;
    private javax.swing.JMenuItem menuItemGerenciadorOrientador;
    private javax.swing.JMenuItem menuItemGerenciadorProfessor;
    private javax.swing.JMenuItem menuItemGerenciadorSupervisor;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables
}
