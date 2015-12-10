package com.example

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.marshallers.sprayjson
import akka.stream.scaladsl.Flow
import akka.stream.ActorMaterializer
import com.example.PersonJsonSupport._
import spray.json._

object Main extends App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher

  val route:Route = {
    
    
      post {
          // unmarshal with in-scope unmarshaller
          entity(as[Person]) { person =>
            complete {
             person
            }
          }
      }
  }

  val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

  println(s"Server online at http://localhost:8080/")

}