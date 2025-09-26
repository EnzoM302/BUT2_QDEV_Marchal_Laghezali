import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Exception.*;

/**
 * Représente un groupe d'étudiants appartenant à une formation spécifique.
 * <p>
 * La classe permet d'ajouter et de retirer des étudiants, calculer les moyennes
 * du groupe pour chaque matière ou en général, et trier le groupe selon différents critères.
 * </p>
 */
public class Groupe {

    /** Liste des étudiants du groupe */
    private ArrayList<Etudiant> etudiants;

    /** Formation associée au groupe */
    private Formation formation;

    /**
     * Constructeur de la classe Groupe.
     *
     * @param idFormation la formation associée au groupe
     */
    public Groupe(Formation idFormation) {
        etudiants = new ArrayList<Etudiant>();
        this.formation = idFormation;
    }

    /**
     * Retourne la liste des étudiants du groupe.
     *
     * @return la liste des étudiants
     */
    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }

    /**
     * Ajoute un étudiant au groupe.
     *
     * @param etudiant l'étudiant à ajouter
     * @throws EtudiantException si l'étudiant existe déjà dans le groupe ou
     *                           si l'étudiant n'appartient pas à la même formation
     */
    public void addEtudiant(Etudiant etudiant) throws EtudiantException {
        if (!etudiants.contains(etudiant) && etudiant.getFormation().getId().equals(formation.getId())) {
            etudiants.add(etudiant);
        } else {
            throw new EtudiantException("L'étudiant existe déjà");
        }
    }

    /**
     * Supprime un étudiant du groupe.
     *
     * @param etudiant l'étudiant à supprimer
     * @throws EtudiantException si l'étudiant n'existe pas dans le groupe
     */
    public void removeEtudiant(Etudiant etudiant) throws EtudiantException {
        if (etudiants.contains(etudiant)) {
            etudiants.remove(etudiant);
        } else {
            throw new EtudiantException("L'étudiant n'existe pas");
        }
    }

    /**
     * Calcule la moyenne du groupe pour une matière donnée.
     *
     * @param matiere le nom de la matière
     * @return la moyenne du groupe pour cette matière
     * @throws MatiereException si la matière n'existe pas pour un étudiant
     */
    public double moyenneGroupeMatiere(String matiere) throws MatiereException {
        double moyenne = 0;
        for (Etudiant etudiant : etudiants) {
            moyenne += etudiant.calculerMoyenneMatiere(matiere);
        }
        return moyenne / etudiants.size();
    }

    /**
     * Calcule la moyenne générale du groupe sur toutes les matières de la formation.
     *
     * @return la moyenne générale du groupe
     * @throws MatiereException si une matière est absente pour un étudiant
     */
    public double moyenneGroupeGeneral() throws MatiereException {
        double moyenne = 0;
        for (Etudiant etudiant : etudiants) {
            moyenne += etudiant.calculerMoyenneGenerale(formation);
        }
        return moyenne / etudiants.size();
    }

    /**
     * Retourne une représentation textuelle du groupe.
     *
     * @return chaîne de caractères contenant les informations des étudiants
     */
    @Override
    public String toString() {
        String s = "";
        for (Etudiant etudiant : etudiants) {
            s += etudiant.toString() + "/";
        }
        return s;
    }

    /**
     * Trie les étudiants du groupe par ordre alphabétique croissant des noms.
     */
    public void triAlpha() {
        Collections.sort(etudiants, new Comparateur(true));
    }

    /**
     * Trie les étudiants du groupe par ordre alphabétique décroissant des noms.
     */
    public void triAntiAlpha() {
        Collections.sort(etudiants, new Comparateur(false));
    }

    /**
     * Trie les étudiants du groupe par mérite (moyenne générale décroissante).
     */
    public void triParMerite() {
        Collections.sort(etudiants);
    }
}

