package com.mansoor.practice.microservice.server.paths

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.{Directives, Route}
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import javax.ws.rs.{GET, Path}

@Path("/")
case object Base extends Directives {
  @GET
  @Operation(
    summary = "Base route",
    description = "Returns the homepage content",
    responses = Array(
      new ApiResponse(responseCode = "200", description = "Welcome to practice REST API!"),
      new ApiResponse(responseCode = "500", description = "Internal Server Error")
    ),
      tags = Array("Base")
  )
  def route: Route = pathSingleSlash {
    get {
      complete(HttpEntity(ContentTypes.`text/html(UTF-8)`,
        s"""
           |<h1>Welcome to practice REST API!</h1>
           |<div>
           |  <a href="/swagger">Click here to navigate to Swagger API!</a>
           |</div
         """.stripMargin)
      )
    }
  }
}
