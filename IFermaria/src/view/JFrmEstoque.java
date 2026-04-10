package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.beans.Beans;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.RollbackException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Atendente;
import model.Estoque;
import model.Medicamento;
import util.Conexao;
import util.Sessao;
import util.Tabelas;

public class JFrmEstoque extends JPanel {

    private JDialog jf;
    public boolean checagemObrigatoria = true,
            checagem_nao_Obrigatoria = true,
            editar = false,
            novo = false,
            validaDataValidade = true,
            validaDataEntrada = true;
    private int quantAtualAntiga;
    String mensagemErro = "",
            mensagemErro_nao_Obrigatoria = "";
    private String diaAtual;

    public int getQuantAtualAntiga() {
        return quantAtualAntiga;
    }

    public void setQuantAtualAntiga(int quantAtualAntiga) {
        this.quantAtualAntiga = quantAtualAntiga;
    }
    Atendente at;

    public JFrmEstoque(JDialog jframe, Atendente at) {
        this.jf = jframe;
        this.at = at;
        initComponents();
        jf.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/inicial.png")));
        idestoqueField.setVisible(false);
        editableFalse();
        ButFalse();
        jButton2.setEnabled(true);
        saveButton.setEnabled(false);
        boolean editar = false;
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
        masterTable.setSelectionMode(0);//só é possível selecionar uma linha da tabela
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("IFermariaPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT e FROM Estoque e where e.quantAtual != 0 order by e.medicamento.nome").setMaxResults(23);
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        medicamentoQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT m FROM Medicamento m order by m.nome");
        medicamentoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(medicamentoQuery.getResultList());
        jPanel2 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        idestoqueField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        loteField = new javax.swing.JTextField();
        quantAtualField = new javax.swing.JTextField();
        quantAtualLabel = new javax.swing.JLabel();
        loteLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        dataValidadeLabel = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        dataEntradaLabel = new javax.swing.JLabel();
        medicamentoIdmedicamentoLabel = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextField2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setBackground(new java.awt.Color(204, 204, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel2.setBackground(new java.awt.Color(96, 202, 164));

        saveButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_multimedia-27_809537.png"))); // NOI18N
        saveButton.setText("SALVAR");
        saveButton.setToolTipText("SALVAR NOVO ESTOQUE/ EDIÇÕES");
        saveButton.addActionListener(formListener);

        newButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_new-24_103173.png"))); // NOI18N
        newButton.setText("NOVO");
        newButton.setToolTipText("NOVO ESTOQUE");
        newButton.addActionListener(formListener);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.idestoque}"), idestoqueField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), idestoqueField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_create_326602.png"))); // NOI18N
        jButton2.setText("EDITAR");
        jButton2.setToolTipText("EDITAR ESTOQUE SELECIONADO");
        jButton2.addActionListener(formListener);

        jPanel1.setBackground(new java.awt.Color(96, 202, 164));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ifermeiras.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel3.setText("IFERMARIA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        home.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_home_298794.png"))); // NOI18N
        home.setText("HOME");
        home.setToolTipText("INICIO");
        home.addActionListener(formListener);

        jButton6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_Close_1891023 (1).png"))); // NOI18N
        jButton6.setText("SAIR");
        jButton6.setToolTipText("EDITAR ESTOQUE SELECIONADO");
        jButton6.addActionListener(formListener);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(idestoqueField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(home)
                .addGap(63, 63, 63)
                .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(idestoqueField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        masterTable.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${medicamento}"));
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
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantAtual}"));
        columnBinding.setColumnName("Quant");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterTable.addMouseListener(formListener);
        masterTable.addKeyListener(formListener);
        masterScrollPane.setViewportView(masterTable);
        if (masterTable.getColumnModel().getColumnCount() > 0) {
            masterTable.getColumnModel().getColumn(0).setPreferredWidth(260);
            masterTable.getColumnModel().getColumn(3).setPreferredWidth(40);
        }

        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField1.setToolTipText("PESQUISAR ESTOQUE");
        jTextField1.addFocusListener(formListener);
        jTextField1.addKeyListener(formListener);

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel1.setText("DIGITE O NOME DO MEDICAMENTO:");

        jCheckBox1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jCheckBox1.setText("ESTOQUES JÁ ZERADOS");
        jCheckBox1.addActionListener(formListener);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBox1))
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("PESQUISA", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        loteField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        loteField.setToolTipText("LOTE");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.lote}"), loteField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), loteField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        quantAtualField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        quantAtualField.setToolTipText("QUANTIDADE DO ESTOQUES");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.quantAtual}"), quantAtualField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), quantAtualField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        quantAtualField.addKeyListener(formListener);

        quantAtualLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        quantAtualLabel.setText("Quant Atual:");

        loteLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        loteLabel.setText("Lote:");

        jComboBox1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, medicamentoList, jComboBox1);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.medicamento}"), jComboBox1, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1.setToolTipText("DATA DE VALIDADE DO ESTOQUE");
        jFormattedTextField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jFormattedTextField1, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        dataValidadeLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        dataValidadeLabel.setText("Data Validade:");

        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField2.setToolTipText("DATA DE ENTRADA DO ESTOQUE");
        jFormattedTextField2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jFormattedTextField2, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        dataEntradaLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        dataEntradaLabel.setText("Data Entrada:");

        medicamentoIdmedicamentoLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        medicamentoIdmedicamentoLabel.setText("Medicamento:");

        jButton3.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton3.setText("+");
        jButton3.addActionListener(formListener);

        jButton4.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton4.setText("-");
        jButton4.addActionListener(formListener);

        jTextField2.setEditable(false);
        jTextField2.setColumns(20);
        jTextField2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField2.setRows(5);
        jTextField2.setToolTipText("CLIQUE DUAS VEZES PARA SELECIONAR O MEDICAMENTO");
        jTextField2.addMouseListener(formListener);
        jScrollPane1.setViewportView(jTextField2);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_today_326713.png"))); // NOI18N
        jButton1.setToolTipText("COLOCAR HOJE COMO DIA DE ENTRADA");
        jButton1.addActionListener(formListener);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(medicamentoIdmedicamentoLabel)
                        .addGap(456, 456, 456))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(dataEntradaLabel)
                                    .addComponent(dataValidadeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(quantAtualLabel)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(jButton4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(quantAtualField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton3)))
                                    .addComponent(loteField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loteLabel))))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(medicamentoIdmedicamentoLabel)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataEntradaLabel)
                    .addComponent(loteLabel))
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(dataValidadeLabel)
                        .addGap(18, 18, 18)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(quantAtualLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(quantAtualField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MEDICAMENTO", jPanel4);

        jButton5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_Doctors_2_753952.png"))); // NOI18N
        jButton5.setText("MEDICAMENTOS");
        jButton5.setToolTipText("MANIPULAR MEDICAMENTOS");
        jButton5.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.FocusListener, java.awt.event.KeyListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                JFrmEstoque.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                JFrmEstoque.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == jButton2) {
                JFrmEstoque.this.jButton2ActionPerformed(evt);
            }
            else if (evt.getSource() == home) {
                JFrmEstoque.this.homeActionPerformed(evt);
            }
            else if (evt.getSource() == jButton6) {
                JFrmEstoque.this.jButton6ActionPerformed(evt);
            }
            else if (evt.getSource() == jCheckBox1) {
                JFrmEstoque.this.jCheckBox1ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton3) {
                JFrmEstoque.this.jButton3ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton4) {
                JFrmEstoque.this.jButton4ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton1) {
                JFrmEstoque.this.jButton1ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton5) {
                JFrmEstoque.this.jButton5ActionPerformed(evt);
            }
        }

        public void focusGained(java.awt.event.FocusEvent evt) {
            if (evt.getSource() == jTextField1) {
                JFrmEstoque.this.jTextField1FocusGained(evt);
            }
        }

        public void focusLost(java.awt.event.FocusEvent evt) {
        }

        public void keyPressed(java.awt.event.KeyEvent evt) {
        }

        public void keyReleased(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == masterTable) {
                JFrmEstoque.this.masterTableKeyReleased(evt);
            }
            else if (evt.getSource() == jTextField1) {
                JFrmEstoque.this.jTextField1KeyReleased(evt);
            }
            else if (evt.getSource() == quantAtualField) {
                JFrmEstoque.this.quantAtualFieldKeyReleased(evt);
            }
        }

        public void keyTyped(java.awt.event.KeyEvent evt) {
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == jTextField2) {
                JFrmEstoque.this.jTextField2MouseClicked(evt);
            }
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == jTextField2) {
                JFrmEstoque.this.jTextField2MouseEntered(evt);
            }
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == jTextField2) {
                JFrmEstoque.this.jTextField2MouseExited(evt);
            }
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                JFrmEstoque.this.masterTableMousePressed(evt);
            }
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                JFrmEstoque.this.masterTableMouseReleased(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        System.out.println(testesValida);
        if (testesValida == true) {//verifica conexao
            try {
                model.Estoque e = new model.Estoque();
                entityManager.persist(e);
                list.add(e);
                int row = list.size() - 1;
                masterTable.setRowSelectionInterval(row, row);
                masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
                editableTrue();
                ButFalse();
                jTabbedPane1.setEnabled(false);
                jTabbedPane1.setSelectedIndex(1);
                quantAtualField.setText("0");
                editar = false;
                novo = true;
                setQuantAtualAntiga(0);
                jTextField2.setText("");
                jFormattedTextField2.setText("");
                jFormattedTextField1.setText("");
                jButton5.setEnabled(false);
                jFormattedTextField1.setForeground(Color.BLACK);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao Criar Novo Cadastro!!\nFeche o Programa!!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_newButtonActionPerformed
    public void validaSalvar() {
        checagemObrigatoria = true;
        Medicamento m = list.get(masterTable.getSelectedRow()).getMedicamento();
//validações
        String diaValidadeStr = jFormattedTextField1.getText().substring(0, 2),
                mesValidadeStr = jFormattedTextField1.getText().substring(3, 5),
                anoValidadeStr = jFormattedTextField1.getText().substring(6, 10);

        int dia = 0, mes = 0, ano = 0;
        String diaStr = jFormattedTextField2.getText().substring(0, 2),
                mesStr = jFormattedTextField2.getText().substring(3, 5),
                anoStr = jFormattedTextField2.getText().substring(6, 10);
        if (!diaStr.equals("  ")) {
            dia = Integer.parseInt(diaStr);
        }
        if (!mesStr.equals("  ")) {
            mes = Integer.parseInt(mesStr);
        }
        if (!anoStr.equals("    ")) {
            ano = Integer.parseInt(anoStr);
        }

        int diaValidade = 0, mesValidade = 0, anoValidade = 0;
        if (!diaValidadeStr.equals("  ")) {
            diaValidade = Integer.parseInt(diaValidadeStr);
        }
        if (!mesValidadeStr.equals("  ")) {
            mesValidade = Integer.parseInt(mesValidadeStr);
        }
        if (!anoValidadeStr.equals("    ")) {
            anoValidade = Integer.parseInt(anoValidadeStr);
        }
        if (jTextField2.getText().equals("")) {
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO SELECIONAR O MEDICAMENTO!\n";
        }
        if (jFormattedTextField2.getText().charAt(0) != ' ') {//data entrada
            if ((mes < 1) || (mes > 12) || (dia < 1) || (dia > 31) || (((mes == 4) || (mes == 6) || (mes == 9) || (mes == 11)) && (dia > 30)) || ((mes == 2) && (((dia > 28) && (ano % 4 != 0)) || (((dia > 29) && (((ano % 4 == 0) && (ano % 100 != 0)) || (ano % 400 == 0)))))) || (ano < 1900)) {
                checagemObrigatoria = false;
                mensagemErro += "DATA  DE ENTRADA INVALIDA! \n";
                validaDataEntrada = false;
            } else {
                validaDataEntrada = true;
            }
        } else {
            validaDataEntrada = false;
        }

        if (jFormattedTextField1.getText().charAt(0) != ' ') {
            if (((mesValidade < 1) || (mesValidade > 12) || (diaValidade < 1) || (diaValidade > 31) || (((mesValidade == 4) || (mesValidade == 6) || (mesValidade == 9) || (mesValidade == 11)) && (diaValidade > 30)) || ((mesValidade == 2) && (((diaValidade > 28) && (anoValidade % 4 != 0)) || (((diaValidade > 29) && (((anoValidade % 4 == 0) && (anoValidade % 100 != 0)) || (anoValidade % 400 == 0)))))) || (anoValidade < 1900)) && (jFormattedTextField1.getText().charAt(0) != ' ')) {
                checagemObrigatoria = false;
                mensagemErro += "DATA  DE VALIDADE INVALIDA! \n";
                validaDataValidade = false;
            } else {
                validaDataValidade = true;
            }
        } else {
            validaDataValidade = false;
            if (!m.getTipo().equals("Material")) {
                checagemObrigatoria = false;
                mensagemErro += "OBRIGATÓRIO PREENCHER DATA  DE VALIDADE! \n";
            }
        }
        if ((quantAtualField.getText().equals("") || quantAtualField.getText().equals("0")) && editar == false) {
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO PREENCHER O CAMPO QUANTIDADE! \n";
        } else if (!quantAtualField.getText().matches("[0-9]*")) {
            checagemObrigatoria = false;
            mensagemErro += "CARACTER NÃO NUMÉRIO NO CAMPO QUANTIDADE! \n";
            quantAtualField.setText("");
        } else if (quantAtualField.getText().length() > 9) {
            checagemObrigatoria = false;
            mensagemErro += "♦LIMITE DE 10 CARACTERES NO CAMPO QUANTIDADE ATUAL, QUANTIDADE DIGITADA: " + quantAtualField.getText().length() + " !\n";
        }
        if (loteField.getText().length() > 50) {
            checagemObrigatoria = false;
            mensagemErro += "♦LIMITE DE 50 CARACTERES NO CAMPO LOTE, QUANTIDADE DIGITADA: " + loteField.getText().length() + " !\n";
        }

    }

    public void check_n_Obrigatoria() {
        int dia = 0, mes = 0, ano = 0;
        Medicamento m = list.get(masterTable.getSelectedRow()).getMedicamento();
        String diaStr = jFormattedTextField2.getText().substring(0, 2);
        String mesStr = jFormattedTextField2.getText().substring(3, 5);
        String anoStr = jFormattedTextField2.getText().substring(6, 10);
        if (!diaStr.equals("  ")) {
            dia = Integer.parseInt(diaStr);
        }
        if (!mesStr.equals("  ")) {
            mes = Integer.parseInt(mesStr);
        }
        if (!anoStr.equals("    ")) {
            ano = Integer.parseInt(anoStr);
        }
        String diaValidadeStr = jFormattedTextField1.getText().substring(0, 2);
        String mesValidadeStr = jFormattedTextField1.getText().substring(3, 5);
        String anoValidadeStr = jFormattedTextField1.getText().substring(6, 10);
        int anoAtual, mesAtual, diaAAtual;

        Calendar hoje = Calendar.getInstance();
        anoAtual = hoje.get(Calendar.YEAR);
        mesAtual = hoje.get(Calendar.MONTH) + 1;
        diaAAtual = hoje.get(Calendar.DAY_OF_MONTH);

        int diaValidade = 0, mesValidade = 0, anoValidade = 0;
        if (!diaValidadeStr.equals("  ")) {
            diaValidade = Integer.parseInt(diaValidadeStr);
        }
        if (!mesValidadeStr.equals("  ")) {
            mesValidade = Integer.parseInt(mesValidadeStr);
        }
        if (!anoValidadeStr.equals("    ")) {
            anoValidade = Integer.parseInt(anoValidadeStr);
        }
        checagem_nao_Obrigatoria = true;
        if (jFormattedTextField2.getText().charAt(0) == ' ') {
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (Data de Entrada) NÃO PREENCHIDO!\n";
        }
        if (jFormattedTextField1.getText().charAt(0) == ' ' && m.getTipo().equals("Material")) {
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (Data de Validade) NÃO PREENCHIDO!\n";
        }
        if (loteField.getText().equals("")) {
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (Lote) NÃO PREENCHIDO!\n";
        }

        if (((anoValidade < ano) || ((mesValidade < mes) && (anoValidade <= ano))
                || ((diaValidade < dia) && (mesValidade <= mes) && (anoValidade <= ano))) && validaDataEntrada == true && validaDataValidade == true) {
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "DATA DE VALIDADE MENOR QUE A DATA DE ENTRADA! \n";
            validaDataValidade = true;
        }
        if (((anoValidade < anoAtual) || ((mesValidade < mesAtual) && (anoValidade <= anoAtual))
                || ((diaValidade < diaAAtual) && (mesValidade <= mesAtual) && (anoValidade <= anoAtual))) && validaDataValidade == true) {
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "DATA DE VALIDADE MENOR QUE O DIA ATUAL (PRODUTO VENCIDO)! \n";
            jFormattedTextField1.setForeground(Color.RED);
        } else {
            jFormattedTextField1.setForeground(Color.BLACK);
        }

    }

    public String setDataEntrada() {
        int ls = masterTable.getSelectedRow();
        Estoque e = list.get(ls);
        if (e.getDataEntrada() != null) {
            String dataAntigaDate = e.getDataEntrada().toString();
            String ano = dataAntigaDate.substring(0, 4);
            String mes = dataAntigaDate.substring(5, 7);
            String dia = dataAntigaDate.substring(8, 10);
            String dataNovaString = dia + mes + ano;
            return dataNovaString;//método para transformar o tipo Date para String
        } else {
            return "";
        }
    }

    public String setDataValidade() {
        int ls = masterTable.getSelectedRow();
        Estoque e = list.get(ls);
        if (e.getDataValidade() != null) {
            String dataAntigaDate = e.getDataValidade().toString();
            String ano = dataAntigaDate.substring(0, 4);
            String mes = dataAntigaDate.substring(5, 7);
            String dia = dataAntigaDate.substring(8, 10);
            String dataNovaString = dia + mes + ano;
            return dataNovaString;//método para transformar o tipo Date para String
        } else {
            return "";
        }
    }
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        if (testesValida == true) {//verifica conexao
            validaSalvar();
            check_n_Obrigatoria();
            int index = masterTable.getSelectedRow();
            int cont = 0;
            if (checagem_nao_Obrigatoria == false) {
                cont = JOptionPane.showConfirmDialog(null, "ATENÇÃO:\n\n" + mensagemErro_nao_Obrigatoria + "\nDESEJA MESMO SALVAR SEM ESSE(s) REGISTRO(s)?", "ATENÇÃO!!", JOptionPane.YES_NO_OPTION);
            } else {
                cont = 0;
            }
            if (cont == 0) {
                if (checagemObrigatoria == true) {
                    try {
                        Medicamento m;
                        if (editar == false && novo == true) {//se for um novo estoque simplesmente aumenta a quantidade do medicamneto
                            int quanttotalAntiga = 0;
                            int quantAtual = 0;
                            int quantNova = 0;
                            m = medicamentoList.get(jComboBox1.getSelectedIndex());
                            quanttotalAntiga = m.getQuantTotal();
                            quantAtual = Integer.parseInt(quantAtualField.getText());
                            quantNova = quanttotalAntiga + quantAtual;
                            m.setQuantTotal(quantNova);
                            quanttotalAntiga = 0;
                            quantAtual = 0;
                            quantNova = 0;
                        } else {//se for uma edição de quantidade, tem que verificar a quantidade antiga para não dar errado a conta
                            int quanttotalAntiga = 0;
                            int quantAtualNova = 0;
                            int quantdigitada = 0;
                            int quantTotalNova = 0;

                            m = medicamentoList.get(jComboBox1.getSelectedIndex());
                            quantdigitada = Integer.parseInt(quantAtualField.getText());
                            quanttotalAntiga = m.getQuantTotal();
                            quantAtualNova = quantdigitada - getQuantAtualAntiga();
                            quantTotalNova = quanttotalAntiga + quantAtualNova;
                            m.setQuantTotal(quantTotalNova);
                            quanttotalAntiga = 0;
                            quantAtualNova = 0;
                            quantTotalNova = 0;
                            quantAtualAntiga = 0;
                        }
                        //salva data Entrada             
                        String dataString = jFormattedTextField2.getText();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        Date dataEntrada;
                        String dia = dataString.substring(0, 2);
                        String mes = dataString.substring(3, 5);
                        String ano = dataString.substring(6, 10);
                        if (jFormattedTextField2.getText().charAt(0) != ' ') {
                            try {
                                dataEntrada = format.parse(ano + "-" + mes + "-" + dia);//tranformando a data de String para Date
                                list.get(index).setDataEntrada(dataEntrada);
                            } catch (ParseException ex) {
                                Logger.getLogger(JFrmAtendimento.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            list.get(index).setDataEntrada(null);
                        }
                        if (jFormattedTextField1.getText().charAt(0) != ' ') {
                            String dataValidadeString = jFormattedTextField1.getText();
                            Date dataValidade;
                            String diaValidade = dataValidadeString.substring(0, 2);
                            String mesValidade = dataValidadeString.substring(3, 5);
                            String anoValidade = dataValidadeString.substring(6, 10);
                            try {
                                dataValidade = format.parse(anoValidade + "-" + mesValidade + "-" + diaValidade);//tranformando a data de String para Date
                                list.get(index).setDataValidade(dataValidade);
                            } catch (ParseException ex) {
                                Logger.getLogger(JFrmAtendimento.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            list.get(index).setDataValidade(null);
                        }
                        entityManager.getTransaction().commit();//salva
                        entityManager.getTransaction().begin();
                        JOptionPane.showMessageDialog(null, "SALVO COM SUCESSO");
                        //não seleciona nenhum item
                        masterTable.setRowSelectionInterval(0, 0);//seta o primeiro item  da tabela
                        java.util.Collection data = query.getResultList();
                        for (Object entity : data) {
                            entityManager.refresh(entity);
                        }
                        list.clear();
                        list.addAll(data);
                        //não seleciona nenhum item
                        Estoque e = list.get(index);
                        new Sessao(at);
                        if (novo == true) {
                            util.Logger.log(Sessao.getAtendenteLogado(), null, "INSERÇÃO DE DADOS NO NOVO ESTOQUE: IDestoque: " + e.getIdestoque()
                                    + " Medicamento: " + e.getMedicamento().getNome()
                                    + " IDmedicamento: " + e.getMedicamento().getIdmedicamento()
                                    + " Data Entrada: " + e.getDataEntrada().toString()
                                    + " Data Validade: " + e.getDataValidade().toString()
                                    + " Lote: " + e.getLote()
                                    + " Quantidade: " + e.getQuantAtual(), Tabelas.ESTOQUE);
                        } else {
                            util.Logger.log(Sessao.getAtendenteLogado(), null, "ATUALIZAÇÃO DE DADOS NO ESTOQUE: IDestoque: " + e.getIdestoque()
                                    + " Medicamento: " + e.getMedicamento().getNome()
                                    + " IDmedicamento: " + e.getMedicamento().getIdmedicamento()
                                    + " Data Entrada: " + e.getDataEntrada().toString()
                                    + " Data Validade: " + e.getDataValidade().toString()
                                    + " Lote: " + e.getLote()
                                    + " Quantidade: " + e.getQuantAtual(), Tabelas.ESTOQUE);
                        }
                    } catch (RollbackException rex) {//erro
                        JOptionPane.showMessageDialog(null, "Erro ao Salvar!!\neche o Programa e verifique a conexão com a internet", "ERRO", JOptionPane.ERROR_MESSAGE);
                        rex.printStackTrace();
                        entityManager.getTransaction().begin();
                        List<model.Estoque> merged = new ArrayList<model.Estoque>(list.size());
                        for (model.Estoque e : list) {
                            merged.add(entityManager.merge(e));
                        }
                        list.clear();
                        list.addAll(merged);
                    }
                    jTabbedPane1.setEnabled(true);
                    jTabbedPane1.setSelectedIndex(0);
                    editableFalse();
                    jButton2.setEnabled(true);
                    home.doClick();
                } else {
                    JOptionPane.showMessageDialog(null, "ERRO:\n\n" + mensagemErro, "ERRO!", JOptionPane.ERROR_MESSAGE);

                }
                mensagemErro = "";
                mensagemErro_nao_Obrigatoria = "";
                validaDataValidade = false;
                validaDataEntrada = false;
            } else {
                mensagemErro = "";
                mensagemErro_nao_Obrigatoria = "";
                validaDataValidade = false;
                validaDataEntrada = false;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        try {
            if (jCheckBox1.isSelected()) {//busca feita apenas com estoque vazios
                query = entityManager.createQuery("select a from Estoque a where a.medicamento.nome like :nome and a.quantAtual = 0 order by a.medicamento.nome,a.dataValidade ").setMaxResults(23);
            } else {//busca feita com estoques que a quantidade seja maior q 0
                query = entityManager.createQuery("select a from Estoque a where a.medicamento.nome like :nome and a.quantAtual != 0 order by a.medicamento.nome,a.dataValidade,a.quantAtual ").setMaxResults(23);

            }
            query.setParameter("nome", "%" + jTextField1.getText() + "%");
            list.clear();
            list.addAll(query.getResultList());
        } catch (Exception e) {
            System.out.println("Falha na busca - " + e.toString());
            JOptionPane.showMessageDialog(null, "Falha na busca", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        if (!list.isEmpty()) {
            Calendar hoje = Calendar.getInstance();//instante atual
            int anoAtual = hoje.get(Calendar.YEAR);
            int mesAtual = hoje.get(Calendar.MONTH) + 1;
            int diaAAtual = hoje.get(Calendar.DAY_OF_MONTH);
            masterTable.setRowSelectionInterval(0, 0);
            ButTrue();
            int ls = masterTable.getSelectedRow();
            Estoque e = list.get(ls);
            jTextField2.setText(e.getMedicamento().toString());

            jFormattedTextField2.setText(setDataEntrada());
            jFormattedTextField1.setText(setDataValidade());
            Date data = list.get(masterTable.getSelectedRow()).getDataValidade();
            if (data != null) {//se tiver data de validade verifica se está vendiso, se sim seta cor vermelha, se não seta cor azul
                String diaValidadeStr = jFormattedTextField1.getText().substring(0, 2);
                String mesValidadeStr = jFormattedTextField1.getText().substring(3, 5);
                String anoValidadeStr = jFormattedTextField1.getText().substring(6, 10);
                int diaValidade = 0, mesValidade = 0, anoValidade = 0;
                if (!diaValidadeStr.equals("  ")) {
                    diaValidade = Integer.parseInt(diaValidadeStr);
                }
                if (!mesValidadeStr.equals("  ")) {
                    mesValidade = Integer.parseInt(mesValidadeStr);
                }
                if (!anoValidadeStr.equals("    ")) {
                    anoValidade = Integer.parseInt(anoValidadeStr);
                }
                if (((anoValidade < anoAtual) || ((mesValidade < mesAtual) && (anoValidade <= anoAtual))
                        || ((diaValidade < diaAAtual) && (mesValidade <= mesAtual) && (anoValidade <= anoAtual)))) {
                    jFormattedTextField1.setForeground(Color.red);//se o estoque estiver vencido, seta cor vermelha na linha
                    masterTable.setSelectionBackground(Color.red);
                } else {
                    jFormattedTextField1.setForeground(Color.BLACK);
                    masterTable.setSelectionBackground(new java.awt.Color(0, 120, 215));
                }
            }

            if (evt.getKeyCode() == 10) {
                jTabbedPane1.setSelectedIndex(1);
                ButTrue();
            }
        } else {
            jTextField2.setText("");
            jFormattedTextField1.setText("");
            jFormattedTextField2.setText("");
        }

    }//GEN-LAST:event_jTextField1KeyReleased

    private void masterTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMousePressed

        int ls = masterTable.getSelectedRow();
        Estoque e = list.get(ls);
        jTextField2.setText(e.getMedicamento().toString());
        jFormattedTextField2.setText(setDataEntrada());
        jFormattedTextField1.setText(setDataValidade());
        editableFalse();
        ButTrue();
        Calendar hoje = Calendar.getInstance();
        int anoAtual = hoje.get(Calendar.YEAR);
        int mesAtual = hoje.get(Calendar.MONTH) + 1;
        int diaAAtual = hoje.get(Calendar.DAY_OF_MONTH);
        jTextField2.setText(e.getMedicamento().toString());
        jFormattedTextField2.setText(setDataEntrada());
        jFormattedTextField1.setText(setDataValidade());
        Date data = list.get(masterTable.getSelectedRow()).getDataValidade();
        if (data != null) {//se tiver data de validade verifica se está vendiso, se sim seta cor vermelha, se não seta cor azul
            String diaValidadeStr = jFormattedTextField1.getText().substring(0, 2);
            String mesValidadeStr = jFormattedTextField1.getText().substring(3, 5);
            String anoValidadeStr = jFormattedTextField1.getText().substring(6, 10);
            int diaValidade = 0, mesValidade = 0, anoValidade = 0;
            if (!diaValidadeStr.equals("  ")) {
                diaValidade = Integer.parseInt(diaValidadeStr);
            }
            if (!mesValidadeStr.equals("  ")) {
                mesValidade = Integer.parseInt(mesValidadeStr);
            }
            if (!anoValidadeStr.equals("    ")) {
                anoValidade = Integer.parseInt(anoValidadeStr);
            }
            if (((anoValidade < anoAtual) || ((mesValidade < mesAtual) && (anoValidade <= anoAtual))
                    || ((diaValidade < diaAAtual) && (mesValidade <= mesAtual) && (anoValidade <= anoAtual)))) {
                jFormattedTextField1.setForeground(Color.red);
                masterTable.setSelectionBackground(Color.red);
            } else {
                jFormattedTextField1.setForeground(Color.BLACK);
                masterTable.setSelectionBackground(new java.awt.Color(0, 120, 215));
            }
        }
        if (evt.getClickCount() == 2) {
            jTabbedPane1.setSelectedIndex(1);
        }
    }//GEN-LAST:event_masterTableMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int ls = masterTable.getSelectedRow();
        if (ls >= 0) {
            jButton2.setEnabled(false);
            setQuantAtualAntiga(Integer.parseInt(quantAtualField.getText()));
            editar = true;
            novo = false;
            jTabbedPane1.setSelectedIndex(1);
            jTabbedPane1.setEnabled(false);
            editableTrue();
            saveButton.setEnabled(true);
            jButton5.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Estoque para ser Editado", "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int quantAntiga = 0;
        int quantnova = 0;
        if (quantAtualField.getText().equals("")) {
            quantAntiga = 0;
            quantnova = quantAntiga + 1;
            String quantStr = String.valueOf(quantnova);
            quantAtualField.setText(quantStr);
        } else if (quantAtualField.getText().matches("[0-9]*")) {//verifica se sao apenas numeros
            if (quantAtualField.getText().length() <= 9) {//vefifica se o valor não é muito grande
                quantAntiga = Integer.parseInt(quantAtualField.getText());
                quantnova = quantAntiga + 1;//soma 1
                String quantStr = String.valueOf(quantnova);
                quantAtualField.setText(quantStr);
            }
        } else {
            quantAtualField.setText("");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int texto = 0;
        int quantAntiga = 0;
        int quantnova = 0;
        if (quantAtualField.getText().equals("")) {
            quantAntiga = 0;
        } else if (quantAtualField.getText().matches("[0-9]*")) {//verifica se sao apenas numeros
            if (quantAtualField.getText().length() <= 9) {//vefifica se o valor não é muito grande
                texto = Integer.parseInt(quantAtualField.getText());
                quantAntiga = texto;
                if (quantAntiga > 0) {//verifica se o valor é positivo
                    quantnova = quantAntiga - 1;//subtrai 1
                    String quantStr = String.valueOf(quantnova);
                    quantAtualField.setText(quantStr);
                }
            }
        } else {
            quantAtualField.setText("");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void quantAtualFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantAtualFieldKeyReleased
        String digitos = "0123456789";//método que verifica se a ultima letra digitada é uma letra
        String texto = quantAtualField.getText();
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
            quantAtualField.setText("");
        }
    }//GEN-LAST:event_quantAtualFieldKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//abre formulario de medicamentos
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        System.out.println(testesValida);
        if (testesValida == true) {//verifica conexao
            jf.dispose();
            JDialog frame = new JDialog(new JFrame(), true);
            frame.add(new JFrmMedicamento(frame, medicamentoList, at));
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setTitle("NOVO MEDICAMENTO");
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        if (testesValida == true) {//verifica conexao
            try {
                java.util.Collection data = query.getResultList();
                for (Object entity : data) {
                    entityManager.refresh(entity);
                }
                list.clear();
                list.addAll(data);
                jTextField1.setText("");
                list.clear();
                query = entityManager.createQuery("SELECT e FROM Estoque e where e.quantAtual != 0 order by e.medicamento.nome").setMaxResults(23);
                list.clear();
                list.addAll(query.getResultList());
                jTabbedPane1.setEnabled(true);
                jTabbedPane1.setSelectedIndex(0);
                editableFalse();
                jButton2.setEnabled(true);
                jTextField2.setText("");
                saveButton.setEnabled(false);
                jFormattedTextField1.setText("");
                jFormattedTextField2.setText("");
                editar = false;
                novo = false;
                jButton5.setEnabled(true);
                jFormattedTextField1.setForeground(Color.BLACK);
                masterTable.setSelectionForeground(Color.black);
                masterTable.setSelectionBackground(new java.awt.Color(0, 120, 215));
                masterTable.setFont(new java.awt.Font("Century Gothic", 0, 14));
                jCheckBox1.setSelected(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro selecionar Estoques cadastrados!!\nFeche o Programa e verifique a conexão com a internet!!!!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_homeActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        System.out.println(testesValida);
        if (testesValida == true) {//verifica conexao
            if (evt.getClickCount() == 2 && novo == true) {
                AddMedicamentos frm = new AddMedicamentos(new JFrame(), true);
//abre tela selecionadora de medicamentos
                frm.setLocationRelativeTo(null);
                frm.setResizable(false);
                frm.setTitle("MEDICAMENTO");
                frm.setVisible(true);
                if (frm.isConfirmado()) {
                    Medicamento m = frm.getMedicamento();
                    jComboBox1.setSelectedItem(m);
                    jTextField2.setText(m.toString());
                    saveButton.setEnabled(true);
                } else {
                    jComboBox1.setSelectedItem(-1);
                    jTextField2.setText("");
                }

            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseEntered
        if (novo == true) {
            jTextField2.setBackground(new java.awt.Color(204, 204, 255));
        }
    }//GEN-LAST:event_jTextField2MouseEntered

    private void jTextField2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseExited
        if (novo == true) {
            jTextField2.setBackground(new java.awt.Color(250, 250, 250));
        }
    }//GEN-LAST:event_jTextField2MouseExited
    private void diadeHoje() {
        int da, ma, aa, ha, mia;//método para verificar o dia atual
        String daSt = null, maSt = null, hSt = null, miSt = null;
        Calendar hoje = Calendar.getInstance();
        da = hoje.get(Calendar.DAY_OF_MONTH);
        ma = hoje.get(Calendar.MONTH) + 1;
        aa = hoje.get(Calendar.YEAR);
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
        diaAtual = (String.valueOf(daSt + maSt + aa));
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        diadeHoje();
        jFormattedTextField2.setText(diaAtual);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void masterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyReleased
        int ls = masterTable.getSelectedRow();
        Estoque e = list.get(ls);
        jTextField2.setText(e.getMedicamento().toString());
        jFormattedTextField2.setText(setDataEntrada());
        jFormattedTextField1.setText(setDataValidade());
        editableFalse();
        ButTrue();
        Calendar hoje = Calendar.getInstance();
        int anoAtual = hoje.get(Calendar.YEAR);
        int mesAtual = hoje.get(Calendar.MONTH) + 1;
        int diaAAtual = hoje.get(Calendar.DAY_OF_MONTH);
        jTextField2.setText(e.getMedicamento().toString());
        jFormattedTextField2.setText(setDataEntrada());
        jFormattedTextField1.setText(setDataValidade());
        Date data = list.get(masterTable.getSelectedRow()).getDataValidade();
        if (data != null) {//se tiver data de validade verifica se está vendiso, se sim seta cor vermelha, se não seta cor azul
            String diaValidadeStr = jFormattedTextField1.getText().substring(0, 2);
            String mesValidadeStr = jFormattedTextField1.getText().substring(3, 5);
            String anoValidadeStr = jFormattedTextField1.getText().substring(6, 10);
            int diaValidade = 0, mesValidade = 0, anoValidade = 0;
            if (!diaValidadeStr.equals("  ")) {
                diaValidade = Integer.parseInt(diaValidadeStr);
            }
            if (!mesValidadeStr.equals("  ")) {
                mesValidade = Integer.parseInt(mesValidadeStr);
            }
            if (!anoValidadeStr.equals("    ")) {
                anoValidade = Integer.parseInt(anoValidadeStr);
            }
            if (((anoValidade < anoAtual) || ((mesValidade < mesAtual) && (anoValidade <= anoAtual))
                    || ((diaValidade < diaAAtual) && (mesValidade <= mesAtual) && (anoValidade <= anoAtual)))) {
                jFormattedTextField1.setForeground(Color.red);
                masterTable.setSelectionBackground(Color.red);
            } else {
                jFormattedTextField1.setForeground(Color.BLACK);
                masterTable.setSelectionBackground(new java.awt.Color(0, 120, 215));
            }
        }
    }//GEN-LAST:event_masterTableKeyReleased

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        if (testesValida == true) {//verifica conexao
            try {
                if (jCheckBox1.isSelected()) {//método selecionador de estoque vazios
                    query = entityManager.createQuery("select a from Estoque a where  a.quantAtual = 0 order by a.medicamento.nome,a.dataValidade,a.quantAtual ").setMaxResults(23);
                    list.clear();
                    list.addAll(query.getResultList());
                } else {
                    home.doClick();
                }
            } catch (Exception e) {
                System.out.println("Falha na busca - " + e.toString());
                jTextField1.setText("");
                JOptionPane.showMessageDialog(null, "Falha na busca", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jf.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased

        int ls = masterTable.getSelectedRow();
        if (ls >= 0) {
            Estoque e = list.get(ls);
            jTextField2.setText(e.getMedicamento().toString());
            jFormattedTextField2.setText(setDataEntrada());
            jFormattedTextField1.setText(setDataValidade());
            editableFalse();
            ButTrue();
            Calendar hoje = Calendar.getInstance();
            int anoAtual = hoje.get(Calendar.YEAR);
            int mesAtual = hoje.get(Calendar.MONTH) + 1;
            int diaAAtual = hoje.get(Calendar.DAY_OF_MONTH);
            jTextField2.setText(e.getMedicamento().toString());
            jFormattedTextField2.setText(setDataEntrada());
            jFormattedTextField1.setText(setDataValidade());
            Date data = list.get(masterTable.getSelectedRow()).getDataValidade();
            if (data != null) {//se tiver data de validade verifica se está vendiso, se sim seta cor vermelha, se não seta cor azul
                String diaValidadeStr = jFormattedTextField1.getText().substring(0, 2);
                String mesValidadeStr = jFormattedTextField1.getText().substring(3, 5);
                String anoValidadeStr = jFormattedTextField1.getText().substring(6, 10);
                int diaValidade = 0, mesValidade = 0, anoValidade = 0;
                if (!diaValidadeStr.equals("  ")) {
                    diaValidade = Integer.parseInt(diaValidadeStr);
                }
                if (!mesValidadeStr.equals("  ")) {
                    mesValidade = Integer.parseInt(mesValidadeStr);
                }
                if (!anoValidadeStr.equals("    ")) {
                    anoValidade = Integer.parseInt(anoValidadeStr);
                }
                if (((anoValidade < anoAtual) || ((mesValidade < mesAtual) && (anoValidade <= anoAtual))
                        || ((diaValidade < diaAAtual) && (mesValidade <= mesAtual) && (anoValidade <= anoAtual)))) {
                    jFormattedTextField1.setForeground(Color.red);
                    masterTable.setSelectionBackground(Color.red);
                } else {
                    jFormattedTextField1.setForeground(Color.BLACK);
                    masterTable.setSelectionBackground(new java.awt.Color(0, 120, 215));
                }
            }
        }
    }//GEN-LAST:event_masterTableMouseReleased

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        System.out.println(testesValida);
        if (testesValida == true) {//verifica conexao
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
            home.requestFocus();
        }
    }//GEN-LAST:event_jTextField1FocusGained
    private void editableFalse() {
        jComboBox1.setEnabled(false);
        jFormattedTextField1.setEditable(false);
        loteField.setEditable(false);
        jFormattedTextField2.setEditable(false);
        quantAtualField.setEditable(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton1.setEnabled(false);
    }

    private void editableTrue() {
        jComboBox1.setEnabled(true);
        jFormattedTextField1.setEditable(true);
        loteField.setEditable(true);
        jFormattedTextField2.setEditable(true);
        quantAtualField.setEditable(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton1.setEnabled(true);
    }

    private void ButFalse() {
        jButton2.setEnabled(false);
    }

    private void ButTrue() {
        jButton2.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dataEntradaLabel;
    private javax.swing.JLabel dataValidadeLabel;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton home;
    private javax.swing.JTextField idestoqueField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea jTextField2;
    private java.util.List<model.Estoque> list;
    private javax.swing.JTextField loteField;
    private javax.swing.JLabel loteLabel;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JLabel medicamentoIdmedicamentoLabel;
    private java.util.List<model.Medicamento> medicamentoList;
    private javax.persistence.Query medicamentoQuery;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField quantAtualField;
    private javax.swing.JLabel quantAtualLabel;
    private javax.persistence.Query query;
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
