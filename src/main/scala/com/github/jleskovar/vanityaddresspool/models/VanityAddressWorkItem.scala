package com.github.jleskovar.vanityaddresspool.models

import java.lang.{Double, Long}
import javax.persistence.{Entity, GeneratedValue, Id}

import scala.beans.BeanProperty

/**
 * Created by james on 31/05/15.
 */
@Entity
class VanityAddressWorkItem {

  @Id
  @GeneratedValue
  @BeanProperty
  var id: Long = _

  @BeanProperty
  var pattern: String = _

  @BeanProperty
  var publicKey: String = _

  @BeanProperty
  var networkByte: String = _

  @BeanProperty
  var reward: Double = _

}
