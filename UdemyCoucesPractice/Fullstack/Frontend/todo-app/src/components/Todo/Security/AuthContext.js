import { createContext, useState, useContext } from "react";
//TODO
//1-craete conext
export const AuthContext = createContext();
export const useAuth = () => useContext(AuthContext);
// share the created context with other component

export default function AuthProvider({ children }) {
  // Put some state in that context
  const [number, setNumber] = useState(10);

  const [isAuthenticated, setAuthenticated] = useState(false);

  //setInterval(() => setNumber(number + 1), 10000);

  function login(username, password) {
    if ((username === "aslam") & (password === "dummy")) {
      setAuthenticated(true);
      return true;
    }
    setAuthenticated(false);
    return false;
  }

  //const valuedToBeShared = { number, isAuthenticated, setAuthenticated };
  return (
    <AuthContext.Provider
      value={{ number, isAuthenticated, setAuthenticated, login }}
    >
      {children}
    </AuthContext.Provider>
  );
}
