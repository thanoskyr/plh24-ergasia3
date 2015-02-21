/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plh24ergasia3;

/**
 * * @author 
 */
//under construction
import javax.persistence.*;
import pojos.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import plh24ergasia3.NewOrModifyBand.*;

public class DBManager {
    
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    public static void openConnection() {
    /* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */
    try {
    /* Δημιουργία EntityManagerFactory για το Persistence Unit της ΒΔ μας */
        emf = Persistence.createEntityManagerFactory("radioDBv2PU"); 
    /* Δημιουργία EntityManager */
        em = emf.createEntityManager(); 
    } catch(Exception e) {
        /* Εμφάνιση μηνύματος σφάλματος */
        System.out.println(e); 
        JOptionPane.showMessageDialog(null, "Αποτυχία σύνδεσης με τη ΒΔ!", "ERROR", JOptionPane.ERROR_MESSAGE);
        /* Αναγκαστικό κλείσιμο προγράμματος */
        // System.exit(0);
    }
    }
    
    public static void closeConnection() {
    /* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */
    try {
    /* Κλείσιμο EntityManager */
        em.close();
    /* Κλείσιμο EntityManagerFactory */
        emf.close();
    } catch(Exception e){ 
        System.out.println(e);
        JOptionPane.showMessageDialog(null, "Αποσύνδεση από τη ΒΔ!", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    }

   

    
    public EntityManager getEm() {
        return em;
    }
    
    
    
    
     
    /* Μέθοδος αποθήκευσης νέου καλλιτέχνη  */
    public static boolean addArtist(Artist artist){
    //* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */   
        try {
            em.getTransaction().begin();
            em.persist(artist);
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e); 
            return false;
        }
    }

    /* Μέθοδος τροποποίησης καλλιτέχνη */
    public static boolean modifyArtist(Artist artist){
    //* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */
        try {
            em.getTransaction().begin();
            em.merge(artist);
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e); 
            return false;
        }
    }

    /* Μέθοδος διαγραφής καλλιτέχνη */
    public static boolean deleteArtist(Artist artist){
    //* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */
        try {
            em.getTransaction().begin();
    /* Merging the contents of the detached entity with
    the persistence context and returns a reference to a managed entity */
            Artist ar = em.merge(artist);
            em.remove(ar);            
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    
    /* Μέθοδος αποθήκευσης νέου συγκροτήματος  */
    public static boolean addMusicGroup(MusicGroup musicGroup){//it works
    //* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */   
        
        try {
            em.getTransaction().begin();
            em.persist(musicGroup);
            for(Artist artist:musicGroup.getArtistList()){
                artist=em.merge(artist);}
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e); 
            return false;
        }
    }
    
    public static boolean modifyMusicGroup(MusicGroup group){
    //* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */
        try {
            em.getTransaction().begin();
            em.merge(group);
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e); 
            return false;
        }
    }

    /* Μέθοδος διαγραφής συγκροτήματος */
    public static boolean deleteMusicGroup(MusicGroup musicGroup){
    //* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */
        try {
            em.getTransaction().begin();
    /* Merging the contents of the detached entity with 
    the persistence context, and returns a reference to a managed entity */
            MusicGroup mg = em.merge(musicGroup);
            em.remove(mg);            
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    //μέθοδος εισαγωγής άλμπουμ
    public static boolean addAlbum(Album album){
        try {
            em.getTransaction().begin();
            em.persist(album);
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e); 
            return false;
        }
//* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */
        
    }
   
    // Εισαγωγή τραγουδιού
    
    public static boolean addSong(Song song){
        try {
            em.getTransaction().begin();
            em.persist(song);
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e); 
            return false;
        }
    
    }
    public static boolean modifySong(Song song){
        try{
            em.getTransaction().begin();
            em.merge(song);
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean addSongList(List<Song> songList){
        try {
            em.getTransaction().begin();
            em.persist(songList);
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e); 
            return false;
        }
    
    }
    
    public static boolean modifyAlbum(Album album){
    //* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */
        try {
            em.getTransaction().begin();
            em.merge(album);
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e); 
            return false;
        }
    }
    
    public static boolean deleteAlbum(Album album){
        //* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */
        try {
            em.getTransaction().begin();
    /* Merging the contents of the detached entity with
    the persistence context and returns a reference to a managed entity */
            Album ar = em.merge(album);
            em.remove(ar);            
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    
    }
    
    public static boolean deleteSong(Song song){
       //* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */
        try {
            em.getTransaction().begin();
    /* Merging the contents of the detached entity with
    the persistence context and returns a reference to a managed entity */
            Song s = em.merge(song);
            em.remove(s);            
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
     /* Μέθοδος αποθήκευσης νέας playlist  */
    public static boolean addPlaylist(Playlist playlist){
    //* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */   
        try {
            em.getTransaction().begin();
            em.persist(playlist);
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e); 
            return false;
        }
    }

    /* Μέθοδος τροποποίησης playlist */
    public static boolean modifyPlaylist(Playlist playlist){
    //* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */
        try {
            em.getTransaction().begin();
            em.merge(playlist);
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e); 
            return false;
        }
    }

    /* Μέθοδος διαγραφής playlist */
    public static boolean deletePlaylist(Playlist playlist){
    //* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */
        try {
            em.getTransaction().begin();
    /* Merging the contents of the detached entity with
    the persistence context and returns a reference to a managed entity */
            Playlist pl = em.merge(playlist);
            em.remove(pl);            
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    
// Καθαρίζει όλους τους πίνακες της ΒΔ
   
    private void clearDB(){         
    em.getTransaction().begin();
        try { 
                         
            Query query1=em.createQuery("DELETE FROM Album");
            query1.executeUpdate();
            Query query2=em.createQuery("DELETE FROM Artist");
            query2.executeUpdate();
            Query query3=em.createQuery("DELETE FROM MusicGroup");
            query3.executeUpdate();
            Query query4=em.createQuery("DELETE FROM Playlist");
            query4.executeUpdate();  
            Query query5=em.createQuery("DELETE FROM Song");
            query5.executeUpdate();
            em.getTransaction().commit();
            
        } catch (Exception e) {
           
            em.getTransaction().rollback();
        }  
    }

    public static boolean modifyBand(MusicGroup band, List<Artist> selectedArtistList){
    //* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */
    
    
    try {
        em.getTransaction().begin();
        // Διαγραφή καλλιτεχνών που δεν υπάρχουν
        
        for (Artist artist : band.getArtistList()) {
        /* Merging the contents of the detached entity with the persistence context, and returns a reference to a managed entity */
            artist = em.merge(artist);
            if (!selectedArtistList.contains(artist)){
            artist.getMusicGroupList().remove(band);
            //band.getArtistList().remove(artist); // Να ξαναδώ γιατί δεν μου δούλευε και έβαλα παρακάτω το retain
            }
        }
        
        band.getArtistList().retainAll(selectedArtistList);  
        //band=em.merge(band);
        // Εισαγωγή νέων καλλιτεχνων 
        for (Artist artist : selectedArtistList) {
        /* Merging the contents of the detached entity with the persistence context, and returns a reference to a managed entity */
            artist = em.merge(artist);
            if (!band.getArtistList().contains(artist)){
                band.getArtistList().add(artist);
                artist.getMusicGroupList().add(band);
             
            }
        }
        
        em.getTransaction().commit();
        return true;
    }catch(Exception e){
        System.out.println(e); 
        return false;
    }
}

    
        public static boolean modifyAlbumSongList(Album album, List<Song> songList){
    //* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */
    
    try {
        em.getTransaction().begin();
        // Διαγραφή τραγουδιων που δεν υπάρχουν
        
        for (Song song : album.getSongList()) {
        /* Merging the contents of the detached entity with the persistence context, and returns a reference to a managed entity */
            song = em.merge(song);
            if (!songList.contains(song)){
                song.setAlbumalbumId(null);
            //    album.getSongList().remove(song);
            
            }
        }
        album.getSongList().retainAll(songList);
   
        // Εισαγωγή νέων τραγουδιών
        for (Song song : songList) {
        /* Merging the contents of the detached entity with the persistence context, and returns a reference to a managed entity */
            song = em.merge(song);
            if(!album.getSongList().contains(song)){
                album.getSongList().add(song);
                song.setAlbumalbumId(album);
             
            }
        }
        
        em.getTransaction().commit();
        return true;
    }catch(Exception e){
        System.out.println(e); 
        return false;
    }
}

    
     
}
