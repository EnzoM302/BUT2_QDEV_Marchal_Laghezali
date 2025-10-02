import java.util.ArrayList;
import java.util.Objects;
import Exception.MatiereException;
import Exception.NoteException;

/**
 * Représente un étudiant inscrit dans une formation.
 * <p>
 * Chaque étudiant possède une identité, une formation et un ensemble de résultats.
 * Cette classe permet d'ajouter des notes, de calculer la moyenne d'une matière ou
 * la moyenne générale, et de comparer des étudiants entre eux selon leurs moyennes générales.
 * </p>
 */
public class Etudiant implements Comparable<Etudiant> {

    /** Identité de l'étudiant (nom, prénom, NIP). */
    private Identite identite;

    /** Formation suivie par l'étudiant. */
    private Formation formation;

    /** Résultats de l'étudiant, stockant les notes par matière. */
    private Resultat resultat;

    /**
     * Constructeur de la classe Etudiant.
     *
     * @param identite l'identité de l'étudiant
     * @param resultat l'ensemble des résultats de l'étudiant
     * @param formation la formation suivie par l'étudiant
     */
    public Etudiant(Identite identite, Resultat resultat, Formation formation) {
        this.identite = identite;
        this.formation = formation;
        this.resultat = resultat;
    }

    /**
     * Retourne l'identité de l'étudiant.
     *
     * @return l'objet {@link Identite} de l'étudiant
     */
    public Identite getIdentite() {
        return identite;
    }

    /**
     * Retourne les résultats de l'étudiant.
     *
     * @return l'objet {@link Resultat} de l'étudiant
     */
    public Resultat getResultat() {
        return resultat;
    }

    /**
     * Retourne la formation suivie par l'étudiant.
     *
     * @return l'objet {@link Formation} de l'étudiant
     */
    public Formation getFormation() {
        return formation;
    }

    /**
     * Ajoute une note pour une matière donnée.
     *
     * @param matiere le nom de la matière
     * @param note la note à ajouter (entre 0 et 20)
     * @throws MatiereException si la matière n'existe pas dans la formation
     * @throws NoteException si la note n'est pas comprise entre 0 et 20
     */
    public void ajouterNote(String matiere, Double note) throws MatiereException, NoteException {
        if (note < 0 || note > 20) {
            throw new NoteException("La note n'est pas comprise entre 0 et 20");
        }
        if (!formation.getMatiere().containsKey(matiere)) {
            throw new MatiereException("La matière n'est pas dans la formation de l'etudiant");
        }
        resultat.getResultat().putIfAbsent(matiere, new ArrayList<>());
        resultat.getResultat().get(matiere).add(note);
    }

    /**
     * Calcule la moyenne de l'étudiant pour une matière donnée.
     *
     * @param matiere le nom de la matière
     * @return la moyenne des notes pour cette matière
     * @throws MatiereException si la matière n'existe pas ou n'a pas de notes
     */
    public Double calculerMoyenneMatiere(String matiere) throws MatiereException {
        if (!resultat.getResultat().containsKey(matiere) || resultat.getResultat().get(matiere).isEmpty()) {
            throw new MatiereException("La matière n'est pas dans la formation de l'étudiant ou n'a pas de notes");
        }

        Double somme = 0.0;
        for (Double note : resultat.getResultat().get(matiere)) {
            somme += note;
        }
        return somme / resultat.getResultat().get(matiere).size();
    }

    /**
     * Calcule la moyenne générale de l'étudiant en prenant en compte les coefficients
     * de chaque matière dans la formation.
     *
     * @param formation la formation pour laquelle calculer la moyenne générale
     * @return la moyenne générale pondérée
     * @throws MatiereException si une matière de la formation n'a pas de notes
     */
    public double calculerMoyenneGenerale(Formation formation) throws MatiereException {
        Double moyenneGenerale = 0.0;
        Double coefficientTotal = 0.0;

        for (String matiere : formation.getMatiere().keySet()) {
            if (formation.getMatiere().containsKey(matiere)) {
                moyenneGenerale += calculerMoyenneMatiere(matiere) * formation.getCoef(matiere);
                coefficientTotal += formation.getCoef(matiere);
            }
        }
        return moyenneGenerale / coefficientTotal;
    }

    /**
     * Vérifie l'égalité de deux étudiants.
     * <p>
     * Deux étudiants sont égaux si leur identité, leur formation et leurs résultats sont identiques.
     * </p>
     *
     * @param o l'objet à comparer
     * @return {@code true} si les étudiants sont égaux, {@code false} sinon
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return Objects.equals(identite, etudiant.identite)
                && Objects.equals(formation, etudiant.formation)
                && Objects.equals(resultat, etudiant.resultat);
    }

    /**
     * Compare deux étudiants selon leur moyenne générale.
     *
     * @param o l'étudiant à comparer
     * @return -1 si {@code o} a une moyenne supérieure, 1 si {@code o} a une moyenne inférieure, 0 si égale
     */
    @Override public int compareTo(Etudiant o) {
        try {
            if (o.calculerMoyenneGenerale(formation) > this.calculerMoyenneGenerale(formation)) {
                return 1;
            } else if (o.calculerMoyenneGenerale(formation) < this.calculerMoyenneGenerale(formation)) {
                return -1;
            }
        } catch (MatiereException e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }

    /**
     * Retourne une représentation textuelle de l'étudiant.
     *
     * @return chaîne au format "Nom : <nom> Prenom : <prenom> INP : <nip>"
     */
    @Override
    public String toString() {
        return "Nom : " + identite.getNom() +
                " Prenom : " + identite.getPrenom() +
                " INP : " + identite.getNip();
    }
}
