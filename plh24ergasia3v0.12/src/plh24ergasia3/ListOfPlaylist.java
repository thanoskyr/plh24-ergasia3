/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plh24ergasia3;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import pojos.Playlist;


/**
 *
 * @author tkomitopoulos
 */
public class ListOfPlaylist extends javax.swing.JFrame {

    /**
     * Creates new form ListOfPlaylist
     */
    Playlist playlist;
    int selectedRow;
    public ListOfPlaylist() {
        initComponents();
        selectedRow=-1;
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
        playlistQuery = java.beans.Beans.isDesignTime() ? null : radioDBv2PUEntityManager.createQuery("SELECT p FROM Playlist p");
        playlistList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(playlistQuery.getResultList());
        PlaylistLabel = new javax.swing.JLabel();
        Exit = new javax.swing.JButton();
        XMLexport = new javax.swing.JButton();
        AddPlaylistSong = new javax.swing.JButton();
        DeletePlaylistSong = new javax.swing.JButton();
        EditPlaylistSong = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PlaylistTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ΛΙΣΤΕΣ ΤΡΑΓΟΥΔΙΩΝ");

        PlaylistLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        PlaylistLabel.setText("Πίνακας Λιστών Τραγουδιών");

        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        Exit.setToolTipText("Έξοδος");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        XMLexport.setText("Εξαγωγή λίστας σε αρχείο XML");
        XMLexport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XMLexportActionPerformed(evt);
            }
        });

        AddPlaylistSong.setText("Προσθήκη");
        AddPlaylistSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPlaylistSongActionPerformed(evt);
            }
        });

        DeletePlaylistSong.setText("Διαγραφή");
        DeletePlaylistSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletePlaylistSongActionPerformed(evt);
            }
        });

        EditPlaylistSong.setText("Επεξεργασία");
        EditPlaylistSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditPlaylistSongActionPerformed(evt);
            }
        });

        PlaylistTable.setColumnSelectionAllowed(true);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, playlistList, PlaylistTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Όνομα");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${description}"));
        columnBinding.setColumnName("Περιγραφή");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${creationDate}"));
        columnBinding.setColumnName("Ημ/νία Δημιουργίας");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(PlaylistTable);
        PlaylistTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton1.setText("Εισαγωγή λίστας από αρχείο XML");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AddPlaylistSong)
                                .addGap(18, 18, 18)
                                .addComponent(DeletePlaylistSong)
                                .addGap(18, 18, 18)
                                .addComponent(EditPlaylistSong))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PlaylistLabel)
                            .addComponent(XMLexport))
                        .addGap(0, 82, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(PlaylistLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddPlaylistSong)
                    .addComponent(DeletePlaylistSong)
                    .addComponent(EditPlaylistSong))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(21, 21, 21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(XMLexport)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        dispose();
    }//GEN-LAST:event_ExitActionPerformed

    private void XMLexportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XMLexportActionPerformed
        // TODO add your handling code here:
       // Ανάκτηση λίστας
        selectedRow = PlaylistTable.getSelectedRow();

        // Έλεγχος ν έχει επιλεχθεί λίστα
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Δεν έχει επιλεχθεί λίστα", "Σφάλμα",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        //επιλεγόμενη λίστα
        playlist=playlistList.get(PlaylistTable.convertRowIndexToModel(selectedRow));
        
        try { 
            // Eπιλογέας αρχείων για XML
            JFileChooser Jfile = new JFileChooser();
            
            // Επιλογή xml
            int chooser = Jfile.showSaveDialog(this);
            if (chooser == JFileChooser.APPROVE_OPTION) { 
                //Αρχείο
                File XML = Jfile.getSelectedFile();
                
                // Δημιουργία ενός ΧΜLfile
                XMLfile xml = new XMLfile(XML);
                
                //καλούμε την writeXML
                xml.writeXML(playlist,XML);
                
                // Εμφάνισε μήνυμα επιβεβαίωσης
                JOptionPane.showMessageDialog(this, "Επιτυχής Αποθήκευση", " Αποθήκευση",
                                          JOptionPane.INFORMATION_MESSAGE);
            }
        } catch(Exception ex) { 
            JOptionPane.showMessageDialog(null, "Αποτυχία εξαγωγής σε xml!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
          
        
    }//GEN-LAST:event_XMLexportActionPerformed

    private void AddPlaylistSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPlaylistSongActionPerformed
        // TODO add your handling code here:
         // ανοίγει τη φόρμα διαχείρiσης Λίστας
        
        new NeworModifyPlaylist().setVisible(true);
    }//GEN-LAST:event_AddPlaylistSongActionPerformed

    private void DeletePlaylistSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletePlaylistSongActionPerformed
        // TODO add your handling code here:
             selectedRow = PlaylistTable.getSelectedRow();
        playlist=playlistList.get(PlaylistTable.convertRowIndexToModel(selectedRow));
        
         int choice = JOptionPane.showConfirmDialog(null, "Θα διαγραφει η playlist " + playlist.getName() +  "!", "",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (choice == 0) {    
            if (DBManager.deletePlaylist(playlist)) {
                playlistList.remove(playlist); //διαγραφη playlist
                JOptionPane.showMessageDialog(null, "Επιτυχής διαγραφή playlist!", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
                
            } else {
                JOptionPane.showMessageDialog(null, "Αποτυχία διαγραφής playlist!", "ERROR", JOptionPane.ERROR_MESSAGE);
           }
       }
    }//GEN-LAST:event_DeletePlaylistSongActionPerformed

    private void EditPlaylistSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditPlaylistSongActionPerformed
        // TODO add your handling code here:
        selectedRow =PlaylistTable.getSelectedRow();
        if (selectedRow==-1)
            JOptionPane.showMessageDialog(null,"Παρακαλώ επιλέξτε κάποια playlist!", "",
                JOptionPane.WARNING_MESSAGE);
        else{
            playlist = playlistList.get(PlaylistTable.convertRowIndexToModel(selectedRow));
            new NeworModifyPlaylist(playlist).setVisible(true);
        }
    }//GEN-LAST:event_EditPlaylistSongActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         try { 
            // Eπιλογέας αρχείων για XML
            JFileChooser Jfile = new JFileChooser();
            
            // Επιλογή xml
            int chooser = Jfile.showOpenDialog(this);
            if (chooser == JFileChooser.APPROVE_OPTION) { 
                //Αρχείο
                File XML = Jfile.getSelectedFile();
               
                // Δημιουργία ενός ΧΜLfile
                XMLfile xml = new XMLfile(XML);
                xml.readXML(XML);
                
            }
        } catch(Exception ex) { 
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Σφάλμα",
                                          JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListOfPlaylist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPlaylistSong;
    private javax.swing.JButton DeletePlaylistSong;
    private javax.swing.JButton EditPlaylistSong;
    private javax.swing.JButton Exit;
    private javax.swing.JLabel PlaylistLabel;
    public static javax.swing.JTable PlaylistTable;
    private javax.swing.JButton XMLexport;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    public static java.util.List<pojos.Playlist> playlistList;
    private javax.persistence.Query playlistQuery;
    private javax.persistence.EntityManager radioDBv2PUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
