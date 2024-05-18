package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.connexion.Connexion;

public class EtudiantM {

    Connection connection = Connexion.getCn();

    public boolean create(Etudiant etudiant) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO etudiant (nom, prenom, sexe, filiere) VALUES (?, ?, ?, ?)");
            statement.setString(1, etudiant.getNom());
            statement.setString(2, etudiant.getPrenom());
            statement.setString(3, etudiant.getSexe());
            statement.setString(4, etudiant.getFiliere());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Etudiant etudiant) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM etudiant WHERE id = ?");
            statement.setInt(1, etudiant.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Etudiant etudiant) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE etudiant SET nom = ?, prenom = ?, sexe = ?, filiere = ? WHERE id = ?");
            statement.setString(1, etudiant.getNom());
            statement.setString(2, etudiant.getPrenom());
            statement.setString(3, etudiant.getSexe());
            statement.setString(4, etudiant.getFiliere());
            statement.setInt(5, etudiant.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Etudiant findById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM etudiant WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Etudiant(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getString("prenom"),
                        resultSet.getString("sexe"), resultSet.getString("filiere"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM etudiant");
            while (resultSet.next()) {
                etudiants.add(new Etudiant(resultSet.getInt("id"), resultSet.getString("nom"),
                        resultSet.getString("prenom"), resultSet.getString("sexe"), resultSet.getString("filiere")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiants;
    }

}
