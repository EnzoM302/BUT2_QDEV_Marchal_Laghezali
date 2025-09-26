import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Exception.NoteException;
import Exception.MatiereException;
import Exception.EtudiantException;

import java.util.ArrayList;
import java.util.HashMap;

public class TestTriMerite {

    @Test
    public void testTriMerite() throws NoteException, MatiereException, EtudiantException {
        Identite i = new Identite("R", "Arthur", "123");
        Identite i2 = new Identite("S", "Astrid", "124");
        Identite i3 = new Identite("D", "David", "125");

        Resultat r = new Resultat();
        Resultat r2 = new Resultat();
        Resultat r3 = new Resultat();

        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Web", 1.0);
        f.getMatiere().put("Reseau", 1.0);
        f.getMatiere().put("Algo", 2.0);

        Etudiant e1 = new Etudiant(i, r, f);
        Etudiant e2 = new Etudiant(i2, r2, f);
        Etudiant e3 = new Etudiant(i3, r3, f);

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

        e2.ajouterNote("Web", 9.0);
        e2.ajouterNote("Web", 8.0);
        e2.ajouterNote("Web", 10.0);
        e2.ajouterNote("Reseau", 9.0);
        e2.ajouterNote("Reseau", 8.0);
        e2.ajouterNote("Reseau", 10.0);
        e2.ajouterNote("Algo", 9.0);
        e2.ajouterNote("Algo", 8.0);
        e2.ajouterNote("Algo", 10.0);

        e3.ajouterNote("Web", 12.0);
        e3.ajouterNote("Web", 10.0);
        e3.ajouterNote("Web", 11.0);
        e3.ajouterNote("Reseau", 12.0);
        e3.ajouterNote("Reseau", 10.0);
        e3.ajouterNote("Reseau", 11.0);
        e3.ajouterNote("Algo", 9.0);
        e3.ajouterNote("Algo", 8.0);
        e3.ajouterNote("Algo", 10.0);

        Groupe g =  new Groupe (f);
        g.addEtudiant(e1);
        g.addEtudiant(e2);
        g.addEtudiant(e3);

        g.triParMerite();
        
        assertEquals("Nom : R Prenom : Arthur INP : 123/Nom : D Prenom : David INP : 125/Nom : S Prenom : Astrid INP : 124/", g.toString());
    }

}
