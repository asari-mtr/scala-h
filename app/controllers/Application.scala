package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  def index = Action { implicit request =>
    var list = List.empty[(String, Seq[String])]

    val headers = request.headers
    for (key <- headers.keys) {
      list = (key, headers.getAll(key)) :: list
    }

    Ok(views.html.index(list))
  }
}
