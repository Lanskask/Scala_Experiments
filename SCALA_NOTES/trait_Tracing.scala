
trait Tracing {
	def trace[A](operation: String)(f: => Future[A])(implicit tracer: Tracer, ctx: Context): Future[A] = {
		val span = tracer.spanBuilder(operation)
		ctx.parrentSpan.foreach(span.asChildOf)
		f(span).andThen { case result => 
			span.setTag("success", result.isSuccess)
			span.finish()
		}
	}
}