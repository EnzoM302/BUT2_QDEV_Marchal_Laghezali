/**
 * Représente l'identité d'une personne, avec un nom, un prénom et un NIP.
 */
public class Identite {

    /** Nom de la personne */
    private String nom;

    /** Prénom de la personne */
    private String prenom;

    /** Numéro d'identification personnel (NIP) */
    private String nip;

    /**
     * Constructeur de la classe Identite.
     *
     * @param nom    le nom de la personne
     * @param prenom le prénom de la personne
     * @param nip    le numéro d'identification personnel
     */
    public Identite(String nom, String prenom, String nip) {
        this.nom = nom;
        this.prenom = prenom;
        this.nip = nip;
    }

    /**
     * Retourne le nom de la personne.
     *
     * @return le nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom de la personne.
     *
     * @param nom le nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le prénom de la personne.
     *
     * @return le prénom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Modifie le prénom de la personne.
     *
     * @param prenom le nouveau prénom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Retourne le NIP (numéro d'identification personnel) de la personne.
     *
     * @return le NIP
     */
    public String getNip() {
        return nip;
    }

    /**
     * Modifie le NIP de la personne.
     *
     * @param nip le nouveau NIP
     */
    public void setNip(String nip) {
        this.nip = nip;
    }
}
