package mx.ipn.dsd

import java.rmi.RemoteException
import java.rmi.registry.LocateRegistry
import java.rmi.registry.Registry
import java.rmi.server.UnicastRemoteObject
import mx.ipn.dsd.services.ProductService
import mx.ipn.dsd.services.impl.ProductServiceImpl

class Server implements Runnable{

  @Override
  public void run(){
    if(System.getSecurityManager() == null){
      System.setSecurityManager(new SecurityManager())
    }
    try{
      final Registry registry = LocateRegistry.createRegistry(2020)
      ProductService stub = new ProductServiceImpl()
      registry.rebind("products",stub) 
      while(true){}
    }
    catch(RemoteException e){
      e.printStackTrace()
    }
  }

  static main(def args){
    Thread thread = new Thread(new Server())  
    thread.start()
  }
}
