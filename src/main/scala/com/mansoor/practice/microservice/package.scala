package com.mansoor.practice

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import org.slf4j.{Logger, LoggerFactory}
import scala.concurrent.ExecutionContext


package object microservice {
  val log: Logger = LoggerFactory.getLogger(this.getClass)
  implicit val system: ActorSystem = ActorSystem("my-system")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  // needed for the future flatMap/onComplete in the end
  implicit val executionContext: ExecutionContext = system.dispatcher

  var hostname: String = _
  var port: Int = _
}
