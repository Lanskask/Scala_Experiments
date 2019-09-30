package ru.smurtazin.lagomtaskschedulerstream.impl

import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.server._
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import play.api.libs.ws.ahc.AhcWSComponents
import ru.smurtazin.lagomtaskschedulerstream.api.LagomTaskSchedulerStreamService
import ru.smurtazin.lagomtaskscheduler.api.LagomTaskSchedulerService
import com.softwaremill.macwire._

class LagomTaskSchedulerStreamLoader extends LagomApplicationLoader {

  override def load(context: LagomApplicationContext): LagomApplication =
    new LagomTaskSchedulerStreamApplication(context) {
      override def serviceLocator: NoServiceLocator.type = NoServiceLocator
    }

  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new LagomTaskSchedulerStreamApplication(context) with LagomDevModeComponents

  override def describeService = Some(readDescriptor[LagomTaskSchedulerStreamService])
}

abstract class LagomTaskSchedulerStreamApplication(context: LagomApplicationContext)
  extends LagomApplication(context)
    with AhcWSComponents {

  // Bind the service that this server provides
  override lazy val lagomServer: LagomServer = serverFor[LagomTaskSchedulerStreamService](wire[LagomTaskSchedulerStreamServiceImpl])

  // Bind the LagomTaskSchedulerService client
  lazy val lagomTaskSchedulerService: LagomTaskSchedulerService = serviceClient.implement[LagomTaskSchedulerService]
}
