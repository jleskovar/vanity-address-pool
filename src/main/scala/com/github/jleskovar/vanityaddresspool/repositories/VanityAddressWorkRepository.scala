package com.github.jleskovar.vanityaddresspool.repositories

import java.lang.Long

import com.github.jleskovar.vanityaddresspool.models.VanityAddressWorkItem
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

/**
 * Created by james on 31/05/15.
 */
@Repository
@RepositoryRestResource(exported = false)
trait VanityAddressWorkRepository extends PagingAndSortingRepository[VanityAddressWorkItem, Long]





