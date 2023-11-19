import "./App.css";
import logo from "./oneTile.png";
import LoginPage from "./Pages/Login/login.js";

function App() {
  return (
    <div className="App">
      <div className="loginPage">
        <LoginPage />
      </div>
      <div className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
      </div>
    </div>
  );
}

export default App;
