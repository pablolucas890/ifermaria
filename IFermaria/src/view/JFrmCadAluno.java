package view;

//importações
import java.awt.Color;
import model.Aluno;
import model.Curso;
import model.CopiaDiretorio;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.beans.Beans;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.RollbackException;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import model.Atendente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.Conexao;
import util.Sessao;
import util.Tabelas;

public class JFrmCadAluno extends JPanel {

    boolean checagemObrigatoria = true, checagem_nao_Obrigatoria = true, novo = false;
    private JFrame jf;

    String mensagemErro = "", mensagemErro_nao_Obrigatoria = "";
    BufferedImage biUser = new BufferedImage(151, 183, BufferedImage.TYPE_INT_RGB);
    Atendente at;

    public JFrmCadAluno(JFrame jframe, Atendente at) {
        Connection conn;
        conn = Conexao.getConnection();
        System.out.println("Aluno criado");
        this.jf = jframe;
        this.at = at;
        jf.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {
                //método que executa ao fechar a janela
                int cont = JOptionPane.showConfirmDialog(null, "DESEJA FAZER BACKUP DAS FOTOS?", "ATENÇÃO!!", JOptionPane.YES_NO_OPTION);
                if (cont == JOptionPane.YES_OPTION) {
                    File pastaOrigem = new File("C:/Users/Public/Documents/IFermaria/fotos");//caminho
                    if (pastaOrigem.exists()) {//pasta fotos existe
                        JFileChooser fc = new JFileChooser();//tela de selecionamento
                        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//apenas diretórios
                        fc.setApproveButtonText("SELECIONAR PASTA");
                        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                            try {//salva no local desejado
                                String path = fc.getSelectedFile().getAbsolutePath() + "/fotos";
                                File pastaDestino = new File(path);
                                CopiaDiretorio.copyAll(pastaOrigem, pastaDestino, true);
                                JOptionPane.showMessageDialog(null, "Cópia realiada com sucesso!");
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "ERRO !!!", "ERRO!!", JOptionPane.ERROR_MESSAGE);
                                new Sessao(at);
                                util.Logger.log(Sessao.getAtendenteLogado(), null, "SAIU", Tabelas.ALUNO);
                                jf.dispose();
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "ERRO AO ENCONTRAR A PASTA fotos, FAÇA BACKUP MANUALMENTE!!!");
                    }
                } else {
                    jf.dispose();
                    new Sessao(at);
                    util.Logger.log(Sessao.getAtendenteLogado(), null, "SAIU", Tabelas.ALUNO);
                }
            }
        }
        );
        initComponents();
        jf.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/inicial.png")));
        jTextField3.setEnabled(false);
        idAlunoField.setVisible(false);
        jComboBox1.setSelectedIndex(-1);
        saveButton.setEnabled(false);
        tabela.setSelectionMode(0);
        jCheckBox1.setSelected(false);
        editableFalse();
        setUser();
        butFalse();

        System.out.println("Iniciando transacao");
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
        System.out.println("transacao aberta");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("IFermariaPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT a FROM Aluno a order by a.nome").setMaxResults(29);
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        cursoQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Curso c order by c.nome");
        cursoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(cursoQuery.getResultList());
        salaQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT s FROM Sala s order by s.sala");
        salaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(salaQuery.getResultList());
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        idAlunoField = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        nomeResponsavelField = new javax.swing.JTextField();
        telefoneResponsavelLabel = new javax.swing.JLabel();
        nomeResponsavelLabel = new javax.swing.JLabel();
        telefoneResponsavelField = new javax.swing.JTextField();
        nomeResponsavelField1 = new javax.swing.JTextField();
        nomeResponsavelLabel1 = new javax.swing.JLabel();
        telefoneResponsavelLabel2 = new javax.swing.JLabel();
        telefoneResponsavelField2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        fotoLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cursoLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        periodoLabel = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        nomeLabel = new javax.swing.JLabel();
        alergiasLabel = new javax.swing.JLabel();
        medusoContinuoLabel = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        medusoContinuoLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        periodoLabel1 = new javax.swing.JLabel();
        dataNascLabel = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        telefoneAlunoLabel = new javax.swing.JLabel();
        telefoneAlunoField = new javax.swing.JTextField();
        cartaoSUSLabel1 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        cartaoSUSLabel = new javax.swing.JLabel();
        cartaoSUSField = new javax.swing.JTextField();
        cartaoSUSLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        cartaoSUSLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        telefoneAlunoField1 = new javax.swing.JTextField();
        telefoneAlunoLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton8 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setBackground(new java.awt.Color(204, 204, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setMinimumSize(new java.awt.Dimension(800, 600));

        jPanel2.setBackground(new java.awt.Color(96, 202, 164));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(96, 202, 164));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ifermeiras.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel3.setText("IFERMARIA");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(12, 12, 12))
        );

        jPanel7.setBackground(new java.awt.Color(96, 202, 164));

        saveButton.setBackground(new java.awt.Color(255, 255, 255));
        saveButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_multimedia-27_809537.png"))); // NOI18N
        saveButton.setText("     SALVAR     ");
        saveButton.setToolTipText("SALVAR CADASTRO/ MODIFICAÇÕES DA PESSOA SELECIONADA");
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        saveButton.addActionListener(formListener);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_cross_1_458267.png"))); // NOI18N
        jButton1.setText("ATENDIMENTO");
        jButton1.setToolTipText("ATENDER PESSOA SELECIONADA");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(formListener);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_Document_928418.png"))); // NOI18N
        jButton3.setText("HISTÓRICO");
        jButton3.setToolTipText("RELATÓRIO DE ATENDIMENTOS DA PESSOA SELECIONADA");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.addActionListener(formListener);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_archive2_1936911.png"))); // NOI18N
        jButton2.setText("     ESTOQUE   ");
        jButton2.setToolTipText("ABRIR JANELA DE ESTOQUE");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addActionListener(formListener);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_create_326602.png"))); // NOI18N
        jButton4.setText("     EDITAR      ");
        jButton4.setToolTipText("EDITAR DADOS DA PESSOA SELECIONADA");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.addActionListener(formListener);

        newButton.setBackground(new java.awt.Color(255, 255, 255));
        newButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_new-24_103173.png"))); // NOI18N
        newButton.setText("       NOVO       ");
        newButton.setToolTipText("NOVO CADASTRO DE PESSOA");
        newButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        newButton.addActionListener(formListener);

        refreshButton.setBackground(new java.awt.Color(255, 255, 255));
        refreshButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_home_298794.png"))); // NOI18N
        refreshButton.setText("        HOME      ");
        refreshButton.setToolTipText("INICIO");
        refreshButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        refreshButton.addActionListener(formListener);

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_Document_928418.png"))); // NOI18N
        jButton10.setText("RELATÓRIOS");
        jButton10.setToolTipText("ABRIR GERENCIADO DE RELATÓRIOS DE CONTROLE");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton10.addActionListener(formListener);

        idAlunoField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idAlunoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(newButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addGap(71, 71, 71)
                .addComponent(idAlunoField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton4, newButton, refreshButton, saveButton});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTabbedPane1.addChangeListener(formListener);
        jTabbedPane1.addKeyListener(formListener);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel2.setText("DIGITE O NOME DA PESSOA:");

        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField1.setToolTipText("DIGITE O NOME DA PESSOA");
        jTextField1.addFocusListener(formListener);
        jTextField1.addKeyListener(formListener);

        tabela.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, tabela);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${sala.sala} ${curso.nome}"));
        columnBinding.setColumnName("Curso");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dataNasc}"));
        columnBinding.setColumnName("Data Nasc");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        tabela.addMouseListener(formListener);
        tabela.addKeyListener(formListener);
        jScrollPane4.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setPreferredWidth(220);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(220);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("PESQUISA", jPanel3);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "RESPONSAVEL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        nomeResponsavelField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        nomeResponsavelField.setToolTipText("DIGITE O NOME DO PAI");
        nomeResponsavelField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nomePai}"), nomeResponsavelField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("");
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        nomeResponsavelField.addKeyListener(formListener);

        telefoneResponsavelLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        telefoneResponsavelLabel.setText("Telefone (Pai):");

        nomeResponsavelLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        nomeResponsavelLabel.setText("Nome Responsavel 1 (Pai):");

        telefoneResponsavelField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        telefoneResponsavelField.setToolTipText("DIGITE O TELEFONE DO PAI");
        telefoneResponsavelField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.telefonePai}"), telefoneResponsavelField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("");
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        telefoneResponsavelField.addKeyListener(formListener);

        nomeResponsavelField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        nomeResponsavelField1.setToolTipText("DIGITE O NOME DA MÃE");
        nomeResponsavelField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nomeMae}"), nomeResponsavelField1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("");
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        nomeResponsavelField1.addKeyListener(formListener);

        nomeResponsavelLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        nomeResponsavelLabel1.setText("Nome Responsavel 2 (Mãe):");

        telefoneResponsavelLabel2.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        telefoneResponsavelLabel2.setText("Telefone (Mãe):");

        telefoneResponsavelField2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        telefoneResponsavelField2.setToolTipText("DIGITE O TELEFONE DA MÃE");
        telefoneResponsavelField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.telefoneMae}"), telefoneResponsavelField2, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("");
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        telefoneResponsavelField2.addKeyListener(formListener);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeResponsavelField1)
                    .addComponent(nomeResponsavelField)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeResponsavelLabel)
                            .addComponent(nomeResponsavelLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(telefoneResponsavelLabel)
                    .addComponent(telefoneResponsavelLabel2)
                    .addComponent(telefoneResponsavelField, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(telefoneResponsavelField2))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeResponsavelLabel)
                    .addComponent(telefoneResponsavelLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeResponsavelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefoneResponsavelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(nomeResponsavelLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeResponsavelField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(telefoneResponsavelLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telefoneResponsavelField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "PACIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        fotoLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        fotoLabel.setText("Foto:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/user.png"))); // NOI18N
        jLabel1.setToolTipText("CLIQUE DUAS VEZES PARA ADICIONAR UMA IMAGEM JÁ SALVA NO COMPUTADOR");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jLabel1, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel1.addMouseListener(formListener);

        cursoLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        cursoLabel.setText("Curso:");

        jComboBox1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jComboBox1.setToolTipText("SELECIONE O CURSO DO ALUNO");
        jComboBox1.setOpaque(false);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cursoList, jComboBox1);
        jComboBoxBinding.setSourceNullValue(null);
        jComboBoxBinding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.curso}"), jComboBox1, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox1.addItemListener(formListener);
        jComboBox1.addMouseListener(formListener);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setToolTipText("DIGITE NESTE CAMPO APENAS SE A PESSOA CONSUMIR MEDICAMENTOS CONTINUAMENTE");
        jTextArea2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.medusoContinuo}"), jTextArea2, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("");
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(jTextArea2);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 0, 0));
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("DIGITE NESTE CAMPO APENAS SE A PESSOA TIVER ALERGIAS");
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.alergias}"), jTextArea1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("");
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(jTextArea1);

        periodoLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        periodoLabel.setText("Período:");

        nomeField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        nomeField.setToolTipText("DIGITE O NOME");
        nomeField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), nomeField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("");
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        nomeField.addKeyListener(formListener);

        nomeLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        nomeLabel.setText("Nome:");

        alergiasLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        alergiasLabel.setText("Alergias:");

        medusoContinuoLabel.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        medusoContinuoLabel.setText("Medicamentos de uso Continuo:");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_199_CircledPlus_183316 (1).png"))); // NOI18N
        jButton5.addActionListener(formListener);

        jComboBox2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jComboBox2.setToolTipText("SELECIONE O PERÍODO QUE O ALUNO ESTÁ");

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, salaList, jComboBox2);
        jComboBoxBinding.setSourceNullValue(null);
        jComboBoxBinding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.sala}"), jComboBox2, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        binding.setSourceNullValue(null);
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);

        jComboBox2.addMouseListener(formListener);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_199_CircledPlus_183316 (1).png"))); // NOI18N
        jButton6.addActionListener(formListener);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_32_111002.png"))); // NOI18N
        jButton9.setToolTipText("TIRAR FOTO");
        jButton9.addActionListener(formListener);

        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextArea3.setRows(5);
        jTextArea3.setToolTipText("DIGITE NESTE CAMPO APENAS SE A PESSOA TIVER ALGUMA DOENÇA");
        jTextArea3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.doencas}"), jTextArea3, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("");
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        jScrollPane3.setViewportView(jTextArea3);

        medusoContinuoLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        medusoContinuoLabel1.setText("Doenças:");

        jTextField2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField2.setToolTipText("DIGITE O ANO DE CADASTRO OU DE ATUALIZAÇÃO DA PESSOA");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.ano}"), jTextField2, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("");
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        jTextField2.addKeyListener(formListener);

        periodoLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        periodoLabel1.setText("Ano de Cadastro:");

        dataNascLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        dataNascLabel.setText("Data Nasc:");

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1.setToolTipText("DIGITE A DATA DE NASCIMENTO");
        jFormattedTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jFormattedTextField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        telefoneAlunoLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        telefoneAlunoLabel.setText("Telefone:");

        telefoneAlunoField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        telefoneAlunoField.setToolTipText("DIGITE O TELEFONE DA PESSOA");
        telefoneAlunoField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.telefoneAluno}"), telefoneAlunoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("");
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        telefoneAlunoField.addKeyListener(formListener);

        cartaoSUSLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        cartaoSUSLabel1.setText("Cpf:");

        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField2.setToolTipText("DIGITE O CPF DA PESSOA");
        jFormattedTextField2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.cpf}"), jFormattedTextField2, org.jdesktop.beansbinding.BeanProperty.create("value"));
        binding.setSourceNullValue(null);
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);

        cartaoSUSLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        cartaoSUSLabel.setText("Cartao SUS:");

        cartaoSUSField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cartaoSUSField.setToolTipText("DIGITE O CARTÃO DO SUS");
        cartaoSUSField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.cartaoSUS}"), cartaoSUSField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("");
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        cartaoSUSField.addKeyListener(formListener);

        cartaoSUSLabel2.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        cartaoSUSLabel2.setText("Tipo");

        jComboBox3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aluno", "Professor", "Funcionario" }));
        jComboBox3.setSelectedIndex(-1);
        jComboBox3.setToolTipText("SELECIONE O TIPO");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.tipo}"), jComboBox3, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox3.addItemListener(formListener);

        cartaoSUSLabel3.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField3.setToolTipText("DIGITE A ÁREA QUE O PROFESSOR/ FUNCIONARIO ATUA NA ESCOLA");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.area}"), jTextField3, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("");
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        telefoneAlunoField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        telefoneAlunoField1.setToolTipText("DIGITE O TELEFONE DA PESSOA");
        telefoneAlunoField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.procedencia}"), telefoneAlunoField1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("");
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        telefoneAlunoField1.addKeyListener(formListener);

        telefoneAlunoLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        telefoneAlunoLabel1.setText("Procedência:");

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jCheckBox1.setText("ALOJAMENTO");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_print_printer_printing_raw_simple_392497.png"))); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jButton8, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButton8.addActionListener(formListener);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(fotoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton9))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomeField)
                                    .addComponent(nomeLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(periodoLabel1)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextField1)
                                    .addComponent(dataNascLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(telefoneAlunoLabel)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(telefoneAlunoField, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextField2)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(cartaoSUSLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(cartaoSUSLabel)
                                        .addGap(132, 132, 132))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(cartaoSUSField)
                                        .addGap(10, 10, 10)))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(cartaoSUSLabel2)
                                        .addGap(0, 132, Short.MAX_VALUE))
                                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cartaoSUSLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton8))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alergiasLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                .addGap(35, 35, 35))
                            .addComponent(medusoContinuoLabel))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(medusoContinuoLabel1)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(cursoLabel)
                                .addGap(0, 318, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(periodoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telefoneAlunoField1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefoneAlunoLabel1))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9)
                    .addComponent(fotoLabel)
                    .addComponent(nomeLabel)
                    .addComponent(periodoLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataNascLabel)
                            .addComponent(telefoneAlunoLabel)
                            .addComponent(cartaoSUSLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefoneAlunoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(cartaoSUSLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cartaoSUSLabel)
                                    .addComponent(cartaoSUSLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cartaoSUSField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1)
                            .addComponent(jButton8))))
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(periodoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cursoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(telefoneAlunoLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telefoneAlunoField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton6)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alergiasLabel)
                    .addComponent(medusoContinuoLabel)
                    .addComponent(medusoContinuoLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cartaoSUSLabel2, cartaoSUSLabel3});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DADOS", jPanel1);

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 204));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_help_326654.png"))); // NOI18N
        jButton7.setToolTipText("VER ATALHOS");
        jButton7.addActionListener(formListener);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.FocusListener, java.awt.event.ItemListener, java.awt.event.KeyListener, java.awt.event.MouseListener, javax.swing.event.ChangeListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                JFrmCadAluno.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == jButton1) {
                JFrmCadAluno.this.jButton1ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton3) {
                JFrmCadAluno.this.jButton3ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton2) {
                JFrmCadAluno.this.jButton2ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton4) {
                JFrmCadAluno.this.jButton4ActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                JFrmCadAluno.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                JFrmCadAluno.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == jButton10) {
                JFrmCadAluno.this.jButton10ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton5) {
                JFrmCadAluno.this.jButton5ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton6) {
                JFrmCadAluno.this.jButton6ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton9) {
                JFrmCadAluno.this.jButton9ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton8) {
                JFrmCadAluno.this.jButton8ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton7) {
                JFrmCadAluno.this.jButton7ActionPerformed(evt);
            }
        }

        public void focusGained(java.awt.event.FocusEvent evt) {
            if (evt.getSource() == jTextField1) {
                JFrmCadAluno.this.jTextField1FocusGained(evt);
            }
        }

        public void focusLost(java.awt.event.FocusEvent evt) {
        }

        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            if (evt.getSource() == jComboBox1) {
                JFrmCadAluno.this.jComboBox1ItemStateChanged(evt);
            }
            else if (evt.getSource() == jComboBox3) {
                JFrmCadAluno.this.jComboBox3ItemStateChanged(evt);
            }
        }

        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == jTabbedPane1) {
                JFrmCadAluno.this.jTabbedPane1KeyPressed(evt);
            }
            else if (evt.getSource() == tabela) {
                JFrmCadAluno.this.tabelaKeyPressed(evt);
            }
        }

        public void keyReleased(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == jTextField1) {
                JFrmCadAluno.this.jTextField1KeyReleased(evt);
            }
            else if (evt.getSource() == tabela) {
                JFrmCadAluno.this.tabelaKeyReleased(evt);
            }
            else if (evt.getSource() == nomeResponsavelField) {
                JFrmCadAluno.this.nomeResponsavelFieldKeyReleased(evt);
            }
            else if (evt.getSource() == telefoneResponsavelField) {
                JFrmCadAluno.this.telefoneResponsavelFieldKeyReleased(evt);
            }
            else if (evt.getSource() == nomeResponsavelField1) {
                JFrmCadAluno.this.nomeResponsavelField1KeyReleased(evt);
            }
            else if (evt.getSource() == telefoneResponsavelField2) {
                JFrmCadAluno.this.telefoneResponsavelField2KeyReleased(evt);
            }
            else if (evt.getSource() == nomeField) {
                JFrmCadAluno.this.nomeFieldKeyReleased(evt);
            }
            else if (evt.getSource() == jTextField2) {
                JFrmCadAluno.this.jTextField2KeyReleased(evt);
            }
            else if (evt.getSource() == telefoneAlunoField) {
                JFrmCadAluno.this.telefoneAlunoFieldKeyReleased(evt);
            }
            else if (evt.getSource() == cartaoSUSField) {
                JFrmCadAluno.this.cartaoSUSFieldKeyReleased(evt);
            }
            else if (evt.getSource() == telefoneAlunoField1) {
                JFrmCadAluno.this.telefoneAlunoField1KeyReleased(evt);
            }
        }

        public void keyTyped(java.awt.event.KeyEvent evt) {
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == jLabel1) {
                JFrmCadAluno.this.jLabel1MouseClicked(evt);
            }
            else if (evt.getSource() == jComboBox1) {
                JFrmCadAluno.this.jComboBox1MouseClicked(evt);
            }
            else if (evt.getSource() == jComboBox2) {
                JFrmCadAluno.this.jComboBox2MouseClicked(evt);
            }
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == tabela) {
                JFrmCadAluno.this.tabelaMousePressed(evt);
            }
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == tabela) {
                JFrmCadAluno.this.tabelaMouseReleased(evt);
            }
        }

        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            if (evt.getSource() == jTabbedPane1) {
                JFrmCadAluno.this.jTabbedPane1StateChanged(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        System.out.println(testesValida);
        if (testesValida == true) {//verifica conexao
            entityManager.getTransaction().rollback();
            entityManager.getTransaction().begin();
            java.util.Collection data = query.getResultList();
            for (Object entity : data) {
                entityManager.refresh(entity);
            }
            list.clear();
            list.addAll(data);
            list.clear();
            query = entityManager.createQuery("SELECT a FROM Aluno a order by a.nome").setMaxResults(29);
            list.clear();
            list.addAll(query.getResultList());
            novo = false;
            jComboBox1.setSelectedIndex(-1);
            jComboBox2.setSelectedIndex(-1);
            jTabbedPane1.setSelectedIndex(0);
            jTabbedPane1.setEnabled(true);
            jTextField1.setText("");
            jTextField2.setText("");
            jComboBox3.setSelectedIndex(-1);
            jTextField3.setText("");
            cartaoSUSLabel3.setText("");
            jFormattedTextField1.setText("");
            saveButton.setEnabled(false);
            setTipo();
            butFalse();
            setUser();
            editableFalse();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_refreshButtonActionPerformed
    public void setAlojamento() {
        if (tabela.getSelectedRow() >= 0) {
            String aloj = list.get(tabela.getSelectedRow()).getAlojamento();
            if (aloj == null) {
                jCheckBox1.setSelected(false);
            } else if (aloj.equals("NÃO")) {
                jCheckBox1.setSelected(false);
            } else {
                jCheckBox1.setSelected(true);
            }
        }
    }

    private void setUser() {
        File diretorio = new File("C:/Users/Public/Documents/IFermaria/fotos");//diretório fotos
        String path, pathReplace;
        if (!diretorio.exists()) { //verifica se o diretório existe
            diretorio.mkdirs(); //se não cria ele
            File user = new File("./user.png");//imagem user
            ImageIcon icone1;

            if (!user.exists()) {// se a imagem nao existir
                path = jLabel1.getIcon().toString();
                pathReplace = path.replaceAll("file:/", "");//pega o caminho do icone pelo jLabel
                icone1 = new ImageIcon(pathReplace);//local do icone do jlabel
            } else {//se existir
                icone1 = new ImageIcon("./user.png");//pega ela

            }
            Image img = icone1.getImage();
            String nomeImagem = "user.png";
            File novaImagem = new File(diretorio + "/" + nomeImagem);//salva na pasta fotos
            BufferedImage bi = new BufferedImage(180, 180, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = bi.createGraphics();
            g2d.drawImage(img, null, null);
            g2d.dispose();
            try {
                ImageIO.write(bi, "JPG", novaImagem);
            } catch (IOException ex) {
                Logger.getLogger(JFrmCadAluno.class.getName()).log(Level.SEVERE, null, ex);
            }

            int ls = tabela.getSelectedRow();
            if (ls >= 0) {//se alguem selecionar alguma linha, seta a foto
                Aluno a = list.get(ls);
                a.setFoto(nomeImagem);
            }
        } else {
        }
        ImageIcon icone = new ImageIcon(diretorio + "/user.png");
        jLabel1.setIcon(icone);
    }

    public void ano() {
        //seta o ano atual
        int aa;
        Calendar hoje = Calendar.getInstance();
        aa = hoje.get(Calendar.YEAR);
        jTextField2.setText(String.valueOf(aa));
        jTextField2.setForeground(Color.BLACK);
    }
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        System.out.println(testesValida);
        if (testesValida == true) {//verifica conexao
            try {
                model.Aluno a = new model.Aluno();
                novo = true;
                entityManager.persist(a);
                list.add(a);
                int row = list.size() - 1;
                tabela.setRowSelectionInterval(row, row);
                tabela.scrollRectToVisible(tabela.getCellRect(row, 0, true));
                jTabbedPane1.setEnabled(false);
                salaList.clear();
                jFormattedTextField1.setText("");
                setUser();
                editableTrue();
                butFalse();
                ano();
                setTipo();
                saveButton.setEnabled(true);
                jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 0)));
                jLabel1.setToolTipText("CLIQUE DUAS VEZES PARA ADICIONAR UMA IMAGEM JÁ SALVA NO COMPUTADOR");
                jTabbedPane1.setSelectedIndex(1);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao Criar Novo Cadastro!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_newButtonActionPerformed

    public void validaSalvar() {
//validações
        String dataString = jFormattedTextField1.getText(),
                auxCPF = jFormattedTextField2.getText(),
                cpfNew = auxCPF.replaceAll("[.-]", ""),
                diaStr = dataString.substring(0, 2),
                mesStr = dataString.substring(3, 5),
                anoStr = dataString.substring(6, 10);
        int dia = 0, mes = 0, ano = 0, anoAtual;

        Calendar hoje = Calendar.getInstance();
        anoAtual = hoje.get(Calendar.YEAR);
        if (!diaStr.equals("  ")) {
            dia = Integer.parseInt(diaStr);
        }
        if (!mesStr.equals("  ")) {
            mes = Integer.parseInt(mesStr);
        }
        if (!anoStr.equals("    ")) {
            ano = Integer.parseInt(anoStr);
        }

        checagemObrigatoria = true;

        if (nomeField.getText().equals("")) {//validação de preenchimeto
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO PREENCHER O CAMPO NOME!\n";
        }
        if (jTextField2.getText().equals("")) {//validação de preenchimeto
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO PREENCHER O CAMPO ANO DE CADASTRO!\n";
        } else if (!jTextField2.getText().matches("[0-9]*")) {
            checagemObrigatoria = false;
            mensagemErro += "CARECTERE NÃO NUMÉRICO NO CAMPO ANO!!!\n";//validação de caractere nao numerico
        } else if (Integer.parseInt(jTextField2.getText()) > anoAtual) {
            checagemObrigatoria = false;
            mensagemErro += "ANO DE CADASTRO INVALIDO!!!\n";
        }
        if (jFormattedTextField1.getText().charAt(0) == ' ') {//validação de preenchimeto
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO PREENCHER O CAMPO DATA DE NASCIMENTO!\n";
        } else if ((mes < 1) || (mes > 12) || (dia < 1) || (dia > 31) || (((mes == 4) || (mes == 6) || (mes == 9) || (mes == 11)) && (dia > 30)) || ((mes == 2) && (((dia > 28) && (ano % 4 != 0)) || (((dia > 29) && (((ano % 4 == 0) && (ano % 100 != 0)) || (ano % 400 == 0)))))) || (ano < 1900)) {
            checagemObrigatoria = false;//validação de data
            mensagemErro += "DATA  DE NASCIMENTO INVALIDA! \n";
        }

        if (jFormattedTextField2.getText().charAt(0) != ' ') {//validação de cpf
            int status = list.get(tabela.getSelectedRow()).validaCPF(cpfNew);
            if (status != 0) {
                if (status == 3) {
                    checagemObrigatoria = false;
                    mensagemErro += "CPF Inválido - Digitos iguais! \n";

                } else if (status == 4) {
                    checagemObrigatoria = false;
                    mensagemErro += "CPF Inválido - dígitos verificadores não conferem! \n";
                }
            }
        } else if (!cartaoSUSField.getText().matches("[0-9]*")) {
            checagemObrigatoria = false;
            mensagemErro += "CARECTERE NÃO NUMÉRICO NO CAMPO CARTÃO DO SUS!!!\n";
        }

        if (jComboBox3.getSelectedIndex() == -1) {//validação de preenchimeto
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO SELECIONAR O TIPO!\n";
        }
        if (jComboBox3.getSelectedIndex() == 1 && jTextField3.getText().equals("")) {//validação de preenchimeto
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO PREENCHER A AREA DO PROFESSOR!\n";
        }
        if (jComboBox3.getSelectedIndex() == 2 && jTextField3.getText().equals("")) {//validação de preenchimeto
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO PREENCHER A AREA DO FUNCIONARIO!\n";
        }
        if (jComboBox3.getSelectedIndex() == 0 && jComboBox1.getSelectedIndex() == -1) {//validação de preenchimeto
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO SELECIONAR O CURSO DO ALUNO!\n";
        }
        if (jComboBox3.getSelectedIndex() == 0 && jComboBox2.getSelectedIndex() == -1) {//validação de preenchimeto
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO SELECIONAR O TURMA DO ALUNO!\n";
        }
        if (jComboBox3.getSelectedIndex() > 0 && jCheckBox1.isSelected()) {//validação de preenchimeto
            checagemObrigatoria = false;
            mensagemErro += jComboBox3.getSelectedItem().toString() + " NÃO PODE MORAR NO ALOJAMENTO!\n";
        }
        if (telefoneAlunoField.getText().length() > 20) {//validação de limite de caracteres
            checagemObrigatoria = false;
            mensagemErro += "♦LIMITE DE 20 CARACTERES NO CAMPO TELEFONE, QUANTIDADE DIGITADA: " + telefoneAlunoField.getText().length() + " !\n";
        }

        if (jTextField2.getText().length() > 4) {//validação de limite de caracteres
            checagemObrigatoria = false;
            mensagemErro += "♦LIMITE DE 4 CARACTERES NO CAMPO ANO DE CADASTRO, QUANTIDADE DIGITADA: " + jTextField2.getText().length() + " !\n";
        }
        if (jTextField3.getText().length() > 50) {//validação de limite de caracteres
            checagemObrigatoria = false;
            mensagemErro += "♦LIMITE DE 50 CARACTERES NO CAMPO AREA DO " + jComboBox3.getSelectedItem().toString() + ", QUANTIDADE DIGITADA: " + jTextField3.getText().length() + " !\n";
        }
        if (cartaoSUSField.getText().length() > 20) {//validação de limite de caracteres
            checagemObrigatoria = false;
            mensagemErro += "♦LIMITE DE 20 CARACTERES NO CAMPO CARTÃO DO SUS, QUANTIDADE DIGITADA: " + cartaoSUSField.getText().length() + " !\n";
        }
        if (nomeField.getText().length() > 100) {//validação de limite de caracteres
            checagemObrigatoria = false;
            mensagemErro += "♦LIMITE DE 100 CARACTERES NO CAMPO NOME, QUANTIDADE DIGITADA: " + nomeField.getText().length() + " !\n";
        }
        if (jTextArea1.getText().length() > 100) {//validação de limite de caracteres
            checagemObrigatoria = false;
            mensagemErro += "♦LIMITE DE 100 CARACTERES NO CAMPO ALERGIAS, QUANTIDADE DIGITADA: " + jTextArea1.getText().length() + " !\n";
        }

        if (jTextArea2.getText().length() > 100) {//validação de limite de caracteres
            checagemObrigatoria = false;
            mensagemErro += "♦LIMITE DE 100 CARACTERES NO CAMPO MEDICAMENTOS DE USO CONTÍNUO, QUANTIDADE DIGITADA: " + jTextArea2.getText().length() + " !\n";
        }

        if (jTextArea3.getText().length() > 100) {//validação de limite de caracteres
            checagemObrigatoria = false;
            mensagemErro += "♦LIMITE DE 100 CARACTERES NO CAMPO DOENÇAS, QUANTIDADE DIGITADA: " + jTextArea3.getText().length() + " !\n";
        }
        if (nomeResponsavelField.getText().length() > 100) {//validação de limite de caracteres
            checagemObrigatoria = false;
            mensagemErro += "♦LIMITE DE 100 CARACTERES NO CAMPO Nome Responsavel 1 (Pai), QUANTIDADE DIGITADA: " + nomeResponsavelField.getText().length() + " !\n";
        }
        if (nomeResponsavelField1.getText().length() > 100) {//validação de limite de caracteres
            checagemObrigatoria = false;
            mensagemErro += "♦LIMITE DE 100 CARACTERES NO CAMPO Nome Responsavel 2 (Mãe), QUANTIDADE DIGITADA: " + nomeResponsavelField1.getText().length() + " !\n";
        }
        if (telefoneResponsavelField.getText().length() > 20) {//validação de limite de caracteres
            checagemObrigatoria = false;
            mensagemErro += "♦LIMITE DE 20 CARACTERES NO CAMPO Telefone (Pai), QUANTIDADE DIGITADA: " + telefoneResponsavelField.getText().length() + " !\n";
        }
        if (telefoneResponsavelField2.getText().length() > 20) {
            checagemObrigatoria = false;//validação de limite de caracteres
            mensagemErro += "♦LIMITE DE 20 CARACTERES NO CAMPO Telefone (Mãe), QUANTIDADE DIGITADA: " + telefoneResponsavelField.getText().length() + " !\n";
        }
        if (telefoneAlunoField1.getText().length() > 100) {
            checagemObrigatoria = false;//validação de limite de caracteres
            mensagemErro += "♦LIMITE DE 100 CARACTERES NO CAMPO Procedencia, QUANTIDADE DIGITADA: " + telefoneAlunoField1.getText().length() + " !\n";
        }
    }

    public void check_n_Obrigatoria() {//validação não obrigatória
        int index = tabela.getSelectedRow();
        checagem_nao_Obrigatoria = true;

        if ((list.get(index).getFoto() == null) || (list.get(index).getFoto().equals("user.png"))) {//validação de preenchimento não obrigatório
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "FOTO NÃO SELECIONADA!\n";
        }

        if (telefoneAlunoField.getText().equals("")) {//validação de preenchimento não obrigatório
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (Telefone) NÃO PREENCHIDO!\n";
        }
        if (jFormattedTextField2.getText().charAt(0) == ' ') {//validação de preenchimento não obrigatório
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (CPF) NÃO PREENCHIDO!\n";
        }
        if (cartaoSUSField.getText().equals("")) {//validação de preenchimento não obrigatório
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (Cartão do SUS) NÃO PREENCHIDO!\n";
        }
        if (telefoneAlunoField1.getText().equals("")) {//validação de preenchimento não obrigatório
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (Procedência) NÃO PREENCHIDO!\n";
        }

        if (jTextArea1.getText().equals("")) {//validação de preenchimento não obrigatório
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (Alergias) NÃO PREENCHIDO!\n";
        }
        if (jTextArea2.getText().equals("")) {//validação de preenchimento não obrigatório
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (Medicamentos de uso Continuo) NÃO PREENCHIDO!\n";
        }

        if (jTextArea3.getText().equals("")) {//validação de preenchimento não obrigatório
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (Doenças) NÃO PREENCHIDO!\n";

        }
        if (nomeResponsavelField.getText().equals("")) {//validação de preenchimento não obrigatório
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (Nome Responsavel 1 - Pai) NÃO PREENCHIDO!\n";
        }

        if (telefoneResponsavelField.getText().equals("")) {//validação de preenchimento não obrigatório
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (Telefone Pai) NÃO PREENCHIDO!\n";
        }

        if (nomeResponsavelField1.getText().equals("")) {//validação de preenchimento não obrigatório
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (Nome Responsavel 2  - Mãe) NÃO PREENCHIDO!\n";
        }
        if (telefoneResponsavelField2.getText().equals("")) {//validação de preenchimento não obrigatório
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (Telefone Mãe) NÃO PREENCHIDO!\n";
        }
    }
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        validaSalvar();
        check_n_Obrigatoria();
        int cont = 0;
        if (checagem_nao_Obrigatoria == false) {//validação não obrigatória
            cont = JOptionPane.showConfirmDialog(null, "ATENÇÃO:\n\n" + mensagemErro_nao_Obrigatoria + "\nDESEJA MESMO SALVAR SEM ESSE(s) REGISTRO(s)?", "ATENÇÃO!!", JOptionPane.YES_NO_OPTION);
        } else {
            cont = 0;
        }
        if (cont == 0) {
            if (checagemObrigatoria == true) {//validções obrigatorias OK

                try {
                    String dataString = jFormattedTextField1.getText();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//transforma a data de String para Date 
                    Date data;
                    String dia = dataString.substring(0, 2), mes = dataString.substring(3, 5), ano = dataString.substring(6, 10);
                    try {//transforma a data de String para Date para poder salvar no banco
                        data = format.parse(ano + "-" + mes + "-" + dia);
                        int index = tabela.getSelectedRow();
                        list.get(index).setDataNasc(data);
                        if (list.get(index).getFoto() == null) {
                            list.get(index).setFoto("user.png");
                        }
                        list.get(index).setTipo(jComboBox3.getSelectedItem().toString());
                    } catch (ParseException ex) {
                        Logger.getLogger(JFrmAtendimento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (jCheckBox1.isSelected()) {
                        list.get(tabela.getSelectedRow()).setAlojamento("SIM");
                    } else {
                        list.get(tabela.getSelectedRow()).setAlojamento("NÃO");

                    }
                    entityManager.getTransaction().commit();//salva
                    entityManager.getTransaction().begin();
                    JOptionPane.showMessageDialog(null, "SALVO COM SUCESSO");
                    //registra na no banco as ações feitas pelo usuario
                    if (novo == true) {
                        new Sessao(at);
                        util.Logger.log(Sessao.getAtendenteLogado(), list.get(tabela.getSelectedRow()),
                                "INSERÇÃO DE DADOS NA NOVA PESSOA: " + list.get(tabela.getSelectedRow()).getNome()
                                + ", Tipo: " + list.get(tabela.getSelectedRow()).getTipo()
                                + ", Alergias: " + list.get(tabela.getSelectedRow()).getAlergias()
                                + ", Area: " + list.get(tabela.getSelectedRow()).getArea()
                                + ", CartaoSUS: " + list.get(tabela.getSelectedRow()).getCartaoSUS()
                                + ", CPF: " + list.get(tabela.getSelectedRow()).getCpf()
                                + ", Doenças: " + list.get(tabela.getSelectedRow()).getDoencas()
                                + ", Foto: " + list.get(tabela.getSelectedRow()).getFoto()
                                + ", MedusoContinuo: " + list.get(tabela.getSelectedRow()).getMedusoContinuo()
                                + ", NomeMae: " + list.get(tabela.getSelectedRow()).getNomeMae()
                                + ", Ano de Cadstro: " + list.get(tabela.getSelectedRow()).getAno()
                                + ", Data Nasc: " + list.get(tabela.getSelectedRow()).getDataNasc()
                                + ", NomePai: " + list.get(tabela.getSelectedRow()).getNomePai(), Tabelas.ALUNO);
                    } else {
                        new Sessao(at);
                        util.Logger.log(Sessao.getAtendenteLogado(), list.get(tabela.getSelectedRow()),
                                "ATUALIZAÇÃO DE DADOS NA PESSOA: " + list.get(tabela.getSelectedRow()).getNome()
                                + ", Tipo: " + list.get(tabela.getSelectedRow()).getTipo()
                                + ", Alergias: " + list.get(tabela.getSelectedRow()).getAlergias()
                                + ", Area: " + list.get(tabela.getSelectedRow()).getArea()
                                + ", CartaoSUS: " + list.get(tabela.getSelectedRow()).getCartaoSUS()
                                + ", CPF: " + list.get(tabela.getSelectedRow()).getCpf()
                                + ", Doenças: " + list.get(tabela.getSelectedRow()).getDoencas()
                                + ", Foto: " + list.get(tabela.getSelectedRow()).getFoto()
                                + ", MedusoContinuo: " + list.get(tabela.getSelectedRow()).getMedusoContinuo()
                                + ", NomeMae: " + list.get(tabela.getSelectedRow()).getNomeMae()
                                + ", Ano de Cadstro: " + list.get(tabela.getSelectedRow()).getAno()
                                + ", Data Nasc: " + list.get(tabela.getSelectedRow()).getDataNasc()
                                + ", NomePai: " + list.get(tabela.getSelectedRow()).getNomePai(), Tabelas.ALUNO);

                    }
                    novo = false;
                } catch (RollbackException rex) {//erro ao salvar
                    JOptionPane.showMessageDialog(null, "Erro ao Salvar!!\nFeche o Programa e verifique a conexão com a internet!!", "ERRO", JOptionPane.ERROR_MESSAGE);
                    rex.printStackTrace();
                    entityManager.getTransaction().begin();
                    List<model.Aluno> merged = new ArrayList<model.Aluno>(list.size());
                    for (model.Aluno a : list) {
                        merged.add(entityManager.merge(a));
                    }
                    list.clear();
                    list.addAll(merged);
                }
                jTabbedPane1.setEnabled(true);
                refreshButton.doClick();
            } else {////validação  obrigatória
                JOptionPane.showMessageDialog(null, "ERRO:\n\n" + mensagemErro, "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
            mensagemErro = "";
            mensagemErro_nao_Obrigatoria = "";
        } else {
            mensagemErro = "";
            mensagemErro_nao_Obrigatoria = "";
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        System.out.println(testesValida);
        if (testesValida == true) {//verifica conexao
            novo = false;
            JDialog frame = new JDialog(new JDialog(), true);
            frame.setContentPane(new JFrmEstoque(frame, at));//abre a janela de estoque
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setTitle("ESTOQUE");
            frame.setVisible(true);
            refreshButton.doClick();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void selecionaFoto() {
        int ls = tabela.getSelectedRow();
        if (ls >= 0) {//se tiver alguma pessoa selecionada na lista
            Aluno a = list.get(ls);
            String nomeFoto = a.getFoto();
            if (a.getFoto() == null) {//se a pessoa salva não tiver foto seta a foto padrão no label
                setUser();
            } else {//se a pessoa tivar foto procura a foto em documentos/ifermaria/fotos
                File existeFotos = new File("C:/Users/Public/Documents/IFermaria/fotos");
                File fotoExiste = new File(existeFotos + "/" + nomeFoto);
                if (!fotoExiste.exists()) {//se não encontrar a foto, seta a foto padrão
                    ImageIcon icone = new ImageIcon(existeFotos + "/user.png");
                    jLabel1.setIcon(icone);
                    jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 0, 0)));
                    jLabel1.setToolTipText("FOTO NÃO ENCONTRADA, TIRE OUTRA FOTO!!!");
                } else {//se encontrar seta a foto da pessoa
                    ImageIcon icone = new ImageIcon(existeFotos + "/" + nomeFoto);
                    jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 0)));
                    jLabel1.setToolTipText("CLIQUE DUAS VEZES PARA ADICIONAR UMA IMAGEM JÁ SALVA NO COMPUTADOR");
                    jLabel1.setIcon(icone);
                }
            }
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (tabela.getSelectedRow() >= 0) {
            Connection conn;
            conn = Conexao.getConnection();
            boolean testesValida = Conexao.isValida();
            System.out.println(testesValida);
            if (testesValida == true) {//verifica conexao
                novo = false;
                //verifica se uma linha da tabela esta selecionada
                Aluno a = list.get(tabela.getSelectedRow()); // pega o aluno da lista correspondente a linha selecionada da tabela
                JFrame frame = new JFrame();
                frame.add(new JFrmAtendimento(a, frame, at));//abre a janela de atendimento com a pessoa selecionada
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setTitle(a.getNome());
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Pessoa", "erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        if (testesValida == true) {//verifica conexao
            int ls = tabela.getSelectedRow();
            Aluno a = list.get(ls);
            if (ls >= 0) {//se tiver alguma pessoa selecionada
                String nomeFoto = a.getFoto();
                File diretorio = new File("C:/Users/Public/Documents/IFermaria/fotos");
                File fotoExiste = new File(diretorio + "/" + nomeFoto);
                if (a.getTipo().equals("Aluno")) {//se a pessoa for do tipo aluno, abre o relatorio do Aluno com informações especificas de alunos como curso
                    String caminho = new File("./relatorio/relatorioAluno.jasper").getAbsolutePath();
                    String caminho2 = new File("./relatorio").getAbsolutePath();
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("id", a.getIdAluno());
                    params.put("SUBREPORT_DIR", caminho2);
                    if (!fotoExiste.exists()) {//se o aluno não tiver foto, passa a foto padrão para o relatório
                        params.put("foto", diretorio + "/user.png");
                    } else {//se o aluno  tiver foto, passa a fotodo aluno
                        params.put("foto", diretorio + "/" + a.getFoto());
                    }

                    try {
                        // JasperReport relatorio = JasperCompileManager.compileReport(caminho);//compila o caminho
                        JasperPrint print = JasperFillManager.fillReport(caminho, params, Conexao.getConnection());//conecta aos dados 
                        JasperViewer view = new JasperViewer(print, false);//imprime na tela
                        view.setVisible(true);
                    } catch (JRException ex) {//erro
                        System.out.println(ex);
                        JOptionPane.showMessageDialog(null, "Falha ao gerar Relatório!!", "Erro", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(RelatoriosControle.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {//se a pessoa for do tipo professor/ Funcionario, abre o relatorio do professor/ Funcionario com informações especificas de professor/ Funcionario
                    String caminho = new File("./relatorio/relatorioProfessor_Funcionario.jasper").getAbsolutePath();
                    String caminho2 = new File("./relatorio").getAbsolutePath();
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("idAluno", a.getIdAluno());
                    params.put("SUBREPORT_DIR", caminho2);
                    if (!fotoExiste.exists()) {//se o professor/ Funcionario não tiver foto, passa a foto padrão para o relatório
                        params.put("foto", diretorio + "/user.png");

                    } else {//se o professor/ Funcionario  tiver foto, passa a fotodo aluno
                        params.put("foto", diretorio + "/" + a.getFoto());
                    }
                    try {
                        //   JasperReport relatorio = JasperCompileManager.compileReport(caminho);//compila o caminho
                        JasperPrint print = JasperFillManager.fillReport(caminho, params, Conexao.getConnection());
                        JasperViewer view = new JasperViewer(print, false);
                        view.setVisible(true);
                    } catch (JRException ex) {
                        System.out.println(ex);
                        JOptionPane.showMessageDialog(null, "Falha ao gerar Relatório!!", "Erro", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(RelatoriosControle.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {//caso não tenha selecionado nehuma pessoa
                JOptionPane.showMessageDialog(null, "SELECIONE UMA PESSOA!!!", "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased

        query = entityManager.createQuery("select a from Aluno a where a.nome like :nome order by a.nome");
        query.setParameter("nome", "%" + jTextField1.getText() + "%");
        query.setMaxResults(29).getResultList();
        list.clear();
        list.addAll(query.getResultList());
        if (!list.isEmpty()) {
            tabela.setRowSelectionInterval(0, 0);
            butTrue();
            setAlojamento();
            if (evt.getKeyCode() == 10) {//ENTER
                jTabbedPane1.setSelectedIndex(1);
            }
        }

        if (evt.getKeyCode() == 113) {//F2
            jButton1.doClick();
        }
        if (evt.getKeyCode() == 112) {//F1
            jButton2.doClick();
        }
        if (evt.getKeyCode() == 114) {//F3
            jButton3.doClick();
        }
        if (evt.getKeyCode() == 115) {//F4
            jButton10.doClick();
        }
        if (evt.getKeyCode() == 27) {//ESC
            refreshButton.doClick();
        }

    }//GEN-LAST:event_jTextField1KeyReleased
    private void editableFalse() {
        //deixa alguns campo impossiveis de editar
        nomeField.setEditable(false);
        if (jComboBox3.getSelectedIndex() != 0) {
            jComboBox1.setEditable(true);
            jComboBox2.setEditable(true);
            jComboBox1.setEnabled(false);
            jComboBox2.setEnabled(false);
        } else {
            jComboBox1.setEditable(false);
            jComboBox2.setEditable(false);
            jComboBox1.setEnabled(false);
            jComboBox2.setEnabled(false);
        }
        telefoneAlunoField1.setEditable(false);
        jCheckBox1.setEnabled(false);
        jFormattedTextField1.setEditable(false);
        telefoneAlunoField.setEditable(false);
        cartaoSUSField.setEditable(false);
        jTextArea1.setEditable(false);
        jTextArea2.setEditable(false);
        nomeResponsavelField.setEditable(false);
        telefoneResponsavelField.setEditable(false);
        jButton5.setEnabled(false);
        jFormattedTextField2.setEditable(false);
        jButton6.setEnabled(false);
        jButton9.setEnabled(false);
        jTextArea3.setEditable(false);
        nomeResponsavelField1.setEditable(false);
        telefoneResponsavelField2.setEditable(false);
        jTextField2.setEditable(false);
        jComboBox3.setEnabled(false);
        jTextField3.setEditable(false);
    }

    private void editableTrue() {
        //deixa alguns campo possiveis de editar
        nomeField.setEditable(true);
        jFormattedTextField1.setEditable(true);
        if (jComboBox3.getSelectedIndex() == 0) {
            jComboBox2.setEnabled(true);
            jComboBox1.setEnabled(true);
        }
        telefoneAlunoField1.setEditable(true);
        jCheckBox1.setEnabled(true);
        jComboBox2.setEditable(false);
        jComboBox1.setEditable(false);
        telefoneAlunoField.setEditable(true);
        cartaoSUSField.setEditable(true);
        jTextArea1.setEditable(true);
        jTextArea2.setEditable(true);
        nomeResponsavelField.setEditable(true);
        telefoneResponsavelField.setEditable(true);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
        jFormattedTextField2.setEditable(true);
        jButton9.setEnabled(true);
        jTextArea3.setEditable(true);
        nomeResponsavelField1.setEditable(true);
        telefoneResponsavelField2.setEditable(true);
        jTextField2.setEditable(true);
        jComboBox3.setEnabled(true);
        jTextField3.setEditable(true);
    }

    private void butTrue() {
        //deixa alguns botões impossiveis de editar
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton1.setEnabled(true);
    }

    private void butFalse() {
        //deixa alguns botões possiveis de editar
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton1.setEnabled(false);
    }

    public void setCorAno() {
        //se o ano for menor que o atual, seta com vermelha para alertar a enfermeira de possiveis atualizações
        int anoAtual;
        int anodaPessoa;
        Calendar hoje = Calendar.getInstance();
        anoAtual = hoje.get(Calendar.YEAR);
        anodaPessoa = list.get(tabela.getSelectedRow()).getAno();
        if (anodaPessoa < anoAtual) {
            jTextField2.setForeground(Color.red);
            jTextField2.setToolTipText("VERRIFIQUE SE AS INFORMAÇÕES ESTÃO CORRERAS");
        } else {
            jTextField2.setForeground(Color.black);
        }
    }

    public String setDia() {
        //tranforma a DataNasc do tipo Date para String e seta no campo
        int ls = tabela.getSelectedRow();
        Aluno a = list.get(ls);
        String dataAntigaDate = a.getDataNasc().toString();
        String ano = dataAntigaDate.substring(0, 4);
        String mes = dataAntigaDate.substring(5, 7);
        String dia = dataAntigaDate.substring(8, 10);
        String dataNovaString = dia + mes + ano;
        return dataNovaString;
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        novo = false;
        jTabbedPane1.setSelectedIndex(1);
        jTabbedPane1.setEnabled(false);
        editableTrue();
        saveButton.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        System.out.println(testesValida);
        if (testesValida == true) {//verifica conexao
            Aluno a = list.get(tabela.getSelectedRow());
            JDialog frame = new JDialog(new JFrame(), true);
            frame.add(new JFrmCurso(frame, cursoList, a));//abre o frame de curso
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setTitle("NOVO CURSO");
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

//filtra os periodos específicos do curso selecionado
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        System.out.println(testesValida);
        if (jTabbedPane1.getSelectedIndex() == 1) {
            if (testesValida == true) {//verifica conexao

                Curso c = (Curso) jComboBox1.getSelectedItem();
                if (c != null && c.getIdcurso() != null) {
                    salaQuery = entityManager.createQuery("select s from Sala s where s.curso = :c");
                    salaQuery.setParameter("c", c);
                    salaList.clear();
                    salaList.addAll(salaQuery.getResultList());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {

        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
//abre a tela de adicionar novos periodos
        if (jComboBox1.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um Curso para Adicionar um novo Período!!", "erro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Connection conn;
            conn = Conexao.getConnection();
            boolean testesValida = Conexao.isValida();
            System.out.println(testesValida);
            if (testesValida == true) {//verifica conexao
                Aluno a = list.get(tabela.getSelectedRow());
                JDialog frame = new JDialog(new JFrame(), true);
                Curso c = cursoList.get(jComboBox1.getSelectedIndex());
                frame.add(new JFrmSala(frame, salaList, c, entityManager, a));
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setTitle("NOVA TURMA");
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
//abre a tela de camera
        if (tabela.getSelectedRow() >= 0) {
            Aluno a = list.get(tabela.getSelectedRow());
            JDialog frame = new JDialog(new JDialog(), true);
            frame.setContentPane(new AbreCamera(frame, a));
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setTitle("NEW FOTO");
            frame.setVisible(true);
            if (!frame.isVisible()) {
                selecionaFoto();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Pessoa", "erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        //abre a tela de relatorios de controle
        try {
            RelatoriosControle frame = new RelatoriosControle(new JFrame(), true);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setTitle("RELATÓRIOS");
            frame.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao Abrir Janela de Controle!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void cartaoSUSFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cartaoSUSFieldKeyReleased
        //verifica se a ultiva letra digitada é um numero
        String digitos = "0123456789";
        String texto = cartaoSUSField.getText();
        boolean b = true;
        if (texto.equals("") || evt.getKeyCode() == 10) {
        } else {
            for (int i = 0; i < texto.length(); i++) {
                if (digitos.indexOf(texto.charAt(i)) == -1) {
                    b = false;
                } else {
                    b = true;
                }
            }
        }
        if (b == false) {
            JOptionPane.showMessageDialog(null, "PREENCHA ESSE CAMPO APENAS COM NUMEROS", "ERRO", JOptionPane.ERROR_MESSAGE);
            cartaoSUSField.setText("");
        }
        if (cartaoSUSField.getText().length() > 20) {//verifica o limite de caracteres para que não ocorra erro de redimencionamento da tela
            JOptionPane.showMessageDialog(null, "LIMITE DE 20 CARACTERES", "ERRO", JOptionPane.ERROR_MESSAGE);
            cartaoSUSField.setText(null);
        }
    }//GEN-LAST:event_cartaoSUSFieldKeyReleased
    public void setTipo() {
//modifica o campo area dependendo do tipo de pessoa a ser cadastrada
        if ((jComboBox3.getSelectedIndex() == 1) || (jComboBox3.getSelectedIndex() == 2)) {
            cartaoSUSLabel3.setText("Area do " + jComboBox3.getSelectedItem().toString());
            jTextField3.setEnabled(true);
            jComboBox1.setSelectedIndex(-1);
            jComboBox2.setSelectedIndex(-1);
            jComboBox1.setEnabled(false);
            jComboBox2.setEnabled(false);
            jButton5.setEnabled(false);
            jButton6.setEnabled(false);
        } else {
            cartaoSUSLabel3.setText("");
            jTextField3.setText("");
            jTextField3.setEnabled(false);
            jComboBox1.setEnabled(true);
            jComboBox2.setEnabled(true);
            jButton5.setEnabled(true);
            jButton6.setEnabled(true);
        }

    }
    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        setTipo();
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        JOptionPane.showMessageDialog(null, "ATALHOS:\n"//tela de atalhos
                + "\nEnter  - Abre dados da Pessoa"
                + "\nF1 - Abre janela de Estoque"
                + "\nF2 - Abre janela Atendimento"
                + "\nF3 - Abre Relatório da Pessoa"
                + "\nF4 = Abre Janela de Controle");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        if (jComboBox1.isEditable()) {//se o tipo for Professor/ Funcionario, ele não pode ter um curso
        } else {
            if ((jComboBox3.getSelectedIndex() == 0) || (jComboBox3.getSelectedIndex() == -1)) {
            } else {
                JOptionPane.showMessageDialog(null, jComboBox3.getSelectedItem().toString() + " não pode ter um curso!!");
            }
        }
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        if ((jComboBox3.getSelectedIndex() == 0) || (jComboBox3.getSelectedIndex() == -1)) {//se o tipo for Professor/ Funcionario, ele não pode ter um periodo
        } else {
            JOptionPane.showMessageDialog(null, jComboBox3.getSelectedItem().toString() + " não pode ter uma Turma!!");
        }
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        String digitos = "0123456789";//verifica se a ultiva letra digitada é um numero
        String texto = jTextField2.getText();
        boolean b = true;
        if (texto.equals("") || evt.getKeyCode() == 10) {
        } else {
            for (int i = 0; i < texto.length(); i++) {
                if (digitos.indexOf(texto.charAt(i)) == -1) {
                    b = false;
                } else {
                    b = true;
                }
            }
        }
        if (b == false) {
            JOptionPane.showMessageDialog(null, "PREENCHA ESSE CAMPO APENAS COM NUMEROS", "ERRO", JOptionPane.ERROR_MESSAGE);
            jTextField2.setText("");
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTabbedPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabbedPane1KeyPressed
        if (evt.getKeyCode() == 27) {//ESC
            refreshButton.doClick();
        }
    }//GEN-LAST:event_jTabbedPane1KeyPressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        //caso o usuario clique duas vezes no label, abre uma janela para selecionar a imagem do windows e salva essa
        //imagem na pasta de fottos
        File existeFotos = new File("C:/Users/Public/Documents/IFermaria/fotos");
        if (!existeFotos.exists()) {
            existeFotos.mkdirs();
        }
        if (evt.getClickCount() == 2 && jLabel1.isEnabled() && nomeField.isEditable()) {
            JFileChooser fc = new JFileChooser();

            fc.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {//filtro de arquivos (apenas imagens)
                    String name = f.getAbsolutePath();
                    return name.endsWith("jpg") | name.endsWith("png") | name.endsWith("gif") | name.endsWith("bmp") | name.endsWith("JPG") | name.endsWith("PNG") | name.endsWith("GIF") | name.endsWith("BMP") | f.isDirectory();

                }

                @Override
                public String getDescription() {
                    return "Imagem";
                }

            });
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                String path = fc.getSelectedFile().getAbsolutePath();
                ImageIcon icone1 = new ImageIcon(path);

                Image img = icone1.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT);

                jLabel1.setIcon(new ImageIcon(img));
                String nomeImagem = System.currentTimeMillis() + ".jpg";

                File novaImagem = new File("C:/Users/Public/Documents/IFermaria/fotos" + nomeImagem);
                BufferedImage bi = new BufferedImage(jLabel1.getWidth(), jLabel1.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = bi.createGraphics();
                g2d.drawImage(img, null, null);
                g2d.dispose();
                try {
                    ImageIO.write(bi, "JPG", novaImagem);
                } catch (IOException ex) {
                    Logger.getLogger(JFrmCadAluno.class.getName()).log(Level.SEVERE, null, ex);
                }

                int ls = tabela.getSelectedRow();
                if (ls >= 0) {
                    Aluno a = list.get(ls);
                    a.setFoto(nomeImagem);
                }
            }
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void nomeFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeFieldKeyReleased
        if (nomeField.getText().length() > 100) {//verifica o limite de caracteres para que não ocorra erro de redimencionamento da tela
            JOptionPane.showMessageDialog(null, "LIMITE DE 100 CARACTERES", "ERRO", JOptionPane.ERROR_MESSAGE);
            nomeField.setText(null);
        }
    }//GEN-LAST:event_nomeFieldKeyReleased

    private void telefoneAlunoFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefoneAlunoFieldKeyReleased
        if (telefoneAlunoField.getText().length() > 20) {//verifica o limite de caracteres para que não ocorra erro de redimencionamento da tela
            JOptionPane.showMessageDialog(null, "LIMITE DE 20 CARACTERES", "ERRO", JOptionPane.ERROR_MESSAGE);
            telefoneAlunoField.setText(null);
        }
    }//GEN-LAST:event_telefoneAlunoFieldKeyReleased

    private void nomeResponsavelFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeResponsavelFieldKeyReleased
        if (nomeResponsavelField.getText().length() > 100) {//verifica o limite de caracteres para que não ocorra erro de redimencionamento da tela
            JOptionPane.showMessageDialog(null, "LIMITE DE 100 CARACTERES", "ERRO", JOptionPane.ERROR_MESSAGE);
            nomeResponsavelField.setText(null);
        }
    }//GEN-LAST:event_nomeResponsavelFieldKeyReleased

    private void nomeResponsavelField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeResponsavelField1KeyReleased
        if (nomeResponsavelField1.getText().length() > 100) {//verifica o limite de caracteres para que não ocorra erro de redimencionamento da tela
            JOptionPane.showMessageDialog(null, "LIMITE DE 100 CARACTERES", "ERRO", JOptionPane.ERROR_MESSAGE);
            nomeResponsavelField1.setText(null);
        }
    }//GEN-LAST:event_nomeResponsavelField1KeyReleased

    private void telefoneResponsavelFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefoneResponsavelFieldKeyReleased
        if (telefoneResponsavelField.getText().length() > 20) {//verifica o limite de caracteres para que não ocorra erro de redimencionamento da tela
            JOptionPane.showMessageDialog(null, "LIMITE DE 20 CARACTERES", "ERRO", JOptionPane.ERROR_MESSAGE);
            telefoneResponsavelField.setText(null);
        }
    }//GEN-LAST:event_telefoneResponsavelFieldKeyReleased

    private void telefoneResponsavelField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefoneResponsavelField2KeyReleased
        if (telefoneResponsavelField2.getText().length() > 20) {//verifica o limite de caracteres para que não ocorra erro de redimencionamento da tela
            JOptionPane.showMessageDialog(null, "LIMITE DE 20 CARACTERES", "ERRO", JOptionPane.ERROR_MESSAGE);
            telefoneResponsavelField2.setText(null);
        }
    }//GEN-LAST:event_telefoneResponsavelField2KeyReleased

    private void tabelaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMousePressed
        setAlojamento();
        butTrue();
        if (evt.getClickCount() == 2) {
            jTabbedPane1.setSelectedIndex(1);
        }
    }//GEN-LAST:event_tabelaMousePressed

    private void tabelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyPressed
        setAlojamento();
        if (evt.getKeyCode() == 113) {
            jButton1.doClick();
        }
        if (evt.getKeyCode() == 112) {
            jButton2.doClick();
        }
        if (evt.getKeyCode() == 114) {
            jButton3.doClick();
        }
        if (evt.getKeyCode() == 115) {
            jButton10.doClick();
        }
        if (evt.getKeyCode() == 27) {
            refreshButton.doClick();
        }
    }//GEN-LAST:event_tabelaKeyPressed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged

        if (jTabbedPane1.getSelectedIndex() == 1 && tabela.getSelectedRow() >= 0 && novo == false) {
            editableFalse();
            selecionaFoto();
            butTrue();
            setCorAno();
            jComboBox1.setSelectedItem(list.get(tabela.getSelectedRow()).getCurso());
            jComboBox2.setSelectedItem(list.get(tabela.getSelectedRow()).getCurso());
            jFormattedTextField1.setText(setDia());
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        System.out.println(testesValida);
        if (testesValida == true) {//verifica conexao
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
            refreshButton.requestFocus();
        }
    }//GEN-LAST:event_jTextField1FocusGained

    private void telefoneAlunoField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefoneAlunoField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_telefoneAlunoField1KeyReleased

    private void tabelaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseReleased
        setAlojamento();
    }//GEN-LAST:event_tabelaMouseReleased

    private void tabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyReleased
        if (tabela.getSelectedRow() >= 0) {
            setAlojamento();
            selecionaFoto();
            setDia();
        }

    }//GEN-LAST:event_tabelaKeyReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        if (testesValida == true) {//verifica conexao
            if (tabela.getSelectedRow() >= 0) {
                Aluno a = list.get(tabela.getSelectedRow());
                if (a.getTipo().equals("Aluno")) {
                    String nomeFoto = a.getFoto();
                    File diretorio = new File("C:/Users/Public/Documents/IFermaria/fotos");
                    File fotoExiste = new File(diretorio + "/" + nomeFoto);
                    String caminho = new File("./relatorio/perfilAluno.jasper").getAbsolutePath();
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("id", a.getIdAluno());
                    if (!fotoExiste.exists()) {//se o aluno não tiver foto, passa a foto padrão para o relatório
                        params.put("foto", diretorio + "/user.png");
                    } else {//se o aluno  tiver foto, passa a fotodo aluno
                        params.put("foto", diretorio + "/" + a.getFoto());
                    }
                    try {
                        JasperPrint print = JasperFillManager.fillReport(caminho, params, Conexao.getConnection());//conecta aos dados 
                        JasperViewer view = new JasperViewer(print, false);//imprime na tela
                        view.setVisible(true);
                    } catch (JRException ex) {//erro
                        System.out.println(ex);
                        JOptionPane.showMessageDialog(null, "Falha ao gerar Relatório!!", "Erro", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(RelatoriosControle.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    String nomeFoto = a.getFoto();
                    File diretorio = new File("C:/Users/Public/Documents/IFermaria/fotos");
                    File fotoExiste = new File(diretorio + "/" + nomeFoto);
                    String caminho = new File("./relatorio/perfilProfe.jasper").getAbsolutePath();
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("id", a.getIdAluno());
                    if (!fotoExiste.exists()) {//se o aluno não tiver foto, passa a foto padrão para o relatório
                        params.put("foto", diretorio + "/user.png");
                    } else {//se o aluno  tiver foto, passa a fotodo aluno
                        params.put("foto", diretorio + "/" + a.getFoto());
                    }
                    try {
                        // JasperReport relatorio = JasperCompileManager.compileReport(caminho);//compila o caminho
                        JasperPrint print = JasperFillManager.fillReport(caminho, params, Conexao.getConnection());//conecta aos dados 
                        JasperViewer view = new JasperViewer(print, false);//imprime na tela
                        view.setVisible(true);
                    } catch (JRException ex) {//erro
                        System.out.println(ex);
                        JOptionPane.showMessageDialog(null, "Falha ao gerar Relatório!!", "Erro", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(RelatoriosControle.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alergiasLabel;
    private javax.swing.JTextField cartaoSUSField;
    private javax.swing.JLabel cartaoSUSLabel;
    private javax.swing.JLabel cartaoSUSLabel1;
    private javax.swing.JLabel cartaoSUSLabel2;
    private javax.swing.JLabel cartaoSUSLabel3;
    private javax.swing.JLabel cursoLabel;
    private java.util.List<model.Curso> cursoList;
    private javax.persistence.Query cursoQuery;
    private javax.swing.JLabel dataNascLabel;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel fotoLabel;
    private javax.swing.JTextField idAlunoField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private java.util.List<model.Aluno> list;
    private javax.swing.JLabel medusoContinuoLabel;
    private javax.swing.JLabel medusoContinuoLabel1;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField nomeField;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeResponsavelField;
    private javax.swing.JTextField nomeResponsavelField1;
    private javax.swing.JLabel nomeResponsavelLabel;
    private javax.swing.JLabel nomeResponsavelLabel1;
    private javax.swing.JLabel periodoLabel;
    private javax.swing.JLabel periodoLabel1;
    private javax.persistence.Query query;
    private javax.swing.JButton refreshButton;
    private java.util.List<model.Sala> salaList;
    private javax.persistence.Query salaQuery;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField telefoneAlunoField;
    private javax.swing.JTextField telefoneAlunoField1;
    private javax.swing.JLabel telefoneAlunoLabel;
    private javax.swing.JLabel telefoneAlunoLabel1;
    private javax.swing.JTextField telefoneResponsavelField;
    private javax.swing.JTextField telefoneResponsavelField2;
    private javax.swing.JLabel telefoneResponsavelLabel;
    private javax.swing.JLabel telefoneResponsavelLabel2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

}
