import java.util.HashMap;

public class Formation {
    private String id;
    private HashMap<String, Double> matirere;

    public Formation(String id, HashMap<String, Double> matirere) {
        this.id = id;
        this.matirere = new HashMap<>(matirere);
    }

    public void ajouterMatiere(String matiere, double coefficient) {
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

   
    public HashMap<String, Double> getMatiere() {
        return matirere;
    }

}
