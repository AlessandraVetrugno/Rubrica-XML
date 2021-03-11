/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubrica;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 *
 * @author Vasile Laura, Vetrugno Alessandra
 */
public class Scrittura {
        public static void scrittura(ArrayList<Contatto>write){ 
         try {
            
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
 
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
 
            Document document = documentBuilder.newDocument();
 
        
            Element root = document.createElement("rub");
            document.appendChild(root);
 
            for(int i=0;i<write.size();i++){
            Element persona  = document.createElement("persona");
 
            root.appendChild(persona);

            Element nome = document.createElement("nome");
            nome.appendChild(document.createTextNode(write.get(i).getNome()));
            persona.appendChild(nome);
 
        
            Element cognome = document.createElement("cognome");
            cognome.appendChild(document.createTextNode(write.get(i).getCognome()));
            persona.appendChild(cognome);
            
            Element numero_telefono = document.createElement("numero_telefono");
            numero_telefono.appendChild(document.createTextNode(write.get(i).getTelefono_casa()));
            persona.appendChild(numero_telefono);
            
            Element indirizzo_email = document.createElement("indirizzo_email");
            indirizzo_email.appendChild(document.createTextNode(write.get(i).getIndirizzo_email()));
            persona.appendChild(indirizzo_email);
            root.appendChild(persona);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("testo.xml"));
 
        
            
            transformer.transform(domSource, streamResult);
 
            
 
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
