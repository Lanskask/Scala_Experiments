package objectrefstypes

object ListsTypes extends App {
  var list0: MyList[Any] = new MyList[String]
  // Don't know how to fix it and what to do with it
  list0 = new MyList[Integer]
}

class MyList[+A]
