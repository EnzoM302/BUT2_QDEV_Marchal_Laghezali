import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Exception.NoteException;
import Exception.MatiereException;
import Exception.EtudiantException;

import java.util.ArrayList;
import java.util.HashMap;


public class TestGroupe {

    //Test d'ajout d'un etudiant dans un groupe
    @Test
    public void testajoutEtudiant() throws EtudiantException {
        Identite i = new Identite("laghezali", "nacime", "123");
        Resultat r = new Resultat();
        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Maths",2.0);
        f.getMatiere().put("Francais",3.0);
        Etudiant e1 = new Etudiant(i, r, f);
        ArrayList<Etudiant> l = new ArrayList<Etudiant>();
        Groupe g = new Groupe (f.getId());
        g.addEtudiant(e1);
        assertEquals("Nom : laghezali Prenom : nacime INP : 123/", g.toString());
    }

    //test d'ajout d'un etudiant qui existe deja dans le groupe, sa releve donc une EtudiantException
    @Test
    public void testAjoutEtudiant() throws EtudiantException {
        Identite i = new Identite("laghezali", "nacime", "123");

        Resultat r = new Resultat();

        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Maths",2.0);
        f.getMatiere().put("Francais",3.0);

        Etudiant e1 = new Etudiant(i, r, f);
        Etudiant e2 = new Etudiant(i, r, f);

        ArrayList<Etudiant> l = new ArrayList<Etudiant>();
        Groupe g = new Groupe (f.getId());
        g.addEtudiant(e1);
        g.addEtudiant(e2);
        assertThrows(EtudiantException.class, () -> g.addEtudiant(e1));
    }

    //test simple supprimer etudiant d'un groupe
    @Test
    public void testSupprimerEtdiant () throws EtudiantException {
        Identite i = new Identite("laghezali", "nacime", "123");

        Resultat r = new Resultat();

        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Maths",2.0);
        f.getMatiere().put("Francais",3.0);

        Etudiant e1 = new Etudiant(i, r, f);

        ArrayList<Etudiant> l = new ArrayList<Etudiant>();
        Groupe g = new Groupe (f.getId());
        g.addEtudiant(e1);
        g.removeEtudiant(e1);
        assertEquals("", g.toString());
    }

    //test supprimer etudiant qui n'existe pas dans le groupe
    @Test
    public void testSupprimerEtdiantinexistent () throws EtudiantException {
        Identite i = new Identite("laghezali", "nacime", "123");
        Identite i2 = new Identite("Marchal", "enzo", "456");

        Resultat r = new Resultat();

        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Maths",2.0);
        f.getMatiere().put("Francais",3.0);

        Etudiant e1 = new Etudiant(i, r, f);
        Etudiant e2 = new Etudiant(i2, r, f);

        ArrayList<Etudiant> l = new ArrayList<Etudiant>();
        Groupe g = new Groupe (f.getId());
        g.addEtudiant(e1);
        assertThrows(EtudiantException.class, () -> g.removeEtudiant(e2));
    }


}
