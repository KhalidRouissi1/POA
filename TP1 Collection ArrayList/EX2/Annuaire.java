package EX2;

import java.util.HashMap;
import java.util.Map;

class Annuaire {
    private Map<String, Fiche> annuaire;

    public Annuaire() {
        this.annuaire = new HashMap<>();
    }

    public void ajouterFiche(String nom, String numero, String adresse) {
        Fiche fiche = new Fiche(nom, numero, adresse);
        annuaire.put(nom, fiche);
    }

    public void chercherFiche(String nom) {
        Fiche fiche = annuaire.get(nom);
        if (fiche != null) {
            System.out.println("Nom: " + fiche.getNom());
            System.out.println("Numero: " + fiche.getNumero());
            System.out.println("Adresse: " + fiche.getAdresse());
        } else {
            System.out.println("Aucune fiche pour le nom " + nom);
        }
    }

    public void afficherAnnuaire() {
        for (Fiche fiche : annuaire.values()) {
            System.out.println("Nom: " + fiche.getNom());
            System.out.println("Numero: " + fiche.getNumero());
            System.out.println("Adresse: " + fiche.getAdresse());
            System.out.println();
        }
    }

}