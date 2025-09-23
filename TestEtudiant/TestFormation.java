import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import Exception.NoteException;
import Exception.MatiereException;
import static org.junit.jupiter.api.Assertions.*;


public class TestFormation {
    private Formation formation;

    @BeforeEach
    void setUp() {
        HashMap<String, Double> matieres = new HashMap<>();
        matieres.put("Maths", 2.0);
        matieres.put("Info", 3.0);
        formation = new Formation("F1", matieres);
    }

    @Test
    void testAjouterMatiere() {
        try{
            formation.ajouterMatiere("Anglais", 1.5);
            assertTrue(formation.getMatiere().containsKey("Anglais"));
            assertEquals(1.5, formation.getCoef("Anglais"), 0.001);
        }catch(MatiereException e){
            e.printStackTrace();
        }

    }

    @Test
    void testAjouterMatiereExistante() {
        // "Maths" existe déjà dans la formation
        assertThrows(MatiereException.class, () -> {
            formation.ajouterMatiere("Maths", 2.5);
        });
    }



    @Test
    void testSupprimerMatiere() {
        formation.supprimerMatiere("Maths");
        assertFalse(formation.getMatiere().containsKey("Maths"));
        assertEquals(0.0, formation.getCoef("Maths"), 0.001);
    }

    @Test
    void testGetCoefMatiereExistante() {
        assertEquals(2.0, formation.getCoef("Maths"), 0.001);
        assertEquals(3.0, formation.getCoef("Info"), 0.001);
    }

    @Test
    void testGetCoefMatiereInexistante() {
        assertEquals(0.0, formation.getCoef("Histoire"), 0.001);
    }

    @Test
    void testGetMatiereImmutableReference() {
        HashMap<String, Double> matieres = formation.getMatiere();
        matieres.put("Test", 5.0);

        assertTrue(formation.getMatiere().containsKey("Test"));
    }
}

