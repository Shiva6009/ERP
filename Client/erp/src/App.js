import logo from "./logo.svg";
import "./App.css";
import LoginPage from "./components/loginpage/LoginPage";
import { loginRequest } from "./api/apirequest";
import WrapperDashboard from "./components/dashboard/WrapperDashboard";

function App() {
  // localStorage.clear()
  return (
    //<WrapperDashboard />
    <LoginPage />
  );
}

export default App;
