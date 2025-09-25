import java.util.Comparator;

public class Comparateur implements Comparator<Etudiant> {

    private boolean type;

    public Comparateur(boolean type){
        this.type = type;
    }
    @Override
    public int compare(Etudiant e1, Etudiant e2) {
        int res1 = e1.getIdentite().getNom().compareToIgnoreCase(e2.getIdentite().getNom());

        if(type){
            return res1;
        }else {
            return -res1;
        }
    }


}
