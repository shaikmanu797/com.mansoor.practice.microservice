package com.mansoor.practice.microservice.server

import akka.http.scaladsl.server.Route
import com.mansoor.practice.microservice.server.paths.Base

object Api {
  def routes: Route = {
    Base.route
  }
}
