package EX2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Annuaire annuaire = new Annuaire();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            String commande = scanner.nextLine().trim();

            if (commande.startsWith("+")) {
                String[] elements = commande.substring(1).split(",");
                if (elements.length == 3) {
                    annuaire.ajouterFiche(elements[0].trim(), elements[1].trim(), elements[2].trim());
                    System.out.println("Fiche ajoutée avec succes.");
                } else {
                    System.out.println("Format invalide ");
                }
            } else if (commande.startsWith("?")) {
                String nom = commande.substring(1).trim();
                annuaire.chercherFiche(nom);
            } else if (commande.equals("!")) {
                annuaire.afficherAnnuaire();
            } else if (commande.equals(".")) {
                System.out.println("Programme terminé.");
                break;
            } else {
                System.out.println("Commande non reconnue.");
            }
        }

        scanner.close();
    }
}
