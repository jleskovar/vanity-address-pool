package com.github.jleskovar.vanityaddresspool.parser

import org.scalatest.matchers.{MatchResult, Matcher}
import org.scalatest.{Inside, Matchers, FunSuite}

import scala.io.Source

/**
 * Created by james on 16/05/15.
 */
class VanityPoolParserTest extends FunSuite with Matchers with Inside {

  val vanityPoolParser = new VanityPoolParser

  test("should be able to parse well-formed work output") {
    val work = readResourceStreamAsString("/valid-work")
    val parsedWork = vanityPoolParser.parse(work.mkString(""))

    parsedWork should have length 3

    inside(parsedWork(0)) { case VanityWorkItem(pattern, publicKey, networkByte, reward) =>
      pattern shouldEqual "11111111"
      publicKey shouldEqual "04C13D9CF2B0E382A4AF29C5E2B97F85C6DD9445F7DCE82CD7207E6FC4716511981B0012C10B39EF152257A8407A2965F92F075379D311D5786D9421795B82D01C"
      networkByte shouldEqual "0"
      reward shouldEqual "0.112000"
    }

    inside(parsedWork(1)) { case VanityWorkItem(pattern, publicKey, networkByte, reward) =>
      pattern shouldEqual "1AnonNinja"
      publicKey shouldEqual "04FC74771485A53A9C827D70F56EC2A61D78D5751320D20C34AA775B7BDECAC661B4791769FBF9481AE75A912452DFFB7685998A2A38007BA29752C724A9132998"
      networkByte shouldEqual "0"
      reward shouldEqual "0.008000"
    }

    inside(parsedWork(2)) { case VanityWorkItem(pattern, publicKey, networkByte, reward) =>
      pattern shouldEqual "1BETBTCcom"
      publicKey shouldEqual "048ECFFA4015053C175EE19676EE856C7BE278253F1BA74B5EE3CCE7D9D2CDB50F54FE2846BC43B985CBD63B3E474BADF9E147E1CA48A4E959C7319CB9FA99C5B2"
      networkByte shouldEqual "0"
      reward shouldEqual "0.200000"
    }
  }

  private def readResourceStreamAsString(resource: String): Seq[String] =
    Source.fromInputStream(getClass.getResourceAsStream(resource)).getLines().toList
}
