import java.util.ArrayList;

import java.util.Comparator;

public class Etudiant implements Statisticable, Comparable<Etudiant> {
    private int mat;
    private String nom;
    ArrayList<Notes> ListNotes = new ArrayList<Notes>();

    public Etudiant(int mat, String nom) {
        this.mat = mat;
        this.nom = nom;
    }

    void addNote(String nom, float note){
        Notes note1 = new Notes(nom,note);
        ListNotes.add(note1);
    }



    @Override
    public float getValue() {
        float sum = 0;
        for (Notes note : ListNotes) {
            sum += note.getValue();
        }
        if (ListNotes.size() > 0) {
            return sum / ListNotes.size();
        } else {
            return 0;
        }
    }



    @Override
    public int compareTo(Etudiant o) {
       return Float.compare(this.getValue(), o.getValue());
    }
    public String getNom() {
        return nom;
    }

    public int getMat() {
        return mat;
    }
}
