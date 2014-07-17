package org.twm.keepalive

import akka.actor.{Props, ActorSystem}
import akka.kernel.Bootable

class KeepAliveApp extends Bootable {
  private val system = ActorSystem()

  override def startup: Unit = {
    system.actorOf(Props[TwmKeepAlive])
  }

  override def shutdown: Unit = {
    system.shutdown()
  }
}
