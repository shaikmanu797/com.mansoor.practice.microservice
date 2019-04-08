package com.mansoor.practice.microservice.server

import com.github.swagger.akka.SwaggerHttpService
import com.github.swagger.akka.model.Info
import com.mansoor.practice.microservice.server.paths.Base
import com.mansoor.practice.microservice.{hostname, port}

case object SwaggerService extends SwaggerHttpService {

  override def apiClasses: Set[Class[_]] = Set(
    Base.getClass
  )

  override val host = s"$hostname:$port"

  override val basePath = "/"

  override def schemes: List[String] = List("http")

  override def apiDocsPath: String = "api-docs"

  override val unwantedDefinitions: Seq[String] = Seq("Function1", "Function1RequestContextFutureRouteResult")

  override def info: Info =
    Info(
      description = "Swagger Akka HTTP Demo Application...",
      version = "1.0",
      title = "Practice Swagger API",
      termsOfService = "",
      contact = None,
      license = None,
      vendorExtensions = Map.empty
    )
}