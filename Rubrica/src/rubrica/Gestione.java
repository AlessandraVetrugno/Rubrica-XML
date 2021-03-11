package rubrica;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vasile Laura, Vetrugno Alessandra 
 */
public class Gestione {
    private ArrayList<Contatto> rubrica;

    public Gestione() {
        rubrica= new ArrayList<>();
    }

    public ArrayList<Contatto> getRubrica() {
        return rubrica;
    }

    public void setRubrica(ArrayList<Contatto> rubrica) {
        this.rubrica = rubrica;
    }
    
    
    public void Add(Contatto c){
        rubrica.add(c);
    }
    
    
    
    @Override
    public String toString(){
        String r="";
        for(int i=0;i<rubrica.size();i++){
            r+=rubrica.get(i).toString()+"\n";
        }
        return  r;
        
   }
    public ArrayList<Contatto> ricerca(String nome){
        ArrayList<Contatto> ricercati=new ArrayList<>();
        for(Contatto c : rubrica){
            if(c.ricerca(nome))
              ricercati.add(c);
    }
        return ricercati;
    }
    
    public void  R_eliminazione (String nome, String cognome, String numero)
    {
        Contatto temp= new Contatto(nome,cognome,numero, " ");
        for(Contatto c : rubrica){
            if(c.equals(temp)){
              rubrica.remove(c);
            return;
            }
    }
    
    }
}

    

