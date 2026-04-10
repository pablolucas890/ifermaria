package view;

//importações
import java.awt.Color;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Estoque;

public class AddEstoque extends javax.swing.JDialog {

    private boolean confirmado;
    private Estoque estoque;

    public AddEstoque(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/inicial.png")));//seta o icone do projeto
        jTable1.setSelectionMode(0);//só é possivel selecionar uma linha da tabela
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        projetoEnfermariaPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("IFermariaPU").createEntityManager();
        estoqueQuery = java.beans.Beans.isDesignTime() ? null : projetoEnfermariaPUEntityManager.createQuery("SELECT e FROM Estoque e where e.quantAtual != 0   order by e.medicamento.nome, e.dataValidade, e.quantAtual").setMaxResults(22);
        estoqueList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(estoqueQuery.getResultList());
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(96, 202, 164));

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel1.setText("Estoque:");

        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, estoqueList, jTable1);
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
        }

        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("Confirma");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("Cancela");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 221, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        //seleciona todos os estoque que comecem com o texto digitado pelo usuário
        estoqueQuery = projetoEnfermariaPUEntityManager.createQuery("select e"
                + " from Estoque e where e.medicamento.nome like :nome and e.quantAtual != 0  order by e.medicamento.nome, e.dataValidade, e.quantAtual").setMaxResults(22);
        estoqueQuery.setParameter("nome", "%" + jTextField1.getText() + "%");//seta no parametro nome o texto digitado pelo usuario
        estoqueList.clear();//limpa a lista
        estoqueList.addAll(estoqueQuery.getResultList());//adiciona a nova lista filtrada pelo parametro
        if (!estoqueList.isEmpty()) {//se tiver algo na lista
            jTable1.setRowSelectionInterval(0, 0);//seta o primeiro item da lista
            Date data = estoqueList.get(jTable1.getSelectedRow()).getDataValidade();
            if (data != null) {
                Calendar hoje = Calendar.getInstance();//pega o instante atual
                int anoAtual = hoje.get(Calendar.YEAR),//pega o ano atual
                        mesAtual = hoje.get(Calendar.MONTH) + 1,//pega o mes atual
                        diaAAtual = hoje.get(Calendar.DAY_OF_MONTH),//pega o dia atual
                        diaValidade = 0, mesValidade = 0, anoValidade = 0;
                String diaValidadeStr = estoqueList.get(jTable1.getSelectedRow()).getDataValidade().toString().substring(8, 10),//pega o dia do atributo data de validade
                        mesValidadeStr = estoqueList.get(jTable1.getSelectedRow()).getDataValidade().toString().substring(5, 7),//pega o mes do atributo data de validade
                        anoValidadeStr = estoqueList.get(jTable1.getSelectedRow()).getDataValidade().toString().substring(0, 4);//pega o ano do atributo data de validade

                if (!diaValidadeStr.equals("  ")) {
                    //se o dia for diferente de vazio adiciona os numeros na variavel INT para que seja possivel fazer as contas
                    diaValidade = Integer.parseInt(diaValidadeStr);
                }
                if (!mesValidadeStr.equals("  ")) {
                    //se o mes for diferente de vazio adiciona os numeros na variavel INT para que seja possivel fazer as contas
                    mesValidade = Integer.parseInt(mesValidadeStr);
                }
                if (!anoValidadeStr.equals("    ")) {
                    //se o ano for diferente de vazio adiciona os numeros na variavel INT para que seja possivel fazer as contas
                    anoValidade = Integer.parseInt(anoValidadeStr);
                }
                if (((anoValidade < anoAtual) || ((mesValidade < mesAtual) && (anoValidade <= anoAtual))
                        || ((diaValidade < diaAAtual) && (mesValidade <= mesAtual) && (anoValidade <= anoAtual)))) {
                    //verifica se a data de data de validade é menor q o dia atual
                    //se sim coloca cor vermelho na linha selecionada
                    jTable1.setSelectionBackground(Color.red);
                } else {
                    //se não coloca cor azul(padrão) na linha selecionada
                    jTable1.setSelectionBackground(new java.awt.Color(0, 120, 215));
                }
            }
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int ls = jTable1.getSelectedRow();
        if (ls >= 0) {//se tiver alguma linha selecionada da tabela
            estoque = estoqueList.get(ls);
            setConfirmado(true);//confirmou
            dispose();//fecha
        } else {
            //se não selecionar nehuma linha da tabela
            JOptionPane.showMessageDialog(null, "Selecione um Medicamento");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setConfirmado(false);//não confirmou
        this.dispose();//fecha
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed

        if (evt.getKeyCode() == 10) {//ENTER
            jButton1.doClick();
        }
        if (evt.getKeyCode() == 27) {//ESC
            jButton2.doClick();
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed

        if (evt.getKeyCode() == 10) {//ENTER
            jButton1.doClick();
        }
        if (evt.getKeyCode() == 27) {//ESC  
            jButton2.doClick();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        Date data = estoqueList.get(jTable1.getSelectedRow()).getDataValidade();
        if (data != null) {
            Calendar hoje = Calendar.getInstance();//pega o instante atual
            int anoAtual = hoje.get(Calendar.YEAR);//pega o ano atual
            int mesAtual = hoje.get(Calendar.MONTH) + 1;//pega o mes atual
            int diaAAtual = hoje.get(Calendar.DAY_OF_MONTH);// pega o dia atual
            String diaValidadeStr = estoqueList.get(jTable1.getSelectedRow()).getDataValidade().toString().substring(8, 10);//pega o dia do atributo data de validade
            String mesValidadeStr = estoqueList.get(jTable1.getSelectedRow()).getDataValidade().toString().substring(5, 7);//pega o mes do atributo data de validade
            String anoValidadeStr = estoqueList.get(jTable1.getSelectedRow()).getDataValidade().toString().substring(0, 4);//pega o ano do atributo data de validade
            int diaValidade = 0, mesValidade = 0, anoValidade = 0;
            if (!diaValidadeStr.equals("  ")) {
                //se o dia for diferente de vazio adiciona os numeros na variavel INT para que seja possivel fazer as contas
                diaValidade = Integer.parseInt(diaValidadeStr);
            }
            if (!mesValidadeStr.equals("  ")) {
                //se o mes for diferente de vazio adiciona os numeros na variavel INT para que seja possivel fazer as contas        
                mesValidade = Integer.parseInt(mesValidadeStr);
            }
            if (!anoValidadeStr.equals("    ")) {
                //se o ano for diferente de vazio adiciona os numeros na variavel INT para que seja possivel fazer as contas
                anoValidade = Integer.parseInt(anoValidadeStr);
            }
            if (((anoValidade < anoAtual) || ((mesValidade < mesAtual) && (anoValidade <= anoAtual))
                    || ((diaValidade < diaAAtual) && (mesValidade <= mesAtual) && (anoValidade <= anoAtual)))) {
                //verifica se a data de data de validade é menor q o dia atual
                //se sim coloca cor vermelho na linha selecionada
                jTable1.setSelectionBackground(Color.red);
            } else {
                //se não coloca cor azul (padrão) na linha selecionada 
                jTable1.setSelectionBackground(new java.awt.Color(0, 120, 215));
            }
        }
        if (evt.getClickCount() == 2) {//dois clique com o mouse
            jButton1.doClick();//clica  botão (jButton1)
        }
    }//GEN-LAST:event_jTable1MousePressed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        if (jTable1.getSelectedRow() >= 0) {
            Date data = estoqueList.get(jTable1.getSelectedRow()).getDataValidade();
            if (data != null) {
                Calendar hoje = Calendar.getInstance();//pega o instante atual
                int anoAtual = hoje.get(Calendar.YEAR),//pega o ano atual
                        mesAtual = hoje.get(Calendar.MONTH) + 1,//pega o mes atual
                        diaAAtual = hoje.get(Calendar.DAY_OF_MONTH),//pega o dia atual
                        diaValidade = 0, mesValidade = 0, anoValidade = 0;
                String diaValidadeStr = estoqueList.get(jTable1.getSelectedRow()).getDataValidade().toString().substring(8, 10),//pega o dia do atributo data de validade
                        mesValidadeStr = estoqueList.get(jTable1.getSelectedRow()).getDataValidade().toString().substring(5, 7),//pega o mes do atributo data de validade
                        anoValidadeStr = estoqueList.get(jTable1.getSelectedRow()).getDataValidade().toString().substring(0, 4);//pega o ano do atributo data de validade

                if (!diaValidadeStr.equals("  ")) {
                    //se o dia for diferente de vazio adiciona os numeros na variavel INT para que seja possivel fazer as contas
                    diaValidade = Integer.parseInt(diaValidadeStr);
                }
                if (!mesValidadeStr.equals("  ")) {
                    //se o mes for diferente de vazio adiciona os numeros na variavel INT para que seja possivel fazer as contas
                    mesValidade = Integer.parseInt(mesValidadeStr);
                }
                if (!anoValidadeStr.equals("    ")) {
                    //se o ano for diferente de vazio adiciona os numeros na variavel INT para que seja possivel fazer as contas
                    anoValidade = Integer.parseInt(anoValidadeStr);
                }
                if (((anoValidade < anoAtual) || ((mesValidade < mesAtual) && (anoValidade <= anoAtual))
                        || ((diaValidade < diaAAtual) && (mesValidade <= mesAtual) && (anoValidade <= anoAtual)))) {
                    //verifica se a data de data de validade é menor q o dia atual
                    //se sim coloca cor vermelho na linha selecionada
                    jTable1.setSelectionBackground(Color.red);
                } else {
                    //se não coloca cor azul (padrão) na linha selecionada 
                    jTable1.setSelectionBackground(new java.awt.Color(0, 120, 215));
                }
            }
        }
    }//GEN-LAST:event_jTable1KeyReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<model.Estoque> estoqueList;
    private javax.persistence.Query estoqueQuery;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.persistence.EntityManager projetoEnfermariaPUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
