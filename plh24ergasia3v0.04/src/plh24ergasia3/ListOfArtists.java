/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plh24ergasia3;
import javax.swing.JOptionPane;
import pojos.Artist;
import plh24ergasia3.DBManager;
/**
 *
 * @author thanos
 */
public class ListOfArtists extends javax.swing.JFrame {

    /**
     * Creates new form ListOfArtists
     */
    int selectedRow;
    Artist artist;
    public ListOfArtists() {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        radioDBv2PUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("radioDBv2PU").createEntityManager();
        artistQuery = java.beans.Beans.isDesignTime() ? null : radioDBv2PUEntityManager.createQuery("SELECT a FROM Artist a");
        artistList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : artistQuery.getResultList();
        albumQuery = java.beans.Beans.isDesignTime() ? null : radioDBv2PUEntityManager.createQuery("SELECT a FROM Album a");
        albumList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : albumQuery.getResultList();
        albumQuery1 = java.beans.Beans.isDesignTime() ? null : radioDBv2PUEntityManager.createQuery("SELECT a FROM Album a");
        albumList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : albumQuery1.getResultList();
        artistQuery1 = java.beans.Beans.isDesignTime() ? null : radioDBv2PUEntityManager.createQuery("SELECT a FROM Artist a");
        artistList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : artistQuery1.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        ArtistsTable = new javax.swing.JTable();
        addArtist = new javax.swing.JButton();
        epistrofh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        deleteArtist = new javax.swing.JButton();
        editArtist = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ArtistsTable.setColumnSelectionAllowed(true);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, artistList1, ArtistsTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${firstName}"));
        columnBinding.setColumnName("Όνομα");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastName}"));
        columnBinding.setColumnName("Επώνυμο");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${artisticName}"));
        columnBinding.setColumnName("Καλλιτεχνικό");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${sex}"));
        columnBinding.setColumnName("Φύλο");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${birthDate}"));
        columnBinding.setColumnName("Ημ/νία Γέννησης");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${birthPlace}"));
        columnBinding.setColumnName("ΤόποςΓέννησης");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${musicGenrename.name}"));
        columnBinding.setColumnName("Είδος Μουσικής");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(ArtistsTable);
        ArtistsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        addArtist.setText("Προσθήκη");
        addArtist.setToolTipText("");
        addArtist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addArtistActionPerformed(evt);
            }
        });

        epistrofh.setText("Επιστροφη στην αρχική");
        epistrofh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                epistrofhActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel1.setText("Αρχείο Καλλιτεχνών");

        deleteArtist.setText("Διαγραφή");
        deleteArtist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteArtistActionPerformed(evt);
            }
        });

        editArtist.setText("Επεξεργασία");
        editArtist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editArtistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(339, 339, 339))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addArtist)
                        .addGap(121, 121, 121)
                        .addComponent(editArtist)
                        .addGap(136, 136, 136)
                        .addComponent(deleteArtist)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(epistrofh))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addArtist)
                    .addComponent(epistrofh)
                    .addComponent(deleteArtist)
                    .addComponent(editArtist))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addArtistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addArtistActionPerformed
        // ανοίγει τη φόρμα διαχείρησης Καλλιτέχνη
        new NewOrModifyArtist().setVisible(true);
    }//GEN-LAST:event_addArtistActionPerformed

    private void epistrofhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_epistrofhActionPerformed
        this.setVisible(false); //κλεινει αυτη η φορμα
        // εμφάνιση αρχικής
        new Kentriki().setVisible(true);
    }//GEN-LAST:event_epistrofhActionPerformed

    private void deleteArtistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteArtistActionPerformed
        // TODO add your handling code here:
        selectedRow = ArtistsTable.getSelectedRow();
        artist=artistList1.get(ArtistsTable.convertColumnIndexToModel(selectedRow));
        
        int choice = JOptionPane.showConfirmDialog(null, "Θα διαγραφει ο καλλιτέχνης " + artist.getFirstName() + " " + artist.getLastName()+ "!", "",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (choice == 0) {    
            if (DBManager.deleteArtist(artist)) {
                artistList1.remove(artist); //διαγραφη καλλιτεχνη
                JOptionPane.showMessageDialog(null, "Επιτυχής διαγραφή καλλιτεχνη!", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                this.setVisible(true); //ανανέωση
            } else {
                JOptionPane.showMessageDialog(null, "Αποτυχία διαγραφής καλλιτέχνη!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteArtistActionPerformed

    private void editArtistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editArtistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editArtistActionPerformed

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
            java.util.logging.Logger.getLogger(ListOfArtists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListOfArtists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListOfArtists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListOfArtists.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListOfArtists().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ArtistsTable;
    private javax.swing.JButton addArtist;
    private java.util.List<pojos.Album> albumList;
    private java.util.List<pojos.Album> albumList1;
    private javax.persistence.Query albumQuery;
    private javax.persistence.Query albumQuery1;
    private java.util.List<pojos.Artist> artistList;
    private java.util.List<pojos.Artist> artistList1;
    private javax.persistence.Query artistQuery;
    private javax.persistence.Query artistQuery1;
    private javax.swing.JButton deleteArtist;
    private javax.swing.JButton editArtist;
    private javax.swing.JButton epistrofh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.persistence.EntityManager radioDBv2PUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
