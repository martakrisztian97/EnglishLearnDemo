package view;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Eredmeny;
import model.Felhasznalo;
import model.KapcsolatDB;
import model.Temakor;

/**
 * Ranglisták megjelenítésre szolgáló felület.
 * @author Márta Krisztián
 * @since 2023-03-15
 */
public class RanglistaJFrame extends javax.swing.JFrame {
    
    private Felhasznalo beFelh;
    private KapcsolatDB kapcsolat;
    private DefaultTableModel dtm;
    private ArrayList<Temakor> temakorok;
    private ArrayList<Eredmeny> eredmenyek;

    /**
     * Creates new form RanglistaJFrame.
     */
    public RanglistaJFrame() {
        initComponents();
    }
    
    /**
     * Creates new form RanglistaJFrame.
     * @param f  Bejelentkezett felhasználó.
     */
    public RanglistaJFrame(Felhasznalo f) {
        initComponents();
        beFelh = f;
        kapcsolat = new KapcsolatDB();
        dtm = (DefaultTableModel)ranglistaTable.getModel();
        temakorok = kapcsolat.temakorokLekerdez(beFelh, true);
        for (Temakor t : temakorok) {
            temakorokComboBox.addItem(t.getMegnevezes());
        }
        ranglistaTable.setRowHeight(24);
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

        temakorokComboBox = new javax.swing.JComboBox<>();
        ranglistaScrollPane = new javax.swing.JScrollPane();
        ranglistaTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ranglista témakörönként");
        setMaximumSize(new java.awt.Dimension(800, 800));
        setMinimumSize(new java.awt.Dimension(800, 800));
        setPreferredSize(new java.awt.Dimension(800, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 800));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        temakorokComboBox.setBackground(new java.awt.Color(0, 153, 255));
        temakorokComboBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        temakorokComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Válasszon!" }));
        temakorokComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        temakorokComboBox.setFocusable(false);
        temakorokComboBox.setMaximumSize(new java.awt.Dimension(200, 35));
        temakorokComboBox.setMinimumSize(new java.awt.Dimension(200, 35));
        temakorokComboBox.setPreferredSize(new java.awt.Dimension(200, 35));
        temakorokComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                temakorokComboBoxItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 0);
        getContentPane().add(temakorokComboBox, gridBagConstraints);

        ranglistaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Felhasználó", "Eredmény"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ranglistaScrollPane.setViewportView(ranglistaTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        getContentPane().add(ranglistaScrollPane, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Témakör");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(jLabel1, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void temakorokComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_temakorokComboBoxItemStateChanged
        int kivalasztottTemakor = (int) temakorokComboBox.getSelectedIndex()-1; // -1 mivel a válasszon felirat szerepel benne
        
        // táblázat kiűrítése
        for (int i = dtm.getRowCount() - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }

        // táblázat feltöltése
        if (kivalasztottTemakor != -1) {
            eredmenyek = kapcsolat.eredmenyeketLekerdez(temakorok.get(kivalasztottTemakor).getId());
            Object[] sor = new Object[2];
             for (Eredmeny e : eredmenyek) {
                sor[0] = e.getFelhasznalonev();
                sor[1] = e.getEredmeny();
                dtm.addRow(sor);
            }
        }
    }//GEN-LAST:event_temakorokComboBoxItemStateChanged

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
            java.util.logging.Logger.getLogger(RanglistaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RanglistaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RanglistaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RanglistaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RanglistaJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane ranglistaScrollPane;
    private javax.swing.JTable ranglistaTable;
    private javax.swing.JComboBox<String> temakorokComboBox;
    // End of variables declaration//GEN-END:variables
}
