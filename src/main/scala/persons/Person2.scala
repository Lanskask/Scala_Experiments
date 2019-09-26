package persons


// Custom mutator and accessor
class Person2 {
  private[this] var privateAge = 1

  def age: Int = {
    println("Hello from accessor")
    privateAge
  }

  def age_$eq(value: Int): Unit = {
    println("Hello from mutator")
    privateAge = value
  }
}
