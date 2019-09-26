// OperatorOverloading
object Demo3 extends App {
	val x, y, z = new Holder(0 )
} 

class Holder(val value: Int) {
	print("new ...")
}
