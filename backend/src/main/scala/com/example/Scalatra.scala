package com.example

import org.scalatra._
import org.scalatra.json._
import org.json4s.jvalue2extractable
import org.json4s.{DefaultFormats, Formats}
import com.example.api.model._

class Scalatra extends ScalatraServlet 
  with JacksonJsonSupport 
  with ContentEncodingSupport
  {
  override implicit val jsonFormats: Formats = DefaultFormats

  private var users: Seq[User] = Seq(
    User(
      1, "foo", "foo@example.com"
    )
  )

  before() {
    contentType = formats("json")
    response.setHeader("Access-Control-Allow-Origin", "*")
    response.setHeader("Access-Control-Allow-Headers", "Content-Type")
  }

  get("/api/users") {
    users
  }

  // POSTリクエストを処理する
  post("/api/users") {
    val create = parsedBody.extract[CreateUser]
    val id = users.map(_.id).maxOption.getOrElse(0) + 1
    val u = User(id, create.name, create.email)
    users = users :+ u
    u
  }
}

