package view;

import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Medicamento;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import util.Conexao;

public class RelatMedicamento extends javax.swing.JDialog {

    public RelatMedicamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/inicial.png")));
        medicamentoList1.clear();
        jTable1.setSelectionMode(0);
        jTable2.setSelectionMode(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        projetoEnfermariaPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("IFermariaPU").createEntityManager();
        medicamentoQuery = java.beans.Beans.isDesignTime() ? null : projetoEnfermariaPUEntityManager.createQuery("SELECT m FROM Medicamento m ORDER BY m.nome").setMaxResults(22);
        medicamentoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(medicamentoQuery.getResultList());
        medicamentoQuery1 = java.beans.Beans.isDesignTime() ? null : projetoEnfermariaPUEntityManager.createQuery("SELECT m FROM Medicamento m ORDER BY m.nome");
        medicamentoList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(medicamentoQuery1.getResultList());
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(96, 202, 164));

        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel1.setText("DIGITE O MEDICAMENTO:");

        jTable2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, medicamentoList1, jTable2);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quant_Antiga}"));
        columnBinding.setColumnName("QUANTIDADE PEDIDA");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable2.getColumnModel().getColumn(0).setHeaderValue("Nome");
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(1).setHeaderValue("Tipo");
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(2).setHeaderValue("QUANTIDADE PEDIDA");
        }

        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, medicamentoList, jTable1);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Unidade");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantTotal}"));
        columnBinding.setColumnName("Quant Total");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_down_right_308966.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("GERAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public String getToday() {
        Calendar hoje = Calendar.getInstance();
        int anoAtual = 0;
        int diaAtual = 0;
        int mesAtual = 0;
        anoAtual = hoje.get(Calendar.YEAR);
        diaAtual = hoje.get(Calendar.DAY_OF_MONTH);
        mesAtual = hoje.get(Calendar.MONTH) + 1;
        return anoAtual + "-" + mesAtual + "-" + diaAtual;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//abre o relatório
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        if (testesValida == true) {//verifica conexao
            if (medicamentoList1 != null) {

                String caminho = new File("./relatorio/relatorioMedicamentos.jrxml").getAbsolutePath();
                try {
                    this.dispose();
                    JasperReport relatorio = JasperCompileManager.compileReport(caminho);
                    JRBeanCollectionDataSource dados = new JRBeanCollectionDataSource(medicamentoList1, false);
                    JasperPrint print = JasperFillManager.fillReport(relatorio, null, dados);
                    JasperViewer view = new JasperViewer(print, false);
                    view.setVisible(true);
                } catch (JRException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(null, "Falha ao gerar Relatório!!", "Erro", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(RelatoriosControle.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "NENHUM MEDICAMENTO SELECIONADO", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        medicamentoQuery = projetoEnfermariaPUEntityManager.createQuery("select m from Medicamento m where m.nome like :nome order by m.nome").setMaxResults(22);
        medicamentoQuery.setParameter("nome", "%" + jTextField1.getText() + "%");
        medicamentoList.clear();
        medicamentoList.addAll(medicamentoQuery.getResultList());
        if (!medicamentoList.isEmpty()) {
            jTable1.setRowSelectionInterval(0, 0);

        }

    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int quant = 0;
        Set<Medicamento> mySet = new HashSet<Medicamento>();
//método que seleciona a quantidade a ser pedida e enviada pro frame, com validações
        int ls = jTable1.getSelectedRow();
        String quantTXT = "";
        if (ls >= 0) {

            boolean verificaNumeros = true;
            boolean verificaTamanho = true;

            quantTXT = JOptionPane.showInputDialog(null, "Digite a Quantidade a fazer o Pedido");
            if (quantTXT.equals("")) {
                quant = 0;
            } else {
                if (quantTXT.matches("[0-9]*")) {
                    if (quantTXT.length() <= 9) {
                        if (Integer.parseInt(quantTXT) > 9999999) {
                            verificaTamanho = false;
                        } else {
                            verificaNumeros = true;
                            quant = Integer.parseInt(quantTXT);
                        }
                    } else {
                        verificaTamanho = false;
                    }

                } else {
                    verificaNumeros = false;
                }

            }
            if (verificaNumeros == true && verificaTamanho == true) {
                if (quant > 0) {
                    Medicamento m = medicamentoList.get(ls);
                    medicamentoList1.add(m);
                    mySet.addAll(medicamentoList1);

                    if (mySet.size() == medicamentoList1.size()) {//verifica se o medicamento ja foi adicionado

                        m.setQuant_Antiga(quant);
                        medicamentoList1.clear();
                        medicamentoList1.addAll(mySet);
                        Collections.sort(medicamentoList1);
                    } else {
                        medicamentoList1.clear();
                        medicamentoList1.addAll(mySet);
                        Collections.sort(medicamentoList1);
                        JOptionPane.showMessageDialog(null, "ESTE MEDICAMENTO JA FOI ADICIONADO!!!", "ERRO", JOptionPane.ERROR_MESSAGE);

                    }
                    quant = 0;
                } else {
                    JOptionPane.showMessageDialog(null, "SELECIONE UMA QUANTIDADE!!");
                }
            } else {
                if (verificaNumeros == false) {
                    JOptionPane.showMessageDialog(null, "PREENCHA ESSE CAMPO APENAS COM NUMEROS", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
                if (verificaTamanho == false) {
                    JOptionPane.showMessageDialog(null, "VALOR MUITO GRANDE", "ERRO", JOptionPane.ERROR_MESSAGE);

                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE UM MEDICAMENTO!!");

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        int ls = jTable2.getSelectedRow();
        if (evt.getKeyCode() == 127) {
            int cont = 1;
            cont = JOptionPane.showConfirmDialog(null, "DESEJA REMOVER O MEDICAMENTO " + medicamentoList1.get(ls).getNome() + " DA TABELA ?", "REMOVER?", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (cont == 0) {

                medicamentoList1.remove(ls);
                Collections.sort(medicamentoList1);
            }
        }

    }//GEN-LAST:event_jTable2KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {

            jButton2.doClick();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == 10) {
            jButton2.doClick();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        System.out.println(testesValida);
        if (testesValida == true) {//verifica conexao
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
            jButton2.requestFocus();
        }
    }//GEN-LAST:event_jTextField1FocusGained

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private java.util.List<model.Medicamento> medicamentoList;
    private java.util.List<model.Medicamento> medicamentoList1;
    private javax.persistence.Query medicamentoQuery;
    private javax.persistence.Query medicamentoQuery1;
    private javax.persistence.EntityManager projetoEnfermariaPUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
