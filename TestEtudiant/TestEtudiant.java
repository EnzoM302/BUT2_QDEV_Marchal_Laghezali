import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import Exception.NoteException;
import Exception.MatiereException;

import java.util.HashMap;

public class TestEtudiant {

    @Test
    public void TestCalculerMoyenne() throws NoteException, MatiereException {
            Identite i = new Identite("123", "laghezali", "nacime");
            Resultat r = new Resultat();
            Etudiant etu = new Etudiant(i, r);
            etu.ajouterNote("Mathematique", 12.0);
            etu.ajouterNote("Mathematique", 8.0);
            assertEquals(10, etu.calculerMoyenneMatiere("Mathematique"));
    }

    @Test
    public void testCalculerMoyenneMatiereInconnue() throws MatiereException {
        Identite i = new Identite("123", "laghezali", "nacime");
        Resultat r = new Resultat();
        Etudiant etu = new Etudiant(i, r);
        assertEquals(0.0, etu.calculerMoyenneMatiere("Physique"));
    }

    @Test
    public void CalculerMoyenneGeneral() throws NoteException, MatiereException {
        Identite i = new Identite("123", "laghezali", "nacime");
        Resultat r = new Resultat();
        Etudiant etu = new Etudiant(i, r);
        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Maths",2.0);
        f.getMatiere().put("Francais",3.0);

        etu.ajouterNote("Maths", 10.0);
        etu.ajouterNote("Maths", 14.0);
        etu.ajouterNote("Francais", 16.0);
        assertEquals(14.0, etu.calculerMoyenneGenerale(f));
    }
}
