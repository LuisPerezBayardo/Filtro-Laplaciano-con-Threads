/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ServerRMI {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args){
        try {
            Server stub = new Server();
            Naming.rebind("rmi://192.168.1.121:5000/server",stub); 
            System.out.println("Servidor escuchando en el puerto 5000.");
        } catch (RemoteException | MalformedURLException ex) {
            System.err.println( ex );
        }
    }
    
}
