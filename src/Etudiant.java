import java.util.ArrayList;
import java.util.Objects;

import Exception.MatiereException;
import Exception.NoteException;

public class Etudiant implements Comparable<Etudiant>{
    private Identite identite;
    private Formation formation;
    private Resultat resultat;

    public Etudiant(Identite identite, Resultat resultat,  Formation formation) {
        this.identite = identite;
        this.formation = formation;
        this.resultat = resultat;
    }
    public Identite getIdentite() {
        return identite;
    }

    public Resultat getResultat() {
        return resultat;
    }

    public Formation getFormation() {
        return formation;
    }

    public void ajouterNote(String matiere, Double note) throws MatiereException, NoteException {
        if ((note >= 0 || note <= 20)) {
            if (formation.getMatiere().containsKey(matiere)){

                resultat.getResultat().putIfAbsent(matiere, new ArrayList<>());

                resultat.getResultat().get(matiere).add(note);
            }else {
                throw new MatiereException("La matière n'est pas dans la formation de l'etudiant");
            }
        }else{
            throw new NoteException("La note n'est pas comprise entre 0 et 20");
        }
    }

    public Double calculerMoyenneMatiere(String matiere) throws MatiereException {
        Double moyenneMatiere = 0.0;

        if (resultat.getResultat().containsKey(matiere)){
            ArrayList<Double> notes = resultat.getResultat().get(matiere);
            for (Double note : notes) {
                moyenneMatiere += note;
            }
        }else{
            throw new MatiereException("La matière n'est pas dans la formation de l'etudiant");
        }
        return moyenneMatiere/resultat.getResultat().get(matiere).size();

    }

    public double calculerMoyenneGenerale(Formation formation) throws MatiereException {
        Double moyenneGenerale = 0.0;
        Double coefficient = 0.0;
        for (String matiere : resultat.getResultat().keySet()) {
                if (formation.getMatiere().containsKey(matiere)){

                    moyenneGenerale += calculerMoyenneMatiere(matiere)*formation.getCoef(matiere);
                    coefficient += formation.getCoef(matiere);
                }

        }
        return moyenneGenerale/coefficient;

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return Objects.equals(identite, etudiant.identite) && Objects.equals(formation, etudiant.formation) && Objects.equals(resultat, etudiant.resultat);
    }

    @Override
    public int compareTo(Etudiant o) {
        try {
            if (o.calculerMoyenneGenerale(formation) > this.calculerMoyenneGenerale(formation)){
                return 1;
            }else if (o.calculerMoyenneGenerale(formation) > this.calculerMoyenneGenerale(formation)){
                return -1;
            }else  {
                return 0;
            }
        } catch (MatiereException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Nom : " + this.identite.getNom() +" Prenom : " + this.identite.getPrenom() + " INP : " + this.identite.getNip();
    }
}
