package Graphs

import scala.collection.mutable.ArrayBuffer


class Vertex {
	var vertexes: ArrayBuffer[Vertex] = ArrayBuffer[Vertex]()
	var visited: Boolean = false
}


object Explore extends App {
	val A = new Vertex()
	val B = new Vertex()
	val C = new Vertex()

	A.vertexes = ArrayBuffer(B, C);
	B.vertexes = ArrayBuffer(C)

	val vertexes = ArrayBuffer(A, B, C)
	vertexes.foreach(vert => vert.visited = false)

	def explore(vertex: Vertex): Unit = {
		vertex.visited = true
		vertex.vertexes.foreach(vert =>
			if (!vert.visited) {
				explore(vert)
			}
		)
	}

	explore(vertexes(0))
	vertexes.foreach(vert => print(s"${vert.visited}, "))
}