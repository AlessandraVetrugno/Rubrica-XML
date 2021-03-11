package rubrica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author  Vasile Laura, Vetrugno Alessandra
 */
public class Carica {
    public static ArrayList<Contatto> carica()  {  
        ArrayList<Contatto> lista = new ArrayList<>();
    
     try{
         java.io.File inputFile = new java.io.File("testo.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         NodeList nList = doc.getElementsByTagName("persona");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               Contatto c = new Contatto( eElement.getElementsByTagName("nome").item(0).getTextContent(),
                       eElement.getElementsByTagName("cognome").item(0).getTextContent(),
                       eElement.getElementsByTagName("numero_telefono").item(0).getTextContent(),
                       eElement.getElementsByTagName("indirizzo_email").item(0).getTextContent());
                 lista.add(c);
            }
         }
      } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
      }
        return lista;
    }
    
    
    
    
    
    
    
    
}
