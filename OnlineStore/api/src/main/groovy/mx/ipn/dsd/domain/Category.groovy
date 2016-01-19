package mx.ipn.dsd.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.JoinColumn

import mx.ipn.dsd.model.CategoryInterface

@Entity
class Category implements Serializable,CategoryInterface{

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id
  String name
  String description

}
