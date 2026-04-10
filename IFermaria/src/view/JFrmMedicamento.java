package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Beans;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Atendente;
import model.Medicamento;
import util.Conexao;

public class JFrmMedicamento extends JPanel {

    private JDialog jf;
    private List<Medicamento> medicamentos;
    boolean checagemObrigatoria = true;
    String mensagemErro = "";
    boolean checagem_nao_Obrigatoria = true;
    String mensagemErro_nao_Obrigatoria = "";
    Atendente at;

    public JFrmMedicamento(JDialog jframe, List<Medicamento> medicamentos, Atendente at) {
        jf = jframe;
        this.at = at;
        jf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {//método executado ao fechar o frame (abre o JFrmEstoque)
                jf.dispose();
                Connection conn;
                conn = Conexao.getConnection();
                boolean testesValida = Conexao.isValida();
                if (testesValida == true) {
                    JDialog frame = new JDialog(new JDialog(), true);
                    frame.setContentPane(new JFrmEstoque(frame, at));
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setTitle("ESTOQUE");
                    frame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.medicamentos = medicamentos;
        initComponents();
        jf.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/inicial.png")));

        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
        jComboBox2.setEnabled(false);
        saveButton.setEnabled(false);
        editableFalse();
        masterTable.setSelectionMode(0);
        jButton4.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("IFermariaPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT m FROM Medicamento m order by m.nome").setMaxResults(29);
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        idmedicamentoField = new javax.swing.JTextField();
        quantTotalField = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        unidadeLabel = new javax.swing.JLabel();
        miligramaField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        nomeLabel1 = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        nomeLabel = new javax.swing.JLabel();
        miligramaField = new javax.swing.JTextField();
        miligramaLabel = new javax.swing.JLabel();
        unidadeLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        idestoqueField2 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setBackground(new java.awt.Color(204, 204, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.idmedicamento}"), idmedicamentoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), idmedicamentoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        quantTotalField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.quantTotal}"), quantTotalField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), quantTotalField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.setText("Delete");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        masterTable.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Unidade");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${catmat}"));
        columnBinding.setColumnName("Catmat");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterTable.addMouseListener(formListener);
        masterTable.addKeyListener(formListener);
        masterScrollPane.setViewportView(masterTable);
        if (masterTable.getColumnModel().getColumnCount() > 0) {
            masterTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            masterTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel2.setText("DIGITE O NOME DO MEDICAMENTO:");

        jTextField3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField3.setToolTipText("PESQUISAR MEDICAMENTO");
        jTextField3.addFocusListener(formListener);
        jTextField3.addKeyListener(formListener);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField3))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("PESQUISAR", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        unidadeLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        unidadeLabel.setText("Unidade:");

        miligramaField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        miligramaField1.setToolTipText("CATMAT");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.catmat}"), miligramaField1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("");
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), miligramaField1, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        miligramaField1.addKeyListener(formListener);

        jComboBox1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Comprimido", "Frasco", "Ampola", "Bisnaga", "Material" }));
        jComboBox1.setSelectedIndex(-1);
        jComboBox1.setToolTipText("TIPO DO MEDICAMENTO");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.tipo}"), jComboBox1, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        binding.setSourceNullValue(null);
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);

        nomeLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        nomeLabel1.setText("Descrição:");

        nomeField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        nomeField.setToolTipText("NOME DO MEDICAMENTO");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), nomeField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("DESCRIÇÃO DO MEDICAMENTO, SERÁ UTILIZADA AO GERAR O RELATÓRIO DE MEDICAMENTOS");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.descricao}"), jTextArea1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("");
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("♦");
        jLabel1.addMouseListener(formListener);

        nomeLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        nomeLabel.setText("Nome:");

        miligramaField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        miligramaField.setToolTipText("UNIDADE DO MEDICAMENTO");
        miligramaField.addKeyListener(formListener);

        miligramaLabel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        miligramaLabel.setText("Dosagem:");

        unidadeLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        unidadeLabel1.setText("CatMat");

        jComboBox2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MG", "ML", "G" }));
        jComboBox2.setSelectedIndex(-1);
        jComboBox2.setToolTipText("TIPO DA UNIDADE (EX...MG,ML,G)");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.unidade}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(unidadeLabel)
                                .addGap(224, 224, 224)
                                .addComponent(unidadeLabel1))
                            .addComponent(nomeLabel)
                            .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(miligramaField1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(miligramaLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(miligramaField, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(nomeLabel)
                .addGap(18, 18, 18)
                .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nomeLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(unidadeLabel)
                            .addComponent(unidadeLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(miligramaField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(miligramaLabel)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(miligramaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DADOS", jPanel1);

        jPanel7.setBackground(new java.awt.Color(96, 202, 164));

        jPanel8.setBackground(new java.awt.Color(96, 202, 164));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ifermeiras.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel8.setText("IFERMARIA");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        refreshButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_home_298794.png"))); // NOI18N
        refreshButton.setText("HOME");
        refreshButton.setToolTipText("VOLTAR AO INÍCIO");
        refreshButton.addActionListener(formListener);

        saveButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_multimedia-27_809537.png"))); // NOI18N
        saveButton.setText("SALVAR");
        saveButton.setToolTipText("SALVAR MEDICAMENTO");
        saveButton.addActionListener(formListener);

        newButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_new-24_103173.png"))); // NOI18N
        newButton.setText("NOVO");
        newButton.setToolTipText("NOVO MEDICAMENTO");
        newButton.addActionListener(formListener);

        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_create_326602.png"))); // NOI18N
        jButton4.setText("EDITAR");
        jButton4.setToolTipText("EDITAR MEDICAMENTO");
        jButton4.addActionListener(formListener);

        jButton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_Close_1891023 (1).png"))); // NOI18N
        jButton5.setText("SAIR");
        jButton5.setToolTipText("EDITAR MEDICAMENTO");
        jButton5.addActionListener(formListener);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(idestoqueField2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(newButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(refreshButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(24, 24, 24)
                .addComponent(idestoqueField2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 515, Short.MAX_VALUE)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(quantTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(idmedicamentoField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idmedicamentoField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(382, 382, 382))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("DADOS");

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.FocusListener, java.awt.event.KeyListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == deleteButton) {
                JFrmMedicamento.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                JFrmMedicamento.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == saveButton) {
                JFrmMedicamento.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                JFrmMedicamento.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == jButton4) {
                JFrmMedicamento.this.jButton4ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton5) {
                JFrmMedicamento.this.jButton5ActionPerformed(evt);
            }
        }

        public void focusGained(java.awt.event.FocusEvent evt) {
            if (evt.getSource() == jTextField3) {
                JFrmMedicamento.this.jTextField3FocusGained(evt);
            }
        }

        public void focusLost(java.awt.event.FocusEvent evt) {
        }

        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == jTextField3) {
                JFrmMedicamento.this.jTextField3KeyPressed(evt);
            }
        }

        public void keyReleased(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == masterTable) {
                JFrmMedicamento.this.masterTableKeyReleased(evt);
            }
            else if (evt.getSource() == jTextField3) {
                JFrmMedicamento.this.jTextField3KeyReleased(evt);
            }
            else if (evt.getSource() == miligramaField1) {
                JFrmMedicamento.this.miligramaField1KeyReleased(evt);
            }
            else if (evt.getSource() == miligramaField) {
                JFrmMedicamento.this.miligramaFieldKeyReleased(evt);
            }
        }

        public void keyTyped(java.awt.event.KeyEvent evt) {
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == jLabel1) {
                JFrmMedicamento.this.jLabel1MouseClicked(evt);
            }
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                JFrmMedicamento.this.masterTableMousePressed(evt);
            }
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                JFrmMedicamento.this.masterTableMouseReleased(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        if (testesValida == true) {
            try {
                jTextField3.setText("");
                entityManager.getTransaction().rollback();
                entityManager.getTransaction().begin();
                java.util.Collection data = query.getResultList();
                for (Object entity : data) {
                    entityManager.refresh(entity);
                }
                list.clear();
                list.addAll(data);
                query = entityManager.createQuery("SELECT m FROM Medicamento m order by m.nome").setMaxResults(29);
                list.clear();
                list.addAll(query.getResultList());
                jTabbedPane1.setSelectedIndex(0);
                jTabbedPane1.setEnabled(true);
                saveButton.setEnabled(false);
                jTabbedPane1.setSelectedIndex(0);
                jTabbedPane1.setEnabled(true);
                editableFalse();
                miligramaField.setText("");
                jComboBox2.setSelectedIndex(-1);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro selecionar Medicamentos cadastrados!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int[] selected = masterTable.getSelectedRows();
        List<model.Medicamento> toRemove = new ArrayList<model.Medicamento>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            model.Medicamento m = list.get(masterTable.convertRowIndexToModel(selected[idx]));
            toRemove.add(m);
            entityManager.remove(m);
        }
        list.removeAll(toRemove);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed

        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        System.out.println(testesValida);
        if (testesValida == true) {
            model.Medicamento m = new model.Medicamento();
            medicamentos.add(m);
            entityManager.persist(m);
            list.add(m);
            int row = list.size() - 1;
            masterTable.setRowSelectionInterval(row, row);
            masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
            quantTotalField.setText("0");
            miligramaField.setText("");
            jComboBox2.setSelectedIndex(-1);
            jTabbedPane1.setSelectedIndex(1);
            jTabbedPane1.setEnabled(false);
            editableTrue();
            saveButton.setEnabled(true);
            jButton4.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_newButtonActionPerformed
    public void validaSalvar() {
        checagemObrigatoria = true;
        if (nomeField.getText().equals("")) {//validação de preenchimento
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO PREENCHER O CAMPO NOME!\n";
        }
        if (!miligramaField.getText().equals("") && jComboBox2.getSelectedIndex() == -1) {//validação de preenchimento
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO SELECIONAR O TIPO DE DOSAGEM (MG, ML, G...)\n";
        }
        if (miligramaField.getText().equals("") && jComboBox2.getSelectedIndex() != -1) {//validação de preenchimento
            checagemObrigatoria = false;
            mensagemErro += "TIPO DE DOSAGEM SELECIONADA, MAS CAMPO NÃO FOI PREENCHIDO!\n";
        }

        if (jComboBox1.getSelectedIndex() == -1) {//validação de preenchimento
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO SELECIONAR A UNIDADE!\n";
        }
        if (!miligramaField1.getText().matches("[0-9]*")) {//validação de caractere não numérico
            checagemObrigatoria = false;
            mensagemErro += "CARACTERE NÃO NUMÉRICO NO CAMPO CATMAT!\n";
        }
        if (miligramaField.getText().length() > 10) {//validação de limite
            checagemObrigatoria = false;
            mensagemErro += "♦LIMITE DE 10 CARACTERES NO CAMPO DOSAGEM, QUANTIDADE DIGITADA:" + miligramaField.getText().length() + " !\n";
        }
        if (nomeField.getText().length() > 100) {//validação de limite
            checagemObrigatoria = false;
            mensagemErro += "♦LIMITE DE 100 CARACTERES NO CAMPO NOME, QUANTIDADE DIGITADA: " + nomeField.getText().length() + " !\n";
        }
        if (jTextArea1.getText().length() > 200) {//validação de limite
            checagemObrigatoria = false;
            mensagemErro += "♦LIMITE DE 200 CARACTERES NA DESCRIÇÃO, QUANTIDADE DIGITADA: " + jTextArea1.getText().length() + " !\n";
        }
        if (miligramaField1.getText().length() > 8) {//validação de limite
            checagemObrigatoria = false;
            mensagemErro += "♦LIMITE DE 8 CARACTERES NO CAMPO CATMAT, QUANTIDADE DIGITADA: " + miligramaField1.getText().length() + " !\n";
        }

    }

    public void check_n_Obrigatoria() {
        checagem_nao_Obrigatoria = true;
        if (jTextArea1.getText().equals("")) {
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (Descrição) NÃO PREENCHIDO!\n";
        }
        if (miligramaField.getText().equals("") && jComboBox2.getSelectedIndex() == -1) {
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (Dosagem) NÃO PREENCHIDO!\n";
        }
        if (miligramaField1.getText().equals("")) {
            checagem_nao_Obrigatoria = false;
            mensagemErro_nao_Obrigatoria += "CAMPO (CATMAT) NÃO PREENCHIDO!\n";
        }

    }

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        if (testesValida == true) {
            validaSalvar();

            check_n_Obrigatoria();

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
                        String miligrama;
                        if (jComboBox2.getSelectedIndex() == -1) {
                            miligrama = "";
                        } else {
                            miligrama = miligramaField.getText() + " " + jComboBox2.getSelectedItem().toString();
                        }
                        int index = masterTable.getSelectedRow();
                        m = list.get(index);
                        m.setUnidade(miligrama);//salva a unidade
                        m.setTipo(jComboBox1.getSelectedItem().toString());
                        entityManager.getTransaction().commit();//salva
                        entityManager.getTransaction().begin();
                        JOptionPane.showMessageDialog(null, "SALVO COM SUCESSO");
                    } catch (RollbackException rex) {
                        JOptionPane.showMessageDialog(null, "ERRO AO SALVAR!Feche o Programa e verifique a conexão com a internet", "ERRO", JOptionPane.ERROR_MESSAGE);
                        rex.printStackTrace();
                        entityManager.getTransaction().begin();
                        List<model.Medicamento> merged = new ArrayList<model.Medicamento>(list.size());
                        for (model.Medicamento m : list) {
                            merged.add(entityManager.merge(m));
                        }
                        list.clear();
                        list.addAll(merged);
                    }
                    refreshButton.doClick();
                    mensagemErro = "";
                } else {
                    JOptionPane.showMessageDialog(null, "ERRO:\n\n" + mensagemErro, "ERRO!", JOptionPane.ERROR_MESSAGE);
                    mensagemErro = "";
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

    private void miligramaField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_miligramaField1KeyReleased
        String digitos = "0123456789";
        String texto = miligramaField1.getText();
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
            miligramaField1.setText("");
        }
    }//GEN-LAST:event_miligramaField1KeyReleased

    private void miligramaFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_miligramaFieldKeyReleased
        if (!miligramaField.getText().equals("")) {

            jComboBox2.setEnabled(true);
        } else {
            jComboBox2.setEnabled(false);
            jComboBox2.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_miligramaFieldKeyReleased

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if (evt.getClickCount() == 2 && jComboBox2.getSelectedIndex() != -1 && nomeField.isEditable()) {

            jComboBox2.setSelectedIndex(-1);
            jComboBox2.setEnabled(false);
            miligramaField.setText("");
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        query = entityManager.createQuery("select m from Medicamento m where m.nome like :nome order by m.nome").setMaxResults(29);
        query.setParameter("nome", "%" + jTextField3.getText() + "%");
        list.clear();
        list.addAll(query.getResultList());
        if (!list.isEmpty()) {
            masterTable.setRowSelectionInterval(0, 0);
            editableFalse();
            setMG();
            jButton4.setEnabled(true);
        }
    }//GEN-LAST:event_jTextField3KeyReleased
    public void editableTrue() {

        nomeField.setEditable(true);
        jTextArea1.setEditable(true);
        miligramaField.setEditable(true);
        miligramaField1.setEditable(true);
        jTextArea1.setEditable(true);
        jComboBox1.setEnabled(true);
    }

    public void editableFalse() {

        nomeField.setEditable(false);
        jTextArea1.setEditable(false);
        miligramaField.setEditable(false);
        miligramaField1.setEditable(false);
        jTextArea1.setEditable(false);
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int ls = masterTable.getSelectedRow();
        if (ls >= 0) {
            jTabbedPane1.setSelectedIndex(1);
            jTabbedPane1.setEnabled(false);
            saveButton.setEnabled(true);
            editableTrue();
            if (!miligramaField.getText().equals("") || jComboBox2.getSelectedIndex() != -1) {
                jComboBox2.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Medicamento para ser Editado", "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        if (evt.getKeyCode() == 10) {
            jTabbedPane1.setSelectedIndex(1);
        }
    }//GEN-LAST:event_jTextField3KeyPressed
    public void setMG() {
        int ls = masterTable.getSelectedRow();//método que separa a unidade do valor para seta no jComboBox
        if (!list.get(ls).getUnidade().equals("")) {
            String unidadeTXT = list.get(ls).getUnidade();
            int tamanho = unidadeTXT.length();
            String finalTXT = unidadeTXT.substring(tamanho - 2, tamanho);
            if (finalTXT.equals("MG")) {
                jComboBox2.setSelectedIndex(0);
                miligramaField.setText(unidadeTXT.substring(0, tamanho - 3));
            } else if (finalTXT.equals("ML")) {
                jComboBox2.setSelectedIndex(1);
                miligramaField.setText(unidadeTXT.substring(0, tamanho - 3));
            } else if (finalTXT.equals(" G")) {
                jComboBox2.setSelectedIndex(2);
                miligramaField.setText(unidadeTXT.substring(0, tamanho - 2));
            }
        } else {
            jComboBox2.setSelectedIndex(-1);
            miligramaField.setText("");
        }
    }
    private void masterTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMousePressed
        editableFalse();
        setMG();
        jButton4.setEnabled(true);
        if (evt.getClickCount() == 2) {
            jTabbedPane1.setSelectedIndex(1);
        }
    }//GEN-LAST:event_masterTableMousePressed

    private void masterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyReleased
        editableFalse();
        setMG();
        jButton4.setEnabled(true);
    }//GEN-LAST:event_masterTableKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jf.dispose();
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        if (testesValida == true) {
            JDialog frame = new JDialog(new JDialog(), true);
            frame.setContentPane(new JFrmEstoque(frame, at));
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setTitle("ESTOQUE");
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased
        editableFalse();
        setMG();
        jButton4.setEnabled(true);
    }//GEN-LAST:event_masterTableMouseReleased

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        System.out.println(testesValida);
        if (testesValida == true) {
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
            refreshButton.requestFocus();
        }
    }//GEN-LAST:event_jTextField3FocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JTextField idestoqueField2;
    private javax.swing.JTextField idmedicamentoField;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private java.util.List<model.Medicamento> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JTextField miligramaField;
    private javax.swing.JTextField miligramaField1;
    private javax.swing.JLabel miligramaLabel;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField nomeField;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JLabel nomeLabel1;
    private javax.swing.JTextField quantTotalField;
    private javax.persistence.Query query;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel unidadeLabel;
    private javax.swing.JLabel unidadeLabel1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

}
