import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import Exception.NoteException;
import Exception.MatiereException;

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
        assertEquals(0, etu.calculerMoyenneMatiere("Physique"));
    }

    @Test
    public void CalculerMoyenneGeneral() throws NoteException, MatiereException {
        Identite i = new Identite("123", "laghezali", "nacime");
        Resultat r = new Resultat();
        Etudiant etu = new Etudiant(i, r);

        etu.ajouterNote("Maths", 10.0);
        etu.ajouterNote("Maths", 14.0);
        etu.ajouterNote("Français", 16.0);
        assertEquals(14.0, etu.calculerMoyenneGeneral());
    }
}
