package todoList.components

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@JSImport("resources/PageTemplate.scss", JSImport.Default)
@js.native
object PageTemplateCSS extends js.Object

@react class PageTemplate extends StatelessComponent {
  case class Props(children: ReactElement)

  val css = PageTemplateCSS

  def render() = {
    div(className := "page-template")(
      h1("일정관리"),
      div(className := "content")(props.children)
      )
  }
}
