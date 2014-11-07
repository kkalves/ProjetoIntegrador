package form;

import dao.AlunoDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.Aluno;
import model.ContaBancaria;
import model.Endereco;

/**
 *
 * @author Giseli e Keyve
 */
public class DlgGerenciadorAluno extends javax.swing.JDialog {

    public DlgGerenciadorAluno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.taObservacao.setLineWrap(true);
    }

    DlgConsultarAluno janelaConsulta = new DlgConsultarAluno(null, true);
    private final AlunoDAO alunoDAO = new AlunoDAO();
    private Aluno aluno;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupEscolaridade = new javax.swing.ButtonGroup();
        panelGeral = new javax.swing.JPanel();
        lbSituação = new javax.swing.JLabel();
        panelDadosBancarios = new javax.swing.JPanel();
        lbNomeBanco = new javax.swing.JLabel();
        tfNomeBanco = new javax.swing.JTextField();
        lbAgencia = new javax.swing.JLabel();
        tfAgencia = new javax.swing.JTextField();
        lbNumeroConta = new javax.swing.JLabel();
        tfNumeroConta = new javax.swing.JTextField();
        panelEndereco = new javax.swing.JPanel();
        lbRua = new javax.swing.JLabel();
        tfRua = new javax.swing.JTextField();
        lbBairro = new javax.swing.JLabel();
        tfBairro = new javax.swing.JTextField();
        lbNumero = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        lbEstado = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        lbCidade = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        panelDadosPessoais = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        lbCpf = new javax.swing.JLabel();
        ftfCpf = new javax.swing.JFormattedTextField();
        lbRg = new javax.swing.JLabel();
        tfRg = new javax.swing.JTextField();
        lbDataNascimento = new javax.swing.JLabel();
        dtcDataNascimento = new com.toedter.calendar.JDateChooser();
        lbSexo = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox();
        lbEscolaridade = new javax.swing.JLabel();
        cbEscolaridade = new javax.swing.JComboBox();
        lbProfissão = new javax.swing.JLabel();
        tfProfissao = new javax.swing.JTextField();
        lbTelefone = new javax.swing.JLabel();
        ftfTelefone = new javax.swing.JFormattedTextField();
        lbEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        cbSituacao = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        panelBotao = new javax.swing.JPanel();
        btCadastrar = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        taObservacao = new javax.swing.JTextArea();
        panelControles = new javax.swing.JPanel();
        panelNavegacao = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciador de Aluno");

        panelGeral.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Aluno", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 102, 204))); // NOI18N

        lbSituação.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbSituação.setText("Situação:");

        panelDadosBancarios.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Bancarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 102, 255))); // NOI18N

        lbNomeBanco.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNomeBanco.setText("Banco:");

        lbAgencia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbAgencia.setText("Agencia:");

        lbNumeroConta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNumeroConta.setText("Conta:");

        javax.swing.GroupLayout panelDadosBancariosLayout = new javax.swing.GroupLayout(panelDadosBancarios);
        panelDadosBancarios.setLayout(panelDadosBancariosLayout);
        panelDadosBancariosLayout.setHorizontalGroup(
            panelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosBancariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbNomeBanco)
                    .addComponent(lbAgencia))
                .addGap(18, 18, 18)
                .addGroup(panelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosBancariosLayout.createSequentialGroup()
                        .addComponent(tfAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbNumeroConta)
                        .addGap(18, 18, 18)
                        .addComponent(tfNumeroConta, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                    .addComponent(tfNomeBanco))
                .addContainerGap())
        );
        panelDadosBancariosLayout.setVerticalGroup(
            panelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosBancariosLayout.createSequentialGroup()
                .addGroup(panelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNomeBanco)
                    .addComponent(tfNomeBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAgencia)
                    .addComponent(tfAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNumeroConta)
                    .addComponent(tfNumeroConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereco", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 102, 255))); // NOI18N

        lbRua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbRua.setText("Rua:");

        tfRua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbBairro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbBairro.setText("Bairro:");

        tfBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbNumero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNumero.setText("Numero:");

        tfNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbEstado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbEstado.setText("Estado:");

        cbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Goiás", "Espírito Santo", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraiba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Rorâima", "São Paulo", "Santa Catarina", "Sergipe", "Tocantins" }));
        cbEstado.setSelectedIndex(-1);

        lbCidade.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbCidade.setText("Cidade:");

        tfCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelEnderecoLayout = new javax.swing.GroupLayout(panelEndereco);
        panelEndereco.setLayout(panelEnderecoLayout);
        panelEnderecoLayout.setHorizontalGroup(
            panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbRua)
                    .addComponent(lbBairro)
                    .addComponent(lbEstado))
                .addGap(18, 18, 18)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEnderecoLayout.createSequentialGroup()
                        .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbNumero)
                        .addGap(18, 18, 18)
                        .addComponent(tfNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                    .addComponent(tfRua)
                    .addGroup(panelEnderecoLayout.createSequentialGroup()
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbCidade)
                        .addGap(18, 18, 18)
                        .addComponent(tfCidade)))
                .addContainerGap())
        );
        panelEnderecoLayout.setVerticalGroup(
            panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnderecoLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRua)
                    .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBairro)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNumero)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEstado)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCidade)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNome.setText("Nome:");

        tfNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbCpf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbCpf.setText("CPF:");

        try {
            ftfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCpf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbRg.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbRg.setText("RG:");

        tfRg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbDataNascimento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbDataNascimento.setText("Data de Nascimento:");

        dtcDataNascimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbSexo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbSexo.setText("Sexo:");

        cbSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
        cbSexo.setSelectedIndex(-1);

        lbEscolaridade.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbEscolaridade.setText("Escolaridade:");

        cbEscolaridade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbEscolaridade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não sabe ler nem escrever", "Ensino fundamental incompleto", "Ensino fundamental completo", "Ensino médio incompleto", "Ensino médio completo", "Ensino superior incompleto", "Ensino superior completo", "Pós-graduação" }));
        cbEscolaridade.setSelectedIndex(-1);

        lbProfissão.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbProfissão.setText("Profissão:");

        tfProfissao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbTelefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbTelefone.setText("Telefone:");

        try {
            ftfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfTelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbEmail.setText("E-mail:");

        tfEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelDadosPessoaisLayout = new javax.swing.GroupLayout(panelDadosPessoais);
        panelDadosPessoais.setLayout(panelDadosPessoaisLayout);
        panelDadosPessoaisLayout.setHorizontalGroup(
            panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbEmail)
                    .addComponent(lbRg)
                    .addComponent(lbDataNascimento)
                    .addComponent(lbCpf)
                    .addComponent(lbNome)
                    .addComponent(lbSexo)
                    .addComponent(lbEscolaridade)
                    .addComponent(lbProfissão)
                    .addComponent(lbTelefone))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ftfCpf)
                    .addComponent(tfNome)
                    .addComponent(dtcDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbEscolaridade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfProfissao)
                    .addComponent(ftfTelefone)
                    .addComponent(tfRg)
                    .addComponent(tfEmail)))
        );
        panelDadosPessoaisLayout.setVerticalGroup(
            panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNome)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCpf)
                            .addComponent(ftfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbRg)
                            .addComponent(tfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lbDataNascimento))
                    .addComponent(dtcDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSexo)
                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEscolaridade)
                    .addComponent(cbEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProfissão)
                    .addComponent(tfProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTelefone)
                    .addComponent(ftfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmail)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDadosPessoaisLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbCpf, lbDataNascimento, lbEmail, lbEscolaridade, lbNome, lbProfissão, lbRg, lbSexo, lbTelefone});

        cbSituacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Em curso", "Cancelado", "Apto", "Não apto" }));
        cbSituacao.setSelectedIndex(-1);
        cbSituacao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSituacaoItemStateChanged(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        panelBotao.setLayout(new java.awt.GridLayout(1, 0));

        btCadastrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cadastrar.png"))); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });
        panelBotao.add(btCadastrar);

        btConsultar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Consultar.png"))); // NOI18N
        btConsultar.setText("Consultar");
        panelBotao.add(btConsultar);

        btAlterar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Alterar.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setEnabled(false);
        panelBotao.add(btAlterar);

        btExcluir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Remover.png"))); // NOI18N
        btExcluir.setText("Excluir ");
        btExcluir.setEnabled(false);
        panelBotao.add(btExcluir);

        btCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        panelBotao.add(btCancelar);

        taObservacao.setColumns(20);
        taObservacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        taObservacao.setRows(5);
        taObservacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observacoes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 102, 255))); // NOI18N
        jScrollPane3.setViewportView(taObservacao);

        javax.swing.GroupLayout panelGeralLayout = new javax.swing.GroupLayout(panelGeral);
        panelGeral.setLayout(panelGeralLayout);
        panelGeralLayout.setHorizontalGroup(
            panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeralLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelGeralLayout.createSequentialGroup()
                            .addComponent(panelDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panelDadosBancarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeralLayout.createSequentialGroup()
                                        .addComponent(lbSituação)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(panelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(panelBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelGeralLayout.setVerticalGroup(
            panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeralLayout.createSequentialGroup()
                .addGroup(panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelGeralLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSituação)
                            .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(panelDadosBancarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(panelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelControles.setLayout(new java.awt.GridLayout(1, 0));

        panelNavegacao.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelNavegacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbSituacaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSituacaoItemStateChanged
        if (this.cbSituacao.getSelectedItem().equals("Cancelado")) {
            tratarCampos(false);
        } else {
            tratarCampos(true);
        }
    }//GEN-LAST:event_cbSituacaoItemStateChanged

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        try {
            if (aluno == null) {
                aluno = new Aluno();
                this.getDados();
                if (alunoDAO.cadastrar(aluno)) {
                    janelaConsulta.atualizarTabela("SELECT * FROM Aluno o, Endereco e, ContaBancaria cb "
                    + "WHERE o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;");
                    JOptionPane.showMessageDialog(this, "Este aluno foi inserido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Já existe aluno cadastrado!",
                            "Cadastro de  Aluno", JOptionPane.ERROR_MESSAGE);
                    aluno = null;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERRO: " + ex.getMessage());
        } catch (ParseException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "ERRO!: " + ex.getMessage());
        } finally {
            this.limparCampos();
        }
    }//GEN-LAST:event_btCadastrarActionPerformed
    
    private void setDados() {
        MaskFormatter mf = null;
        this.tfNome.setText(aluno.getNome());
        this.cbSituacao.setSelectedItem(aluno.getSituacao());
        try {
            mf = new MaskFormatter("###.###.###-##");
        } catch (ParseException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
        mf.setPlaceholder(aluno.getCpf());
        this.ftfCpf.setText(new DefaultFormatterFactory(mf).toString());
        this.tfRg.setText(aluno.getRg());
        this.cbEscolaridade.setSelectedItem(aluno.getEscolaridade());
        this.dtcDataNascimento.setDateFormatString(df.format(aluno.getDataNascimento()));
        try {
            mf = new MaskFormatter("(##)####-####");
        } catch (ParseException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
        mf.setPlaceholder(aluno.getTelefone());
        this.ftfTelefone.setText(new DefaultFormatterFactory(mf).toString());
        this.tfEmail.setText(aluno.getEmail());
        this.cbEstado.setSelectedItem(aluno.getEndereco().getEstado());
        this.tfCidade.setText(aluno.getEndereco().getCidade());
        this.tfBairro.setText(aluno.getEndereco().getBairro());
        this.tfRua.setText(aluno.getEndereco().getRua());
        this.tfNumero.setText(Long.toString(aluno.getEndereco().getNumero()));
        this.tfNomeBanco.setText(aluno.getContaBancaria().getNomeBanco());
        this.tfAgencia.setText(Integer.toString(aluno.getContaBancaria().getAgencia()));
        this.tfNumeroConta.setText(Integer.toString(aluno.getContaBancaria().getNumeroConta()));

    }
    
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    private void getDados() throws ParseException {
        if (!tfNome.getText().isEmpty()) {
            aluno.setNome(tfNome.getText());
            if (aluno.isCPF(this.ftfCpf.getText())) {
                aluno.setCpf(ftfCpf.getText());
            } else {
                throw new IllegalArgumentException("CPF Inválido");
            }
            aluno.setRg(tfRg.getText());
            aluno.setTelefone(ftfTelefone.getText());
            aluno.setEmail(tfEmail.getText());
            aluno.setEscolaridade(cbEscolaridade.getSelectedItem().toString());
            aluno.setDataNascimento(dtcDataNascimento.getDate());
            aluno.setObservacoes(taObservacao.getText());
            aluno.setSituacao(cbSituacao.getSelectedItem().toString());
            aluno.setEndereco(
                    new Endereco(
                            tfRua.getText(),
                            Integer.parseInt(tfNumero.getText()),
                            tfBairro.getText(),
                            cbEstado.getSelectedItem().toString(),
                            tfCidade.getText()
                    )
            );
            aluno.setContaBancaria(
                    new ContaBancaria(
                            tfNomeBanco.getText(),
                            Integer.parseInt(tfAgencia.getText()),
                            Integer.parseInt(tfNumeroConta.getText())
                    )
            );
        }
    }
    
private void tratarCampos(boolean status) {
        this.tfNome.setEnabled(status);
        this.ftfCpf.setEnabled(status);
        this.tfRg.setEnabled(status);
        this.dtcDataNascimento.setEnabled(status);
        this.cbSexo.setEnabled(status);
        this.cbEscolaridade.setEnabled(status);
        this.tfProfissao.setEnabled(status);
        this.ftfTelefone.setEnabled(status);
        this.tfEmail.setEnabled(status);
        this.tfNomeBanco.setEnabled(status);
        this.tfAgencia.setEnabled(status);
        this.tfNumeroConta.setEnabled(status);
        this.tfRua.setEnabled(status);
        this.tfNumero.setEnabled(status);
        this.tfBairro.setEnabled(status);
        this.tfCidade.setEnabled(status);
        this.cbEstado.setEnabled(status);
        this.taObservacao.setEnabled(status);
    }

private void limparCampos(){
    this.tfNome.setText(null);
        this.ftfCpf.setText(null);
        this.tfRg.setText(null);
        this.dtcDataNascimento.setDate(null);
        this.cbSexo.setSelectedIndex(-1);
        this.cbEscolaridade.setSelectedIndex(-1);
        this.tfProfissao.setText(null);
        this.ftfTelefone.setText(null);
        this.tfEmail.setText(null);
        this.tfNomeBanco.setText(null);
        this.tfAgencia.setText(null);
        this.tfNumeroConta.setText(null);
        this.tfRua.setText(null);
        this.tfNumero.setText(null);
        this.tfBairro.setText(null);
        this.tfCidade.setText(null);
        this.cbEstado.setSelectedIndex(-1);
        this.taObservacao.setText(null);
}

private void tratarControles(boolean status) {
        this.btCadastrar.setEnabled(!status);
        this.btAlterar.setEnabled(status);
        this.btExcluir.setEnabled(status);
    }

 public void recuperarDadosAlterarAluno(int idAluno) {
        try {
            aluno = alunoDAO.buscarPorId(idAluno);
            this.setDados();
            this.tratarControles(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

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
            java.util.logging.Logger.getLogger(DlgGerenciadorAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                 DlgGerenciadorAluno dialog = new DlgGerenciadorAluno(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup buttonGroupEscolaridade;
    private javax.swing.JComboBox cbEscolaridade;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JComboBox cbSexo;
    private javax.swing.JComboBox cbSituacao;
    private com.toedter.calendar.JDateChooser dtcDataNascimento;
    private javax.swing.JFormattedTextField ftfCpf;
    private javax.swing.JFormattedTextField ftfTelefone;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbAgencia;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbCidade;
    private javax.swing.JLabel lbCpf;
    private javax.swing.JLabel lbDataNascimento;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEscolaridade;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNomeBanco;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbNumeroConta;
    private javax.swing.JLabel lbProfissão;
    private javax.swing.JLabel lbRg;
    private javax.swing.JLabel lbRua;
    private javax.swing.JLabel lbSexo;
    private javax.swing.JLabel lbSituação;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JPanel panelBotao;
    private javax.swing.JPanel panelControles;
    private javax.swing.JPanel panelDadosBancarios;
    private javax.swing.JPanel panelDadosPessoais;
    private javax.swing.JPanel panelEndereco;
    private javax.swing.JPanel panelGeral;
    private javax.swing.JPanel panelNavegacao;
    private javax.swing.JTextArea taObservacao;
    private javax.swing.JTextField tfAgencia;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNomeBanco;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfNumeroConta;
    private javax.swing.JTextField tfProfissao;
    private javax.swing.JTextField tfRg;
    private javax.swing.JTextField tfRua;
    // End of variables declaration//GEN-END:variables

}
