package ru.smurtazin.lagomtaskschedulerstream.api

import akka.NotUsed
import akka.stream.scaladsl.Source
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

/**
  * The Lagom Task Scheduler stream interface.
  *
  * This describes everything that Lagom needs to know about how to serve and
  * consume the LagomTaskSchedulerStream service.
  */
trait LagomTaskSchedulerStreamService extends Service {

  def stream: ServiceCall[Source[String, NotUsed], Source[String, NotUsed]]

  override final def descriptor: Descriptor = {
    import Service._

    named("lagom-task-scheduler-stream")
      .withCalls(
        namedCall("stream", stream)
      ).withAutoAcl(true)
  }
}
