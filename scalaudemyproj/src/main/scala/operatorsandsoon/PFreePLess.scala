package operatorsandsoon

// Point free and point less styles
object PFreePLess {
  val cos: Double => Double = Math.cos
  val sin: Double => Double = Math.sin

  val f: Double => Double = x => cos(sin(x))

  // Point-free style
  val g: Double => Double = cos compose sin
}
