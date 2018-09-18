package todoList.components

import slinky.core._
import slinky.core.annotations.react
import slinky.web.html._

import scala.scalajs.js
import org.scalajs.dom
import org.scalajs.dom.raw.{Event, KeyboardEvent}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@JSImport("resources/TodoInput.scss", JSImport.Default)
@js.native
object TodoInputCSS extends js.Object

@react class TodoInput extends StatelessComponent {
  case class Props(value: String,
                   onChange: js.Function1[Event, Unit],
                   onInsert: js.Function1[Event, Unit])

  val css = TodoInputCSS

  def render() = {
    div(className := "todo-input")(
      input(onChange := { props.onChange },
            value := { props.value },
            onKeyPress := { handleKeyPress _ }),
      div(className := "add-button", onClick := { props.onInsert })("추가")
    )
  }

  def handleKeyPress(e: Event): Unit = {
    if (e.asInstanceOf[KeyboardEvent].key == "Enter") props.onInsert
  }
}
