package operatorsandsoon

object TypeConstrInfixForm2 {
  // ((_ ++ _) **)
  val x0: Int +++ String ** Boolean = ???
  val x1: **[+++[Int, String], Boolean] = x0

  // (_ ++ (_ **))
  val y0: Int +++ (String ** Boolean) = ???
  val y1: +++[Int, **[String, Boolean]] = y0

}

case class +++[A, B](a: A, b: B)
case class **[A, B](a: A, b: B)
