

val s = Sink.actorSubscriber[Int](Props(new MySinkActor))

class MySinkAactor extends ActorSubscriber {
	override def receive: Receive = {
		case ActorSubscriberMessage.OnNext =>
			cansel()
			request(100)
		case ActorSubscriberMessage.OnComplete => 
		case ActorSubscriberMessage.OnError => 
	}
}

// ------------------

class MySourceActor(addr: String) extends ActorPublisher[Array[Byte]] {
	var conn: ZMQ.Socket = ???

	override def preStart() {
		conn.connect(addr)
	}

	override def postStop() {
		conn.disconnect(addr)
	}
}

// -----------

val s: Source[Int, ActorRef] = 
	Source.actorPublisher[Int](props(new MySourceActor))

class MySourceActor() extends ActorPublisher {
	override def receive: Receive = {
		case ActorPublesherMessage.Request(n) =>
			onNext(100)
			onCompleteThenStop()
			onErrorThenStop(new Exception)
		case ActorPublisherMessage.Cansel = >
			context.stop(self)
	}	
}

// -----------------
emit элемента
Завершение
Ошибка

Backpresure
Отмена

// ------------

val source: Source[ByteString, Control] = ???

val stream: RunnableGraph[(Control, Future[Int])] = source
	.mapAsync(10)(process)
	.toMap(Sink.head)(Keep.both) // head, both

val (control: Control, result: Future[Int]) = stream.run()
result.onComplete(_ => "We are done here")

control.gracefullStop()

trait Controll {
	def gracefullStop()
}
// -----------------

val source = ZMQSource(contrext,
	mode = ZMQ.PULL,
	timeout = 1 seconds,
	addresses = List("tcp://127:0.0.1:12345")
)

def process(in: ByteString): Future[Int] = ???


val stream = source
	.mapAsync(10)(process)
	.toMap(Sink.last)(Keep.right)

val result: Future[Int] = stream.run()
result.onComplete(_ => "We are done here")

// ----------
val source: Source[Int, Notused] = Source.single(1)
val sink: Source[Any, Future[Done]] = Source.ignore

val s1: RunnableGraph[NotUsed] = 
	source.to(sink)
val s2: RunnableGraph[Future[Done]] = 
	source.toMat(sink)(Keep.right)

val s2: RunnableGraph[(NotUsed, Future[Done])] = 
	source.toMat(sink)(Keep.both)


// -----------

val stream: RunnableGraph[Future[List[TransactionID]]] = 
	Source
		.fromIterator {
			() => hdfs.listStatusIteator(path)
		}
		.filter(_.isFile)
		.flatMapConcat { file => 
			val s = fromInputStream(hdfs.open(file.getPath))
			Source.fromIterator(() => s.getLines())
		}
		.throttle(10, 1 seconds, 0, ThrottleMode.Shaping)
		.mapAsyncUnordered(50)(checkFraud)
		.collect { case Some(value) => value}
		.take(100)
		.fold(List.empty[TransactionID])(_ :+ _)
		.toMat(Sink.head)(Keep.right)
// ----------

def checkFraud(in: String): Future[Option[TransactionID]] = ???

val result: List[TransactionID] = (for {
	file <- hdfs.listStatusIteator(path)
		if file.isFile
	line <- fromInputStream(fs.open(file.getpath)).getLines()
	resultOpt = Await.result(checkFraud(line), 10 seconds)
	result < resultOpt
} yield result)
.take(100).toList