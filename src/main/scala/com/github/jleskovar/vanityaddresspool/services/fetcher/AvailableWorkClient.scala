package com.github.jleskovar.vanityaddresspool.services.fetcher

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod._

/**
 * Created by james on 31/05/15.
 */
@FeignClient(url="${vanitypool.base.url}")
trait AvailableWorkClient {

  @RequestMapping(method = Array(GET), value = Array("/getWork"))
  def getAvailableWork(): String

}
