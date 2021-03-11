/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubrica;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Vasile Laura, Vetrugno Alessandra
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button aggiungibt;
    @FXML
    private Button elimina;
    @FXML
    private TextArea NomeTxt;
    @FXML
    private TextArea CognomeTxt;
    @FXML
    private TextArea NumeroTxt;
    @FXML
    private TextArea EmailTxt;
    private Gestione g;
    @FXML
    private Label listaLBL;

   
    @FXML
    private Button ricercabt;
    @FXML
    private TextField ricerca;
    @FXML
    private Button salva;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       g = new  Gestione();
       g.setRubrica(Carica.carica());
        listaLBL.setText(g.toString());
    }  
    
    private ArrayList<Contatto> rubrica;

    @FXML
    private void Add(ActionEvent event) {
        g.Add(new Contatto(NomeTxt.getText(), CognomeTxt.getText(), NumeroTxt.getText(), EmailTxt.getText()));
        listaLBL.setText(g.toString());
        Scrittura.scrittura(g.getRubrica());
       
   
    }
    
    @FXML
    private void Remove(ActionEvent event) {
        g.R_eliminazione(NomeTxt.getText(), CognomeTxt.getText(), NumeroTxt.getText());
        listaLBL.setText(g.toString());
        Scrittura.scrittura(g.getRubrica());
        // bisogna fare una ricerca tra i contatti per l'eliminazione
    }

    @FXML
    private void Ricerca(ActionEvent event) {
        if(ricerca.getText().equals(""))
        {
            listaLBL.setText(g.toString());
            return;
        }
        String s="";
        for(Contatto c: g.ricerca(ricerca.getText()))
        {
            s+=c.toString()+ "\n";
        }
       listaLBL.setText(s);
    }

    @FXML
    private void save(ActionEvent event) {
       Scrittura.scrittura(g.getRubrica()); 
    }
     
    
    
    
    
}
