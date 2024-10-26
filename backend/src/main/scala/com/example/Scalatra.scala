package com.example

import org.scalatra._
import org.scalatra.json._
import org.json4s.{DefaultFormats, Formats}
import org.openapitools.server.model.*

class Scalatra extends ScalatraServlet with JacksonJsonSupport  {
  implicit val formats: Formats = Serialization.formats(NoTypeHints)

  // GETリクエストを処理する
  get("/") {
    User(
      1, "foo", "foo@example.com"
    )
  }

  // POSTリクエストを処理する
  post("/submit") {
    val name = params.getOrElse("name", "Anonymous")
    s"Hello, $name!"
  }
}

