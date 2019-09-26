package operatorsandsoon

object FuncOrder {

  println(I1(1) add I1(2) mul I1(3))
  println(I1(1) + I1(2) * I1(3))

}

case class I1(k: Int) {
  def add(that: I1): I1 = I1(this.k + that.k)
  def mul(that: I1): I1 = I1(this.k * that.k)

  def +(that: I1): I1 = I1(this.k + that.k)
  def *(that: I1): I1 = I1(this.k * that.k)
}
