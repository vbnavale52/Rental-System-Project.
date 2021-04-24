import "./App.css";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import LoginPage from "./Common/LoginPage"
import UserProfile from "./CustomerScreen/UserProfile"
import ViewProfile from "./CustomerScreen/ViewProfile"
import UserRegister from "./CustomerScreen/UserRegistration"
import FileUpload from "./CustomerScreen/FileUpload"
function App() {
  return (
    <div className="App">
      <Router>
        <div >
          <Switch>
            <Route path="/register_new" exact component={UserRegister} />
            <Route path="/sign_in" exact component={LoginPage} />
            <Route path="/user_profile" component={UserProfile} />
            <Route path="/view_profile" component={ViewProfile} />
            <Route path="/upload_file" component={FileUpload} />
          </Switch>
        </div>
      </Router>

    </div>
  );
}

export default App;
