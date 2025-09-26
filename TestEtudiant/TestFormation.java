import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import Exception.NoteException;
import Exception.MatiereException;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Classe de tests unitaires pour la classe Formation.
 * Utilise JUnit 5 pour vérifier le comportement des méthodes
 * de gestion des matières et de leurs coefficients.
 *
 * Tests inclus :
 * - ajout d'une matière
 * - ajout d'une matière existante (exception)
 * - ajout d'une matière avec coefficient négatif (exception)
 * - suppression d'une matière
 * - récupération du coefficient d'une matière existante et inexistante
 * - vérification de la référence immuable des matières
 *
 * Chaque test crée une formation avec des matières initiales,
 * puis effectue les opérations et vérifie les résultats attendus.
 */
public class TestFormation {

    private Formation formation;

    /**
     * Initialisation avant chaque test.
     * Crée une formation avec deux matières initiales : Maths et Info.
     */
    @BeforeEach
    void setUp() {
        HashMap<String, Double> matieres = new HashMap<>();
        matieres.put("Maths", 2.0);
        matieres.put("Info", 3.0);
        formation = new Formation("F1", matieres);
    }

    /**
     * Test de l'ajout d'une nouvelle matière avec coefficient positif.
     *
     * Scénario :
     * - Ajouter "Anglais" avec coefficient 1.5.
     * - Vérifier que la matière est présente.
     * - Vérifier que le coefficient est correct.
     */
    @Test
    void testAjouterMatiere() {
        try {
            formation.ajouterMatiere("Anglais", 1.5);
            assertTrue(formation.getMatiere().containsKey("Anglais"));
            assertEquals(1.5, formation.getCoef("Anglais"), 0.001);
        } catch (MatiereException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test de l'ajout d'une matière déjà existante.
     *
     * Scénario :
     * - Tenter d'ajouter "Maths" à nouveau.
     * - Vérifier que MatiereException est levée.
     */
    @Test
    void testAjouterMatiereExistante() {
        assertThrows(MatiereException.class, () -> {
            formation.ajouterMatiere("Maths", 2.5);
        });
    }

    /**
     * Test de l'ajout d'une matière avec un coefficient négatif.
     *
     * Scénario :
     * - Tenter d'ajouter "Maths" avec coefficient -2.5.
     * - Vérifier que MatiereException est levée.
     */
    @Test
    void testAjouterMatiereCoeffNegatif() {
        assertThrows(MatiereException.class, () -> {
            formation.ajouterMatiere("Maths", -2.5);
        });
    }

    /**
     * Test de suppression d'une matière existante.
     *
     * Scénario :
     * - Supprimer "Maths".
     * - Vérifier que la matière n'est plus présente.
     * - Vérifier que le coefficient retourne 0.0.
     */
    @Test
    void testSupprimerMatiere() {
        formation.supprimerMatiere("Maths");
        assertFalse(formation.getMatiere().containsKey("Maths"));
        assertEquals(0.0, formation.getCoef("Maths"), 0.001);
    }

    /**
     * Test de récupération du coefficient d'une matière existante.
     *
     * Scénario :
     * - Vérifier que "Maths" retourne 2.0.
     * - Vérifier que "Info" retourne 3.0.
     */
    @Test
    void testGetCoefMatiereExistante() {
        assertEquals(2.0, formation.getCoef("Maths"), 0.001);
        assertEquals(3.0, formation.getCoef("Info"), 0.001);
    }

    /**
     * Test de récupération du coefficient d'une matière inexistante.
     *
     * Scénario :
     * - Vérifier que "Histoire" retourne 0.0.
     */
    @Test
    void testGetCoefMatiereInexistante() {
        assertEquals(0.0, formation.getCoef("Histoire"), 0.001);
    }

    /**
     * Test de la référence immuable des matières.
     *
     * Scénario :
     * - Récupérer la HashMap des matières.
     * - Ajouter une nouvelle entrée dans la copie récupérée.
     * - Vérifier que la matière est effectivement ajoutée dans la formation.
     *
     * Note : ce test montre que getMatiere() retourne une référence mutable,
     * ce qui peut être amélioré si on veut une vraie immutabilité.
     */
    @Test
    void testGetMatiereImmutableReference() {
        HashMap<String, Double> matieres = formation.getMatiere();
        matieres.put("Test", 5.0);

        assertTrue(formation.getMatiere().containsKey("Test"));
    }
}


