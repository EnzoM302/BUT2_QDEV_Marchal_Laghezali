import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Exception.NoteException;
import Exception.MatiereException;
import Exception.EtudiantException;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Classe de tests unitaires pour tester le tri des étudiants dans un groupe.
 * Utilise JUnit 5 pour vérifier que le tri alphabétique et anti-alphabétique fonctionne correctement.
 *
 * Scénario général :
 * - Crée un groupe avec trois étudiants.
 * - Teste le tri alphabétique (triAlpha) et anti-alphabétique (triAntiAlpha).
 * - Vérifie l'ordre attendu dans la représentation sous forme de chaîne (toString).
 */
public class TestTriGroupe {

    /**
     * Test du tri alphabétique des étudiants dans un groupe.
     *
     * Scénario :
     * - Trois étudiants ajoutés au groupe dans un ordre quelconque.
     * - Tri alphabétique effectué avec la méthode triAlpha().
     * - Vérifie que l'ordre final est correct (ordre alphabétique sur le nom).
     */
    @Test
    public void testTriGroupeTriAlpha() throws EtudiantException {
        Identite i = new Identite("laghezali", "nacime", "123");
        Identite i2 = new Identite("Marchal", "enzo", "456");
        Identite i3 = new Identite("toto", "lolo", "789");

        Resultat r = new Resultat();

        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Maths", 2.0);
        f.getMatiere().put("Francais", 3.0);

        Etudiant e1 = new Etudiant(i, r, f);
        Etudiant e2 = new Etudiant(i2, r, f);
        Etudiant e3 = new Etudiant(i3, r, f);

        Groupe g = new Groupe(f);
        g.addEtudiant(e1);
        g.addEtudiant(e2);
        g.addEtudiant(e3);

        g.triAlpha();

        assertEquals(
                "Nom : laghezali Prenom : nacime INP : 123/" +
                        "Nom : Marchal Prenom : enzo INP : 456/" +
                        "Nom : toto Prenom : lolo INP : 789/",
                g.toString(),
                "Le tri alphabétique n'a pas produit l'ordre attendu"
        );
    }

    /**
     * Test du tri anti-alphabétique des étudiants dans un groupe.
     *
     * Scénario :
     * - Trois étudiants ajoutés au groupe dans un ordre quelconque.
     * - Tri anti-alphabétique effectué avec la méthode triAntiAlpha().
     * - Vérifie que l'ordre final est correct (ordre inverse alphabétique sur le nom).
     */
    @Test
    public void testTriGroupeAntiAlpha() throws EtudiantException {
        Identite i = new Identite("laghezali", "nacime", "123");
        Identite i2 = new Identite("Marchal", "enzo", "456");
        Identite i3 = new Identite("toto", "lolo", "789");

        Resultat r = new Resultat();

        Formation f = new Formation("forma1", new HashMap<String, Double>());
        f.getMatiere().put("Maths", 2.0);
        f.getMatiere().put("Francais", 3.0);

        Etudiant e1 = new Etudiant(i, r, f);
        Etudiant e2 = new Etudiant(i2, r, f);
        Etudiant e3 = new Etudiant(i3, r, f);

        Groupe g = new Groupe(f);
        g.addEtudiant(e1);
        g.addEtudiant(e2);
        g.addEtudiant(e3);

        g.triAntiAlpha();

        assertEquals(
                "Nom : toto Prenom : lolo INP : 789/" +
                        "Nom : Marchal Prenom : enzo INP : 456/" +
                        "Nom : laghezali Prenom : nacime INP : 123/",
                g.toString(),
                "Le tri anti-alphabétique n'a pas produit l'ordre attendu"
        );
    }


}
