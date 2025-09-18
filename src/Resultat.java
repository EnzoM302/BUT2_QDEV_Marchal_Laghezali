import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Resultat {
    private HashMap<String, ArrayList<Double>> resultat;

    public Resultat() {
        this.resultat = new HashMap<>();
    }

    public HashMap<String, ArrayList<Double>> getResultat() {
        return resultat;
    }

}
