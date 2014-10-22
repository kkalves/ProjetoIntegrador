package form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author Giseli e Keyve
 */
public class FrmTelaPrincipal extends javax.swing.JFrame implements ActionListener {

    public FrmTelaPrincipal() {
        setExtendedState(MAXIMIZED_BOTH);
        timer = new Timer(500, this);
        timer.setRepeats(true);
        timer.start();
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.PLAIN, 18)));
        initComponents();
    }
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy   "
            + "HH:mm");
    Timer timer;

    @Override
    public void actionPerformed(ActionEvent ae
    ) {
        if (ae.getSource().equals(timer)) {
            this.lbRelogio.setText(sdf.format(new Date(System.currentTimeMillis())));
            this.lbRelogio.setFont(new Font("Arial", Font.PLAIN, 24));
            this.lbRelogio.setForeground(Color.BLACK);
        }
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
        jLabel1 = new javax.swing.JLabel();
        lbRelogio = new javax.swing.JLabel();
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
        setTitle("SIGCUP - Sistema de Gerenciamento de Curso Profissionalizantes");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204), 2));

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
        btGerenciadoOrientador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerenciadoOrientadorActionPerformed(evt);
            }
        });

        btGerenciadorSupervisor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGerenciadorSupervisor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Supervisor.png"))); // NOI18N
        btGerenciadorSupervisor.setText("Gerenciador De Supervisor");
        btGerenciadorSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerenciadorSupervisorActionPerformed(evt);
            }
        });

        btGerenciadorProfessor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGerenciadorProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Teacher.png"))); // NOI18N
        btGerenciadorProfessor.setText("Gerenciador De Professor");
        btGerenciadorProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerenciadorProfessorActionPerformed(evt);
            }
        });

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logo.png"))); // NOI18N

        lbRelogio.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbRelogio.setText("Relógio");
        lbRelogio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbRelogio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRelogioMouseClicked(evt);
            }
        });

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
        menuItemGerenciadorOrientador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGerenciadorOrientadorActionPerformed(evt);
            }
        });
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
        menuItemGerenciadorProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGerenciadorProfessorActionPerformed(evt);
            }
        });
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbRelogio))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1)))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(lbRelogio)))
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
        DlgGerenciadorSupervisor gerenciadorSupervisor = new DlgGerenciadorSupervisor(this, true);
        gerenciadorSupervisor.setVisible(true);
    }//GEN-LAST:event_menuItemGerenciadorSupervisorActionPerformed

    private void lbRelogioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRelogioMouseClicked
        JOptionPane.showMessageDialog(this, "Nós da empresa TecDOM queremos lhe desejar um maravilhoso dia."
                + "\n\nTecDom - Tecnologia de Dominio");
    }//GEN-LAST:event_lbRelogioMouseClicked

    private void btGerenciadoOrientadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerenciadoOrientadorActionPerformed
        DlgGerenciadorOrientador gerenciadorOrientador = new DlgGerenciadorOrientador(this, true);
        gerenciadorOrientador.setVisible(true);
    }//GEN-LAST:event_btGerenciadoOrientadorActionPerformed

    private void menuItemGerenciadorOrientadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGerenciadorOrientadorActionPerformed
        DlgGerenciadorOrientador gerenciadorOrientador = new DlgGerenciadorOrientador(this, true);
        gerenciadorOrientador.setVisible(true);
    }//GEN-LAST:event_menuItemGerenciadorOrientadorActionPerformed

    private void btGerenciadorSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerenciadorSupervisorActionPerformed
        DlgGerenciadorSupervisor gerenciadorSupervisor = new DlgGerenciadorSupervisor(this, true);
        gerenciadorSupervisor.setVisible(true);
    }//GEN-LAST:event_btGerenciadorSupervisorActionPerformed

    private void menuItemGerenciadorProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGerenciadorProfessorActionPerformed
        DlgGerenciadorProfessor gerenciadorProfessor = new DlgGerenciadorProfessor(this, true);
        gerenciadorProfessor.setVisible(true);
    }//GEN-LAST:event_menuItemGerenciadorProfessorActionPerformed

    private void btGerenciadorProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerenciadorProfessorActionPerformed
        DlgGerenciadorProfessor gerenciadorProfessor = new DlgGerenciadorProfessor(this, true);
        gerenciadorProfessor.setVisible(true);
    }//GEN-LAST:event_btGerenciadorProfessorActionPerformed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Liquid".equals(info.getName())) {
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel lbRelogio;
    private javax.swing.JMenu menuConsultas;
    private javax.swing.JMenu menuGerenciadores;
    private javax.swing.JMenuItem menuItemGerenciadorCurso;
    private javax.swing.JMenuItem menuItemGerenciadorOrientador;
    private javax.swing.JMenuItem menuItemGerenciadorProfessor;
    private javax.swing.JMenuItem menuItemGerenciadorSupervisor;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables

}
