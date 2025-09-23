import java.util.HashMap;
import Exception.MatiereException;

public class Formation {
    private String id;
    private HashMap<String, Double> matirere;

    public Formation(String id, HashMap<String, Double> matirere) {
        this.id = id;
        this.matirere = new HashMap<>(matirere);
    }

    public void ajouterMatiere(String matiere, double coefficient) throws MatiereException {
        if (this.matirere.containsKey(matiere)) {
            throw new MatiereException("La matière '" + matiere + "' existe déjà.");
        }
        this.matirere.put(matiere, coefficient);
    }

    public void supprimerMatiere(String matiere) {
        this.matirere.remove(matiere);
    }

    public double getCoef(String mat) {
        if (matirere.containsKey(mat)) {
            return matirere.get(mat).doubleValue();
        }
        return 0;
    }

    public String getId() {
        return id;
    }


    public HashMap<String, Double> getMatiere() {
        return matirere;
    }

}
