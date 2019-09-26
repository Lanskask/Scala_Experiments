// OperatorOverloading
object Demo3 extends App {
	var c = new C(0)
	c ?= 1 	// c = c ? 1
			// c = c.?(1)

	println(c.value)
} 

class C(val value: Int) {
	def ?(k: Int): C = new C(value + k)
}