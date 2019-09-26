package operatorsandsoon

object PostfixOperator {

  // error
//  val a1 = + I3(0)

  // should be no error
  val y0 = I3(0).+
  val y1 = I3(0).-
  val y2 = I3(0).!
  val y3 = I3(0).~
//
  val z0 = I3(0) +
  val z1 = I3(0) -
  val z2 = I3(0) !
  val z3 = I3(0) ~

}

case class I3(k: Int) {
  def +(): I3 = I3(2 * this.k)
  def -(): I3 = I3(3 * this.k)
  def !(): I3 = I3(4 * this.k)
  def ~(): I3 = I3(5 * this.k)
}
