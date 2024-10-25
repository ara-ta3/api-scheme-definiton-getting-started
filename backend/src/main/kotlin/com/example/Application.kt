package com.example

import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable

@Serializable
data class PostData(val message: String)

fun main() {
    embeddedServer(Netty, port = 8080) {
        // ContentNegotiationにkotlinxのjsonを使用
        install(ContentNegotiation) {
            json()  // kotlinx.serialization の JSON サポート
        }

        routing {
            get("/hello") {
                call.respond(HttpStatusCode.OK, "Hello, Ktor with kotlinx-json!")
            }

            post("/post") {
                val data = call.receive<PostData>()
                call.respond(HttpStatusCode.OK, "Received: ${data.message}")
            }
        }
    }.start(wait = true)
}
