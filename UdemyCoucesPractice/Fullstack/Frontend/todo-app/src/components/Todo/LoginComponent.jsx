import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./Security/AuthContext";
function LoginComponent() {
  const [username, setUsername] = useState("aslam");

  const [password, setPassword] = useState("");

  const [showErrorMessage, setErrorMessage] = useState(false);

  const navigate = useNavigate();

  const authContext = useAuth();

  function handleUsernameChange(event) {
    setUsername(event.target.value);
  }

  function handlePasswordChange(event) {
    setPassword(event.target.value);
  }

  function handleSubmit() {
    if (authContext.login(username, password)) {
      navigate(`/welcome/${username}`);
    } else {
      setErrorMessage(true);
    }
  }

  return (
    <div className="Login">
      <h1>Time to Login !</h1>
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

export default LoginComponent;
