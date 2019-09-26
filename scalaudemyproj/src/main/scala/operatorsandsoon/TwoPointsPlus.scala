package operatorsandsoon


case class I4(k: Int) {

  // Лево ассоциативная свёртка
  // 1 ++ 2 ++ 3 ++ 4
  def ++(that: I4): I4 = I4(this.k + that.k)

  // Право ассоциативная свёртка
  // 1 +: 2 +: 3 +: 4
  // 1 +: (2 +: (3 +: 4))
  def +:(that: I4): I4 = I4(this.k + that.k)
}

object TwoPointsPlus extends App {
    println(I4(1) ++ I4(2) ++ I4(3))
    println(I4(1) +: I4(2) +: I4(3))
}
