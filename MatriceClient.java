import java.rmi.Naming;
import java.util.Random;
import java.util.Scanner;

public class MatriceClient {

    public static void main(String[] args) {
        try {
            // Connexion au serveur RMI
            MatriceOperations matriceOperations = (MatriceOperations) Naming.lookup("//localhost/MatriceOperations");
            Scanner scanner = new Scanner(System.in);

            // Identification de l'utilisateur
            System.out.print("Nom d'utilisateur : ");
            String id = scanner.nextLine();
            System.out.print("Mot de passe : ");
            String pass = scanner.nextLine();
            Utilisateur utilisateur = new Utilisateur(id, pass);
            if (!matriceOperations.identification(utilisateur)) {
                System.out.println("Identifiants incorrects.");
                return;
            }

            // Génération de deux matrices aléatoires
            Random random = new Random();
            System.out.print("Nombre de lignes de la matrice : ");
            int rows = scanner.nextInt();
            System.out.print("Nombre de colonnes de la matrice : ");
            int columns = scanner.nextInt();
            double[][] matrice1 = new double[rows][columns];
            double[][] matrice2 = new double[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrice1[i][j] = random.nextDouble();
                    matrice2[i][j] = random.nextDouble();
                }
            }

            // Choix de l'opération à effectuer
            System.out.println("1. Addition");
            System.out.println("2. Multiplication");
            System.out.println("3. Transposition");
            System.out.print("Choix de l'opération : ");
            int choix = scanner.nextInt();
            double[][] resultat = null;
            switch (choix) {
                case 1:
                    resultat = matriceOperations.addition(matrice1, matrice2);
                    break;
                case 2:
                    resultat = matriceOperations.multiplication(matrice1, matrice2);
                    break;
                case 3:
                    resultat = matriceOperations.transposition(matrice1);
                    break;
                default:
                    System.out.println("Choix invalide.");
                    return;
            }

            // Affichage du résultat
            System.out.println("Résultat :");
            for (int i = 0; i < resultat.length; i++) {
                for (int j = 0; j < resultat[0].length; j++) {
                    System.out.print(resultat[i][j] + " ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}
