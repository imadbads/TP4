import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class MatriceOperationsImpl extends UnicastRemoteObject implements MatriceOperations {

    private static final long serialVersionUID = 1L;
    private List<Utilisateur> utilisateurs = new ArrayList<>();

    protected MatriceOperationsImpl() throws RemoteException {
        super();
    }

    // Méthode pour l'addition de deux matrices
    public double[][] addition(double[][] matrice1, double[][] matrice2) throws RemoteException {
        int rows = matrice1.length;
        int columns = matrice1[0].length;
        double[][] resultat = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultat[i][j] = matrice1[i][j] + matrice2[i][j];
            }
        }
        return resultat;
    }

    // Méthode pour la multiplication de deux matrices
    public double[][] multiplication(double[][] matrice1, double[][] matrice2) throws RemoteException {
        int rows = matrice1.length;
        int columns = matrice2[0].length;
        double[][] resultat = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < matrice2.length; k++) {
                    resultat[i][j] += matrice1[i][k] * matrice2[k][j];
                }
            }
        }
        return resultat;
    }

    // Méthode pour la transposée d'une matrice
    public double[][] transposition(double[][] matrice) throws RemoteException {
        int rows = matrice.length;
        int columns = matrice[0].length;
        double[][] resultat = new double[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultat[j][i] = matrice[i][j];
            }
        }
        return resultat;
    }

    // Méthode pour l'identification d'un utilisateur
    public boolean identification(Utilisateur utilisateur) throws RemoteException {
        for (Utilisateur u : utilisateurs) {
            if (u.id.equals(utilisateur.id)) {
                if (u.pass.equals(utilisateur.pass)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        utilisateurs.add(utilisateur);
        return true;
    }

}
