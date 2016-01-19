package mx.ipn.dsd.controllers

import java.rmi.registry.Registry
import mx.ipn.dsd.services.ProductService
import mx.ipn.dsd.model.ProductInterface

class ProductController{
  
  def list(Registry registry){
    ProductService productService = (ProductService) registry.lookup("ProductService")
    List<ProductInterface> products = productService.getProducts()
    products
  }

}
