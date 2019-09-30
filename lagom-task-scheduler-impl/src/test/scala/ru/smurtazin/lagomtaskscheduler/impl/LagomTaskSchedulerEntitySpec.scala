package ru.smurtazin.lagomtaskscheduler.impl

import akka.actor.ActorSystem
import akka.testkit.TestKit
import com.lightbend.lagom.scaladsl.testkit.PersistentEntityTestDriver
import com.lightbend.lagom.scaladsl.playjson.JsonSerializerRegistry
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpec}

class LagomTaskSchedulerEntitySpec extends WordSpec with Matchers with BeforeAndAfterAll {

  private val system = ActorSystem("LagomTaskSchedulerEntitySpec",
    JsonSerializerRegistry.actorSystemSetupFor(LagomTaskSchedulerSerializerRegistry))

  override protected def afterAll(): Unit = {
    TestKit.shutdownActorSystem(system)
  }

  private def withTestDriver(block: PersistentEntityTestDriver[LagomTaskSchedulerCommand[_], LagomTaskSchedulerEvent, LagomTaskSchedulerState] => Unit): Unit = {
    val driver = new PersistentEntityTestDriver(system, new LagomTaskSchedulerEntity, "lagom-task-scheduler-1")
    block(driver)
    driver.getAllIssues should have size 0
  }

  "Lagom Task Scheduler entity" should {

    "say hello by default" in withTestDriver { driver =>
      val outcome = driver.run(Hello("Alice"))
      outcome.replies should contain only "Hello, Alice!"
    }

    "allow updating the greeting message" in withTestDriver { driver =>
      val outcome1 = driver.run(UseGreetingMessage("Hi"))
      outcome1.events should contain only GreetingMessageChanged("Hi")
      val outcome2 = driver.run(Hello("Alice"))
      outcome2.replies should contain only "Hi, Alice!"
    }

  }
}
