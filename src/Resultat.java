import java.util.ArrayList;
import java.util.HashMap;

/**
 * Représente le résultat d'un étudiant.
 * Chaque matière est associée à une liste de notes.
 */
public class Resultat {

    /**
     * Map des résultats : clé = nom de la matière, valeur = liste de notes pour cette matière
     */
    private HashMap<String, ArrayList<Double>> resultat;

    /**
     * Constructeur par défaut.
     * Initialise une map vide pour stocker les notes des différentes matières.
     */
    public Resultat() {
        this.resultat = new HashMap<>();
    }

    /**
     * Retourne la map des résultats.
     * La map associe chaque matière à une liste de notes.
     *
     * @return la map des résultats (matière -> liste de notes)
     */
    public HashMap<String, ArrayList<Double>> getResultat() {
        return resultat;
    }
}
