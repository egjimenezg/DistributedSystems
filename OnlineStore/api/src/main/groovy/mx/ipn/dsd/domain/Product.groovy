package mx.ipn.dsd.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import mx.ipn.dsd.model.ProductInterface

@Entity
class Product implements Serializable, ProductInterface{

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id
  Integer existence
  String name
  String description
  BigDecimal cost

}
