import java.util.ArrayList;
import java.util.Collections;

public class Stats {

    public static float bestNoteEtud(Etudiant e1) {

        return(Collections.max(e1.ListNotes).getValue());
    }

    public static float worstNoteEtud(Etudiant e1) {
        return(Collections.min(e1.ListNotes).getValue());
    }


    public static void worstNoteGroupe(ArrayList<Etudiant> e) {
        Etudiant min = e.get(0);
        for (Etudiant etudiant : e) {
            Etudiant minNote = etudiant;
            if (minNote.getValue() < min.getValue()) {
                min = minNote;
            }
        }

        System.out.println("Worst student is "+ min.getNom());
    }

    public static void bestNoteGroup(ArrayList<Etudiant> e) {
        Etudiant max = e.get(0);
        for (Etudiant etudiant : e) {
            Etudiant maxNote = etudiant;
            if (maxNote.getValue() > max.getValue()) {
                max = maxNote;
            }
        }
        System.out.println("Best student is "+ max.getNom());
    }


    public static float groupMoy(ArrayList<Etudiant> e) {
        float total = 0;
        for (Etudiant etudiant : e) {
            total += etudiant.getValue();
        }
        return e.isEmpty() ? 0 : total / e.size();
    }

}