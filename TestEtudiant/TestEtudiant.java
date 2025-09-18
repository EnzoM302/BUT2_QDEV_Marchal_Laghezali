import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEtudiant {

    @Test
    public void TestCalculerMoyenne(){
        Identite i = new Identite("123", "laghezali", "nacime");
        Resultat r = new Resultat();
        Etudiant etu = new Etudiant(i, r);
        etu.ajouterNote("Mathematique", 12);
        etu.ajouterNote("Mathematique", 8);
        assertEquals(10, etu.calculerMoyenneMatiere("Mathematique"));
    }

    @Test
    public void testCalculerMoyenneMatiereInconnue() {
        Identite i = new Identite("123", "laghezali", "nacime");
        Resultat r = new Resultat();
        Etudiant etu = new Etudiant(i, r);
        assertEquals(0, etu.calculerMoyenneMatiere("Physique"));
    }

    @Test
    public void CalculerMoyenneGeneral(){
        Identite i = new Identite("123", "laghezali", "nacime");
        Resultat r = new Resultat();
        Etudiant etu = new Etudiant(i, r);

        etu.ajouterNote("Maths", 10.0);
        etu.ajouterNote("Maths", 14.0);
        etu.ajouterNote("Français", 16.0);
        assertEquals(14.0, etu.calculerMoyenneGeneral());
    }
}
