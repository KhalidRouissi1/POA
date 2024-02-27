package TP2;

import java.util.*;

public class Patient {
    private String nom ;
    private Set<String > ordonnance ;
    public Patient ( String n){
        nom = n ;
        ordonnance = new HashSet<String >();
    }
    public String getNom () {
        return nom;
    }

    public boolean ordonnanceVide (){
        return  ordonnance.isEmpty();
    }

    public void ajoutMedicament ( String m) {
        ordonnance.add(m);
    }

    public void affiche() {
        System.out.println("Ordonnance de " + nom + ":");
        if (ordonnance.isEmpty()) {
            System.out.println("Aucun médicament prescrit.");
        } else {
            for (String medicament : ordonnance) {
                System.out.println("- " + medicament);
            }
        }
    }
    public boolean contientMedicament (String m) {
        return ordonnance.contains(m);
    }


    public void trieOrdonnace() {

        TreeSet<String> ordd = new TreeSet<String>(ordonnance);
        ordonnance.clear();
        ordonnance.addAll(ordd);

    }




}
