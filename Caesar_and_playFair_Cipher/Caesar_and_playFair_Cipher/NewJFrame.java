/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.awt.Choice;

/**
 *
 * @author pc
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
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

        plaintext = new javax.swing.JTextField();
        key = new javax.swing.JTextField();
        ciphertext = new javax.swing.JTextField();
        butten1 = new javax.swing.JButton();
        butten2 = new javax.swing.JButton();
        butten3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        plaintext.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        plaintext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plaintextActionPerformed(evt);
            }
        });

        key.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        ciphertext.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ciphertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciphertextActionPerformed(evt);
            }
        });

        butten1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        butten1.setText("Encrypt");
        butten1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butten1ActionPerformed(evt);
            }
        });

        butten2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        butten2.setText("Decrypt");
        butten2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butten2ActionPerformed(evt);
            }
        });

        butten3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        butten3.setText("clear");
        butten3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butten3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Plain_text");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("key");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("cipher_text");

        ComboBox1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Caesar Cipher", "PlayFair Cipher", " " }));
        ComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("please select the cipher algorithm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 315, Short.MAX_VALUE)
                                .addComponent(butten3)
                                .addGap(116, 116, 116))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1)
                                        .addComponent(plaintext)
                                        .addComponent(ComboBox1, 0, 237, Short.MAX_VALUE)
                                        .addComponent(ciphertext))
                                    .addComponent(jLabel2)
                                    .addComponent(key, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(butten1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(butten2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(46, 46, 46))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plaintext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(butten1)
                        .addGap(45, 45, 45)))
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butten2)
                    .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ciphertext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(butten3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void plaintextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plaintextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plaintextActionPerformed

    private void butten1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butten1ActionPerformed
        if(ComboBox1.getSelectedItem()=="Caesar Cipher"){
            String x=plaintext.getText();
            int y=Integer.parseInt(key.getText());
            String f=CaesarCipher.encrypt(x, y);
            ciphertext.setText(f);
        }else{
            String x=plaintext.getText();
            String k=key.getText();
            PlayFair.setKey(k);
            PlayFair.KeyGen();
            String f=PlayFair.encryptMessage(x);
            ciphertext.setText(f);
            
            
        }
// TODO add your handling code here:
    }//GEN-LAST:event_butten1ActionPerformed

    private void butten2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butten2ActionPerformed
        if(ComboBox1.getSelectedItem()=="Caesar Cipher"){
            String x=plaintext.getText();
            int y=Integer.parseInt(key.getText());
            String f=CaesarCipher.decrypt(x, y);
            ciphertext.setText(f);
        }else{
            String x=plaintext.getText();
            String k=key.getText();
            PlayFair.setKey(k);
            PlayFair.KeyGen();
            String f=PlayFair.decryptMessage(x);
            ciphertext.setText(f);
        }
    }//GEN-LAST:event_butten2ActionPerformed

    private void butten3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butten3ActionPerformed
        plaintext.setText(null); 
        ciphertext.setText(null);
        key.setText(null);
// TODO add your handling code here:
    }//GEN-LAST:event_butten3ActionPerformed

    private void ciphertextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciphertextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ciphertextActionPerformed

    private void ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox1ActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_ComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBox1;
    private javax.swing.JButton butten1;
    private javax.swing.JButton butten2;
    private javax.swing.JButton butten3;
    private javax.swing.JTextField ciphertext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField key;
    private javax.swing.JTextField plaintext;
    // End of variables declaration//GEN-END:variables
}
