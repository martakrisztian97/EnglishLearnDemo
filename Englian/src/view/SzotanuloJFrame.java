package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Felhasznalo;
import model.KapcsolatDB;
import model.Szo;
import model.Temakor;

/**
 * Egy szószedet szavait tartalmazó felület azok megtanulására.
 * @author Márta Krisztián
 * @since 2023-03-05
 */
public class SzotanuloJFrame extends javax.swing.JFrame {
    
    private Felhasznalo beFelh;
    private Temakor temakor;
    private KapcsolatDB kapcsolat;
    private boolean kifejezesAngol; // A kifejezés nyelve
    private List<Szo> szavak;
    private List<String> kifejezesek;
    private List<String> definiciok;
    private int hanyadikSzo; // Nem index, hanem sorszám

    /**
     * Creates new form SzotanuloJFrame.
     */
    public SzotanuloJFrame() {
        initComponents();
    }
    
    /**
     * Creates new form SzotanuloJFrame.
     * @param f Bejelentkezett felhasználó.
     * @param t A szószedet témakörének azonosítója.
     */
    public SzotanuloJFrame(Felhasznalo f, Temakor t) {
        initComponents();
        this.setTitle(t.getMegnevezes()+" témakör szókártyái");
        tanulasPanel.setVisible(false);
        vegePanel.setVisible(false);
        beFelh = f;
        temakor = t;
        kapcsolat = new KapcsolatDB();
        szavak = kapcsolat.szavakAdottTemakorbenLekerdez(temakor.getId());
        Collections.shuffle(szavak);
        kifejezesek = new ArrayList<>();
        definiciok = new ArrayList<>();
        hanyadikSzo = 1;
        hatralevoSzavakSzamaLabel.setText("Megtanulandó szavak száma: "+(szavak.size()));
        
    }
    
    /**
     * Megvizsgálja, hogy az angol rádiógomb van-e kijelölve.
     * @return A rádiógomb kijelöltségével.
     */
    public boolean angolRadioButtonKijelolve() {
        boolean b = false;
        if (angolRadioButton.isSelected()) b = true;
        return b;
    }
    
    /**
     * A kifejezéseket és a definíciókat tartalmazó listák tartalmának beállítása.
     */
    public void kifejezesekEsDefiniciokBeallitasa() {
        kifejezesek.clear();
        definiciok.clear();
        for (Szo szo : szavak) {
            if (kifejezesAngol) {
                kifejezesek.add(szo.getAngol());
                definiciok.add(szo.getMagyar());
            } else {
                kifejezesek.add(szo.getMagyar());
                definiciok.add(szo.getAngol());
            }
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

        kifejezesNyelveButtonGroup = new javax.swing.ButtonGroup();
        inditasPanel = new javax.swing.JPanel();
        angolRadioButton = new javax.swing.JRadioButton();
        magyarRadioButton = new javax.swing.JRadioButton();
        kezdesButton = new javax.swing.JButton();
        tanulasPanel = new javax.swing.JPanel();
        kifejezesButton = new javax.swing.JButton();
        definicoButton = new javax.swing.JButton();
        marTudomButton = new javax.swing.JButton();
        megTanulomButton = new javax.swing.JButton();
        hatralevoSzavakSzamaLabel = new javax.swing.JLabel();
        vegePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ujraButton = new javax.swing.JButton();
        bezarasButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 700));
        setMinimumSize(new java.awt.Dimension(600, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        inditasPanel.setMaximumSize(new java.awt.Dimension(600, 700));
        inditasPanel.setMinimumSize(new java.awt.Dimension(600, 700));
        inditasPanel.setName(""); // NOI18N
        inditasPanel.setPreferredSize(new java.awt.Dimension(600, 700));
        inditasPanel.setLayout(new java.awt.GridBagLayout());

        kifejezesNyelveButtonGroup.add(angolRadioButton);
        angolRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        angolRadioButton.setSelected(true);
        angolRadioButton.setText("Angol");
        angolRadioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        angolRadioButton.setFocusable(false);
        angolRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                angolRadioButtonItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 200, 0);
        inditasPanel.add(angolRadioButton, gridBagConstraints);

        kifejezesNyelveButtonGroup.add(magyarRadioButton);
        magyarRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        magyarRadioButton.setText("Magyar");
        magyarRadioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        magyarRadioButton.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 100, 200, 0);
        inditasPanel.add(magyarRadioButton, gridBagConstraints);

        kezdesButton.setBackground(new java.awt.Color(0, 153, 255));
        kezdesButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        kezdesButton.setForeground(new java.awt.Color(255, 255, 255));
        kezdesButton.setText("KEZDÉS");
        kezdesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kezdesButton.setFocusable(false);
        kezdesButton.setMaximumSize(new java.awt.Dimension(200, 100));
        kezdesButton.setMinimumSize(new java.awt.Dimension(200, 100));
        kezdesButton.setPreferredSize(new java.awt.Dimension(200, 100));
        kezdesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kezdesButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        inditasPanel.add(kezdesButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(inditasPanel, gridBagConstraints);

        tanulasPanel.setMaximumSize(new java.awt.Dimension(600, 700));
        tanulasPanel.setMinimumSize(new java.awt.Dimension(600, 700));
        tanulasPanel.setPreferredSize(new java.awt.Dimension(600, 700));
        tanulasPanel.setLayout(new java.awt.GridBagLayout());

        kifejezesButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        kifejezesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        kifejezesButton.setFocusable(false);
        kifejezesButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kifejezesButton.setMaximumSize(new java.awt.Dimension(500, 200));
        kifejezesButton.setMinimumSize(new java.awt.Dimension(500, 200));
        kifejezesButton.setPreferredSize(new java.awt.Dimension(500, 200));
        kifejezesButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 0);
        tanulasPanel.add(kifejezesButton, gridBagConstraints);

        definicoButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        definicoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        definicoButton.setFocusPainted(false);
        definicoButton.setMaximumSize(new java.awt.Dimension(500, 200));
        definicoButton.setMinimumSize(new java.awt.Dimension(500, 200));
        definicoButton.setPreferredSize(new java.awt.Dimension(500, 200));
        definicoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                definicoButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 0);
        tanulasPanel.add(definicoButton, gridBagConstraints);

        marTudomButton.setBackground(new java.awt.Color(50, 205, 50));
        marTudomButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        marTudomButton.setForeground(new java.awt.Color(255, 255, 255));
        marTudomButton.setText("<html><div text-align:center>MÁR<br>TUDOM</div></html>");
        marTudomButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        marTudomButton.setFocusable(false);
        marTudomButton.setMaximumSize(new java.awt.Dimension(175, 100));
        marTudomButton.setMinimumSize(new java.awt.Dimension(175, 100));
        marTudomButton.setPreferredSize(new java.awt.Dimension(175, 100));
        marTudomButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                marTudomButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        tanulasPanel.add(marTudomButton, gridBagConstraints);

        megTanulomButton.setBackground(new java.awt.Color(255, 99, 71));
        megTanulomButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        megTanulomButton.setForeground(new java.awt.Color(255, 255, 255));
        megTanulomButton.setText("<html><div text-align:center>MÉG<br>TANULOM</div></html>");
        megTanulomButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        megTanulomButton.setFocusable(false);
        megTanulomButton.setMaximumSize(new java.awt.Dimension(175, 100));
        megTanulomButton.setMinimumSize(new java.awt.Dimension(175, 100));
        megTanulomButton.setPreferredSize(new java.awt.Dimension(175, 100));
        megTanulomButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                megTanulomButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        tanulasPanel.add(megTanulomButton, gridBagConstraints);

        hatralevoSzavakSzamaLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hatralevoSzavakSzamaLabel.setText("Megtanulandó szavak száma: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        tanulasPanel.add(hatralevoSzavakSzamaLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(tanulasPanel, gridBagConstraints);

        vegePanel.setMaximumSize(new java.awt.Dimension(600, 700));
        vegePanel.setMinimumSize(new java.awt.Dimension(600, 700));
        vegePanel.setPreferredSize(new java.awt.Dimension(600, 700));
        vegePanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("A szószedet végére ért!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 0);
        vegePanel.add(jLabel1, gridBagConstraints);

        ujraButton.setBackground(new java.awt.Color(0, 153, 255));
        ujraButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ujraButton.setForeground(new java.awt.Color(255, 255, 255));
        ujraButton.setText("ÚJRA");
        ujraButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ujraButton.setFocusable(false);
        ujraButton.setMaximumSize(new java.awt.Dimension(175, 100));
        ujraButton.setMinimumSize(new java.awt.Dimension(175, 100));
        ujraButton.setPreferredSize(new java.awt.Dimension(175, 100));
        ujraButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ujraButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 25, 0);
        vegePanel.add(ujraButton, gridBagConstraints);

        bezarasButton.setBackground(new java.awt.Color(255, 99, 71));
        bezarasButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bezarasButton.setForeground(new java.awt.Color(255, 255, 255));
        bezarasButton.setText("BEZÁRÁS");
        bezarasButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bezarasButton.setFocusable(false);
        bezarasButton.setMaximumSize(new java.awt.Dimension(175, 100));
        bezarasButton.setMinimumSize(new java.awt.Dimension(175, 100));
        bezarasButton.setPreferredSize(new java.awt.Dimension(175, 100));
        bezarasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bezarasButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        vegePanel.add(bezarasButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(vegePanel, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        SzoszedetekJFrame szoszedet = new SzoszedetekJFrame(beFelh);
        szoszedet.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void kezdesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kezdesButtonMouseClicked
        inditasPanel.setVisible(false);
        tanulasPanel.setVisible(true);
        kifejezesAngol = angolRadioButtonKijelolve();
        kifejezesekEsDefiniciokBeallitasa();
        kifejezesButton.setText(kifejezesek.get(0));
        kifejezesButton.setIcon(new ImageIcon(getClass().getResource("/view/images/"+temakor.getMappa()+"/"+szavak.get(0).getKep())));
    }//GEN-LAST:event_kezdesButtonMouseClicked

    private void angolRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_angolRadioButtonItemStateChanged
       kifejezesAngol = angolRadioButtonKijelolve();
    }//GEN-LAST:event_angolRadioButtonItemStateChanged

    private void definicoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_definicoButtonMouseClicked
        if (definicoButton.getText().equals("")) {
            definicoButton.setText(definiciok.get(hanyadikSzo-1));
        }
    }//GEN-LAST:event_definicoButtonMouseClicked

    private void marTudomButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_marTudomButtonMouseClicked
        definicoButton.setText("");
        szavak.remove(hanyadikSzo-1);
        kifejezesek.remove(hanyadikSzo-1);
        definiciok.remove(hanyadikSzo-1);
        hatralevoSzavakSzamaLabel.setText("Megtanulandó szavak száma: "+(szavak.size()));
        if (szavak.isEmpty()) {
            tanulasPanel.setVisible(false);
            vegePanel.setVisible(true);
        } else if (hanyadikSzo-1 < szavak.size()) {
            kifejezesButton.setText(kifejezesek.get(hanyadikSzo-1));
            kifejezesButton.setIcon(new ImageIcon(getClass().getResource("/view/images/"+temakor.getMappa()+"/"+szavak.get(hanyadikSzo-1).getKep())));
        } else {
            JOptionPane.showMessageDialog(null, "Folytatás a fennmaradó szavakkal!", "Üzenet", JOptionPane.INFORMATION_MESSAGE);
            hanyadikSzo = 1;
            kifejezesButton.setText(kifejezesek.get(0));
            kifejezesButton.setIcon(new ImageIcon(getClass().getResource("/view/images/"+temakor.getMappa()+"/"+szavak.get(0).getKep())));
        }
    }//GEN-LAST:event_marTudomButtonMouseClicked

    private void megTanulomButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_megTanulomButtonMouseClicked
        definicoButton.setText("");
        hanyadikSzo++;
        if (hanyadikSzo-1 < szavak.size()) {
            kifejezesButton.setText(kifejezesek.get(hanyadikSzo-1));
            kifejezesButton.setIcon(new ImageIcon(getClass().getResource("/view/images/"+temakor.getMappa()+"/"+szavak.get(hanyadikSzo-1).getKep())));
        } else {
            JOptionPane.showMessageDialog(null, "Folytatás a fennmaradó szavakkal!", "Üzenet", JOptionPane.INFORMATION_MESSAGE);
            hanyadikSzo = 1;
            Collections.shuffle(szavak);
            kifejezesekEsDefiniciokBeallitasa();
            kifejezesButton.setText(kifejezesek.get(0));
            kifejezesButton.setIcon(new ImageIcon(getClass().getResource("/view/images/"+temakor.getMappa()+"/"+szavak.get(0).getKep())));
        }
    }//GEN-LAST:event_megTanulomButtonMouseClicked

    private void bezarasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bezarasButtonMouseClicked
        SzoszedetekJFrame szoszedet = new SzoszedetekJFrame(beFelh);
        szoszedet.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bezarasButtonMouseClicked

    private void ujraButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ujraButtonMouseClicked
        vegePanel.setVisible(false);
        inditasPanel.setVisible(true);
        szavak = kapcsolat.szavakAdottTemakorbenLekerdez(temakor.getId());
        Collections.shuffle(szavak);
        hanyadikSzo = 1;
    }//GEN-LAST:event_ujraButtonMouseClicked

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
            java.util.logging.Logger.getLogger(SzotanuloJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SzotanuloJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SzotanuloJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SzotanuloJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SzotanuloJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton angolRadioButton;
    private javax.swing.JButton bezarasButton;
    private javax.swing.JButton definicoButton;
    private javax.swing.JLabel hatralevoSzavakSzamaLabel;
    private javax.swing.JPanel inditasPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton kezdesButton;
    private javax.swing.JButton kifejezesButton;
    private javax.swing.ButtonGroup kifejezesNyelveButtonGroup;
    private javax.swing.JRadioButton magyarRadioButton;
    private javax.swing.JButton marTudomButton;
    private javax.swing.JButton megTanulomButton;
    private javax.swing.JPanel tanulasPanel;
    private javax.swing.JButton ujraButton;
    private javax.swing.JPanel vegePanel;
    // End of variables declaration//GEN-END:variables
}
