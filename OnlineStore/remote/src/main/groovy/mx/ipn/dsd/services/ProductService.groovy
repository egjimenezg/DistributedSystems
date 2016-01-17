package mx.ipn.dsd.services

import java.rmi.Remote
import java.rmi.RemoteException
import mx.ipn.dsd.model.ProductInterface

interface ProductService extends Remote{
  
  public List<ProductInterface> getProducts() throws RemoteException;

}
