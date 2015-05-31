package com.github.jleskovar.vanityaddresspool

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(Array("com.github.jleskovar.vanityaddresspool"))
@EnableFeignClients
class Application {

}

object Application extends App {
  SpringApplication.run(classOf[Application])
}
