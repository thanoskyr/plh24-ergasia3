/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plh24ergasia3;


import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import pojos.Album;
import pojos.MusicGroup;
import pojos.MusicProductionCompany;
import pojos.Song;




/**
 *
 * @author Rithri
 */
public class NewOrModifyBandAlbum extends javax.swing.JFrame {
    
    private Album album;//δημιουργια field
    private MusicProductionCompany company;
    private int selectedBandRow;
    private int selectedCompanyRow;
    boolean modify;
    private MusicGroup band;
    String typos;
    Song song;
    Random generator = new Random(); 
    /**
     * Creates new form ModifyBandAlbum
     */
  
     public NewOrModifyBandAlbum(){
         initComponents();
         songList.clear();
         modify=false;
         selectedBandRow=-1;
         selectedCompanyRow=-1;
         setTitle("ΠΡΟΣΘΗΚΗ ΑΛΜΟΥΜ ΣΥΓΚΡΟΤΗΜΑΤΟΣ");
    }
    
    
    public NewOrModifyBandAlbum(Album a){
         initComponents();
         album=a;
         modify=true;
         songList.clear();
         albumTitle.setText(album.getTitle());
         releaseDate.setDate(album.getReleaseDate());
         albumNo.setText(Integer.toString(album.getDiskNumber()));
         for(Song song:album.getSongList()){
             songList.add(song);
         }
         setTitle("ΤΡΟΠΟΠΟΙΗΣΗ ΑΛΜΠΟΥΜ ΣΥΓΚΡΟΤΗΜΑΤΟΣ");
    }
    
    public boolean checkFields(){
        if((!albumTitle.getText().isEmpty())&&(!albumNo.getText().isEmpty())&&releaseDate!=null)
            if(selectedBandRow>=0&&selectedCompanyRow>=0)
                return true;
            else{
                JOptionPane.showMessageDialog(null, "Πρέπει να επιλεγει εταιρεία και συγκροτημα απο τι λιστες", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        else{
            JOptionPane.showMessageDialog(null, "Πρέπει να συμπληρωθoύν όλα τα πεδία ", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false; 
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        radioDBv2PUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("radioDBv2PU").createEntityManager();
        songQuery = java.beans.Beans.isDesignTime() ? null : radioDBv2PUEntityManager.createQuery("SELECT s FROM Song s");
        songList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(songQuery.getResultList());
        musicProductionCompanyQuery1 = java.beans.Beans.isDesignTime() ? null : radioDBv2PUEntityManager.createQuery("SELECT m FROM MusicProductionCompany m");
        musicProductionCompanyList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(musicProductionCompanyQuery1.getResultList());
        musicGroupQuery = java.beans.Beans.isDesignTime() ? null : radioDBv2PUEntityManager.createQuery("SELECT m FROM MusicGroup m");
        musicGroupList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(musicGroupQuery.getResultList());
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        songArray = new javax.swing.JTable();
        albumTitle = new javax.swing.JTextField();
        albumNo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        releaseDate = new com.toedter.calendar.JDateChooser();
        cancel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        bandTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        companyTable = new javax.swing.JTable();
        insertSong = new javax.swing.JButton();
        deleteSong = new javax.swing.JButton();
        save = new javax.swing.JButton();
        saveNewSong = new javax.swing.JButton();
        type2 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 800));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Διαχείριση Άλμπουμ Συγκροτήματος");

        jLabel2.setText("Τίτλος");

        jLabel3.setText("Τύπος Άλμπουμ");

        jLabel4.setText("Αριθμός Άλμπουμ");

        jLabel5.setText("Εταιρία Παραγωγής");

        jLabel7.setText("Ημερομηνία Κυκλοφορίας");

        jLabel8.setText("Λίστα Τραγουδιών:");

        songArray.setColumnSelectionAllowed(true);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, songList, songArray);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${title}"));
        columnBinding.setColumnName("Τίτλος");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${duration}"));
        columnBinding.setColumnName("διάρκεια σε sec");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tracknr}"));
        columnBinding.setColumnName("Αριθμός σειράς");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(songArray);
        songArray.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        albumTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albumTitleActionPerformed(evt);
            }
        });

        albumNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albumNoActionPerformed(evt);
            }
        });

        jLabel10.setText("Συγκροτήμα:");

        cancel.setText("Ακύρωση");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, musicGroupList, bandTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Ονομα");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${formationDate}"));
        columnBinding.setColumnName("Ημ/νια δημιουργίας");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(bandTable);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, musicProductionCompanyList, companyTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Ονομα");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${address}"));
        columnBinding.setColumnName("Διευθυνση");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${telephone}"));
        columnBinding.setColumnName("τηλέφωνο");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane3.setViewportView(companyTable);

        insertSong.setText("Εισαγωγή");
        insertSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertSongActionPerformed(evt);
            }
        });

        deleteSong.setText("Διαγραφή");
        deleteSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSongActionPerformed(evt);
            }
        });

        save.setText("Αποθήκευση");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        saveNewSong.setText("Αποθήκευση");
        saveNewSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveNewSongActionPerformed(evt);
            }
        });

        type2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  "CD", "EP", "LP" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(126, 126, 126)
                                .addComponent(albumTitle))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(type2, 0, 208, Short.MAX_VALUE)
                                    .addComponent(albumNo)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addGap(26, 26, 26)))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(insertSong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteSong))
                            .addComponent(jLabel7)
                            .addComponent(cancel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveNewSong))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(releaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(441, 441, 441))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(albumTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(type2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(albumNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(insertSong)
                            .addComponent(deleteSong)
                            .addComponent(saveNewSong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(releaseDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancel))
                        .addGap(82, 82, 82))))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    
    
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        //this.setVisible(false); //κλεινει αυτη η φορμα
        new Kentriki().setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void albumTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_albumTitleActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_albumTitleActionPerformed

    private void albumNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_albumNoActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_albumNoActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        selectedBandRow=bandTable.getSelectedRow();
        selectedCompanyRow=companyTable.getSelectedRow();
        if(songList.size()>0){
        if(checkFields()==true){
            
            band=musicGroupList.get(bandTable.convertRowIndexToModel(selectedBandRow));
            company=musicProductionCompanyList.get(companyTable.convertRowIndexToModel(selectedCompanyRow));
            if(!modify){//νέα εγγραφή άλμπουμ
                album = new Album();
                album.setTitle(albumTitle.getText());
                //Tύπος άλμπουμ
                typos = (String) type2.getSelectedItem();
                        if (typos.equals("CD")) { 
                             album.setType("CD");
                             } else if (typos.equals("EP")) { 
                               album.setType("EP");
                             } else { 
                              album.setType("LP");
                                                    }
                album.setDiskNumber(Integer.parseInt(albumNo.getText()));//κανω το string int
                album.setReleaseDate(releaseDate.getDate());
                album.setMusicProductionCompanyname(company);
                album.setMusicGroupmusicGroupId(band);
                album.setSongList(songList);
            
                for(Song song:songList){//για κάθε τραγούδι της λιστας                   
                    song.setAlbumalbumId(album);
                    }
                if(DBManager.addAlbum(album)){//ενημερωση πίνακα
                    for (MusicGroup band : musicGroupList) { 
                        if (!band.getAlbumList().contains(album))
                            band.getAlbumList().add(album);
                    }
                    AlbumArrayBand.albumList1.add(album);
                    JOptionPane.showMessageDialog(null, "Επιτυχής αποθήκευση νέου αλμπουμ!", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            }
            else{//επεξεργασία του υπάρχοντος
                album.setTitle(albumTitle.getText());
                //Tύπος άλμπουμ
                typos = (String) type2.getSelectedItem();
                        if (typos.equals("CD")) { 
                             album.setType("CD");
                             } else if (typos.equals("EP")) { 
                               album.setType("EP");
                             } else { 
                              album.setType("LP");
                                                    }
                album.setDiskNumber(Integer.parseInt(albumNo.getText()));//κανω το string int
                album.setReleaseDate(releaseDate.getDate());
                album.setMusicProductionCompanyname(company);
                album.setMusicGroupmusicGroupId(band);
                if(DBManager.modifyAlbumSongList(album,songList)){
                    if(DBManager.modifyAlbum(album)){
                        JOptionPane.showMessageDialog(null, "Επιτυχής επεξεργασία " , "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);                                           
                        //ενημέρωση πίνακα
                        AlbumArrayBand.albumList1.set(AlbumArrayBand.jTable1.getSelectedRow(),album);
                        dispose();
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Σφάλμα επικοινωνίας με τη ΒΔ!", "ERROR", JOptionPane.ERROR_MESSAGE);

            }
        }
        }
        else
            JOptionPane.showMessageDialog(null, "Πρέπει να προστεθει τουλαχιστον ενα τραγούδι!", "ERROR", JOptionPane.ERROR_MESSAGE);

    }//GEN-LAST:event_saveActionPerformed

    private void insertSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertSongActionPerformed
        int id=generator.nextInt();
        song = new Song(id,"τιτλος",0,0);//δημιουργει νεο κενό που το τροποποιουμε με το χέρι
        songList.add(song);//εισαγει το "λευκο" song
        JOptionPane.showMessageDialog(null, "Παρακαλω επεξεργαστείτε το νέο τραγούδι, πατήστε enter και το κουμπί αποθηκευση", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);     
      
    }//GEN-LAST:event_insertSongActionPerformed

    private void deleteSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSongActionPerformed
        // TODO add your handling code here:
        int selectedSongRow=songArray.getSelectedRow();
        Song song1=songList.get(songArray.convertRowIndexToModel(selectedSongRow));
        if (DBManager.deleteSong(song1)){
            songList.remove(song1);           
        }
        else {
            JOptionPane.showMessageDialog(null, "Αποτυχία διαγραφής τραγουδιου!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteSongActionPerformed
    public static boolean checkSong(Song song, List<Song> songlist ){
        //εμεις εχουμε σχεδιασει τη βάση ώστεκαθε τραγουδι να έχει μοναδικο id
        songlist.remove(song);//αφαιρω το song
        for(Song s : songlist){
            if(s.getTitle().equals(song.getTitle())){
                return true;//υπάρχει το τραγουδι μεσα στη λιστα ηδη
            }
        }
        return false;
    }
    private void saveNewSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveNewSongActionPerformed
        // TODO add your handling code here: πρεπει να γινεται ελεγχος!
        if(!checkSong(song,songList)){//αν δεν υπάρχει το τραγουδι στη λιστα
            songList.add(song);
            
            if(DBManager.addSong(song)){ 
            
                JOptionPane.showMessageDialog(null, "Το νέο τραγούδι αποθηκεύτηκε με επιτυχία", "SUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);     
            }
            else{
                JOptionPane.showMessageDialog(null, "Αποτυχία εισαγωγής τραγουδιου στη ΒΔ!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            
            JOptionPane.showMessageDialog(null, "Το τραγούδι υπάρχει ήδη στη λίστα!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveNewSongActionPerformed

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
            java.util.logging.Logger.getLogger(NewOrModifyBandAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewOrModifyBandAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewOrModifyBandAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewOrModifyBandAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewOrModifyBandAlbum().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField albumNo;
    private javax.swing.JTextField albumTitle;
    private javax.swing.JTable bandTable;
    private javax.swing.JButton cancel;
    private javax.swing.JTable companyTable;
    private javax.swing.JButton deleteSong;
    private javax.swing.JButton insertSong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private java.util.List<pojos.MusicGroup> musicGroupList;
    private javax.persistence.Query musicGroupQuery;
    private java.util.List<pojos.MusicProductionCompany> musicProductionCompanyList;
    private javax.persistence.Query musicProductionCompanyQuery1;
    private javax.persistence.EntityManager radioDBv2PUEntityManager;
    private com.toedter.calendar.JDateChooser releaseDate;
    private javax.swing.JButton save;
    private javax.swing.JButton saveNewSong;
    protected static javax.swing.JTable songArray;
    private java.util.List<pojos.Song> songList;
    private javax.persistence.Query songQuery;
    private javax.swing.JComboBox type2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

 
   

}
