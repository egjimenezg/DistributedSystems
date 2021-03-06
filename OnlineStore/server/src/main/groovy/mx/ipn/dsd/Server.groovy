package mx.ipn.dsd

import java.rmi.RemoteException
import java.rmi.registry.LocateRegistry
import java.rmi.registry.Registry
import java.rmi.server.UnicastRemoteObject
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.data.jpa.repository.JpaContext
import mx.ipn.dsd.config.ApplicationConfig
import mx.ipn.dsd.config.DataSourceConfig
import mx.ipn.dsd.config.ServiceConfig
import javax.sql.DataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.beans.factory.config.AutowireCapableBeanFactory
import mx.ipn.dsd.services.ProductService
import mx.ipn.dsd.services.CategoryService
import mx.ipn.dsd.services.impl.ProductServiceImpl

class Server {

  @Autowired
  ProductService productService
  @Autowired
  CategoryService categoryService 

  public Server() {
    ApplicationContext ctx = new AnnotationConfigApplicationContext()
    ctx.register(ApplicationConfig.class)
    ctx.register(DataSourceConfig.class)
    ctx.register(ServiceConfig.class)
    ctx.refresh()

    AutowireCapableBeanFactory server = ctx.getAutowireCapableBeanFactory()
    server.autowireBean(this)
  }

  static main(def args){
    Server server = new Server();

    if(System.getSecurityManager() == null){
      System.setSecurityManager(new SecurityManager())
    }
    try{
      final Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT)
      ProductService productStub = (ProductService) UnicastRemoteObject.exportObject(server.productService, 0)
      CategoryService categoryStub = (CategoryService) UnicastRemoteObject.exportObject(server.categoryService,0)
      registry.rebind("ProductService",productStub)
      registry.rebind("CategoryService",categoryStub)
    }
    catch(RemoteException e){
      e.printStackTrace()
    }
  }
}
