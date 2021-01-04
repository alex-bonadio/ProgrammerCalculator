package view;

import controller.database.ControllerFrameDataBase;

/* @author Alex Bonadio Classe: 146 */
public class FrameDataBase extends javax.swing.JFrame {

    public ControllerFrameDataBase controllerFrameDataBase;
    public FrameStart start;

    public FrameDataBase() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        botaoConsultar = new javax.swing.JButton();
        botaoDeletar = new javax.swing.JButton();
        botaoConfigurar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta ao Banco de Dados");
        setMaximumSize(new java.awt.Dimension(0, 0));
        setMinimumSize(new java.awt.Dimension(475, 305));
        setName("FrameDataBase"); // NOI18N
        setPreferredSize(null);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        textArea.setRows(5);
        textArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        jScrollPane1.setViewportView(textArea);

        botaoConsultar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoConsultar.setText("Consultar");
        botaoConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botaoConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConsultarActionPerformed(evt);
            }
        });

        botaoDeletar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoDeletar.setText("Deletar");
        botaoDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botaoDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDeletarActionPerformed(evt);
            }
        });

        botaoConfigurar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoConfigurar.setText("Config IP");
        botaoConfigurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfigurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoConfigurar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botaoConfigurar, botaoConsultar, botaoDeletar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoConfigurar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botaoConfigurar, botaoConsultar, botaoDeletar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultarActionPerformed
        boolean check = controllerFrameDataBase.consultar();
        if (check == false) {
            exibirMsgOffline();
        }
    }//GEN-LAST:event_botaoConsultarActionPerformed

    private void botaoDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDeletarActionPerformed
        boolean check = controllerFrameDataBase.deletar();
        if (check == false) {
            exibirMsgOffline();
        }
    }//GEN-LAST:event_botaoDeletarActionPerformed

    private void botaoConfigurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfigurarActionPerformed

        controllerFrameDataBase.configurarIP();
    }//GEN-LAST:event_botaoConfigurarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        boolean check = false;
        if (controllerFrameDataBase.conexao.getConn() != null) {
            check = controllerFrameDataBase.conexao.fecharConexao();
        }
        if (check = true) {
            exibirMsgOffline();
        }
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConfigurar;
    private javax.swing.JButton botaoConsultar;
    private javax.swing.JButton botaoDeletar;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables

    public void getReference(ControllerFrameDataBase controllerFrameMySQL, FrameStart start) {

        this.controllerFrameDataBase = controllerFrameMySQL;
        this.start = start;
    }

    public void exibirMsgOffline() {
        controllerFrameDataBase.user.setNome("");
        controllerFrameDataBase.user.setIp("");
        controllerFrameDataBase.user.setHostname("");
        if (controllerFrameDataBase.conexao.getConn() != null) {
            controllerFrameDataBase.conexao.fecharConexao();
        }
        start.jLabelMsg.setText("DataBase Server : OFFLINE");
        //    start.jLabelMsg.setText("Oracle Server : OFFLINE");
        textArea.append("Desconectado do Banco de Dados\n\n");

    }
}
