/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.image.BufferedImage;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class Server extends UnicastRemoteObject implements ClientServices{

    
    private final Filtros filter = new Filtros();
    private final ArrayList<ClientSession> clients = new ArrayList<>();
    
    private int ids = 0;
    
    private boolean concurrentInUse = false;
    private boolean sequentialInUse = false;
    
    
    
    public Server() throws RemoteException {}

    public boolean isConcurrentInUse() {
        return concurrentInUse;
    }

    public void setConcurrentInUse(boolean concurrentInUse) {
        this.concurrentInUse = concurrentInUse;
    }

    public boolean isSequentialInUse() {
        return sequentialInUse;
    }

    public void setSequentialInUse(boolean sequentialInUse) {
        this.sequentialInUse = sequentialInUse;
    }

    
    @Override
    public ClientSession login() throws RemoteException {
        ClientSession session = new ClientSession();
        session.setIdClient( this.ids );
        
        this.clients.add( session );
        
        this.ids++;
        
        return session;
    }

    @Override
    public ClientSession applyFilterSequentialMethod(ClientSession cl, int threshold) throws RemoteException {
        while(this.isSequentialInUse())
        {
            try {Thread.sleep(100);}catch (InterruptedException ex) {}
        }
        
        this.setSequentialInUse(true);
        
        try{
            
            ClientSession confirm = this.getClientByID( cl.getIdClient() );
            
            
            if( confirm == null )
            {
                return null;
            }
            
            
            cl.setTime_init(System.currentTimeMillis());
            BufferedImage result = this.filter.aplicarFiltroSecuencial(cl.getOriginalImage(), threshold);
            cl.setResultImage(result);
            cl.setTime_finished(System.currentTimeMillis());
            cl.setTime( cl.getTime_finished() - cl.getTime_init() );
            
            return cl;
            
        }finally{
            this.setSequentialInUse(false);
        }
        
    }

    @Override
    public ClientSession applyFilterConcurrentMethod(ClientSession cl, int threshold) throws RemoteException {
       while(this.isConcurrentInUse())
        {
            try {Thread.sleep(100);}catch (InterruptedException ex) {}
        }
       
       this.setConcurrentInUse(true);
       
       try{
           ClientSession confirm = this.getClientByID( cl.getIdClient() );
           
           if( confirm == null )
           {
               return null;
           }
           
           cl.setTime_init(System.currentTimeMillis());
           BufferedImage result  = this.filter.aplicarFiltroConcurrente(cl.getOriginalImage(), threshold);
           cl.setResultImage( result );
           cl.setTime_finished(System.currentTimeMillis());
           cl.setTime( cl.getTime_finished() - cl.getTime_init() );
           
           return cl;
           
       }finally{
           this.setConcurrentInUse(false);
       }
        
    }
    
    
    
    
    private ClientSession getClientByID( int id )
    {
        for(ClientSession cl : this.clients  )
        {
            if(cl.getIdClient() == id)
            {
                return cl;
            }
        }
        
        return null;
    }
    
    
    
    
}
