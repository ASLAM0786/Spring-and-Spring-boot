import { useState } from "react";
import {
  BrowserRouter,
  Routes,
  Route,
  useNavigate,
  useParams,
  Link,
} from "react-router-dom";
import "./todoApp.css";
export default function TodoApp() {
  return (
    <div className="TodoApp">
      <HeaderComponent />
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<LoginComponent />} />
          <Route path="/login" element={<LoginComponent />} />
          <Route path="/welcome/:username" element={<WelcomeComponent />} />
          <Route path="*" element={<ErrorComponent />} />
          <Route path="/todos" element={<ListTodoComponent />} />
          <Route path="/logout" element={<LogoutComponent />} />
        </Routes>
      </BrowserRouter>
      <FooterComponent />
    </div>
  );
}

function LoginComponent() {
  const [username, setUsername] = useState("aslam");

  const [password, setPassword] = useState("");

  const [showSuccessMessage, setSuccessMessage] = useState(false);

  const [showErrorMessage, setErrorMessage] = useState(false);

  const navigate = useNavigate();

  function handleUsernameChange(event) {
    setUsername(event.target.value);
  }

  function handlePasswordChange(event) {
    setPassword(event.target.value);
  }

  function handleSubmit() {
    console.log(username);
    console.log(password);

    if ((username === "aslam") & (password === "dummy")) {
      setSuccessMessage(true);
      setErrorMessage(false);
      console.log("Success");
      navigate(`/welcome/${username}`);
    } else {
      console.log("Failed");
      setErrorMessage(true);
      setSuccessMessage(false);
    }
  }

  return (
    <div className="Login">
      <h1>Time to Login !</h1>
      {showSuccessMessage && (
        <div className="successMessage">Authenticated Successfully</div>
      )}

      {showErrorMessage && (
        <div className="errorMessage">
          Authentication Failed. Please check your credential
        </div>
      )}
      <div className="LoginForm">
        <div>
          <label>User Name</label>
          <input
            type="text"
            name="username"
            value={username}
            onChange={handleUsernameChange}
          />
        </div>
        <div>
          <label>Password</label>
          <input
            type="password"
            name={password}
            onChange={handlePasswordChange}
          />
        </div>
        <div>
          <button type="button" name="login" onClick={handleSubmit}>
            Login
          </button>
        </div>
      </div>
    </div>
  );
}
/**Link use so that full page did not get refresh */
function WelcomeComponent() {
  const { username } = useParams();
  console.log(username);
  return (
    <div className="WelcomeComponent">
      <h1>Welcome {username}</h1>
      <div>
        Manage your todos- <Link to="/todos">Go here</Link>
      </div>
    </div>
  );
}

function ErrorComponent() {
  return (
    <div className="ErrorComponent">
      <h1>We are really working hard</h1>
      <div>
        Apology for 404: reach out to our team <mark>learnFromScratch</mark>
      </div>
    </div>
  );
}
function HeaderComponent() {
  return (
    <div className="header">
      Header
      <hr />
    </div>
  );
}
function FooterComponent() {
  return (
    <div className="footer">
      <hr />
      Footer
    </div>
  );
}

function LogoutComponent() {
  return (
    <div className="LogoutComponent">
      <h1>You are logged out !</h1>
      <div>Thank you for visiting our website. come back soon.</div>
    </div>
  );
}

function ListTodoComponent() {
  const today = new Date();
  const targetDate = new Date(
    today.getFullYear() + 12,
    today.getMonth(),
    today.getDay()
  );
  const todos = [
    { id: 1, description: "Learn AWS", done: false, targetDate: targetDate },
    { id: 2, description: "Learn Azure", done: false, targetDate: targetDate },
    { id: 3, description: "Learn Devops", done: false, targetDate: targetDate },
  ];
  return (
    <div className="ListTodoComponent">
      <h1>Things you want to do</h1>
      <div>
        <table>
          <thead>
            <tr>
              <td>Id</td>
              <td>Description</td>
              <td>Is Done?</td>
              <td>Target Date</td>
            </tr>
          </thead>
          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id}>
                <td>{todo.id}</td>
                <td>{todo.description}</td>
                <td>{todo.done.toString()}</td>
                <td>{todo.targetDate.toDateString()}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      {/*<div>Todo Details</div>*/}
    </div>
  );
}
