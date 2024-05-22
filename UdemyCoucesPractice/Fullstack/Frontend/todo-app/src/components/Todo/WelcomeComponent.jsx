import { useParams, Link } from "react-router-dom";
/**Link use so that full page did not get refresh */
function WelcomeComponent() {
  const { username } = useParams();

  return (
    <div className="WelcomeComponent">
      <h1>Welcome {username}</h1>
      <div>
        Manage your todos- <Link to="/todos">Go here</Link>
      </div>
    </div>
  );
}

export default WelcomeComponent;
