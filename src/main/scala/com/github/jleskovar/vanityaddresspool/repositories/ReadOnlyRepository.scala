package com.github.jleskovar.vanityaddresspool.repositories

import org.springframework.data.repository.{Repository, NoRepositoryBean}

/**
 * Created by james on 31/05/15.
 */
@NoRepositoryBean
trait ReadOnlyRepository[T, ID <: java.io.Serializable] extends Repository[T, ID] {
  def findOne(id: ID): T

  def findAll(): java.lang.Iterable[T]
}


