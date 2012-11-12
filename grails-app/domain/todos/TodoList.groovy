package todos

class TodoList {

	static hasMany = [todos: Todo]
	
	String name
	
    static constraints = {
    }
}
