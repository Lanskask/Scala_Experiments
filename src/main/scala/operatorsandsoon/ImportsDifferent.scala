package operatorsandsoon


import java.lang.Double.{isNaN, isInfinite => isInf}
import java.lang.Float._
import java.lang.Integer.valueOf

class ImportsDifferent {
  val x = valueOf("42")
  def y(d: Double) = isInf(_: Double) || isNaN(_: Double)
  val z = floatToRawIntBits(0.1f)
}
