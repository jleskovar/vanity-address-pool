package com.github.jleskovar.vanityaddresspool.repositories

import org.springframework.data.domain.{Page, Pageable, Sort}
import org.springframework.data.repository.{Repository, NoRepositoryBean}

/**
 * Created by james on 31/05/15.
 */
@NoRepositoryBean
trait ReadOnlyPagingAndSortingRepository[T, ID <: java.io.Serializable] extends Repository[T, ID] {

  def findOne(id: ID): T

  def findAll(): java.lang.Iterable[T]

  def findAll(sort: Sort): java.lang.Iterable[T]

  def findAll(pageable: Pageable): Page[T]
}
