import java.util.HashMap;
import Exception.MatiereException;

/**
 * Représente une formation avec un identifiant et un ensemble de matières.
 * <p>
 * Chaque matière est associée à un coefficient. La classe permet d'ajouter ou
 * supprimer des matières et de récupérer les coefficients associés.
 * </p>
 */
public class Formation {

    /** Identifiant de la formation */
    private String id;

    /** Table des matières et leurs coefficients */
    private HashMap<String, Double> matirere;

    /**
     * Constructeur de la classe Formation.
     *
     * @param id identifiant de la formation
     * @param matirere table des matières avec leurs coefficients
     */
    public Formation(String id, HashMap<String, Double> matirere) {
        this.id = id;
        this.matirere = new HashMap<>(matirere);
    }

    /**
     * Ajoute une matière à la formation avec son coefficient.
     *
     * @param matiere le nom de la matière
     * @param coefficient le coefficient associé
     * @throws MatiereException si la matière existe déjà ou si le coefficient est négatif
     */
    public void ajouterMatiere(String matiere, double coefficient) throws MatiereException {
        if (this.matirere.containsKey(matiere)) {
            throw new MatiereException("La matière '" + matiere + "' existe déjà.");
        }
        if (coefficient < 0) {
            throw new MatiereException("La matière '" + matiere + "' a un coefficient négatif");
        }
        this.matirere.put(matiere, coefficient);
    }

    /**
     * Supprime une matière de la formation.
     *
     * @param matiere le nom de la matière à supprimer
     */
    public void supprimerMatiere(String matiere) {
        this.matirere.remove(matiere);
    }

    /**
     * Retourne le coefficient associé à une matière.
     *
     * @param mat le nom de la matière
     * @return le coefficient si la matière existe, sinon 0
     */
    public double getCoef(String mat) {
        if (matirere.containsKey(mat)) {
            return matirere.get(mat);
        }
        return 0;
    }

    /**
     * Retourne l'identifiant de la formation.
     *
     * @return l'identifiant
     */
    public String getId() {
        return id;
    }

    /**
     * Retourne la table des matières de la formation.
     *
     * @return un {@link HashMap} contenant les matières et leurs coefficients
     */
    public HashMap<String, Double> getMatiere() {
        return matirere;
    }
}
