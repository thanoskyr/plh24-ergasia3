package plh24ergasia3;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import pojos.Playlist;
import pojos.Song;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XMLfile {
    
    private final DateFormat df;
    private File xmlFile;
    

    public XMLfile(File xmlFile) {//constructor
        this.xmlFile = xmlFile;
        df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
       
        
    }
   
     public synchronized void readXML (File xmlFile){
     
         try {

	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(xmlFile);
 
	
	doc.getDocumentElement().normalize();
 
	NodeList nList = doc.getElementsByTagName("Όνομα");
        
        for (int i = 0; i< nList.getLength(); i++) {
 
		Node nNode = nList.item(i);
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
 

        
    public synchronized void writeXML (Playlist p,File xmlFile){
        
        try {
            
            //Δημιουργία .ΧΜL
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder;
            docBuilder = docFactory.newDocumentBuilder();
            
            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("rootElement");
            
            
            //name elements
            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(String.format(p.getName())));
            rootElement.appendChild(name);
            
            //description elements
            Element description = doc.createElement("description");
            description.appendChild(doc.createTextNode(String.format(p.getDescription())));
            rootElement.appendChild(description);
           
            // date elements
            Element date = doc.createElement("date");
            date.appendChild(doc.createTextNode(df.format(p.getCreationDate())));
            doc.appendChild(date);
            
            
            // Τραγούδια λίστας
            Element Songplaylistlist = doc.createElement(("list"));
            rootElement.appendChild(Songplaylistlist);
            
           for (Song song : p.getSongList()) {
                Element songTitle = doc.createElement("title");
                songTitle.appendChild(doc.createTextNode(song.getTitle()));
                Songplaylistlist.appendChild(songTitle);
                Element songDuration = doc.createElement("duration");
                songDuration.appendChild(doc.createTextNode(Integer.toString(song.getDuration())));
                Songplaylistlist.appendChild(songDuration);
                
            }
            
            // Copy  xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);
       
        //exceptions
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
         Logger.getLogger(XMLfile.class.getName()).log(Level.SEVERE, null, ex);
     }  catch (TransformerException ex) {
            Logger.getLogger(XMLfile.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

  
}	
        

       

    
    
    