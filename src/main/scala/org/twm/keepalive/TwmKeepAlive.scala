package org.twm.keepalive

import akka.actor.Actor
import akka.event.Logging
import spray.client.pipelining._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

class TwmKeepAlive extends Actor {
  private val logger = Logging(context.system, this)
  private val pipeline = sendReceive

  context.system.scheduler.schedule(initialDelay = 0.milliseconds, interval = 5.minutes, self, "tick")

  override def receive = {
    case "tick" =>
      pipeline(Get("http://twm.herokuapp.com/keep-alive")).onComplete{
        case completed => logger.info(s"Completed: $completed")
      }
    case msg =>
      logger.warning(s"Got wrong message: $msg")
  }
}
