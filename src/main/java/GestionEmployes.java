import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GestionEmployes {

    private static int max_employes=50;
    private static Employe[] employes=new Employe[max_employes];
    private static int nb_employes=0;
    // *** printMenu ***
    public static void printMenu(){
        System.out.println("***** Menu Gestion des employés ***** ");
        System.out.println("1. Ajouter   un employé");
        System.out.println("2. Modifier  un employé");
        System.out.println("3. Supprimer un employé");
        System.out.println("4. Afficher la liste des employés");
        System.out.println("5. Rechercher  un employé");
        System.out.println("6. Calculer la masse salariale");
        System.out.println("7. trier les employés par salaire");
        System.out.println("8. Quitter");
        System.out.println("Votre choix ");

    }

    // *** AjouterEmploye() ***
    public static void AjouterEmploye(Scanner scanner){
        if(nb_employes>max_employes){
            System.out.println("Tableau complet, impossible d'ajouter un employé.");
            return;
        }

        System.out.println("Entree votre ID");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Entree nom");
        String nom = scanner.nextLine();

        System.out.println("Entree poste");
        String poste = scanner.nextLine();

        System.out.println("Entree salaire");
        double salaire = scanner.nextDouble();

        employes[nb_employes++]=new Employe(id,nom, poste ,salaire);
        System.out.println("Employé ajouté avec succes !");
    }

    // *** modifierEmploye() ***
    public static void ModifierEmploye(Scanner scanner){
        System.out.println("Entree ID de l'employé à modifier ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i<nb_employes; i++){
            if(employes[i].getId()==id){
                System.out.println("Entree le nouveau nom");
                employes[i].setNom(scanner.nextLine());
                System.out.println("Entree le nouveau poste");
                employes[i].setPoste(scanner.nextLine());
                System.out.println("Entree le nouveau salaire");
                employes[i].setSalaire(scanner.nextDouble());
                System.out.println("Employé modifier avec succes !");
                return;
            }
        }
        System.out.println("Employé introuvable");
    }
    // *** supprimerEmploye() ***
    public static void SupprimerEmploye(Scanner scanner){
        System.out.println("Entree ID de l'employé à supprimer ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for(int i=0; i<nb_employes; i++){
            if(employes[i].getId()==id){
                for(int j=i; j<nb_employes-1; j++){
                        employes[j]=employes[j+1];
                }
                employes[--nb_employes]=null;
                System.out.println("Employé supprimer avec succes !");
                return;

            }
        }
        System.out.println("Employé introuvable");
    }
    // *** afficherEmployes() ***
    public static void AfficherEmploye(){
        if(nb_employes==0){
            System.out.println("Aucun employé trouvé");
            return;
        }
        for (int i = 0; i < nb_employes; i++) {
            System.out.println(employes[i]);
        }
    }
    // *** rechercherEmploye() ***
    public static void RechercherEmploye(Scanner scanner){
        System.out.println("Entree le nom ou le poste de l'employé à rechercher");
        String employe=scanner.nextLine();

        for (int i = 0; i < nb_employes; i++) {
            if(employes[i].getNom().equals(employe)||employes[i].getPoste().equals(employe)){
                System.out.println(employes[i]);
                return;
            }
        }
        System.out.println("Employé introvable");
    }
    // *** calculerMasseSalariale() ***
    public static void CalculerSalaire(){
        double total=0;
        for (int i=0;i<nb_employes;i++){
            total+=employes[i].getSalaire();
        }
        System.out.println("Le totale des salaires est"+total);
    }
    // *** trierEmployesParSalaire() ***
    public static void TrierEmploye(Scanner scanner){
        System.out.println("Trier les employés par salaire par order (TRUE / FALSE) ");
        boolean Order = scanner.nextBoolean();
        Arrays.sort(employes,0,nb_employes,new Comparator<Employe>(){
            @Override
            public int compare(Employe o1, Employe o2) {
                if(Order){
                    return Employe.compareParSalaire(o1,o2);
                }else
                {
                    return Employe.compareParSalaire(o2,o1);}
                }

        });
        AfficherEmploye();
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int choix;
        do {
            printMenu();
            System.out.println("Entre votre choix :");
            choix=scanner.nextInt();
            scanner.nextLine();
            switch(choix){
                case 1:
                    AjouterEmploye(scanner);
                    break;
                case 2:
                    ModifierEmploye(scanner);
                    break;
                case 3:
                    SupprimerEmploye(scanner);
                    break;
                case 4:
                    AfficherEmploye();
                    break;
                case 5:
                    RechercherEmploye(scanner);
                    break;

                case 6:
                    CalculerSalaire();
                    break;
                case 7:
                    TrierEmploye(scanner);
                    break;
                case 8:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide,réessayez.");
            }
        }while (choix!=8);
        scanner.close();
    }
}
