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

public class XMLfile {
    
    private final DateFormat df;
    private File xmlFile;
    
    public XMLfile(File xmlFile) {//constructor
        this.xmlFile = xmlFile;
        df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        
    }
    
      
    public synchronized void writeXML (Playlist p,File xmlFile){
       
        try {
            
            //Δημιουργία .ΧΜL
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder;
            docBuilder = docFactory.newDocumentBuilder();
            
           
            Document doc = docBuilder.newDocument();
            Element playlist=doc.createElement("Playlist");
            doc.appendChild(playlist);
            
            // set attribute to playlist element
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
            Element songplaylist = doc.createElement(("songsOfPlaylist"));
            playlist.appendChild(songplaylist);
            
           for (Song song : p.getSongList()) {
                Element songElement=doc.createElement("song");
                //songId.appendChild(doc.createTextNode(Integer.toString(song.getSongId())));
                songplaylist.appendChild(songElement);
                
                Element title = doc.createElement("title");
                title.appendChild(doc.createTextNode(song.getTitle()));
                songElement.appendChild(title);
                
                Element duration = doc.createElement("duration");
                duration.appendChild(doc.createTextNode(Integer.toString(song.getDuration())));
                songElement.appendChild(duration);
                      
                Element musicGroup=doc.createElement("musicGroup");
                Element artist=doc.createElement("artist");
                if(song.getAlbumalbumId().getMusicGroupmusicGroupId()!=null){ //τραγουδι συγκροτήματος
                    musicGroup.appendChild(doc.createTextNode(song.getAlbumalbumId().getMusicGroupmusicGroupId().getName()));
                    artist.appendChild(doc.createTextNode("-"));
                }
                else{ //τραγουδι καλλιτέχνη {
                    musicGroup.appendChild(doc.createTextNode("-"));
                    artist.appendChild(doc.createTextNode(song.getAlbumalbumId().getArtistartistId().getLastName()));
                        
                        }   
                songElement.appendChild(musicGroup);
                songElement.appendChild(artist);
   
                
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
        

       
    