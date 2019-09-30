package ru.smurtazin.lagomtaskscheduler.impl

import com.lightbend.lagom.scaladsl.server.LocalServiceLocator
import com.lightbend.lagom.scaladsl.testkit.ServiceTest
import org.scalatest.{AsyncWordSpec, BeforeAndAfterAll, Matchers}
import ru.smurtazin.lagomtaskscheduler.api._

class LagomTaskSchedulerServiceSpec extends AsyncWordSpec with Matchers with BeforeAndAfterAll {

  private val server = ServiceTest.startServer(
    ServiceTest.defaultSetup
      .withCassandra()
  ) { ctx =>
    new LagomTaskSchedulerApplication(ctx) with LocalServiceLocator
  }

  val client: LagomTaskSchedulerService = server.serviceClient.implement[LagomTaskSchedulerService]

  override protected def afterAll(): Unit = server.stop()

  "Lagom Task Scheduler service" should {

    "say hello" in {
      client.hello("Alice").invoke().map { answer =>
        answer should ===("Hello, Alice!")
      }
    }

    "allow responding with a custom message" in {
      for {
        _ <- client.useGreeting("Bob").invoke(GreetingMessage("Hi"))
        answer <- client.hello("Bob").invoke()
      } yield {
        answer should ===("Hi, Bob!")
      }
    }
  }
}
