import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatriceOperations extends Remote {

    // Méthode pour l'addition de deux matrices
    double[][] addition(double[][] matrice1, double[][] matrice2) throws RemoteException;

    // Méthode pour la multiplication de deux matrices
    double[][] multiplication(double[][] matrice1, double[][] matrice2) throws RemoteException;

    // Méthode pour la transposée d'une matrice
    double[][] transposition(double[][] matrice) throws RemoteException;

    // Méthode pour l'identification d'un utilisateur
    boolean identification(Utilisateur utilisateur) throws RemoteException;

    
}
