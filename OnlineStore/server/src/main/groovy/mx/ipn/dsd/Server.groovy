package mx.ipn.dsd

import java.rmi.RemoteException
import java.rmi.registry.LocateRegistry
import java.rmi.registry.Registry
import java.rmi.server.UnicastRemoteObject
import mx.ipn.dsd.services.ProductService
import mx.ipn.dsd.services.impl.ProductServiceImpl
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import mx.ipn.dsd.config.ApplicationConfig
import mx.ipn.dsd.config.DataSourceConfig
import mx.ipn.dsd.config.ServiceConfig
import javax.sql.DataSource


class Server implements Runnable{

  @Override
  public void run(){
    if(System.getSecurityManager() == null){
      System.setSecurityManager(new SecurityManager())
    }
    try{
      final Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT)
      ProductService productService = new ProductServiceImpl()
      ProductService stub = (ProductService) UnicastRemoteObject.exportObject(productService,0)
      registry.rebind("ProductService",stub) 
    }
    catch(RemoteException e){
      e.printStackTrace()
    }
  }

  static main(def args){
    ApplicationContext ctx = new AnnotationConfigApplicationContext()
    ctx.register(ApplicationConfig.class)
    ctx.register(DataSourceConfig.class)
    ctx.register(ServiceConfig.class)
    ctx.refresh()
    Thread thread = new Thread(new Server())  
    thread.start()
  }
}
