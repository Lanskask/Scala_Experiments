
//Source
val input = Source(1 to 100)
//Flow
val normalize = Flow[Int].map(_ * 2)
//Sink
val output = Sink.foreach[Int](println)

input.via(normalize).runWith(output).andThen {
	case _ =>
		actorSystem.shutdown()
		actorSystem.awaitTerminator()
}