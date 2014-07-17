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



    //val response1 = Observable.from(pipeline(Get("https://api.github.com/users")))
    //val response2 = Observable.from(pipeline(Get("https://api.github.com/users/octocat/orgs")))
  }
}
