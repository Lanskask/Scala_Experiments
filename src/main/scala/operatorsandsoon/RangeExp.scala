package operatorsandsoon

import scala.runtime.RichInt

object RangeExp extends App {
  for (k <- 1 to 10) {
    println(k)
  }

  for (k <- 1.to(10)) println(k)

  val range10: Range = 1.to(10)
  for (k <- range10) println(k)

  val range10_2: Range = new RichInt(1).to(10)
  for (k <- range10_2) println(k)
}

