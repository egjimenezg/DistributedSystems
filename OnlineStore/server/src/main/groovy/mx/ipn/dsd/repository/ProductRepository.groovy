package mx.ipn.dsd.config.repository

import org.springframework.data.domain.Sort
import org.springframework.data.repository.CrudRepository
import mx.ipn.dsd.domain.Product

interface ProductRepository extends CrudRepository<Product, Long>{

  List<Product> findAll()

}
