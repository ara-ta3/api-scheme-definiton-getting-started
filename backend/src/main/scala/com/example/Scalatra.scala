package com.example

import org.scalatra._

class Scalatra extends ScalatraServlet {

  // GETリクエストを処理する
  get("/") {
    "Hello, Scalatra Jakarta!"
  }

  // POSTリクエストを処理する
  post("/submit") {
    val name = params.getOrElse("name", "Anonymous")
    s"Hello, $name!"
  }
}

