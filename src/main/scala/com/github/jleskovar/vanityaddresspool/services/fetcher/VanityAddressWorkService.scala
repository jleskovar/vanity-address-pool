package com.github.jleskovar.vanityaddresspool.services.fetcher

import java.util

import com.github.jleskovar.vanityaddresspool.models.VanityAddressWorkItem
import com.github.jleskovar.vanityaddresspool.repositories.VanityAddressWorkRepository
import com.github.jleskovar.vanityaddresspool.services.parser.VanityPoolParser
import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import scala.collection.JavaConverters._

/**
 * Created by james on 31/05/15.
 */
@Service
class VanityAddressWorkService @Autowired() (workClient: AvailableWorkClient,
                                             parser: VanityPoolParser,
                                             vanityAddressWorkRepository: VanityAddressWorkRepository) {

  val LOG = LogFactory.getLog(getClass)

  @Transactional
  def fetchAvailable(): Unit = {
    val availableWork = workClient.getAvailableWork()

    val workItems = parser.parse(availableWork)

    val entities = workItems.map { item =>
      val ent = new VanityAddressWorkItem
      ent.networkByte = item.networkByte
      ent.pattern = item.pattern
      ent.publicKey = item.publicKey
      ent.reward = item.reward.toDouble
      ent
    }

    val entitiesToSave = entities.asJava
    vanityAddressWorkRepository.deleteAll()
    LOG.info(s"Saving ${entitiesToSave.size()} entities")
    vanityAddressWorkRepository.save(entitiesToSave)
  }


}
