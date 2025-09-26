import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import Exception.EtudiantException;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Classe de tests unitaires pour la classe Groupe.
 * Utilise JUnit 5 pour vérifier le comportement des méthodes
 * d'ajout et de suppression d'étudiants dans un groupe.
 *
 * Tests inclus :
 * - ajout d'un étudiant
 * - ajout d'un étudiant déjà présent (exception)
 * - suppression d'un étudiant
 * - suppression d'un étudiant non présent (exception)
 *
 * Chaque test crée un groupe avec une formation spécifique
 * et des étudiants, puis vérifie le résultat attendu ou l'exception.
 */
public class TestGroupe {

    /**
     * Test de l'ajout d'un étudiant dans un groupe.
     *
     * Scénario :
     * - Création d'un étudiant avec formation Maths/Francais.
     * - Ajout de l'étudiant dans le groupe.
     * - Vérification que le groupe contient l'étudiant avec la bonne représentation textuelle.
     *
     * @throws EtudiantException si l'ajout échoue (non attendu ici)
     */
    @Test
    public void testajoutEtudiant() throws EtudiantException {
        Identite i = new Identite("laghezali", "nacime", "123");
        Resultat r = new Resultat();
        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Maths",2.0);
        f.getMatiere().put("Francais",3.0);
        Etudiant e1 = new Etudiant(i, r, f);
        Groupe g = new Groupe(f);
        g.addEtudiant(e1);
        assertEquals("Nom : laghezali Prenom : nacime INP : 123/", g.toString());
    }

    /**
     * Test de l'ajout d'un étudiant déjà présent dans le groupe.
     *
     * Scénario :
     * - Création de deux étudiants identiques.
     * - Ajout du premier dans le groupe.
     * - Tentative d'ajout du second (identique) → doit lever EtudiantException.
     */
    @Test
    public void testAjoutEtudiantFaux() throws EtudiantException {
        Identite i = new Identite("laghezali", "nacime", "123");
        Resultat r = new Resultat();
        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Maths",2.0);
        f.getMatiere().put("Francais",3.0);

        Etudiant e1 = new Etudiant(i, r, f);
        Etudiant e2 = new Etudiant(i, r, f);

        Groupe g = new Groupe(f);
        g.addEtudiant(e1);
        assertThrows(EtudiantException.class, () -> g.addEtudiant(e2));
    }

    /**
     * Test de la suppression d'un étudiant existant dans le groupe.
     *
     * Scénario :
     * - Création d'un étudiant et ajout dans le groupe.
     * - Suppression de cet étudiant.
     * - Vérification que le groupe est vide.
     *
     * @throws EtudiantException si l'ajout ou la suppression échoue (non attendu ici)
     */
    @Test
    public void testSupprimerEtdiant() throws EtudiantException {
        Identite i = new Identite("laghezali", "nacime", "123");
        Resultat r = new Resultat();
        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Maths",2.0);
        f.getMatiere().put("Francais",3.0);

        Etudiant e1 = new Etudiant(i, r, f);
        Groupe g = new Groupe(f);
        g.addEtudiant(e1);
        g.removeEtudiant(e1);
        assertEquals("", g.toString());
    }

    /**
     * Test de la suppression d'un étudiant non présent dans le groupe.
     *
     * Scénario :
     * - Création de deux étudiants.
     * - Ajout du premier dans le groupe.
     * - Tentative de suppression du second → doit lever EtudiantException.
     *
     * @throws EtudiantException si l'ajout échoue (non attendu ici)
     */
    @Test
    public void testSupprimerEtdiantinexistent() throws EtudiantException {
        Identite i = new Identite("laghezali", "nacime", "123");
        Identite i2 = new Identite("Marchal", "enzo", "456");
        Resultat r = new Resultat();
        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Maths",2.0);
        f.getMatiere().put("Francais",3.0);

        Etudiant e1 = new Etudiant(i, r, f);
        Etudiant e2 = new Etudiant(i2, r, f);

        Groupe g = new Groupe(f);
        g.addEtudiant(e1);
        assertThrows(EtudiantException.class, () -> g.removeEtudiant(e2));
    }

}

