package com.github.jleskovar.vanityaddresspool.parser

/**
 * Created by james on 16/05/15.
 */
class VanityPoolParser {
  def parse(input: String): Seq[VanityWorkItem] = {
    input.split(";").map(_.trim).filter(!_.isEmpty).map { s =>
      val fields = s.split(":").map(_.trim)
      VanityWorkItem(fields(0), fields(1), fields(2), fields(3))
    }
  }

}

case class VanityWorkItem(pattern: String, publicKey: String, networkByte: String, reward: String)
