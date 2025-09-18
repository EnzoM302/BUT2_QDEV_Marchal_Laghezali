import java.util.ArrayList;
import Exception.MatiereException;
import Exception.NoteException;

public class Etudiant {
    private Identite identite;
    private Formation formation;
    private Resultat resultat;

    public Etudiant(Identite identite, Resultat resultat) {
        this.identite = identite;
        this.resultat = resultat;
    }
    public Identite getIdentite() {
        return identite;
    }

    public Resultat getResultat() {
        return resultat;
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



}
