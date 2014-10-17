package form;

import dao.OrientadorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Orientador;
import table.OrientadorCellRenderer;
import table.OrientadorTableModel;

/**
 *
 * @author Giseli E Keyve
 */
public class DlgConsultarOrientador extends javax.swing.JDialog {

    public DlgConsultarOrientador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (listaOrientador != null) {
            atualizarTabela("SELECT idOrientador, nome, cpf, rg, dataEntrada, status "
                    + "FROM Orientador;");
        }
    }
    DlgGerenciadorOrientador janelaOrientador;
    OrientadorDAO orientadorDAO = new OrientadorDAO();
    List<Orientador> listaOrientador = new ArrayList<>();
    
    private void atualizarTabela(String sql) {
        try {
            listaOrientador = orientadorDAO.listarTodos();
            if (listaOrientador != null) {
                tableOrientador.setModel(new OrientadorTableModel(listaOrientador));
                tableOrientador.setDefaultRenderer(Object.class, new OrientadorCellRenderer());
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar clientes na base de dados");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrientador = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        btBuscarPorNome = new javax.swing.JButton();
        btBuscarPorCpf = new javax.swing.JButton();
        btBuscarPorRG = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btEnviar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nome:");

        tableOrientador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tableOrientador.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableOrientador);
        if (tableOrientador.getColumnModel().getColumnCount() > 0) {
            tableOrientador.getColumnModel().getColumn(0).setResizable(false);
            tableOrientador.getColumnModel().getColumn(1).setResizable(false);
            tableOrientador.getColumnModel().getColumn(2).setResizable(false);
            tableOrientador.getColumnModel().getColumn(3).setResizable(false);
            tableOrientador.getColumnModel().getColumn(4).setResizable(false);
            tableOrientador.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("CPF:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("RG:");

        jTextField1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btBuscarPorNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btBuscarPorNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/consultar.png"))); // NOI18N
        btBuscarPorNome.setText("Buscar");
        btBuscarPorNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204), 2));

        btBuscarPorCpf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btBuscarPorCpf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/consultar.png"))); // NOI18N
        btBuscarPorCpf.setText("Buscar");
        btBuscarPorCpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204), 2));

        btBuscarPorRG.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btBuscarPorRG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/consultar.png"))); // NOI18N
        btBuscarPorRG.setText("Buscar");
        btBuscarPorRG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204), 2));

        jPanel1.setLayout(new java.awt.GridLayout());

        btEnviar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Enviar.png"))); // NOI18N
        btEnviar.setText("Enviar");
        jPanel1.add(btEnviar);

        jPanel2.setLayout(new java.awt.GridLayout());

        btVoltar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        btVoltar.setText("Voltar");
        jPanel2.add(btVoltar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btBuscarPorRG, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(btBuscarPorCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btBuscarPorNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarPorNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarPorCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btBuscarPorRG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarOrientador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarOrientador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarOrientador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarOrientador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgConsultarOrientador dialog = new DlgConsultarOrientador(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btEnviar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tableOrientador;
    // End of variables declaration//GEN-END:variables
}
