package TP2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class DossierPharmacie {
    private String nom ;
    private HashMap<String , Patient > patients ;


    public DossierPharmacie ( String n) {
        nom = n;
        patients = new HashMap<String, Patient>();
    }


    void nouveauPatient(String nom, String[] ord) {
        Patient p = new Patient(nom);
        for (String medicament : ord) {
            p.ajoutMedicament(medicament);
        }
        patients.put(nom.toLowerCase(), p);
    }

    public boolean ajoutMedicament(String nom, String m) {

        Patient p = patients.get(nom);
        if (p != null) {
            p.ajoutMedicament(m);
            return true;
        }
        return false;
    }


    public void affichePatient(String nom) {
        Patient p = patients.get(nom);
        if (p != null) {
            System.out.println("Nom du patient : " + p.getNom());
            p.affiche();
        } else {
            System.out.println("Le patient " + nom + " n'existe pas.");
        }
    }

    public void affiche() {
        System.out.println("Nom de la pharmacie : " + nom);
        System.out.println("Liste des patients :");
        for (Patient p : patients.values()) {
            System.out.println("Nom du patient : " + p.getNom());
            p.affiche();
            System.out.println();
        }
    }


    public Collection<String> affichePatientAvecMedicament(String m) {
        Collection<String> patientsAvecMedicament = new ArrayList<>();

        for (Patient p : patients.values()) {
            if (p.contientMedicament(m)) {
                patientsAvecMedicament.add(p.getNom());
            }
        }

        return patientsAvecMedicament;
    }
}
