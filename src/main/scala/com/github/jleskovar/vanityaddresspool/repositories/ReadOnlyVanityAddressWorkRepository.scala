package com.github.jleskovar.vanityaddresspool.repositories

import com.github.jleskovar.vanityaddresspool.models.VanityAddressWorkItem
import org.springframework.stereotype.Repository

/**
 * Created by james on 31/05/15.
 */
@Repository
trait ReadOnlyVanityAddressWorkRepository extends ReadOnlyPagingAndSortingRepository[VanityAddressWorkItem, java.lang.Long]
