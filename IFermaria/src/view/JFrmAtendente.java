package view;

//importações
import java.awt.EventQueue;
import java.awt.Toolkit;
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
import model.Atendimento;
import util.Conexao;
import util.Logger;
import util.Sessao;
import util.Tabelas;

public class JFrmAtendente extends JPanel {

    private JDialog jf;
    Atendimento atend;
    boolean novo = false;
    private boolean checagemObrigatoria;
    private String mensagemErro = "";
    boolean login = false;

    public JFrmAtendente(JDialog jframe, Atendimento a) {
        //construtor caso o usuário tenha aberto o frame na janela de atendimento
        atend = a;
        jf = jframe;
        initComponents();
        jf.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/inicial.png")));//seta o icone do projeto
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
    }

    public JFrmAtendente(JDialog jframe) {
        //construtor caso o usuário tenha aberto o frame na janela de inicial
        login = true;
        jf = jframe;
        initComponents();
        jPanel5.setVisible(false);
        jf.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/inicial.png")));//seta o icone do projeto
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("IFermariaPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT a FROM Atendente a order by a.nome");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        renderSenha1 = new util.RenderSenha();
        idAtendenteField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        nomeField = new javax.swing.JTextField();
        nomeLabel1 = new javax.swing.JLabel();
        idcursoField = new javax.swing.JTextField();
        txt_login = new javax.swing.JTextField();
        nomeLabel2 = new javax.swing.JLabel();
        nomeLabel3 = new javax.swing.JLabel();
        txt_senha = new javax.swing.JPasswordField();
        txt_confirmasenha = new javax.swing.JPasswordField();
        nomeLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        newButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        FormListener formListener = new FormListener();

        renderSenha1.setText("renderSenha1");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.idAtendente}"), idAtendenteField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), idAtendenteField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jTabbedPane1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        masterTable.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${login}"));
        columnBinding.setColumnName("Login");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${senha}"));
        columnBinding.setColumnName("Senha");
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
            masterTable.getColumnModel().getColumn(2).setResizable(false);
            masterTable.getColumnModel().getColumn(2).setCellRenderer(renderSenha1);
        }

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel1.setText("DIGITE O NOME:");

        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField1.addKeyListener(formListener);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("PESQUISAR", jPanel3);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        nomeField.setEditable(false);
        nomeField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), nomeField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        nomeField.addKeyListener(formListener);

        nomeLabel1.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        nomeLabel1.setText("NOME:");

        txt_login.setEditable(false);
        txt_login.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.login}"), txt_login, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txt_login.addKeyListener(formListener);

        nomeLabel2.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        nomeLabel2.setText("LOGIN");

        nomeLabel3.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        nomeLabel3.setText("SENHA");

        txt_senha.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.senha}"), txt_senha, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txt_confirmasenha.setEditable(false);

        nomeLabel4.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        nomeLabel4.setText("CONFIRMA SENHA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_login)
                    .addComponent(txt_senha)
                    .addComponent(txt_confirmasenha)
                    .addComponent(nomeField)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(nomeLabel3)
                                .addGap(404, 404, 404)
                                .addComponent(idcursoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nomeLabel1)
                            .addComponent(nomeLabel2)
                            .addComponent(nomeLabel4))
                        .addGap(0, 48, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nomeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idcursoField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txt_confirmasenha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );

        jTabbedPane1.addTab("ATENDENTE", jPanel2);

        jPanel4.setBackground(new java.awt.Color(96, 202, 164));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));

        newButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_new-24_103173.png"))); // NOI18N
        newButton.setText("NOVO");
        newButton.addActionListener(formListener);

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_create_326602.png"))); // NOI18N
        jButton2.setText("EDITAR");
        jButton2.addActionListener(formListener);

        refreshButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_Close_1891023 (1).png"))); // NOI18N
        refreshButton.setText("CANCELAR");
        refreshButton.addActionListener(formListener);

        saveButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_multimedia-27_809537.png"))); // NOI18N
        saveButton.setText("SALVAR");
        saveButton.setEnabled(false);
        saveButton.addActionListener(formListener);

        jPanel5.setBackground(new java.awt.Color(96, 202, 164));

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(formListener);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(96, 202, 164));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.setPreferredSize(new java.awt.Dimension(170, 193));

        jLabel5.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel5.setText("IFERMARIA");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ifermeiras.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(newButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(refreshButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(refreshButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.KeyListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == newButton) {
                JFrmAtendente.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == jButton2) {
                JFrmAtendente.this.jButton2ActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                JFrmAtendente.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == saveButton) {
                JFrmAtendente.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == jButton1) {
                JFrmAtendente.this.jButton1ActionPerformed(evt);
            }
        }

        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == masterTable) {
                JFrmAtendente.this.masterTableKeyPressed(evt);
            }
        }

        public void keyReleased(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == jTextField1) {
                JFrmAtendente.this.jTextField1KeyReleased(evt);
            }
            else if (evt.getSource() == nomeField) {
                JFrmAtendente.this.nomeFieldKeyReleased(evt);
            }
            else if (evt.getSource() == txt_login) {
                JFrmAtendente.this.txt_loginKeyReleased(evt);
            }
        }

        public void keyTyped(java.awt.event.KeyEvent evt) {
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                JFrmAtendente.this.masterTableMousePressed(evt);
            }
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        jf.dispose();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        if (testesValida == true) {
            model.Atendente a = new model.Atendente();//adiciona uma nova atendente ao objeto a
            entityManager.persist(a);//as consultas serão realizadas apartir desta nova atendente
            list.add(a);//adiciona uma nova atendente a lista
            int row = list.size() - 1;//seta a linha da tabela no atributo row
            masterTable.setRowSelectionInterval(row, row);//seta a linha selecionada pelo atributo row
            masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
            nomeField.setEditable(true);// será possível digiitar no campo nome
            txt_login.setEditable(true);
            txt_senha.setEditable(true);
            txt_confirmasenha.setEditable(true);
            novo = true;
            jTabbedPane1.setSelectedIndex(1);//seta a aba do painel
            jTabbedPane1.setEnabled(false);//não será possivel clicar no páinel
            saveButton.setEnabled(true);//será possivel clicar no botão de salvar
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_newButtonActionPerformed
    public void validaSalvar() {
        checagemObrigatoria = true;
//validação de preenchimento de nome
        if (nomeField.getText().equals("")) {
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO PREENCHER O CAMPO NOME!\n";
        }
        if (nomeField.getText().length() > 100) {
            checagemObrigatoria = false;//limite de preenchimeto
            mensagemErro += "♦LIMITE DE 100 CARACTERES NO CAMPO Atendente, QUANTIDADE DIGITADA: " + nomeField.getText().length() + " !\n";
        }

        if (!txt_confirmasenha.getText().equals(txt_senha.getText())) {
            checagemObrigatoria = false;
            mensagemErro += "AS SENHAS NÃO COENCIDEM!\n";
        }
    }
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        if (testesValida == true) {
            validaSalvar();
            if (checagemObrigatoria == true) {
                try {
                    Atendente a = list.get(masterTable.getSelectedRow());
                    entityManager.getTransaction().commit();//salva
                    entityManager.getTransaction().begin();
                    if (login != true) {
                        atend.setAtendente(a);//seta a atendente
                    }
                    jf.dispose();//fecha
                    JOptionPane.showMessageDialog(null, "SALVO COM SUCESSO");
                    //registra na no banco as ações feitas pelo usuario
                    if (novo = true) {
                        new Sessao(a);
                        Logger.log(Sessao.getAtendenteLogado(), null, "INSERÇÃO DE DADOS NA NOVA ATENDENTE: " + a.getNome() + " login: " + a.getLogin() + "Senha: " + a.getSenha(), Tabelas.LOGIN);
                    } else {
                        new Sessao(a);
                        Logger.log(Sessao.getAtendenteLogado(), null, "ATUALIZAÇÃO DE DADOS DA ATENDENTE: " + a.getNome() + " login: " + a.getLogin() + "Senha: " + a.getSenha(), Tabelas.LOGIN);

                    }
                } catch (RollbackException rex) {
                    //erro            
                    JOptionPane.showMessageDialog(null, "Erro ao Salvar!!\nFeche o Programa e verifique a conexão com a internet!!", "ERRO", JOptionPane.ERROR_MESSAGE);
                    rex.printStackTrace();
                    entityManager.getTransaction().begin();//inicio
                    List<model.Atendente> merged = new ArrayList<model.Atendente>(list.size());
                    for (model.Atendente a : list) {
                        merged.add(entityManager.merge(a));
                    }
                    list.clear();
                    list.addAll(merged);
                }
                refreshButton.doClick();
                jTabbedPane1.setSelectedIndex(0);//primeira aba do painel
                jTabbedPane1.setEnabled(true);//será possivel clicar no painel
            } else {//erro de validação
                JOptionPane.showMessageDialog(null, "ERRO:\n\n" + mensagemErro, "ERRO!", JOptionPane.ERROR_MESSAGE);

            }
            mensagemErro = "";
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        //seleciona as atendentes que comecem com o texto digitado pelo usuario
        query = entityManager.createQuery("select a from Atendente a where nome like :nome order by a.nome");
        query.setParameter("nome", "%" + jTextField1.getText() + "%");//seta o parametro nome com o texto digitado
        list.clear();//limpa a lista
        list.addAll(query.getResultList());//adiciona a nova lista filtrada por parametro
        if (!list.isEmpty()) {
            masterTable.setRowSelectionInterval(0, 0);//seleciona o primeiro item da lista filtrada
            if (evt.getKeyCode() == 10) {//ENTER
                jButton1.doClick();
            }
        }
        if (evt.getKeyCode() == 27) {//ESC  
            refreshButton.doClick();
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (masterTable.getSelectedRow() >= 0 && novo != true) {//se tiver alguma linha selecionada e o usuario não tiver clicado  em NOVO  
            String senhaAtual = list.get(masterTable.getSelectedRow()).getSenha();
            String senhaDigitada = JOptionPane.showInputDialog(null, "DIGITE A SENHA ATUAL");
            if (senhaAtual.equals(senhaDigitada)) {
                nomeField.setEditable(true);// será possível digiitar no campo nome
                txt_login.setEditable(true);
                txt_senha.setEditable(true);
                txt_confirmasenha.setEditable(true);
                jTabbedPane1.setSelectedIndex(1);
                jTabbedPane1.setEnabled(false);
                saveButton.setEnabled(true);
                novo = false;
            } else {
                JOptionPane.showMessageDialog(null, "SENHA INCORRETA", "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Atendente a = list.get(masterTable.getSelectedRow());
        atend.setAtendente(a);//seta a atendente
        jf.dispose();//fecha
    }//GEN-LAST:event_jButton1ActionPerformed

    private void masterTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMousePressed
        if (evt.getClickCount() == 2) {
            jTabbedPane1.setSelectedIndex(1);
        }
    }//GEN-LAST:event_masterTableMousePressed

    private void nomeFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeFieldKeyReleased
        if (evt.getKeyCode() == 10) {// ENTER
            saveButton.doClick();
        }
        if (evt.getKeyCode() == 27) {//ESC
            refreshButton.doClick();
        }
    }//GEN-LAST:event_nomeFieldKeyReleased

    private void masterTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyPressed
        if (evt.getKeyCode() == 10) {//enter
            nomeField.setEditable(true);
            jTabbedPane1.setSelectedIndex(1);
            jTabbedPane1.setEnabled(false);
            saveButton.setEnabled(true);
        }
        if (evt.getKeyCode() == 27) {//ESC
            refreshButton.doClick();
        }
    }//GEN-LAST:event_masterTableKeyPressed

    private void txt_loginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loginKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_loginKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JTextField idAtendenteField;
    private javax.swing.JTextField idcursoField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private java.util.List<model.Atendente> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField nomeField;
    private javax.swing.JLabel nomeLabel1;
    private javax.swing.JLabel nomeLabel2;
    private javax.swing.JLabel nomeLabel3;
    private javax.swing.JLabel nomeLabel4;
    private javax.persistence.Query query;
    private javax.swing.JButton refreshButton;
    private util.RenderSenha renderSenha1;
    private javax.swing.JButton saveButton;
    private javax.swing.JPasswordField txt_confirmasenha;
    private javax.swing.JTextField txt_login;
    private javax.swing.JPasswordField txt_senha;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

}
