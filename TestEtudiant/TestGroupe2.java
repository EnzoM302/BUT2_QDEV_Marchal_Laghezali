import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Exception.NoteException;
import Exception.MatiereException;
import Exception.EtudiantException;


/**
 * Classe de tests unitaires pour la classe Groupe.
 * Utilise JUnit 5 pour vérifier le calcul des moyennes générales et par matière
 * pour un groupe d'étudiants avec des notes prédéfinies.
 *
 * Tests inclus :
 * - calcul de la moyenne générale du groupe
 * - calcul de la moyenne par matière
 *
 * Avant chaque test, un groupe est initialisé avec 3 étudiants et leurs notes.
 */
public class TestGroupe2 {

    private Groupe g;

    /**
     * Initialisation avant chaque test.
     * Crée un groupe avec une formation contenant trois matières : Web, Reseau, Algo.
     * Trois étudiants sont créés et des notes sont ajoutées pour chaque matière.
     */
    @BeforeEach
    public void setUp() throws MatiereException, NoteException, EtudiantException {
        Identite i1 = new Identite("R", "Arthur", "123");
        Identite i2 = new Identite("S", "Astrid", "124");
        Identite i3 = new Identite("D", "David", "125");

        Resultat r1 = new Resultat();
        Resultat r2 = new Resultat();
        Resultat r3 = new Resultat();

        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Web", 1.0);
        f.getMatiere().put("Reseau", 1.0);
        f.getMatiere().put("Algo", 2.0);

        Etudiant e1 = new Etudiant(i1, r1, f);
        Etudiant e2 = new Etudiant(i2, r2, f);
        Etudiant e3 = new Etudiant(i3, r3, f);

        // Notes étudiant 1
        e1.ajouterNote("Web", 12.0);
        e1.ajouterNote("Web", 10.0);
        e1.ajouterNote("Web", 11.0);
        e1.ajouterNote("Web", 15.0);
        e1.ajouterNote("Reseau", 12.0);
        e1.ajouterNote("Reseau", 10.0);
        e1.ajouterNote("Reseau", 11.0);
        e1.ajouterNote("Algo", 9.0);
        e1.ajouterNote("Algo", 8.0);
        e1.ajouterNote("Algo", 10.0);

        // Notes étudiant 2
        e2.ajouterNote("Web", 9.0);
        e2.ajouterNote("Web", 8.0);
        e2.ajouterNote("Web", 10.0);
        e2.ajouterNote("Reseau", 9.0);
        e2.ajouterNote("Reseau", 8.0);
        e2.ajouterNote("Reseau", 10.0);
        e2.ajouterNote("Algo", 9.0);
        e2.ajouterNote("Algo", 8.0);
        e2.ajouterNote("Algo", 10.0);

        // Notes étudiant 3
        e3.ajouterNote("Web", 12.0);
        e3.ajouterNote("Web", 10.0);
        e3.ajouterNote("Web", 11.0);
        e3.ajouterNote("Reseau", 12.0);
        e3.ajouterNote("Reseau", 10.0);
        e3.ajouterNote("Reseau", 11.0);
        e3.ajouterNote("Algo", 9.0);
        e3.ajouterNote("Algo", 8.0);
        e3.ajouterNote("Algo", 10.0);

        g = new Groupe(f);
        g.addEtudiant(e1);
        g.addEtudiant(e2);
        g.addEtudiant(e3);
    }

    /**
     * Test du calcul de la moyenne générale du groupe.
     *
     * Scénario :
     * - Calculer la moyenne générale du groupe pour toutes les matières.
     * - Vérifier que la moyenne est égale à 9.75.
     */
    @Test
    public void testMoyenneGeneral() throws MatiereException {
        assertEquals(9.75, g.moyenneGroupeGeneral(), "On devrait obtenir 9.75 de moyenne de groupe");
    }

    /**
     * Test du calcul de la moyenne par matière pour le groupe.
     *
     * Scénario :
     * - Calculer la moyenne du groupe pour la matière "Web".
     * - Vérifier que la moyenne est environ 10.66 (tolérance 2).
     */
    @Test
    public void testMoyenneGroupeMatiere() throws MatiereException {
        assertEquals(10.66, g.moyenneGroupeMatiere("Web"), 2, "On devrait obtenir 10.66 de moyenne pour le Web");
    }

    @Test
    public void testTriParMerite(){
        g.triParMerite();
        assertEquals("Nom : R Prenom : Arthur INP : 123/"
                + "Nom : D Prenom : David INP : 125/"
                + "Nom : S Prenom : Astrid INP : 124/", g.toString());
    }
}
