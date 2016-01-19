package mx.ipn.dsd.services.impl

import java.rmi.Remote
import java.rmi.RemoteException
import mx.ipn.dsd.services.CategoryService
import mx.ipn.dsd.model.CategoryInterface
import mx.ipn.dsd.domain.Category
import mx.ipn.dsd.repository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.sql.DataSource

@Service
class CategoryServiceImpl implements CategoryService{

  @Autowired
  CategoryRepository categoryRepository

  List<CategoryInterface> list() throws RemoteException{
    categoryRepository.findAll()
  }

}
