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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

public class DBManager {
    
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    public static void openConnection() {
    /* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */
    try {
    /* Δημιουργία EntityManagerFactory για το Persistence Unit της ΒΔ μας */
        emf = Persistence.createEntityManagerFactory("plh24ergasia3PU"); 
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
    public static boolean addMusicGroup(MusicGroup musicGroup){
    //* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */   
        try {
            em.getTransaction().begin();
            em.persist(musicGroup);
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            System.out.println(e); 
            return false;
        }
    }

    /* Μέθοδος τροποποίησης συγκροτήματος*/
    public static boolean modifyMusicGroup(MusicGroup musicGroup){
    //* Χρήση exceptions για τον χειρισμό λαθών κατά την επικοινωνία με τη ΒΔ */
        try {
            em.getTransaction().begin();
            em.merge(musicGroup);
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


    
   







}
