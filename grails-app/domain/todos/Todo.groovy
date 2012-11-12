package todos

class Todo {

	String label
	Boolean done = false
	
	static belongsTo = [list:TodoList]
	
    static constraints = {
    }
}
