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
        Groupe g = new Groupe (f);
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
        Groupe g = new Groupe (f);
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
        Groupe g = new Groupe (f);
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
        Groupe g = new Groupe (f);
        g.addEtudiant(e1);
        assertThrows(EtudiantException.class, () -> g.removeEtudiant(e2));
    }

    @Test
    public void testMoyenneGeneral(){
        try {
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

            assertEquals(9.75,g.moyenneGroupeGeneral(),"On devrait obtenir 9.75 de moyenne de groupe");



        }catch (MatiereException | NoteException e) {
           e.printStackTrace();
        } catch (EtudiantException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testMoyenneGroupeMatiere(){
        try {
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

            assertEquals(10.66, g.moyenneGroupeMatiere("Web"),2,"On devrait obtenir 10.66 de moyenne pour le Web");



        } catch (MatiereException e) {
            throw new RuntimeException(e);
        } catch (NoteException e) {
            throw new RuntimeException(e);
        } catch (EtudiantException e) {
            throw new RuntimeException(e);
        }
    }


}
