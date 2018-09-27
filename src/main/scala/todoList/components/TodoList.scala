package todoList.components

import slinky.core._
import slinky.core.annotations.react
import slinky.web.html._

// import todoList.components.TodoItem

@react class TodoList extends StatelessComponent {
  case class Props(todos: Map[Int, Tuple2[String, Boolean]],
                   onToggle: Int => Unit,
                   onRemove: Int => Unit)

  def render() = {
    div(
      props.todos.map {
        case (key, item) =>
          val done: Boolean = item._2
          val text: String  = item._1
          TodoItem(done,
                   text,
                   onToggle = (_) => props.onToggle(key),
                   onRemove = (_) => props.onRemove(key)).withKey(key.toString),
      }
    )
  }
}
