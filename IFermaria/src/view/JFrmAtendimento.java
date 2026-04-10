package view;

//importações
import java.awt.Color;
import model.Aluno;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.beans.Beans;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.RollbackException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Atendente;
import model.Atendimento;
import model.Enfermidade;
import model.Estoque;
import model.Medicamento;
import util.Conexao;
import util.Sessao;
import util.Tabelas;

public class JFrmAtendimento extends JPanel {

    boolean checagemObrigatoria = true;
    String mensagemErro = "";
    boolean checagem_nao_Obrigatoria = true;
    String mensagemErro_nao_Obrigatoria = "";
    private JFrame jf;
    private String horaAtual = "", horaAtualSaida = "", diaAtual = "";
    Aluno al;
    Atendente at;
    private boolean editar = false;
    String texto = "";

    public JFrmAtendimento(Aluno aluno, JFrame jframe, Atendente at) {
        jf = jframe;
        al = aluno;//adiciona o aluno selecionado no outro frame ao objeto aluno
        this.at = at;
        initComponents();
        jf.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/inicial.png")));//seta o icone do projeto
        jTextField1.setEnabled(false);
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
        enabledFalse();
        Atendimento primeiro = null;
        if (list.size() > 0) {
            primeiro = list.get(0);
            System.out.println(list.size());
        }
        jPanel22.setVisible(false);
        jPanel9.setVisible(false);
        jLabel5.setText(aluno.getNome());
        //seleciona todos os atendimento do aluno selecionado anteriomente, mais o primeiro atendimento que  é nulo
        //pois acontece um erro ao adicionar enfermidades/ estoques no atendimento que estiver na primeira linha da tabela 
        query = entityManager.createQuery("select a from Atendimento a where a.aluno.nome like :nome order by a.dataAtendimento, a.hora");
        query.setParameter("nome", aluno.getNome());//seta o parametro nome com o texto digitado
        list.clear();//limpa a lista
        list.add(primeiro);
        list.addAll(query.getResultList());//adiciona a nova lista filtrada por parametro   
        masterTable.setSelectionMode(0);//só é possível selecionar uma linha da tabela  
        jTable2.setSelectionMode(0);//só é possível selecionar uma linha da tabela   
        jTable1.setSelectionMode(0);//só é possível selecionar uma linha da tabela  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("IFermariaPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT a FROM Atendimento a");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        alunoQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT a FROM Aluno a");
        alunoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : alunoQuery.getResultList();
        enfermidadeQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT e FROM Enfermidade e order by e.nome");
        enfermidadeList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(enfermidadeQuery.getResultList());
        estoqueQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT e FROM Estoque e where e.quantAtual != 0 order by e.medicamento.nome");
        estoqueList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : estoqueQuery.getResultList();
        medicamentoQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT m FROM Medicamento m");
        medicamentoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : medicamentoQuery.getResultList();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<model.Enfermidade>();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        refreshButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        enfermidadeidEnfermidadeLabel = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextField5 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        dataAtendimentoLabel = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        alunoidAlunoLabel = new javax.swing.JLabel();
        alunoidAlunoLabel1 = new javax.swing.JLabel();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jTextField3 = new javax.swing.JTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        horaLabel = new javax.swing.JLabel();
        horaLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        condutaLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        estoqueidestoqueLabel = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextField4 = new javax.swing.JTextArea();
        jPanel23 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        quantRetiradaField = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        quantRetiradaLabel = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        quantRetiradaField6 = new javax.swing.JTextField();
        quantRetiradaLabel6 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jRadioButton5 = new javax.swing.JRadioButton();

        FormListener formListener = new FormListener();

        setBackground(new java.awt.Color(204, 204, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel1.setBackground(new java.awt.Color(96, 202, 164));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(179, 488));

        jPanel2.setBackground(new java.awt.Color(96, 202, 164));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(170, 193));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ifermeiras.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel3.setText("IFERMARIA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(16, 16, 16))
        );

        jComboBox2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, enfermidadeList, jComboBox2);
        jComboBoxBinding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(jComboBoxBinding);

        jComboBox3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, estoqueList, jComboBox3);
        jComboBoxBinding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(jComboBoxBinding);

        jComboBox1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, alunoList, jComboBox1);
        bindingGroup.addBinding(jComboBoxBinding);
        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.aluno}"), jComboBox1, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jComboBox1, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        refreshButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_Close_1891023 (1).png"))); // NOI18N
        refreshButton.setText("CANCELAR");
        refreshButton.setToolTipText("CANCELAR ATENDIMENTO");
        refreshButton.addActionListener(formListener);

        saveButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_multimedia-27_809537.png"))); // NOI18N
        saveButton.setText("SALVAR");
        saveButton.setToolTipText("SALVAR ATENDIMENTO");
        saveButton.addActionListener(formListener);

        newButton.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_new-24_103173.png"))); // NOI18N
        newButton.setText("NOVO");
        newButton.setMaximumSize(new java.awt.Dimension(155, 29));
        newButton.setMinimumSize(new java.awt.Dimension(155, 29));
        newButton.addActionListener(formListener);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {refreshButton, saveButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addGap(8, 8, 8)
                        .addComponent(refreshButton)))
                .addGap(56, 56, 56)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        masterTable.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dataAtendimento}"));
        columnBinding.setColumnName("Data Atendimento");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hora}"));
        columnBinding.setColumnName("Hora Entrada");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterTable.addMouseListener(formListener);
        masterTable.addKeyListener(formListener);
        masterScrollPane.setViewportView(masterTable);
        if (masterTable.getColumnModel().getColumnCount() > 0) {
            masterTable.getColumnModel().getColumn(0).setResizable(false);
            masterTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel5.setText("Nome");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46))
        );

        jTabbedPane1.addTab("ATENDIMENTOS ANTIGOS", jPanel16);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "QUEIXA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        enfermidadeidEnfermidadeLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        enfermidadeidEnfermidadeLabel.setText("Enfermidade:");

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jTextField5.setEditable(false);
        jTextField5.setColumns(20);
        jTextField5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField5.setRows(5);
        jTextField5.setToolTipText("CLIQUE DUAS VEZES PARA ADICIONAR UMA ENFERMIDADE");
        jTextField5.addMouseListener(formListener);
        jTextField5.addKeyListener(formListener);
        jScrollPane6.setViewportView(jTextField5);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_199_CircledPlus_183316 (1).png"))); // NOI18N
        jButton3.addActionListener(formListener);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(0, 0, 0))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jButton2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_down_right_308966.png"))); // NOI18N
        jButton2.addActionListener(formListener);

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel1.setText("Anotações da Enfermagem:");

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setToolTipText("OBSERVAÇÕES NA QUEIXA");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.queixa}"), jTextArea2, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane4.setViewportView(jTextArea2);

        jTable2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable2.setToolTipText("ENFERMIDADE ADICIONADAS AO ATENDIMENTO");

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedElement.enfermidades}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, eLProperty, jTable2);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable2.addKeyListener(formListener);
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
        }

        jButton7.setText("...");
        jButton7.addActionListener(formListener);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(enfermidadeidEnfermidadeLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(enfermidadeidEnfermidadeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "DADOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1.setToolTipText("DATA DO ATENDIMENTO");
        jFormattedTextField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        dataAtendimentoLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        dataAtendimentoLabel.setText("Data Atendimento:");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField2.setToolTipText("NOME DA PESSOA");
        jTextField2.setOpaque(false);

        alunoidAlunoLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        alunoidAlunoLabel.setText("PACIENTE");

        alunoidAlunoLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        alunoidAlunoLabel1.setText("Atendente:");
        alunoidAlunoLabel1.setToolTipText("NOME DA ATENDENTE");

        try {
            jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField3.setToolTipText("HORA DE SAÍDA");
        jFormattedTextField3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.horaSaida}"), jFormattedTextField3, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.atendente.nome}"), jTextField3, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("");
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        jTextField3.addMouseListener(formListener);

        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField2.setToolTipText("HORA DE ENTRADA");
        jFormattedTextField2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.hora}"), jFormattedTextField2, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        horaLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        horaLabel.setText("Hora de entrada:");

        horaLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        horaLabel1.setText("Hora de saída:");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_10_171505 (1).png"))); // NOI18N
        jButton6.setToolTipText("COLOCAR HORA ATUAL NA HORA DE SAÍDA");
        jButton6.addActionListener(formListener);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(horaLabel)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(horaLabel1)
                            .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataAtendimentoLabel)))
                    .addComponent(jTextField3)
                    .addComponent(jTextField2)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alunoidAlunoLabel1)
                            .addComponent(alunoidAlunoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(alunoidAlunoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(alunoidAlunoLabel1)
                .addGap(6, 6, 6)
                .addComponent(jTextField3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horaLabel)
                    .addComponent(horaLabel1)
                    .addComponent(dataAtendimentoLabel))
                .addGap(6, 6, 6)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jTabbedPane1.addTab("Queixa/Informa e Apresenta", jPanel4);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        condutaLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        condutaLabel.setText("Anotações da Enfermagem (Conduta):");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("OBSERVAÇÕES DA CONDUTA");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.conduta}"), jTextArea1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(jTextArea1);

        jTabbedPane2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable1.setToolTipText("ESTOQUES RETIRADOS");
        jTable1.setEnabled(false);
        jTable1.setMaximumSize(new java.awt.Dimension(200, 200));
        jTable1.setMinimumSize(new java.awt.Dimension(100, 100));

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedElement.estoque}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, eLProperty, jTable1);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${medicamento}"));
        columnBinding.setColumnName("Medicamento");
        columnBinding.setColumnClass(model.Medicamento.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lote}"));
        columnBinding.setColumnName("Lote");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dataValidade}"));
        columnBinding.setColumnName("Data Validade");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable1.addMouseListener(formListener);
        jTable1.addKeyListener(formListener);
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        estoqueidestoqueLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        estoqueidestoqueLabel.setText("Medicamento do Estoque:");

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jTextField4.setEditable(false);
        jTextField4.setColumns(20);
        jTextField4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField4.setRows(5);
        jTextField4.setToolTipText("CLIQUE DUAS VEZES PARA ADICIONAR UM MEDICAMENTO DO ESTOQUE");
        jTextField4.addMouseListener(formListener);
        jTextField4.addKeyListener(formListener);
        jScrollPane5.setViewportView(jTextField4);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_down_right_308966.png"))); // NOI18N
        jButton1.addActionListener(formListener);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jButton5.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton5.setText("+");
        jButton5.addActionListener(formListener);

        quantRetiradaField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        quantRetiradaField.setToolTipText("QUANTIDADE A SER RETIRADA DO ESTOQUE EM UNIDADES DE COMPRIMIDOS");
        quantRetiradaField.addKeyListener(formListener);

        jButton4.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton4.setText("-");
        jButton4.addActionListener(formListener);

        quantRetiradaLabel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        quantRetiradaLabel.setText("Baixa no Estoque");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(quantRetiradaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantRetiradaField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(quantRetiradaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(quantRetiradaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));

        quantRetiradaField6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        quantRetiradaField6.setToolTipText("QUANTIDADE A SER RETIRADA DO ESTOQUE EM UNIDADES DE COMPRIMIDOS");

        quantRetiradaLabel6.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        quantRetiradaLabel6.setText("Ñ/ Baixa no Estoque");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(quantRetiradaLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(quantRetiradaField6))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(quantRetiradaLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                .addComponent(quantRetiradaField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quant"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setEnabled(false);
        jScrollPane7.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(estoqueidestoqueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(estoqueidestoqueLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("MEDICAMENTO", jPanel6);

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jRadioButton1.setText("CONSULTA MÉDICA LOCAL");
        jRadioButton1.setToolTipText("ENCAMINHOU O PACIENTE PARA UMA CONSULTA COM A MÉDICA");
        jRadioButton1.addActionListener(formListener);

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jRadioButton2.setText("PRONTO ATENDIMENTO OURO FINO");
        jRadioButton2.setToolTipText("ENCAMINHOU O PACIENTE PARA O  PRONTO ATENDIMENTO OURO FINO");
        jRadioButton2.addActionListener(formListener);

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jRadioButton3.setText("POSTO DE SAÚDE EM INCONFIDENTES");
        jRadioButton3.setToolTipText("ENCAMINHOU O PACIENTE PARA  O POSTO DE INCONFIDENTES");
        jRadioButton3.addActionListener(formListener);

        jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jRadioButton4.setText("POUSO ALEGRE");
        jRadioButton4.setToolTipText("ENCAMINHOU O PACIENTE PARA POUSO ALEGRE");
        jRadioButton4.addActionListener(formListener);

        jRadioButton7.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Cambria", 2, 14)); // NOI18N
        jRadioButton7.setText("OUTROS: ");
        jRadioButton7.addActionListener(formListener);

        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField1.setToolTipText("OUTROS ENCAMINHAMENTOS");
        jTextField1.addKeyListener(formListener);

        jRadioButton5.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton5.setText("SEM ENCAMINHAMENTO");
        jRadioButton5.setToolTipText("ENCAMINHOU O PACIENTE PARA UMA CONSULTA COM A MÉDICA");
        jRadioButton5.addActionListener(formListener);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jRadioButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1))
                    .addComponent(jRadioButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jRadioButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("ENCAMINHAMENTO", jPanel7);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(condutaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(condutaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Conduta", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.KeyListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == refreshButton) {
                JFrmAtendimento.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == saveButton) {
                JFrmAtendimento.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                JFrmAtendimento.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == jButton3) {
                JFrmAtendimento.this.jButton3ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton2) {
                JFrmAtendimento.this.jButton2ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton7) {
                JFrmAtendimento.this.jButton7ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton6) {
                JFrmAtendimento.this.jButton6ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton1) {
                JFrmAtendimento.this.jButton1ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton5) {
                JFrmAtendimento.this.jButton5ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton4) {
                JFrmAtendimento.this.jButton4ActionPerformed(evt);
            }
            else if (evt.getSource() == jRadioButton1) {
                JFrmAtendimento.this.jRadioButton1ActionPerformed(evt);
            }
            else if (evt.getSource() == jRadioButton2) {
                JFrmAtendimento.this.jRadioButton2ActionPerformed(evt);
            }
            else if (evt.getSource() == jRadioButton3) {
                JFrmAtendimento.this.jRadioButton3ActionPerformed(evt);
            }
            else if (evt.getSource() == jRadioButton4) {
                JFrmAtendimento.this.jRadioButton4ActionPerformed(evt);
            }
            else if (evt.getSource() == jRadioButton7) {
                JFrmAtendimento.this.jRadioButton7ActionPerformed(evt);
            }
            else if (evt.getSource() == jRadioButton5) {
                JFrmAtendimento.this.jRadioButton5ActionPerformed(evt);
            }
        }

        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == jTextField5) {
                JFrmAtendimento.this.jTextField5KeyPressed(evt);
            }
            else if (evt.getSource() == jTable2) {
                JFrmAtendimento.this.jTable2KeyPressed(evt);
            }
            else if (evt.getSource() == jTable1) {
                JFrmAtendimento.this.jTable1KeyPressed(evt);
            }
            else if (evt.getSource() == jTextField4) {
                JFrmAtendimento.this.jTextField4KeyPressed(evt);
            }
        }

        public void keyReleased(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == masterTable) {
                JFrmAtendimento.this.masterTableKeyReleased(evt);
            }
            else if (evt.getSource() == jTable1) {
                JFrmAtendimento.this.jTable1KeyReleased(evt);
            }
            else if (evt.getSource() == quantRetiradaField) {
                JFrmAtendimento.this.quantRetiradaFieldKeyReleased(evt);
            }
            else if (evt.getSource() == jTextField1) {
                JFrmAtendimento.this.jTextField1KeyReleased(evt);
            }
        }

        public void keyTyped(java.awt.event.KeyEvent evt) {
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                JFrmAtendimento.this.masterTableMouseClicked(evt);
            }
            else if (evt.getSource() == jTextField5) {
                JFrmAtendimento.this.jTextField5MouseClicked(evt);
            }
            else if (evt.getSource() == jTextField3) {
                JFrmAtendimento.this.jTextField3MouseClicked(evt);
            }
            else if (evt.getSource() == jTable1) {
                JFrmAtendimento.this.jTable1MouseClicked(evt);
            }
            else if (evt.getSource() == jTextField4) {
                JFrmAtendimento.this.jTextField4MouseClicked(evt);
            }
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == jTextField5) {
                JFrmAtendimento.this.jTextField5MouseEntered(evt);
            }
            else if (evt.getSource() == jTextField3) {
                JFrmAtendimento.this.jTextField3MouseEntered(evt);
            }
            else if (evt.getSource() == jTextField4) {
                JFrmAtendimento.this.jTextField4MouseEntered(evt);
            }
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == jTextField5) {
                JFrmAtendimento.this.jTextField5MouseExited(evt);
            }
            else if (evt.getSource() == jTextField3) {
                JFrmAtendimento.this.jTextField3MouseExited(evt);
            }
            else if (evt.getSource() == jTextField4) {
                JFrmAtendimento.this.jTextField4MouseExited(evt);
            }
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                JFrmAtendimento.this.masterTableMousePressed(evt);
            }
            else if (evt.getSource() == jTable1) {
                JFrmAtendimento.this.jTable1MousePressed(evt);
            }
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                JFrmAtendimento.this.masterTableMouseReleased(evt);
            }
            else if (evt.getSource() == jTable1) {
                JFrmAtendimento.this.jTable1MouseReleased(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed

        jf.dispose();//fecha o frame
    }//GEN-LAST:event_refreshButtonActionPerformed
    public void enabledFalse() {
        jButton6.setEnabled(false);
        jButton3.setEnabled(false);
        jButton2.setEnabled(false);
        jTable2.setEnabled(false);
        jTextArea2.setEditable(false);
        jButton1.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jTable1.setEnabled(false);
        jTextArea1.setEditable(false);
        jRadioButton5.setEnabled(false);
        jRadioButton1.setEnabled(false);
        jRadioButton3.setEnabled(false);
        jRadioButton2.setEnabled(false);
        jRadioButton4.setEnabled(false);
        jRadioButton7.setEnabled(false);
        jFormattedTextField2.setEditable(false);
        jFormattedTextField3.setEditable(false);
        jFormattedTextField1.setEditable(false);
        saveButton.setEnabled(false);
        quantRetiradaField.setEditable(false);
        jButton7.setEnabled(false);
    }

    public void enabledtrue() {
        jButton6.setEnabled(true);
        jButton3.setEnabled(true);
        jButton2.setEnabled(true);
        jTable2.setEnabled(true);
        jTextArea2.setEditable(true);
        jButton1.setEnabled(true);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        jTable1.setEnabled(true);
        jTextArea1.setEditable(true);
        jRadioButton5.setEnabled(true);
        jRadioButton1.setEnabled(true);
        jRadioButton3.setEnabled(true);
        jRadioButton2.setEnabled(true);
        jRadioButton4.setEnabled(true);
        jRadioButton7.setEnabled(true);
        jFormattedTextField2.setEditable(true);
        jFormattedTextField3.setEditable(true);
        jFormattedTextField1.setEditable(true);
        saveButton.setEnabled(true);
        quantRetiradaField.setEditable(true);
        jButton7.setEnabled(true);
    }

    private void diadeHoje() {
        //pega o dia, mes, ano , minut, hora atual
        int da, ma, aa, ha, mia;
        String daSt, maSt, hSt, miSt;
        Calendar hoje = Calendar.getInstance();
        da = hoje.get(Calendar.DAY_OF_MONTH);
        ma = hoje.get(Calendar.MONTH) + 1;
        aa = hoje.get(Calendar.YEAR);
        ha = hoje.get(Calendar.HOUR_OF_DAY);
        mia = hoje.get(Calendar.MINUTE);
        //se o numero for de 0 até 9, adiciona um 0 a String
        if (da < 10) {
            daSt = "0" + String.valueOf(da);
        } else {
            daSt = String.valueOf(da);
        }
        if (ma < 10) {
            maSt = "0" + String.valueOf(ma);
        } else {
            maSt = String.valueOf(ma);
        }
        if (ha < 10) {
            hSt = "0" + String.valueOf(ha);
        } else {
            hSt = String.valueOf(ha);
        }
        if (mia < 10) {
            miSt = "0" + String.valueOf(mia);
        } else {
            miSt = String.valueOf(mia);
        }
        diaAtual = (String.valueOf(daSt + maSt + aa));//concatena a data atual
        horaAtual = (hSt + miSt);//concatena a hora atual
        horaAtualSaida = (hSt + ":" + miSt);//concatena a hora de saida
    }
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        System.out.println(testesValida);
        if (testesValida == true) {//verifica conexao
            editar = false;
            query = entityManager.createQuery("select a from Atendimento a");
            list.clear();//limpa a lista
            list.addAll(query.getResultList());
            jTabbedPane1.setSelectedIndex(1);
            jPanel5.setVisible(false);
            enabledtrue();
            DefaultTableModel val = (DefaultTableModel) jTable3.getModel();
            while (jTable3.getRowCount() > 0) {//se tiver alguma linha na tabela de quantidade, remove
                val.removeRow(0);
            }
            model.Atendimento a = new model.Atendimento();//adiciona um novo atendimento ao objeto a
            entityManager.persist(a);//as consultas serão realizadas apartir deste novo atendimento
            list.add(a);//adiciona um novo atendimento a lista
            int row = list.size() - 1;//seta a linha da tabela no atributo row
            masterTable.setRowSelectionInterval(row, row);//seta a linha selecionada pelo atributo row
            masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
            quantRetiradaField.setText("0");
            diadeHoje();//verifica o instate atual
            jFormattedTextField2.setText(horaAtual);//seta hora atual
            jFormattedTextField1.setText(diaAtual);// seta dia tual
            a.setHora(jFormattedTextField2.getText());
            a.setAtendente(at);
            int index = masterTable.getSelectedRow();//linha selecionada
            list.get(index).setAluno(al);//seta o aluno do frame anterior no Aluno do Atendimento
            if (jComboBox1.getSelectedItem().toString().length() > 55) {
                String nomeMenor = jComboBox1.getSelectedItem().toString().substring(0, 55);
                jTextField2.setText(nomeMenor + " ...");
            } else {
                jTextField2.setText(jComboBox1.getSelectedItem().toString());//seta o texto do jComboBox1 que está vinculado com a classe Aluno
            }
            jComboBox2.setSelectedIndex(-1);//seta nenhum item no jComboBox2
            jTable1.setSelectionMode(0);//permite apenas a seleção de uma linha da tabela
            jTable2.setSelectionMode(0);//permite apenas a seleção de uma linha da tabela
            jRadioButton5.setSelected(true);//seleciona inicialmete o jRadioButton5
            if (masterTable.getSelectedRow() == 0) {
                //o primeiro atendimento do banco de dados acontece um erro no programa onde as enfermidades 
                //adicionadas a lista não aparecem para a visualização,
                //assim, caso seja o primeiro atendimento do banco de dados, ele salva o atual vazio e cria outro , pois aparir
                //do segundo atendimento esse erro não acontece
                primeiroAtendimento();
                newButton.doClick();
                int index2 = masterTable.getSelectedRow();//linha selecionada
                list.get(index2).setAluno(al);//add aluno
                if (jComboBox1.getSelectedItem().toString().length() > 55) {
                    String nomeMenor = jComboBox1.getSelectedItem().toString().substring(0, 55);
                    jTextField2.setText(nomeMenor + " ...");
                } else {
                    jTextField2.setText(jComboBox1.getSelectedItem().toString());//seta o texto do jComboBox1 que está vinculado com a classe Aluno
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_newButtonActionPerformed

    public void setEncaminhamento() {
        //método para setaroEncaminhamento dependendo do jRadioButton selecionado pelo usuario
        int index = masterTable.getSelectedRow();
        if (index >= 0) {
            Atendimento a = list.get(index);
            if (jRadioButton1.isSelected()) {//se estiver selecionado que o seu texto
                a.setEncaminhamento(jRadioButton1.getText());
            } else if (jRadioButton2.isSelected()) {//se estiver selecionado que o seu texto
                a.setEncaminhamento(jRadioButton2.getText());
            } else if (jRadioButton3.isSelected()) {//se estiver selecionado que o seu texto
                a.setEncaminhamento(jRadioButton3.getText());
            } else if (jRadioButton4.isSelected()) {//se estiver selecionado que o seu texto
                a.setEncaminhamento(jRadioButton4.getText());
            } else if (jRadioButton5.isSelected()) {////se estiver selecionado não pega nehum texto
                a.setEncaminhamento("");
            } else {//pega o texto do campo digitado
                a.setEncaminhamento(jTextField1.getText());
            }
        }

    }

    public void setSemobservacoes() {
        if (jTextArea2.getText().equals("")) {//se for vazio seta o texto Sem Observações
            jTextArea2.setText("Sem Observações");
        } else {

        }
        if (jTextArea1.getText().equals("")) {//se for vazio seta o texto Sem Observações

            jTextArea1.setText("Sem Observações");
        } else {

        }
    }

    public void validaSalvar() {
        checagemObrigatoria = true;
        int ls = masterTable.getSelectedRow();//pega a linha selecionada
        Atendimento a = list.get(ls);
        int anoAtual, mesAtual, diaAAtual, dia = 0, mes = 0, ano = 0, hora = 0, minuto = 0, horaSaida = 0, minutoSaida = 0;

        String dataString = jFormattedTextField1.getText(),
                diaStr = dataString.substring(0, 2),//pega o dia da data
                mesStr = dataString.substring(3, 5),//pega o mes da data
                anoStr = dataString.substring(6, 10),//pega o ano da data
                horaStr = jFormattedTextField2.getText().substring(0, 2),//pega a hora da hora de entrada
                minutoStr = jFormattedTextField2.getText().substring(3, 5),//pega o menuto da hora de entrada
                horaSaidaStr = jFormattedTextField3.getText().substring(0, 2),//pega a hora da hora se saida
                minutoSaidaStr = jFormattedTextField3.getText().substring(3, 5);// pega o minuto da hora de saida

        Calendar hoje = Calendar.getInstance();//instante atual
        anoAtual = hoje.get(Calendar.YEAR);//ano atual
        mesAtual = hoje.get(Calendar.MONTH) + 1;//mes atual
        diaAAtual = hoje.get(Calendar.DAY_OF_MONTH);//dia atual

        //transforma as strings em inteiros para as demais contas
        if (!diaStr.equals("  ")) {
            dia = Integer.parseInt(diaStr);
        }
        if (!mesStr.equals("  ")) {
            mes = Integer.parseInt(mesStr);
        }
        if (!anoStr.equals("    ")) {
            ano = Integer.parseInt(anoStr);
        }

        if (!horaStr.equals("  ")) {
            hora = Integer.parseInt(horaStr);
        }
        if (!minutoStr.equals("  ")) {
            minuto = Integer.parseInt(minutoStr);
        }
        if (!horaSaidaStr.equals("  ")) {
            horaSaida = Integer.parseInt(horaSaidaStr);
        }
        if (!minutoSaidaStr.equals("  ")) {
            minutoSaida = Integer.parseInt(minutoSaidaStr);
        }

        if (jTextField2.getText().equals("")) {//verificação de preenchimeto do paciente
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO SELECIONAR UM PACIENTE!\n";
        }
        if (jTextField3.getText().equals("")) {//verificação de preenchimeto do ATENDENTE
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO PREENCHER O CAMPO ATENDENTE!\n";
            jTabbedPane1.setSelectedIndex(1);
            jTextField3.setBackground(Color.red);
        }

        if (jFormattedTextField2.getText().charAt(0) == ' ') {//verificação de preenchimeto dO CAMPO HORA DE ENTRADA
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO PREENCHER O CAMPO HORA DE ENTRADA!\n";
        } else if ((hora < 0) || (hora > 23) || (minuto < 0) || (minuto > 59)) {//validação de hora
            checagemObrigatoria = false;
            mensagemErro += "HORA DE ENTRADA INVALIDA!\n";
        }
        if (jFormattedTextField3.getText().charAt(0) != ' ') {//validação de hora
            if (((horaSaida < 0) || (horaSaida > 23) || (minutoSaida < 0) || (minutoSaida > 59))) {
                checagemObrigatoria = false;
                mensagemErro += "HORA DE SAÍDA INVALIDA!\n";
            } else if ((horaSaida < hora) || ((minutoSaida < minuto) && (horaSaida <= hora))) {//validação de hora
                checagemObrigatoria = false;
                mensagemErro += "HORA DE SAÍDA INVALIDA (HORA DE SAIDA DEVE SER MAIOR QUE  HORA DE ENTRADA)!\n";
            }
        }
        if (jFormattedTextField1.getText().charAt(0) == ' ') {//verificação de preenchimeto dO CAMPO DATA DE ATENDIMENTO
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO PREENCHER O CAMPO DATA DE ATENDIMENTO!\n";
        } else if ((mes < 1) || (mes > 12) || (dia < 1) || (dia > 31) || (((mes == 4) || (mes == 6) || (mes == 9) || (mes == 11)) && (dia > 30)) || ((mes == 2) && (((dia > 28) && (ano % 4 != 0)) || (((dia > 29) && (((ano % 4 == 0) && (ano % 100 != 0)) || (ano % 400 == 0)))))) || (ano < 1900)) {
            checagemObrigatoria = false;
            mensagemErro += "DATA DE ATENDIMENTO INVALIDA! \n";//validação de data
        } else if ((ano > anoAtual) || ((mes > mesAtual) && (ano >= anoAtual)) || ((dia > diaAAtual) && (mes >= mesAtual) && (ano >= anoAtual))) {
            checagemObrigatoria = false;
            mensagemErro += "DATA DE ATENDIMENTO INVALIDA (DATA MAIOR QUE O DIA ATUAL)! \n";//validação de data
        }
        if (jTextArea2.getText().length() > 300) {
            checagemObrigatoria = false;//limite de preenchimeto
            mensagemErro += "♦LIMITE DE 300 CARACTERES NO CAMPO Anotações da Enfermagem, QUANTIDADE DIGITADA: " + jTextArea2.getText().length() + " !\n";
        }
        if (jTextArea1.getText().length() > 300) {
            checagemObrigatoria = false;//limite de preenchimeto
            mensagemErro += "♦LIMITE DE 300 CARACTERES NO CAMPO Anotações da Enfermagem (Conduta), QUANTIDADE DIGITADA: " + jTextArea1.getText().length() + " !\n";
        }
        if (jTextField1.getText().length() > 30) {
            checagemObrigatoria = false;//limite de preenchimeto
            mensagemErro += "♦LIMITE DE 30 CARACTERES NO CAMPO Outros, QUANTIDADE DIGITADA: " + jTextField1.getText().length() + " !\n";
        }

    }

    public void check_n_Obrigatoria() {
        int ls = masterTable.getSelectedRow();
        Atendimento a = list.get(ls);
        checagem_nao_Obrigatoria = true;
        if (jFormattedTextField3.getText().charAt(0) == ' ') {
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (Hora de Saída) NÃO PREENCHIDO!\n";//aviso de não preenchimento
        }
        if (list.get(ls).getEnfermidades().size() <= 0) {
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "Nenhuma Enfermidade Selecionada! \n";//aviso de não preenchimento
        }
        if (jTextArea2.getText().equals("")) {
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (Anotações da Enfermagem) NÃO PREENCHIDO!\n";//aviso de não preenchimento

        }
        if (list.get(ls).getEstoque().size() <= 0) {
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "Nenhum Medicamento Retirado do Estoque! \n";//aviso de não preenchimento
        }
        if (jTextArea1.getText().equals("")) {
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (Anotações da Enfermagem (Conduta)) NÃO PREENCHIDO!\n";//aviso de não preenchimento
        }
        if (a.getEncaminhamento().equals("")) {
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "Nenhum Encaminhamento Selecionado!\n";//aviso de não preenchimento
        }

    }
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        System.out.println(testesValida);
        if (testesValida == true) {//verifica conexão
            setEncaminhamento();
            validaSalvar();//validacao obrigatoria
            check_n_Obrigatoria();//validação não obrigatória
            int cont = 0;
            if (checagem_nao_Obrigatoria == false) {
                cont = JOptionPane.showConfirmDialog(null, "ATENÇÃO:\n\n" + mensagemErro_nao_Obrigatoria + "\nDESEJA MESMO SALVAR SEM ESSE(s) REGISTRO(s)?", "ATENÇÃO!!", JOptionPane.YES_NO_OPTION);
            } else {
                cont = 0;
            }
            if (cont == 0) {
                if (checagemObrigatoria == true) {
                    try {

                        setSemobservacoes();
                        Atendimento atendi = list.get(masterTable.getSelectedRow());
                        String dataString = jFormattedTextField1.getText();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        Date data;
                        String dia = dataString.substring(0, 2), mes = dataString.substring(3, 5), ano = dataString.substring(6, 10);
                        try {//transforma a data de string para Date
                            data = format.parse(ano + "-" + mes + "-" + dia);
                            int index = masterTable.getSelectedRow();
                            list.get(index).setDataAtendimento(data);
                        } catch (ParseException ex) {
                            Logger.getLogger(JFrmAtendimento.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        entityManager.getTransaction().commit();//salva
                        entityManager.getTransaction().begin();
                        jPanel3.setVisible(false);
                        jPanel6.setVisible(false);
                        jTextField2.setText(null);
                        jf.dispose();//fecha
                        JOptionPane.showMessageDialog(null, "SALVO COM SUCESSO");
                        //registra na no banco as ações feitas pelo usuario
                        new Sessao(list.get(masterTable.getSelectedRow()).getAtendente());
                        util.Logger.log(Sessao.getAtendenteLogado(), al, "NOVO ATENDIMENTO: Paciente: " + al.getNome()
                                + " ID: " + al.getIdAluno()
                                + " Hora: " + atendi.getHora()
                                + " Hora Saida: " + atendi.getHoraSaida()
                                + " Data Atendimento: " + atendi.getDataAtendimento().toString()
                                + " Queixas: " + atendi.getQueixa()
                                + " Conduta: " + atendi.getConduta()
                                + " Encaminhamento: " + atendi.getEncaminhamento(), Tabelas.ATENDIMENTO);

                    } catch (RollbackException rex) {//erro ao salvar
                        JOptionPane.showMessageDialog(null, "ERRO AO SALVAR!!Feche o Programa e verifique a conexão com a internet!!", "ERRO", JOptionPane.ERROR_MESSAGE);
                        rex.printStackTrace();
                        entityManager.getTransaction().begin();
                        List<model.Atendimento> merged = new ArrayList<model.Atendimento>(list.size());
                        for (model.Atendimento a : list) {
                            merged.add(entityManager.merge(a));
                        }
                        list.clear();
                        list.addAll(merged);
                    }
                    refreshButton.doClick();
                } else {//validacoes obrigatorias mensagens
                    JOptionPane.showMessageDialog(null, "ERRO:\n\n" + mensagemErro, "ERRO!", JOptionPane.ERROR_MESSAGE);

                }
                mensagemErro = "";
                mensagemErro_nao_Obrigatoria = "";
            } else {
                mensagemErro = "";
                mensagemErro_nao_Obrigatoria = "";
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Set<Estoque> mySet = new HashSet<Estoque>();
        int index = masterTable.getSelectedRow();
        boolean b = false;
        for (int i = 0; i < quantRetiradaField6.getText().length(); i++) {
            if (quantRetiradaField6.getText().substring(i, i + 1).equals("-")) {
                b = true;
            } else {
                b = false;
            }
        }
        if (b == false) {
            if (!jTextField4.getText().equals("")) {//se tiver algum estoque selecionado
                if (index >= 0) {
                    if (quantRetiradaField.getText().equals("")) {//se não tiver nehum textto seta 0
                        quantRetiradaField.setText("0");
                    }
                    if (quantRetiradaField6.getText().equals("")) {//se não tiver nehum textto seta 0
                        quantRetiradaField6.setText("0");
                    }
                    if (quantRetiradaField.getText().matches("[0-9]*")) {//se for apenas numeros

                        if (quantRetiradaField.getText().length() <= 9) {//se o valor não for muito grande para um numero do tipo inteiro

                            Atendimento a = list.get(index);
                            Estoque estoque = (Estoque) jComboBox3.getSelectedItem();//estoque selecionado
                            Medicamento m = estoque.getMedicamento();//medicamneto do estoque

                            int quantNova = Integer.parseInt(quantRetiradaField.getText());//quantidade a se retirar
                            int quantAntiga = estoque.getQuantAtual();//quantidade antiga do estoque
                            int quantTotalAntiga = m.getQuantTotal();//quantidade antiga do medicamento
                            int quantTotalSub = 0;
                            int quantSub = 0;
                            int quantAntigaEstoque = quantAntiga;
                            int quantAntigaMedicamento = quantTotalAntiga;

                            if (quantNova > quantAntiga) {//se a quantidade a retirar for maior que a quantidade atual do estoque
                                JOptionPane.showMessageDialog(null, "ERRO AO RETIRAR, QUANTIDADE RETIRADA ACIMA DA QUANTIDADE DESTE ESTOQUE, QUANTIDADE DESTE ESTOQUE = " + quantAntiga, "ERRO", JOptionPane.ERROR_MESSAGE);
                            } else {
                                if ((m.getTipo().equals("Comprimido")) && (quantNova < 0)) {//se for comprimido é obrigatório retirar a quantidade
                                    JOptionPane.showMessageDialog(null, " QUANTIDADE RETIRADA INVALIDA, VALOR MENOR OU IGUAL A ZERO", "ERRO", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    a.getEstoque().add(estoque);//adiciona o novo estoque selecionado a lista de estoque
                                    mySet.addAll(a.getEstoque());//adiciona o novo estoque selecionado a lista de mySqt que elimina elementos iguais
                                    System.out.println("MySet: " + mySet.size());
                                    System.out.println("lista: " + a.getEstoque().size());
                                    if (mySet.size() == a.getEstoque().size()) {//se o tamanho das dua listas forem iguais é porque o estoque adicionado ainda não foi adicionado a lista de estoques
                                        a.getEstoque().clear();
                                        a.getEstoque().addAll(mySet);
                                        estoque.getAtendimentos().add(a);
                                        quantSub = quantAntiga - quantNova;//caucula a nova quantidade do estoque
                                        quantTotalSub = quantTotalAntiga - quantNova;//caucula a nova quantidade do medicamento
                                        estoque.setQuantAntiga(quantAntigaEstoque);//seta a quantidade antiga do estoque para que se o usuraio queira cancelar a seleção do medicamento, a quantidade possa voltar para a quantidade inicial sem modificações
                                        m.setQuant_Antiga(quantAntigaMedicamento); //seta a quantidade antiga do medicamneto para que se o usuraio queira cancelar a seleção do medicamento, a quantidade possa voltar para a quantidade inicial sem modificações
                                        estoque.setQuantAtual(quantSub);//seta a nova quantidade do estoque após a subtração
                                        m.setQuantTotal(quantTotalSub);//seta a nova quantidade do medicamento após a subtração

                                        DefaultTableModel val = (DefaultTableModel) jTable3.getModel();
                                        while (jTable3.getRowCount() > 0) {//se tiver alguma linha na tabela de quantidade remove e deixa a tabela vazia
                                            val.removeRow(0);
                                        }
                                        //seta no campo quantRetirada do novo estoque a quantRetirada digitada pelo usuario mais um traço ex: 10ml -
                                        estoque.setQuantRetirada(quantRetiradaField6.getText() + " -");
                                        int linhas = jTable1.getRowCount();//numero de linhas da tabela de estoques
                                        texto = "";//seta o texto de quantRetirada do atendimento anterior nulo ex: "10 -20 -2ml -" -> ""
                                        for (int i = 0; i < linhas; i++) {
                                            //for que passa em todas as linhas da tabela de estoque, pega a quantidade retirada daquele estoque
                                            //e junta tudo no campo quantRetirada do Atendimento ex: primeira vez: "10 -", segunda vez: "10- 20 -",
                                            //até acabar as linhas da tabela, além disso adiciona na tabela de quantidade a quantidade retirada do estoque 
                                            //que o for está passando
                                            texto += list.get(index).getEstoque().get(i).getQuantRetirada();
                                            list.get(index).setQuantRetirada(texto);
                                            System.out.println("Quant Retirada: " + texto);
                                            val.addRow(new String[]{list.get(index).getEstoque().get(i).getQuantRetirada().replaceAll(" -", "")});
                                        }

                                    } else {// se o tamenho entre as duas listas for diferente é porque o estoque selecionado já foi adicionado
                                        a.getEstoque().clear();
                                        a.getEstoque().addAll(mySet);
                                        estoque.getAtendimentos().add(a);
                                        JOptionPane.showMessageDialog(null, "ESTE ESTOQUE JA FOI ADICIONADO!!!", "ERRO", JOptionPane.ERROR_MESSAGE);

                                    }
                                }

                            }
                            jTextField4.setText("");
                            jComboBox3.setSelectedItem(-1);
                            masterTable.setRowSelectionInterval(0, 0);
                            masterTable.setRowSelectionInterval(index, index);
                            quantRetiradaField.setText("");
                            quantRetiradaField6.setText("");
                        } else {//caso o valor digitado seja muito grande
                            JOptionPane.showMessageDialog(null, "LIMITE DE 9 CARACTERES NO CAMPO QUANTIDADE RETIRADA!!", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {//caso tenha um caractere não numérico
                        JOptionPane.showMessageDialog(null, "CARACTERE NÃO NUMÉRIO NO CAMPO QUANTIDADE RETIRADA!!", "ERRO", JOptionPane.ERROR_MESSAGE);
                    }

                }
            } else {//caso o usuário não tenha selecionado nenhum medicamento
                JOptionPane.showMessageDialog(null, "SELECIONE UM MEDICAMENTO DO ESTOQUE!!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Set<Enfermidade> mySet = new HashSet<Enfermidade>();
        int index = masterTable.getSelectedRow();
        if (!jTextField5.getText().equals("")) {

            if (index >= 0 && jComboBox2.getSelectedIndex() != -1) {
                Atendimento a = list.get(index);
                Enfermidade enfermidade = (Enfermidade) jComboBox2.getSelectedItem();//enfermidade selecionada
                //add
                a.getEnfermidades().add(enfermidade);//adiciona a nova enfermidade selecionada a lista de enfermidades que matem elemento repetidos
                mySet.addAll(a.getEnfermidades());//adiciona o nova enfermidade selecionada a lista de mySqt que elimina elementos iguais
                if (mySet.size() == a.getEnfermidades().size()) {//se o tamanho das duas listas forem iguais é porque a enfermidade adicionada ainda não foi adicionado a lista de enfermidade
                    a.getEnfermidades().clear();//limpa a lista 
                    a.getEnfermidades().addAll(mySet);//adiciona a nova lista
                    enfermidade.getAtendimentos().add(a);//adiociona o atendimento a classe enfermidades
                } else {// se o tamenho entre as duas listas for diferente é porque a enfermidade selecionada já foi adicionada
                    a.getEnfermidades().clear();//limpa a lista
                    a.getEnfermidades().addAll(mySet);//adiciona a nova lista
                    enfermidade.getAtendimentos().add(a);
                    JOptionPane.showMessageDialog(null, "ESTA ENFERMIDADE JA FOI ADICIONADA!!!", "ERRO", JOptionPane.ERROR_MESSAGE);

                }
                //gambi
                Collections.sort(a.getEnfermidades());//orde em ordem alfabética
                masterTable.setRowSelectionInterval(0, 0);
                masterTable.setRowSelectionInterval(index, index);
                jTextField5.setText("");
                jComboBox2.setSelectedIndex(-1);
            }
        } else {//caso o usuario não tenha selecionado nehuma enfermidade
            JOptionPane.showMessageDialog(null, "SELECIONE UMA ENFERMIDADE!!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //abre o frame de adionar nova enfermidade
        JDialog frame = new JDialog(new JFrame(), true);
        frame.add(new JFrmEnfermidade(frame, enfermidadeList));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("NOVA ENFERMIDADE");
        frame.setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed
    public void setDados() {
        //método para setar dados não vinculados com a masterTable assim que uma linha da mesma for selecionada
        if (masterTable.getSelectedRow() >= 0) {
            editar = true;
            enabledtrue();
            jTextField2.setText(list.get(masterTable.getSelectedRow()).getAluno().getNome());
            String encaminhamento = list.get(masterTable.getSelectedRow()).getEncaminhamento();
            if (encaminhamento.equals("")) {
                jRadioButton5.setSelected(true);
                jTextField1.setEnabled(false);
            } else if (encaminhamento.equals("CONSULTA MÉDICA LOCAL")) {
                jRadioButton1.setSelected(true);
                jTextField1.setEnabled(false);
            } else if (encaminhamento.equals("POSTO DE SAÚDE EM INCONFIDENTES")) {
                jRadioButton3.setSelected(true);
                jTextField1.setEnabled(false);
            } else if (encaminhamento.equals("PRONTO ATENDIMENTO OURO FINO")) {
                jRadioButton2.setSelected(true);
                jTextField1.setEnabled(false);
            } else if (encaminhamento.equals("POUSO ALEGRE")) {
                jRadioButton4.setSelected(true);
                jTextField1.setEnabled(false);
            } else {
                jRadioButton7.setSelected(true);
                jTextField1.setEnabled(true);
                jTextField1.setText(encaminhamento);
            }
            String dataAtendimento, dia, mes, ano;
            ano = list.get(masterTable.getSelectedRow()).getDataAtendimento().toString().substring(0, 4);
            mes = list.get(masterTable.getSelectedRow()).getDataAtendimento().toString().substring(5, 7);
            dia = list.get(masterTable.getSelectedRow()).getDataAtendimento().toString().substring(8, 10);
            dataAtendimento = dia + mes + ano;
            jFormattedTextField1.setText(dataAtendimento);
            if (list.get(masterTable.getSelectedRow()).getQueixa().equals("Sem Observações")) {
                jTextArea2.setText("");
            }
            if (list.get(masterTable.getSelectedRow()).getConduta().equals("Sem Observações")) {
                jTextArea1.setText("");
            }

        }
    }
    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
        if (masterTable.getSelectedRow() == 0) {
            enabledFalse();
            //primeira linah da tabela fica da cor branca para o usuario nao confundir
            masterTable.setSelectionBackground(Color.WHITE);
        } else {
            editar = true;
            int index = masterTable.getSelectedRow();
            int linhas = jTable1.getRowCount();
            DefaultTableModel val = (DefaultTableModel) jTable3.getModel();
            while (jTable3.getRowCount() > 0) {//se tiver alguma linha na tabela de quantidade, remove para que possa atualizar as a novas quantidades e não duplicar os dados
                val.removeRow(0);
            }
            if (linhas > 0) {
                String quantAtendimento = list.get(index).getQuantRetirada();
                System.out.println("Quant Atendimento Antiga: " + quantAtendimento);
                for (int i = 0; i < linhas; i++) {
                    //for que passa em todas as linhas da tabela de estoque, pega a quantidade retirada daquele estoque
                    //pegando todo o texto de quantRetirada até o primiro traço "-", então adiciona essa parte do texto ao estoque selecionado e
                    //remove em seguida para que o próximo estoque a passar pelo for pegue o o texto de quantRetirada até o primiro traço "-"
                    //no caso vai ser o segundo traço pois foi removido o pimeiro EX:
                    //quantRetirada do atendimento: 10 - 20- 30-
                    //primeira vez: estoque 1 pega (10- )
                    //quantRetirada do atendimento: 20- 30-
                    //primeira vez: estoque 2 pega (20- )
                    //quantRetirada do atendimento: 30-
                    //primeira vez: estoque 3 pega (30- )
                    int contador = quantAtendimento.length();
                    System.out.println("Contador:" + contador);
                    int posicao = 0;
                    String quant = null;
                    for (int j = 0; j < contador; j++) {
                        if (quantAtendimento.substring(j, j + 1).equals("-")) {
                            posicao = j + 1;
                            System.out.println("posicao:" + posicao);
                            quant = quantAtendimento.substring(0, posicao);
                            j = contador;
                        }
                    }
                    System.out.println(quant);
                    String aux = quantAtendimento.substring(posicao, quantAtendimento.length());
                    quantAtendimento = aux;
                    list.get(masterTable.getSelectedRow()).getEstoque().get(i).setQuantRetirada(quant);
                    val.addRow(new String[]{quant.replaceAll(" -", "")});
                }
            }
            masterTable.setSelectionBackground(new java.awt.Color(0, 120, 215));
            setDados();
        }
    }//GEN-LAST:event_masterTableMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int texto = 0;
        int quantAntiga = 0;
        int quantnova = 0;

        if (quantRetiradaField.getText().equals("")) {//se o texto for vazio, seta 0
            quantAntiga = 0;
        } else if (quantRetiradaField.getText().matches("[0-9]*")) {//se só tiver numeros
            if (quantRetiradaField.getText().length() <= 9) {//se o valor não for muito grande
                texto = Integer.parseInt(quantRetiradaField.getText());
                quantAntiga = texto;
                if (quantAntiga > 0) {//se o valor for maior que 0 diminui 1 no texto digitado
                    quantnova = quantAntiga - 1;
                    String quantStr = String.valueOf(quantnova);
                    quantRetiradaField.setText(quantStr);
                    quantRetiradaField6.setText(quantRetiradaField.getText());
                }

            }
        } else {//se tiver letras ou outros caracteres seta um texto vazio
            quantRetiradaField.setText("");
            quantRetiradaField6.setText("");
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int quantAntiga = 0;
        int quantnova = 0;
        if (quantRetiradaField.getText().equals("")) {//se o texto for vazio, seta 0
            quantAntiga = 0;
            quantnova = quantAntiga + 1;
            String quantStr = String.valueOf(quantnova);
            quantRetiradaField.setText(quantStr);
        } else if (quantRetiradaField.getText().matches("[0-9]*")) {//se só tiver numeros
            if (quantRetiradaField.getText().length() <= 9) {//se o valor não for muito grande
                //soma mais um ao texto digitado
                quantAntiga = Integer.parseInt(quantRetiradaField.getText());
                quantnova = quantAntiga + 1;
                String quantStr = String.valueOf(quantnova);
                quantRetiradaField.setText(quantStr);
                quantRetiradaField6.setText(quantRetiradaField.getText());
            }
        } else {//se tiver letras ou outros caracteres seta um texto vazio
            quantRetiradaField.setText("");
            quantRetiradaField6.setText("");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed

        jTextField1.setEnabled(true);
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        jTextField1.setEnabled(false);
        jTextField1.setText(null);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jTextField1.setEnabled(false);
        jTextField1.setText(null);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        jTextField1.setEnabled(false);
        jTextField1.setText(null);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jTextField1.setEnabled(false);
        jTextField1.setText(null);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed

        int ls = masterTable.getSelectedRow();
        int ls2 = jTable2.getSelectedRow();
        Atendimento a = list.get(ls);
        Enfermidade enfermidadeSelected = a.getEnfermidades().get(ls2);
        if (evt.getKeyCode() == 127) {//delete
            int cont = 1;
            cont = JOptionPane.showConfirmDialog(null, "DESEJA REMOVER A ENFERMIDADE " + enfermidadeSelected + " DA TABELA ?", "REMOVER?", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (cont == 0) {//se o usuario realmente quiser remover a enfermidade 
//remove
                a.getEnfermidades().remove(ls2);
                a.setEnfermidades(a.getEnfermidades());
                masterTable.setRowSelectionInterval(0, 0);
                masterTable.setRowSelectionInterval(ls, ls);
            }
        }
    }//GEN-LAST:event_jTable2KeyPressed

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        System.out.println(testesValida);
        if (testesValida == true) {//verifica conexao
            if (evt.getClickCount() == 2 && saveButton.isEnabled()) {
                //abre o frame de selecionar enfermidades para ser adicinadas a lista
                AddEnfermidade frm = new AddEnfermidade(new JFrame(), true);
                frm.setLocationRelativeTo(null);
                frm.setResizable(false);
                frm.setTitle("ENFERMIDADES");
                frm.setVisible(true);

                if (frm.isConfirmado()) {
                    Enfermidade e = frm.getEnfermidade();
                    jComboBox2.setSelectedItem(e);
                    jTextField5.setText(e.toString());
                } else {
                    jComboBox2.setSelectedItem(-1);
                    jTextField5.setText("");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseEntered
//mouse passu por cima
        if (saveButton.isEnabled()) {
            jTextField5.setBackground(new java.awt.Color(204, 204, 255));
        }
    }//GEN-LAST:event_jTextField5MouseEntered

    private void jTextField5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseExited
//mouse saiu de cima
        if (saveButton.isEnabled()) {
            jTextField5.setBackground(new java.awt.Color(250, 250, 250));
        }
    }//GEN-LAST:event_jTextField5MouseExited

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        if (evt.getKeyCode() == 10 && !jTextField5.getText().equals("")) {
            jButton2.doClick();
        }
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        System.out.println(testesValida);
        if (testesValida == true) {
            if (evt.getClickCount() == 2 && saveButton.isEnabled()) {
//abre o frame de selecionar estoques para ser adicinadas a lista
                AddEstoque frm = new AddEstoque(new JFrame(), true);
                frm.setLocationRelativeTo(null);
                frm.setResizable(false);
                frm.setTitle("ESTOQUE");
                frm.setVisible(true);

                if (frm.isConfirmado()) {
                    Estoque e = frm.getEstoque();
                    jComboBox3.setSelectedItem(e);
                    jTextField4.setText(e.toString() + ", Quant: (" + e.getQuantAtual() + ") ");
                    quantRetiradaField.setText("");
                    quantRetiradaField6.setText("");
                    String tipo = e.getMedicamento().getTipo();
                    //dependendo do tipo do estoque, abre o painel de dar baixa ou não do estoque
                    if (tipo.equals("Comprimido")) {//da baixa
                        jPanel9.setVisible(true);
                        jPanel22.setVisible(false);
                    } else if (tipo.equals("Frasco")) {//nao da baixa apenas salva a quantidade em String para a visualização em relatorios
                        jPanel9.setVisible(false);
                        jPanel22.setVisible(true);
                    } else if (tipo.equals("Ampola")) {//da baixa
                        jPanel9.setVisible(true);
                        jPanel22.setVisible(false);
                    } else if (tipo.equals("Bisnaga")) {//nao da baixa apenas salva a quantidade em String para a visualização em relatorios
                        jPanel9.setVisible(false);
                        jPanel22.setVisible(true);
                    } else {//nao da baixa apenas salva a quantidade em String para a visualização em relatorios
                        jPanel9.setVisible(false);
                        jPanel22.setVisible(true);
                    }

                } else {
                    jComboBox3.setSelectedItem(-1);
                    jTextField4.setText("");
                    quantRetiradaField.setText("");
                    quantRetiradaField6.setText("");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseEntered
        if (saveButton.isEnabled()) {
            jTextField4.setBackground(new java.awt.Color(204, 204, 255));
        }
    }//GEN-LAST:event_jTextField4MouseEntered

    private void jTextField4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseExited
        if (saveButton.isEnabled()) {
            jTextField4.setBackground(new java.awt.Color(250, 250, 250));
        }
    }//GEN-LAST:event_jTextField4MouseExited

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        if (evt.getKeyCode() == 10 && !jTextField4.getText().equals("")) {
            jButton1.doClick();
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed

        int ls = masterTable.getSelectedRow();
        int ls2 = jTable1.getSelectedRow();
        Atendimento a = list.get(ls);
        Estoque estoqueSelecionado = a.getEstoque().get(ls2);
        if (evt.getKeyCode() == 127 && editar == false) {
            int cont = 1;
            cont = JOptionPane.showConfirmDialog(null, "DESEJA REMOVER O MEDICAMENTO DO ESTOQUE : " + estoqueSelecionado.toString() + " DA TABELA ?", "REMOVER?", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (cont == 0) {//se o usuario realmente quiser remover o estoque adicionado a lista 

                Medicamento medicamento = estoqueSelecionado.getMedicamento();
                int quantidadeRetiradadoMedicamento = estoqueSelecionado.getQuantAntiga() - estoqueSelecionado.getQuantAtual();//quantidade retirada do medicamento
                int quantTotalAntiga = medicamento.getQuantTotal();//quantidade total antes de ser retirado
                int quantNova = quantTotalAntiga + quantidadeRetiradadoMedicamento;//volta a quantidade original do medicamento

                estoqueSelecionado.setQuantAtual(estoqueSelecionado.getQuantAntiga());//volta a quantidade original do estoque
                medicamento.setQuantTotal(quantNova);//seta a quantidade antiga
                a.getEstoque().remove(ls2);
                a.setEstoque(a.getEstoque());
                masterTable.setRowSelectionInterval(0, 0);
                masterTable.setRowSelectionInterval(ls, ls);
                int linhas = jTable1.getRowCount();
                System.out.println("Linhas: " + linhas);
                texto = "";
                System.out.println("Novo Texto: " + texto);
                DefaultTableModel val = (DefaultTableModel) jTable3.getModel();
                if (linhas == 0) {
                    System.out.println("0 Linhas");
                    texto = "";
                    list.get(ls).setQuantRetirada(texto);
                    while (jTable3.getRowCount() > 0) {
                        val.removeRow(0);
                    }
                } else {
                    while (jTable3.getRowCount() > 0) {
                        val.removeRow(0);
                    }
                    for (int i = 0; i < linhas; i++) {
                        //for que passa em todas as linhas da tabela de estoque, pega a quantidade retirada daquele estoque
                        //e atualiza tudo no campo quantRetirada do Atendimento ex: primeira vez: "10 -12 -", segunda vez: "10-" (o usuario removeu um estoque),
                        //até acabar as linhas da tabela, além disso adiciona na tabela de quantidade a quantidade retirada do estoque 
                        //que o for está passando
                        texto += list.get(ls).getEstoque().get(i).getQuantRetirada();
                        list.get(ls).setQuantRetirada(texto);
                        System.out.println("Quant Retirada: " + texto);
                        val.addRow(new String[]{list.get(masterTable.getSelectedRow()).getEstoque().get(i).getQuantRetirada().replaceAll(" -", "")});

                    }
                }
            }
        }
        if (evt.getKeyCode() == 127 && editar == true) {
            JOptionPane.showMessageDialog(null, "NÃO É POSSÍVEL REMOVER ESTOQUE DEPOIS DE SALVO!!", "ERRO", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        diadeHoje();
        int ls = masterTable.getSelectedRow();
        list.get(ls).setHoraSaida(horaAtualSaida);//seta a hora atual na hora de saida
    }//GEN-LAST:event_jButton6ActionPerformed

    private void quantRetiradaFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantRetiradaFieldKeyReleased
        //verifica se a ultima tecla digitada pelo usuario é um numero
        String digitos = "0123456789";
        String texto = quantRetiradaField.getText();
        boolean b = true;
        if (texto.equals("") || evt.getKeyCode() == 10) {
        } else {

            for (int i = 0; i < texto.length(); i++) {
                if (digitos.indexOf(texto.charAt(i)) == -1) {
                    b = false;
                } else {
                    quantRetiradaField6.setText(quantRetiradaField.getText());//seta no outro campo de texto tudo digitado neste,
                    //pois será o outro campo de texto o responsável por salvar em String a quantRetiraada, este campo apenas serve
                    //para dar baixa no estoque e fazer as contas
                    b = true;
                }
            }
        }
        if (b == false) {//se não aparece uma mensagem
            JOptionPane.showMessageDialog(null, "PREENCHA ESSE CAMPO APENAS COM NUMEROS", "ERRO", JOptionPane.ERROR_MESSAGE);
            quantRetiradaField.setText("");
            quantRetiradaField6.setText("");
        }
    }//GEN-LAST:event_quantRetiradaFieldKeyReleased

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        jTextField1.setEnabled(false);
        jTextField1.setText(null);
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        System.out.println(testesValida);
        if (testesValida == true) {
            if (evt.getClickCount() == 2 && saveButton.isEnabled()) {
                //abre o selecionador de atendentes
                Atendimento a = list.get(masterTable.getSelectedRow());
                a.setAtendente(null);
                JDialog frame = new JDialog(new JFrame(), true);
                frame.setContentPane(new JFrmAtendente(frame, a));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setTitle("Atendente");
                frame.setVisible(true);
                if (frame.isVisible()) {

                } else {
                    Atendente at = list.get(masterTable.getSelectedRow()).getAtendente();
                    if (at != null) {
                        if (at.getNome().length() > 55) {
                            jTextField3.setText(at.getNome().substring(0, 55) + " ...");
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseEntered
        if (saveButton.isEnabled()) {
            jTextField3.setBackground(new java.awt.Color(204, 204, 255));
        }
    }//GEN-LAST:event_jTextField3MouseEntered

    private void jTextField3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseExited
        if (saveButton.isEnabled()) {
            jTextField3.setBackground(new java.awt.Color(250, 250, 250));
        }
    }//GEN-LAST:event_jTextField3MouseExited

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        if (jTextField1.getText().length() > 30) {
            JOptionPane.showMessageDialog(null, "LIMITE DE CARACTERES", "ERRO", JOptionPane.ERROR_MESSAGE);
            jTextArea1.setText("");
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void masterTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMousePressed

        if (masterTable.getSelectedRow() > 0) {
            editar = true;
            int index = masterTable.getSelectedRow();
            int linhas = jTable1.getRowCount();
            DefaultTableModel val = (DefaultTableModel) jTable3.getModel();
            while (jTable3.getRowCount() > 0) {
                val.removeRow(0);
            }
            if (linhas > 0) {
                String quantAtendimento = list.get(index).getQuantRetirada();
                System.out.println("Quant Atendimento Antiga: " + quantAtendimento);
                for (int i = 0; i < linhas; i++) {
                    //for que passa em todas as linhas da tabela de estoque, pega a quantidade retirada daquele estoque
                    //pegando todo o texto de quantRetirada até o primiro traço "-", então adiciona essa parte do texto ao estoque selecionado e
                    //remove em seguida para que o próximo estoque a passar pelo for pegue o o texto de quantRetirada até o primiro traço "-"
                    //no caso vai ser o segundo traço pois foi removido o pimeiro EX:
                    //quantRetirada do atendimento: 10 - 20- 30-
                    //primeira vez: estoque 1 pega (10- )
                    //quantRetirada do atendimento: 20- 30-
                    //primeira vez: estoque 2 pega (20- )
                    //quantRetirada do atendimento: 30-
                    //primeira vez: estoque 3 pega (30- )
                    int contador = quantAtendimento.length();
                    System.out.println("Contador:" + contador);
                    int posicao = 0;
                    String quant = null;
                    for (int j = 0; j < contador; j++) {
                        if (quantAtendimento.substring(j, j + 1).equals("-")) {
                            posicao = j + 1;
                            System.out.println("posicao:" + posicao);
                            quant = quantAtendimento.substring(0, posicao);
                            j = contador;
                        }
                    }
                    System.out.println(quant);
                    String aux = quantAtendimento.substring(posicao, quantAtendimento.length());
                    quantAtendimento = aux;
                    list.get(masterTable.getSelectedRow()).getEstoque().get(i).setQuantRetirada(quant);
                    val.addRow(new String[]{quant.replaceAll(" -", "")});
                }
            }
            masterTable.setSelectionBackground(new java.awt.Color(0, 120, 215));
            setDados();
            if (evt.getClickCount() == 2) {
                jTabbedPane1.setSelectedIndex(1);
            }
        } else {
            enabledFalse();
            masterTable.setSelectionBackground(Color.WHITE);
        }
    }//GEN-LAST:event_masterTableMousePressed

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased
        if (masterTable.getSelectedRow() == 0) {
            enabledFalse();
            masterTable.setSelectionBackground(Color.WHITE);
        } else {
            editar = true;
            int index = masterTable.getSelectedRow();
            int linhas = jTable1.getRowCount();
            DefaultTableModel val = (DefaultTableModel) jTable3.getModel();
            while (jTable3.getRowCount() > 0) {
                val.removeRow(0);
            }
            if (linhas > 0) {
                String quantAtendimento = list.get(index).getQuantRetirada();
                System.out.println("Quant Atendimento Antiga: " + quantAtendimento);
                for (int i = 0; i < linhas; i++) {
                    //for que passa em todas as linhas da tabela de estoque, pega a quantidade retirada daquele estoque
                    //pegando todo o texto de quantRetirada até o primiro traço "-", então adiciona essa parte do texto ao estoque selecionado e
                    //remove em seguida para que o próximo estoque a passar pelo for pegue o o texto de quantRetirada até o primiro traço "-"
                    //no caso vai ser o segundo traço pois foi removido o pimeiro EX:
                    //quantRetirada do atendimento: 10 - 20- 30-
                    //primeira vez: estoque 1 pega (10- )
                    //quantRetirada do atendimento: 20- 30-
                    //primeira vez: estoque 2 pega (20- )
                    //quantRetirada do atendimento: 30-
                    //primeira vez: estoque 3 pega (30- )
                    int contador = quantAtendimento.length();
                    System.out.println("Contador:" + contador);
                    int posicao = 0;
                    String quant = null;
                    for (int j = 0; j < contador; j++) {
                        if (quantAtendimento.substring(j, j + 1).equals("-")) {
                            posicao = j + 1;
                            System.out.println("posicao:" + posicao);
                            quant = quantAtendimento.substring(0, posicao);
                            j = contador;
                        }
                    }
                    System.out.println(quant);
                    String aux = quantAtendimento.substring(posicao, quantAtendimento.length());
                    quantAtendimento = aux;
                    list.get(masterTable.getSelectedRow()).getEstoque().get(i).setQuantRetirada(quant);
                    val.addRow(new String[]{quant.replaceAll(" -", "")});
                }
            }
            masterTable.setSelectionBackground(new java.awt.Color(0, 120, 215));
            setDados();
        }
    }//GEN-LAST:event_masterTableMouseReleased

    private void masterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyReleased
        if (masterTable.getSelectedRow() == 0) {
            enabledFalse();
            jFormattedTextField1.setText("");
            jTextField2.setText("");
            jRadioButton5.setSelected(true);
            jTextField1.setText("");
            masterTable.setSelectionBackground(Color.white);
        } else {
            editar = true;
            int index = masterTable.getSelectedRow();
            int linhas = jTable1.getRowCount();
            DefaultTableModel val = (DefaultTableModel) jTable3.getModel();
            while (jTable3.getRowCount() > 0) {
                val.removeRow(0);
            }
            if (linhas > 0) {
                String quantAtendimento = list.get(index).getQuantRetirada();
                System.out.println("Quant Atendimento Antiga: " + quantAtendimento);
                for (int i = 0; i < linhas; i++) {
                    //for que passa em todas as linhas da tabela de estoque, pega a quantidade retirada daquele estoque
                    //pegando todo o texto de quantRetirada até o primiro traço "-", então adiciona essa parte do texto ao estoque selecionado e
                    //remove em seguida para que o próximo estoque a passar pelo for pegue o o texto de quantRetirada até o primiro traço "-"
                    //no caso vai ser o segundo traço pois foi removido o pimeiro EX:
                    //quantRetirada do atendimento: 10 - 20- 30-
                    //primeira vez: estoque 1 pega (10- )
                    //quantRetirada do atendimento: 20- 30-
                    //primeira vez: estoque 2 pega (20- )
                    //quantRetirada do atendimento: 30-
                    //primeira vez: estoque 3 pega (30- )
                    int contador = quantAtendimento.length();
                    System.out.println("Contador:" + contador);
                    int posicao = 0;
                    String quant = null;
                    for (int j = 0; j < contador; j++) {
                        if (quantAtendimento.substring(j, j + 1).equals("-")) {
                            posicao = j + 1;
                            System.out.println("posicao:" + posicao);
                            quant = quantAtendimento.substring(0, posicao);
                            j = contador;
                        }
                    }
                    System.out.println(quant);
                    String aux = quantAtendimento.substring(posicao, quantAtendimento.length());
                    quantAtendimento = aux;
                    list.get(masterTable.getSelectedRow()).getEstoque().get(i).setQuantRetirada(quant);
                    val.addRow(new String[]{quant.replaceAll(" -", "")});
                }
            }
            masterTable.setSelectionBackground(new java.awt.Color(0, 120, 215));
            setDados();
        }
    }//GEN-LAST:event_masterTableKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Atendimento a = list.get(masterTable.getSelectedRow());
        AddPressao frm = new AddPressao(new JFrame(), true, a);
        frm.setLocationRelativeTo(null);
        frm.setResizable(false);
        frm.setTitle("INFORMAÇÕES");
        frm.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        if (jTable1.getSelectedRow() >= 0) {
            jTable3.setRowSelectionInterval(jTable1.getSelectedRow(), jTable1.getSelectedRow());
        }
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (jTable1.getSelectedRow() >= 0) {
            jTable3.setRowSelectionInterval(jTable1.getSelectedRow(), jTable1.getSelectedRow());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        if (jTable1.getSelectedRow() >= 0) {
            jTable3.setRowSelectionInterval(jTable1.getSelectedRow(), jTable1.getSelectedRow());
        }
    }//GEN-LAST:event_jTable1MousePressed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        if (jTable1.getSelectedRow() >= 0) {
            jTable3.setRowSelectionInterval(jTable1.getSelectedRow(), jTable1.getSelectedRow());
        }
    }//GEN-LAST:event_jTable1MouseReleased
    public void primeiroAtendimento() {
        // set for o primeiro atendimento do banco de dados, ele salva e adicina outro, pois o primeiro
        //antendimento sempre da erro na lista de enfermidades/ estoque, já apartir do segundo nao
        list.get(0).setAluno(null);
        list.get(0).setHora(null);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
        masterTable.setRowSelectionInterval(0, 0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<model.Aluno> alunoList;
    private javax.persistence.Query alunoQuery;
    private javax.swing.JLabel alunoidAlunoLabel;
    private javax.swing.JLabel alunoidAlunoLabel1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel condutaLabel;
    private javax.swing.JLabel dataAtendimentoLabel;
    private java.util.List<model.Enfermidade> enfermidadeList;
    private javax.persistence.Query enfermidadeQuery;
    private javax.swing.JLabel enfermidadeidEnfermidadeLabel;
    private javax.persistence.EntityManager entityManager;
    private java.util.List<model.Estoque> estoqueList;
    private javax.persistence.Query estoqueQuery;
    private javax.swing.JLabel estoqueidestoqueLabel;
    private javax.swing.JLabel horaLabel;
    private javax.swing.JLabel horaLabel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox<model.Enfermidade> jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextArea jTextField4;
    private javax.swing.JTextArea jTextField5;
    private java.util.List<model.Atendimento> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private java.util.List<model.Medicamento> medicamentoList;
    private javax.persistence.Query medicamentoQuery;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField quantRetiradaField;
    private javax.swing.JTextField quantRetiradaField6;
    private javax.swing.JLabel quantRetiradaLabel;
    private javax.swing.JLabel quantRetiradaLabel6;
    private javax.persistence.Query query;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

}
