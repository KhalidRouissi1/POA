package connexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static final String URL = "jdbc:mysql://localhost:3306/demoJDBC";
    private static final String UTILISATEUR = "root";
    private static final String MOT_DE_PASSE = "root";

    public static Connection obtenirConnexion() {
        Connection connexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connexion = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
            System.out.println("Connexion reussie !");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur de connexion à la base de données : " + e.getMessage());
        }
        return connexion;
    }
}
