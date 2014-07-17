package org.twm.keepalive

import akka.actor.ActorSystem
import spray.client.pipelining._
import scala.concurrent.duration._
import scala.concurrent.Future
import scala.util.{Failure, Success}

object TwmKeepAlive {
  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem()
    import system.dispatcher

    val pipeline = sendReceive

    system.scheduler.schedule(initialDelay = 0.seconds, interval = 5.seconds, new Runnable {
      override def run(): Unit = {
        pipeline(Get("http://twm.herokuapp.com/keep-alive")).onComplete{
          case completed => println(s"Completed: $completed")
        }
      }
    })

    //val response1 = Observable.from(pipeline(Get("https://api.github.com/users")))
    //val response2 = Observable.from(pipeline(Get("https://api.github.com/users/octocat/orgs")))
  }
}
