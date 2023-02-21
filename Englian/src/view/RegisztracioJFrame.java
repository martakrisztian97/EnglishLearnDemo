package view;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.KapcsolatDB;

/**
 * Regisztráció
 *
 * @author Márta Krisztián
 * @since 2022-11-17
 */
public class RegisztracioJFrame extends javax.swing.JFrame {

    private KapcsolatDB kapcsolat;
    List<String> felhasznalok = new ArrayList<>();

    /**
     * Creates new form Regisztracio7
     */
    public RegisztracioJFrame() {
        initComponents();
        kapcsolat = new KapcsolatDB();
        felhasznalok = kapcsolat.felhasznalok();
    }

    /**
     * Regisztráció implementálása
     */
    public void regisztracio() {
        String nev = nevTextField.getText();
        String email = emailTextField.getText();
        String felhasznalonev = felhasznalonevTextField.getText();
        String jelszo = new String(jelszoPasswordField.getPassword());
        String jelszoIsmet = new String(jelszoIsmetPasswordField.getPassword());
        if (!emailValidalas(email))
            JOptionPane.showMessageDialog(null, "Helyes email címet adjon meg!", "Sikertelen regisztráció", JOptionPane.ERROR_MESSAGE);
        else if (felhasznalonev.isEmpty())
            JOptionPane.showMessageDialog(null, "Felhasználónév megadása kötelező!", "Sikertelen regisztráció", JOptionPane.ERROR_MESSAGE);
        else if (felhasznalok.contains(felhasznalonev))
            JOptionPane.showMessageDialog(null, "A felhasználónév foglalt!", "Sikertelen regisztráció", JOptionPane.ERROR_MESSAGE);
        else if (!jelszo.equals(jelszoIsmet))
            JOptionPane.showMessageDialog(null, "A jelszavaknak egyezniük kell!", "Sikertelen regisztráció", JOptionPane.ERROR_MESSAGE);
        else if (!jelszoValidalas(jelszo))
            JOptionPane.showMessageDialog(null, "A jelszónak minimum 8 karakter hosszúnak kell lenni, valamint tartalmaznia kell kisbetűt, nagybetűt és számot!", "Sikertelen regisztráció", JOptionPane.ERROR_MESSAGE);
        else {
            kapcsolat.regisztracio(nev, email, felhasznalonev, md5Kodolas(jelszo));
            JOptionPane.showMessageDialog(null, "Sikeres regisztráció!", "Sikeres regisztráció", JOptionPane.INFORMATION_MESSAGE);
            nevTextField.setText("");
            emailTextField.setText("");
            felhasznalonevTextField.setText("");
            jelszoPasswordField.setText("");
            jelszoIsmetPasswordField.setText("");
        }
    }
    
    /**
     * Email cím validálása.
     * @param email A validálni kívánt email cím.
     * @return Az email cím érvényessége.
     */
    public boolean emailValidalas(String email) {
        Pattern pattern = Pattern.compile("[a-z0-9]+@[a-z]+\\.[a-z]+"); 
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
     /**
     * Jelszó cím validálása.
     * @param jelszo A validálni kívánt jelszó.
     * @return Az jelszó érvényessége.
     */
    public boolean jelszoValidalas(String jelszo) {
        boolean ervenyes = true;
        Pattern kisbetu = Pattern.compile("[a-z]"); 
        Pattern nagybetu = Pattern.compile("[A-Z]");
        Pattern szam = Pattern.compile("[0-9]");
        if (jelszo.length() < 8) ervenyes = false;
        if (!kisbetu.matcher(jelszo).find()) ervenyes = false;
        if (!nagybetu.matcher(jelszo).find()) ervenyes = false;
        if (!szam.matcher(jelszo).find()) ervenyes = false;
        return ervenyes;
    }

    /**
     * MD5 kódolási algoritmus implementálása.
     * @param jelszo A kódolni kívánt jelszó.
     * @return A kódolt jelszó.
     */
    public String md5Kodolas(String jelszo) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(jelszo.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        nevTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        felhasznalonevTextField = new javax.swing.JTextField();
        jelszoPasswordField = new javax.swing.JPasswordField();
        jelszoIsmetPasswordField = new javax.swing.JPasswordField();
        regisztracioButton = new javax.swing.JButton();
        logoLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jelszoMegjeleniteseCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Angol szótanuló alkalmazás demó");
        setMaximumSize(new java.awt.Dimension(500, 450));
        setMinimumSize(new java.awt.Dimension(500, 450));
        setPreferredSize(new java.awt.Dimension(500, 450));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        nevTextField.setMinimumSize(new java.awt.Dimension(200, 30));
        nevTextField.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        getContentPane().add(nevTextField, gridBagConstraints);

        emailTextField.setMinimumSize(new java.awt.Dimension(200, 30));
        emailTextField.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        getContentPane().add(emailTextField, gridBagConstraints);

        felhasznalonevTextField.setMinimumSize(new java.awt.Dimension(200, 30));
        felhasznalonevTextField.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        getContentPane().add(felhasznalonevTextField, gridBagConstraints);

        jelszoPasswordField.setMinimumSize(new java.awt.Dimension(200, 30));
        jelszoPasswordField.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        getContentPane().add(jelszoPasswordField, gridBagConstraints);

        jelszoIsmetPasswordField.setMinimumSize(new java.awt.Dimension(200, 30));
        jelszoIsmetPasswordField.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        getContentPane().add(jelszoIsmetPasswordField, gridBagConstraints);

        regisztracioButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        regisztracioButton.setText("Regisztráció");
        regisztracioButton.setMaximumSize(new java.awt.Dimension(250, 40));
        regisztracioButton.setMinimumSize(new java.awt.Dimension(250, 40));
        regisztracioButton.setPreferredSize(new java.awt.Dimension(250, 40));
        regisztracioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regisztracioButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(regisztracioButton, gridBagConstraints);

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/myemoji2.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        getContentPane().add(logoLabel, gridBagConstraints);

        jLabel1.setText("Név:");
        jLabel1.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel5.setText("Jelszó ismét:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jLabel5, gridBagConstraints);

        jLabel2.setText("E-mail:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setText("Felhasználónév:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jLabel3, gridBagConstraints);

        jLabel4.setText("Jelszó:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jLabel4, gridBagConstraints);

        jelszoMegjeleniteseCheckBox.setText("Jelszó megjelenítése ");
        jelszoMegjeleniteseCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jelszoMegjeleniteseCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(jelszoMegjeleniteseCheckBox, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void regisztracioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regisztracioButtonMouseClicked
        regisztracio();
    }//GEN-LAST:event_regisztracioButtonMouseClicked

    private void jelszoMegjeleniteseCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jelszoMegjeleniteseCheckBoxActionPerformed
        if (jelszoMegjeleniteseCheckBox.isSelected()) {
            jelszoPasswordField.setEchoChar((char)0);
            jelszoIsmetPasswordField.setEchoChar((char)0);
        } else {
            jelszoPasswordField.setEchoChar('*');
            jelszoIsmetPasswordField.setEchoChar('*');
        }
    }//GEN-LAST:event_jelszoMegjeleniteseCheckBoxActionPerformed

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
            java.util.logging.Logger.getLogger(RegisztracioJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisztracioJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisztracioJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisztracioJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisztracioJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTextField felhasznalonevTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jelszoIsmetPasswordField;
    private javax.swing.JCheckBox jelszoMegjeleniteseCheckBox;
    private javax.swing.JPasswordField jelszoPasswordField;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JTextField nevTextField;
    private javax.swing.JButton regisztracioButton;
    // End of variables declaration//GEN-END:variables
}
