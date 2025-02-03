// *** creation de la classe employe ***
public class Employe {
    private int id;
    private String nom;
    private String poste;
    private double salaire;

//    Constructeur avec tous les attributs :
    public Employe(int id, String nom, String poste, double salaire) {
        this.id = id;
        this.nom = nom;
        this.poste = poste;
        this.salaire = salaire;
    }

//    Constructeur par defaut :

    public Employe() {
    }
// Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPoste() {
        return poste;
    }

    public double getSalaire() {
        return salaire;
    }
// Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

//    Une méthode toString()
    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", poste='" + poste + '\'' +
                ", salaire=" + salaire +
                '}';
    }

    //    Une méthode statique compareParSalaire
    public static int compareParSalaire(Employe E1, Employe E2) {
        return Double.compare(E1.getSalaire(), E2.getSalaire());
    }
}
