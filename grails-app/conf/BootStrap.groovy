import todos.TodoList;
import todos.Todo;

class BootStrap {

	def init = { servletContext ->
		environments {
			development {
				def liste
				def todo
				
				// a first todo list
				liste = new TodoList(name:"todos1")
				liste.todos = new ArrayList<Todo>();
				liste.save(flush: true)
				
				todo = new Todo(label:"Sortir Bobby", done:true, list:liste).save(flush: true)
				liste.todos.add(todo)
				todo = new Todo(label:"Terminer les todos", list:liste).save(flush: true)
				liste.todos.add(todo)
				liste.save(flush: true)
				
				// a second todo list
				liste = new TodoList(name:"todos2", list:liste).save(flush: true)
				liste.todos = new ArrayList<Todo>();
				liste.save(flush: true)
				
				todo = new Todo(label:"Sortir Bobby", list:liste).save(flush: true)
				liste.todos.add(todo)
				todo = new Todo(label:"Terminer les todos", list:liste).save(flush: true)
				liste.todos.add(todo)
				liste.save(flush: true)
			}
		}
	}
	def destroy = {
	}
}
