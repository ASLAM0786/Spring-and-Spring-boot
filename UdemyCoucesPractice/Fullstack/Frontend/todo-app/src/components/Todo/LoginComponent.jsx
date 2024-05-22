import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./Security/AuthContext";
function LoginComponent() {
  const [username, setUsername] = useState("aslam");

  const [password, setPassword] = useState("");

  const [showSuccessMessage, setSuccessMessage] = useState(false);

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
    console.log(username);
    console.log(password);

    if ((username === "aslam") & (password === "dummy")) {
      authContext.setAuthenticated(true);
      setSuccessMessage(true);
      setErrorMessage(false);
      console.log("Success");
      navigate(`/welcome/${username}`);
    } else {
      authContext.setAuthenticated(false);
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

export default LoginComponent;
