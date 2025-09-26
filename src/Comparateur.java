import java.util.Comparator;

/**
 * Comparateur d'étudiants basé sur le nom.
 * <p>
 * Cette classe implémente {@link Comparator} pour permettre de trier des objets {@link Etudiant}
 * en fonction de leur nom.
 * </p>
 * <p>
 * Le tri peut être effectué soit dans l'ordre alphabétique croissant, soit dans l'ordre alphabétique
 * décroissant, selon le paramètre {@code type} fourni lors de l'instanciation.
 * </p>
 */
public class Comparateur implements Comparator<Etudiant> {

    /**
     * Type de tri.
     * <ul>
     *     <li>{@code true} : tri alphabétique croissant (A → Z)</li>
     *     <li>{@code false} : tri alphabétique décroissant (Z → A)</li>
     * </ul>
     */
    private boolean type;

    /**
     * Constructeur du comparateur.
     *
     * @param type indique le type de tri : {@code true} pour croissant, {@code false} pour décroissant.
     */
    public Comparateur(boolean type){
        this.type = type;
    }

    /**
     * Compare deux étudiants en fonction de leur nom.
     *
     * @param e1 le premier étudiant à comparer
     * @param e2 le second étudiant à comparer
     * @return un entier négatif, zéro ou positif si le nom de {@code e1} est respectivement
     *         avant, égal ou après le nom de {@code e2} dans l'ordre choisi
     */
    @Override
    public int compare(Etudiant e1, Etudiant e2) {
        int res1 = e1.getIdentite().getNom().compareToIgnoreCase(e2.getIdentite().getNom());

        if(type){
            return res1; // Tri croissant
        } else {
            return -res1; // Tri décroissant
        }
    }
}
