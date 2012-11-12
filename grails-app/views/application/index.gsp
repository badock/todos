<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
	</head>
	<body>
		<div id="views">
    		<div id="tasks">
				<h1>${todoList.name }</h1>
				<br>
				<g:form action="createTodo">
					<input type="hidden" name="todoList" value="${todoList.id }">					
					<input id="input_todo" name="label" type="text" placeholder="What needs to be done?">
				</g:form>		        	
				<br>
				
				<div class="items">
				<g:each var="todo" in="${todoList.todos.sort{a,b-> a.id.compareTo(b.id)}}">
				
					<div class="item ">
						<div class="view" title="Double click to edit...">
							<g:form action="updateTodo">
								<input type="hidden" name="id" value="${todo.id}">
								<input type="checkbox" ${ todo.done?"checked":""} onclick="$('#done_field').val(this.value);this.form.submit();">
								<input id="done_field" type="hidden" name="done" checked="${todo.done}">
								<input type="hidden" name="label" value="${todo.label}">
								
								<span>${todo.label}</span>
							
							<g:link action="deleteTodo" id="${todo.id }">delete</g:link>
							</g:form>
						</div>
					</div>
				</g:each>
				</div>
			</div>
		</div>
	</body>
</html>