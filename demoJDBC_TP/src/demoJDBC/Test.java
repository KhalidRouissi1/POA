package demoJDBC;

import beans.Client;
import services.ClientService;

public class Test {
    public static void main(String[] args) {
        ClientService cs = new ClientService();

        cs.create(new Client("SAFI", "ali"));
        cs.create(new Client("ALAOUI", "widane"));
        cs.create(new Client("RAMI", "amine"));
        cs.create(new Client("ALAMI", "kamal"));
        cs.create(new Client("SELAMI", "mohamed"));

        // Afficher le client dont id = 3
        Client c = cs.findById(3);
        if (c != null) {
            System.out.println("Client avec id = 3 : " + c.getNom() + " " + c.getPrenom());
        } else {
            System.out.println("Aucun client avec id = 3 trouvé !");
        }

        // Supprimer le client dont id = 3
        Client clientToDelete = cs.findById(3);
        if (clientToDelete != null) {
            cs.delete(clientToDelete);
            System.out.println("Client avec id = 3 supprimé !");
        } else {
            System.out.println("Aucun client avec id = 3 trouvé !");
        }

        // Modifier le client dont id = 2
        Client cc = cs.findById(2);
        if (cc != null) {
            cc.setNom("nouveau nom");
            cc.setPrenom("nouveau Prénom");
            cs.update(cc);
            System.out.println("Client avec id = 2 mis à jour !");
        } else {
            System.out.println("Aucun client avec id = 2 trouvé !");
        }

        // Afficher la liste des clients
        System.out.println("Liste des clients :");
        for (Client cl : cs.findAll()) {
            System.out.println(cl.getNom());
        }
    }
}
