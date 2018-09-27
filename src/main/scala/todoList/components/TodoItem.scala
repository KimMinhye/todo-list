package todoList.components

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import org.scalajs.dom.raw.Event
import org.scalajs.dom

@JSImport("resources/TodoItem.scss", JSImport.Default)
@js.native
object TodoItemCSS extends js.Object

@react class TodoItem extends StatelessComponent {
  case class Props(done: Boolean,
                   children: ReactElement,
                   onToggle: js.Function1[Event, Unit],
                   onRemove: js.Function1[Event, Unit])

  val css = TodoItemCSS

  def render() = {
    div(className := "todo-item", onClick := { props.onToggle })(
      input(className := "tick",
            `type` := "checkbox",
            checked := { props.done },
            readOnly),
      div(className := s"text ${props.done}")(props.children),
      div(
        className := "delete",
        onClick := { (e: Event) =>
          {
            dom.console.log("start")
            props.onRemove
            e.stopPropagation()
            dom.console.log("end")
          }
        }
      )("[지우기]")
    )
  }
}
