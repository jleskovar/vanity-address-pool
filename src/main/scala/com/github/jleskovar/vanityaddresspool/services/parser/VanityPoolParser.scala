package com.github.jleskovar.vanityaddresspool.services.parser

import org.springframework.stereotype.Component

/**
 * Created by james on 16/05/15.
 */
@Component
class VanityPoolParser {
  def parse(input: String): Seq[ParsedWorkItem] = {
    val nonEmptyLines = input.split(";").map(_.trim).filter(!_.isEmpty)
    nonEmptyLines.map { s =>
      val fields = s.split(":").map(_.trim)
      ParsedWorkItem(fields(0), fields(1), fields(2), fields(3))
    }
  }

}

case class ParsedWorkItem(pattern: String, publicKey: String, networkByte: String, reward: String)
