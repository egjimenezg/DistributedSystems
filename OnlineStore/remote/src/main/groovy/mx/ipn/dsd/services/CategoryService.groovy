package mx.ipn.dsd.services

import java.rmi.Remote
import java.rmi.RemoteException
import mx.ipn.dsd.model.CategoryInterface

interface CategoryService extends Remote{
  
  public List<CategoryInterface> list() throws RemoteException;

}
