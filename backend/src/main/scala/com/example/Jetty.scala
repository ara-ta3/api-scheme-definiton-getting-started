package com.example

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.ee10.servlet.{ServletContextHandler, ServletHolder}
import org.scalatra.LifeCycle

object JettyLauncher {
  def main(args: Array[String]): Unit = {
    val port = 8080
    val server = new Server(port)

    val context = new ServletContextHandler(ServletContextHandler.SESSIONS)
    context.setContextPath("/")
    server.setHandler(context)
    val servletHolder = new ServletHolder(new Scalatra())
    context.addServlet(servletHolder, "/*")
    sys.addShutdownHook {
      println("Shutting down Jetty server...")
      server.stop()
      server.destroy()
      println("Jetty server stopped.")
    }
    server.start()
    server.join()
  }
}
