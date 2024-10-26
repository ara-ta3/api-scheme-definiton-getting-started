package com.example

import org.scalatra._
import org.scalatra.json._
import org.json4s.{DefaultFormats, Formats}
import com.example.api.model._

class Scalatra extends ScalatraServlet 
  with JacksonJsonSupport 
  with ContentEncodingSupport
  {
  override implicit val jsonFormats: Formats = DefaultFormats

  get("/api/users") {
    response.setHeader("Access-Control-Allow-Origin", "*")
    response.setHeader("Access-Control-Allow-Headers", "Content-Type")
    contentType = formats("json")
    Seq(
      User(
        1, "foo", "foo@example.com"
      )
    )
  }

  // POSTリクエストを処理する
  post("/api/users") {
    val name = params.getOrElse("name", "Anonymous")
    s"Hello, $name!"
  }
}

