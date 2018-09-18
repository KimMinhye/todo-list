package todoList

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.React
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport}

import org.scalajs.dom.raw.{Event, KeyboardEvent}

import todoList.components._

@react class App extends StatelessComponent {
  type Props = Unit

  def render() = {
    PageTemplate(TodoInput("", ((_: Event) => println("onChange")), ((_: Event) => println("onInsert"))))
  }
}
