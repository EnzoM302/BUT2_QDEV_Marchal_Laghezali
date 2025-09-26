import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Exception.*;

public class Groupe {
    private ArrayList<Etudiant>  etudiants;
    private Formation formation;

    public Groupe(Formation idFormation) {
        etudiants = new ArrayList<Etudiant>();
        this.formation = idFormation;
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }


    public void addEtudiant(Etudiant etudiant) throws EtudiantException {
        if (!etudiants.contains(etudiant) && etudiant.getFormation().getId().equals(formation.getId())) {
            etudiants.add(etudiant);
        }else{
            throw new EtudiantException("L'étudiant existe déjà");
        }
    }

    public void removeEtudiant(Etudiant etudiant)throws EtudiantException {
        if (etudiants.contains(etudiant)) {
            etudiants.remove(etudiant);
        }else{
            throw new EtudiantException("l'etudiant n'existe pas");
        }

    }

    public double moyenneGroupeMatiere(String matiere) throws MatiereException {
        double moyenne = 0;
        for (Etudiant etudiant : etudiants) {
            moyenne += etudiant.calculerMoyenneMatiere(matiere);
        }
        return moyenne/etudiants.size();
    }

    public double moyenneGroupeGeneral() throws MatiereException {
        double moyenne = 0;
        for (Etudiant etudiant : etudiants) {
            moyenne += etudiant.calculerMoyenneGenerale(formation);
        }
        return moyenne/etudiants.size();
    }

    @Override
    public String toString() {
        String s = "";
        for (Etudiant etudiant : etudiants) {
            s += etudiant.toString() + "/";
        }
        return s;
    }

    public void triAlpha(){
        Collections.sort(etudiants, new Comparateur(true));
    }

    public void triAntiAlpha(){
        Collections.sort(etudiants, new Comparateur(false));
    }




}
