package com.mansoor.practice.microservice.server

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import com.mansoor.practice.microservice.server.paths.Base

object Api {
  def routes: Route = {
    SwaggerService.routes ~ getFromResourceDirectory("swagger") ~
      path("swagger") {
        get {
          redirect("/swagger-ui/index.html", StatusCodes.PermanentRedirect)
        }
      } ~
      Base.route
  }
}
