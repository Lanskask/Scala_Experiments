

object WhileFunc extends App {


	def WHILE(condition: => Boolean)(operation: => Unit) = 
		if(condition) {
			operation
			WHILE(condition)(operation)
		}
		else()
	
	WHILE(i < 5)(println(s"${i+=1}"))

}