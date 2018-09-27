package todoList

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.React
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport}

import org.scalajs.dom.raw.{Event, HTMLInputElement}
import org.scalajs.dom

import todoList.components._

@react class App extends Component {
  type Props = Unit
  case class State(input: String, todos: Map[Int, Tuple2[String, Boolean]])

  def initialState =
    State("", Map(0 -> ("리액트 공부하기", true), 1 -> ("컴포넌트 스타일링 해보기", false)))

  def handleChange(e: Event) = {
    val eventValue =
      e.target.asInstanceOf[HTMLInputElement].value
    setState(_.copy(input = eventValue))
  }

  def handleInsert() = {
    setState(
      prevState =>
        State("",
              prevState.todos + (prevState.todos.size -> (state.input, false))))
  }

  def handleToggle(key: Int) = {
    val newTodos = state.todos.map {
      case (k, (v, done)) if (k == key) => (key, (v, !done))
      case x                            => x
    }
    setState(_.copy(todos = newTodos))
  }

  def handleRemove(key: Int): Unit = {
    val newTodos = state.todos - key
    setState(_.copy(todos = newTodos))
    state.todos.foreach{case (k, v) => dom.console.log(k)}
  }

  def render() = {
    PageTemplate(
      children = Seq(
        TodoInput(onChange = handleChange _,
                  onInsert = (_) => handleInsert(),
                  value = state.input),
        TodoList(state.todos, handleToggle, handleRemove)
      ))
  }
}
