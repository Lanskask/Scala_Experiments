package operatorsandsoon

object PFreePLess2 {

  // NOT "pointless style" + NOT "Point-free style"
  val f0: Int => Int = x => 1.+(x)

  // "pointless style" + NOT "Point-free style"
  val f1: Int => Int = x => 1 + x

  // NOT "pointless style" + "Point-free style"
  val f2: Int => Int = 1.+(_)

  // "pointless style" + "Point-free style" with placeholder
  val f3: Int => Int = 1 + _

  // "pointless style" + "Point-free style"
  val f4: Int => Int = 1 +

}
