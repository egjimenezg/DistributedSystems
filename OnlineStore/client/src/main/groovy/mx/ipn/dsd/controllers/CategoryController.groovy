package mx.ipn.dsd.controllers

import java.rmi.registry.Registry
import mx.ipn.dsd.services.CategoryService
import mx.ipn.dsd.model.CategoryInterface

class CategoryController{

  def list(Registry registry){
    CategoryService categoryService = (CategoryService) registry.lookup("CategoryService")
    List<CategoryInterface> categories = categoryService.list()
    categories
  }  

}
