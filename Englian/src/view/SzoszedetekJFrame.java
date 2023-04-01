package view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.Felhasznalo;
import model.KapcsolatDB;
import model.Szo;
import model.Temakor;

/**
 * A bejelentkezett felhasználó szószedeteit tartalmazó felület.
 * @author Márta Krisztián
 * @since 2023-02-28
 */
public class SzoszedetekJFrame extends javax.swing.JFrame {
    
    private JFrame frame;
    private Felhasznalo beFelh;
    private KapcsolatDB kapcsolat;
    private ArrayList<Temakor> temakorok;
    private ArrayList<Szo> szavak;
    private ArrayList<JButton> gombok;

    /**
     * Creates new form SzoszedetekJFrame
     */
    public SzoszedetekJFrame() {
        initComponents();
    }
    
    /**
     * Creates new form SzoszedetekJFrame
     * @param f  Bejelentkezett felhasználó.
     */
    public SzoszedetekJFrame(Felhasznalo f) {
        initComponents();
        frame = this;
        beFelh = f;
        kapcsolat = new KapcsolatDB();
        temakorok = kapcsolat.temakorokLekerdez(beFelh, false);
        gombok = new ArrayList<>();
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 3, 20, 20)); // (0 -> bármennyi sor, 4 -> oszlop, 20 -> vízszintes rés, 20 -> függőleges rés)
             
        for (int i = 0; i < temakorok.size(); i++) {
            ImageIcon kep = new ImageIcon(getClass().getResource("/view/images/"+temakorok.get(i).getKep()));
            JButton ujGomb = new JButton(temakorok.get(i).getMegnevezes(), kep);
            ujGomb.setFont(new Font("Segou UI", Font.BOLD, 15));
            ujGomb.setText(ujGomb.getText().toUpperCase());
            ujGomb.setPreferredSize(new Dimension(200, 200));
            ujGomb.setHorizontalTextPosition(ujGomb.CENTER);
            ujGomb.setVerticalTextPosition(ujGomb.BOTTOM);
            ujGomb.setFocusable(false);
            ujGomb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            gombok.add(ujGomb);
        }
        
        for (JButton gomb : gombok) {
            gomb.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("GOMB FORRÁSA KATTINTÁSKOR: "+gombok.indexOf(e.getSource()));
                    szavak = kapcsolat.szavakAdottTemakorbenLekerdez(temakorok.get(gombok.indexOf(e.getSource())).getId());
                    if (szavak.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ez a szószedet nem tartalmaz szavakat, kérem töltsön fel párat!", "Üzenet", JOptionPane.ERROR_MESSAGE);
                    } else {
                        SzotanuloJFrame szotanulo = new SzotanuloJFrame(beFelh, temakorok.get(gombok.indexOf(e.getSource())));
                        szotanulo.setVisible(true);
                        frame.setVisible(false);
                    }
                }
            });
            panel.add(gomb);
        }
        
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // görgő sebességének beállítása
        
        int magassag = 210;
        if (temakorok.size() >= 4 && temakorok.size() <= 6)
            magassag = 450;
        else if (temakorok.size() >= 7)
            magassag = 720;
        
        scrollPane.setBounds(20, 20, 750, magassag); // új elhelyezkedés és méret
        scrollPane.setBorder(null);
        JPanel contentPane = new JPanel(null);
        contentPane.add(scrollPane);
        this.setContentPane(contentPane);
        this.pack();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Szószedetek");
        setMaximumSize(new java.awt.Dimension(800, 800));
        setMinimumSize(new java.awt.Dimension(800, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 800));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        MenuJFrame menu = new MenuJFrame(beFelh);
        menu.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(SzoszedetekJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SzoszedetekJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SzoszedetekJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SzoszedetekJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SzoszedetekJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
