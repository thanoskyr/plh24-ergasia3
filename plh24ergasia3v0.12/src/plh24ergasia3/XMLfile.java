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
    
    public synchronized Document readXmlDocument() {
        Document document;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(xmlFile);
            //isNewDocument = false;
            return document;
        }catch (Exception e){
            // File does not exist
            //isNewDocument = true;
            return null;
        }
    }
     
     public synchronized void readXML (File xmlFile){
         //Ελλιπής κώδικας
         try {

	DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
	Document doc = dBuilder.parse(xmlFile);
        
        doc.getDocumentElement().normalize();

 
	NodeList nList = doc.getElementsByTagName("name");
        NodeList dList = doc.getElementsByTagName("description");
        NodeList daList = doc.getElementsByTagName("date");
        for (int i = 0; i< nList.getLength(); i++) {
                Node nNode = nList.item(i);
             if(nNode.getNodeType()== Node.ELEMENT_NODE){
                 Element name=(Element) nNode;
             }   
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
 

        
    public synchronized void writeXML (Playlist p,File xmlFile){
        //παρόλο που φτιάχνεται ΧΜL αρχείο είναι κενό
        try {
            
            //Δημιουργία .ΧΜL
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder;
            docBuilder = docFactory.newDocumentBuilder();
            
            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("rootElement");
            doc.appendChild(rootElement);
            
            Element root = doc.getDocumentElement();
            
            Element playlist=doc.createElement("Playlist");
            root.appendChild(playlist);
            
            // set attribute to purchase element
                Attr attr = doc.createAttribute("name");
                if (p.getName()==null){
                    attr.setValue("");
                    } else {
                    attr.setValue(p.getName());
                }
                playlist.setAttributeNode(attr);
                
            
            //description elements
            Element description = doc.createElement("description");
            description.appendChild(doc.createTextNode(p.getDescription()));
            playlist.appendChild(description);
           
            // date elements
            Element date = doc.createElement("date");
            date.appendChild(doc.createTextNode(df.format(p.getCreationDate())));
            playlist.appendChild(date);
            
            
            // Τραγούδια λίστας
            Element Songplaylistlist = doc.createElement(("songplaylistlist"));
            playlist.appendChild(Songplaylistlist);
            
           for (Song song : p.getSongList()) {
                Element title = doc.createElement("title");
                title.appendChild(doc.createTextNode(song.getTitle()));
                Songplaylistlist.appendChild(title);
                Element duration = doc.createElement("duration");
                duration.appendChild(doc.createTextNode(Integer.toString(song.getDuration())));
                Songplaylistlist.appendChild(duration);
                
                if(song.getAlbumalbumId().getMusicGroupmusicGroupId()!=null){ //τραγουδι συγκροτήματος       
                    Element musicGroup=doc.createElement("musicGroup");
                    musicGroup.appendChild(doc.createTextNode(song.getAlbumalbumId().getMusicGroupmusicGroupId().getName()));
                    Songplaylistlist.appendChild(musicGroup);
                }
                else{//τραγουδι καλλιτέχνη
                    Element artist=doc.createElement("artist");
                    artist.appendChild(doc.createTextNode(song.getAlbumalbumId().getArtistartistId().getLastName()));
                    Songplaylistlist.appendChild(artist);
                }
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
        

       

    
    
    