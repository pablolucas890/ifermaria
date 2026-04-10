package view;

import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.Conexao;

public class RelatoriosControle extends JDialog {

    private boolean mensal = false;
    private boolean diario;
    private String diaAtual;
    private boolean enfermidade;

    public RelatoriosControle(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/inicial.png")));
        jPanel1.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager1 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("IFermariaPU").createEntityManager();
        medicamentoQuery1 = java.beans.Beans.isDesignTime() ? null : entityManager1.createQuery("SELECT m FROM Medicamento m order by m.nome");
        medicamentoList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(medicamentoQuery1.getResultList());
        atendimentoQuery = java.beans.Beans.isDesignTime() ? null : entityManager1.createQuery("SELECT a FROM Atendimento a");
        atendimentoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(atendimentoQuery.getResultList());
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(96, 202, 164));

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_today_326713.png"))); // NOI18N
        jButton4.setText("RELATÓRIO DIARIO");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_Doctors_2_753952.png"))); // NOI18N
        jButton1.setText("RELATÓRIO DE MEDICAMENTOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_Calendar01_928424.png"))); // NOI18N
        jButton2.setText("RELATÓRIO MENSAL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_heart_1118211.png"))); // NOI18N
        jButton3.setText("RELATÓRIO DE ENFERMIDADES");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(96, 202, 164));

        jButton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton5.setText("OK");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(96, 202, 164));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Data:");

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jFormattedTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextField1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(96, 202, 164));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Ano:");

        jComboBox2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100" }));

        jComboBox1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        jComboBox1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Mês:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBox1, jComboBox2});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBox1, jComboBox2});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        if (testesValida == true) {//verifica conexao

            this.dispose();
            RelatMedicamento frm = new RelatMedicamento(new JFrame(), true);
            frm.setLocationRelativeTo(null);
            frm.setResizable(false);
            frm.setTitle("RELATÓRIO DE MEDICAMENTOS");
            frm.setVisible(true);
            diario = false;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        jPanel6.setVisible(true);
        Calendar hoje = Calendar.getInstance();
        int anoAtual = 0;
        anoAtual = hoje.get(Calendar.YEAR);
        int mes = hoje.get(Calendar.MONTH);
        jComboBox1.setSelectedIndex(mes);
        jComboBox2.setSelectedIndex(anoAtual - 2000);
        diario = false;
        mensal = true;
        enfermidade = false;

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Connection conn;
        conn = Conexao.getConnection();
        boolean testesValida = Conexao.isValida();
        if (testesValida == true) {//verifica conexao
            int mes = jComboBox1.getSelectedIndex() + 1;
            int ano = Integer.parseInt(jComboBox2.getSelectedItem().toString());
            if (mensal == true) {// se o usario clicou em mensal seleciona todas as quantidade e repassa por meio de parametros
                int outros = 0;
                int quantTotal = 0;
                int quantLocal = 0;
                int quantPostoInconfidentes = 0;
                int quantProntoOuroFino = 0;
                int quantPousoAlegre = 0;
                int quantNenhum = 0;
                try {
                    atendimentoQuery = entityManager1.createQuery("select a from  Atendimento a where month(a.dataAtendimento) = " + mes + " and year(a.dataAtendimento) = " + ano);
                    atendimentoList.clear();
                    atendimentoList.addAll(atendimentoQuery.getResultList());
                    quantTotal = atendimentoList.size();

                    atendimentoQuery = entityManager1.createQuery("select a from  Atendimento a where month(a.dataAtendimento) = :mes and year(a.dataAtendimento) = :ano AND a.encaminhamento like :EncaminhamentoParamter");
                    atendimentoQuery.setParameter("EncaminhamentoParamter", "CONSULTA MÉDICA LOCAL");
                    atendimentoQuery.setParameter("mes", mes);
                    atendimentoQuery.setParameter("ano", ano);
                    atendimentoList.clear();
                    atendimentoList.addAll(atendimentoQuery.getResultList());
                    quantLocal = atendimentoList.size();

                    atendimentoQuery.setParameter("EncaminhamentoParamter", "POSTO DE SAÚDE EM INCONFIDENTES");
                    atendimentoList.clear();
                    atendimentoList.addAll(atendimentoQuery.getResultList());
                    quantPostoInconfidentes = atendimentoList.size();

                    atendimentoQuery.setParameter("EncaminhamentoParamter", "PRONTO ATENDIMENTO OURO FINO");
                    atendimentoList.clear();
                    atendimentoList.addAll(atendimentoQuery.getResultList());
                    quantProntoOuroFino = atendimentoList.size();

                    atendimentoQuery.setParameter("EncaminhamentoParamter", "POUSO ALEGRE");
                    atendimentoList.clear();
                    atendimentoList.addAll(atendimentoQuery.getResultList());
                    quantPousoAlegre = atendimentoList.size();

                    atendimentoQuery.setParameter("EncaminhamentoParamter", "");
                    atendimentoList.clear();
                    atendimentoList.addAll(atendimentoQuery.getResultList());
                    quantNenhum = atendimentoList.size();

                    outros = quantTotal - (quantLocal + quantPostoInconfidentes + quantPousoAlegre + quantProntoOuroFino + quantNenhum);

                } catch (Exception e) {
                    System.out.println(e);
                }
                if (outros > 0) {
                    String caminho1 = new File("./relatorio/outros.jasper").getAbsolutePath();
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("outros", outros);
                    params.put("mes", mes);
                    params.put("ano", ano);
                    try {
                        this.dispose();
                        //JasperReport relatorio = JasperCompileManager.compileReport(caminho1);
                        JasperPrint print = JasperFillManager.fillReport(caminho1, params, Conexao.getConnection());
                        JasperViewer view = new JasperViewer(print, false);
                        view.setVisible(true);
                    } catch (JRException ex) {
                        System.out.println(ex);
                        JOptionPane.showMessageDialog(null, "Falha ao gerar Relatório!!", "Erro", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(RelatoriosControle.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                String caminho1 = new File("./relatorio/relatorioMensal.jasper").getAbsolutePath();
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("mes", mes);
                params.put("ano", ano);
                params.put("ouroFino", quantProntoOuroFino);
                params.put("inconfidentes", quantPostoInconfidentes);
                params.put("pousoAlegre", quantPousoAlegre);
                params.put("local", quantLocal);
                params.put("total", quantTotal);
                params.put("quantNenhum", quantNenhum);
                params.put("outros", outros);
                try {
                    this.dispose();
                    //  JasperReport relatorio = JasperCompileManager.compileReport(caminho1);
                    JasperPrint print = JasperFillManager.fillReport(caminho1, params, Conexao.getConnection());
                    JasperViewer view = new JasperViewer(print, false);
                    view.setVisible(true);
                } catch (JRException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(null, "Falha ao gerar Relatório!!", "Erro", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(RelatoriosControle.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (diario == true) {
                this.dispose();
                String caminho1 = new File("./relatorio/relatorioDiario2.jasper").getAbsolutePath();
                String caminho2 = new File("./relatorio").getAbsolutePath();
                Map<String, Object> params = new HashMap<String, Object>();

                params.put("day", getDia());
                params.put("SUBREPORT_DIR", caminho2);
                try {
                    //  JasperReport relatorio = JasperCompileManager.compileReport(caminho1);
                    JasperPrint print = JasperFillManager.fillReport(caminho1, params, Conexao.getConnection());
                    JasperViewer view = new JasperViewer(print, false);
                    view.setVisible(true);
                } catch (JRException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(null, "Falha ao gerar Relatório!!", "Erro", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(RelatoriosControle.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {//se o usuario selecionou enfermidades
                String caminho1 = new File("./relatorio/relatorioEnfermidades.jasper").getAbsolutePath();
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("mes", mes);
                params.put("ano", ano);
                try {
                    this.dispose();
                    //   JasperReport relatorio = JasperCompileManager.compileReport(caminho1);
                    JasperPrint print = JasperFillManager.fillReport(caminho1, params, Conexao.getConnection());
                    JasperViewer view = new JasperViewer(print, false);
                    view.setVisible(true);
                } catch (JRException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(null, "Falha ao gerar Relatório!!", "Erro", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(RelatoriosControle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            jComboBox1.setSelectedIndex(0);
            jComboBox2.setSelectedIndex(0);
            jPanel1.setVisible(false);
            mensal = false;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar com o servidor!!\nFeche o Programa e verifique a conexão com a internet!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jPanel1.setVisible(true);
        getToday();
        jPanel6.setVisible(false);
        jPanel2.setVisible(true);
        diario = true;
        mensal = false;
        enfermidade = false;
        jFormattedTextField1.setText(diaAtual);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        jPanel6.setVisible(true);
        Calendar hoje = Calendar.getInstance();
        int anoAtual = 0;
        anoAtual = hoje.get(Calendar.YEAR);
        int mes = hoje.get(Calendar.MONTH);
        jComboBox1.setSelectedIndex(mes);
        jComboBox2.setSelectedIndex(anoAtual - 2000);
        mensal = false;
        diario = false;
        enfermidade = true;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jFormattedTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField1KeyPressed
        if (evt.getKeyCode() == 10) {
            jButton5.doClick();
        }
    }//GEN-LAST:event_jFormattedTextField1KeyPressed
    public String getDia() {

        Calendar hoje = Calendar.getInstance();
        String anoAtual;
        String diaAtual;
        String mesAtual;
        anoAtual = jFormattedTextField1.getText().substring(6, 10);
        diaAtual = jFormattedTextField1.getText().substring(0, 2);
        mesAtual = jFormattedTextField1.getText().substring(3, 5);
        return anoAtual + "-" + mesAtual + "-" + diaAtual;
    }

    public void getToday() {
        //pega o dia, mes, ano , minut, hora atual
        int da, ma, aa;
        String daSt, maSt;
        Calendar hoje = Calendar.getInstance();
        da = hoje.get(Calendar.DAY_OF_MONTH);
        ma = hoje.get(Calendar.MONTH) + 1;
        aa = hoje.get(Calendar.YEAR);
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
        diaAtual = (String.valueOf(daSt + maSt + aa));//concatena a data atual
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List atendimentoList;
    private javax.persistence.Query atendimentoQuery;
    private javax.persistence.EntityManager entityManager1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private java.util.List<model.Medicamento> medicamentoList1;
    private javax.persistence.Query medicamentoQuery1;
    // End of variables declaration//GEN-END:variables
}
