import java.util.Comparator;

class NotesComparator implements Comparator<Notes> {
    @Override
    public int compare(Notes n1, Notes n2) {
        return Float.compare(n1.getValue(), n2.getValue());
    }
}
