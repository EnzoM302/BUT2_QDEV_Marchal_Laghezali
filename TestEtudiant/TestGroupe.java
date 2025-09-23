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

    @Test
    public void tes1() throws EtudiantException {
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

    @Test
    public void testAjoutEtudiant() {

    }
}
