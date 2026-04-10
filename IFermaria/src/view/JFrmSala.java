package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Aluno;
import model.Curso;
import model.Sala;

public class JFrmSala extends JPanel {

    private JDialog jf;
    private List<Sala> salas;
    private boolean checagemObrigatoria;
    private String mensagemErro = "";
    Aluno a;

    public JFrmSala(JDialog jframe, List<Sala> salas, Curso curso, EntityManager em, Aluno a) {
        this.a = a;
        jf = jframe;
        this.salas = salas;
        initComponents();

        jf.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/inicial.png")));
        this.entityManager = em;
        query = entityManager.createQuery("SELECT s FROM Sala s");
        list.clear();
        list.addAll(query.getResultList());
        idField.setVisible(false);
        masterTable.setVisible(false);
        newButton.doClick();
        int index = masterTable.getSelectedRow();
        list.get(index).setCurso(curso);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("IFermariaPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT s FROM Sala s");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        cursoQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Curso c");
        cursoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(cursoQuery.getResultList());
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        cursoIdcursoLabel = new javax.swing.JLabel();
        salaLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        salaField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        FormListener formListener = new FormListener();

        setBackground(new java.awt.Color(204, 204, 255));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${sala}"));
        columnBinding.setColumnName("Sala");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${curso}"));
        columnBinding.setColumnName("Curso");
        columnBinding.setColumnClass(model.Curso.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        masterScrollPane.setViewportView(masterTable);

        cursoIdcursoLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        cursoIdcursoLabel.setText("Curso");

        salaLabel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        salaLabel.setText("Turma");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.id}"), idField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), idField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        salaField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        salaField.setToolTipText("DIGITE A SALA A SER ADICIONADA");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.sala}"), salaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), salaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        salaField.addKeyListener(formListener);

        saveButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_199_CircledPlus_183316 (1).png"))); // NOI18N
        saveButton.setText("ADICIONAR");
        saveButton.addActionListener(formListener);

        refreshButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_delete_678153 (1).png"))); // NOI18N
        refreshButton.setText("CANCELAR");
        refreshButton.addActionListener(formListener);

        newButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_new-24_103173.png"))); // NOI18N
        newButton.setText("NOVO");
        newButton.addActionListener(formListener);

        jComboBox1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cursoList, jComboBox1);
        jComboBoxBinding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.curso}"), jComboBox1, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jButton1.setText("deletar");
        jButton1.addActionListener(formListener);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jComboBox1, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.nome}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("");
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addComponent(saveButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cursoIdcursoLabel)
                            .addComponent(salaLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(salaField)
                            .addComponent(jTextField1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {refreshButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(refreshButton)
                        .addComponent(saveButton))
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cursoIdcursoLabel)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaLabel)
                    .addComponent(salaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextField1, salaField});

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.KeyListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                JFrmSala.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                JFrmSala.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                JFrmSala.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == jButton1) {
                JFrmSala.this.jButton1ActionPerformed(evt);
            }
        }

        public void keyPressed(java.awt.event.KeyEvent evt) {
        }

        public void keyReleased(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == salaField) {
                JFrmSala.this.salaFieldKeyReleased(evt);
            }
        }

        public void keyTyped(java.awt.event.KeyEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
        jf.dispose();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        Sala s1 = new Sala();
        entityManager.persist(s1);
        list.add(s1);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }//GEN-LAST:event_newButtonActionPerformed
    public void validaSalvar() {
        checagemObrigatoria = true;

        if (salaField.getText().equals("")) {
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO PREENCHER O CAMPO TURMA!\n";
        }
        if (jTextField1.getText().equals("")) {
            checagemObrigatoria = false;
            mensagemErro += "OBRIGATÓRIO PREENCHER O CAMPO CURSO!\n";
        }
        if (salaField.getText().length() > 20) {
            checagemObrigatoria = false;
            mensagemErro += "♦LIMITE DE 20 CARACTERES NO CAMPO TURMA, QUANTIDADE DIGITADA: " + salaField.getText().length() + " !\n";
        }
    }
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        validaSalvar();
        if (checagemObrigatoria == true) {
//adiciona o periodo ao aluno, mais não salva, apenão salva ao salvar um aluno
            model.Sala sl = list.get(masterTable.getSelectedRow());
            salas.add(sl);
            a.setSala(sl);
            JOptionPane.showMessageDialog(null, "PERÍODO ADICIONADO, AO SALVAR A PESSOA, O PERÍODO SERÁ SALVO");
            jf.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "ERRO:\n\n" + mensagemErro, "ERRO!", JOptionPane.ERROR_MESSAGE);

        }
        mensagemErro = "";
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int[] selected = masterTable.getSelectedRows();
        List<model.Sala> toRemove = new ArrayList<model.Sala>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            model.Sala s = list.get(masterTable.convertRowIndexToModel(selected[idx]));
            toRemove.add(s);
            entityManager.remove(s);
        }
        list.removeAll(toRemove);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void salaFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salaFieldKeyReleased

        if (evt.getKeyCode() == 10) {

            saveButton.doClick();
        }
        if (evt.getKeyCode() == 27) {

            refreshButton.doClick();
        }
    }//GEN-LAST:event_salaFieldKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cursoIdcursoLabel;
    private java.util.List<model.Curso> cursoList;
    private javax.persistence.Query cursoQuery;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JTextField idField;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JTextField jTextField1;
    private java.util.List<model.Sala> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.persistence.Query query;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField salaField;
    private javax.swing.JLabel salaLabel;
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
