package plh24ergasia3;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import pojos.Playlist;
import pojos.Song;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLfile {
    
    private final DateFormat df;
    private File xmlFile;
    

    public XMLfile(File xmlFile) {//constructor
        this.xmlFile = xmlFile;
        df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
       
        
    }
   
     public synchronized void readXML (){}
   
        
    public synchronized void writeXML (Playlist p,File xmlFile){
        
        try {
            
            //Δημιουργία .ΧΜL
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder;
            docBuilder = docFactory.newDocumentBuilder();
            
            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("root");
            doc.appendChild(rootElement);
            
            
            //όνομα
            Element name = doc.createElement("Όνομα");
            name.appendChild(doc.createTextNode(String.format(p. getName())));
            rootElement.appendChild(name);
            
            Element description = doc.createElement("Περιγραφή");
            description.appendChild(doc.createTextNode(String.format(p. getDescription())));
            rootElement.appendChild(description);
           
            // date elements
            Element date = doc.createElement("Ημερομηνία");
            date.appendChild(doc.createTextNode(df.format(p. getCreationDate())));
            doc.appendChild(date);
            
            
            
            
            // Τραγούδια της λίστας
            Element Songplaylistlist = doc.createElement(("Λιστα"));
            rootElement.appendChild(Songplaylistlist);
            //για κάθε τραγούδι της λίστας 
                Playlist Playlist=new Playlist();
            for (Song song : Playlist.getSongList()) {
                Element songTitle = doc.createElement("Τίτλος");
                songTitle.appendChild(doc.createTextNode(song.getTitle()));
                Songplaylistlist.appendChild(songTitle);
                Element songDuration = doc.createElement("Διάρκεια");
                songDuration.appendChild(doc.createTextNode(Integer.toString(song.getDuration())));
                Songplaylistlist.appendChild(songDuration);
                
            }
            
            // Copy  xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
       
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
         Logger.getLogger(XMLfile.class.getName()).log(Level.SEVERE, null, ex);
     }
       
    }

  
}	
        

       

    
    
    