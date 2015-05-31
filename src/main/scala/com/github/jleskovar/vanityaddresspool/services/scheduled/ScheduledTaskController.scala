package com.github.jleskovar.vanityaddresspool.services.scheduled

import com.github.jleskovar.vanityaddresspool.services.fetcher.VanityAddressWorkService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.{RequestMapping, RestController}

/**
 * Created by james on 31/05/15.
 */
@RestController
class ScheduledTaskController {

  @Autowired
  val vanityAddressWorkService: VanityAddressWorkService = null

  @RequestMapping(value = Array("/fetchWork"))
  @Scheduled(fixedDelay = 600000L)
  def fetchWork(): Unit = vanityAddressWorkService.fetchAvailable()

}
