package mx.ipn.dsd.repository

import org.springframework.data.domain.Sort
import org.springframework.data.repository.CrudRepository
import org.springframework.data.jpa.repository.Query
import mx.ipn.dsd.domain.Product

interface ProductRepository extends CrudRepository<Product, Long>{

  @Query("FROM Product p")
  List<Product> findAll()

}
