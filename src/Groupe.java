import java.util.ArrayList;

import Exception.*;

public class Groupe {
    private ArrayList<Etudiant>  etudiants;
    private String idFormation;

    public Groupe(String idFormation) {
        etudiants = new ArrayList<>();
        this.idFormation = idFormation;
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }


    public void addEtudiant(Etudiant etudiant) throws EtudiantException {
        if (!etudiants.contains(etudiant) && etudiant.getFormation().getId().equals(idFormation)) {
            etudiants.add(etudiant);
        }else{
            throw new IllegalArgumentException("L'étudiant existe déjà");
        }
    }

    public void removeEtudiant(Etudiant etudiant) {
        etudiants.remove(etudiant);
    }

    @Override
    public String toString() {
        String s = "";
        for (Etudiant etudiant : etudiants) {
            s += etudiant.toString() + "\n";
        }
        return s;
    }
}
