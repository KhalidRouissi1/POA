import java.util.Comparator;

public class Notes implements Statisticable, Comparable<Notes> {
    private String nom;
    private float note;

    public Notes(String nom, float note) {
        this.nom = nom;
        this.note = note;
    }

    @Override
    public float getValue() {
        return this.note;
    }

    @Override
    public int compareTo(Notes o) {
        return Float.compare(this.getValue(), o.getValue());
    }

}
