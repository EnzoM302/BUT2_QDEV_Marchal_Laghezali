import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Exception.*;

public class Groupe {
    private ArrayList<Etudiant>  etudiants;
    private String idFormation;

    public Groupe(String idFormation) {
        etudiants = new ArrayList<Etudiant>();
        this.idFormation = idFormation;
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }


    public void addEtudiant(Etudiant etudiant) throws EtudiantException {
        if (!etudiants.contains(etudiant) && etudiant.getFormation().getId().equals(idFormation)) {
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
