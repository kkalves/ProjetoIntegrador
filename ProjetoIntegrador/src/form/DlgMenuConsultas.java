/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package form;

/**
 *
 * @author Aluno
 */
public class DlgMenuConsultas extends javax.swing.JDialog {

    /**
     * Creates new form DlgMenuConsultas
     * @param parent
     * @param modal
     */
    public DlgMenuConsultas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btConsultarCurso = new javax.swing.JButton();
        btConsultarOrientador = new javax.swing.JButton();
        btConsultarSupervisor = new javax.swing.JButton();
        btConsultarProfessor = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lbLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu De Consultas");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204), 2));

        btConsultarCurso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btConsultarCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Curso.png"))); // NOI18N
        btConsultarCurso.setText("Consultar Curso");
        btConsultarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarCursoActionPerformed(evt);
            }
        });

        btConsultarOrientador.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btConsultarOrientador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Orientador.png"))); // NOI18N
        btConsultarOrientador.setText("Consultar Orientador");
        btConsultarOrientador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarOrientadorActionPerformed(evt);
            }
        });

        btConsultarSupervisor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btConsultarSupervisor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Supervisor.png"))); // NOI18N
        btConsultarSupervisor.setText("Consultar Supervisor");
        btConsultarSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarSupervisorActionPerformed(evt);
            }
        });

        btConsultarProfessor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btConsultarProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Professor.png"))); // NOI18N
        btConsultarProfessor.setText("Consultar Professor");
        btConsultarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarProfessorActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/aluno.png"))); // NOI18N
        jButton1.setText("Consultar Aluno");

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Turma.png"))); // NOI18N
        jButton2.setText("Consultar Turma");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btConsultarCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btConsultarOrientador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btConsultarSupervisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btConsultarProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btConsultarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btConsultarOrientador)
                .addGap(18, 18, 18)
                .addComponent(btConsultarSupervisor)
                .addGap(18, 18, 18)
                .addComponent(btConsultarProfessor)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btConsultarCurso, btConsultarOrientador, btConsultarProfessor, btConsultarSupervisor, jButton1});

        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/LogoIfsc.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btConsultarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarCursoActionPerformed
        this.setVisible(false);
        DlgConsultarCurso telaConsulta = new DlgConsultarCurso(null, true);
        telaConsulta.setVisible(true);
    }//GEN-LAST:event_btConsultarCursoActionPerformed

    private void btConsultarOrientadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarOrientadorActionPerformed
        this.setVisible(false);
        DlgConsultarOrientador telaConsulta = new DlgConsultarOrientador(null, true);
        telaConsulta.setVisible(true);
    }//GEN-LAST:event_btConsultarOrientadorActionPerformed

    private void btConsultarSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarSupervisorActionPerformed
        this.setVisible(false);
        DlgConsultarSupervisor telaConsulta = new DlgConsultarSupervisor(null, true);
        telaConsulta.setVisible(true);
    }//GEN-LAST:event_btConsultarSupervisorActionPerformed

    private void btConsultarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarProfessorActionPerformed
        this.setVisible(false);
        DlgConsultarProfessor telaConsulta = new DlgConsultarProfessor(null, true);
        telaConsulta.setVisible(true);
    }//GEN-LAST:event_btConsultarProfessorActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgMenuConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DlgMenuConsultas dialog = new DlgMenuConsultas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btConsultarCurso;
    private javax.swing.JButton btConsultarOrientador;
    private javax.swing.JButton btConsultarProfessor;
    private javax.swing.JButton btConsultarSupervisor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbLogo;
    // End of variables declaration//GEN-END:variables
}
