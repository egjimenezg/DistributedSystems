package mx.ipn.dsd.repository

import org.springframework.data.domain.Sort
import org.springframework.data.repository.CrudRepository
import org.springframework.data.jpa.repository.Query
import mx.ipn.dsd.domain.Category

interface CategoryRepository extends CrudRepository<Category, Long>{

  List<Category> findAll()

}
