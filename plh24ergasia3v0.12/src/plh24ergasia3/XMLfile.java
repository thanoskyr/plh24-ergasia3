package plh24ergasia3;

import java.io.File;
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
    
   
        
    public static void XmlFile(File xmlFile){
        
        try {
            
            //Δημιουργία .ΧΜL
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder;
            docBuilder = docFactory.newDocumentBuilder();
            
            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Λίστα");
            doc.appendChild(rootElement);
            
            // Όνομα λίστας
            Element xmlfile = doc.createElement("xmlfile");
            rootElement.appendChild(xmlfile);
            
            // Attributes του xmlfile
            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            xmlfile.setAttributeNode(attr);
            
            // Τραγούδια της λίστας
            Element Songplaylistlist = doc.createElement(("Λιστα"));
            rootElement.appendChild(Songplaylistlist);
            //για κάθε τραγούδι της λίστας 
                Playlist Playlist=new Playlist();
            for (Song song : Playlist.getSongList()) {
                Element Songplaylist = doc.createElement("Τραγούδι");
                Songplaylistlist.appendChild(Songplaylist);
                Element songTitle = doc.createElement("Τίτλος");
                songTitle.appendChild(doc.createTextNode(song.getTitle()));
                Songplaylistlist.appendChild(songTitle);
            }
            
            // Copy  xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Desktop\\songlist.xml"));
       
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
         Logger.getLogger(XMLfile.class.getName()).log(Level.SEVERE, null, ex);
     }
       
    }

  
}	
        

       

    
    
    