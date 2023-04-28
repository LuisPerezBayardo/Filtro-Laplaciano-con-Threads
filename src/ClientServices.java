/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ClientServices extends Remote
{
    
    public ClientSession login()throws RemoteException;
    
    public ClientSession applyFilterSequentialMethod(ClientSession cl, int threshold) throws RemoteException;
    public ClientSession applyFilterConcurrentMethod(ClientSession cl, int threshold) throws RemoteException;
    
}
