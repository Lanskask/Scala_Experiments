package ru.smurtazin.lagomtaskschedulerstream.impl

import com.lightbend.lagom.scaladsl.api.ServiceCall
import ru.smurtazin.lagomtaskschedulerstream.api.LagomTaskSchedulerStreamService
import ru.smurtazin.lagomtaskscheduler.api.LagomTaskSchedulerService

import scala.concurrent.Future

/**
  * Implementation of the LagomTaskSchedulerStreamService.
  */
class LagomTaskSchedulerStreamServiceImpl(lagomTaskSchedulerService: LagomTaskSchedulerService) extends LagomTaskSchedulerStreamService {
  def stream = ServiceCall { hellos =>
    Future.successful(hellos.mapAsync(8)(lagomTaskSchedulerService.hello(_).invoke()))
  }
}
