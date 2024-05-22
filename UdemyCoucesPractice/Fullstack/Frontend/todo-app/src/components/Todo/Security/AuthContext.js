import { createContext, useState, useContext } from "react";
//TODO
//1-create context
export const AuthContext = createContext();
export const useAuth = () => useContext(AuthContext);
// share the created context with other component

export default function AuthProvider({ children }) {
  // Put some state in that context

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

  function logout() {
    setAuthenticated(false);
  }

  return (
    <AuthContext.Provider value={{ isAuthenticated, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
}
