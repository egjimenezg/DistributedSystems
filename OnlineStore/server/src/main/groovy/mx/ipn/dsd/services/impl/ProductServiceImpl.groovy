package mx.ipn.dsd.services.impl

import java.rmi.Remote
import java.rmi.RemoteException
import mx.ipn.dsd.services.ProductService
import mx.ipn.dsd.model.ProductInterface
import mx.ipn.dsd.domain.Product
import mx.ipn.dsd.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.sql.DataSource

@Service
class ProductServiceImpl implements ProductService{

  @Autowired
  ProductRepository productRepository

  List<ProductInterface> getProducts() throws RemoteException{
    productRepository.findAll()
  }
}
