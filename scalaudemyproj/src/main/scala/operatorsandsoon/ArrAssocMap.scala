package operatorsandsoon

object ArrAssocMap {

  var map0 = Map("France" -> "Paris")
  map0 += "Japan" -> "Tokyo"

  var map1: Map[String, String] = Map.apply(new ArrowAssoc("France").->("Paris"))
  map1.+=(new ArrowAssoc("Japan").->("Tokyo"))
}
