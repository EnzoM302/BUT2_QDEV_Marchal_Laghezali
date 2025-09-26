import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Exception.NoteException;
import Exception.MatiereException;

import java.util.HashMap;

/**
 * Classe de tests unitaires pour la classe Etudiant.
 * Utilise JUnit 5 pour vérifier le comportement des méthodes
 * de calcul de moyenne et la gestion des exceptions.
 *
 * Tests inclus :
 * - calculerMoyenneMatiere()
 * - calculerMoyenneGenerale()
 * - gestion des matières inconnues ou sans notes
 *
 * Chaque test crée un étudiant avec une formation spécifique
 * et des notes, puis vérifie le résultat attendu ou l'exception.
 */
public class TestEtudiant {

    /**
     * Test de calcul de la moyenne d'une matière existante avec plusieurs notes.
     *
     * Scénario :
     * - Création d'un étudiant avec la formation Maths/Francais.
     * - Ajout de deux notes en Maths : 12 et 8.
     * - Vérification que la moyenne de Maths est 10.
     *
     * Exception : NoteException ou MatiereException si erreur.
     */
    @Test
    public void TestCalculerMoyenne() throws NoteException, MatiereException {
        Identite i = new Identite("123", "laghezali", "nacime");
        Resultat r = new Resultat();
        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Maths",2.0);
        f.getMatiere().put("Francais",3.0);
        Etudiant etu = new Etudiant(i, r, f);
        etu.ajouterNote("Maths", 12.0);
        etu.ajouterNote("Maths", 8.0);
        assertEquals(10, etu.calculerMoyenneMatiere("Maths"));
    }

    /**
     * Test du comportement lorsque la matière demandée est inconnue.
     *
     * Scénario :
     * - Création d'un étudiant avec la formation Maths/Francais.
     * - Appel de calculerMoyenneMatiere pour une matière "Physique" absente.
     * - Vérification que MatiereException est levée.
     */
    @Test
    public void testCalculerMoyenneMatiereInconnue() throws MatiereException {
        Identite i = new Identite("123", "laghezali", "nacime");
        Resultat r = new Resultat();
        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Maths",2.0);
        f.getMatiere().put("Francais",3.0);
        Etudiant etu = new Etudiant(i, r, f);
        assertThrows(MatiereException.class, () -> etu.calculerMoyenneMatiere("Physique"));
    }

    /**
     * Test du comportement lorsque la matière demandée n'a aucune note.
     *
     * Scénario :
     * - Création d'un étudiant avec la formation Maths/Francais.
     * - Ajout d'une note seulement pour Maths.
     * - Appel de calculerMoyenneMatiere pour "Physique" (pas de note).
     * - Vérification que MatiereException est levée.
     */
    @Test
    public void testCalculerMoyenneMatiereSansNote() throws MatiereException, NoteException {
        Identite i = new Identite("123", "laghezali", "nacime");
        Resultat r = new Resultat();
        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Maths",2.0);
        f.getMatiere().put("Francais",3.0);
        Etudiant etu = new Etudiant(i, r, f);
        etu.ajouterNote("Maths", 12.0);
        assertThrows(MatiereException.class, () -> etu.calculerMoyenneMatiere("Physique"));
    }

    /**
     * Test du calcul de la moyenne générale pour un étudiant ayant toutes les matières notées.
     *
     * Scénario :
     * - Création d'un étudiant avec formation Maths/Francais.
     * - Ajout des notes suivantes :
     *      Maths : 10, 14
     *      Francais : 16
     * - Vérification que la moyenne générale est 14.4
     */
    @Test
    public void CalculerMoyenneGeneral() throws NoteException, MatiereException {
        Identite i = new Identite("123", "laghezali", "nacime");
        Resultat r = new Resultat();
        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Maths",2.0);
        f.getMatiere().put("Francais",3.0);
        Etudiant etu = new Etudiant(i, r, f);

        etu.ajouterNote("Maths", 10.0);
        etu.ajouterNote("Maths", 14.0);
        etu.ajouterNote("Francais", 16.0);
        assertEquals(14.4, etu.calculerMoyenneGenerale(f));
    }

    /**
     * Test du calcul de la moyenne générale lorsque l'étudiant n'a pas de notes
     * pour toutes les matières de la formation.
     *
     * Scénario :
     * - Création d'un étudiant avec formation Maths/Francais.
     * - Ajout de notes uniquement pour Maths.
     * - Appel de calculerMoyenneGenerale
     * - Vérification que MatiereException est levée pour Francais (pas de note).
     */
    @Test
    public void CalculerMoyenneGeneralSansNote() throws MatiereException, NoteException {
        Identite i = new Identite("123", "laghezali", "nacime");
        Resultat r = new Resultat();
        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Maths",2.0);
        f.getMatiere().put("Francais",3.0);
        Etudiant etu = new Etudiant(i, r, f);

        etu.ajouterNote("Maths", 10.0);
        etu.ajouterNote("Maths", 14.0);

        assertThrows(MatiereException.class, () -> etu.calculerMoyenneGenerale(f));
    }
}
