package persons

class Person2Demo {

  val person = new Person2

  val age = person.age
  person.age = 45

  person.age_$eq(45)
  person.age_=(45)
}
