package view;

import controller.frameStart.ControllerFrameStart;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/* @author Alex Bonadio Linhas de Codigo: 1677  Classe: 389 Pacote: 973 */
public class FrameStart extends javax.swing.JFrame {

    // Objetos da classe Usuario, Conexao e Controller são instanciados para comunicação com o MySQL 
//  public ControllerFrameStart controllerFrameStart = new ControllerFrameStart();
    public ControllerFrameStart controllerFrameStart;
    private int decisao;

    public FrameStart() {
        initComponents();
        controllerFrameStart = new ControllerFrameStart();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        inputTextBox = new javax.swing.JTextField();
        radioBin = new javax.swing.JRadioButton();
        radioTer = new javax.swing.JRadioButton();
        radioOct = new javax.swing.JRadioButton();
        radioDec = new javax.swing.JRadioButton();
        radioHex = new javax.swing.JRadioButton();
        botaoConverter = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();
        texto_tern = new javax.swing.JTextField();
        texto_bin = new javax.swing.JTextField();
        texto_oct = new javax.swing.JTextField();
        texto_dec = new javax.swing.JTextField();
        texto_hex = new javax.swing.JTextField();
        jLabelMsg = new javax.swing.JLabel();
        botaoOnline = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Programmer Calculator");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(240, 240, 240));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        inputTextBox.setFont(new java.awt.Font("Tahoma", 0, 34)); // NOI18N
        inputTextBox.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inputTextBox.setToolTipText("");
        inputTextBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        inputTextBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        buttonGroup1.add(radioBin);
        radioBin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        radioBin.setText("Binário: ");
        radioBin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBinActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioTer);
        radioTer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        radioTer.setText("Ternário:");
        radioTer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTerActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioOct);
        radioOct.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        radioOct.setText("Octal:");
        radioOct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOctActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioDec);
        radioDec.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        radioDec.setSelected(true);
        radioDec.setText("Decimal:");
        radioDec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDecActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioHex);
        radioHex.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        radioHex.setText("Hexadecimal:");
        radioHex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioHexActionPerformed(evt);
            }
        });

        botaoConverter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoConverter.setText("Converter");
        botaoConverter.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botaoConverter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConverterActionPerformed(evt);
            }
        });

        botaoLimpar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoLimpar.setText("Limpar");
        botaoLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });

        texto_tern.setEditable(false);
        texto_tern.setBackground(new java.awt.Color(255, 255, 255));
        texto_tern.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        texto_tern.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        texto_tern.setText("0");
        texto_tern.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        texto_bin.setEditable(false);
        texto_bin.setBackground(new java.awt.Color(255, 255, 255));
        texto_bin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        texto_bin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        texto_bin.setText("0");
        texto_bin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        texto_bin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        texto_oct.setEditable(false);
        texto_oct.setBackground(new java.awt.Color(255, 255, 255));
        texto_oct.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        texto_oct.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        texto_oct.setText("0");
        texto_oct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        texto_dec.setEditable(false);
        texto_dec.setBackground(new java.awt.Color(255, 255, 255));
        texto_dec.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        texto_dec.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        texto_dec.setText("0");
        texto_dec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        texto_hex.setEditable(false);
        texto_hex.setBackground(new java.awt.Color(255, 255, 255));
        texto_hex.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        texto_hex.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        texto_hex.setText("0");
        texto_hex.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        jLabelMsg.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabelMsg.setForeground(new java.awt.Color(0, 0, 255));
        jLabelMsg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelMsg.setText("DataBase Server : OFFLINE");
        jLabelMsg.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        botaoOnline.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoOnline.setText("Conectar");
        botaoOnline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOnlineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputTextBox)
                    .addComponent(jLabelMsg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioOct, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(radioTer, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(radioBin, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(radioDec, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botaoConverter, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(radioHex))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoOnline, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(texto_bin, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_hex, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(texto_oct)
                            .addComponent(texto_dec, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_tern, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMsg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(radioBin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_bin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(radioTer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_tern, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(radioOct)
                    .addComponent(texto_oct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(radioDec)
                    .addComponent(texto_dec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(radioHex)
                    .addComponent(texto_hex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConverter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoOnline, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void radioTerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTerActionPerformed
        // usuário escolheu digitar um Número em Ternário
        decisao = 3;
        inputTextBox.requestFocus();
    }//GEN-LAST:event_radioTerActionPerformed

    private void radioBinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBinActionPerformed
        // usuário escolheu digitar um Número em Binário
        decisao = 2;
        inputTextBox.requestFocus();
    }//GEN-LAST:event_radioBinActionPerformed

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
        // Botão Limpar
        controllerFrameStart.limparEntrada();
    }//GEN-LAST:event_botaoLimparActionPerformed

    private void botaoConverterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConverterActionPerformed
        // Ao clicar no Botão Converter, as conversões são feitas
        if (inputTextBox.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite um Número!");
            inputTextBox.requestFocus();
        } else {
            switch (decisao) {
                case 16:
                    controllerFrameStart.conversaoHub(controllerFrameStart.base16, (short) 16);
                    break;
                case 2:
                    controllerFrameStart.conversaoHub(controllerFrameStart.base2, (short) 2);
                    break;
                case 3:
                    controllerFrameStart.conversaoHub(controllerFrameStart.base3, (short) 3);
                    break;
                case 8:
                    controllerFrameStart.conversaoHub(controllerFrameStart.base8, (short) 8);
                    break;
                default:
                    controllerFrameStart.conversaoHub(controllerFrameStart.base10, (short) 10);
                    break;
            }
        }
    }//GEN-LAST:event_botaoConverterActionPerformed

    private void radioOctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOctActionPerformed
        // usuário escolheu digitar um Número em Octal
        decisao = 8;
        inputTextBox.requestFocus();
    }//GEN-LAST:event_radioOctActionPerformed

    private void radioDecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDecActionPerformed
        // usuário escolheu digitar um Número em Decimal
        decisao = 10;
        inputTextBox.requestFocus();
    }//GEN-LAST:event_radioDecActionPerformed

    private void radioHexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioHexActionPerformed
        // usuário escolheu digitar um Número em Hexadecimal
        decisao = 16;
        inputTextBox.requestFocus();
    }//GEN-LAST:event_radioHexActionPerformed

    private void botaoOnlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOnlineActionPerformed

        try {
            controllerFrameStart.conectarDataBase();
        } catch (IOException ex) {
            Logger.getLogger(FrameStart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoOnlineActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        if (controllerFrameStart.controllerFrameDataBase.conexao.getConn() != null) {
            controllerFrameStart.controllerFrameDataBase.conexao.fecharConexao();
        }
    }//GEN-LAST:event_formWindowClosed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrameStart start = new FrameStart();
                start.sendReference(start);
                start.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConverter;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoOnline;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JTextField inputTextBox;
    public javax.swing.JLabel jLabelMsg;
    private javax.swing.JRadioButton radioBin;
    private javax.swing.JRadioButton radioDec;
    private javax.swing.JRadioButton radioHex;
    private javax.swing.JRadioButton radioOct;
    private javax.swing.JRadioButton radioTer;
    public javax.swing.JTextField texto_bin;
    public javax.swing.JTextField texto_dec;
    public javax.swing.JTextField texto_hex;
    public javax.swing.JTextField texto_oct;
    public javax.swing.JTextField texto_tern;
    // End of variables declaration//GEN-END:variables

    public void sendReference(FrameStart start) {

        controllerFrameStart.getReference(start);
    }

    public int getDecisao() {
        return decisao;
    }

    public void setDecisao(int decisao) {
        this.decisao = decisao;
    }
}
