package operatorsandsoon


object Demo0 extends App {
  val x0 = I2(1).add(I2(2))
  val x1 = I2(1) add I2(2)
}

class ConstrFunc {

}

case class I2(k: Int) {
  def add(that: I2): I2 = I2(this.k + that.k)
}