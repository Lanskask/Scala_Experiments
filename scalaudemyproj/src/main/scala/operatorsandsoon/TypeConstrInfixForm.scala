package operatorsandsoon


// У инфиксных типов нет приоритетов
object TypeConstrInfixForm extends App {

  val x0: ab[Int, String] = ???
  val x1: Int ab String = ???

  val y0: ++[Int, String] = ???
  val y1: Int ++ String = ???

  val y2: List[Int ++ String] = ???

//  Error:(13, 25) not enough arguments for constructor ++: (a: Int, b: String)++[Int,String].
//  Unspecified value parameters a, b.
//  class X extends ( Int ++ String)
//  class X extends ( Int ++ String )

  val f: Int ++ String => String ++ Int = ???

}

case class ab[A, B](a: A, b: B)
case class ++[A, B](a: A, b: B)

case class A()
case class B()