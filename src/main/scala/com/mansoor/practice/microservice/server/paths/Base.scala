package com.mansoor.practice.microservice.server.paths

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives.{complete, get, pathEndOrSingleSlash}
import akka.http.scaladsl.server.Route

case object Base {
  def route: Route = pathEndOrSingleSlash {
    get {
      complete(HttpEntity(ContentTypes.`text/html(UTF-8)`,
        s"""
           |<h1>Welcome to practice REST API!</h1>
           |<div>
           |  <a href="/swagger">Click here to navigate to Swagger API!</a>
           |</div
         """.stripMargin))
    }
  }
}
