package operatorsandsoon


trait T
class C
object O

object Demo extends App {
  val x: T = null
  val y: C = null
//  val z: O = null
  val z: O.type = null

  def f(x: T): T = ???
  def g(x: C): C = ???
//  def h(x: O): O = ???
  def h(x: O.type ): O.type = ???

  def r(arg: Any): String = arg match {
    case _: T => "T"
    case _: C => "C"
//    case _: O => "O"
    case _: O.type => "O.type"
  }
}

class Demo1 {
  def f(x: Int): Int =
    if (x == 0 ) 1
    else x * f(x - 1)
}
