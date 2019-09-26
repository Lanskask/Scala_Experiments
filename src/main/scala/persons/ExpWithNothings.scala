package persons

class ExpWithNothings extends App {
  val un_const0 = new C[Nothing]
  val x: C[Int] = un_const0

  val un_const1: Nothing = ???
}

class C[+T]
