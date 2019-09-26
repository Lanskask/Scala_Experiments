Scala Json


https://manuel.bernhardt.io/2015/11/06/a-quick-tour-of-json-libraries-in-scala/


https://stackoverflow.com/questions/4170949/how-to-parse-json-in-scala-using-standard-scala-classes



import scala.util.parsing.json.
...
val json:Option[Any] = JSON.parseFull(jsonString)
val map:Map[String,Any] = json.get.asInstanceOf[Map[String, Any]]
val languages:List[Any] = map.get("languages").get.asInstanceOf[List[Any]]
languages.foreach( langMap => {
val language:Map[String,Any] = langMap.asInstanceOf[Map[String,Any]]
val name:String = language.get("name").get.asInstanceOf[String]
val isActive:Boolean = language.get("is_active").get.asInstanceOf[Boolean]
val completeness:Double = language.get("completeness").get.asInstanceOf[Double]
}


class CC[T] { def unapply(a:Any):Option[T] = Some(a.asInstanceOf[T]) }

object M extends CC[Map[String, Any]]
object L extends CC[List[Any]]
object S extends CC[String]
object D extends CC[Double]
object B extends CC[Boolean]

val jsonString =
    """
      {
        "languages": [{
            "name": "English",
            "is_active": true,
            "completeness": 2.5
        }, {
            "name": "Latin",
            "is_active": false,
            "completeness": 0.9
        }]
      }
    """.stripMargin

val result = for {
    Some(M(map)) <- List(JSON.parseFull(jsonString))
    L(languages) = map("languages")
    M(language) <- languages
    S(name) = language("name")
    B(active) = language("is_active")
    D(completeness) = language("completeness")
} yield {
    (name, active, completeness)
}

assert( result == List(("English",true,2.5), ("Latin",false,0.9)))