import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { retrieveTodosApi, deleteTodoApi } from "./api/TodoApiService.js";
import { useAuth } from "./Security/AuthContext.js";

function ListTodosComponent() {
  const authContext = useAuth();

  const username = authContext.username;

  const [todos, setTodods] = useState([]);

  const [message, setMessage] = useState(null);

  const navigate = useNavigate();

  useEffect(() => refreshTodos(), []);

  function refreshTodos() {
    console.log(username);
    retrieveTodosApi(username)
      .then((response) => {
        setTodods(response.data);
      })
      .catch((error) => console.log(error))
      .finally(() => console.log("cleaning up"));
  }

  function deleteTodo(id) {
    deleteTodoApi(username, id)
      .then((response) => {
        setMessage(`Delete todo with Id:${id} successful`);
        refreshTodos();
      })
      .catch((error) => console.log(error))
      .finally(() => console.log(""));
  }

  function updateTodo(id) {
    navigate(`/todo/${id}`);
  }
  function addTodo() {
    navigate(`/todo/${-1}`);
  }
  return (
    <div className="container">
      <h1>Things you want to do</h1>
      {message && <div className="alert alert-warning">{message}</div>}

      <div>
        <table className="table">
          <thead>
            <tr>
              <th>Description</th>
              <th>Is Done?</th>
              <th>Target Date</th>
            </tr>
          </thead>
          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id}>
                <td>{todo.description}</td>
                <td>{todo.done.toString()}</td>
                {/*<td>{todo.targetDate.toDateString()}</td>*/}
                <td>{todo.targetDate.toString()}</td>
                <td>
                  <button
                    className="btn btn-warning"
                    onClick={() => deleteTodo(todo.id)}
                  >
                    Delete
                  </button>
                </td>
                <td>
                  <button
                    className="btn btn-success"
                    onClick={() => updateTodo(todo.id)}
                  >
                    Update
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <div>
        <button className="btn btn-success m-3" onClick={() => addTodo()}>
          Add Todo
        </button>
      </div>
    </div>
  );
}

export default ListTodosComponent;
