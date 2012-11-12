package todos

class ApplicationController {
	
    def index() {
		
		def truc = TodoList.findByName(params.id)
		
		if(truc == null) {
			truc = new TodoList()
			truc.name = params.id
			truc.todos = new ArrayList<Todo>()
			
			truc.save(flush:true)
		}
		
		render(view: "index", model: [todoList:truc])	
	}
	
	def createTodo() {
		def truc = TodoList.get(params.todoList)
		def todo = new Todo(label: params.label, list:truc).save(flush:true)
		
		redirect(action: "index", params: [id: todo.list.name])
	}
	
	def updateTodo() {
		def truc2 = params.done
		
		def todo = Todo.get(params.id)
		
		todo.label= params.label
		todo.done = !todo.done
		
		todo.save(flush:true)
		redirect(action: "index", params: [id: todo.list.name])
	}
	
	
	def deleteTodo() {
		def todo = Todo.findById(params.id)
		todo.list.todos.remove(todo)
		todo.list.save(flush:true)
		
		if(todo!=null) {
			todo.delete(flush:true)
		}
		
		redirect(action: "index", params: [id: todo.list.name])
	}
}
