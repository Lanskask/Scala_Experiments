
import scala.collection.mutable.ArrayBuffer

object FormulaAnalizer extends App {
  val str = "4 + 15 * 6 - 18"
  // val str2 = "(4 + 15) * 6 - 18"
  val nums = Set('1','2','3','4','5','6','7','8','9','0')
  val opes = Set('-','+','*','\\')
  val tknArr = ArrayBuffer[String]()


	def tokenizer(str: String, aggr: String, tknArr: ArrayBuffer[String]): ArrayBuffer[String] = {
 		for(ch <- str) {
 			var i = 0

 			ch match {
 				case ch if nums(ch) =>
 					i+=1; println(s"$i $str $tknArr");
					aggr match {
            case aggr if strNotEmptyOrSpace(aggr) =>
							tokenizer(str.substring(1), s"$aggr$ch" , tknArr += s"$aggr$ch")
						case _ =>
					}
 				case ch if opes(ch) =>
 					i+=1; println(s"$i $str $tknArr");
					aggr match {
						case aggr if strNotEmptyOrSpace(aggr) =>
							tokenizer(str.substring(1), s"$aggr$ch", tknArr += s"$aggr$ch")
						case _ =>
					}
				case ' ' =>
 					i+=1; println(s"$i $str $tknArr");
 					tokenizer(str.substring(1), ch +"", tknArr)
 				case _ =>
					i+=1; println(s"$i $str $tknArr");
 				 	tokenizer(str.substring(1), ch +"", tknArr)
 			}

 		}
 		tknArr
 	}

	def strNotEmptyOrSpace(str: String) = !(str == " " || str.isEmpty)

	tokenizer(str, "0", tknArr)
}