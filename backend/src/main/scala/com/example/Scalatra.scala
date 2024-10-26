package com.example

import org.scalatra._
import org.scalatra.json._
import org.json4s.{DefaultFormats, Formats}
import com.example.api.model._

class Scalatra extends ScalatraServlet 
  with JacksonJsonSupport 
  with ContentEncodingSupport  {
  override implicit val jsonFormats: Formats = DefaultFormats

  // GETリクエストを処理する
  get("/") {
    contentType = formats("json")
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

