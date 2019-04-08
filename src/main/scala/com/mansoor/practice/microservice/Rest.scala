package com.mansoor.practice.microservice

import akka.http.scaladsl.Http
import com.mansoor.practice.microservice.server.Api
import com.mansoor.practice.microservice.utils.CmdArgs
import scopt.OParser

object Rest extends App {
  val builder = OParser.builder[CmdArgs]
  val parser = {
    import builder._
    OParser.sequence(
      programName("Rest Microservice Practice"),
      head("scopt", "4.x"),
      opt[String]('h', "hostname")
        .valueName("<hostname>")
        .optional()
        .action((x, c) => c.copy(hostname = x))
        .text("hostname is a required property, eg., localhost"),
      opt[Int]('p', "port")
        .valueName("<port>")
        .required()
        .action((x, c) => c.copy(port = x))
        .validate(v =>
          if ( Range(1,65537).contains(v) ) success else failure ("input port not within range 1 to 65536")
        )
        .text("port number is a required property, eg., 8080"),
      opt[Unit]('r', "run")
        .required()
        .action((x, c) => c.copy(run = true))
        .text("run is a required flag to execute the example"),
      note(sys.props("line.separator"))
    )
  }

  OParser.parse(parser, args, CmdArgs()) match {
    case Some(config) =>
      hostname = config.hostname
      port = config.port
      val bindingFuture = Http().bindAndHandle(Api.routes, hostname, port)

      log.info(s"Server online at http://$hostname:$port/")
    case _ =>
  }
}
