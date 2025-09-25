import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Exception.NoteException;
import Exception.MatiereException;
import Exception.EtudiantException;

import java.util.ArrayList;
import java.util.HashMap;


public class TestTriGroupe {
    @Test
    public void testTriGroupeTriAlpha() throws EtudiantException {
        Identite i = new Identite("laghezali", "nacime", "123");
        Identite i2 = new Identite("Marchal", "enzo", "456");
        Identite i3 = new Identite("toto", "lolo", "789");

        Resultat r = new Resultat();

        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Maths",2.0);
        f.getMatiere().put("Francais",3.0);

        Etudiant e1 = new Etudiant(i, r, f);
        Etudiant e2 = new Etudiant(i2, r, f);
        Etudiant e3 = new Etudiant(i3, r, f);

        ArrayList<Etudiant> l = new ArrayList<Etudiant>();
        Groupe g = new Groupe (f.getId());
        g.addEtudiant(e1);
        g.addEtudiant(e2);
        g.addEtudiant(e3);

        g.triAlpha();

        assertEquals("Nom : laghezali Prenom : nacime INP : 123/Nom : Marchal Prenom : enzo INP : 456/Nom : toto Prenom : lolo INP : 789/", g.toString());
    }

    @Test
    public void testTriGroupeAntiAlpha() throws EtudiantException {
        Identite i = new Identite("laghezali", "nacime", "123");
        Identite i2 = new Identite("Marchal", "enzo", "456");
        Identite i3 = new Identite("toto", "lolo", "789");

        Resultat r = new Resultat();

        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Maths",2.0);
        f.getMatiere().put("Francais",3.0);

        Etudiant e1 = new Etudiant(i, r, f);
        Etudiant e2 = new Etudiant(i2, r, f);
        Etudiant e3 = new Etudiant(i3, r, f);

        ArrayList<Etudiant> l = new ArrayList<Etudiant>();
        Groupe g = new Groupe (f.getId());
        g.addEtudiant(e1);
        g.addEtudiant(e2);
        g.addEtudiant(e3);

        g.triAntiAlpha();

        assertEquals("Nom : toto Prenom : lolo INP : 789/Nom : Marchal Prenom : enzo INP : 456/Nom : laghezali Prenom : nacime INP : 123/", g.toString());
    }
}
