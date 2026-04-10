package view;

//importações
import JImage.JIResizeImage;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryEvent;
import com.github.sarxos.webcam.WebcamDiscoveryListener;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamPicker;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import model.Aluno;

public class AbreCamera extends javax.swing.JPanel implements Runnable, WindowListener, ItemListener, WebcamListener, WebcamDiscoveryListener, Thread.UncaughtExceptionHandler {

    private boolean verificaClick = false, confirmado = false, verificaCerto = true, verificaCamera = false;
    private WebcamPicker seletor = null;
    private Webcam webcam = null;
    private WebcamPanel panel = null;
    private JDialog jf;
    ImageIcon foto = null;
    Aluno alunos;
    String nome, fn;

    public AbreCamera(JDialog jframe, Aluno a) {
        
        initComponents();//inicia componetes
        this.jf = jframe;
        jf.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/inicial.png")));//seta a o icone do projeto
        this.alunos = a;
        iniciaCamera();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jButton2 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        jPanel1.setBackground(new java.awt.Color(96, 202, 164));

        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_multimedia-27_809537.png"))); // NOI18N
        jButton1.setText("SALVAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/user.png"))); // NOI18N
        jToggleButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/if_home_298794.png"))); // NOI18N
        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jToggleButton1.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jToggleButton1, jToggleButton3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jToggleButton1, jToggleButton3});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
  public void iniciaCamera() {
        Webcam.addDiscoveryListener(this);
        jToggleButton1.setLayout(new BorderLayout());
        jf.addWindowListener(this);
        seletor = new WebcamPicker();
        seletor.addItemListener(this);//adiciona as webcam1s do windows ao seletor
        webcam = seletor.getSelectedWebcam(); //adiciona a webcam selecionada pelo seletor a variavel webcam
        if (null == webcam) {
            //se não existir webcam
            verificaCamera = true;
        } else {
            //se exixtir webcam
            panel = new WebcamPanel(webcam, false);//adiciona o video da webcam ao painel
            panel.setFPSDisplayed(true);
            jToggleButton1.add(seletor, BorderLayout.NORTH);//coloca o seletor em cima
            jToggleButton1.add(panel, BorderLayout.CENTER);//coloca o painel de transmissão ao centro
            jf.pack();
            setVisible(true);//deixa o frame visivel
            panel.start();//inicia painel da camera
            verificaCerto = true;
            verificaCamera = false;
        }
    }

    public boolean isVerificaClick() {
        return verificaClick;
    }

    public void setVerificaClick(boolean verificaClick) {
        this.verificaClick = verificaClick;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        File diretorio = new File("C:/Users/Public/Documents/IFermaria/fotos"); //adiciona o caminho de salvagem ao caminho do usuario
        if (!diretorio.exists()) {//se o diretório de fotos não existir
            diretorio.mkdirs(); // cria diretório.
        } else {
        }
        if (isVerificaClick()) {//se a pessoa tirou alguma foto

            String nomeImagem = System.currentTimeMillis() + ".jpg"; //para o nome da imagem é juntado o intante em milisegundos com a extenção .jpg
            Image img = foto.getImage().getScaledInstance(151, 183, Image.SCALE_DEFAULT);//seta o tamanho da foto a ser salva
            File novaImagem = new File(diretorio + "/" + nomeImagem);//caminho da foto
            BufferedImage bi2 = new BufferedImage(151, 183, BufferedImage.TYPE_INT_RGB);//tamanho da imahem
            Graphics2D g2d = bi2.createGraphics();
            g2d.drawImage(img, null, null);//desenha a imagem
            g2d.dispose();
            try {
                ImageIO.write(bi2, "JPG", novaImagem);//salva a imagem
            } catch (IOException ex) {
                Logger.getLogger(JFrmCadAluno.class.getName()).log(Level.SEVERE, null, ex);
            }
            alunos.setFoto(nomeImagem);//seta a foto da pessoa no objeto da pessoa selecionado
            webcam.close();//fecha a webcam
            jf.dispose();//fecha o frame
        } else {
            //caso o usuario não tenha selecionado nenhuma foto
            JOptionPane.showMessageDialog(null, "Tire uma Foto", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        BufferedImage bf2;
        bf2 = webcam.getImage();//pega o frame exato da webcam
        foto = new ImageIcon(bf2);//seta a foto tirada
        if (verificaCerto == true) {
            setVerificaClick(true);
            JIResizeImage resize = new JIResizeImage();
            Image imageresize = resize.rescale(bf2, 387, 470);//desenha a imagem do tamanho do botão
            jToggleButton3.setIcon(new ImageIcon(imageresize));//seta a imagem no botão
        } else {
            //caso não tenha a webcam
            setVerificaClick(false);
            JOptionPane.showMessageDialog(null, "A CAMERA NÃO FOI BEM INICIALIZADA", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (verificaCerto == true) {
            webcam.close();//fecha a webcam
        } else {
        }
        jf.dispose();//fecha o frame
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

    }//GEN-LAST:event_jToggleButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton3;
    // End of variables declaration//GEN-END:variables
    public void run() {
    }

    public void webcamOpen(WebcamEvent we) {
    }

    public void webcamClosed(WebcamEvent we) {
        if (verificaCamera == false) {
            //caso não tenha nenhuma webcam no windows
            JOptionPane.showMessageDialog(null, "Nao Achou a WebCam", "ERRO", JOptionPane.ERROR_MESSAGE);
            jf.dispose();//fecha o frame
        } else {
            webcam.close();//fecha a webcam
            jf.dispose();//fecha o frame
        }
    }

    public void webcamDisposed(WebcamEvent we) {
    }

    public void webcamImageObtained(WebcamEvent we) {
    }

    public void webcamFound(WebcamDiscoveryEvent wde) {
        if (null != seletor) {
            seletor.addItem(wde.getWebcam());
        }
    }

    public void webcamGone(WebcamDiscoveryEvent wde) {
        if (null != seletor) {
            seletor.removeItem(wde.getWebcam());
        }
    }

    public void windowOpened(WindowEvent we) {
    }

    public void windowClosing(WindowEvent we) {
        webcam.close();//ao fechar a janela fecha a webcam
        jf.dispose();//ao fechar a janela fecha o frame
    }

    public void windowClosed(WindowEvent we) {
        webcam.close();//ao fechar a janela fecha a webcam
        jf.dispose();//ao fechar a janela fecha o frame
    }

    public void windowIconified(WindowEvent we) {
        panel.pause();//ao minimizar o frame pausa o video do painel
    }

    public void windowDeiconified(WindowEvent we) {
        panel.resume();//ao maximizar volta a gravação
    }

    public void windowActivated(WindowEvent we) {
    }

    public void windowDeactivated(WindowEvent we) {
    }

    public void itemStateChanged(ItemEvent ie) {
        //método ao selecionar outra webcam inicia a nova webcam
        if (ie.getItem() != webcam) {
            if (null != webcam) {//se tiver alguma webcam
                panel.stop();//pausa a tansmisssão do painel
                remove(panel);//remove o painel de gravação atual
                webcam.removeWebcamListener(this);//remove a webcam atual
                webcam.close();//fecha a webcam
                webcam = (Webcam) ie.getItem();//adiciona a nova webcam
                webcam.setViewSize(WebcamResolution.VGA.getSize());
                webcam.addWebcamListener(this);
                panel = new WebcamPanel(webcam, false);//adiciona a transmissão da webcam ao painel
                panel.setFPSDisplayed(true);//a transmissão é feita por FPS(varias fotos repetidamente)
                add(seletor, BorderLayout.NORTH);//adiciona o seletor em cima do jToggleButon
                add(panel, BorderLayout.CENTER);//adiciona o seletor ao centro do jToggleButon
                jf.pack();
                panel.start();//starta o paine novamente
            }
        }
    }

    public void uncaughtException(Thread thread, Throwable thrwbl) {
        //caso ocorra algum erro
        System.out.println("Erro" + thread.getName());
        thrwbl.printStackTrace();
    }
}
