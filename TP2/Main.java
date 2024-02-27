package TP2;

public class Main {
    public static void main(String[] args) {
        DossierPharmacie pharmacie = new DossierPharmacie("Ma Pharmacie");

        pharmacie.nouveauPatient("Ahmed", new String[]{"AA", "SS"});
        pharmacie.nouveauPatient("Salah", new String[]{"FF"});
        pharmacie.nouveauPatient("Sara", new String[]{"AA", "SS", "RR"});

        pharmacie.affiche();

        pharmacie.ajoutMedicament("Sara", "YY");

        pharmacie.affichePatient("Salah");

        // Find patients with a specific medication
        System.out.println("Patients with Paracetamol:");
        for (String patient : pharmacie.affichePatientAvecMedicament("AA")) {
            System.out.println(patient);
        }    }
}
