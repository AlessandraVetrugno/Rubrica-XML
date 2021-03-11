package rubrica;

import java.util.ArrayList;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vasile Laura, Vetrugno Alessandra
 */
public class Contatto {
    public String nome;
    public String Cognome;
    public String telefono_casa;
    public String indirizzo_email;

    public Contatto(String nome, String Cognome, String telefono_casa, String indirizzo_email) {
        this.nome = nome;
        this.Cognome = Cognome;
        this.telefono_casa = telefono_casa;
        this.indirizzo_email = indirizzo_email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String Cognome) {
        this.Cognome = Cognome;
    }

    public String getTelefono_casa() {
        return telefono_casa;
    }

    public void setTelefono_casa(String telefono_casa) {
        this.telefono_casa = telefono_casa;
    }

    public String getIndirizzo_email() {
        return indirizzo_email;
    }

    public void setIndirizzo_email(String indirizzo_email) {
        this.indirizzo_email = indirizzo_email;
    }

    public boolean ricerca (String nome){
        return  (this.nome.equalsIgnoreCase(nome) || this.Cognome.equalsIgnoreCase(nome));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.Cognome);
        hash = 79 * hash + Objects.hashCode(this.telefono_casa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contatto other = (Contatto) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.Cognome, other.Cognome)) {
            return false;
        }
        if (!Objects.equals(this.telefono_casa, other.telefono_casa)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "    "+ "nome: " +nome+"            "+"cognome: "+ Cognome+"            " +"telefono: "+ telefono_casa+"            "+"email: "+ indirizzo_email ;
    }
    

    
}
