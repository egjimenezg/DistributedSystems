package mx.ipn.dsd

import java.rmi.registry.LocateRegistry
import java.rmi.RemoteException
import java.rmi.registry.Registry
import mx.ipn.dsd.services.ProductService
import mx.ipn.dsd.model.ProductInterface
import mx.ipn.dsd.view.GUI

class Client{
  static main(def args){
    GUI view = new GUI()       
  }
}
