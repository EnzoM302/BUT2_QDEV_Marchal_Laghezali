import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Exception.NoteException;
import Exception.MatiereException;

import java.util.HashMap;

public class TestEtudiant {

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
}
