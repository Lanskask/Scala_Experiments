package persons

private class Person1_5(var name: String, var age: Int) {

  def this(age: Int) {
    this(Person1_5.DEFAULT_NAME, age)
  }

  def this(name: String) {
    this(name, Person1_5.DEFAULT_AGE)
  }

  def this() {
    this(Person1_5.DEFAULT_NAME, Person1_5.DEFAULT_AGE)
  }

}

object Person1_5 {
  val DEFAULT_NAME = "Mik"
  val DEFAULT_AGE = 5
}
