import { useParams, Link } from "react-router-dom";
import { useState } from "react";
import { retrieveHelloWorldPathVariable } from "./api/HelloWorldApiService";
import { useAuth } from "./Security/AuthContext";
/**Link use so that full page did not get refresh */
function WelcomeComponent() {
  const { username } = useParams();

  const [message, setMessage] = useState(null);

  const authContext = useAuth();

  const token = authContext.token;

  function callHelloWorldRestAPI() {
    retrieveHelloWorldPathVariable("Aslam", token)
      .then((response) => successfulResponse(response))
      .catch((error) => errorResponse(error))
      .finally(() => console.log("do cleanup"));
  }
  function successfulResponse(response) {
    setMessage(response.data.message);
  }

  function errorResponse(response) {
    console.log(response);
  }

  return (
    <div className="WelcomeComponent">
      <h1>Welcome {username}</h1>
      <div>
        Manage your todos- <Link to="/todos">Go here</Link>
      </div>
      <div>
        <button className="btn btn-success m-5" onClick={callHelloWorldRestAPI}>
          Call Hello World
        </button>
      </div>
      <div className="text-info">{message}</div>
    </div>
  );
}

export default WelcomeComponent;
